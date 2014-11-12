package no.hib.mums.shipmaker.ui;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.graphiti.examples.common.ui.DiagramNameWizardPage;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import no.hib.mums.shared.MumsConstants;
import no.hib.mums.shared.NewDiagramWizard;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.FeatureProvider;

public class NewShipDiagramWizard extends NewDiagramWizard {

	private final static String WIZARD_TITLE = "New ShipMaker Diagram";
	private final static String DIAGRAM_TITLE = "ShipMaker Diagram";

	private DPFWizardPage partDiagramPage;

	public NewShipDiagramWizard() {
		super(WIZARD_TITLE, DIAGRAM_TITLE, MumsConstants.SHIPMAKER_DIAGRAM_TYPE);
	}

	@Override
	public void addPages() {
		super.addPages();
		addPage(partDiagramPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);

		partDiagramPage = new DPFWizardPage(WIZARD_TITLE, "PartMaker Diagram");
		String[] tmp = { "*.dpf.part" };
		partDiagramPage.setFileDialogFilters(tmp, tmp);
		partDiagramPage.setTitle(WIZARD_TITLE);
		partDiagramPage.setDescription("Create new " + DIAGRAM_TITLE);
	}

	@Override
	public boolean performFinish() {
		DiagramNameWizardPage namePage = (DiagramNameWizardPage) getPage(diagramName);
		final String diagramName = namePage.getText();

		createFolders(getSelection().getFirstElement());
		boolean res = createFolders(getSelection().getFirstElement());
		if (!res)
			return false;

		diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId,
				diagramName, true);

		String editorID = DiagramEditor.DIAGRAM_EDITOR_ID;
		String defaultEditorExtension = "diagram"; //$NON-NLS-1$
		diagramTypeProviderId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId(diagramTypeId);

		// We strip away the last part of the diagramTypeId id. Might not be the
		// proper naming convention.
		String editorName[] = diagramTypeProviderId.split("\\.");
		StringBuilder sbb = new StringBuilder();

		for (int i = 0; i < editorName.length - 1; ++i) {
			sbb.append(editorName[i] + ".");
		}
		sbb.append("editor"); //$NON-NLS-1$

		String namingConventionID = sbb.toString();
		IEditorDescriptor specificEditor = PlatformUI.getWorkbench()
				.getEditorRegistry().findEditor(namingConventionID);

		// If there is a specific editor get the file extension
		if (specificEditor != null) {
			editorID = namingConventionID;
			IExtensionRegistry extensionRegistry = Platform
					.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry
					.getExtensionPoint("org.eclipse.ui.editors"); //$NON-NLS-1$
			IExtension[] extensions = extensionPoint.getExtensions();
			for (IExtension ext : extensions) {
				IConfigurationElement[] configurationElements = ext
						.getConfigurationElements();
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

		IFile diagramFile = diagramFolder.getFile(diagramName
				+ "." + defaultEditorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath()
				.toString(), true);

		FileService.createEmfFileForDiagram(uri, getDiagram());

		String[] path = partDiagramPage.getLinkTarget().split("\\.");
		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < path.length - 1; i++) {
			sb.append(path[i] + ".");
		}
		sb.append("xmi");

		HashMap<String, String> settings = new HashMap<String, String>();
		settings.put(diagramFile.getFullPath().toOSString(), sb.toString());
		writeSettings(diagramFile.getProject(), settings);

		String providerId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(
				EcoreUtil.getURI(diagram), providerId);

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(editorInput, editorID);
		} catch (PartInitException e) {
			String error = "lol";
			IStatus status = new Status(IStatus.ERROR,
					ExamplesCommonPlugin.getID(), error, e);
			ErrorDialog.openError(getShell(), "lol", null, status);
		}

		DiagramEditor de = (DiagramEditor) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DiagramTypeProvider dtp = (DiagramTypeProvider) de
				.getDiagramTypeProvider();

		FeatureProvider fp = (FeatureProvider) dtp.getFeatureProvider();
		fp.init();

		return true;
	}

	private void writeSettings(IProject project, Map<String, String> settings) {
		IFile f = project.getFile(".settings/no.hib.mums.shipmaker.prefs");
		if (f == null || !f.exists()) {
			try {
				f.create(new ByteArrayInputStream("".getBytes()), false, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		Assert.isTrue(f.exists());

		PreferenceStore store = new PreferenceStore();

		try {
			store.load(f.getContents());
			for (String s : settings.keySet()) {
				store.setValue(s, settings.get(s));
			}
			store.save(new FileOutputStream(f.getLocation().toOSString()),
					"ShipMaker properties file");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
