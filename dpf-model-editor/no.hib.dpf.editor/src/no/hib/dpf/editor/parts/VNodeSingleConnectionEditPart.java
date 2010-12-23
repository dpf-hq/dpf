package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.DPFEpiConnectionFigure;
import no.hib.dpf.editor.model.SingleNodeConnection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;

public class VNodeSingleConnectionEditPart extends VEdgeEditPart {
	
	@Override
	protected IFigure createFigure() {
		connectionFigure = new DPFEpiConnectionFigure();
		PolygonDecoration arrowHead = new PolygonDecoration();
		arrowHead.setScale(16, 6);
		connectionFigure.setTargetDecoration(arrowHead); // arrow at target endpoint
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
