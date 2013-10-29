package no.hib.dpf.transform.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;


public class TransformArrowLabelEditPart extends ArrowLabelEditPart {
	private Production production = null;
	
	public void setParent(EditPart parent){
		super.setParent(parent);
		DArrow dArrow = getDArrow();
		if(parent != null && dArrow != null)
			production = (Production) dArrow.eContainer().eContainer().eContainer();
	}
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		DArrow model = getDArrow();
		if(production.isDeled(model))
			figure.setForegroundColor(delt);
		else if(production.isKept(model))
			figure.setForegroundColor(kept);
		else if(production.isAdded(model))
			figure.setForegroundColor(insert);
	}
	private static final Color kept = TransformEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = TransformEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = TransformEditorPreferences.getDefault().getInsertForegroundColor();
}
