package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.DArrow;
import no.hib.dpf.editor.model.DConstraint;
import no.hib.dpf.editor.model.commands.MultipleArrowConstraintCreateCommand;
import no.hib.dpf.editor.parts.ArrowEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;
import no.hib.dpf.metamodel.Graph;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointlyInjectiveConstraintAction extends CreateConstraintAction {
		
	public static final String ID = "no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction";
	
	public CreateJointlyInjectiveConstraintAction(IWorkbenchPart part, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph, constraintProperties);
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ArrowEditPart> connectionEditParts, List<NodeEditPart> shapeEditParts) {
		return new MultipleArrowConstraintCreateCommand((DArrow)connectionEditParts.get(0).getModel(), (DArrow)connectionEditParts.get(1).getModel(), DConstraint.ConstraintType.JOINTLY_INJECTIVE, createIDObject());
	}
	
	
}
