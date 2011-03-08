package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.EpiArrowConnection;
import no.hib.dpf.editor.viewmodel.SingleNodeConnection;

import org.eclipse.draw2d.IFigure;

public class SingleArrowEditPart extends ArrowEditPart {
	
	@Override
	protected IFigure createFigure() {
		EditableLabel label = new EditableLabel(getArrow().getName());
		connectionFigure = new EpiArrowConnection(label);
		setArrowHead(connectionFigure);
		return connectionFigure;
	}
	
	public SingleArrowEditPart() {
		super();
	}
	
	@Override
	protected SingleNodeConnection getCastedModel() {
		return (SingleNodeConnection)getModel();
	}
	
	
}
