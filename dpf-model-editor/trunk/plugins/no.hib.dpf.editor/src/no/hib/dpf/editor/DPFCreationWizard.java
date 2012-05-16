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

import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;

import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

/**
 * Create a new .dpf-file.
 */
@SuppressWarnings("restriction")
public class DPFCreationWizard extends Wizard implements INewWizard {

	private static int fileCount = 1;
	private CreationPage createPage = null;
	private WizardNewLinkPage typeLinkPage = null;
	private WizardNewLinkPage signatureLinkPage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		// add pages to this wizard
		addPage(createPage);
		addPage(typeLinkPage);
		addPage(signatureLinkPage);
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

		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
		typeLinkPage = new WizardNewLinkPage("Add type graph", IResource.FILE);
		typeLinkPage.setTitle("Include type graph");
		String filename = null;
		IContainer parentResource = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			parentResource = (IContainer)selection.getFirstElement();
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".xmi"))
				filename = DPFEditor.getDiagramFromModel(filename);
		} else
			filename = DPFEditor.getWorkspaceDirectory();
		
		typeLinkPage.setLinkTarget(filename);
		typeLinkPage.setContainer(parentResource);
		
		signatureLinkPage = new WizardNewLinkPage("Add Signature", IResource.FILE);
		signatureLinkPage.setTitle("Include Signature");
		signatureLinkPage.setLinkTarget(filename);
		signatureLinkPage.setContainer(parentResource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		return createPage.finish();
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
			setTitle("Create a new " + DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION + " file");
			setDescription("Create a new " + DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION + " file");
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
			setFileName("dpfSpecification" + fileCount + DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION);
			setPageComplete(validatePage());
		}

		
		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see DPFCreationWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();
			fileCount++;
			URI newDiagarmURI = DPFCoreUtil.getFileURI(newDiagramFile);
			//Initialize model file and diagram file
			DSpecification newSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();

			// Gets null value when user does not check checkbox
			String typeModelFileName = typeLinkPage.getLinkTarget();
			DSpecification typeSpec = null;
			ResourceSetImpl resourceSet = DPFEditor.getResourceSet();
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			if(typeModelFileName != null){
				typeSpec = DPFEditor.loadDSpecification(resourceSet, URI.createFileURI(typeModelFileName), resourceToDiagnosticMap);
				EcoreUtil.resolveAll(typeSpec);
			}
			newSpec.setDType(typeSpec != null ? typeSpec : REFLEXIVE_DSPECIFICATION);

			String signatureFileName = signatureLinkPage.getLinkTarget();
			if(signatureFileName != null){
				DSignature signature = DPFEditor.loadDSignature(resourceSet, URI.createFileURI(signatureFileName), resourceToDiagnosticMap);
				EcoreUtil.resolveAll(signature);
				newSpec.setDSignature(signature);
			}
			if(newSpec.getDSignature() == null && newSpec.getDType() != null)
				newSpec.setDSignature(newSpec.getDType().getDSignature());
			
			DPFEditor.updateResourceSet(resourceSet, newSpec, null, newDiagarmURI);
			try {
				DPFEditor.saveDSpecification(resourceSet, newSpec, newDiagarmURI, resourceToDiagnosticMap);
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

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null && getFileName().endsWith(DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION)) 
				return true;
			setErrorMessage("The 'file' name must end with " + DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION);
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
