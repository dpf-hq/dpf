package no.hib.dpf.uconstraint.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.DArrowCreateCommand;
import no.hib.dpf.editor.commands.DNodeDeleteCommand;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.policies.DArrowCreatePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.policies.NodeComponentEditPolicy;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.preferences.ConstraintsEditorPreferences;
import no.hib.dpf.uconstraint.presentation.ActionEditPolicy;

public class ConstraintsDNodeEditPart extends DNodeEditPart{
	private UConstraint uconstraint = null;

	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy(){
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				Object child = getHost().getModel();
				if (child instanceof DNode) {
					return new ConstraintsDNodeDeleteCommand((DNode) child);
				}
				return super.createDeleteCommand(deleteRequest);
			}
		});
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DArrowCreatePolicy(){
			protected Command getConnectionCreateCommand( CreateConnectionRequest request) {

				DNode source = (DNode) getHost().getModel();
				Object objectType = request.getNewObjectType();
				DArrowCreateCommand cmd = null;
				if (objectType == DArrow.class) {
					DArrow darrow = (DArrow) request.getNewObject();
					if(darrow.getDType().getDSource() == source.getDType())
						cmd = new ConstraintsDArrowCreateCommand(source, darrow);
				}
				request.setStartCommand(cmd);
				return cmd;
			}
		});
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		installEditPolicy("action", new ActionEditPolicy());
	}
	class ConstraintsDNodeDeleteCommand extends DNodeDeleteCommand{
		UConstraint uconstraint;
		int index = 0;
		public ConstraintsDNodeDeleteCommand(DNode child) {
			super(child);
			uconstraint = (UConstraint) parent.eContainer().eContainer();
			if(!uconstraint.isKept(child))
				index = uconstraint.isAdded(child) ? 1 : 2;
		}
		public void execute() {
			super.execute();
			uconstraint.setKept(child, false);
		}
		
		public void undo() {
			super.undo();
			if(index == 0)
				uconstraint.setKept(child, true);
			else if(index == 1)
				uconstraint.setAdded(child);
			else
				uconstraint.setDeled(child);
		}
	}
	
	class ConstraintsDArrowCreateCommand extends DArrowCreateCommand{
		UConstraint uconstraint;
		public ConstraintsDArrowCreateCommand(DNode source, DArrow newObject) {
			super(source, newObject);
			uconstraint = (UConstraint) source.eContainer().eContainer().eContainer();
		}
		public void execute() {
			super.execute();
			uconstraint.setKept(newDArrow, true);
		}
		public void undo() {
			super.undo();
			uconstraint.setKept(newDArrow, false);
		}
	}

	public void setParent(EditPart parent){
		super.setParent(parent);
		DNode dArrow = getDNode();
		if(parent != null && dArrow != null)
			uconstraint = (UConstraint) dArrow.eContainer().eContainer().eContainer();
	}
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		DNode editObject = getDNode();
		if(uconstraint.isKept(editObject))
			figure.setBackgroundColor(kept);
		else if(uconstraint.isDeled(editObject))
			figure.setBackgroundColor(delt);
		else if(uconstraint.isAdded(editObject))
			figure.setBackgroundColor(insert);
	}
	private static final Color kept = ConstraintsEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = ConstraintsEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = ConstraintsEditorPreferences.getDefault().getInsertForegroundColor();
}
