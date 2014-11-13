/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.transform.presentation;

import no.hib.dpf.transform.icons.ImageSettings;
import no.hib.dpf.transform.util.DefineNameVariableDialog;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Provides context menu actions for the ShapesEditor.
 * 
 * @author Elias Volanakis
 */
public class TranformEditorContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry actionRegistry;
	private EditPartViewer editViewer;

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
	public TranformEditorContextMenuProvider(EditPartViewer viewer,
			ActionRegistry registry) {
		super(viewer);
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		viewer.getEditPartRegistry();
		
		editViewer = viewer;
//		add = new AddLeftAction(viewer);
		this.actionRegistry = registry;
//		registry.registerAction(add);
	}

	protected Action generateToEcore = new Action(TransformConstants.ADD_VARIABLE, ImageSettings.IMG_GENERATE_ECORE.getImageDescriptor()) {
		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override	
		public void run() {
			//WizardDialog wizardDialog = new WizardDialog(TransformActivePage.getActiveWorkBenchWindow().getShell(),
			DefineNameVariableDialog dialog = new DefineNameVariableDialog(TransformUtils.getActiveWorkBenchWindow().getShell(), editViewer.getFocusEditPart());
			dialog.create();
			if(dialog.open() == Window.OK){
			}
//				    if (VariableDialog.open() == Window.OK) {
//				      System.out.println("Ok pressed");
//				    } else {
//				      System.out.println("Cancel pressed");
//				    }
		}
	};
	
//	AddLeftAction add, remove;
	/**
	 * Called when the context menu is about to show. Actions, whose state is
	 * enabled, will appear in the context menu.
	 * 
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		menu.add(new Separator(GEFActionConstants.GROUP_UNDO));
		menu.add(new Separator(GEFActionConstants.GROUP_UNDO));
		menu.add(new Separator(GEFActionConstants.GROUP_EDIT));
		// Add actions to the menu
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO,
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));
		
		menu.add(new Separator());
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT, generateToEcore);
//		if(add.isEnabled())
//			menu.appendToGroup(GEFActionConstants.GROUP_EDIT, add);
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}
	
//	class AddLeftAction extends Action{
//
//		private static final String ADD_ELEMENT_TO_LEFT = "Add the element to the left pattern";
//		private EditPartViewer viewer;
//		public AddLeftAction(EditPartViewer viewer) {
//			super(ADD_ELEMENT_TO_LEFT);
//			setId("no.hib.dpf.transformeditor.addleftaction");
//			this.viewer = viewer;
//			setToolTipText(ADD_ELEMENT_TO_LEFT);
//		}
//		public void run() {
//			
//			GraphicalViewer graphicalViewer = (GraphicalViewer)viewer;
//		}
//		public boolean isEnabled(){
//			if(viewer != null && !viewer.getSelectedEditParts().isEmpty())
//				return super.isEnabled();
//			return false;
//		}
//	}

}
