package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 * @author oyvind
 *
 */
public class DPFConnectionFigure extends PolylineConnection implements RoutableFigure {
		
	
	private EditableLabel label;

	public EditableLabel getLabel() {
		return label;
	}

	public DPFConnectionFigure(EditableLabel label) {
	
		this.label = label;
		label.setForegroundColor(ColorConstants.black);
		add(label, new ConnectionLocator(this, ConnectionLocator.MIDDLE));
	}
	
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
