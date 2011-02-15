package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.commands.MultiplicityConstraintCreateCommand;
import no.hib.dpf.metamodel.Graph;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateMultiplicityConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction";	
	
	public CreateMultiplicityConstraintAction(IWorkbenchPart part, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph, constraintProperties);
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts) {
		return new MultiplicityConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel());
	}
	
	
}
