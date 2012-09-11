package no.hib.dpf.transform.presentation;

import no.hib.dpf.editor.commands.EmptyExecutableCommand;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

public class ActionEditPolicy extends AbstractEditPolicy {

	public Command getCommand(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()))
			return MakeAddCommand(getHost());
		if (DeleteTool.REQ_MAKE_DELETE.equals(request.getType()))
			return MakeDeleteCommand(getHost());
		return null;
	}

	private Command MakeDeleteCommand(EditPart editPart) {
		if(editPart != null){
			System.out.println(editPart);
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeAddCommand(EditPart editPart) {
		if(editPart != null){
			System.out.println(editPart);
		}
		return EmptyExecutableCommand.INSTANCE;
	}
	public EditPart getTargetEditPart(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()) || DeleteTool.REQ_MAKE_DELETE.equals(request.getType()))
			return getHost();
		return null;
	}
}
