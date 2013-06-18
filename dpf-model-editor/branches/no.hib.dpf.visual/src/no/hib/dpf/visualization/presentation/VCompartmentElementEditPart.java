package no.hib.dpf.visualization.presentation;

import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.figures.EditableLabel;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

public class VCompartmentElementEditPart extends GraphicalEditPartWithListener {

	
	public VCompartmentElementEditPart() {
	}
	
	@Override
	protected IFigure createFigure() {
		return new EditableLabel(getNodeLabelName());
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}
	
	protected DNode getDiagramModel(){ 
		return ((VCompartmentElement)getModel()).getDNode();
	}

	public DNode getDNode(){
		return ((VCompartmentElement)getModel()).getDNode();
	}

	public Node getDPFNode(){
		DNode dnode = getDNode();
		if(dnode != null)
			return dnode.getNode();
		return null;
	}

	public DNode getDType(){
		DNode model = getDNode();
		if(model != null)
			return model.getDType();
		return null;
	}
	
	public Node getType(){
		Node model = getDPFNode();
		if(model != null)
			return model.getTypeNode();
		return null;
	}

	private String getNodeLabelName() {
		String result = "";
		if(getDPFNode().getName() != null)
			result += getDPFNode().getName();
		Node type = getType();
		if (type != null && type.getName() != null) 
			result += " : " + type.getName();
		return result;
	}

}
