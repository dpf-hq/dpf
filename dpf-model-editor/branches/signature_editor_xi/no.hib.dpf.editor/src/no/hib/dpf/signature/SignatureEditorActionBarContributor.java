package no.hib.dpf.signature;

import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;

public class SignatureEditorActionBarContributor extends ActionBarContributor {

/**
 * Create actions managed by this contributor.
 * @see org.eclipse.gef.ui.actions.ActionBarContributor#buildActions()
 */
@Override
protected void buildActions() {
	addRetargetAction(new DeleteRetargetAction());
	addRetargetAction(new UndoRetargetAction());
	addRetargetAction(new RedoRetargetAction());
	
	addRetargetAction(new ZoomInRetargetAction());
	addRetargetAction(new ZoomOutRetargetAction());

//	addRetargetAction(new RetargetAction(
//			GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
//			GEFMessages.ToggleSnapToGeometry_Label, IAction.AS_CHECK_BOX));
//
//	addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, 
//			GEFMessages.ToggleGrid_Label, IAction.AS_CHECK_BOX));
//	
//	addRetargetAction(new RetargetAction(ActionFactory.PRINT.getId(),
//			GEFMessages.PrintAction_Label, IAction.AS_PUSH_BUTTON));
	
	
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
//	addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));
}

/**
 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(IMenuManager)
 */
//public void contributeToMenu(IMenuManager menubar) {
//	super.contributeToMenu(menubar);
//	MenuManager viewMenu = new MenuManager("DPF Diagram");
////	viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
////	viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));
////	viewMenu.add(new Separator());
////	viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
////	viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
////	menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
//}

/**
 * Add actions to the given toolbar.
 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
 */
@Override
public void contributeToToolBar(IToolBarManager toolBarManager) {
	super.contributeToToolBar(toolBarManager);
	toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
	toolBarManager.add(getAction(ActionFactory.REDO.getId()));
	toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
	
	
//	toolBarManager.add(new Separator());
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
//	toolBarManager.add(new Separator());
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
//	toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
////	
//	toolBarManager.add(new Separator());	
//	String[] zoomStrings = new String[] {	ZoomManager.FIT_ALL, 
//											ZoomManager.FIT_HEIGHT, 
//											ZoomManager.FIT_WIDTH	};
//	toolBarManager.add(new ZoomComboContributionItem(getPage(), zoomStrings));
//	
//	toolBarManager.add(new Separator());	
	
}

//@Override
//public void contributeToStatusLine(IStatusLineManager statusLineManager) {
//	super.contributeToStatusLine(statusLineManager);
//	DPFPlugin.getDefault().setStatusLineManager(statusLineManager);
//}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
 */
protected void declareGlobalActionKeys() {
	// currently none
}

}
