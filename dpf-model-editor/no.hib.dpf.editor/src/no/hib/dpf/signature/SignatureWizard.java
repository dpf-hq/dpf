package no.hib.dpf.signature;

import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFErrorReport;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
 * Create a new .sig file.
 */
public class SignatureWizard extends Wizard implements INewWizard {

	private static int fileCount = 1;
	private CreationPage createPage = null;

	public void addPages() {
		// add pages to this wizard
		addPage(createPage);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// create pages for this wizard
		createPage = new CreationPage(workbench, selection);
	}

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
		 * @see SignatureWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("Signature Creation", selection);
			this.workbench = workbench;
			setTitle("Create a new Signature file");
			setDescription("Create a new Signature file");
		}

		public void createControl(Composite parent) {
			super.createControl(parent);
			setFileName("signature" + fileCount + "." + SIGNATURE_EXTENSTION);
			setPageComplete(validatePage());
		}

		public static final String SIGNATURE_EXTENSTION = "sig";
		
		boolean finish() {
			// create a new diagram file, result != null if successful
			IFile newDiagramFile = createNewFile();
			fileCount++;
			ResourceSetImpl resourceSet = SignatureEditor.getResourceSet();
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			//Initialize signature 
			DSignature dSignature = DiagramFactory.eINSTANCE.createDSignature();
			try {
				SignatureEditor.saveDSignature(resourceSet, URI.createFileURI(newDiagramFile.getLocation().toOSString()), dSignature, resourceToDiagnosticMap);
				newDiagramFile.getParent().refreshLocal(IResource.DEPTH_ONE, null);
			} catch (CoreException e1) {
				DPFErrorReport.logError(e1);
				return false;
			} 
			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if (newDiagramFile != null && page != null) {
				try {
					IEditorPart editorPart = IDE.openEditor(page, newDiagramFile, true);
					if(editorPart != null)
						editorPart.setFocus();
				} catch (PartInitException e) {
					DPFErrorReport.logError(e);
					return false;
				}
			}
			return true;
		}

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null && getFileName().endsWith(SIGNATURE_EXTENSTION)) 
				return true;
			setErrorMessage("The 'file' name must end with " + SIGNATURE_EXTENSTION);
			return false;
		}

		protected boolean validatePage() {
			return super.validatePage() && validateFilename();
		}
	}
}

