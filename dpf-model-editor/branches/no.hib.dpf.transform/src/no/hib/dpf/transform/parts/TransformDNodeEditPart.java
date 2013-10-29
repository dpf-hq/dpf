package no.hib.dpf.transform.parts;

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
import no.hib.dpf.editor.parts.NodeComponentEditPolicy;
import no.hib.dpf.editor.policies.DArrowCreatePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;
import no.hib.dpf.transform.presentation.ActionEditPolicy;

public class TransformDNodeEditPart extends DNodeEditPart{
	private Production production = null;

	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy(){
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				Object child = getHost().getModel();
				if (child instanceof DNode) {
					return new TransformDNodeDeleteCommand((DNode) child);
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
						cmd = new TransformDArrowCreateCommand(source, darrow);
				}
				request.setStartCommand(cmd);
				return cmd;
			}
		});
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		installEditPolicy("action", new ActionEditPolicy());
	}
	class TransformDNodeDeleteCommand extends DNodeDeleteCommand{
		Production production;
		int index = 0;
		public TransformDNodeDeleteCommand(DNode child) {
			super(child);
			production = (Production) parent.eContainer().eContainer();
			if(!production.isKept(child))
				index = production.isAdded(child) ? 1 : 2;
		}
		public void execute() {
			super.execute();
			production.setKept(child, false);
		}
		
		public void undo() {
			super.undo();
			if(index == 0)
				production.setKept(child, true);
			else if(index == 1)
				production.setAdded(child);
			else
				production.setDeled(child);
		}
	}
	
	class TransformDArrowCreateCommand extends DArrowCreateCommand{
		Production production;
		public TransformDArrowCreateCommand(DNode source, DArrow newObject) {
			super(source, newObject);
			production = (Production) source.eContainer().eContainer().eContainer();
		}
		public void execute() {
			super.execute();
			production.setKept(newDArrow, true);
		}
		public void undo() {
			super.undo();
			production.setKept(newDArrow, false);
		}
	}

	public void setParent(EditPart parent){
		super.setParent(parent);
		DNode dArrow = getDNode();
		if(parent != null && dArrow != null)
			production = (Production) dArrow.eContainer().eContainer().eContainer();
	}
	@Override
	public void refreshVisuals() {
		super.refreshVisuals();
		DNode editObject = getDNode();
		if(production.isKept(editObject))
			figure.setBackgroundColor(kept);
		else if(production.isDeled(editObject))
			figure.setBackgroundColor(delt);
		else if(production.isAdded(editObject))
			figure.setBackgroundColor(insert);
	}
	private static final Color kept = TransformEditorPreferences.getDefault().getPreserveForegroundColor();
	private static final Color delt = TransformEditorPreferences.getDefault().getDeleteForegroundColor();
	private static final Color insert = TransformEditorPreferences.getDefault().getInsertForegroundColor();
}
