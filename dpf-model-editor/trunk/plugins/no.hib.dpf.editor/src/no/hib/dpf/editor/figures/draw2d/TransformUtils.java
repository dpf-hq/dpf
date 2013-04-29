package no.hib.dpf.editor.figures.draw2d;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class  TransformUtils {

	public static double getAngle(double x, double y){
		return Math.atan2(y, x);
	}
	public static double getAngle(PrecisionPoint p){
		return getAngle(p.preciseX(), p.preciseY());
	}
	public static PrecisionPoint getSubstract(PrecisionPoint a, PrecisionPoint b){
		return new PrecisionPoint(a.preciseX() - b.preciseX(), a.preciseY() - b.preciseY());
	}
	
	public static PrecisionPoint spinAndMove(Point location, double angle, PrecisionPoint to){
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		double x = location.preciseX() * cos - location.preciseY() * sin;
		double y = location.preciseX() * sin + location.preciseY() * cos;
		return new PrecisionPoint(x + to.preciseX(), y + to.preciseY());
	}
	public static PrecisionPoint move(PrecisionPoint a, PrecisionPoint b){
		return new PrecisionPoint(a.preciseX() + b.preciseX(), a.preciseY() + b.preciseY());
	}
	public static PrecisionPoint moveToNewAxis(PrecisionPoint x, PrecisionPoint newCenter){
		return getSubstract(x, newCenter);
	}
	
	public static PrecisionPoint spin(PrecisionPoint location, double angle){
		
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		double x = location.preciseX() * cos - location.preciseY() * sin;
		double y = location.preciseX() * sin + location.preciseY() * cos;
		return new PrecisionPoint(x, y);
	}
	
	/*
	 * The three parameters are in the same coordinate
	 * The axis is moved from old to newCenter and x is parallel with newOrient
	 * return old point's new point value relative to new axis
	 */
	public static PrecisionPoint translateToNewAxis(PrecisionPoint old, PrecisionPoint newCenter, PrecisionPoint newOrient){
		PrecisionPoint result = new PrecisionPoint(moveToNewAxis(old, newCenter));
		return spin(result, getAngle(newOrient.preciseX(), newOrient.preciseY()));
	}
	/*
	 * newPoint is relative to new axis
	 * newCenter and newOrient is relative to old axis
	 * return newPoint's point value relative to old axis
	 */
	public static PrecisionPoint translateBackToAxis(PrecisionPoint newPoint, PrecisionPoint newCenter, PrecisionPoint newOrient){
		PrecisionPoint result = spin(newPoint, -getAngle(newOrient.x, newOrient.y));
		result = new PrecisionPoint(result.translate(newCenter));
		return result;
	}
}
