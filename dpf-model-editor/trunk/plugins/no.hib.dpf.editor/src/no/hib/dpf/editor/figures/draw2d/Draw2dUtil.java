package no.hib.dpf.editor.figures.draw2d;


import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.impl.DOffsetImpl;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class Draw2dUtil {

	public static Point getAbsoluteBendPoint(Point start, Point end, DOffset p) {
		TransformS.setBasic(start, end);
		int len = TransformS.getRelative(end).x;
		double ration = (double)len / (double)p.getLen();
		PrecisionPoint result = new PrecisionPoint(ration * p.getOffset().x, ration * p.getOffset().y);
		return TransformS.getAbsolute(result);
	}
	
	public static DOffset getDOffset(Point start, Point end, Point p){
		TransformS.setBasic(start, end);
		return new DOffsetImpl(TransformS.getRelative(p), TransformS.getRelative(end).x);
	}
	/*
	 * Get Doffset for a bendpoint
	 */
	public static DOffset getDOffset(IFigure source, IFigure target, Point p){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		return Draw2dUtil.getDOffset(start, end, p);
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
		TransformS.setBasic(start, end);
		double pre = Integer.MAX_VALUE;
		int min = 0;
		for(int index = 0; index < points.size() - 2; ++index){
			Point first = points.getPoint(index), secondPoint = points.getPoint(index + 1);
			TransformS.setBasic(first, secondPoint);
			double distance = Math.pow(Math.pow(p.getDistance(first), 2) - Math.pow(TransformS.getRelative(p).x, 2), 0.5);
			if(distance < pre){
				min = index;
				pre = distance;
			}
		}
		start = copied.getPoint(min);
		end = copied.getPoint(min + 1);
		DOffset result = Draw2dUtil.getDOffset(start, end, p);
		result.setIndex(min);
		return result;
	}
	/*
	 * get Absoluate point of labels
	 */
	public static Point getAbsolutePoint(IFigure source, IFigure target, PointList points, DOffset offset){
		Point start, end;
		int index = offset.getIndex();
		if(index == 0)
			start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		else
			start = points.getPoint(index);
		if(index == points.size() - 2)
			end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		else
			end = points.getPoint(index + 1);
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

}
