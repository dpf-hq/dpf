package no.hib.dpf.editor.policies;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.DNodeCreateCommand;
import no.hib.dpf.editor.commands.DNodeMoveCommand;
import no.hib.dpf.editor.commands.DNodeResizeCommand;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;

/**
 * EditPolicy for the Figure used by this edit part. Children of
 * XYLayoutEditPolicy can be used in Figures with XYLayout.
 * 
 * @author Elias Volanakis
 */
public class DGraphXYLayoutEditPolicy extends XYLayoutEditPolicy {

	private List<DNodeEditPart> updatedDNodeEditParts = null;

	/*
	 *Change size and location of DNode
	 */
	protected Command createChangeConstraintCommand(
			ChangeBoundsRequest request, EditPart child, Object constraint) {
		Object type = request.getType();
		if (constraint instanceof Rectangle) {
			// make sure the Request is of a type we support:
			boolean move = RequestConstants.REQ_MOVE.equals(type) || RequestConstants.REQ_ALIGN_CHILDREN.equals(type) || RequestConstants.REQ_MOVE_CHILDREN.equals(type);
			boolean size = RequestConstants.REQ_RESIZE.equals(type) || RequestConstants.REQ_RESIZE_CHILDREN.equals(type);
			if(move && (child instanceof DComposedNodePart || child instanceof DNodeEditPart))
			{
				Point newLocation = ((Rectangle)constraint).getLocation();
				if(child instanceof DComposedNodePart){
					DComposedNodePart compose = (DComposedNodePart) child;
					compose.getCrossPoint(newLocation);
					if(compose.getBound() != null)
						newLocation = newLocation.translate(compose.getBound().getCenter().getNegated());
				}
				return new DNodeMoveCommand((DNode)child.getModel(), newLocation);
			}
			if(size && child instanceof DNodeEditPart)
				return new DNodeResizeCommand((DNode)child.getModel(), ((Rectangle)constraint).getSize());
		}
		return super.createChangeConstraintCommand(request, child, constraint);
	}
	
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			if(getHost() instanceof DGraphEditPart){
				if(updatedDNodeEditParts != null)
					for(DNodeEditPart node : updatedDNodeEditParts)
						node.eraseSourceFeedback(request);
							updatedDNodeEditParts = null;
			}
		}
	}
	
	public void eraseTargetFeedback(Request request) {
		eraseSourceFeedback(request);
		super.eraseTargetFeedback(request);
	}

	protected Command getCreateCommand(CreateRequest request) {
		Object childClass = request.getNewObjectType();
		Rectangle rectangle = (Rectangle) getConstraintFor(request);
		if (childClass == DNode.class) {
			DNode node = (DNode)request.getNewObject();
			node.setLocation(rectangle.getCenter());
			// return a command that can add a Shape to a DPFDiagram
			return new DNodeCreateCommand(node, ((DGraph)getHost().getModel()));
		}
		return null;
	} 
	public List<DNodeEditPart> getDNodeEditParts(DGraphEditPart parent, DNode type){
		List<DNodeEditPart> result = new ArrayList<DNodeEditPart>();
		for(Object child : parent.getChildren()){
			if(child instanceof DNodeEditPart){
				DNode dNode = ((DNodeEditPart) child).getDNode();
				if(!(dNode instanceof DConstraintNode) && dNode.getDType() == type)
					result.add((DNodeEditPart) child);
			}
		}
		return result;

	}
	public EditPart getTargetEditPart(Request request) {
		EditPart part = super.getTargetEditPart(request);
		if(part == null)
			if(REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType()))
				return getHost();
		return part;

	}
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			CreateConnectionRequest create = (CreateConnectionRequest) request;
			EditPart host = getHost();
			if(host instanceof DGraphEditPart){
				DGraphEditPart graphEditpart = (DGraphEditPart) host;
				DArrow arrow = (DArrow) create.getNewObject();
				if(REQ_CONNECTION_START.equals(request.getType())){
					updatedDNodeEditParts = getDNodeEditParts(graphEditpart, arrow.getDType().getDSource());
					for(DNodeEditPart node : updatedDNodeEditParts)
						node.showSourceFeedback(request);
				}else if(REQ_CONNECTION_END.equals(request.getType())){
					updatedDNodeEditParts = getDNodeEditParts(graphEditpart, arrow.getDType().getDTarget());
					for(DNodeEditPart node : updatedDNodeEditParts)
						node.showSourceFeedback(request);
				}
			}
		}
	}

}