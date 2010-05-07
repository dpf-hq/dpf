package protoedit.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.IWorkbenchPart;

import protoedit.commands.CreateClassCommand;
import protoedit.commands.CreateReferenceCommand;
import protoedit.editparts.tree.DiagramTreeEditPart;
import protomodel.Diagram;

public class CreateClassAction extends SelectionAction {
	public final static String ID = "protoedit.actions.CreateClassAction";
	private Diagram diagram;
	
	public CreateClassAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Create new class");
		setToolTipText("Create new class");
	}

	@Override
	protected boolean calculateEnabled() {
		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() != 1) {
			return false;
		}

		Object selectedObject = selectedObjects.get(0);

		if (selectedObject instanceof EditPart) {
			EditPart editpart = (EditPart) selectedObject;
			if (editpart instanceof DiagramTreeEditPart) {
				diagram = (Diagram) editpart.getModel();
				return true;
			}
		}

		return false;
	}
	
	@Override
	public void run() {
		InputDialog dialog = new InputDialog(getWorkbenchPart().getSite()
				.getShell(), "Create class", "Name of new class: ",
				"aClass", null);
		dialog.open();
		if(dialog.getReturnCode() != InputDialog.CANCEL) {
			System.out.println("Class " + dialog.getValue() + " added in " + diagram);
			Command command = new CreateClassCommand(diagram, dialog.getValue());
			execute(command);
		}
	}

}
