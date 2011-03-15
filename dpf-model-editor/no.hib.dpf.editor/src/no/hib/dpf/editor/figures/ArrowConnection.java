package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class ArrowConnection extends PolylineConnection implements RoutableFigure {
	
	@Override
	protected void outlineShape(Graphics g) {
		g.pushState();
		g.setAntialias(SWT.ON); //FIXME: this is a hack, it should really be set globally somewhere? 		
		super.outlineShape(g);
		g.popState();
	}

	@Override
	public int getRoutingPriority() {
		return 5;
	}
	
}
