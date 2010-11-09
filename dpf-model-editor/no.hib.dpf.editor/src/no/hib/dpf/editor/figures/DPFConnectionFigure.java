package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.ShapeConnectionEditPart;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.PointList;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class DPFConnectionFigure extends PolylineConnection {
		
	private ShapeConnectionEditPart editPart;
	
	
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
//		System.out.println("LINE Y-Points: " + p1.y + ", " + p2.y);
	}
	
	private boolean changedPoints = false;
	
	public void setChanged(boolean newValue) {
		changedPoints = newValue;
	}

	@Override
	public void setPoints(PointList points) {
		PointList current = this.getPoints();
		if (current.size() !=  points.size()) {
			changedPoints = true;
		} else {
			for (int i = 0; i < current.size(); i++) {
				if (!(current.getPoint(i).equals(points.getPoint(i)))) {
					changedPoints = true;					
				}
			}
		}
		super.setPoints(points);
	}
	
	public void fireRouted() {
		if (changedPoints) {
			// Notify any constraints to this figure's part
			changedPoints = false;
			editPart.updateConstraints();
		}
	}
	
	public void setEditPart(ShapeConnectionEditPart editPart) {
		this.editPart = editPart;
	}


	private static int counter = 0;
	
}
