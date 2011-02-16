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

import no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction;
import no.hib.dpf.editor.editoractions.SrcSelectAction;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Provides context menu actions for the ShapesEditor.
 * 
 * @author Elias Volanakis
 */
public class DPFEditorContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry actionRegistry;

	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer
	 * and ActionRegistry.
	 * 
	 * @param viewer
	 *            the editor's graphical viewer
	 * @param registry
	 *            the editor's action registry
	 * @param signature
	 *            the editor's signature
	 * @throws IllegalArgumentException
	 *             if registry is <tt>null</tt>.
	 */
	public DPFEditorContextMenuProvider(EditPartViewer viewer,
			ActionRegistry registry) {
		super(viewer);
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		this.actionRegistry = registry;
	}

	/**
	 * Called when the context menu is about to show. Actions, whose state is
	 * enabled, will appear in the context menu.
	 * 
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);

		// Add actions to the menu
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO,
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));

		getActionAndAppendToMenu(menu, SrcSelectAction.ID);
		getActionAndAppendToMenu(menu,
				CreateJointlyInjectiveConstraintAction.ID);
		getActionAndAppendToMenu(menu,
				CreateJointlySurjectiveConstraintAction.ID);
		getActionAndAppendToMenu(menu, CreateMultiplicityConstraintAction.ID);
	}

	private void getActionAndAppendToMenu(IMenuManager menu, String actionID) {
		IAction action = getAction(actionID);
		if ((action != null) && (action.isEnabled())) {
			menu.appendToGroup(GEFActionConstants.GROUP_COPY, action);
		}
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}

}
