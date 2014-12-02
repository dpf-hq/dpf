package no.hib.dpf.uconstraint.parts;


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
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.preferences.ConstraintsEditorPreferences;
import no.hib.dpf.uconstraint.presentation.ActionEditPolicy;

public class ConstraintsDArrowEditPart extends DArrowEditPart {
	private UConstraint uconstraint = null;	
	
	private static final Color kept = ConstraintsEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = ConstraintsEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = ConstraintsEditorPreferences.getDefault().getInsertForegroundColor();
	public void refreshVisuals(){
		super.refreshVisuals();
		DArrow model = getDArrow();
		if(uconstraint.isDeled(model))
			figure.setForegroundColor(delt);
		else if(uconstraint.isKept(model))
			figure.setForegroundColor(kept);
		else if(uconstraint.isAdded(model))
			figure.setForegroundColor(insert);
		for(Object iter : getChildren()){
			if(iter instanceof ConstraintsArrowLabelEditPart)
				((ConstraintsArrowLabelEditPart)iter).refreshVisuals();
		}
	}
	
	public void setParent(EditPart parent){
		DArrow dArrow = getDArrow();
		if(parent != null && dArrow != null)
			uconstraint = (UConstraint) dArrow.eContainer().eContainer().eContainer();
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
		UConstraint uconstraint = null;
		public TranformDArrowDeleteCommand(DArrow conn) {
			super(conn);
			uconstraint = (UConstraint) conn.eContainer().eContainer().eContainer();
			if(!uconstraint.isKept(conn))
				index = uconstraint.isAdded(conn) ? 1 : 2;
		}
		public void execute() {
			super.execute();
			uconstraint.setKept(connection, false);
		}
		public void undo(){
			super.undo();
			if(index == 0)
				uconstraint.setKept(connection, true);
			else if(index == 1)
				uconstraint.setAdded(connection);
			else
				uconstraint.setDeled(connection);
		}
	}
}
