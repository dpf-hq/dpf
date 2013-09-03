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

import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.rules.CorrespondanceGraph;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.transform.util.TransformConstants;

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
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

/**
 * Create a new .xform-file.
 */
@SuppressWarnings("restriction")
public class DPFCreationWizard extends Wizard implements INewWizard {

	private CreationPage createPage = null;
	private TransformWizardPage configPage = null;
	

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

		DPFUtils.updateFileName(createPage, selection, "specification", "xform");
		IDEWorkbenchMessages.WizardNewLinkPage_linkFileButton = "Load File:";
		configPage = new TransformWizardPage("The wizard id does not matter");
		configPage.setTitle("Choose source, target metamodel and signature");
		configPage.setDescription("The page allows you to choose your own source metamodel, target metamodel and customed signature. " +
				"The default metamodel and signature will be used if you check default metamodel and default signature. " + 
				"This model transformation will be a endogenous model transformation if you check target metamodel");
		
		String filename = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".xmi"))
				filename = DPFUtils.getDiagramFromModel(filename);
		} else
			filename = DPFEditor.getWorkspaceDirectory();
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

	public static final String TRANSFORM_EXTENSION = ".xform";
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
		 * @see DPFCreationWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("dpfCreationPage1", selection);
			this.workbench = workbench;
			setTitle("Create a new xform file");
			setDescription("Create a new xform file");
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see DPFCreationWizard#performFinish()
		 */
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();
			URI newDiagarmURI = DPFUtils.getFileURI(newDiagramFile);
			//Initialize model file and diagram file
			Transform transform = TransformFactory.eINSTANCE.createTransform();
			
			ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();


			
			String sourceTypeModelFileName = configPage.getSourceMetaModelURI();
			
			if(sourceTypeModelFileName!=null){
				transform.setSourceLocation(sourceTypeModelFileName);
			}
			
			DSpecification sourceTypeSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
			sourceTypeSpec.setDType(configPage.getSourceMetaModel());
			
			if(sourceTypeModelFileName != null){
				sourceTypeSpec = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(sourceTypeModelFileName), resourceToDiagnosticMap);
				//typeSpec = DPFUtils.loadDModel(resourceSet, URI.createFileURI(typeModelFileName), resourceToDiagnosticMap);
				//typeSpec = DPFUtils.loadDSpecification(URI.createFileURI(typeModelFileName));
				EcoreUtil.resolveAll(sourceTypeSpec);
			}
			//transform.setMetaModel(typeSpec != null ? typeSpec : DPFConstants.REFLEXIVE_DSPECIFICATION);
			transform.setSourceMetaModel(sourceTypeSpec != null ? sourceTypeSpec : DPFConstants.REFLEXIVE_DSPECIFICATION);
			System.out.println("DSPec " + transform.getSourceMetaModel().getDType().getDGraph().getDNodes());
			
			String targetTypeModelFileName = configPage.getTargetMetaModelURI();
			
			if(targetTypeModelFileName!=null){
				transform.setTargetLocation(targetTypeModelFileName);
			}
			
			DSpecification targetTypeSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
			targetTypeSpec.setDType(configPage.getTargetMetaModel());
			
			if(targetTypeModelFileName != null){
				targetTypeSpec = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(targetTypeModelFileName), resourceToDiagnosticMap);
				EcoreUtil.resolveAll(targetTypeSpec);
			}
			transform.setTargetMetaModel(targetTypeSpec != null ? targetTypeSpec : DPFConstants.REFLEXIVE_DSPECIFICATION);

			String uri = "C:/Users/Petter/runtime-EclipseApplication/model/CorrespondanceModel.dpf";
			
			DSpecification correspondanceSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
			
			if(uri != null){
				correspondanceSpec = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(uri), resourceToDiagnosticMap);
			}
			
			transform.setCommonGraph(correspondanceSpec);
			
			try {
				TransformEditor.saveTransform(resourceSet, newDiagarmURI, transform, resourceToDiagnosticMap);
				newDiagramFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e1) {
				DPFUtils.logError("Error happens when store new create DPF Specification", e1);
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
			if (getFileName() != null && getFileName().endsWith("xform"))
				return true;
			//setErrorMessage("The 'file' name must end with " + DPFUtils.DEFAULT_DIAGRAM_MODEL_EXTENSION);
			setErrorMessage("The 'file' name must end with xform");
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
