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

import no.hib.dpf.core.Specification;
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

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
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
	
	protected Specification specification = null;

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

		private boolean createSourceLink = false;
		private boolean createTargetLink = false;
		
		private Text createSourceField;
		private Text createTargetField;
		
		private Button browseSourceButton;
		private Button browseTargetButton;
		
		
		
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
			
			initializeDialogUnits(parent);
			
			//Composite topLevel = new Composite(parent, SWT.NONE);
			//GridLayout layout = new GridLayout();
			
			Composite topLevel = new Composite(parent, SWT.NONE); {
				Font font = parent.getFont();
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				topLevel.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.grabExcessVerticalSpace = true;
				topLevel.setFont(font);
				topLevel.setLayoutData(data);
			}
			
			final Button createSourceLinkButton = new Button(topLevel, SWT.CHECK);
			
			createSourceLinkButton.setText("Load &Source Specification");
			createSourceLinkButton.setSelection(createSourceLink);
			GridData newData = new GridData();
			newData.horizontalSpan = 2;
			createSourceLinkButton.setLayoutData(newData);
			createSourceLinkButton.setFont(parent.getFont());
			
			SelectionListener sourceListener = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					createSourceLink = createSourceLinkButton.getSelection();
					createSourceField.setEnabled(createSourceLink);
					browseSourceButton.setEnabled(createSourceLink);
				}
			};
			createSourceLinkButton.addSelectionListener(sourceListener);
			
			createSourceField = new Text(topLevel, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				createSourceField.setLayoutData(data);
				createSourceField.setEnabled(createSourceLink);
			}
			
			browseSourceButton = new Button(topLevel, SWT.PUSH);
			{
				setButtonLayoutData(browseSourceButton);
				browseSourceButton.setText("&Browse...");
				browseSourceButton.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent event) {
						browseButtonPressed(createSourceField, "*.dpf");
						specification = DPFCoreUtil.loadSpecification(URI.createFileURI(createSourceField.getText()));
						
					}
				});
				browseSourceButton.setEnabled(createSourceLink);
			}
			
			final Button createTargetLinkButton = new Button(topLevel, SWT.CHECK);
			
			createTargetLinkButton.setText("Load &Target Specification");
			createTargetLinkButton.setSelection(createTargetLink);
			createTargetLinkButton.setLayoutData(newData);
			createTargetLinkButton.setFont(parent.getFont());
			
			SelectionListener targetListener = new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					createTargetLink = createTargetLinkButton.getSelection();
					createTargetField.setEnabled(createTargetLink);
					browseTargetButton.setEnabled(createTargetLink);
				}
			};	
			
			createTargetLinkButton.addSelectionListener(targetListener);
			
			createTargetField = new Text(topLevel, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				createTargetField.setLayoutData(data);
				createTargetField.setEnabled(createTargetLink);
			}
			
			browseTargetButton = new Button(topLevel, SWT.PUSH);
			{
				setButtonLayoutData(browseTargetButton);
				browseTargetButton.setText("&Browse...");
				browseTargetButton.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent event) {
						browseButtonPressed(createTargetField, "*.dpf");
					}
				});
				browseTargetButton.setEnabled(createTargetLink);
			}
		}
		private void browseButtonPressed(Text field, String filterExtensions) {
			String targetName = field.getText();
			String selection = null;
			IFileStore store = null;
			
			if(targetName.length() > 0){
				store = getFileStore(targetName);
				if(store == null || !store.fetchInfo().exists()){
					store = null;
				}
			}
			
			FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
			fileDialog.setFilterExtensions(new String[]{filterExtensions, "*"});
			
			if(store != null){
				if(store.fetchInfo().isDirectory()){
					fileDialog.setFilterPath(targetName);
				}
				else{
					fileDialog.setFileName(targetName);
				}
			}
	
	        selection = fileDialog.open();
	        
	        if (selection != null) {
	        	field.setText(selection);
	        }
			
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
	 /**
		 * Get the file store for the string.
		 * 
		 * @param string
		 * @return IFileStore or <code>null</code> if there is a
		 *         {@link CoreException}.
		 */
		public static IFileStore getFileStore(String string) {
			return getFileStore(new Path(string).toFile().toURI());
		}

		/**
		 * Get the file store for the URI.
		 * 
		 * @param uri
		 * @return IFileStore or <code>null</code> if there is a
		 *         {@link CoreException}.
		 */
		public static IFileStore getFileStore(java.net.URI uri) {
			try {
				return EFS.getStore(uri);
			} catch (CoreException e) {
				e.printStackTrace();
				return null;
			}
		}
}
