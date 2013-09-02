package no.hib.dpf.transform.presentation;

import org.eclipse.swt.widgets.FileDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.henshin.ApplyTransformation;
import no.hib.dpf.transform.henshin.TranslateToEcore;
import no.hib.dpf.transform.henshin.TranslateToHenshinRules;
import no.hib.dpf.transform.icons.ImageSettings;
import no.hib.dpf.transform.provider.TransformEditPlugin;
import no.hib.dpf.transform.rules.CorrespondanceGraph;
import no.hib.dpf.transform.util.BrowseInstanceModel;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.transform.util.TransformConstants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.gef.ui.actions.ZoomInRetargetAction;
import org.eclipse.gef.ui.actions.ZoomOutRetargetAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;
import org.eclipse.ui.ide.IDE;

@SuppressWarnings("restriction")
public class TransformActionBarContributor extends ActionBarContributor {

	// Action action = new Action("Generate" ,
	// ImageSettings.IMG_GENERATE.getImageDescriptor()) {
	// };
	protected IEditorPart activeEditorPart;
	//private RetargetAction generateAction;

	protected IAction generateToEcore = new Action(TransformConstants.GENERATE_ECORE, ImageSettings.IMG_GENERATE_ECORE.getImageDescriptor()) {
		
		
		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public void run() {
			DSpecification dspec = null;
			
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformUtils.activeWindowFileLocation()), resourceToDiagnosticMap);
			
			URI source = URI.createFileURI(transform.getSourceLocation());
			URI target = URI.createFileURI(transform.getTargetLocation());
			
			String dpfFilename = TransformUtils.activeWorkingDirectory()+"\\"+TransformUtils.createCorrespondanceType(source.lastSegment().replace(".dpf", ""), 
					target.lastSegment());
			String xmiFilename = TransformUtils.activeWorkingDirectory()+"\\"+TransformUtils.createCorrespondanceType(source.lastSegment().replace(".dpf", ""), 
					target.lastSegment().replace(".dpf", "xmi"));
			System.out.println("1" + dpfFilename);
			URI newDiagramUri = URI.createFileURI(dpfFilename);
			URI newCoreUri = URI.createFileURI(xmiFilename);

			CorrespondanceGraph cGraph = new CorrespondanceGraph();
			dspec = cGraph.createCorrespondanceGraph();
			
			DSpecification newDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
			newDSpecification.setDType(dspec);
			newDSpecification.setDSignature(DiagramFactory.eINSTANCE.createDefaultDSignature());

			File dpfFile = new File(newDiagramUri.toFileString());
			File xmiFile = new File(newCoreUri.toFileString());
			if(dpfFile.exists()){
				xmiFile.delete();
				dpfFile.delete();
			}
			DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), newDSpecification, newDiagramUri, new LinkedHashMap<Resource, Diagnostic>());
		}
	};
	protected IAction generateToHenshin = new Action(TransformConstants.GENERATE_HENSHIN, ImageSettings.IMG_GENERATE_HENSHIN.getImageDescriptor()) {
		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public void run() {
			TranslateToHenshinRules.generateHenshinModule(true);
		}
	};
	protected IAction executeTransformation = new Action(TransformConstants.EXECUTE_TRANSFORMATION, ImageSettings.IMG_EXECUTE_TRANFORMATION.getImageDescriptor()) {
		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public void run() {
			//ApplyTransformation.exeucteTransformation("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.xmi", true);
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformUtils.activeWindowFileLocation()), resourceToDiagnosticMap);
			BrowseInstanceModel br = new BrowseInstanceModel(TransformUtils.getActiveWorkBenchWindow().getShell(), transform);
			if(br.open() == Window.OK){
//				String xmiPath = br.getModelInstanceFilePath().replace(".dpf", ".xmi");
				ApplyTransformation.exeucteTransformation(br.getModelInstanceFilePath(), true);
			}
			
//			FileDialog file = new FileDialog(TransformActivePage.getActiveWorkBenchWindow().getShell());
//			file.open();
//			WizardDialog wizardDialog = new WizardDialog(TransformActivePage.getActiveWorkBenchWindow().getShell(),
//				      new BrowseInstance());
//				    if (wizardDialog.open() == Window.OK) {
//				      System.out.println("Ok pressed");
//				    } else {
//				      System.out.println("Cancel pressed");
//				    }
		}
	};

	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;
	}

	@Override
	protected void buildActions() {
		addRetargetAction(new DeleteRetargetAction());
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));

		toolBarManager.add(new Separator());

		toolBarManager.add(generateToEcore);
		toolBarManager.add(generateToHenshin);
		toolBarManager.add(executeTransformation);
	}

	@Override
	protected void declareGlobalActionKeys() {
		// TODO Auto-generated method stub

	}

	@Override
	public void contributeToMenu(IMenuManager menubar) {
		super.contributeToMenu(menubar);
		MenuManager viewMenu = new MenuManager("Transform Editor");
		viewMenu.add(generateToEcore);
		viewMenu.add(generateToHenshin);
		viewMenu.add(executeTransformation);
		menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
	}
}
