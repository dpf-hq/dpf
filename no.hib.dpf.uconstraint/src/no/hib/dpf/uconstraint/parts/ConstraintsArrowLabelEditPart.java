package no.hib.dpf.uconstraint.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.preferences.ConstraintsEditorPreferences;


public class ConstraintsArrowLabelEditPart extends ArrowLabelEditPart {
	private UConstraint uconstraint = null;
	
	public void setParent(EditPart parent){
		super.setParent(parent);
		DArrow dArrow = getDArrow();
		if(parent != null && dArrow != null)
			uconstraint = (UConstraint) dArrow.eContainer().eContainer().eContainer();
	}
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		DArrow model = getDArrow();
		if(uconstraint.isDeled(model))
			figure.setForegroundColor(delt);
		else if(uconstraint.isKept(model))
			figure.setForegroundColor(kept);
		else if(uconstraint.isAdded(model))
			figure.setForegroundColor(insert);
	}
	private static final Color kept = ConstraintsEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = ConstraintsEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = ConstraintsEditorPreferences.getDefault().getInsertForegroundColor();
}
