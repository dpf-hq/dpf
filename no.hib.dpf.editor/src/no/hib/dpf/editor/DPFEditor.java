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

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.provider.CoreItemProviderAdapterFactory;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.provider.DiagramItemProviderAdapterFactory;
import no.hib.dpf.editor.actions.CreateConstraintToolEntry;
import no.hib.dpf.editor.actions.PrintAction;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.editor.parts.NodeTreeEditPartFactory;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
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
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * A graphical editor with flyout palette that can edit .dpf files. The binding
 * between the .dpf file extension and this editor is done in plugin.xml
 * 
 * @author Elias Volanakis
 */
public class DPFEditor extends GraphicalEditorWithFlyoutPalette {

	/** This is the root of the editor's model. */

	protected DSpecification dSpecification;

	// /** Palette component, holding the tools and shapes. */
	private PaletteRoot paletteRoot;

	protected DPFEditPartFactory shapesEditPartFactory;
	protected DPFEditorPaletteFactory paletteFactory;
	private static final String Marker_ID = DPFUtils.getPluginID()	+ ".validationmarker";

	protected PropertySheetPage propertySheetPage;

	/** Create a new DPFEditor instance. This is called by the Workspace. */
	public DPFEditor() {
		paletteFactory = new DPFEditorPaletteFactory();
		setEditDomain(new DefaultEditDomain(this));
		listenToDisplayDyntTypedArrowsProperty();
	}

	protected URI getFileURI() {
		return dSpecification.eResource().getURI();
	}

	private void listenToDisplayDyntTypedArrowsProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore()
		.addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(
					org.eclipse.jface.util.PropertyChangeEvent event) {
				if ((event.getProperty()
						.equals(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS))
						|| (event.getProperty()
								.equals(PreferenceConstants.P_DISPLAY_TYPED_ARROWS))) {
					// paletteFactory.updatePalette(getPaletteRoot(),
					// getSpecification().getTypeGraph());
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

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
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

		loadProperties(getGraphicalViewer());
		registerAction(new PrintAction(viewer));		
		registerAction(new ToggleSnapToGeometryAction(viewer));
		registerAction(new ToggleGridAction(viewer));
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		// configure the context menu provider
		ContextMenuProvider cmProvider = new DPFEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
	}

	protected void loadProperties(GraphicalViewer viewer) {
		// Snap to Geometry property
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, dSpecification.isSnap());
		// Grid properties
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, dSpecification.isGrid());
		// We keep grid visibility and enablement in sync
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, dSpecification.isGridVisible());
		// Zoom
		ZoomManager manager = (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null)
			manager.setZoom(dSpecification.getZoom());
	}

	protected void saveProperties(GraphicalViewer viewer) {
		// Snap to Geometry property
		dSpecification.setSnap(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED));		
		// Grid properties
		dSpecification.setGrid(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED));
		// We keep grid visibility and enablement in sync
		dSpecification.setGridVisible(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGrid.PROPERTY_GRID_VISIBLE));
		// Zoom
		ZoomManager manager = getGraphicalViewer() == null ? null : (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null)
			dSpecification.setZoom(manager.getZoom());
	}

	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}

	protected ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**When model is saved to another location, model's metamodel location 
	 * and model's signature location, both relative to the model's location,  should be updated.
	 * 
	 * @param iter : the model
	 * @param oldBase : model old location
	 * @param createFileURI : model new location
	 */
	private static void updateMetaModelReference(DSpecification iter, URI oldBase, URI createFileURI){
		if(oldBase == null){
			DSpecification typeSpec = iter.getDType();
			if(typeSpec != null && typeSpec != REFLEXIVE_DSPECIFICATION){
				String relative = typeSpec.eResource().getURI().deresolve(createFileURI).toFileString();
				iter.setMetaFile(relative);
				iter.getSpecification().setMetaFile(DPFUtils.getModelFromDiagram(relative));
			}
			DSignature signature = iter.getDSignature();
			if(signature != null){
				String relative = "";
				DSpecification type = iter.getDType();
				if(type != null && type.getDSignature() == signature)
					relative = type.getSignatureFile();
				else
					relative = signature.eResource().getURI().deresolve(createFileURI).toFileString();
				iter.setSignatureFile(relative);
				iter.getSpecification().setSignatureFile(relative);
			}
			return;
		}
		if(iter.getMetaFile() != null && !iter.getMetaFile().isEmpty()){
			String newMetaFile = DPFUtils.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getMetaFile())).toFileString();
			iter.setMetaFile(newMetaFile);
			iter.getSpecification().setMetaFile(DPFUtils.getModelFromDiagram(newMetaFile));
		}
		if(iter.getSignatureFile() != null && !iter.getSignatureFile().isEmpty()){
			String newSignatureFile = DPFUtils.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getSignatureFile())).toFileString();
			iter.setSignatureFile(newSignatureFile);
			iter.getSpecification().setSignatureFile(newSignatureFile);
		}
	}
	
	
	/**When model is saved to another location, if a signature is not the default one,
	 * the icon location of each predicate, relative to the model, should be update
	 * @param dSignature : signature to update
	 * @param newBase : model's new location
	 */
	private static void updateSignatureReference(DSignature dSignature, URI newBase){
		URI oldBase = dSignature.eResource().getURI();
		for(DPredicate predicate : dSignature.getDPredicates()){
			String icon = predicate.getIcon();
			if(icon != null && !icon.isEmpty())
				predicate.setIcon(DPFUtils.updateRelativeURI(oldBase, newBase, URI.createFileURI(predicate.getIcon())).toFileString());
		}
	}
	
	/**When model is saved to another location, update relative locations
	 * @param resourceSet : the resourceSet containing the model
	 * @param newSpec : the model
	 * @param oldURI : model's old location
	 * @param newURI : model's new location
	 */
	public static void updateResourceSet(ResourceSetImpl resourceSet, DSpecification newSpec, URI oldURI, URI newURI){
		Assert.isNotNull(resourceSet);
		URI modelFileURI = DPFUtils.getModelURI(newURI);
		Resource diagram = resourceSet.createResource(newURI);
		Resource model = resourceSet.createResource(modelFileURI);
		resourceSet.getURIResourceMap().put(newURI, diagram);
		resourceSet.getURIResourceMap().put(modelFileURI, model);
		DSpecification iter = newSpec;
		while(iter != REFLEXIVE_DSPECIFICATION){
			updateMetaModelReference(iter, oldURI, newURI);
			diagram.getContents().add(iter);
			model.getContents().add(iter.getSpecification());
			if(iter.getDSignature() != null && iter.getDSignature() != DEFAULT_DSIGNATURE){
				updateSignatureReference(iter.getDSignature(), newURI);
				diagram.getContents().add(iter.getDSignature());
				model.getContents().add(iter.getDSignature().getSignature());
			}
			iter = iter.getDType();
		}
	}		

	public DSignature getDSignature() {
		return dSpecification.getDSignature();
	}

	public void doSave(final URI uri, IProgressMonitor monitor) {

		saveProperties(getGraphicalViewer());
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				DPFUtils.saveDSpecification(resourceSet, dSpecification, uri);
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
				updateResourceSet(resourceSet, dSpecification, dSpecification.eResource().getURI(), DPFUtils.getFileURI(file));
				doSave(DPFUtils.getFileURI(file), new NullProgressMonitor());
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class) {
			return new ShapesOutlinePage(new TreeViewer());
		} else if (type == ZoomManager.class) {
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		}else if (type == IPropertySheetPage.class) {
			return getPropertySheetPage();
		}

		return super.getAdapter(type);		
	}

	private ComposedAdapterFactory factory = null;
	public ComposedAdapterFactory getComposedAdapterFactory(){
		if(factory == null){
			factory = new ComposedAdapterFactory();
			factory.addAdapterFactory(new DiagramItemProviderAdapterFactory());
			factory.addAdapterFactory(new CoreItemProviderAdapterFactory());
		}
		return factory;
	}

	public Object getPropertySheetPage() {
		if(propertySheetPage == null) {
			propertySheetPage = (UndoablePropertySheetPage) super .getAdapter(IPropertySheetPage.class);
			//			 A new PropertySourceProvider was implemented to fetch the model
			// from the edit part when required. The property source is provided
			// by the generated EMF classes and wrapped by the AdapterFactoryContentProvider
			// to yield standard eclipse interfaces.
			IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
				IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(getComposedAdapterFactory());

				@Override
				public IPropertySource getPropertySource(Object object) {
					IPropertySource source = null;
					if(object instanceof DNodeEditPart) 
						source = modelPropertySourceProvider.getPropertySource(((DNodeEditPart) object).getDNode());
					else if(object instanceof DComposedNodePart)
						source = modelPropertySourceProvider.getPropertySource((((DComposedNodePart)object).getDConstraint()));
					else if(object instanceof DArrowEditPart) 
						source = modelPropertySourceProvider.getPropertySource(((DArrowEditPart) object).getDArrow());
					else if(object instanceof DConstraintEditPart)
						source = modelPropertySourceProvider.getPropertySource(((DConstraintEditPart)object).getModel());
					else if(object instanceof ArrowLabelEditPart){
						ArrowLabelEditPart editpart = (ArrowLabelEditPart) object;
						DOffset offset = editpart.getDOffset();
						if (offset != null && (offset.eContainer() instanceof DConstraint || offset .eContainer() instanceof DArrow))
							source = modelPropertySourceProvider .getPropertySource(offset.eContainer());
					}
					return source != null ? new UnwrappingPropertySource(source) : null;
				}

			};
			UndoablePropertySheetEntry root = new UndoablePropertySheetEntry(getCommandStack());
			root.setPropertySourceProvider(sourceProvider);
			propertySheetPage.setRootEntry(root);
		}
		return propertySheetPage;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}

	/**
	 * Set up the editor's inital content (after creation).
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(dSpecification.getDGraph());
		validateModel(dSpecification.getDGraph().getGraph());
		getSite().setSelectionProvider(getGraphicalViewer());
		getSite().getSelectionProvider().addSelectionChangedListener(paletteFactory);
	}

	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()){
			public PaletteViewer createPaletteViewer(Composite parent) {
				final PaletteViewer viewer = super.createPaletteViewer(parent);
				viewer.addSelectionChangedListener(new org.eclipse.jface.viewers.ISelectionChangedListener(){
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						if(!(event.getSource() instanceof PaletteViewer)) return;
						PaletteViewer source = (PaletteViewer)event.getSource();
						ISelection selection = event.getSelection();
						if(selection instanceof StructuredSelection){
							Object[] selectedParObjects = ((StructuredSelection)selection).toArray();
							if(selectedParObjects.length != 1 || !(selectedParObjects[0] instanceof AbstractGraphicalEditPart)) return;
							AbstractGraphicalEditPart editPart = (AbstractGraphicalEditPart)selectedParObjects[0];
							Object object = editPart.getModel();
							if(object instanceof CreateConstraintToolEntry){
								Command command = ((CreateConstraintToolEntry)object).getCommand();
								if(command != null && command.canExecute()){
									getCommandStack().execute(command);
									((CreateConstraintToolEntry)object).setGraphHomorphism(null);
								}
								if(object != getPaletteRoot().getDefaultEntry()){
									source.getEditDomain().loadDefaultTool();
								}
							}
						}
					}
				});
				return viewer;
			}
		};
	}

	public  void validateModel(Graph graph) {
		Map<Constraint, List<Node>> visited = new HashMap<Constraint, List<Node>>();
		for(Node node : graph.getNodes()){
			for (Constraint constraint : node.getTypeNode().getConstraints()) {
				List<Node> visitedNodes = visited.get(constraint);
				if(visitedNodes != null && visitedNodes.contains(node)) continue;
				EList<Node> vertex = new BasicEList<Node>();
				EList<Arrow> arrows = new BasicEList<Arrow>();
				DPFCoreUtil.findRelatedElements(node, constraint, graph, vertex, arrows);
				if(!vertex.isEmpty()){
					boolean valid = constraint.validate(vertex, arrows);
					if(!valid){
						for(Node iter : vertex)
							addMarker(iter, constraint);
						for(Arrow iter : arrows)
							addMarker(iter, constraint);
					}
					if(visitedNodes == null){
						visitedNodes = new ArrayList<Node>(vertex.size());
						visitedNodes.addAll(vertex);
					}else{
						for(Node iter : vertex){
							if(!visitedNodes.contains(iter))
								visitedNodes.add(iter);
						}
					}
					visited.put(constraint, visitedNodes);
				}
			}
		}
	}
	
	public boolean isSaveAsAllowed() {
		return true;
	}

	protected void setInput(IEditorInput input) {
		super.setInput(input);
		IFile file = ((IFileEditorInput) input).getFile();
		dSpecification = DPFUtils.loadDSpecification(resourceSet, DPFUtils.getFileURI(file));
		Assert.isTrue(dSpecification != null);
		setPartName(file.getName());

		paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDType().getDGraph());
		paletteFactory.updatePalette(dSpecification);
		shapesEditPartFactory = new DPFEditPartFactory();
	}

	/**
	 * Returns the path to the workspace of this editor.
	 */
	public static String getWorkspaceDirectory() {
		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
	}


	@Override
	public void doSave(IProgressMonitor monitor) {
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		doSave(DPFUtils.getFileURI(file), monitor);
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
			getViewer().setContents(dSpecification.getSpecification());
			// show outline viewer
		}

		public void dispose() {
			// unhook outline viewer
			getSelectionSynchronizer().removeViewer(getViewer());
			// dispose
			super.dispose();
		}

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

	private Map<IDObject, List<IMarker>> markersMap = new HashMap<IDObject, List<IMarker>>();
	private IMarker findMarker(List<IMarker> markers, Constraint constraint){
		if(markers != null)
			for(IMarker marker : markers)
				try {
					if(marker.getAttribute("constraint") == constraint)
						return marker;
				} catch (CoreException e) {
					DPFUtils.logError(e);
					return null;
				}
		return null;
	}
	public void addMarker(IDObject iter, Constraint constraint) {
		IFile file = ((IFileEditorInput)getEditorInput()).getFile();
		if(file == null) return;
		List<IMarker> markers = markersMap.get(iter);
		if(markers == null)
			markers = new ArrayList<IMarker>();
		if(findMarker(markers, constraint) == null){
			IMarker marker = null;
			try {
				String name = (iter instanceof Node)? ((Node)iter).getName() : 
					((iter instanceof Arrow) ? ((Arrow)iter).getName() : null);

				marker = file.createMarker(Marker_ID);
				marker.setAttribute(IMarker.MESSAGE, name + " violates constraint [" 
						+ constraint.getPredicate().getSymbol()    + "] on {" 
						+ DPFUtils.printConstraint(constraint) + "}");
				marker.setAttribute(IMarker.LOCATION, name);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute("constraint", constraint);
			} catch (CoreException e) {
				marker = null;
				DPFUtils.logError(e);
			}
			if(marker != null)
				markers.add(marker);
		}
		if(markers.size() == 1){
			markersMap.put(iter, markers);
			updateVisual(iter);
		}
	}
	private void updateVisual(IDObject iter){
		if(iter instanceof Node){
			DNode dNode = dSpecification.getDGraph().getDNode((Node) iter);
			if(dNode != null){
				Object editpart = getGraphicalViewer().getEditPartRegistry().get(dNode);
				if(editpart instanceof DNodeEditPart)
					((NodeFigure)((DNodeEditPart)editpart).getFigure()).setErrorImageFlag(isMakerExisting(iter));
			}
		}
	}

	public boolean isMakerExisting(IDObject object) {
		return markersMap.containsKey(object) && !markersMap.get(object).isEmpty();
	}

	public void deleteMaker(IDObject iter, Constraint constraint) {
		IFile file = ((IFileEditorInput)getEditorInput()).getFile();
		if(file == null) return;
		List<IMarker> markers = markersMap.get(iter);
		if(markers != null){
			IMarker marker = findMarker(markers, constraint);
			if(marker != null){
				if (marker.exists()) {
					try {
						marker.delete();
						markers.remove(marker);
						if(markers.isEmpty())
							updateVisual(iter);
					} catch (CoreException e) {
						DPFUtils.logError(e);
					}
				}
			}
		}
	}

	public void deleteMaker(IDObject checkedArrow) {
		List<IMarker> markers = markersMap.get(checkedArrow);
		IFile file = ((IFileEditorInput)getEditorInput()).getFile();
		if(file == null)
			return;
		if(markers == null) return;
		try {
			for(IMarker marker : markers)
				if (marker.exists()) 
					marker.delete();
			markersMap.remove(checkedArrow);
			updateVisual(checkedArrow);
		} catch (CoreException e) {
			DPFUtils.logError(e);
		}
	}
	
	class UnwrappingPropertySource implements IPropertySource {
	    private IPropertySource source;

	    public UnwrappingPropertySource(final IPropertySource source) {
	        this.source = source;
	    }

	    @Override
	    public Object getEditableValue() {
	        Object value = source.getEditableValue();
	        return value instanceof PropertyValueWrapper ? ((PropertyValueWrapper) value).getEditableValue(null) : source.getEditableValue();
	    }

	    @Override
	    public IPropertyDescriptor[] getPropertyDescriptors() {
	        return source.getPropertyDescriptors();
	    }

	    @Override
	    public Object getPropertyValue(Object id) {
	        Object value = source.getPropertyValue(id);
	        if(value == null)
	        	return null;
	        return value instanceof PropertyValueWrapper ? ((PropertyValueWrapper) value).getEditableValue(null) : value;//source.getEditableValue();
	    }

	    @Override
	    public boolean isPropertySet(Object id) {
	        return source.isPropertySet(id);
	    }

	    @Override
	    public void resetPropertyValue(Object id) {
	        source.resetPropertyValue(id);
	    }

	    @Override
	    public void setPropertyValue(Object id, Object value) {
	        source.setPropertyValue(id, value);
	    }
	}
}
