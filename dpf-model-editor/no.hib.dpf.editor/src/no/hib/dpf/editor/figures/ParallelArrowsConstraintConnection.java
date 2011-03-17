package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

import no.hib.dpf.editor.parts.ConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The arrows are supposed to be parallel, and (for the time being) in the same direction.
 */
public class ParallelArrowsConstraintConnection extends TwoArrowConstraintConnection {
	
	public ParallelArrowsConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		super(constraintEditPart, labelText, new int[]{ -20, 20});
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
						
		Point [] controlpoints = getMidwayControlPoints(p1, p2, controlPointsOffsets[0], controlPointsOffsets[1]);
		
// Draws the control points for your viewing pleasure		
//		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[0], p1)));
//		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[0], p2)));
		
		
		Bezier bezier = new Bezier(p1, p2, getMidwayPoint(controlpoints[1], p1), getMidwayPoint(controlpoints[1], p2));
		bezier.outlineShape(g);
		
		drawCenteredText(g, labelText, controlpoints[0]);
		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(p1));

	}

}
