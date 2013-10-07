/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Hï¿½yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * ï¿½yvind Bech and Dag Viggo Lokï¿½en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.transform.presentation;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.parts.TransformArrowLabelEditPart;
import no.hib.dpf.transform.parts.TransformDArrowEditPart;
import no.hib.dpf.transform.parts.TransformDNodeEditPart;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * A graphical editor with flyout palette that can edit .dpf files. The
 * binding between the .dpf file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public abstract class ProductionEditor extends GraphicalEditorWithFlyoutPalette{

	/** This is the root of the editor's model. */

	protected Production production;

	//	/** Palette component, holding the tools and shapes. */
	protected Transform transform = null;
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	protected PaletteRoot paletteRoot;

	private DPFEditPartFactory shapesEditPartFactory;
	protected DPFTransformPaletteFactory paletteFactory;

	protected DSpecification dspec = null;
	
	protected PropertySheetPage propertySheetPage;


	public void setProduction(Production prod){
		production = prod;
	}
	
	public ProductionEditor(){
		paletteFactory = new DPFTransformPaletteFactory();
	}
	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>
	 * This is the place to choose an appropriate RootEditPart and
	 * EditPartFactory for your editor. The RootEditPart determines the behavior
	 * of the editor's "work-area". For example, GEF includes zoomable and
	 * scrollable root edit parts. The EditPartFactory maps model elements to
	 * edit parts (controllers).
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	 public void createPartControl(Composite parent) {
		 super.createPartControl(parent);
		
		 
	 }
	 
	 public DPFTransformPaletteFactory getpaletteFactory(){
		 return paletteFactory;
	 }
	
	 protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		String transformFile = TransformUtils.activeWindowFileLocation();
		transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(transformFile), resourceToDiagnosticMap);
		DSpecification defaultDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		defaultDSpecification.setDType(DiagramFactory.eINSTANCE.createDefaultDSpecification());
		
		DGraph newGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		


		DSpecification sourceDSpecification = transform.getSourceMetaModel();
		DSpecification targetDSpecification = transform.getTargetMetaModel();
		
		if(sourceDSpecification!=targetDSpecification && !targetDSpecification.getDGraph().getDNodes().isEmpty()){
			//commonGraph.setGraph(DiagramFactory.eINSTANCE.createDefaultDSpecification());

			System.out.println("Like");
			
			newGraph = setDGraphForExogenousTransformation(sourceDSpecification, targetDSpecification, transformFile);
//			EditPartGraph cGraph = new EditPartGraph();
//			dspec = cGraph.getCommonGraph();
//			dspec.setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
//			dspec.setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
//			
			String uri = "C:/Users/Petter/runtime-EclipseApplication/model/CorrespondanceModel.dpf";
//			
//			CorrespondanceGraph graph = new CorrespondanceGraph();
//			dspec = graph.getCommonGraph(sourceDSpecification, targetDSpecification);
//			
			dspec = transform.getCommonGraph();
//			dspec = DPFUtils.loadDSpecification(DPFUtils.getResourceSet(), URI.createFileURI(uri), resourceToDiagnosticMap);
//			EcoreUtil.resolveAll(dspec);
			
			for(int i = 0;i<dspec.getDGraph().getDNodes().size();i++){
				System.out.println(i+ " Name: " + dspec.getDGraph().getDNodes().get(i).getName() + " " + dspec.getDGraph().getDNodes().get(i).getTypeName());
			}
			
			newGraph = dspec.getDType().getDGraph();
		}
		else{
			System.out.println("Ulike");
			newGraph = sourceDSpecification.getDGraph();
		}
		for(int i = 0;i<newGraph.getDNodes().size();i++){
			System.out.println(newGraph.getDNodes().get(i).getName());
		}
		
		GraphicalViewer viewer = getGraphicalViewer();
		//paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDType().getDGraph());
		//paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDGraph());
		

		paletteFactory.updatePalette(getPaletteRoot(), newGraph);

