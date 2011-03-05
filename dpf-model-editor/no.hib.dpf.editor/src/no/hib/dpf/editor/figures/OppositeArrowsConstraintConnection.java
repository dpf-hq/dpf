package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.ConstraintEditPart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Draws a figure located between two points (on arrows).
 * The arrows are supposed to be parallel, and (for the time being) in opposite directions.
 */
public class OppositeArrowsConstraintConnection extends TwoArrowConstraintConnection {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	
	NodeFigure basicRectangleFigure;
	ConstraintEditPart constraintEditPart;
	private String labelText;
	
	public OppositeArrowsConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		this.constraintEditPart = constraintEditPart;
		this.labelText = labelText;
		setMyBackgroundColor(ColorConstants.black);
	}
		
		
	@Override
	protected void outlineShape(Graphics g) {
		
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
				
		g.drawText(labelText, getMidwayPoint(p1, p2)); ///.translate(-17, 0));

		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(p1));
		drawAnchorBlob(g, buildPointBox(p2));
//		counter++;
//		System.out.println(Integer.toString(counter) + ": Outlines Constraint figure");
		super.outlineShape(g);
		
	}
	
//	private static int counter = 0;
		
	


	
}
