package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

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
