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

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.EditorPartListener;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.parts.TransformArrowLabelEditPart;
import no.hib.dpf.transform.parts.TransformDArrowEditPart;
import no.hib.dpf.transform.parts.TransformDGraphEditPart;
import no.hib.dpf.transform.parts.TransformDNodeEditPart;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * A graphical editor with flyout palette that can edit .dpf files. The
 * binding between the .dpf file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public abstract class ProductionEditor extends GraphicalEditorWithFlyoutPalette{

	/** This is the root of the editor's model. */

	protected Production production;
	protected Transform transform = null;

	protected PaletteRoot paletteRoot;

	private DPFEditPartFactory shapesEditPartFactory;
	protected DPFTransformPaletteFactory paletteFactory;

	protected DSpecification dspec = null;

	protected PropertySheetPage propertySheetPage;


	public void setProduction(Production prod){
		production = prod;
	}

	public ProductionEditor(){
		paletteFactory = new DPFTransformPaletteFactory();
	}

	public DPFTransformPaletteFactory getpaletteFactory(){
		return paletteFactory;
	}

	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		paletteFactory.updatePalette(getPaletteRoot(), dspec.getDGraph());

		shapesEditPartFactory = new DPFEditPartFactory(){
			protected EditPart getPartForElement(Object modelElement) {
				if (modelElement instanceof DGraph) 
					return new TransformDGraphEditPart();
				if (modelElement instanceof DNode) 
					return new TransformDNodeEditPart();
				if (modelElement instanceof DArrow) 
					return new TransformDArrowEditPart();
				if (modelElement instanceof DOffset) {
					DOffset offset = (DOffset) modelElement;
					if(offset.eContainer() instanceof DArrow)
						return new TransformArrowLabelEditPart();
				}
				if(modelElement instanceof DConstraint){
					return new DConstraintEditPart(){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());	
						}
					};
				}
				return super.getPartForElement(modelElement);
			}
		};
		viewer.setEditPartFactory(shapesEditPartFactory);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		ContextMenuProvider cmProvider = new TranformEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	public void doSave(final URI uri, IProgressMonitor monitor) {

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), dspec, uri);
			}
		};

		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			getCommandStack().markSaveLocation();

			IFile file = ((IFileEditorInput)getEditorInput()).getFile();
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);

			//			updateStatusBar();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void doSave(IProgressMonitor monitor) {
		Shell shell = getSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();

		final IPath path = dialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				IFileEditorInput newInput = new FileEditorInput(file);
				setInputWithNotify(newInput);
				setPartName(newInput.getName());
				DPFEditor.updateResourceSet(DPFUtils.getResourceSet(), dspec, dspec.eResource().getURI(), DPFUtils.getFileURI(file));
				doSave(DPFUtils.getFileURI(file), new NullProgressMonitor());
			}
		}

	}

	@Override
	protected void createActions() {
		super.createActions(); // to get the default actions

		DSignature signature = dspec.getDSignature();
		if (signature != null) {
			for (DPredicate predicate : signature.getDPredicates())
				addActionForPredicate(predicate);
			if(signature != DEFAULT_DSIGNATURE){
				for (DPredicate predicate : DEFAULT_DSIGNATURE.getDPredicates())
					addActionForPredicate(predicate);
			}
			if(partListener == null){
				partListener = new EditorPartListener(this, constraintActions);
				getSite().getPage().addPartListener(partListener);
			}
		}
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.LEFT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.RIGHT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.TOP));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.BOTTOM));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.CENTER));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.MIDDLE));
	}

	private void addActionForPredicate(final DPredicate dPredicate) {
		CreateConstraintAction action = new CreateConstraintAction(this, dspec, dPredicate); 
		registerAction(action);
		constraintActions.add(action);
	}

	@SuppressWarnings("unchecked")
	private void registerAction(IAction action) {
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
	}

	List<IAction> constraintActions = new ArrayList<IAction>();

	protected IPartListener partListener = null;
	public void dispose() {
		if(partListener != null)
			getSite().getPage().removePartListener(partListener);
		super.dispose();
	}
};