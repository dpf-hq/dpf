package no.hib.dpf.uconstraint.parts;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.requests.CreateRequest;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.DNodeCreateCommand;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.policies.DArrowCreateFeedBackPolicy;
import no.hib.dpf.editor.policies.DGraphXYLayoutEditPolicy;
import no.hib.dpf.uconstraint.UConstraint;

public class ConstraintsDGraphEditPart extends DGraphEditPart {

	protected void createEditPolicies() {
		// disallows the removal of this edit part from its parent
		// handles constraint changes (e.g. moving and/or resizing) of model
		// elements
		// and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DGraphXYLayoutEditPolicy(){
			protected Command getCreateCommand(CreateRequest request) {
				Object childClass = request.getNewObjectType();
				Rectangle rectangle = (Rectangle) getConstraintFor(request);
				if (childClass == DNode.class) {
					DNode node = (DNode)request.getNewObject();
					node.setLocation(rectangle.getCenter());
					// return a command that can add a Shape to a DPFDiagram
					return new TransformDNodeCreateCommand(node, ((DGraph)getHost().getModel()));
				}
				return null;
			}
		});
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DArrowCreateFeedBackPolicy());
		// Shows a snap line when nodes align:
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy()); //$NON-NLS-1$
	}
	class TransformDNodeCreateCommand extends DNodeCreateCommand{
		UConstraint uconstraint = null;
		public TransformDNodeCreateCommand(DNode newVNode, DGraph parent) {
			super(newVNode, parent);
			uconstraint = (UConstraint) parent.eContainer().eContainer();
		}
		public void execute() {
			super.execute();
			uconstraint.setKept(newObject, true);
		}
		public void undo(){
			uconstraint.setKept(newObject, false);
			super.undo();
		}
	}
}
