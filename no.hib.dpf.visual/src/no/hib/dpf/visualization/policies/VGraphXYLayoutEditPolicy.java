package no.hib.dpf.visualization.policies;

import java.util.List;

import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;
import no.hib.dpf.editor.policies.DGraphXYLayoutEditPolicy;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.commands.VNodeCreateCommand;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

public class VGraphXYLayoutEditPolicy extends DGraphXYLayoutEditPolicy {

	EMap<DElement, VElement> maps;
	EList<VCompartment> compartments;
	
	public VGraphXYLayoutEditPolicy(EMap<DElement, VElement> maps, EList<VCompartment> compartments) {
		this.maps = maps;
		this.compartments = compartments;
	}
	
	/*
	 *Change size and location of DNode
	 */
	@Override
	protected Command createChangeConstraintCommand(ChangeBoundsRequest request, EditPart child, Object constraint) {
		return super.createChangeConstraintCommand(request, child, constraint);
	}
	
	@Override
	public void eraseSourceFeedback(Request request) {
		super.eraseSourceFeedback(request);
	}
	
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Object childClass = request.getNewObjectType();
		Rectangle rectangle = (Rectangle) getConstraintFor(request);
		if (childClass == DNode.class) {
			DNode node = (DNode)request.getNewObject();
			node.setLocation(rectangle.getCenter());
			// return a command that can add a Shape to a DPFDiagram
			return new VNodeCreateCommand(node, ((DGraph)getHost().getModel()), maps, compartments);
		}
		return super.getCreateCommand(request);
	} 
	public List<DNodeEditPart> getDNodeEditParts(DGraphEditPart parent, DNode type){
		return super.getDNodeEditParts(parent, type);
	}
	
	public List<DDataNodeEditPart> getDDataNodeEditParts(DGraphEditPart parent, DDataNode type){
		return super.getDDataNodeEditParts(parent, type);
	}
	
	@Override
	public EditPart getTargetEditPart(Request request) {
		return super.getTargetEditPart(request);

	}
	
	@Override
	public void showSourceFeedback(Request request) {
		super.showSourceFeedback(request);
	}
}