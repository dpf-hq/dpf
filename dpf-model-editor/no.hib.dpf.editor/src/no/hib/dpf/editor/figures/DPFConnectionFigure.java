package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.ShapeConnectionEditPart;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class DPFConnectionFigure extends PolylineConnection {
		
	/**
	 * Called by the anchors of this connection when they have moved,
	 * revalidating this polyline connection.
	 * 
	 * @param anchor
	 *            the anchor that moved
	 */
	@Override
	public void anchorMoved(ConnectionAnchor anchor) {
		System.out.println(Integer.toString(counter) + ": revalidates Line figure");
		revalidate();
	}
	
	@Override
	protected void outlineShape(Graphics g) {
//		PointList points = getPoints();
//		Point p1 = points.getFirstPoint();
//		Point p2 = points.getLastPoint();
//		System.out.println("LINE Y-Points: " + p1.y + ", " + p2.y);

		
		super.outlineShape(g);
//		System.out.println("---- ");		
		counter++;
		System.out.println(Integer.toString(counter) + ": Outlines Line figure");
		firePropertyChange(ShapeConnectionEditPart.CONNECTION_REDRAWN, null, null);
//		System.out.println("LINE Y-Points: " + p1.y + ", " + p2.y);
	}
	

	private static int counter = 0;
	
}
