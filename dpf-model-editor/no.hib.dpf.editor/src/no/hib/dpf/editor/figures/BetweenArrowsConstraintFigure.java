package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class BetweenArrowsConstraintFigure extends PolylineConnection {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	BasicRectangleFigure basicRectangleFigure;
	private String labelText;
	
	public BetweenArrowsConstraintFigure(BasicRectangleFigure basicRectangleFigure, String labelText) {
		this.basicRectangleFigure = basicRectangleFigure;
		this.labelText = labelText;
	}
	
	private Point[] getMidwayControlPoint(Point startPoint, Point endPoint) {
		Point[] firstCandidate = makeMidwayControlPoint(startPoint, endPoint);
		Point[] secondCandidate = makeMidwayControlPoint(endPoint, startPoint);
		
		if (basicRectangleFigure == null) {
			return firstCandidate;
		}
		
		if ((basicRectangleFigure.getLocation().getDistance(firstCandidate[0]) >=
			(basicRectangleFigure.getLocation().getDistance(secondCandidate[0])))) {
			return firstCandidate;
		}
		return secondCandidate;
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
	
	@Override
	protected void outlineShape(Graphics g) {
		
		
		//super.outlineShape(g);
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
		
		Point [] controlpoints = getMidwayControlPoint(p1, p2);
		
		Bezier bezier = new Bezier(points.getFirstPoint(), points.getLastPoint(), controlpoints[0], controlpoints[0]);
		bezier.outlineShape(g);
		
		g.drawText(labelText, controlpoints[1].translate(-17, 0));
		
		drawAnchorBlob(g, buildPointBox(points.getFirstPoint()));
		drawAnchorBlob(g, buildPointBox(points.getLastPoint()));
	}
	
	private Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}
 	
	private void drawAnchorBlob(Graphics g, Rectangle r) {
//		Color c = new Color()
		setBackgroundColor(ColorConstants.black);
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
	
	


	
}
