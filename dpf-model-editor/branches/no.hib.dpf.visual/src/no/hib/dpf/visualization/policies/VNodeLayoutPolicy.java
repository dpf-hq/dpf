package no.hib.dpf.visualization.policies;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visualization.commands.ChildDNodeCreateCommand;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

public class VNodeLayoutPolicy extends LayoutEditPolicy {

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Object childClass = request.getNewObjectType();
		if (childClass == DNode.class) {
			DNode node = (DNode)request.getNewObject();
			// return a command that can add a Shape to a DPFDiagram
			return new ChildDNodeCreateCommand(node, ((DNode)getHost().getModel()));
		}
		return null;
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
