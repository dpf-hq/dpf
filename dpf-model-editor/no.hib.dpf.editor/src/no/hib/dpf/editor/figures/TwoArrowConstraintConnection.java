package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.ConstraintEditPart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public abstract class TwoArrowConstraintConnection extends PolylineConnection implements RoutableFigure {
	
	protected String labelText;
	protected ConstraintEditPart constraintEditPart;
	private NodeFigure basicRectangleFigure;
	private int [] controlPointsOffsets;

	public TwoArrowConstraintConnection(ConstraintEditPart constraintEditPart, String labelText, int [] controlPointsOffsets) {
		super();
		this.constraintEditPart = constraintEditPart;
		this.labelText = labelText;
		this.controlPointsOffsets = controlPointsOffsets;
		setMyBackgroundColor(ColorConstants.black);		
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
		
		
		Bezier bezier = new Bezier(p1, p2, getMidwayPoint(controlpoints[0], p1), getMidwayPoint(controlpoints[0], p2));
		bezier.outlineShape(g);
		
		drawCenteredText(g, labelText, controlpoints[1]);
		drawEndpointBlobs(g, p1, p2);

	}
	
	protected NodeFigure getBasicRectangleFigure() {
		if (basicRectangleFigure == null) {
			basicRectangleFigure = constraintEditPart.getRectangleFigureForFigure();
		}
		return basicRectangleFigure;
	}
	
	
	protected Point[] getMidwayControlPoints(Point startPoint, Point endPoint, int offset1, int offset2) {
		Point[] firstCandidate = makeMidwayControlPoints(startPoint, endPoint, offset1, offset2);
		Point[] secondCandidate = makeMidwayControlPoints(endPoint, startPoint, offset1, offset2);
		
		if (getBasicRectangleFigure() == null) {
			return firstCandidate;
		}
		
		if ((getBasicRectangleFigure().getLocation().getDistance(firstCandidate[0]) >=
			(getBasicRectangleFigure().getLocation().getDistance(secondCandidate[0])))) {
			return firstCandidate;
		}
		return secondCandidate;
	}
	
	private Point[] makeMidwayControlPoints(Point startPoint, Point endPoint, int offset1, int offset2) {
		// First point: to make control points for Bezier
		// Second point: to make center point for text
		int dx = endPoint.x - startPoint.x;
		int dy = endPoint.y - startPoint.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * offset1, normOrthoVectorY  * offset1);		
		Point midway = new Point(startPoint.x + (dx/2), startPoint.y + (dy/2));
		
		Point[] retval = new Point[2];
		
		retval[0] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		finalVector = new Point(normOrthoVectorX * offset2, normOrthoVectorY  * offset2);		
		retval[1] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		
		return retval;
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

	protected void drawAnchorBlob(Graphics g, Rectangle r) {
		g.fillArc(r.x, r.y, r.width, r.height, 0, 360);	
	}

	protected Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}

	protected Point getMidwayPoint(Point p1, Point p2) {		
		int maxY = Math.max(p1.y, p2.y);
		int minY = Math.min(p1.y, p2.y);
		
		int maxX = Math.max(p1.x, p2.x);
		int minX = Math.min(p1.x, p2.x);
		
		int dx = maxX - minX;
		int dy = maxY - minY;		
		return new Point(maxX - (dx/2), maxY - (dy/2));
	}

	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			super.getBounds();
			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
			bounds.expand(90, 90);
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

	protected void drawCenteredText(Graphics g, String text, Point point) {
		Dimension textSize = FigureUtilities.getTextExtents(text, g.getFont());
		
		Point textPoint = new Point(point.x - (textSize.width/2), point.y - (textSize.height/2));
		g.drawText(text, textPoint);		
	}

	protected void drawEndpointBlobs(Graphics g, Point p1, Point p2) {
		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(p1));
		drawAnchorBlob(g, buildPointBox(p2));
	}
	
}