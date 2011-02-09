package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.DPFEpiConnectionFigure;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.viewmodel.SingleNodeConnection;

import org.eclipse.draw2d.IFigure;

public class VNodeSingleConnectionEditPart extends VArrowEditPart {
	
	@Override
	protected IFigure createFigure() {
		EditableLabel label = new EditableLabel(getArrow().getName());
		connectionFigure = new DPFEpiConnectionFigure(label);
		setArrowHead(connectionFigure);
		return connectionFigure;
	}
	
	public VNodeSingleConnectionEditPart() {
		super();
	}
	
	@Override
	protected SingleNodeConnection getCastedModel() {
		return (SingleNodeConnection)getModel();
	}
	
	
}
