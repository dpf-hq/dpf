package no.hib.dpf.visualization.presentation;

import java.util.List;

import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.TextCellEditorLocator;
import no.hib.dpf.editor.parts.TextDirectEditManager;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.figures.CompositeNodeFigure;
import no.hib.dpf.visualization.figures.EditableLabel;
import no.hib.dpf.visualization.figures.NodeFigure;
import no.hib.dpf.visualization.policies.DArrowCreatePolicy;
import no.hib.dpf.visualization.policies.VNodeLayoutPolicy;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

public class DPFNodeEditPart extends DNodeEditPart {

	VNode visual = null;
	EList<VCompartment> compartments = null;
	EMap<IDObject, VElement> maps;
	
	public DPFNodeEditPart(VNode vElement, EList<VCompartment> nodeCompartments, EMap<IDObject, VElement> maps) {
		visual = vElement;
		compartments = nodeCompartments;
		this.maps = maps;
	}
	
	protected void createEditPolicies() {
		// allow adding of childs in compartments
		if(visual != null && visual.isComposite())
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new VNodeLayoutPolicy());
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DArrowCreatePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}
	
	protected IFigure createFigure() {
		IFigure figure;
		if(visual != null && visual.isComposite()) {
			figure = new CompositeNodeFigure(new EditableLabel(getNodeLabelName()));
		} else
			figure = new NodeFigure(new EditableLabel(getNodeLabelName()));
		return figure;
	}
	
	public IFigure getContentPane(){
		if(visual != null && visual.isComposite())
			return ((CompositeNodeFigure)getFigure()).getContentPane();
		return super.getContentPane();
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
	public EList<VCompartment> getCompartments() {
		return compartments;
	}
	@Override
	protected List<VCompartment> getModelChildren() {
		return compartments; 
	}
	
	// Hide connections to contained nodes
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDNode().getDOutgoings());
		sources.addAll(getDNode().getConstraintsFrom());
		
		for(DArrow arrow : getDNode().getDOutgoings()) {
			VElement aElement = maps.get(arrow.getArrow().getTypeArrow());
			if(aElement instanceof VArrow && ((VArrow)aElement).isComposed())
				sources.remove(arrow);
		}
		
		return sources;
	}
}