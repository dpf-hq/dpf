package protoedit.editparts.tree;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import protoedit.commands.DeleteReferenceCommand;
import protomodel.Reference;

public class ReferenceComponentEditPolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		System.out.println("createDeleteCommand: " + getHost().getModel());
		return new DeleteReferenceCommand((Reference) getHost().getModel());
	}
}
