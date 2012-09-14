package no.hib.mums.shared;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.examples.common.ExamplesCommonPlugin;
import org.eclipse.graphiti.examples.common.FileService;
import org.eclipse.graphiti.examples.common.navigator.nodes.base.AbstractInstancesOfTypeContainerNode;
import org.eclipse.graphiti.examples.common.ui.DiagramNameWizardPage;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class NewDiagramWizard extends BasicNewResourceWizard {
	protected String diagramName = "Diagram name";
	protected String wizardWindowTitle = "New Diagram";

	protected Diagram diagram; 
	protected String diagramTypeId;
	protected String diagramTypeProviderId;
	
	protected IProject project = null;
	protected IFolder diagramFolder = null;
	
	public NewDiagramWizard(String wizardTitle, String diagramTitle, String typeId) {
		this.wizardWindowTitle = wizardTitle;
		this.diagramName = diagramTitle;
		this.diagramTypeId = typeId;
	}
	
	@Override
	public void addPages() {
//		addPage(new DiagramTypeWizardPage(PAGE_NAME_DIAGRAM_TYPE));
		addPage(new DiagramNameWizardPage(diagramName, wizardWindowTitle, null));
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
	}

	protected boolean createFolders(Object element) {
		if (element instanceof IProject) {
			project = (IProject) element;
		} 
		//FIXME: These cases are "hardcoded". The graphiti plugin probably does some 
		//adaptation in the plugin.xml to avoid this. 
		else if (element instanceof IJavaProject) {
			project = ((IJavaProject)element).getProject();
		} else if (element instanceof IPackageFragmentRoot) {
			project = ((IPackageFragmentRoot)element).getJavaProject().getProject();
		}	
		
		else if (element instanceof AbstractInstancesOfTypeContainerNode) {
			AbstractInstancesOfTypeContainerNode aiocn = (AbstractInstancesOfTypeContainerNode) element;
			project = aiocn.getProject();
		} else if (element instanceof IFolder) {
			diagramFolder = (IFolder) element;
			project = diagramFolder.getProject();
		}

		if (project == null || !project.isAccessible()) {
			String error = "Error creating diagram";
			IStatus status = new Status(IStatus.ERROR, ExamplesCommonPlugin.getID(), error);
			ErrorDialog.openError(getShell(), "No project found", null, status);
			return false;
		}

		if (diagramFolder == null) {
			diagramFolder = project.getFolder("src"); //$NON-NLS-1$
		}
		return true;
	}
	
	@Override
	public boolean performFinish() {
//		ITextProvider typePage = (ITextProvider) getPage(PAGE_NAME_DIAGRAM_TYPE);
//		final String diagramTypeId = typePage.getText();

		DiagramNameWizardPage namePage = (DiagramNameWizardPage) getPage(diagramName);
		final String diagramName = namePage.getText();

		diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, diagramName, true);

		boolean res = createFolders(getSelection().getFirstElement());
		if(!res) return false;

		String editorID = DiagramEditor.DIAGRAM_EDITOR_ID;
		String defaultEditorExtension = "diagram"; //$NON-NLS-1$
		diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagramTypeId);
		
		//We strip away the last part of the diagramTypeId id. Might not be the proper naming convention.
		String editorName[] = diagramTypeProviderId.split("\\.");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < editorName.length-1; ++i) {
			sb.append(editorName[i]+".");
		}
		sb.append("editor"); //$NON-NLS-1$
		
		String namingConventionID = sb.toString();
		IEditorDescriptor specificEditor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(namingConventionID);

		// If there is a specific editor get the file extension
		if (specificEditor != null) {
			editorID = namingConventionID;
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint("org.eclipse.ui.editors"); //$NON-NLS-1$
			IExtension[] extensions = extensionPoint.getExtensions();
			for (IExtension ext : extensions) {
				IConfigurationElement[] configurationElements = ext.getConfigurationElements();
				for (IConfigurationElement ce : configurationElements) {
					String id = ce.getAttribute("id"); //$NON-NLS-1$
					if (editorID.equals(id)) {
						String fileExt = ce.getAttribute("extensions"); //$NON-NLS-1$
						if (fileExt != null) {
							defaultEditorExtension = fileExt;
							break;
						}
					}

				}
			}
		}

		IFile diagramFile = diagramFolder.getFile(diagramName + "." + defaultEditorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		FileService.createEmfFileForDiagram(uri, diagram);
		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(EcoreUtil.getURI(diagram), providerId);

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, editorID);
		} catch (PartInitException e) {
			String error = "lol";
			IStatus status = new Status(IStatus.ERROR, ExamplesCommonPlugin.getID(), error, e);
			ErrorDialog.openError(getShell(), "lol", null, status);
			return false;
		}

		return true;
	}
	
	public String getDiagramName() {
		return diagramName;
	}

	public String getDiagramTypeId() {
		return diagramTypeId;
	}
	
	public String getDiagramTypeProviderId() {
		return diagramTypeProviderId;
	}
	
	public Diagram getDiagram() {
		return diagram;
	}
}
