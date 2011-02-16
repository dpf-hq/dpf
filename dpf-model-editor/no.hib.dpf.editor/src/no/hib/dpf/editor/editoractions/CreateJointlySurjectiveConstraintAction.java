package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.VArrowEditPart;
import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.editor.viewmodel.commands.MultipleArrowConstraintCreateCommand;
import no.hib.dpf.metamodel.Graph;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointlySurjectiveConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction";	
	
	public CreateJointlySurjectiveConstraintAction(IWorkbenchPart part, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph, constraintProperties);
	}

	@Override
	protected Command getConstraintCreateCommand(List<VArrowEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts) {
		return new MultipleArrowConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel(), (VArrow)connectionEditParts.get(1).getModel(), VConstraint.ConstraintType.JOINTLY_SURJECTIVE, createIDObject());
	}
	
	
}
