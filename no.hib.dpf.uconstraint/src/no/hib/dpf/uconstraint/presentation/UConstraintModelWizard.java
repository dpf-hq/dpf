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

package no.hib.dpf.uconstraint.presentation;

import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UConstraintFactory;
import no.hib.dpf.uconstraint.util.ConstraintsUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
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
 * Create a new .xform-file.
 */
@SuppressWarnings("restriction")
public class UConstraintModelWizard extends Wizard implements INewWizard {

	private CreationPage createPage = null;
	private UConstraintWizardPage configPage = null;


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
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
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// create pages for this wizard
		createPage = new CreationPage(workbench, selection);

//		ConstraintsUtils.updateFileName(createPage, selection, "specification", "xform");
		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
		configPage = new UConstraintWizardPage("The wizard id does not matter");
		configPage.setTitle("Choose source, target metamodel and signature");
		configPage.setDescription("The page allows you to choose your own source metamodel and customed signature. " +
				"The default metamodel and signature will be used if you check default metamodel and default signature. ");

		String filename = null;

		if(selection.getFirstElement() instanceof IResource) {
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".xmi"))
				filename = DPFUtils.getDiagramFromModel(filename);
		} else
			filename = DPFUtils.getWorkspaceDirectory();
		configPage.setInitialLocation(filename);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		return createPage.finish();
	}

	public static final String TRANSFORM_EXTENSION = ".uc";
	/**
	 * This WizardPage can create an empty .shapes file for the ShapesEditor.
	 */
	public class CreationPage extends WizardNewFileCreationPage {

		/**
		 * Hides the advanced option widgets.
		 */
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
		 * @see UConstraintModelWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("dpfCreationPage1", selection);
			this.workbench = workbench;
			setTitle("Create a new new universal constraint file");
			setDescription("Create a new universal constraint file");
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see UConstraintModelWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();

			URI newDiagarmURI = DPFUtils.getFileURI(newDiagramFile);
			//Initialize model file and diagram file
			Constraints constraints = UConstraintFactory.eINSTANCE.createConstraints();


			constraints.setSourceLocation(configPage.getSourceMetaModelURI());
			constraints.setElementTypeGraph(configPage.getSourceMetaModel());
			constraints.setDSignature(configPage.getSignature());
			ConstraintsUtils.saveConstraints(ConstraintsUtils.getResourceSet(), newDiagarmURI, constraints, true);
			try {
				newDiagramFile.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e1) {
				DPFUtils.logError(e1);
			} 

			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();

			if (newDiagramFile != null && page != null) {
				try {
					IEditorPart editorPart = IDE.openEditor(page, newDiagramFile, true);
					if(editorPart != null)
						editorPart.setFocus();
				} catch (PartInitException e) {
					DPFUtils.logError("Error happens when Open DPF Editor", e);
					return false;
				}
			}

			return true;
		}

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			//if (getFileName() != null && getFileName().endsWith(DPFUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION)) 
			if (getFileName() != null && getFileName().endsWith("uc"))
				return true;
			//setErrorMessage("The 'file' name must end with " + DPFUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION);
			setErrorMessage("The 'file' name must end with uc");
			return false;
			//			if (getFileName() != null && getFileName().endsWith(DPFUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION)) 
			//				return true;
			//			setErrorMessage("The 'file' name must end with " + DPFUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION);
			//			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		protected boolean validatePage() {
			return super.validatePage() && validateFilename();
		}
	}
}
