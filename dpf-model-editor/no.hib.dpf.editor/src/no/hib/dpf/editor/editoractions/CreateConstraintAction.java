package no.hib.dpf.editor.editoractions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.Constraint;
import no.hib.dpf.editor.model.commands.ConstraintCreateCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class CreateConstraintAction extends SelectionAction {
	
	// an identifier for the action
	public static final String ID="no.hib.dpf.editor.editoractions.CreateConstraintAction";	

	public CreateConstraintAction(IWorkbenchPart part) {
		super(part);
		setId(ID);              // sets ID
		setText("Create new Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Constraint");
	}

	private List<ConnectionEditPart> getSelectedConnectionEditParts() {
		List<ConnectionEditPart> connectionEditParts = new ArrayList<ConnectionEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ConnectionEditPart) {
				connectionEditParts.add((ConnectionEditPart)getSelectedObjects().get(i));
			}
		}
		return connectionEditParts;
	}
	
	private List<ShapeEditPart> getSelectedShapeEditParts() {
		List<ShapeEditPart> shapeEditParts = new ArrayList<ShapeEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ShapeEditPart) {
				shapeEditParts.add((ShapeEditPart)getSelectedObjects().get(i));
			}
		}
		return shapeEditParts;
	}

	@Override
	protected boolean calculateEnabled() {
		// we only want enabled if one node w/two outgoing edges are selected.
		// TODO: Make this configurable

		if (getSelectedObjects().size() != 3) {
			return false;
		}
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<ShapeEditPart> shapeEditParts = getSelectedShapeEditParts();
		
		if ((connectionEditParts.size() != 2) || (shapeEditParts.size() != 1)) {
			return false;
		}
		return ((connectionEditParts.get(0).getSource().equals(shapeEditParts.get(0))) &&
				(connectionEditParts.get(1).getSource().equals(shapeEditParts.get(0))));
	}

	
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true

		System.out.println("Start run...");
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<ShapeEditPart> shapeEditParts = getSelectedShapeEditParts();
		
		// Any EditPart can access its viewer
		EditPartViewer viewer = shapeEditParts.get(0).getViewer();

		// Deselect an existing selection
		viewer.deselectAll();

		// Flush this
		viewer.flush();
		

//		ConstraintCreateCommand constraintCreateCommand = new ConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel(), (Connection)connectionEditParts.get(1).getModel(), Constraint.SOLID_CONNECTION);
//		
//		execute(constraintCreateCommand);
		
		// create a new connection between source and target
		Constraint constraint = new Constraint((Connection)connectionEditParts.get(0).getModel(), (Connection)connectionEditParts.get(1).getModel());
		// use the supplied line style
		constraint.setLineStyle(Constraint.SOLID_CONNECTION);

		System.out.println("End run...");
		
		
		// og AbstractEditPart.refreshChildren()
// Se AbstractConnectionCreationTool		
//		eraseSourceFeedback();
//		Command endCommand = getCommand();
//		setCurrentCommand(endCommand);
//		executeCurrentCommand();
//		return true;


//		// Select the source edit part
//		viewer.select(cep.getSource());
//
//		// If the source Edit part is off screen, this will scroll to it.
//		viewer.reveal(cep.getSource());
	}
	
	
}
