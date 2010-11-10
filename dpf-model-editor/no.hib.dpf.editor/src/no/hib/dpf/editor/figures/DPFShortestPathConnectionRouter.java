package no.hib.dpf.editor.figures;

/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.Path;
import org.eclipse.draw2d.graph.ShortestPathRouter;

/**
 * Routes multiple connections around the children of a given container figure.
 * This implementation is a copy of ShortestPathConnectionRouter just to get around
 * the stupid fact that translateToRelative() is a final method in Figure, and
 * that ShortestPathConnectionRouter is final.
 * 
 * The object of this exercise is to avoid calling translateToRelative() on
 * BetweenArrowsConstraintFigure.
 * 
 * @author Whitney Sorenson
 * @author Randy Hudson
 * @since 3.1
 */
@SuppressWarnings("rawtypes")
public final class DPFShortestPathConnectionRouter extends AbstractRouter {

	private class LayoutTracker extends LayoutListener.Stub {
		public void postLayout(IFigure container) {
			processLayout();
		}

		public void remove(IFigure child) {
			removeChild(child);
		}

		public void setConstraint(IFigure child, Object constraint) {
			addChild(child);
		}
	}

	private Map constraintMap = new HashMap();
	private Map figuresToBounds;
	private Map connectionToPaths;
	private boolean isDirty;
	private ShortestPathRouter algorithm = new ShortestPathRouter();
	private IFigure container;
	private Set staleConnections = new HashSet();
	private LayoutListener listener = new LayoutTracker();

	private FigureListener figureListener = new FigureListener() {
		@SuppressWarnings("unchecked")
		public void figureMoved(IFigure source) {
			Rectangle newBounds = source.getBounds().getCopy();
			if (algorithm.updateObstacle(
					(Rectangle) figuresToBounds.get(source), newBounds)) {
				queueSomeRouting();
				isDirty = true;
			}

			figuresToBounds.put(source, newBounds);
		}
	};
	private boolean ignoreInvalidate;

	/**
	 * Creates a new shortest path router with the given container. The
	 * container contains all the figure's which will be treated as obstacles
	 * for the connections to avoid. Any time a child of the container moves,
	 * one or more connections will be revalidated to process the new obstacle
	 * locations. The connections being routed must not be contained within the
	 * container.
	 * 
	 * @param container
	 *            the container
	 */
	public DPFShortestPathConnectionRouter(IFigure container) {
		isDirty = false;
		algorithm = new ShortestPathRouter();
		this.container = container;
	}

	@SuppressWarnings("unchecked")
	void addChild(IFigure child) {
		if (connectionToPaths == null)
			return;
		if (figuresToBounds.containsKey(child))
			return;
		Rectangle bounds = child.getBounds().getCopy();
		algorithm.addObstacle(bounds);
		figuresToBounds.put(child, bounds);
		child.addFigureListener(figureListener);
		isDirty = true;
	}

	private void hookAll() {
		figuresToBounds = new HashMap();
		for (int i = 0; i < container.getChildren().size(); i++)
			addChild((IFigure) container.getChildren().get(i));
		container.addLayoutListener(listener);
	}

	private void unhookAll() {
		container.removeLayoutListener(listener);
		if (figuresToBounds != null) {
			Iterator figureItr = figuresToBounds.keySet().iterator();
			while (figureItr.hasNext()) {
				// Must use iterator's remove to avoid concurrent modification
				IFigure child = (IFigure) figureItr.next();
				figureItr.remove();
				removeChild(child);
			}
			figuresToBounds = null;
		}
	}

	/**
	 * Gets the constraint for the given {@link Connection}. The constraint is
	 * the paths list of bend points for this connection.
	 * 
	 * @param connection
	 *            The connection whose constraint we are retrieving
	 * @return The constraint
	 */
	public Object getConstraint(Connection connection) {
		return constraintMap.get(connection);
	}

	/**
	 * Returns the default spacing maintained on either side of a connection.
	 * The default value is 4.
	 * 
	 * @return the connection spacing
	 * @since 3.2
	 */
	public int getSpacing() {
		return algorithm.getSpacing();
	}

