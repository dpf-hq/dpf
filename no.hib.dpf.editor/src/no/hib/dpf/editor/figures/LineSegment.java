package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class LineSegment{
	public static Point move(Point a, Point origin){
		return origin.getNegated().translate(a);
	}
	public static Point spin(Point a, double angle){
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad), sin = Math.sin(rad);
		return new PrecisionPoint(Math.round(a.x * cos - a.y * sin), Math.round(a.x * sin + a.y * cos));
	}
	private Double length = null;
	private Double slope = null;
	private PrecisionPoint start = null, end = null;
	public LineSegment(Point start2, Point end2) {
		start = new PrecisionPoint(start2);
		end = new PrecisionPoint(end2 == null ? new Point() : end2);
	}
	public Point getCrossPoint(Rectangle r){
		Point center = r.getCenter();
		float centerX = center.x;
		float centerY = center.y;

		Point reference = start;
		if (r.isEmpty()
				|| (reference.x == (int) centerX && reference.y == (int) centerY))
			return new Point((int) centerX, (int) centerY); // This avoids
															// divide-by-zero

		float dx = reference.x - centerX;
		float dy = reference.y - centerY;

		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
		float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy)
				/ r.height);

		dx *= scale;
		dy *= scale;
		centerX += dx;
		centerY += dy;

		return new Point(Math.round(centerX), Math.round(centerY));
	}
	
	public double getLength() {
		if(length == null)
			length = new Double(start.getDistance(end));
		return length;
	}
	public double getSlope(){
		if(slope == null){
			double ratio = 0; 
			double dx = end.preciseX() - start.preciseX();
			double dy = end.preciseY() - start.preciseY();
			if(dx == 0){
				ratio = Math.PI / 2.0;
				if(dy < 0)
					ratio = -ratio;
			}else{
				ratio = Math.atan(dy / dx);
				if (dx < 0) 
					ratio = ratio + Math.PI;
			}
			slope = new Double(ratio);
		}
		return slope;
	}
	public  Point getSpinEnd(double len, double angle){
		return new LineSegment(end, start).getSpinStart(len, angle);
	}
	public Point getSpinStart(double len, double angle){
		return spin(angle).scaleTo(len).end;
	}
	public  LineSegment move(Point origin){
		Point delta = origin.getNegated();
		return new LineSegment(delta.getTranslated(start), delta.getTranslated(end));
	}
	
	public LineSegment scaleTo(double length){
		double ratio = length / getLength();
		return new LineSegment(start.getScaled(ratio), end.getScaled(ratio));
	}
	public LineSegment spin(double angle){
		Point end = move(this.end, start);
		end = spin(end, angle);
		return new LineSegment(start, end.getTranslated(start));
	}
}
