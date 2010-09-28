package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class DPFConnectionFigure extends PolylineConnection {
	
	// TODO: calculate this based on the connected node's properties.
	private int maxDistanceToConnectionPoint = 75; 
	
	/**
	 * @see Shape#outlineShape(Graphics)
	 */
	@Override
	protected void outlineShape(Graphics g) {
		super.outlineShape(g);
		PointList points = getPoints();
		g.drawArc(calculateConnectionPoint(points).x, calculateConnectionPoint(points).y, 20, 20, 300, 300);
	}
	
	private Point calculateConnectionPoint(PointList points) {
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


}
