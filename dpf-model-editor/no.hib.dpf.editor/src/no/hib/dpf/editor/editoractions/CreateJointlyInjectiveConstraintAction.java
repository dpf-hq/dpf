package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.VEdge;
import no.hib.dpf.editor.model.commands.JInjConstraintCreateCommand;
import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointlyInjectiveConstraintAction extends CreateConstraintAction {
		
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction";
	private static Predicate JIPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");

	public CreateJointlyInjectiveConstraintAction(IWorkbenchPart part, Graph graph) {
		super(part, ID, graph, JIPredicate);
		setText("Create new Jointly Injective Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Jointly Injective Constraint");
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts) {
		return new JInjConstraintCreateCommand((VEdge)connectionEditParts.get(0).getModel(), (VEdge)connectionEditParts.get(1).getModel());
	}
	
	
}
