package no.hib.dpf.editor.editoractions;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class CreateEllipseAction extends SelectionAction {
	
	// an identifier for the action
	public static final String ID="shapes.tutorial.CreateEllipseAction";	

	public CreateEllipseAction(IWorkbenchPart part) {
		super(part);
		setId(ID);              // sets ID
		setText("Create new Ellipse"); // sets text displayed in the menu
		setToolTipText("Creates a new Ellipse");
	}

	@Override
	protected boolean calculateEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
