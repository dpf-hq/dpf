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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.constant.DPFConstants;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.ModelElement;
import no.hib.dpf.editor.editoractions.ConstraintProperties;
import no.hib.dpf.editor.editoractions.CreateCompositionConstraintAction;
import no.hib.dpf.editor.editoractions.CreateImageInclusionConstraintAction;
import no.hib.dpf.editor.editoractions.CreateInjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateInverseConstraintAction;
import no.hib.dpf.editor.editoractions.CreateIrreflexiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction;
import no.hib.dpf.editor.editoractions.CreateNANDConstraintAction;
import no.hib.dpf.editor.editoractions.CreateSurjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateTransitiveIrreflexiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateXORConstraintAction;
import no.hib.dpf.editor.editoractions.PrintAction;
import no.hib.dpf.editor.parts.EditPartFactoryImpl;
import no.hib.dpf.editor.parts.NodeTreeEditPartFactory;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


/**
 * A graphical editor with flyout palette that can edit .dpf files. The
 * binding between the .dpf file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public class DPFEditor extends GraphicalEditorWithFlyoutPalette implements PropertyChangeListener {

	/** This is the root of the editor's model. */
	private DPFDiagram diagram;

	private Specification specification = CoreFactory.eINSTANCE.createSpecification();
	private Signature signature;
		
