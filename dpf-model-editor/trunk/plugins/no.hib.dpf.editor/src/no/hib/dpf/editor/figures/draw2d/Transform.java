package no.hib.dpf.editor.figures.draw2d;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;


/**
 * Provides support for transformations of scaling, translation and rotation.
 */
public class Transform {

	private double scaleX = 1.0, scaleY = 1.0, dx, dy, cos = 1.0, sin;

	/**
	 * Returns a new transformed Point of the input Point based on the
	 * transformation values set.
	 * 
	 * @param p
	 *            Point being transformed
	 * @return The transformed Point
	 * @since 2.0
	 */
	public PrecisionPoint getTransformed(Point p) {
		double x = p.x + dx;
		double y = p.y + dy;
		double temp;
		x *= scaleX;
		y *= scaleY;

		temp = x * cos - y * sin;
		y = x * sin + y * cos;
		x = temp;
		return new PrecisionPoint(x, y);
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
