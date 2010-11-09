package no.hib.dpf.editor.figures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class ConnectionConstraintAnchor implements ConnectionAnchor {

	private static final int maxDistanceToConnectionPoint = 75;

	@SuppressWarnings("rawtypes")
	protected List listeners = new ArrayList(1);
	private PolylineConnection connectionFigure;

	private boolean useTargetEnd;

	/**
	 * Constructs a ConnectionConstraintAnchor at the Point p.
	 * 
	 * @param p
	 *            the point where this anchor will be located (unused)
	 * @param useTargetEnd
	 *            instructs the anchor to anchor from the target end of the
	 *            connection.
	 * 
	 * @since 2.0
	 */
	public ConnectionConstraintAnchor(Point p, boolean useTargetEnd) {
		this.useTargetEnd = useTargetEnd;
	}

	/**
	 * Adds a listener interested in the movement of this ConnectionAnchor.
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#addAnchorListener(AnchorListener)
	 */
	@SuppressWarnings("unchecked")
	public void addAnchorListener(AnchorListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the listener.
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#removeAnchorListener(AnchorListener)
	 */
	public void removeAnchorListener(AnchorListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Notifies all the listeners in the list of a change in position of this
	 * anchor. This is called from one of the implementing anchors when its
	 * location is changed.
	 * 
	 * @since 2.0
	 */
	@SuppressWarnings("rawtypes")
	protected void fireAnchorMoved() {
		Iterator iter = listeners.iterator();
		while (iter.hasNext())
			((AnchorListener) iter.next()).anchorMoved(this);
	}

	/**
	 * Returns the location of this anchor. The reference point is ignored in
	 * this implementation.
	 * 
	 * @see ConnectionAnchor#getLocation(Point)
	 */
	public Point getLocation(Point reference) {
		System.out.println("returns point: " + getLinePoint());
		return getLinePoint();
	}

	/**
	 * Returns the connection figure.
	 */
	public IFigure getOwner() {
		return this.connectionFigure;
	}

	/**
	 * Returns the point which is used as the reference by this connection
	 * anchor.
	 * 
	 * @see ConnectionAnchor#getReferencePoint()
	 */
	public Point getReferencePoint() {
		System.out.println("returns reference point: " + getLinePoint());
		return getLinePoint();
//		Point ref = getLinePoint();
//		getOwner().translateToAbsolute(ref);
//		return ref;		
	}

	private Point getLinePoint() {
		if (this.connectionFigure != null) {
			if (useTargetEnd == false) {
				// connectionFigure.getSourceAnchor()
				return calculateConnectionPointFromSource(connectionFigure
						.getPoints());
			} else {
				return calculateConnectionPointFromTarget(connectionFigure
						.getPoints());
			}
		}
		throw new RuntimeException(
				"ConnectionConstraintAnchor: No connectionFigure set.");
	}

	public void setConnectionFigure(PolylineConnection connectionFigure) {
		this.connectionFigure = connectionFigure;
	}

	public PolylineConnection getConnectionFigure() {
		return connectionFigure;
	}

	private Point getEndPoint(PointList points, boolean fromFirstPoint) {
		if (fromFirstPoint) {
			return points.getFirstPoint();
		}
		return points.getLastPoint();
	}

	private Point getSecondPointFromEnd(PointList points, boolean fromFirstPoint) {
		if (points.size() < 2) {
			return getEndPoint(points, fromFirstPoint);
		}
		if (fromFirstPoint) {
			return points.getPoint(1);
		}
		return points.getPoint(points.size() - 2);
	}

	private Point calculateConnectionPointFromSource(PointList points) {
		return calculateConnectionPoint(points, true);
	}

	private Point calculateConnectionPointFromTarget(PointList points) {
		return calculateConnectionPoint(points, false);
	}

	private Point calculateConnectionPoint(PointList points,
			boolean fromFirstPoint) {
//		System.out.println("Calculates connection points");
		Point endPoint = getEndPoint(points, fromFirstPoint);
		if (points.size() < 2) {
//			System.out.println("Return encdPoint");
			return endPoint;
		}

		Point secondPoint = getSecondPointFromEnd(points, fromFirstPoint);

		double distanceBetweenFirstPoints = endPoint.getDistance(secondPoint);
		if (distanceBetweenFirstPoints < 0.01) {
//			System.out.println("Return encdPoint (d9stance)");
			return endPoint;
		}

		double distanceToConnectionPoint = findDistanceToConnectionPoint(distanceBetweenFirstPoints);
//		System.out.println("distanceToConnectionPoint: " + distanceToConnectionPoint);

		return calculateConnectionPoint(endPoint, secondPoint, distanceBetweenFirstPoints, distanceToConnectionPoint);
	}

	private double findDistanceToConnectionPoint(
			double distanceBetweenFirstPoints) {
		double distanceToConnectionPoint = distanceBetweenFirstPoints / 2;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		return distanceToConnectionPoint;
	}

	private Point calculateConnectionPoint(Point endPoint, Point secondPoint,
			double distanceBetweenFirstPoints, double distanceToConnectionPoint) {
		int deltaX = secondPoint.x - endPoint.x;
		int deltaY = secondPoint.y - endPoint.y;

		double factor = distanceToConnectionPoint / distanceBetweenFirstPoints;
		deltaX = (int) (deltaX * factor);
		deltaY = (int) (deltaY * factor);
//		System.out.println("secondPoint.y: " + secondPoint.y);
//		System.out.println("   endPoint.y: " + endPoint.y);
//		System.out.println("       factor: " + factor);
//		System.out.println("       deltaY: " + deltaY);
//
//		System.out.println("   calculated: " + (endPoint.y + deltaY));

		return new Point(endPoint.x + deltaX, endPoint.y + deltaY);
	}

//	@Override
//	public void ancestorAdded(IFigure ancestor) {
//		int stopp = 23;
//		stopp = 2;
//	}
//
//	@Override
//	public void ancestorMoved(IFigure ancestor) {
//		int stopp = 23;
//		stopp = 3;
////		fireAnchorMoved();
//	}
//
//	@Override
//	public void ancestorRemoved(IFigure ancestor) {
//		int stopp = 23;
//		stopp = 4;
//	}

}
