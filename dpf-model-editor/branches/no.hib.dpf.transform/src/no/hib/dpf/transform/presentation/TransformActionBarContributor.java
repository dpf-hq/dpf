package no.hib.dpf.transform.presentation;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.henshin.ApplyTransformation;
import no.hib.dpf.transform.henshin.TranslateToHenshinRules;
import no.hib.dpf.transform.icons.ImageSettings;
import no.hib.dpf.transform.rules.CorrespondanceGraph;
import no.hib.dpf.transform.util.BrowseInstanceModel;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.AlignmentRetargetAction;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;

@SuppressWarnings("restriction")
public class TransformActionBarContributor extends ActionBarContributor {

	protected IEditorPart activeEditorPart;

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
			Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
			Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformUtils.activeWindowFileLocation()), resourceToDiagnosticMap);
			BrowseInstanceModel br = new BrowseInstanceModel(TransformUtils.getActiveWorkBenchWindow().getShell(), transform);
			if(br.open() == Window.OK){
				ApplyTransformation.exeucteTransformation(br.getModelInstanceFilePath(), true, br.getTargetModelName());
			}
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
		
		
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.LEFT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.CENTER));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.RIGHT));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.TOP));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.MIDDLE));
		addRetargetAction(new AlignmentRetargetAction(PositionConstants.BOTTOM));
		
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));

		toolBarManager.add(new Separator());
		
		toolBarManager.add(generateToHenshin);
		toolBarManager.add(executeTransformation);
		

		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_LEFT));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_CENTER));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_RIGHT));
		toolBarManager.add(new Separator());
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_TOP));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_MIDDLE));
		toolBarManager.add(getAction(GEFActionConstants.ALIGN_BOTTOM));
		
	}

	@Override
	public void contributeToMenu(IMenuManager menubar) {
		super.contributeToMenu(menubar);
		MenuManager viewMenu = new MenuManager("Transform Editor");
		viewMenu.add(generateToHenshin);
		viewMenu.add(executeTransformation);
		menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
	}

	@Override
	protected void declareGlobalActionKeys() {
		// TODO Auto-generated method stub
		
	}
}
