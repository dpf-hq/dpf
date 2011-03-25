package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.preferences.DPFEditorPreferences;

public class ArrowNameLabelEditPart extends ArrowLabelEditPart {

	@Override
	protected boolean getVisible() {
		return DPFEditorPreferences.getDefault().getDisplayArrows();
	}

	@Override
	protected boolean placeLabelAtEnd() {
		return false;
	}

	@Override
	protected String getFullName() {
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames()) {
			return getConnectionModel().getLabelText() + " : " + ((ArrowEditPart) getParent()).getArrow().getTypeName();
		} else {
			return getConnectionModel().getLabelText();
		}
	}
	
}
