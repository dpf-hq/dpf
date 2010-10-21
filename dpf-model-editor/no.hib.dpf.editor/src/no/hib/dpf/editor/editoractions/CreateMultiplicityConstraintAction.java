package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.commands.MultiplicityConstraintCreateCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateMultiplicityConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction";	
	private static Predicate MPredicate = MetamodelFactory.eINSTANCE.createPredicate("", "e_1:null:null");

	
	public CreateMultiplicityConstraintAction(IWorkbenchPart part, Graph graph) {
		super(part, ID, graph, MPredicate);
		setText("Create new Multiplicity Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Multiplicity Constraint");
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<ShapeEditPart> shapeEditParts) {
		return new MultiplicityConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel());
	}
	
	
}
