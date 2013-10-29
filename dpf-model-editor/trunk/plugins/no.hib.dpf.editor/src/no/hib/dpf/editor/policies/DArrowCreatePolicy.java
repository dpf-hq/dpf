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
		DNode dNode = (DNode) getHost().getModel();
		DArrow dArrow = (DArrow) request.getNewObject();
		if(dArrow.getDType().getDTarget() != dNode.getDType()){
			return null;
		}
		if(cmd != null)
			cmd.setTarget(dNode);
		return cmd;
	}

	protected Command getConnectionCreateCommand( CreateConnectionRequest request) {

		DNode source = (DNode) getHost().getModel();
		Object objectType = request.getNewObjectType();
		DArrowCreateCommand cmd = null;
		if (objectType == DArrow.class) {
			DArrow darrow = (DArrow) request.getNewObject();
			if(darrow.getDType().getDSource() == source.getDType())
				cmd = new DArrowCreateCommand(source, darrow);
		}
		request.setStartCommand(cmd);
		return cmd;
	}

	protected Command getReconnectSourceCommand( ReconnectRequest request) {
		Object model = request.getConnectionEditPart().getModel();
		if(model instanceof DArrow){
			DArrow conn = (DArrow) model;
			DNode newSource = (DNode) getHost().getModel();
			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
			cmd.setNewSource(newSource);
			return cmd;
		}
		return null;
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
