package no.hib.dpf.editor.policies;

import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.DConstraintDeleteCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public class DConstraintDeletePolicy extends ComponentEditPolicy {
	
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object child = getHost().getModel();
		if (child instanceof DOffset) {
			return new DConstraintDeleteCommand((DConstraint) ((DOffset) child).eContainer());
		}
		return super.createDeleteCommand(deleteRequest);
	}
}
