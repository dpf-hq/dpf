package protoedit.actions;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.ui.IWorkbenchPart;

import protoedit.commands.CreateReferenceCommand;
import protoedit.editparts.tree.ClazzTreeEditPart;
import protomodel.Clazz;

public class CreateReferenceAction extends SelectionAction {
	public final static String ID = "protoedit.actions.CreateReferenceAction";
	private Clazz clazz;

	public CreateReferenceAction(IWorkbenchPart part) {
		super(part);
		setId(ID);
		setText("Create Reference");
		setToolTipText("Create Graph");
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
			if (editpart instanceof ClazzTreeEditPart) {
				clazz = (Clazz) editpart.getModel();
				return true;
			}
		}

		return false;
	}

	@Override
	public void run() {
		InputDialog dialog = new InputDialog(getWorkbenchPart().getSite()
				.getShell(), "Create Reference", "Name of new reference: ",
				"newReference", null);
		dialog.open();
		if(dialog.getReturnCode() != InputDialog.CANCEL) {
			System.out.println("Reference " + dialog.getValue() + " added in " + clazz);
			Command command = new CreateReferenceCommand(clazz, dialog.getValue());
			execute(command);
		}
	}

}
