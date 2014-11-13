package no.hib.dpf.visualization.presentation;

import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.parts.TextCellEditorLocator;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.figures.EditableLabel;
import no.hib.dpf.visualization.policies.NameDirectEditPolicy;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

public class VCompartmentElementEditPart extends GraphicalEditPartWithListener {
    
    protected void listen(){
		super.listen();
		addUIAdapter(getDPFNode(), modelListener);
	}
	
	protected void unlisten(){
		removeUIAdapter(getDPFNode(), modelListener);
		super.unlisten();
	}
	
	@Override
	protected void handleModelChanged(Notification msg) {
		refreshVisuals();
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

	protected void refreshVisuals() {
		EditableLabel figure = (EditableLabel)getFigure();
		figure.setText(getNodeLabelName());
		figure.setVisible(true);
		figure.revalidate();
	}
	
	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			TextDirectEditManager manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator((EditableLabel)getFigure()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}
}
