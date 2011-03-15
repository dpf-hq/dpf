package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.EpiArrowConnection;
import no.hib.dpf.editor.model.SingleNodeConnection;

public class SingleArrowEditPart extends ArrowEditPart {

	@Override
	protected void createConnectionFigure() { // EditableLabel label) {
		connectionFigure = new EpiArrowConnection(); //label);
	}
	
	@Override
	protected SingleNodeConnection getCastedModel() {
		return (SingleNodeConnection)getModel();
	}
	
	
}
