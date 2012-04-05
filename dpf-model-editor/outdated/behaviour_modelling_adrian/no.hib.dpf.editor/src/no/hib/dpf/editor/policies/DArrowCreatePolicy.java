package no.hib.dpf.editor.policies;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.ConnectionReconnectCommand;
import no.hib.dpf.editor.commands.DArrowCreateCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

public class DArrowCreatePolicy extends GraphicalNodeEditPolicy {

	protected Command getConnectionCompleteCommand( CreateConnectionRequest request) {
		DArrowCreateCommand cmd = (DArrowCreateCommand) request.getStartCommand();
		if(cmd != null)
			cmd.setTarget((DNode) getHost().getModel());
		return cmd;
	}

	protected Command getConnectionCreateCommand( CreateConnectionRequest request) {

		DNode source = (DNode) getHost().getModel();
		Object objectType = request.getNewObjectType();
		DArrowCreateCommand cmd = null;
		if (objectType == DArrow.class) {
			DArrow darrow = (DArrow) request.getNewObject();
			cmd = new DArrowCreateCommand(source, darrow);
		}
		request.setStartCommand(cmd);
		return cmd;
	}

	protected Command getReconnectSourceCommand( ReconnectRequest request) {
		DArrow conn = (DArrow) request.getConnectionEditPart() .getModel();
		DNode newSource = (DNode) getHost().getModel();
		ConnectionReconnectCommand cmd = new ConnectionReconnectCommand( conn);
		cmd.setNewSource(newSource);
		return cmd;
	}

	protected Command getReconnectTargetCommand( ReconnectRequest request) {
		Object model = request.getConnectionEditPart().getModel();
		if(model instanceof DArrow){
			DArrow conn = (DArrow) model;
			DNode newTarget = (DNode) getHost().getModel();
			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
			cmd.setNewTarget(newTarget);
			return cmd;
		}
		return null;
	}
}
