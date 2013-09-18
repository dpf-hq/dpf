package no.hib.dpf.editor.displaymodel.factories;

import org.eclipse.gef.tools.ConnectionCreationTool;

public class DPFConnectionCreationTool extends ConnectionCreationTool {
	protected void showSourceFeedback() {
		if(getTargetEditPart() != null)
			getTargetEditPart().showSourceFeedback(getSourceRequest());
		super.showSourceFeedback();
	}
	protected void eraseSourceFeedback() {
		if(getTargetEditPart() != null)
			getTargetEditPart().eraseSourceFeedback(getSourceRequest());
		super.eraseSourceFeedback();
	}

}
