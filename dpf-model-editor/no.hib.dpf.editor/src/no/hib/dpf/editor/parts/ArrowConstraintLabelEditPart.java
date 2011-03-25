package no.hib.dpf.editor.parts;


public class ArrowConstraintLabelEditPart extends ArrowLabelEditPart {

	@Override
	protected boolean getVisible() {
		return true;
	}

	@Override
	protected boolean placeLabelAtEnd() {
		return true;
	}

	@Override
	protected String getFullName() {
		return getConnectionModel().getLabelText();
	}
	

}
