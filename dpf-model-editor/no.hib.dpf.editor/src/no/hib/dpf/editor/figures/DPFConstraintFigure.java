package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.Graphics;
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
		
		super.outlineShape(g);
		PointList points = getPoints();
		drawAnchorBlob(g, buildPointBox(points.getFirstPoint()));
		drawAnchorBlob(g, buildPointBox(points.getLastPoint()));
	}
	
	private Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}
 	
	private void drawAnchorBlob(Graphics g, Rectangle r) {
//		Color c = new Color()
//		g.setForegroundColor(Color.)
		g.fillArc(r.x, r.y, r.width, r.height, 0, 360);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		Rectangle bounds = super.getBounds();
		bounds.expand(6, 6);
		return bounds;
	}
	
	


	
}
