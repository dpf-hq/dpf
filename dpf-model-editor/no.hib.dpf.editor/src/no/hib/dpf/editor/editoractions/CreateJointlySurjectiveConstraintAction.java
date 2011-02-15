package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.commands.JSurjConstraintCreateCommand;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointlySurjectiveConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction";	
	private static Predicate JSPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_2:n_1,e_2:n_3:n_1");
	
	public CreateJointlySurjectiveConstraintAction(IWorkbenchPart part, Graph graph) {
		super(part, ID, graph, JSPredicate);
		setText("Create new [jointly-surjective] Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Jointly Surjective Constraint");
	}

	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts) {
		return new JSurjConstraintCreateCommand((VArrow)connectionEditParts.get(0).getModel(), (VArrow)connectionEditParts.get(1).getModel());
	}
	
	
}
