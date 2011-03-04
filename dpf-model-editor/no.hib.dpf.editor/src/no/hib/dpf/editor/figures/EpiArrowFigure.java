package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.geometry.Rectangle;


public class EpiArrowFigure extends ArrowConnection {
	
	public EpiArrowFigure(EditableLabel label) {
		super(label);
	}
	@Override
	public int getRoutingPriority() {
		return super.getRoutingPriority() + 1;
	}
		
	public Rectangle getOwnerBounds() {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof NodeFigure)) {
			return ((NodeFigure)getSourceAnchor().getOwner()).getBounds().getCopy();
		}
		return null;
	}

}
