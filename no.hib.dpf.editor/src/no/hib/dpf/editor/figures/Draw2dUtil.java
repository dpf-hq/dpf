package no.hib.dpf.editor.figures;


import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.impl.DOffsetImpl;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class Draw2dUtil {

	/*
	 * get a tranform which transforms the current coordinate to the new one in which
	 * the line from start and end is the x-axis
	 */
	public static Transform getTransform(Point start, Point end){
		Transform transform = new Transform();
		Point line = new Point(end.getTranslated(start.getNegated()));
		transform.setRotation(-Math.atan((double)line.y/(double)line.x));
		Point axis = transform.getTransformed(start);
		transform.setTranslation(-axis.preciseX(), -axis.preciseY());
		return transform;
	}
	public static class Transform {
		public double scaleX = 1.0, scaleY = 1.0, dx, dy, cos = 1.0, sin;
		public Point getTransformed(Point p) {
			double x = p.preciseX();
			double y = p.preciseY();
			double temp;
			x *= scaleX;
			y *= scaleY;

			temp = x * cos - y * sin;
			y = x * sin + y * cos;
			x = temp;
			return new PrecisionPoint(x + dx, y + dy);
		}
		public Transform(){
			super();
		}
		public Point getTransformBack(Point p) {
			double x = p.preciseX() - dx;
			double y = p.preciseY() - dy;

			double temp;
			temp = x * cos + y * sin;
			y =  -x * sin + y * cos;
			x = temp;

			x /= scaleX;
			y /= scaleY;

			return new PrecisionPoint(x, y);
		}

		/**
		 * Sets the value for the amount of scaling to be done along both axes.
		 * 
		 * @param scale
		 *            Scale factor
		 * @since 2.0
		 */
		public void setScale(double scale) {
			scaleX = scaleY = scale;
		}

		/**
		 * Sets the value for the amount of scaling to be done along X and Y axes
		 * individually.
		 * 
		 * @param x
		 *            Amount of scaling on X axis
		 * @param y
		 *            Amount of scaling on Y axis
		 * @since 2.0
		 */
		public void setScale(double x, double y) {
			scaleX = x;
			scaleY = y;
		}

		/**
		 * Sets the rotation angle.
		 * 
		 * @param angle
		 *            Angle of rotation
		 * @since 2.0
		 */
		public void setRotation(double angle) {
			cos = Math.cos(angle);
			sin = Math.sin(angle);
		}

		/**
		 * Sets the translation amounts for both axes.
		 * 
		 * @param x
		 *            Amount of shift on X axis
		 * @param y
		 *            Amount of shift on Y axis
		 * @since 2.0
		 */
		public void setTranslation(double x, double y) {
			dx = x;
			dy = y;
		}
	}
	/*
	 * get a transform which transforms back to the old coordinate
	 */

	public static PrecisionPoint mid(Point start, Point end){
		return new PrecisionPoint((start.preciseX() + end.preciseX())/2.0, (start.preciseY() + end.preciseY())/2.0);
	}

	public static Point getAbsoluteBendPoint(Point start, Point end, DOffset p) {
		Transform transform = getTransform(start, end);
		double len = transform.getTransformed(end).preciseX();
		double ration = (double)len / (double)p.getLen();
		PrecisionPoint result = new PrecisionPoint(ration * p.getOffset().preciseX(), ration * p.getOffset().preciseY());
		return transform.getTransformBack(result);
	}

	public static DOffset getDOffset(Point start, Point end, Point p){
		Transform transform = getTransform(start, end);
		return new DOffsetImpl(transform.getTransformed(p), transform.getTransformed(end).x);
		
	}

	/*
	 * Get Doffset for a bendpoint
	 */
	public static DOffset getDOffset(IFigure source, IFigure target, Point p){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		return getDOffset(start, end, p);
	}
	/*
	 * Get DOffset for labels. Find the lines composed by two consecutive bendpoints where the point has shortest distance 
	 */
	public static DOffset getDOffset(IFigure source, IFigure target, PointList points, Point p){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		PointList copied = points.getCopy();
		copied.setPoint(start, 0);
		copied.setPoint(end, copied.size() - 1);
		Transform transform = getTransform(start, end);
		double pre = Integer.MAX_VALUE;
		int min = 0;
		if(points.size() > 2)
		for(int index = 0; index + 1 < points.size(); ++index){
			Point first = points.getPoint(index), secondPoint = points.getPoint(index + 1);
			transform = getTransform(first, secondPoint);
			double distance = Math.pow(Math.pow(p.getDistance(first), 2) - Math.pow(transform.getTransformed(p).x, 2), 0.5);
			if(distance < pre){
				min = index;
				pre = distance;
			}
		}
		start = copied.getPoint(min);
		end = copied.getPoint(min + 1);
		DOffset result = getDOffset(start, end, p);
		result.setIndex(min);
		return result;
	}
	/*
	 * get Absoluate point of labels
	 */
	public static Point getAbsolutePoint(IFigure source, IFigure target, PointList points, DOffset offset){
		Point start, end;
		int index = offset.getIndex();
		PointList copied = points.getCopy();
		start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		copied.setPoint(start, 0);
		copied.setPoint(end, copied.size() - 1);
		if(index + 1 < points.size()){
			start = copied.getPoint(index);
			end = copied.getPoint(index + 1);
		}else{
			start = copied.getPoint(points.size() - 2);
			end = copied.getPoint(points.size() - 1);
		}
		return getAbsoluteBendPoint(start, end, offset);
	}

	//find the cross point of two lines. p1, p2 are two points of first line and p3, p4 are two points of second line
	public static Point getCross(Point p1, Point p2, Point p3, Point p4){
		int k = (p2.x - p1.x) * (p4.y - p3.y) - (p2.y - p1.y) * (p4.x - p3.x);
		if(k == 0)
			return null;
		return new PrecisionPoint(((p3.y - p1.y) * (p2.x - p1.x) * (p4.x - p3.x) + p1.x * (p2.y - p1.y) * (p4.x - p3.x) - p3.x * (p4.y - p3.y) * (p2.x - p1.x)) / -k,
				((p3.x - p1.x) * (p2.y - p1.y) * (p4.y - p3.y) + p1.y * (p2.x - p1.x) * (p4.y - p3.y) - p3.y * (p4.x - p3.x) * (p2.y - p1.y)) / k);
	}
	public static boolean isParallel(Point p1, Point p2, Point p3, Point p4){
		return (p2.x - p1.x) * (p4.y - p3.y) == (p2.y - p1.y) * (p4.x - p3.x);
	}
	//scale the vector according to the direction and get the end point.
	public static Point scableLine(Point start, Point end, double scale){
		return end.getScaled(scale).translate(start.getScaled(1-scale));
	}

	public static org.eclipse.draw2d.geometry.Point getCenter(DNode dSource) {
		return dSource.getLocation().getTranslated(dSource.getSize().getScaled(0.5));
	}

}