	/**
	 * @see ConnectionRouter#invalidate(Connection)
	 */
	@SuppressWarnings("unchecked")
	public void invalidate(Connection connection) {
		if (ignoreInvalidate)
			return;
		staleConnections.add(connection);
		isDirty = true;
	}

	private void processLayout() {
		if (staleConnections.isEmpty())
			return;
		((Connection) staleConnections.iterator().next()).revalidate();
	}

	// Revised for DPF:
	// Connections are laid out before constraints
	private void processStaleConnections() {
		Iterator iter = staleConnections.iterator();
		if (iter.hasNext() && connectionToPaths == null) {
			connectionToPaths = new HashMap();
			hookAll();
		}

		
		List<Connection> nodeConnections = new ArrayList<Connection>();
		List<Connection> constraintConnections = new ArrayList<Connection>();
		while (iter.hasNext()) {
			Connection conn = (Connection) iter.next();
			if (conn instanceof BetweenArrowsConstraintFigure) {
				constraintConnections.add(conn);
			} else {
				nodeConnections.add(conn);
			}
		}
		for (Connection conn : nodeConnections) {
			processStaleConnection(conn, false);
		}
		for (Connection conn : constraintConnections) {
			processStaleConnection(conn, true);
		}
		
		
		staleConnections.clear();
	}

	@SuppressWarnings("unchecked")
	private void processStaleConnection(Connection conn, boolean isConstraintFigure) {

		Path path = (Path) connectionToPaths.get(conn);
		if (path == null) {
			path = new Path(conn);
			connectionToPaths.put(conn, path);
			algorithm.addPath(path);
		}

		List constraint = (List) getConstraint(conn);
		if (constraint == null)
			constraint = Collections.EMPTY_LIST;

		Point start = conn.getSourceAnchor().getReferencePoint().getCopy();
		Point end = conn.getTargetAnchor().getReferencePoint().getCopy();

		// --------------------------------------------------------------
		// CHANGE FROM ORIGINAL:
		// --------------------------------------------------------------			
		if (!isConstraintFigure) {
			// --------------------------------------------------------------
			container.translateToRelative(start);
			container.translateToRelative(end);
			
		}
		// --------------------------------------------------------------

		path.setStartPoint(start);
		path.setEndPoint(end);

		if (!constraint.isEmpty()) {
			PointList bends = new PointList(constraint.size());
			for (int i = 0; i < constraint.size(); i++) {
				Bendpoint bp = (Bendpoint) constraint.get(i);
				bends.addPoint(bp.getLocation());
			}
			path.setBendPoints(bends);
		} else
			path.setBendPoints(null);

		isDirty |= path.isDirty;
	}

	void queueSomeRouting() {
		if (connectionToPaths == null || connectionToPaths.isEmpty())
			return;
		try {
			ignoreInvalidate = true;
			((Connection) connectionToPaths.keySet().iterator().next())
					.revalidate();
		} finally {
			ignoreInvalidate = false;
		}
	}

	/**
	 * @see ConnectionRouter#remove(Connection)
	 */
	public void remove(Connection connection) {
		staleConnections.remove(connection);
		constraintMap.remove(connection);
		if (connectionToPaths == null)
			return;
		Path path = (Path) connectionToPaths.remove(connection);
		algorithm.removePath(path);
		isDirty = true;
		if (connectionToPaths.isEmpty()) {
			unhookAll();
			connectionToPaths = null;
		} else {
			// Make sure one of the remaining is revalidated so that we can
			// re-route again.
			queueSomeRouting();
		}
	}

	void removeChild(IFigure child) {
		if (connectionToPaths == null)
			return;
		Rectangle bounds = child.getBounds().getCopy();
		boolean change = algorithm.removeObstacle(bounds);
		figuresToBounds.remove(child);
		child.removeFigureListener(figureListener);
		if (change) {
			isDirty = true;
			queueSomeRouting();
		}
	}

