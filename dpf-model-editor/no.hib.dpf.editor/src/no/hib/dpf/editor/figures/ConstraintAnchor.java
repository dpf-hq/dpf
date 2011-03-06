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

public class ConstraintAnchor implements ConnectionAnchor {

	private static final int maxDistanceToConnectionPoint = 75;

	@SuppressWarnings("rawtypes")
	protected List listeners = new ArrayList(1);
	protected PolylineConnection connectionFigure;
	protected boolean useTargetEnd;

	/**
	 * Constructs a ConnectionConstraintAnchor at the Point p.
	 * 
	 * @param useTargetEnd
	 *            instructs the anchor to anchor from the target end of the
	 *            connection.
	 * 
	 * @since 2.0
	 */
	public ConstraintAnchor(boolean useTargetEnd) {
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
	}

	protected Point getLinePoint() {
		if (useTargetEnd == false) {
			return calculateConnectionPointFromSource(connectionFigure.getPoints());
		} else {
			return calculateConnectionPointFromTarget(connectionFigure.getPoints());
		}
	}

	public void setConnectionFigure(PolylineConnection connectionFigure) {
		this.connectionFigure = connectionFigure;
	}

	public PolylineConnection getConnectionFigure() {
		return connectionFigure;
	}

	protected Point getEndPoint(PointList points, boolean fromFirstPoint) {
		if (fromFirstPoint) {
			return points.getFirstPoint();
		}
		return points.getLastPoint();
	}

	protected Point getSecondPointFromEnd(PointList points, boolean fromFirstPoint) {
		if (points.size() < 2) {
			return getEndPoint(points, fromFirstPoint);
		}
		if (fromFirstPoint) {
			return points.getPoint(1);
		}
		return points.getPoint(points.size() - 2);
	}

	protected Point calculateConnectionPointFromSource(PointList points) {
		return calculateConnectionPoint(points, true);
	}

	protected Point calculateConnectionPointFromTarget(PointList points) {
		return calculateConnectionPoint(points, false);
	}

	protected Point calculateConnectionPoint(PointList points,
			boolean fromFirstPoint) {
		Point endPoint = getEndPoint(points, fromFirstPoint);
		if (points.size() < 2) {
			return endPoint;
		}

		Point secondPoint = getSecondPointFromEnd(points, fromFirstPoint);

		double distanceBetweenFirstPoints = endPoint.getDistance(secondPoint);
		if (distanceBetweenFirstPoints < 0.01) {
			return endPoint;
		}

		double distanceToConnectionPoint = findDistanceToConnectionPoint(distanceBetweenFirstPoints);

		return calculateConnectionPoint(endPoint, secondPoint, distanceBetweenFirstPoints, distanceToConnectionPoint);
	}

	protected double findDistanceToConnectionPoint(
			double distanceBetweenFirstPoints) {
		double distanceToConnectionPoint = distanceBetweenFirstPoints / 2;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		return distanceToConnectionPoint;
	}

	protected Point calculateConnectionPoint(Point endPoint, Point secondPoint,
			double distanceBetweenFirstPoints, double distanceToConnectionPoint) {
		int deltaX = secondPoint.x - endPoint.x;
		int deltaY = secondPoint.y - endPoint.y;

		double factor = distanceToConnectionPoint / distanceBetweenFirstPoints;
		deltaX = (int) (deltaX * factor);
		deltaY = (int) (deltaY * factor);
		return new Point(endPoint.x + deltaX, endPoint.y + deltaY);
	}


}
