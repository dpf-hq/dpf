package no.hib.dpf.visualization.policies;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.ConnectionReconnectCommand;
import no.hib.dpf.editor.commands.DArrowCreateCommand;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.visualization.figures.NodeFigure;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
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
	public void showSourceFeedback(Request request) {
		Object type = request.getType();
		if ((REQ_CONNECTION_START.equals(type) || REQ_CONNECTION_END.equals(type))
				&& request instanceof CreateConnectionRequest){
			CreateConnectionRequest create = (CreateConnectionRequest) request;
			
			EditPart target = create.getTargetEditPart();
			DNodeEditPart host = (DNodeEditPart) getHost();
			EditPart source = create.getSourceEditPart();
			if(source == host)
				super.showSourceFeedback(request);
			NodeFigure figure = (NodeFigure) host.getFigure();
			if(target instanceof DGraphEditPart){
				if(REQ_CONNECTION_START.equals(type))
					figure.showFeedBack(1);
				else if(REQ_CONNECTION_END.equals(type)){
					DArrow arrow = (DArrow) create.getNewObject();
					if(!(create.getSourceEditPart() == host && host.getDType() != arrow.getDType().getDTarget()))
						figure.showFeedBack(2);
				}
			}else if(target instanceof DNodeEditPart){
				DNode dType = host.getDType();
				DGraphEditPart parent = (DGraphEditPart) host.getParent();
				List<DNodeEditPart> result = new ArrayList<DNodeEditPart>();
				for(Object child : parent.getChildren()){
					if(child instanceof DNodeEditPart){
						DNode dNode = ((DNodeEditPart) child).getDNode();
						if(!(dNode instanceof DConstraintNode) && dNode.getDType() == dType)
							result.add((DNodeEditPart) child);
					}
				}
				result.remove(target);
				for(DNodeEditPart iter : result){
					NodeFigure figure1 = (NodeFigure) iter.getFigure();
					figure1.showFeedBack(0);
				}
				figure.showFeedBack(0);
			}
		}
	}
	public void eraseSourceFeedback(Request request){
		if ((REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType()))
				&& request instanceof CreateConnectionRequest){
			super.eraseSourceFeedback(request);
			NodeFigure figure = (NodeFigure) ((DNodeEditPart) getHost()).getFigure();
			figure.showFeedBack(0);
		}
	}
}
