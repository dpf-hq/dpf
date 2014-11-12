package no.hib.dpf.editor.wizards;
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

 
import java.util.LinkedHashMap;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFDiagramConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.nature.DPFProjectSupport;
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
 * Create a new .visualization-file.
 */
@SuppressWarnings("restriction")
public class DPFTemplateWizard extends Wizard implements INewWizard{

	private CreationPage createPage = null;
	private String initialLocation = "";
	private DSpecification metamodel;
	private DSignature sig;
	
	public static final String DEFAULT_VISUALIZATION_MODEL_EXTENSION = ".dpf";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	@Override
	public void addPages() {
		// add pages to this wizard
		addPage(createPage);
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

		DPFModelPersistanceUtils.updateFileName(createPage, selection, "newTemplate", "dpf");
		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
	
		initialLocation = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			initialLocation = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(initialLocation.endsWith(".xmi"))
				initialLocation = DPFModelPersistanceUtils.getDiagramFromModel(initialLocation);
		} else{
			initialLocation = DPFEditor.getWorkspaceDirectory();
		}
		sig = DPFDiagramConstants.DEFAULT_DSIGNATURE; 
		metamodel = getCompositionMetamodel();
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
			IFile newDiagramFile = createNewFile();
			URI newDiagarmURI = DPFModelPersistanceUtils.getFileURI(newDiagramFile);
			
			
			DSpecification newDSpec = getNewDSpecification(metamodel, sig);
			updateMetalevels(newDSpec);
			
			// Gets null value when user does not check checkbox
			try {
				DPFModelPersistanceUtils.saveDSpecification(DPFModelPersistanceUtils.getResourceSet(), newDSpec, newDiagarmURI, new LinkedHashMap<Resource, Diagnostic>());
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
		 * TODO
		 * @param newDSpec
		 */
		private void updateMetalevels(DSpecification newDSpec) {
			Specification newSpec = newDSpec.getSpecification();
			newSpec.setMetalevel(-1);
			newSpec.getType().setMetalevel(-2);
			newSpec.getType().getType().setMetalevel(-3);
		}

		private DSpecification getNewDSpecification(DSpecification dSpec, DSignature sig) {
			DSpecification newSpec = DPFModelUtils.getNewDSpecification(dSpec, sig);

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
			if (metamodel != null && sig != null) {
				return super.validatePage() && validateFilename();
			}
			return false;
		}
	}
	

	/**
	 * TODO refer to file in filestructure instead of copying the metamodel to the new project?
	 * @return
	 */
	private DSpecification getCompositionMetamodel() {
		String filePath = new String(initialLocation);
		
		String workspace = DPFEditor.getWorkspaceDirectory();
		workspace = workspace.replace("/", "\\");
		if(filePath.contains(workspace)){
			filePath = filePath.substring(workspace.length(), filePath.length());
		}
		int i = filePath.indexOf("\\");
		if(i == 0){
			i = filePath.indexOf("\\", 2);
		}
		filePath = filePath.substring(0, i);
		
		workspace += filePath + "\\" + DPFProjectSupport.FOLDERNAME_TEMPLATE_METAMODELS + "\\Composition.dpf";
		
		DSpecification spec = DPFModelPersistanceUtils.loadDModel(URI.createFileURI(workspace));
		return spec;
	}
}
