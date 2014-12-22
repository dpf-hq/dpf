package no.hib.dpf.editor;

import java.util.List;

import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

public class EditorPartListener implements IPartListener {
	IEditorPart editor;
	List<IAction> constraintActions;
	public EditorPartListener(IEditorPart edit, List<IAction> actions){
		editor = edit;
		constraintActions = actions;
	}

	public void partActivated(IWorkbenchPart p) {
		IActionBars actionBars = getActionBars(p, editor);
		if(actionBars == null) return;
		IToolBarManager toolbar = actionBars.getToolBarManager();
		if(toolbar == null) return;		
		for (IAction action : constraintActions)
			toolbar.add(action);
		toolbar.update(true);
		actionBars.updateActionBars();
	}

	private IActionBars getActionBars(IWorkbenchPart p, IEditorPart p2){
		if(constraintActions == null) return null;
		if (p != p2) return null;
		if((ActionRegistry) p2.getAdapter(ActionRegistry.class) == null) return null;
		return p2.getEditorSite().getActionBars();
	}
	public void partBroughtToTop(IWorkbenchPart p) { }

	public void partClosed(IWorkbenchPart p) { }

	public void partDeactivated(IWorkbenchPart p) {
		IActionBars actionBars = getActionBars(p, editor);
		if(actionBars == null) return;
		IToolBarManager toolbar = actionBars.getToolBarManager();
		if(toolbar == null) return;
		for (IAction action : constraintActions)
			toolbar.remove(action.getId());
		toolbar.update(true);
		actionBars.updateActionBars();
	}

	public void partOpened(IWorkbenchPart p) { }
}