//	/** Palette component, holding the tools and shapes. */
	private PaletteRoot paletteRoot;
	
	private EditPartFactoryImpl shapesEditPartFactory;
	private DPFEditorPaletteFactory paletteFactory;

	/** Create a new DPFEditor instance. This is called by the Workspace. */
	public DPFEditor() {
		paletteFactory = new DPFEditorPaletteFactory();
		setEditDomain(new DefaultEditDomain(this));
		listenToDisplayDyntTypedArrowsProperty();
	}
	
	private void listenToDisplayDyntTypedArrowsProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if ((event.getProperty().equals(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS)) ||
					(event.getProperty().equals(PreferenceConstants.P_DISPLAY_TYPED_ARROWS))) {
					//paletteFactory.updatePalette(getPaletteRoot(), getSpecification().getTypeGraph());
				}
			}
		});
	}	
	
	/**
	 * Overridden to create our own actions
	 */
	@Override
	protected void createActions() {
		super.createActions(); // to get the default actions
		
		// TODO: this is a temporary solution, only to get the signature from
		// somwhere. Make this a part of the modelling hierarchy.
		
		
		// First step to move the predicates out of the editor:
		// There remains to make some coupling between these predicates
		// and the parts/figures that implement them.
		ConstraintProperties xorProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[xor]"), 
				"Create new [xor] Constraint",
				"Creates a new [xor] Constraint",
				DConstraint.ConstraintType.XOR);
		
		registerAction(new CreateXORConstraintAction(this, diagram.getDpfGraph(), xorProperties));
		
		ConstraintProperties nandProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[nand]"), 
				"Create new [nand] Constraint",
				"Creates a new [nand] Constraint",
				DConstraint.ConstraintType.NAND);
		
		registerAction(new CreateNANDConstraintAction(this, diagram.getDpfGraph(), nandProperties));

		ConstraintProperties injectiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[injective]"), 
				"Create new [injective] Constraint",
				"Creates a new [injective] Constraint",
				DConstraint.ConstraintType.INJECTIVE);
		
		registerAction(new CreateInjectiveConstraintAction(this, diagram.getDpfGraph(), injectiveProperties));
		ConstraintProperties surjectiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[surjective]"), 
				"Create new [surjective] Constraint",
				"Creates a new [surjective] Constraint",
				DConstraint.ConstraintType.SURJECTIVE);
		
		registerAction(new CreateSurjectiveConstraintAction(this, diagram.getDpfGraph(), surjectiveProperties));

		
		ConstraintProperties jointlyInjectiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[jointly-injective]"), 
				"Create new [jointly-injective] Constraint",
				"Creates a new [jointly-injective] Constraint",
				DConstraint.ConstraintType.JOINTLY_INJECTIVE);
		
		registerAction(new CreateJointlyInjectiveConstraintAction(this, diagram.getDpfGraph(), jointlyInjectiveProperties));
				
		ConstraintProperties jointlySurjectiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[jointly-surjective]"), 
				"Create new [jointly-surjective] Constraint",
				"Creates a new [jointly-surjective] Constraint",
				DConstraint.ConstraintType.JOINTLY_SURJECTIVE);
		
		registerAction(new CreateJointlySurjectiveConstraintAction(this, diagram.getDpfGraph(), jointlySurjectiveProperties));
		
		ConstraintProperties multiplicityProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[mult(m,n)]"), 
				"Create new [mult(m,n)] Constraint",
				"Creates a new [mult(m,n)] Constraint",
				DConstraint.ConstraintType.MULTIPLICITY);

		registerAction(new CreateMultiplicityConstraintAction(this, diagram.getDpfGraph(), multiplicityProperties));
		
		ConstraintProperties inverseProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[inverse]"),
				"Create new [inverse] Constraint",
				"Creates a new [inverse] Constraint",
				DConstraint.ConstraintType.INVERSE);
		registerAction(new CreateInverseConstraintAction(this, diagram.getDpfGraph(), inverseProperties));

		ConstraintProperties imageInclusionProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[image-inclusion]"),
				"Create new [image-inclusion] Constraint",
				"Creates a new [image-inclusion] Constraint",
				DConstraint.ConstraintType.IMAGE_INCLUSION);
		registerAction(new CreateImageInclusionConstraintAction(this, diagram.getDpfGraph(), imageInclusionProperties));
		
		ConstraintProperties compositionProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[composition]"),
				"Create new [composition] Constraint",
				"Creates a new [composition] Constraint",
				DConstraint.ConstraintType.COMPOSITION);
		registerAction(new CreateCompositionConstraintAction(this, diagram.getDpfGraph(), compositionProperties));


		ConstraintProperties irreflexiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[irreflexive]"),
				"Create new [irreflexive] Constraint",
				"Creates a new [irreflexive] Constraint",
				DConstraint.ConstraintType.IRREFLEXIVE);
		registerAction(new CreateIrreflexiveConstraintAction(this, diagram.getDpfGraph(), irreflexiveProperties));
		
		ConstraintProperties transitiveIrreflexiveProperties = new ConstraintProperties(
				signature.getPredicateBySymbol("[transitive-irreflexive]"),
				"Create new [transitive-irreflexive] Constraint",
				"Creates a new [transitive-irreflexive] Constraint",
				DConstraint.ConstraintType.TRANSITIVE_IRREFLEXIVE);
		
		registerAction(new CreateTransitiveIrreflexiveConstraintAction(this, diagram.getDpfGraph(), transitiveIrreflexiveProperties));
		
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.LEFT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.RIGHT));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.TOP));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.BOTTOM));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.CENTER));
		registerAction(new AlignmentAction((IWorkbenchPart)this, PositionConstants.MIDDLE));
	}

	@SuppressWarnings("unchecked")
	private void registerAction(IAction action) {
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
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
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(shapesEditPartFactory);
		
		// -------------------------------------------------
		ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();

		List<String> zoomLevels = new ArrayList<String>(3);
		zoomLevels.add(ZoomManager.FIT_ALL);
		zoomLevels.add(ZoomManager.FIT_WIDTH);
		zoomLevels.add(ZoomManager.FIT_HEIGHT);
		root.getZoomManager().setZoomLevelContributions(zoomLevels);

		IAction zoomIn = new ZoomInAction(root.getZoomManager());
		IAction zoomOut = new ZoomOutAction(root.getZoomManager());
		getActionRegistry().registerAction(zoomIn);
		getActionRegistry().registerAction(zoomOut);
		
		viewer.setRootEditPart(root);
		// -------------------------------------------------
		
		registerAction(new PrintAction(viewer));		

		registerAction(new ToggleSnapToGeometryAction(viewer));

		registerAction(new ToggleGridAction(viewer));
		
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		// configure the context menu provider
		ContextMenuProvider cmProvider = new DPFEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
						
		loadProperties(viewer);
	}
	
	protected void loadProperties(GraphicalViewer viewer) {
		// Snap to Geometry property
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, new Boolean(diagram.isSnapToGeometryEnabled()));		
		// Grid properties
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, new Boolean(diagram.isGridEnabled()));
		// We keep grid visibility and enablement in sync
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, new Boolean(diagram.isGridEnabled()));
		// Zoom
		ZoomManager manager = (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null) {
			manager.setZoom(diagram.getZoom());
		}
	}	
	
	protected void saveViewerPropertiesToDiagram() {
		try {
			diagram.setGridEnabled(((Boolean)getGraphicalViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED)).booleanValue());
			diagram.setSnapToGeometry(((Boolean)getGraphicalViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED)).booleanValue());
		
			ZoomManager manager = (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
			if (manager != null) {
				diagram.setZoom(manager.getZoom());
			}
		} catch (Exception e) {}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.ui.parts.GraphicalEditor#commandStackChanged(java.util
	 * .EventObject)
	 */
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#
	 * createPaletteViewerProvider()
	 */
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				// create a drag source listener for this palette viewer
				// together with an appropriate transfer drop target listener,
				// this will enable
				// model element creation by dragging a
				// CombinatedTemplateCreationEntries
				// from the palette into the editor
				// @see ShapesEditor#createTransferDropTargetListener()
				//				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
		};
	}

	
	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}
	
	
