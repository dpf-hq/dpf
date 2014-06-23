package no.hib.dpf.editor.policies;

import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.editor.commands.constraint.DConstraintDeleteCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public class DConstraintDeletePolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object child = getHost().getModel();
		if (child instanceof DConstraint) {
			return new DConstraintDeleteCommand((DConstraint) child);
		}
		return super.createDeleteCommand(deleteRequest);
	}
}
