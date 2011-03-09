package no.hib.dpf.editor.editoractions;

import no.hib.dpf.editor.model.VArrow;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class SrcSelectAction extends SelectionAction {

	// an identifier for the action
	public static final String ID="shapes.tutorial.SrcSelectAction";

	public SrcSelectAction(IWorkbenchPart part) {
		super(part);
		setId(ID);              // sets ID
		setText("Select link src"); // sets text displayed in the menu
		setToolTipText("Focus on link source");
	}

	@Override
	protected boolean calculateEnabled() {
		// we only want enabled if is single selection
		if ((getSelectedObjects().size() != 1) || (!(getSelectedObjects().get(0) instanceof ConnectionEditPart))) {
			return false;
		}
		// and we want the model to be a Connection object.
		ConnectionEditPart cep = (ConnectionEditPart) getSelectedObjects().get(0);
		if (cep.getModel() instanceof VArrow) {
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		// so we know its a ConnectionEditPart

		ConnectionEditPart cep = (ConnectionEditPart) getSelectedObjects().get(0);
		// Any EditPart can access its viewer
		EditPartViewer viewer = cep.getViewer();

		// Deselect an existing selection
		viewer.deselectAll();

		// Flush this
		viewer.flush();

		// Select the source edit part
		viewer.select(cep.getSource());

		// If the source Edit part is off screen, this will scroll to it.
		viewer.reveal(cep.getSource());
	}

}
