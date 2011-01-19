package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.geometry.Rectangle;


public class DPFEpiConnectionFigure extends DPFConnectionFigure {
	
	public DPFEpiConnectionFigure(EditableLabel label) {
		super(label);
	}
	@Override
	public int getRoutingPriority() {
		return super.getRoutingPriority() + 1;
	}
		
	public Rectangle getOwnerBounds() {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof BasicRectangleFigure)) {
			return ((BasicRectangleFigure)getSourceAnchor().getOwner()).getBounds().getCopy();
		}
		return null;
	}

}
