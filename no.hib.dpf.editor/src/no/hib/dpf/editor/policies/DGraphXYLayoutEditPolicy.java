package no.hib.dpf.editor.policies;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.DNodeCreateCommand;
import no.hib.dpf.editor.commands.DNodeMoveCommand;
import no.hib.dpf.editor.commands.DNodeResizeCommand;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

/**
 * EditPolicy for the Figure used by this edit part. Children of
 * XYLayoutEditPolicy can be used in Figures with XYLayout.
 * 
 * @author Elias Volanakis
 */
public class DGraphXYLayoutEditPolicy extends XYLayoutEditPolicy {

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
				return new DNodeMoveCommand((DNode)child.getModel(), newLocation);
			}
			if(size && child instanceof DNodeEditPart)
				return new DNodeResizeCommand((DNode)child.getModel(), ((Rectangle)constraint).getSize());
		}
		return super.createChangeConstraintCommand(request, child, constraint);
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
	
	public EditPart getTargetEditPart(Request request) {
		EditPart part = super.getTargetEditPart(request);
		if(part == null)
			if(REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType()))
				return getHost();
		return part;

	}
}
