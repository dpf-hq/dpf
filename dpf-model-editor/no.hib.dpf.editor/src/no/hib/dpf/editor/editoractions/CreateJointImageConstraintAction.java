package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.DPFDiagram;
import no.hib.dpf.editor.model.commands.JImgConstraintCreateCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointImageConstraintAction extends SelectionActionForEditParts {
	
	
	// an identifier for the action
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointImageConstraintAction";	

	public CreateJointImageConstraintAction(IWorkbenchPart part, DPFDiagram diagram) {
		super(part, ID, diagram);
		setText("Create new Joint Image Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Joint Image Constraint");
	}

	@Override
	protected boolean calculateEnabled() {
		// we only want enabled if one node w/two outgoing edges are selected.
		// TODO: Make this configurable
		
		Predicate testPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1", "e_1:null:n_1,e_2:null:n_1");
						
		no.hib.dpf.metamodel.Constraint constraint =
			testPredicate.createConstraint(getSelectionNodes(), getSelectionEdges(), graph);
		return (constraint != null);
		
	}

	
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<ShapeEditPart> shapeEditParts = getSelectedShapeEditParts();
		
		// Any EditPart can access its viewer
		EditPartViewer viewer = shapeEditParts.get(0).getViewer();

		// Deselect an existing selection
		viewer.deselectAll();

		// Flush this
		viewer.flush();
		
// TODO: make ConstraintElement dependant on a "Real" constraint...
		JImgConstraintCreateCommand constraintCreateCommand = new JImgConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel(), (Connection)connectionEditParts.get(1).getModel(), ConstraintElement.SOLID_CONNECTION);
		
		execute(constraintCreateCommand);
	}
	
	
}