//		paletteFactory.updatePalette(getPaletteRoot(), dspec.getDGraph());
		//paletteFactory.updatePaletteForExogenous(getPaletteRoot(), sourceDSpecification.getDGraph(), targetDSpecification.getDGraph());
		
		shapesEditPartFactory = new DPFEditPartFactory(){
			protected EditPart getPartForElement(Object modelElement) {
//				System.out.println("Her " + modelElement.toString());
//				EObject object = (EObject) modelElement;
//				Production prod = (Production) object.eContainer().eContainer();
//				if(prod.getName().contains(TransformConstants.CORRESPONDACE_GRAPH)){
//					System.out.println("her");
//				}
//				System.out.println(object.eContainer().eContainer());
//				if (modelElement instanceof DGraph) {
//					return new DGraphEditPart(){
//						protected void createEditPolicies() {
//							super.createEditPolicies();
//							installEditPolicy("action", new ActionEditPolicy());
//						}
//					};
//				}
				if (modelElement instanceof DNode) {
					return new TransformDNodeEditPart(modelElement){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());
						}
					};
				}
				if (modelElement instanceof DArrow) {
					return new TransformDArrowEditPart(modelElement){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());
						}
					};
				}
				if (modelElement instanceof DOffset) {
					DOffset offset = (DOffset) modelElement;
					if(offset.eContainer() instanceof DArrow)
						return new TransformArrowLabelEditPart(offset);
				}
				if(modelElement instanceof DConstraint){
					return new DConstraintEditPart(){
						protected void createEditPolicies() {
							super.createEditPolicies();
							installEditPolicy("action", new ActionEditPolicy());	
						}
					};
				}
				return super.getPartForElement(modelElement);
			}
		};
		viewer.setEditPartFactory(shapesEditPartFactory);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		ContextMenuProvider cmProvider = new TranformEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}
		
	private DGraph setDGraphForExogenousTransformation(DSpecification sourceDSpecification, 
			DSpecification targetDSpecification, String transformFile){
		
		DGraph tempGraph = null;
		
		DGraph defaultDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		DNode defaultNode = DPFConstants.REFLEXIVE_TYPE_DNODE;
		DArrow defaultDArrow = DPFConstants.REFLEXIVE_TYPE_DARROW;
		
		EcoreUtil.resolveAll(targetDSpecification);
		EcoreUtil.resolveAll(targetDSpecification.getSpecification());
		
		Assert.isTrue(targetDSpecification != null);
		setPartName(transformFile);
		tempGraph = targetDSpecification.getDGraph();
		defaultDGraph = targetDSpecification.getDGraph();

		
//		tempGraph.getDNodes().addAll(targetDSpecification.getDGraph().getDNodes());
//		tempGraph.getDArrows().addAll(targetDSpecification.getDGraph().getDArrows());
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
			tempGraph.createDNode(sourceDSpecification.getDGraph().getDNodes().get(i).getName(), defaultNode);
		}
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode dSource = null;
			DNode dTarget = null;
			for(int j = 0;j<tempGraph.getDNodes().size();j++){
				if(tempGraph.getDNodes().get(j).getName().contains(dArrow.getDSource().getName())){
					dSource = tempGraph.getDNodes().get(j);
				}
			}
			for(int j = 0;j<tempGraph.getDNodes().size();j++){
				if(tempGraph.getDNodes().get(j).getName().contains(dArrow.getDTarget().getName())){
					dTarget = tempGraph.getDNodes().get(j);
				}
			}
			tempGraph.createDArrow(dArrow.getName(), dSource, dTarget, defaultDArrow);
		}
		//return tempGraph;
		return defaultDGraph;
	}

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}
	
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();	
//		getGraphicalViewer().setContents(dspec.getDGraph());
//		System.out.println("Hei");
	}
//	@Override
//	protected void setInput(IEditorInput input) {
//		super.setInput(input);
//		IFile file = ((IFileEditorInput) input).getFile();
//		dspec = DPFUtils.loadDSpecification(DPFUtils.getResourceSet(), DPFUtils.getFileURI(file), resourceToDiagnosticMap);
//		EcoreUtil.resolveAll(dspec);
//		EcoreUtil.resolveAll(dspec.getSpecification());
//		
//		if(dspec.getDSignature() != null){
//			EcoreUtil.resolveAll(dspec.getDSignature());
//			EcoreUtil.resolveAll(dspec.getDSignature().getSignature());
//		}
//		System.out.println("GHJØR DETTE");
//		Assert.isTrue(dspec != null);
//		setPartName(file.getName());
//		
//		paletteFactory.updatePalette(getPaletteRoot(), dspec.getDType().getDGraph());
//		shapesEditPartFactory = new DPFEditPartFactory();
//	}
	
	public void doSave(final URI uri, IProgressMonitor monitor) {

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), dspec, uri, resourceToDiagnosticMap);
			}
		};

		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			getCommandStack().markSaveLocation();

			IFile file = ((IFileEditorInput)getEditorInput()).getFile();
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);

			//			updateStatusBar();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void doSave(IProgressMonitor monitor) {
		Shell shell = getSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();

		final IPath path = dialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				IFileEditorInput newInput = new FileEditorInput(file);
				setInputWithNotify(newInput);
				setPartName(newInput.getName());
				DPFEditor.updateResourceSet(DPFUtils.getResourceSet(), dspec, dspec.eResource().getURI(), DPFUtils.getFileURI(file));
				doSave(DPFUtils.getFileURI(file), new NullProgressMonitor());
			}
		}
		
	}
	
	@Override
	protected void createActions() {
		super.createActions(); // to get the default actions

		DSignature signature = dspec.getDSignature();
		if (signature != null) {
			for (DPredicate predicate : signature.getDPredicates())
				addActionForPredicate(predicate);
			if(signature != DEFAULT_DSIGNATURE){
				for (DPredicate predicate : DEFAULT_DSIGNATURE.getDPredicates())
					addActionForPredicate(predicate);
			}
		}
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.LEFT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.RIGHT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.TOP));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.BOTTOM));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.CENTER));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.MIDDLE));
	}
	
	private void addActionForPredicate(final DPredicate dPredicate) {
		CreateConstraintAction action = new CreateConstraintAction(this, dspec, dPredicate); 
		registerAction(action);
		constraintActions.add(action);
	}
	
	@SuppressWarnings("unchecked")
	private void registerAction(IAction action) {
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
	}
	
	List<IAction> constraintActions = new ArrayList<IAction>();

	protected IPartListener partListener = new IPartListener() {
		public void partActivated(IWorkbenchPart p) {
			ProductionEditor editor = ProductionEditor.this;
			if (p != editor)
				return;
			IActionBars actionBars = editor.getEditorSite().getActionBars();
			IToolBarManager toolbar = actionBars.getToolBarManager();
			for (IAction action : constraintActions)
				toolbar.add(action);
			toolbar.update(true);
			actionBars.updateActionBars();
		}

		public void partBroughtToTop(IWorkbenchPart p) { }

		public void partClosed(IWorkbenchPart p) { }

		public void partDeactivated(IWorkbenchPart p) {
			ProductionEditor editor = ProductionEditor.this;
			if (p != editor)
				return;
			IActionBars actionBars = editor.getEditorSite().getActionBars();
			IToolBarManager toolbar = actionBars.getToolBarManager();
			for (IAction action : constraintActions)
				toolbar.remove(action.getId());
			toolbar.update(true);
			actionBars.updateActionBars();
		}

		public void partOpened(IWorkbenchPart p) { }
	};
	
	
};