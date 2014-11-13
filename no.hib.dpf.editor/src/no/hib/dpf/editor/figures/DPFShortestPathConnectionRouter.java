/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *     �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.figures;

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
 * This implementation is mostly a copy of ShortestPathConnectionRouter just to get around
 * the fact that ShortestPathConnectionRouter is declared final.
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

	private ShortestPathRouter algorithm = new ShortestPathRouter();
	private Map<Connection, Path> connectionToPaths;
	private Map constraintMap = new HashMap();
	private IFigure container;
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
	private Map figuresToBounds;
	private boolean ignoreInvalidate;

	private boolean isDirty;
	private LayoutListener listener = new LayoutTracker();

	private Set staleConnections = new HashSet();

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
	 * @return the container which contains connections routed by this router
	 * @since 3.5
	 */
	public IFigure getContainer() {
		return container;
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
	 * @return true if there are connections routed by this router, false
	 *         otherwise
	 * @since 3.5
	 */
	public boolean hasMoreConnections() {
		return connectionToPaths != null && !connectionToPaths.isEmpty();
	}

	private void hookAll() {
		figuresToBounds = new HashMap();
		for (int i = 0; i < container.getChildren().size(); i++)
			addChild((IFigure) container.getChildren().get(i));
		container.addLayoutListener(listener);
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

	private void processLayout() {
		if (staleConnections.isEmpty())
			return;
		((Connection) staleConnections.iterator().next()).revalidate();
	}


	// Revised for DPF:
	// Connections are laid out before constraints
	private List<Connection> constraints = new ArrayList<Connection>();
	private void processStaleConnections() {
		Iterator iter = staleConnections.iterator();
		if (iter.hasNext() && connectionToPaths == null) {
			connectionToPaths = new HashMap<Connection, Path>();
			hookAll();
		}
		while (iter.hasNext()) {
			Connection conn = (Connection) iter.next();
			if(conn instanceof ArrowConnection)
				processStaleConnections(conn);
			else
				constraints.add(conn);
		}
	}

	private void processStaleConstraints() {
		for(Connection conn : constraints){
			processStaleConstraints(conn);
		}
	}
	private void processStaleConstraints(Connection conn){
		if(conn.getSourceAnchor() == null || conn.getTargetAnchor() == null) return;
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

		container.translateToRelative(start);
		container.translateToRelative(end);

		path.setStartPoint(start);
		path.setEndPoint(end);

		isDirty |= path.isDirty;
	}
	private void processStaleConnections(Connection conn) {
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

		container.translateToRelative(start);
		container.translateToRelative(end);

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

	private void update(List updated){
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
			current.translateToRelative(start);
			current.translateToRelative(end);
			points.setPoint(start, 0);
			points.setPoint(end, points.size() - 1);
			current.setPoints(points);
		}
	}
	/**
	 * router connection firstly and then router related constraint connection.
	 * Because constraint connection is dependent on connection.
	 */
	public void route(Connection conn) {
		if (isDirty) {
			ignoreInvalidate = true;
			processStaleConnections();
			update(algorithm.solve());
			processStaleConstraints();
			update(algorithm.solve());
			staleConnections.clear();
			isDirty = false;
			ignoreInvalidate = false;
		}
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

	// -----------------------------------------------------------------------
	
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
	
	
}
