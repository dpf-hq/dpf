package no.hib.dpf.editor.parts.constraint;


import no.hib.dpf.editor.figures.ConstraintConnection;
import no.hib.dpf.editor.parts.node.DComposedNodePart;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;

public class DConstraintFromNodeEditPart extends DConstraintEditPart {

	@Override
	protected IFigure createFigure() {
		return new ConstraintConnection(this);
	}

	//update the source edit part, which is a DConstraintNodeEditPart
	@Override
	public void setSource(EditPart source) {
		EditPart old = getSource();
		super.setSource(source);
		EditPart editPart = getSource();
		if(old != source && editPart instanceof DComposedNodePart && getTarget() instanceof EditPart){
			((DComposedNodePart)editPart).add(getTarget());
			editPart.refresh();
		}
		if(old != source && old instanceof DComposedNodePart && getTarget() instanceof EditPart){
			((DComposedNodePart)old).remove(getTarget());
		}
	}
	//update the source edit part, which is a DConstraintNodeEditPart
	@Override
	public void setTarget(EditPart target){
		EditPart old = getTarget();
		super.setTarget(target);
		EditPart editPart = getSource();
		if(old != target && editPart instanceof DComposedNodePart && target instanceof EditPart){
			((DComposedNodePart)editPart).add(getTarget());
			editPart.refresh();
		}
		if(old != target && editPart instanceof DComposedNodePart && old instanceof EditPart){
			((DComposedNodePart)editPart).remove(old);
		}
	}
}
