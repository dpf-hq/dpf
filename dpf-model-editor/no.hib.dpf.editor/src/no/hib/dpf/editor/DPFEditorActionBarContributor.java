/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor;

import no.hib.dpf.editor.editoractions.ConstraintRetargetAction;
import no.hib.dpf.editor.editoractions.CreateCompositionConstraintAction;
import no.hib.dpf.editor.editoractions.CreateImageInclusionConstraintAction;
import no.hib.dpf.editor.editoractions.CreateInverseConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction;
import no.hib.dpf.editor.model.VConstraint;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;

/**
 * Contributes actions to a toolbar.
 * This class is tied to the editor in the definition of editor-extension (see plugin.xml).
 * @author Elias Volanakis
 */
@SuppressWarnings("restriction")
public class DPFEditorActionBarContributor extends ActionBarContributor {

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

	addRetargetAction(new RetargetAction(
			GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, 
			GEFMessages.ToggleSnapToGeometry_Label, IAction.AS_CHECK_BOX));

	addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, 
			GEFMessages.ToggleGrid_Label, IAction.AS_CHECK_BOX));
	
	addRetargetAction(new RetargetAction(ActionFactory.PRINT.getId(),
			GEFMessages.PrintAction_Label, IAction.AS_PUSH_BUTTON));
	
	
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
	addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));
	
	
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.INVERSE));
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.JOINTLY_INJECTIVE));
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.JOINTLY_SURJECTIVE));
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.MULTIPLICITY));
	
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.IMAGE_INCLUSION));
	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.COMPOSITION));
//	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.INJECTIVE));
//	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.SURJECTIVE));
//	addRetargetAction(new ConstraintRetargetAction(VConstraint.ConstraintType.IRREFLEXIVE));	
}

/**
 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(IMenuManager)
 */
public void contributeToMenu(IMenuManager menubar) {
	super.contributeToMenu(menubar);
	MenuManager viewMenu = new MenuManager("DPF Diagram");
	viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
	viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));
	viewMenu.add(new Separator());
	viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
	viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
	menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
}

/**
 * Add actions to the given toolbar.
 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(org.eclipse.jface.action.IToolBarManager)
 */
@Override
public void contributeToToolBar(IToolBarManager toolBarManager) {
	toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
	toolBarManager.add(getAction(ActionFactory.REDO.getId()));
	
	
	toolBarManager.add(new Separator());
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
	toolBarManager.add(new Separator());
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
	toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
//	
	toolBarManager.add(new Separator());	
	String[] zoomStrings = new String[] {	ZoomManager.FIT_ALL, 
											ZoomManager.FIT_HEIGHT, 
											ZoomManager.FIT_WIDTH	};
	toolBarManager.add(new ZoomComboContributionItem(getPage(), zoomStrings));
	
	toolBarManager.add(new Separator());	
	
	toolBarManager.add(getAction(CreateJointlyInjectiveConstraintAction.ID));
	toolBarManager.add(getAction(CreateJointlySurjectiveConstraintAction.ID));
	toolBarManager.add(getAction(CreateInverseConstraintAction.ID));
	toolBarManager.add(getAction(CreateMultiplicityConstraintAction.ID));
	toolBarManager.add(getAction(CreateImageInclusionConstraintAction.ID));
	toolBarManager.add(getAction(CreateCompositionConstraintAction.ID));
//	toolBarManager.add(getAction(CreateInjectiveConstraintAction.ID));
//	toolBarManager.add(getAction(CreateSurjectiveConstraintAction.ID));
//	toolBarManager.add(getAction(CreateIrreflexiveConstraintAction.ID));
}

@Override
public void contributeToStatusLine(IStatusLineManager statusLineManager) {
	super.contributeToStatusLine(statusLineManager);
	DPFPlugin.getDefault().setStatusLineManager(statusLineManager);
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
 */
protected void declareGlobalActionKeys() {
	// currently none
}

}