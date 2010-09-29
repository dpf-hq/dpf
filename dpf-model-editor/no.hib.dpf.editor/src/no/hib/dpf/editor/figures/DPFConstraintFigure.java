package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class DPFConstraintFigure extends PolylineConnection {

	Rectangle firstPointBounds;
	Rectangle lastPointBounds;
	
	@Override
	protected void outlineShape(Graphics g) {
		
		
		//super.outlineShape(g);
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
		
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		//Point normOrthoVector = new Point(orthoVector.x / length, orthoVector.y / length);
		Point finalVector = new Point(normOrthoVectorX * 20, normOrthoVectorY  * 20);
		
		Point midway = new Point(p1.x + (dx/2), p1.y + (dy/2));
		
		
		
		Point controlpoint = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		Bezier bezier = new Bezier(points.getFirstPoint(), points.getLastPoint(), controlpoint, controlpoint);
		bezier.outlineShape(g);
		
//		g.drawLine(p1, controlpoint);
//		g.drawLine(controlpoint, p2);
		
		g.drawText("[label]", controlpoint);
		
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
