package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.commands.MultiplicityConstraintCreateCommand;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateMultiplicityConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction";	
	private static Predicate MPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2", "e_1:n_1:n_2");

	
	public CreateMultiplicityConstraintAction(IWorkbenchPart part, Graph graph) {
		super(part, ID, graph, MPredicate);
		setText("Create new Multiplicity Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Multiplicity Constraint");
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts) {
		return new MultiplicityConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel());
	}
	
	
}