	/**
	 * @see ConnectionRouter#route(Connection)
	 */
	public void route(Connection conn) {
		if (isDirty) {
			ignoreInvalidate = true;
			processStaleConnections();
			isDirty = false;
			List updated = algorithm.solve();
			Connection current;
			for (int i = 0; i < updated.size(); i++) {
 				Path path = (Path) updated.get(i);
				

				current = (Connection) path.data;
				current.revalidate();

				PointList points = path.getPoints().getCopy();
				Point ref1, ref2, start, end;
				ref1 = new PrecisionPoint(points.getPoint(1));
				ref2 = new PrecisionPoint(points.getPoint(points.size() - 2));
				current.translateToAbsolute(ref1);
				current.translateToAbsolute(ref2);
				start = current.getSourceAnchor().getLocation(ref1).getCopy();
				end = current.getTargetAnchor().getLocation(ref2).getCopy();
				// --------------------------------------------------------------
				// CHANGE FROM ORIGINAL:
				// --------------------------------------------------------------			
				if (!(current instanceof BetweenArrowsConstraintFigure)) {
					// --------------------------------------------------------------

					current.translateToRelative(start);
					current.translateToRelative(end);
				}
				// --------------------------------------------------------------
				points.setPoint(start, 0);
				points.setPoint(end, points.size() - 1);
				
				
				current.setPoints(points);

			}
			ignoreInvalidate = false;
		}
	}

	/**
	 * @return All connection paths after routing dirty paths. Some of the paths
	 *         that were not dirty may change as well, as a consequence of new
	 *         routings.
	 * @since 3.5
	 */
	public List getPathsAfterRouting() {
		if (isDirty) {
			processStaleConnections();
			isDirty = false;
			List all = algorithm.solve();
			return all;

		}
		return null;
	}

	/**
	 * @see ConnectionRouter#setConstraint(Connection, Object)
	 */
	@SuppressWarnings("unchecked")
	public void setConstraint(Connection connection, Object constraint) {
		// Connection.setConstraint() already calls revalidate, so we know that
		// a
		// route() call will follow.
		staleConnections.add(connection);
		constraintMap.put(connection, constraint);
		isDirty = true;
	}

	/**
	 * Sets the default space that should be maintained on either side of a
	 * connection. This causes the connections to be separated from each other
	 * and from the obstacles. The default value is 4.
	 * 
	 * @param spacing
	 *            the connection spacing
	 * @since 3.2
	 */
	public void setSpacing(int spacing) {
		algorithm.setSpacing(spacing);
	}

	/**
	 * @return true if there are connections routed by this router, false
	 *         otherwise
	 * @since 3.5
	 */
	public boolean hasMoreConnections() {
		return connectionToPaths != null && !connectionToPaths.isEmpty();
	}

	/**
	 * @return the container which contains connections routed by this router
	 * @since 3.5
	 */
	public IFigure getContainer() {
		return container;
	}

	/**
	 * Sets the value indicating if connection invalidation should be ignored.
	 * 
	 * @param b
	 *            true if invalidation should be skipped, false otherwise
	 * @since 3.5
	 */
	public void setIgnoreInvalidate(boolean b) {
		ignoreInvalidate = b;
	}

	/**
	 * Returns the value indicating if connection invalidation should be
	 * ignored.
	 * 
	 * @return true if invalidation should be skipped, false otherwise
	 * @since 3.5
	 */
	public boolean shouldIgnoreInvalidate() {
		return ignoreInvalidate;
	}

	/**
	 * Returns the value indicating if the router is dirty, i.e. if there are
	 * any outstanding connections that need to be routed
	 * 
	 * @return true if there are connections to be routed, false otherwise
	 * @since 3.5
	 */
	public boolean isDirty() {
		return isDirty;
	}

	/**
	 * Returns true if the given connection is routed by this router, false
	 * otherwise
	 * 
	 * @param conn
	 *            Connection whose router is questioned
	 * @return true if this is the router used for conn
	 * @since 3.5
	 */
	public boolean containsConnection(Connection conn) {
		return connectionToPaths != null && connectionToPaths.containsKey(conn);
	}

}