package no.hib.dpf.diagram.util;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class TransformS{
	static org.eclipse.draw2d.geometry.Transform absolute= new org.eclipse.draw2d.geometry.Transform();
	static private PrecisionPoint from = new PrecisionPoint(0, 0), to = new PrecisionPoint(0, 0);
	static Transform relative= new Transform();
	static final PrecisionPoint zero = new PrecisionPoint(0, 0);
	public static Point getAbsolute(Point point){
		return absolute.getTransformed(point);
	}
	static private Double getAngle(PrecisionPoint p){
		return Math.atan2(p.preciseY(), p.preciseX());
	}
	public static Point getRelative(Point point){
		return relative.getTransformed(point);
	}
	static private PrecisionPoint getRelative(PrecisionPoint from2, PrecisionPoint to2) {
		return new PrecisionPoint(to2.preciseX() - from2.preciseX(), to2.preciseY() - from2.preciseY());
	}
	static public void setBasic(Point f, Point t){
		from.setPreciseX(f.x);
		from.setPreciseY(f.y);
		to.setPreciseX(t.x);
		to.setPreciseY(t.y);
		relative.setTranslation(-f.preciseX(), -f.preciseY());
		double ration = getAngle(getRelative(from, to));
		relative.setRotation(-ration);
		absolute.setTranslation(f.preciseX(), f.preciseY());
		absolute.setRotation(ration);
		
	}
	static public void setFrom(Point f){
		from.setPreciseX(f.x);
		from.setPreciseY(f.y);
		relative.setTranslation(-f.preciseX(), -f.preciseY());
		double ration = getAngle(getRelative(from, to));
		relative.setRotation(-ration);
		absolute.setTranslation(f.preciseX(), f.preciseY());
		absolute.setRotation(ration);
		
	}
	static public void setTo(Point t){
		to.setPreciseX(t.x);
		to.setPreciseY(t.y);
		double ration = getAngle(getRelative(from, to));
		relative.setRotation(-ration);
		absolute.setRotation(ration);

	}
}