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
public class BetweenArrowsConstraintConnection extends PolylineConnection implements RoutableFigure {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	
	NodeFigure basicRectangleFigure;
	ConstraintEditPart constraintEditPart;
	private String labelText;
	
	public BetweenArrowsConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		this.constraintEditPart = constraintEditPart;
		this.labelText = labelText;
		setMyBackgroundColor(ColorConstants.black);
	}
	
	private NodeFigure getBasicRectangleFigure() {
		if (basicRectangleFigure == null) {
			basicRectangleFigure = constraintEditPart.getRectangleFigureForFigure();
		}
		return basicRectangleFigure;
	}
	
	private Point[] getMidwayControlPoints(Point startPoint, Point endPoint) {
		Point[] firstCandidate = makeMidwayControlPoints(startPoint, endPoint);
		Point[] secondCandidate = makeMidwayControlPoints(endPoint, startPoint);
		
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
	
	private Point[] makeMidwayControlPoints(Point startPoint, Point endPoint) {
		int dx = endPoint.x - startPoint.x;
		int dy = endPoint.y - startPoint.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * 20, normOrthoVectorY  * 20);		
		Point midway = new Point(startPoint.x + (dx/2), startPoint.y + (dy/2));
		
		Point[] retval = new Point[3];
		retval[2] = midway;
		
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
				
		Point [] controlpoints = getMidwayControlPoints(p1, p2);
		
// Draws the control points for your viewing pleasure		
//		g.drawText("¥", getMidwayPoint(controlpoints[0], p1));
//		g.drawText("¥", getMidwayPoint(controlpoints[0], p2));
		
		
		Bezier bezier = new Bezier(p1, p2, getMidwayPoint(controlpoints[0], p2), getMidwayPoint(controlpoints[0], p1));
		bezier.outlineShape(g);
		
		g.drawText(labelText, controlpoints[1].translate(-17, 0));

		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(points.getFirstPoint()));
		drawAnchorBlob(g, buildPointBox(points.getLastPoint()));
//		counter++;
//		System.out.println(Integer.toString(counter) + ": Outlines Constraint figure");
		
	}

	private Point getMidwayPoint(Point p1, Point p2) {
		int dx = p1.x - p2.x;
		int dy = p1.y - p2.y;		
		return new Point(p1.x + (dx/2), p1.y + (dy/2));
	}
	
//	private static int counter = 0;
	
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
