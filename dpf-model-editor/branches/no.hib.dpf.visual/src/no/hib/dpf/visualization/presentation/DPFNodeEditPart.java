package no.hib.dpf.visualization.presentation;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import no.hib.dpf.core.Node;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.TextCellEditorLocator;
import no.hib.dpf.editor.parts.TextDirectEditManager;
import no.hib.dpf.visual.VCompositeElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.impl.VisualFactoryImpl;
import no.hib.dpf.visualization.figures.CompositeNodeFigure;
import no.hib.dpf.visualization.figures.EditableLabel;
import no.hib.dpf.visualization.figures.NodeFigure;
import no.hib.dpf.visualization.policies.VNodeLayoutPolicy;

public class DPFNodeEditPart extends DNodeEditPart {

	VNode visual = null;
	EList<Node> children = null;
	public DPFNodeEditPart(VNode vElement, EList<Node> children) {
		visual = vElement;
		this.children = children;
	}
	
	protected void createEditPolicies() {
		super.createEditPolicies();
		//installEditPolicy(EditPolicy.LAYOUT_ROLE, new VNodeLayoutPolicy());
	}
	
	protected IFigure createFigure() {
		IFigure figure;
		if(visual.isComposite()) {
			figure = new CompositeNodeFigure(new EditableLabel(getNodeLabelName()), children);
			VisualFactory factory = new VisualFactoryImpl();
			/*for(Node child : children) {
				VCompositeElement compartment = factory.createVCompositeElement();
				compartment.setName(child.getName());
				visual.addCompartment(compartment);
			}*/
		} else
			figure = new NodeFigure(new EditableLabel(getNodeLabelName()));
		return figure;
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
	
	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			TextDirectEditManager manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator(((NodeFigure)getFigure()).getNameLabel()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}
	private void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
		label.revalidate();
	}
	protected void refreshVisuals() {
		NodeFigure figure = (NodeFigure)getFigure();
		DPFEditor editor = getEditor();
		if(editor != null){
			boolean flag = editor.isMakerExisting(getDNode().getNode());
			if(figure.getErrorImageFlag() != flag)
				figure.setErrorImageFlag(flag);
		}
		getFigure().setBounds(new Rectangle(getDiagramModel().getLocation(), getDiagramModel().getSize()));
		refreshLabel();
		//			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent
		// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
		// this figure and will not draw it correctly.
	}
}