//	/**
//	 * Create a transfer drop target listener. When using a
//	 * CombinedTemplateCreationEntry tool in the palette, this will enable model
//	 * element creation by dragging from the palette.
//	 * 
//	 * @see #createPaletteViewerProvider()
//	 */
//	private TransferDropTargetListener createTransferDropTargetListener() {
//		return new TemplateTransferDropTargetListener(getGraphicalViewer()) {
//			@SuppressWarnings("rawtypes")
//			protected CreationFactory getFactory(Object template) {
//				return new SimpleFactory((Class) template);
//			}
//		};
//	}

	public static final String DEFAULT_MODEL_EXTENSION = "xmi";
	public static final String DEFAULT_VISUAL_EXTENSION = "dpf";

	//dpf name to xmi name
	public static String getModelFromDiagram(String diagram){
		return diagram.substring(0, diagram.lastIndexOf('.') + 1) + DEFAULT_MODEL_EXTENSION;
	}
	//xmi name to dpf name
	public static String getDiagramFromModel(String model){
		return model.substring(0, model.lastIndexOf('.') + 1) + DEFAULT_VISUAL_EXTENSION;
	}

	// Temporary unused: the file is re-generated every time.
	// TODO: make signature editor, fix all this, and make the user select a signature at some point.
	private void loadSignature() {
		if(resourceSet == null)
			resourceSet = getResourceSet();
		Resource resource = DPFCoreUtil.getResource(resourceSet, DPFConstants.DefaultSignature, resourceToDiagnosticMap);
		resourceSet.getURIResourceMap().put(DPFConstants.DefaultSignature, resource);
		resetSignature();
		Assert.isNotNull(signature);
		resource.getContents().add(signature);
	}

	private void resetSignature() {
		if(signature != null)
			return;
		signature = CoreFactory.eINSTANCE.createSignature();
		
		signature.getPredicates().add(CoreFactory.eINSTANCE.createPredicate("[jointly-injective]", "n_1,n_2,n_3", "a_1:n_1:n_2,a_2:n_1:n_3"));
		signature.getPredicates().add(CoreFactory.eINSTANCE.createPredicate("[image-inclusion]", "n_1,n_2", "a_1:n_1:n_2,a_2:n_1:n_2"));		
		signature.getPredicates().add(CoreFactory.eINSTANCE.createPredicate("[composition]", "n_1,n_2,n_3", "a_1:n_1:n_2,a_2:n_2:n_3,a_3:n_1:n_3"));
		signature.getPredicates().add(CoreFactory.eINSTANCE.createPredicate("[injective]", "n_1,n_2", "a_1:n_1:n_2"));
		
		Predicate surjectivePredicate = CoreFactory.eINSTANCE.createPredicate("[surjective]", "n_1,n_2", "a_1:n_1:n_2");
		surjectivePredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createSurjectiveSemantics());
		signature.getPredicates().add(surjectivePredicate);		

		Predicate xorPredicate = CoreFactory.eINSTANCE.createPredicate("[xor]", "n_1,n_2,n_3", "a_1:n_1:n_2,a_2:n_1:n_3");
		xorPredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createXORSemantics());
		signature.getPredicates().add(xorPredicate);
		
		Predicate nandPredicate = CoreFactory.eINSTANCE.createPredicate("[nand]", "n_1,n_2,n_3", "a_1:n_1:n_2,a_2:n_1:n_3");
		nandPredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createNANDSemantics());
		signature.getPredicates().add(nandPredicate);

		Predicate jSPredicate = CoreFactory.eINSTANCE.createPredicate("[jointly-surjective]", "n_1,n_2,n_3", "a_1:n_2:n_1,a_2:n_3:n_1");
		jSPredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createJointlySurjectiveSemantics());
		signature.getPredicates().add(jSPredicate);

		Predicate inversePredicate = CoreFactory.eINSTANCE.createPredicate("[inverse]", "n_1,n_2", "a_1:n_1:n_2,a_2:n_2:n_1");
		inversePredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createInverseSemantics());
		signature.getPredicates().add(inversePredicate);

		Predicate irreflexivePredicate = CoreFactory.eINSTANCE.createPredicate("[irreflexive]", "n_1", "a_1:n_1:n_1");
		irreflexivePredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createIrreflexiveSemantics());
		signature.getPredicates().add(irreflexivePredicate);

		Predicate transitiveIrreflexivePredicate = CoreFactory.eINSTANCE.createPredicate("[transitive-irreflexive]", "n_1", "a_1:n_1:n_1");
		transitiveIrreflexivePredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createTransitiveIrreflexiveSemantics());
		signature.getPredicates().add(transitiveIrreflexivePredicate);
		
		Predicate multiplicityPredicate = CoreFactory.eINSTANCE.createPredicate("[mult(m,n)]", "n_1,n_2", "a_1:n_1:n_2");
		multiplicityPredicate.setSemanticsValidator(CoreFactory.eINSTANCE.createMultiplicitySemantics());
		signature.getPredicates().add(multiplicityPredicate);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor
	 * )
	 */
	public void doSave(IProgressMonitor monitor) {

		final String modelFileName = diagram.getFilename();

		final String  diagramFileName  = getDiagramFromModel(modelFileName);
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				saveDPFModel(resourceSet, URI.createFileURI(modelFileName), specification, resourceToDiagnosticMap);
				saveViewerPropertiesToDiagram();
				saveDPFDiagram(diagramFileName, diagram);
			}
		};

		try {
			// This runs the options, and shows progress.
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			getCommandStack().markSaveLocation();

			IFile file = ((IFileEditorInput)getEditorInput()).getFile();
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
			
			updateStatusBar();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {
		// Show a SaveAs dialog
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
				diagram.setFilename(getModelFromDiagram(file.getLocation().toOSString()));
				doSave(new NullProgressMonitor());
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class) {
			return new ShapesOutlinePage(new TreeViewer());
		} else if (type == ZoomManager.class) {
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		}

		return super.getAdapter(type);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#getPaletteRoot
	 * ()
	 */
	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}

	private void handleLoadException(Exception e) {
		System.err.println("** Load failed. Using default model. **");
		e.printStackTrace();
		specification = CoreFactory.eINSTANCE.createSpecification();
		diagram = new DPFDiagram();
		diagram.setDpfGraph(specification.getGraph());
		diagram.addPropertyChangeListener(this);
	}

	/**
	 * Set up the editor's inital content (after creation).
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(diagram); // set the contents of this editor
	}

	/*@Override
	public void setFocus() {
		super.setFocus();
		paletteFactory.updatePalette(getPaletteRoot(), getSpecification().getTypeGraph());
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		try {
			IFile file = ((IFileEditorInput) input).getFile();
			diagram = loadDPFDiagram(file.getContents());
			final String modelFileName = getModelFromDiagram(file.getLocation().toString());
			diagram.setFilename(modelFileName);
			diagram.addPropertyChangeListener(this);
			
			specification = loadDPFModel(resourceSet, URI.createFileURI(modelFileName), resourceToDiagnosticMap);
			verifyConstraint();
			diagram.setDpfGraph(specification.getGraph());
			diagram.setDpfReferencesInViewModel();
			
			loadSignature();
			
			paletteFactory.updatePalette(getPaletteRoot(), diagram.getParent(), specification.getTypeGraph());
			shapesEditPartFactory = new EditPartFactoryImpl(diagram.getParent());
			setPartName(file.getName());
		} catch (CoreException e) {
			handleLoadException(e);
		} 	
	}

	/**
	 * Returns the path to the workspace of this editor.
	 */
	public static String getWorkspaceDirectory() {
		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
	}

	/**
	 * Creates an outline pagebook for this editor.
	 */
	public class ShapesOutlinePage extends ContentOutlinePage {
		/**
		 * Create a new outline page for the shapes editor.
		 * 
		 * @param viewer
		 *            a viewer (TreeViewer instance) used for this outline page
		 * @throws IllegalArgumentException
		 *             if editor is null
		 */
		public ShapesOutlinePage(EditPartViewer viewer) {
			super(viewer);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.part.IPage#createControl(org.eclipse.swt.widgets.Composite
		 * )
		 */
		public void createControl(Composite parent) {
			// create outline viewer page
			getViewer().createControl(parent);
			// configure outline viewer
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new NodeTreeEditPartFactory());
			// configure & add context menu to viewer
			ContextMenuProvider cmProvider = new DPFEditorContextMenuProvider(getViewer(), getActionRegistry());
			getViewer().setContextMenu(cmProvider);
			getSite().registerContextMenu(
					"org.eclipse.gef.examples.shapes.outline.contextmenu",
					cmProvider, getSite().getSelectionProvider());
			// hook outline viewer
			getSelectionSynchronizer().addViewer(getViewer());
			// initialize outline viewer with model
			getViewer().setContents(diagram);
			// show outline viewer
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#dispose()
		 */
		public void dispose() {
			// unhook outline viewer
			getSelectionSynchronizer().removeViewer(getViewer());
			// dispose
			super.dispose();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.part.IPage#getControl()
		 */
		public Control getControl() {
			return getViewer().getControl();
		}

		/**
		 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
		 */
		public void init(IPageSite pageSite) {
			super.init(pageSite);
			ActionRegistry registry = getActionRegistry();
			IActionBars bars = pageSite.getActionBars();
			String id = ActionFactory.UNDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.REDO.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.DELETE.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = ActionFactory.COPY.getId();
			bars.setGlobalActionHandler(id, registry.getAction(id));
		}
	}

	private static Image Valid_Constarint_Icon = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	private static Image InValid_Constarint_Icon = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	boolean isValid = true;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//System.err.println("VALIDATION RESULT: ");
		verifyConstraint();
	}

	private void verifyConstraint(){
		isValid = true;
		for (Constraint c : specification.getTypeGraph().getConstraints()) {
			try {
				Graph oStar = specification.createOStar(c);
				// Transfer the constraint's parameters to the predicate validator:
				Boolean validation = c.getPredicate().validateSemantics(oStar, c.getParameters(), c.getConstrainedNodes(), c.getConstrainedArrows());
				isValid &= validation.booleanValue();
			} catch (IllegalArgumentException e) {
				isValid = false;
			}
			//System.err.println(validation);
		}
		updateStatusBar();
	}
	private void updateStatusBar(){
		DPFPlugin.getDefault().getStatusLineManager().setMessage(isValid ? Valid_Constarint_Icon : InValid_Constarint_Icon, 
				isValid ? "All constraints validated." : "Validation failed.");
	}


	public void setFocus() {
		super.setFocus();
		updateStatusBar();
	}
	
	private ResourceSetImpl resourceSet = getResourceSet();
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	public static void saveDPFDiagram(String diagramFile, DPFDiagram newDiagram) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(diagramFile));
			oos.writeObject(newDiagram);
			oos.close();
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
	}
	
	private static DPFDiagram loadDPFDiagram(InputStream stream){
		DPFDiagram diagram = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(stream);
			diagram = (DPFDiagram) ois.readObject();
			ois.close();
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		} catch (ClassNotFoundException e) {
			DPFErrorReport.logError(e);
		}
		DPFDiagram current = diagram;
		while(current != null){
			for(ModelElement element : current.getChildrenWithID().values())
				element.loadConfigure();
					current = current.getParent();
		}
		
		return diagram;
	}
	
	public static DPFDiagram loadDPFDiagram(String diagramFromModel) {
		try {
			return loadDPFDiagram(new FileInputStream(diagramFromModel));
		} catch (FileNotFoundException e) {
			DPFErrorReport.logError(e);
		}
		return null;
	}
	
	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());
		Resource graph = resourceSet.createResource(DPFConstants.DefaultGraph);
		graph.getContents().add(DPFConstants.REFLEXIVE_TYPE_GRAPH);
		resourceSet.getURIResourceMap().put(DPFConstants.DefaultGraph, graph);
		return resourceSet;
	}

	public static Specification loadDPFModel( ResourceSet resourceSet, URI createFileURI,
			Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		if(resourceSet == null)
			resourceSet = getResourceSet();

		Resource resource = DPFCoreUtil.getResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		try {
			resource.load(null);
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
		Assert.isTrue(resource.getContents().size() == 1);
		return (Specification) resource.getContents().get(0);

	}

	public static void saveDPFModel(ResourceSet resourceSet, URI createFileURI, Specification specification,
			Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		if(resourceSet == null)
			resourceSet = getResourceSet();

		Resource resource = DPFCoreUtil.getResource(resourceSet, createFileURI, resourceToDiagnosticMap);

		Assert.isNotNull(resource);
		resource.getContents().add(specification);		
		
		try {
			resource.save(null);
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
		
	}
	
	
}