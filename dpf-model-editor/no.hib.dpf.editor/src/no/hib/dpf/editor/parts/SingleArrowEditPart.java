package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.displaymodel.SingleNodeConnection;
import no.hib.dpf.editor.figures.EpiArrowConnection;

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
