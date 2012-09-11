/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.presentation;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.editor.wizards.DPFCreationWizard;
import no.hib.dpf.editor.wizards.DPFWizardPage;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.utils.DPFCoreUtil;

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


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class TransformModelWizard extends Wizard implements INewWizard {

	protected List<String> initialObjectNames;
	private static int fileCount = 1;
	private CreationPage createPage = null;
	private DPFWizardPage typeLinkPage = null;
	private DPFWizardPage signatureLinkPage;

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

		typeLinkPage = new DPFWizardPage("Add type graph", "Type graph");
		String[] tmp = {"*" + DPFEditor.DEFAULT_DIAGRAM_MODEL_EXTENSION};
		typeLinkPage.setFileDialogFilters(tmp, tmp);
		
		typeLinkPage.setTitle("Include type graph");
		String filename = null;
		
		if(selection.getFirstElement() instanceof IResource) {
			filename = ((IResource)selection.getFirstElement()).getLocation().toOSString();
			if(filename.endsWith(".xmi"))
				filename = DPFEditor.getDiagramFromModel(filename);
		} else
			filename = DPFEditor.getWorkspaceDirectory();
		
		typeLinkPage.setLinkTarget(filename);
		
		signatureLinkPage = new DPFWizardPage("Add Signature", "Signature");
		tmp = new String[] { "*.sig"};
		signatureLinkPage.setFileDialogFilters(tmp, tmp);
		signatureLinkPage.setTitle("Include signature");
		signatureLinkPage.setLinkTarget(filename);
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
			setTitle("Create a new  " + TRANSFORM_EXTENSION + " file");
			setDescription("Create a new  " + TRANSFORM_EXTENSION + " file");
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
			setFileName("transform" + fileCount + TRANSFORM_EXTENSION);
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
			Transform transform = TransformFactory.eINSTANCE.createTransform();

			// Gets null value when user does not check checkbox
			String typeModelFileName = typeLinkPage.getLinkTarget();
			DSpecification typeSpec = null;
			ResourceSetImpl resourceSet = TransformEditor.getResourceSet();
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			if(typeModelFileName != null){
				typeSpec = DPFEditor.loadDSpecification(resourceSet, URI.createFileURI(typeModelFileName), resourceToDiagnosticMap);
				EcoreUtil.resolveAll(typeSpec);
			}
			transform.setMetaModel(typeSpec != null ? typeSpec : DPFConstants.REFLEXIVE_DSPECIFICATION);

			String signatureFileName = signatureLinkPage.getLinkTarget();
			DSignature signature = null;
			if(signatureFileName != null){
				signature = DPFEditor.loadDSignature(resourceSet, URI.createFileURI(signatureFileName), resourceToDiagnosticMap);
				EcoreUtil.resolveAll(signature);
			}
			transform.setDSignature(signature == null ? DPFConstants.DEFAULT_DSIGNATURE : signature);
			
			try {
				TransformEditor.saveTransform(resourceSet, newDiagarmURI, transform, resourceToDiagnosticMap);
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
			if (getFileName() != null && getFileName().endsWith(TRANSFORM_EXTENSION)) 
				return true;
			setErrorMessage("The 'file' name must end with " + TRANSFORM_EXTENSION);
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
