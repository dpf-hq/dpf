package no.hib.dpf.transform.parts;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.editor.commands.DArrowDeleteCommand;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;
import no.hib.dpf.transform.presentation.ActionEditPolicy;

public class TransformDArrowEditPart extends DArrowEditPart {
	private Production production = null;	
	
	private static final Color kept = TransformEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = TransformEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = TransformEditorPreferences.getDefault().getInsertForegroundColor();
	public void refreshVisuals(){
		super.refreshVisuals();
		DArrow model = getDArrow();
		if(production.isDeled(model))
			figure.setForegroundColor(delt);
		else if(production.isKept(model))
			figure.setForegroundColor(kept);
		else if(production.isAdded(model))
			figure.setForegroundColor(insert);
		for(Object iter : getChildren()){
			if(iter instanceof TransformArrowLabelEditPart)
				((TransformArrowLabelEditPart)iter).refreshVisuals();
		}
	}
	
	public void setParent(EditPart parent){
		DArrow dArrow = getDArrow();
		if(parent != null && dArrow != null)
			production = (Production) dArrow.eContainer().eContainer().eContainer();
		super.setParent(parent);
	}
	
	@Override
	protected void createEditPolicies() {
		refreshBendpointEditPolicy();

		// Selection handle edit policy.
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element		
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				return new TranformDArrowDeleteCommand(getDArrow());
			}
		});
		installEditPolicy("action", new ActionEditPolicy());
	}
	
	class TranformDArrowDeleteCommand extends DArrowDeleteCommand{
		int index = 0;
		Production production = null;
		public TranformDArrowDeleteCommand(DArrow conn) {
			super(conn);
			production = (Production) conn.eContainer().eContainer().eContainer();
			if(!production.isKept(conn))
				index = production.isAdded(conn) ? 1 : 2;
		}
		public void execute() {
			super.execute();
			production.setKept(connection, false);
		}
		public void undo(){
			super.undo();
			if(index == 0)
				production.setKept(connection, true);
			else if(index == 1)
				production.setAdded(connection);
			else
				production.setDeled(connection);
		}
	}
}
