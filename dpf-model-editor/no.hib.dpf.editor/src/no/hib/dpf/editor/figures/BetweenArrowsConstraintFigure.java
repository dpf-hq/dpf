package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.parts.ConstraintEditPart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class BetweenArrowsConstraintFigure extends PolylineConnection implements RoutableFigure {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	
	BasicRectangleFigure basicRectangleFigure;
	ConstraintEditPart constraintEditPart;
	private String labelText;
	
	public BetweenArrowsConstraintFigure(ConstraintEditPart constraintEditPart, String labelText) {
		this.constraintEditPart = constraintEditPart;
		this.labelText = labelText;
		setMyBackgroundColor(ColorConstants.black);
	}
	
	private BasicRectangleFigure getBasicRectangleFigure() {
		if (basicRectangleFigure == null) {
			basicRectangleFigure = constraintEditPart.getRectangleFigureForFigure();
		}
		return basicRectangleFigure;
	}
	
	private Point[] getMidwayControlPoint(Point startPoint, Point endPoint) {
		Point[] firstCandidate = makeMidwayControlPoint(startPoint, endPoint);
		Point[] secondCandidate = makeMidwayControlPoint(endPoint, startPoint);
		
		if (getBasicRectangleFigure() == null) {
			return firstCandidate;
		}
		
		if ((getBasicRectangleFigure().getLocation().getDistance(firstCandidate[0]) >=
			(getBasicRectangleFigure().getLocation().getDistance(secondCandidate[0])))) {
			return firstCandidate;
		}
		return secondCandidate;
	}
	
	
	/**
	 * Returns <code>true</code> if this Figure uses local coordinates. This
	 * means its children are placed relative to this Figure's top-left corner.
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 * @since 2.0
	 */
	@Override
	protected boolean useLocalCoordinates() {
		return false;
	}
	
	private Point[] makeMidwayControlPoint(Point startPoint, Point endPoint) {
		int dx = endPoint.x - startPoint.x;
		int dy = endPoint.y - startPoint.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * 20, normOrthoVectorY  * 20);		
		Point midway = new Point(startPoint.x + (dx/2), startPoint.y + (dy/2));
		
		Point[] retval = new Point[2];
		
		retval[0] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		finalVector = new Point(normOrthoVectorX * 37, normOrthoVectorY  * 37);		
		retval[1] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		
		return retval;
	}
	
	/**
	 * Sets the list of points to be used by this figure. Removes any previously
	 * existing points. This figure will hold onto the given list by reference.
	 * 
	 * @param points
	 *            new set of points
	 */
	public void setPoints(PointList points) {
		super.setPoints(points);
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
//		System.out.println("Constraint Y-Points: " + p1.y + ", " + p2.y);
				
		Point [] controlpoints = getMidwayControlPoint(p1, p2);
		
		Bezier bezier = new Bezier(points.getFirstPoint(), points.getLastPoint(), controlpoints[0], controlpoints[0]);
		bezier.outlineShape(g);

		g.drawText(labelText, controlpoints[1].translate(-17, 0));

		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(points.getFirstPoint()));
		drawAnchorBlob(g, buildPointBox(points.getLastPoint()));
		counter++;
		System.out.println(Integer.toString(counter) + ": Outlines Constraint figure");
//		System.out.println("Constraint Y-Points: " + p1.y + ", " + p2.y);
		
	}
	
	private static int counter = 0;
	
	private Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}
 	
	private void drawAnchorBlob(Graphics g, Rectangle r) {
		g.fillArc(r.x, r.y, r.width, r.height, 0, 360);	
	}
	
	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			super.getBounds();
			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
			bounds.expand(30, 30);
		}
		return bounds;
		
	}
	
	
	/**
	 * SetBacgroundColor without update()
	 * @see IFigure#setBackgroundColor(Color)
	 */
	@SuppressWarnings("deprecation")
	public void setMyBackgroundColor(Color bg) {
		// Set background color to bg unless in high contrast mode.
		// In that case, get the color from system
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		Color highContrastClr = null;
		try {
			if (display.getHighContrast()) {
				highContrastClr = display
						.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
			}
		} catch (SWTException e) {
			highContrastClr = null;
		}
		bgColor = highContrastClr == null ? bg : highContrastClr;
	}

	@Override
	public int getRoutingPriority() {
		return 10;
	}


	
}
