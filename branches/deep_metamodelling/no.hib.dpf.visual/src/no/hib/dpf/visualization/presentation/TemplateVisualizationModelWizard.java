package no.hib.dpf.visualization.presentation;
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


import java.util.HashMap;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.editor.utilities.DPFModelUtils;
import no.hib.dpf.editor.wizards.DPFCreationWizard;
import no.hib.dpf.utils.DPFCoreUtil;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.util.VisualizationModelPersistanceUtils;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

/**
 * Create a new .visualization-file.
 */
@SuppressWarnings("restriction")
public class TemplateVisualizationModelWizard extends Wizard implements INewWizard{

	private CreationPage createPage = null;
	private TemplateVisualizationModelWizardPage configPage = null;
	private String initialLocation = "";
	
	public static final String DEFAULT_VISUALIZATION_MODEL_EXTENSION = ".visualization";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		// add pages to this wizard
		addPage(createPage);
		addPage(configPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// create pages for this wizard
		createPage = new CreationPage(workbench, selection);

		DPFModelPersistanceUtils.updateFileName(createPage, selection, "m0", "visualization");
		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
		configPage = new TemplateVisualizationModelWizardPage("The wizard id does not matter");
		configPage.setTitle("Choose diagram model, visual model and signature");
		configPage.setDescription("The page allows you to choose your own metamodel and customed signature. " +
				"The default metamodel and signature will be used if you check default metamodel and default signature");
		
		initialLocation = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			initialLocation = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(initialLocation.endsWith(".xmi"))
				initialLocation = DPFModelPersistanceUtils.getDiagramFromModel(initialLocation);
		} else
			initialLocation = VisualizationEditor.getWorkspaceDirectory();
		configPage.setInitialLocation(initialLocation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		return createPage.finish();
	}

	/**
	 * This WizardPage can create an empty .shapes file for the ShapesEditor.
	 */
	public class CreationPage extends WizardNewFileCreationPage {

		/**
		 * Hides the advanced option widgets.
		 */
		@Override
		protected void handleAdvancedButtonSelect() {
		}


		private final IWorkbench workbench;

		/**
		 * Create a new wizard page instance.
		 * 
		 * @param workbench
		 *            the current workbench
		 * @param selection
		 *            the current object selection
		 * @see DPFCreationWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("dpfCreationPage1", selection);
			this.workbench = workbench;
			setTitle("Create a new " + DEFAULT_VISUALIZATION_MODEL_EXTENSION + " file");
			setDescription("Create a new " + DEFAULT_VISUALIZATION_MODEL_EXTENSION + " file");
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see DPFCreationWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newFile = createNewFile();
			URI fileURI = DPFModelPersistanceUtils.getFileURI(newFile);
			
			DSpecification newDSpec = getNewDSpecification(configPage);

			
			// load the class visual model:
			Visuals visuals = configPage.getVisualModel();
			
			// create the new visualization
			Visualizations visualization = VisualizationModelUtils.getNewVisualization(newDSpec, visuals);

			// Gets null value when user does not check checkbox
			try {
				ResourceSetImpl resourceSet = VisualizationModelPersistanceUtils.getResourceSet();
				VisualizationModelPersistanceUtils.saveVisualizations(resourceSet, visualization, fileURI, new HashMap<Resource, Diagnostic>());
				newFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e1) {
				DPFCoreUtil.logError("An error happened when trying to store the new DPF Visualization", e1);
			} 
			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if (newFile != null && page != null) {
				try {
					IEditorPart editorPart = IDE.openEditor(page, newFile, true);
					if(editorPart != null)
						editorPart.setFocus();
				} catch (PartInitException e) {
					DPFCoreUtil.logError("An error happened when trying to open the DPF Editor", e);
					return false;
				}
			}
			return true;
		}
		
		/**
		 * @author Ole Klokkhammer
		 * @param cfgPage
		 * @return
		 */
		private DSpecification getNewDSpecification(TemplateVisualizationModelWizardPage cfgPage) {
			DSpecification newSpec = DPFModelUtils.getNewDSpecification(cfgPage.getMetaModel(), cfgPage.getSignature());

			// set the Graph name to the specified filename
			String fileName = getFileName();
			fileName = fileName.substring(0, fileName.indexOf(".")); // filename without file-extension
			newSpec.getDGraph().getGraph().setName(fileName);
			
			return newSpec;
		}
	

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null && getFileName().endsWith(DEFAULT_VISUALIZATION_MODEL_EXTENSION)) 
				return true;
			setErrorMessage("The 'file' name must end with " + DEFAULT_VISUALIZATION_MODEL_EXTENSION);
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		@Override
		protected boolean validatePage() {
			return super.validatePage() && validateFilename();
		}
	}
}
