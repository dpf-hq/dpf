package no.hib.dpf.visualization.policies;

import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.commands.ChildDNodeCreateCommand;
import no.hib.dpf.visualization.presentation.DPFNodeEditPart;

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
		DPFNodeEditPart editpart =(DPFNodeEditPart)getHost();
		Object childClass = request.getNewObjectType();
		if (childClass == VCompartmentElement.class) {
			VCompartmentElement node = (VCompartmentElement)request.getNewObject();
			node.getDNode().setLocation(editpart.getDNode().getLocation());
			// return a command that can add a Shape to a DPFDiagram
			for(VCompartment compartment : editpart.getCompartments()) {
				if(compartment.getName().equals(node.getDNode().getNode().getTypeName()))
					return new ChildDNodeCreateCommand(node.getDNode(), editpart.getDNode(), compartment, editpart.getDNode().getDGraph());
			}
		}
		return null;
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
