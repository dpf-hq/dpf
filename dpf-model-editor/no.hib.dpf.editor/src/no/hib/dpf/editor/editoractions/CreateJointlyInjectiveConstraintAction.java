package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.ArrowEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.editor.viewmodel.commands.MultipleArrowConstraintCreateCommand;
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
		return new MultipleArrowConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel(), (VArrow)connectionEditParts.get(1).getModel(), VConstraint.ConstraintType.JOINTLY_INJECTIVE, createIDObject());
	}
	
	
}
