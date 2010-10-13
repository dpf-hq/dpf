package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.DPFDiagram;
import no.hib.dpf.editor.model.commands.MultiplicityConstraintCreateCommand;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.ui.IWorkbenchPart;

public class CreateMultiplicityConstraintAction extends SelectionActionForEditParts {
	
	
	// an identifier for the action
	public static final String ID="no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction";	

	public CreateMultiplicityConstraintAction(IWorkbenchPart part, DPFDiagram diagram) {
		super(part, ID, diagram);
		setText("Create new Multiplicity Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Multiplicity Constraint");
	}

	@Override
	protected boolean calculateEnabled() {
		// we only want enabled if one node w/two outgoing edges are selected.
		// TODO: Make this configurable
		
		Predicate testPredicate = MetamodelFactory.eINSTANCE.createPredicate("", "e_1:null:null");
						
		no.hib.dpf.metamodel.Constraint constraint =
			testPredicate.createConstraint(getSelectionNodes(), getSelectionEdges(), graph);
		return (constraint != null);
		
	}

	
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();

		EditPartViewer viewer = connectionEditParts.get(0).getViewer();

		// Deselect an existing selection
		viewer.deselectAll();

		// Flush this
		viewer.flush();
		
// TODO: make ConstraintElement dependant on a "Real" constraint...
		MultiplicityConstraintCreateCommand constraintCreateCommand = new MultiplicityConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel());
		
		execute(constraintCreateCommand);
	}
	
	
}
