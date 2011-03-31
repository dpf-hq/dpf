package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;
import no.hib.dpf.editor.model.commands.SingleArrowConstraintCreateCommand;
import no.hib.dpf.editor.parts.ArrowEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;
import no.hib.dpf.metamodel.Graph;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateTransitiveIrreflexiveConstraintAction extends CreateConstraintAction {
	public static final String ID = "no.hib.dpf.editor.editoractions.CreateTransitiveIrreflexiveConstraintAction";
	
	public CreateTransitiveIrreflexiveConstraintAction(IWorkbenchPart part, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph, constraintProperties);
	}

	@Override
	protected Command getConstraintCreateCommand(List<ArrowEditPart> connectionEditParts, List<NodeEditPart> shapeEditParts) {
		return new SingleArrowConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel(), VConstraint.ConstraintType.TRANSITIVE_IRREFLEXIVE, createIDObject());
	}
	
}
