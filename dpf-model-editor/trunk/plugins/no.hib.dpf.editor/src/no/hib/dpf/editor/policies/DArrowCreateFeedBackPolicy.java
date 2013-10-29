package no.hib.dpf.editor.policies;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.swt.graphics.Color;

public class DArrowCreateFeedBackPolicy extends GraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionCompleteCommand( CreateConnectionRequest request) { return null; }

	@Override
	protected Command getConnectionCreateCommand( CreateConnectionRequest request) { return null; }

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) { return null; }

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) { return null; }

	public void showTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			Object newObject = ((CreateConnectionRequest) request).getNewObject();
			if(newObject instanceof DArrow){
				DArrow dArrow = (DArrow) newObject;
				DNode dType = null; 
				boolean showSource = true;
				if(REQ_CONNECTION_START.equals(request.getType()))
					dType = dArrow.getDType().getDSource();
				if(REQ_CONNECTION_END.equals(request.getType())){
					dType = dArrow.getDType().getDTarget();
					showSource = false;
				}
				if(dType != null){
					DGraphEditPart editPart = (DGraphEditPart) getHost();
					for(Object child : editPart.getChildren()){
						DNodeEditPart dNode = (DNodeEditPart) child;
						if(dNode.getDType() == dType){
							lists.add(dNode);
							dNode.getFigure().setBackgroundColor(showSource ? source : target);
						}
					}
				}
			}
		}
	}
	private static final Color source = DPFEditorPreferences.getDefault().getArrowSourceColor();
	private static final Color target = DPFEditorPreferences.getDefault().getArrowTargetColor();
	
	public void eraseTargetFeedback(Request request) {
		if(request instanceof CreateConnectionRequest){
			if(!lists.isEmpty()){
				for(DNodeEditPart iter : lists)
					iter.refreshVisuals();
				lists.clear();
			}
		}
	}
	List<DNodeEditPart> lists = new ArrayList<DNodeEditPart>();

}
