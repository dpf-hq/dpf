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
package no.hib.dpf.editor.wizards;

import java.util.LinkedHashMap;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.editor.utilities.DPFModelUtils;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
 * Create a new .dpf-file.
 */
@SuppressWarnings("restriction")
public class DPFCreationWizard extends Wizard implements INewWizard{

	private CreationPage createPage = null;
	private DPFWizardPage configPage = null;

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

		DPFModelPersistanceUtils.updateFileName(createPage, selection, "specification", "dpf");
		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
		configPage = new DPFWizardPage("The wizard id does not matter");
		configPage.setTitle("Choose metamodel and signature");
		configPage.setDescription("The page allows you to choose your own metamodel and customed signature. " +
				"The default metamodel and signature will be used if you check default metamodel and default signature");
		
		String filename = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".xmi"))
				filename = DPFModelPersistanceUtils.getDiagramFromModel(filename);
		} else
			filename = DPFEditor.getWorkspaceDirectory();
		configPage.setInitialLocation(filename);
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
			setTitle("Create a new " + DPFModelPersistanceUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION + " file");
			setDescription("Create a new " + DPFModelPersistanceUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION + " file");
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see DPFCreationWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();
			URI newDiagarmURI = DPFModelPersistanceUtils.getFileURI(newDiagramFile);
			//Initialize model file and diagram file
			DSpecification newSpec = getNewDSpecification(configPage);

			// Gets null value when user does not check checkbox
			try {
				DPFModelPersistanceUtils.saveDSpecification(DPFModelPersistanceUtils.getResourceSet(), newSpec, newDiagarmURI, new LinkedHashMap<Resource, Diagnostic>());
				newDiagramFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e1) {
				DPFCoreUtil.logError("An error happened when trying to store the new DPF Specification", e1);
			} 
			
			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if (newDiagramFile != null && page != null) {
				
				try {
					IEditorPart editorPart = IDE.openEditor(page, newDiagramFile, true);
					if(editorPart != null){
						editorPart.setFocus();
					}
				} catch (PartInitException e) {
					DPFCoreUtil.logError("An error happened when trying to open the DPF Editor", e);
					return false;
				}
			}
			return true;
		}

		/**
		 * @author Ole Klokkhammer
		 * @return
		 */
		private DSpecification getNewDSpecification(DPFWizardPage cfgPage) {
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
			if (getFileName() != null && getFileName().endsWith(DPFModelPersistanceUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION)) 
				return true;
			setErrorMessage("The 'file' name must end with " + DPFModelPersistanceUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION);
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
