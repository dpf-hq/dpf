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
package no.hib.dpf.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.dialogs.WizardNewLinkPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

import no.hib.dpf.constant.*;
/**
 * Create a new .dpf-file.
 */
@SuppressWarnings("restriction")
public class DPFCreationWizard extends Wizard implements INewWizard {

	private static int fileCount = 1;
	private CreationPage page1;
	private WizardNewLinkPage page2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		// add pages to this wizard
		addPage(page1);
		addPage(page2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// create pages for this wizard
		page1 = new CreationPage(workbench, selection);

		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load type specification:";
		page2 = new WizardNewLinkPage("Add type graph", IResource.FILE);
		page2.setTitle("Include type graph");
		String filename = null;
		if(selection.getFirstElement() instanceof IResource){
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".dpf"))
				filename = DPFEditor.getModelFromDiagram(filename);
		}
		else
			filename = DPFEditor.getWorkspaceDirectory();
		page2.setLinkTarget(filename);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		return page1.finish();
	}

	/**
	 * This WizardPage can create an empty .shapes file for the ShapesEditor.
	 */
	private class CreationPage extends WizardNewFileCreationPage {

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
		 * @see DPFCreationWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("dpfCreationPage1", selection);
			this.workbench = workbench;
			setTitle("Create a new " + DEFAULT_EXTENSION + " file");
			setDescription("Create a new " + DEFAULT_EXTENSION + " file");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl(org
		 * .eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			super.createControl(parent);
			setFileName("dpfSpecification" + fileCount + DEFAULT_EXTENSION);
			setPageComplete(validatePage());
		}

		/** Return a new DPFDiagram instance. */
		private Object createDefaultContent() {
			return new DPFDiagram();
		}

		private static final String DEFAULT_EXTENSION = ".dpf";
		
		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see DPFCreationWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();
			fileCount++;
			String diagramFileName = newDiagramFile.getLocation().toOSString();
			String modelFileName = DPFEditor.getModelFromDiagram(diagramFileName);
			
			//Initialize model file and diagram file
			Specification newSpec = CoreFactory.eINSTANCE.createSpecification();
			DPFDiagram newDiagram = new DPFDiagram();
			
			// Gets null value when user does not check checkbox
			String typeModelFileName = page2.getLinkTarget();
			if (typeModelFileName != null) {
				// TODO: move to validation (when wrong file, user must be notified)
				Specification typeSpec = DPFEditor.loadDPFModel(typeModelFileName);
				DPFDiagram typeDiagram = DPFEditor.loadDPFDiagram(DPFEditor.getDiagramFromModel(typeModelFileName));
				newSpec.setTypeGraph(typeSpec.getGraph());
				newDiagram.setParent(typeDiagram);
			}else
				newSpec.setTypeGraph(DPFConstants.REFLEXIVE_TYPE_GRAPH);
			
			newDiagram.setDpfGraph(newSpec.getGraph());
			DPFEditor.saveDPFModel(modelFileName, newSpec);
			DPFEditor.saveDPFDiagram(diagramFileName, newDiagram);

			try {
				newDiagramFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e1) {
				DPFErrorReport.logError("Error happens when store new create DPF Specification", e1);
			} 
			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if (newDiagramFile != null && page != null) {
				try {
					IEditorPart editorPart = IDE.openEditor(page, newDiagramFile, true);
					if(editorPart != null)
						editorPart.setFocus();
				} catch (PartInitException e) {
					DPFErrorReport.logError("Error happens when Open DPF Editor", e);
					return false;
				}
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
		 */
		protected InputStream getInitialContents() {
			ByteArrayInputStream bais = null;
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(createDefaultContent()); // argument must be
															// Serializable
				oos.flush();
				oos.close();
				bais = new ByteArrayInputStream(baos.toByteArray());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return bais;
		}

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null
					&& getFileName().endsWith(DEFAULT_EXTENSION)) {
				return true;
			}
			setErrorMessage("The 'file' name must end with "
					+ DEFAULT_EXTENSION);
			return false;
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
