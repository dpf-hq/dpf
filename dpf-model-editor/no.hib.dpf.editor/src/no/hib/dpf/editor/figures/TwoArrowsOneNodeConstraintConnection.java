package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.parts.ConstraintEditPart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class TwoArrowsOneNodeConstraintConnection extends TwoArrowConstraintConnection  {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	
	NodeFigure basicRectangleFigure;
	ConstraintEditPart constraintEditPart;
	private String labelText;
	
	public TwoArrowsOneNodeConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
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
	
		
	private Point[] makeMidwayControlPoints(Point startPoint, Point endPoint) {
		// First point: to make control points for Bezier
		// Second point: to make control point for text
		int dx = endPoint.x - startPoint.x;
		int dy = endPoint.y - startPoint.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * 45, normOrthoVectorY  * 45);		
		Point midway = new Point(startPoint.x + (dx/2), startPoint.y + (dy/2));
		
		Point[] retval = new Point[2];
		
		retval[0] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		finalVector = new Point(normOrthoVectorX * 30, normOrthoVectorY  * 30);		
		retval[1] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		
		return retval;
	}
	
	
	private void drawCenteredText(Graphics g, String text, Point point) {
		Dimension textSize = FigureUtilities.getTextExtents(labelText, g.getFont());
		
		Point textPoint = new Point(point.x - (textSize.width/2), point.y - (textSize.height/2));
		g.drawText(labelText, textPoint);
		
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
				
		Point [] controlpoints = getMidwayControlPoints(p1, p2);
		
// Draws the control points for your viewing pleasure		
//		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[0], p1)));
//		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[0], p2)));
		
		
		Bezier bezier = new Bezier(p1, p2, getMidwayPoint(controlpoints[0], p1), getMidwayPoint(controlpoints[0], p2));
		bezier.outlineShape(g);
				
		drawCenteredText(g, labelText, controlpoints[1]);

		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(points.getFirstPoint()));
		drawAnchorBlob(g, buildPointBox(points.getLastPoint()));
	}
	
}
