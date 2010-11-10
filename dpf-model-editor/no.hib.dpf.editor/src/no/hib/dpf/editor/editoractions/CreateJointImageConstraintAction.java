package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.commands.JImgConstraintCreateCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointImageConstraintAction extends CreateConstraintAction {
	
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointImageConstraintAction";	
	private static Predicate JIPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_2:n_1,e_2:n_3:n_1");
	
	public CreateJointImageConstraintAction(IWorkbenchPart part, Graph graph) {
		super(part, ID, graph, JIPredicate);
		setText("Create new Joint Image Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Joint Image Constraint");
	}

	@Override
	protected Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<ShapeEditPart> shapeEditParts) {
		return new JImgConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel(), (Connection)connectionEditParts.get(1).getModel(), ConstraintElement.SOLID_CONNECTION);
	}
	
	
}
