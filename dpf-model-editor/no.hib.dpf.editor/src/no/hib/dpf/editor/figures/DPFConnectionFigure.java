package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class DPFConnectionFigure extends PolylineConnection implements RoutableFigure {
		
	
	@Override
	protected void outlineShape(Graphics g) {
		
		super.outlineShape(g);
		counter++;
//		System.out.println(Integer.toString(counter) + ": Outlines Line figure");
	}
	
	private static int counter = 0;

	@Override
	public int getRoutingPriority() {
		return 5;
	}
	
}
