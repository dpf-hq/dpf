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
	
	public static DOffset getDOffset(IFigure source, IFigure target, Point p){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		return Draw2dUtil.getDOffset(start, end, p);
	}
	
	public static DOffset getDOffset(IFigure source, IFigure target, PointList points, Point p){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		TransformS.setBasic(start, end);
		if(points.size() > 2){
			int pre = Integer.MIN_VALUE;
			int relative = TransformS.getRelative(p).x;
			int index = 0;
			for(; index < points.size() - 2; ++index){
				Point currentPoint = points.getPoint(index + 1);
				int current = TransformS.getRelative(currentPoint).x;
				if(current < pre) {
					int temp = pre;
					pre = current;
					current = temp;
				}
				if(relative > pre && relative <= current)
					break;
				pre = current;
			}
			start = points.getPoint(index).getCopy();
			end = points.getPoint(index + 1);
			return Draw2dUtil.getDOffset(start, end, p, index);
		}else
			return Draw2dUtil.getDOffset(start, end, p, 0);
	}
	public static boolean isInvalid(IFigure source, IFigure target, Point label, Point newBendPoint, DOffset offset){
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		TransformS.setBasic(start, end);
		return TransformS.getRelative(label).x > TransformS.getRelative(newBendPoint).x ;
	}
	public static Point getAbsolutePoint(IFigure source, IFigure target, PointList points, DOffset offset){
		Point start, end;
		int index = offset.getIndex();
		if(points.size() == 2){
			start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
			end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		}else{
			if(index > points.size() - 2) return null;
			start = points.getPoint(index);
			end = points.getPoint(index + 1);
		}
		return getAbsoluteBendPoint(start, end, offset);
	}

	private static DOffset getDOffset(Point start, Point end, Point p, int index) {
		DOffset result = getDOffset(start, end, p);
		result.setIndex(index);
		return result;
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
