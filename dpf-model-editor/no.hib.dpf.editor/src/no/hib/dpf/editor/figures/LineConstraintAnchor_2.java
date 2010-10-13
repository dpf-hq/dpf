package no.hib.dpf.editor.figures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class LineConstraintAnchor_2 implements ConnectionAnchor {

	/**
	 * The list of listeners
	 */
	@SuppressWarnings("rawtypes")
	protected List listeners = new ArrayList(1);
	private PolylineConnection connectionFigure;
	private BasicRectangleFigure sourceNodeFigure;
	
	private Point location;
	private boolean useTargetEnd;

	/**
	 * Constructs an XYAnchor at the Point p.
	 * 
	 * @param p
	 *            the point where this anchor will be located
	 *           
	 * @since 2.0
	 */
	public LineConstraintAnchor_2(Point p, boolean useTargetEnd) {
		location = new Point(p);
		this.useTargetEnd = useTargetEnd;
	}

	/**
	 * @see org.eclipse.draw2d.ConnectionAnchor#addAnchorListener(AnchorListener)
	 */
	@SuppressWarnings("unchecked")
	public void addAnchorListener(AnchorListener listener) {
		listeners.add(listener);
	}

	/**
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
	 * Returns the location of this anchor relative to the reference point given
	 * in as input. Since this is XY layout, the location of the point is
	 * independent of the reference point.
	 * 
	 * @see ConnectionAnchor#getLocation(Point)
	 */
	public Point getLocation(Point reference) {
		return getLinePoint();			
	}

	/**
	 * Returns <code>null</code> as these anchors inherently do not depend on
	 * other figures for their location.
	 * 
	 * @see ConnectionAnchor#getOwner()
	 * @since 2.0
	 */
	public IFigure getOwner() {
		return null;
	}

	/**
	 * Returns the point which is used as the reference by this connection
	 * anchor. In the case of the XYAnchor, this point is the same as its
	 * location.
	 * 
	 * @see ConnectionAnchor#getReferencePoint()
	 */
	public Point getReferencePoint() {
		return getLinePoint();			
	}

	/**
	 * Sets the location of this anchor and notifies all the listeners of the
	 * update.
	 * 
	 * @param p
	 *            the new location of this anchor
	 * @see #getLocation(Point)
	 * @since 2.0
	 */
	public void setLocation(Point p) {
		location.setLocation(p);
		fireAnchorMoved();
	}

	private Point getLinePoint() {
		if (this.connectionFigure != null) {
			if (useTargetEnd == false) {
				return calculateConnectionPointFromSource(connectionFigure.getPoints());
			} else {				
				return calculateConnectionPointFromTarget(connectionFigure.getPoints());
			}
		}
		return new Point(new Random().nextInt(500), new Random().nextInt(500));
	}
	
	public void setConnectionFigure(PolylineConnection connectionFigure) {
		this.connectionFigure = connectionFigure;
	}

	public PolylineConnection getConnectionFigure() {
		return connectionFigure;
	}	
	
	
	// TODO: calculate this based on the connected node's properties.
	private int maxDistanceToConnectionPoint = 75; 
	
	private Point calculateConnectionPointFromSource(PointList points) {
		if (points.size() < 2) return points.getFirstPoint();
		
		double distanceBetweenFirstPoints = points.getFirstPoint().getDistance(points.getPoint(1));
		if (distanceBetweenFirstPoints < 0.01) {
			return points.getFirstPoint();
		}
		double distanceToConnectionPoint = distanceBetweenFirstPoints/2;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		
		
		int deltaX = points.getPoint(1).x - points.getPoint(0).x;
		int deltaY = points.getPoint(1).y - points.getPoint(0).y;
		
		double factor = distanceToConnectionPoint/distanceBetweenFirstPoints;
		deltaX = (int)(deltaX * factor);
		deltaY = (int)(deltaY * factor);
		
		return new Point(points.getFirstPoint().x + deltaX, points.getFirstPoint().y + deltaY);
	}

	private Point calculateConnectionPointFromTarget(PointList points) {
		if (points.size() < 2) return points.getLastPoint();
		
		double distanceBetweenLastPoints = points.getLastPoint().getDistance(points.getPoint(points.size() - 2));
		if (distanceBetweenLastPoints < 0.01) {
			return points.getLastPoint();
		}
		double distanceToConnectionPoint = distanceBetweenLastPoints/2;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		
		
		int deltaX = points.getPoint(points.size() - 2).x - points.getPoint(points.size() - 1).x;
		int deltaY = points.getPoint(points.size() - 2).y - points.getPoint(points.size() - 1).y;
		
		double factor = distanceToConnectionPoint/distanceBetweenLastPoints;
		deltaX = (int)(deltaX * factor);
		deltaY = (int)(deltaY * factor);
		
		return new Point(points.getLastPoint().x + deltaX, points.getLastPoint().y + deltaY);
	}

	public void setSourceNodeFigure(BasicRectangleFigure sourceFigure) {
		this.sourceNodeFigure = sourceFigure;
	}

	public BasicRectangleFigure getSourceNodeFigure() {
		return sourceNodeFigure;
	}	
}
