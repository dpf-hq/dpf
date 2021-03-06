package no.hib.dpf.visualization.presentation;

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
//import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.provider.DiagramItemProviderAdapterFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditorContextMenuProvider;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.actions.PrintAction;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.NodeTreeEditPartFactory;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DArrowEditPart;
//import no.hib.dpf.editor.parts.attribute.DArrowDAttributeEditPart;
//import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
//import no.hib.dpf.editor.parts.attribute.DNodeDAttributeEditPart;
//import no.hib.dpf.editor.parts.attribute.DNodeDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.NodeTreeEditPartFactory;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.utils.DPFCoreUtil;
import no.hib.dpf.visual.VisualPlugin;
import no.hib.dpf.visual.provider.VisualItemProviderAdapterFactory;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.part.VCompartmentElementEditPart;
import no.hib.dpf.visualization.part.VisualizationEditPartFactory;
import no.hib.dpf.visualization.util.VisualizationModelPersistanceUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import no.hib.dpf.visualization.provider.VisualizationItemProviderAdapterFactory;
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
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;



public class VisualizationEditor extends GraphicalEditorWithFlyoutPalette {

	/** This is the root of the editor's model. */

	private Visualizations visualizations;

	// /** Palette component, holding the tools and shapes. */
	private PaletteRoot paletteRoot;

	private VisualizationEditPartFactory shapesEditPartFactory;
	private DPFVisualizationPaletteFactory paletteFactory;
	private static final String Marker_ID = DPFPlugin.PLUGIN_ID	+ ".validationmarker";

	protected PropertySheetPage propertySheetPage;
	
	private ResourceSetImpl resourceSet = DPFModelPersistanceUtils.getResourceSet();
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();


	/** Create a new DPFEditor instance. This is called by the Workspace. */
	public VisualizationEditor() {
		paletteFactory = new DPFVisualizationPaletteFactory();
		setEditDomain(new DefaultEditDomain(this));
		listenToDisplayDyntTypedArrowsProperty();
	}

	protected URI getFileURI() {
		return visualizations.eResource().getURI();
	}

	private void listenToDisplayDyntTypedArrowsProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
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

		DSignature signature = visualizations.getInstance().getDSignature();
		if (signature != null) {
			for (DPredicate predicate : signature.getDPredicates())
				addActionForPredicate(predicate);
			if(signature != DPFConstants.DEFAULT_DSIGNATURE){ 
				for (DPredicate predicate : DPFConstants.DEFAULT_DSIGNATURE.getDPredicates())
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
		CreateConstraintAction action = new CreateConstraintAction(this, visualizations.getInstance(), dPredicate);
		registerAction(action);
		constraintActions.add(action);
	}

	@SuppressWarnings("unchecked")
	private void registerAction(IAction action) {
		getActionRegistry().registerAction(action);
		getSelectionActions().add(action.getId());
	}

	@Override
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
	@Override
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
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, visualizations.getInstance().isSnap());
		// Grid properties
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, visualizations.getInstance().isGrid());
		// We keep grid visibility and enablement in sync
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, visualizations.getInstance().isGridVisible());
		// Zoom
		ZoomManager manager = (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null)
			manager.setZoom(visualizations.getInstance().getZoom());
	}

	protected void saveProperties(GraphicalViewer viewer) {
		// Snap to Geometry property
		visualizations.getInstance().setSnap(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED));
		// Grid properties
		visualizations.getInstance().setGrid(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGrid.PROPERTY_GRID_ENABLED));
		// We keep grid visibility and enablement in sync
		visualizations.getInstance().setGridVisible(viewer == null ? false : (Boolean) viewer.getProperty(SnapToGrid.PROPERTY_GRID_VISIBLE));
		// Zoom
		ZoomManager manager = getGraphicalViewer() == null ? null : (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
		if (manager != null)
			visualizations.getInstance().setZoom(manager.getZoom());
	}

	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
		super.commandStackChanged(event);
	}

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(180);
		return retval;
	}

	
	private static void updateMetaModelReference(DSpecification iter, URI oldBase, URI createFileURI){
		if(oldBase == null){
			DSpecification typeSpec = iter.getDType();
			if(typeSpec != null && typeSpec != DPFConstants.REFLEXIVE_DSPECIFICATION){
				String relative = typeSpec.eResource().getURI().deresolve(createFileURI).toFileString();
				iter.setMetaFile(relative);
				iter.getSpecification().setMetaFile(DPFModelPersistanceUtils.getModelFromDiagram(relative));
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
			String newMetaFile = DPFModelPersistanceUtils.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getMetaFile())).toFileString();
			iter.setMetaFile(newMetaFile);
			iter.getSpecification().setMetaFile(DPFModelPersistanceUtils.getModelFromDiagram(newMetaFile));
		}
		if(iter.getSignatureFile() != null && !iter.getSignatureFile().isEmpty()){
			String newSignatureFile = DPFModelPersistanceUtils.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getSignatureFile())).toFileString();
			iter.setSignatureFile(newSignatureFile);
			iter.getSpecification().setSignatureFile(newSignatureFile);
		}
	}
	private static void updateSignatureReference(DSpecification iter, URI newBase){
		DSignature dSignature = iter.getDSignature();
		if(dSignature != null){
			URI oldBase = dSignature.eResource().getURI();
			for(DPredicate predicate : dSignature.getDPredicates()){
				String icon = predicate.getIcon();
				if(icon != null && !icon.isEmpty())
					predicate.setIcon(DPFModelPersistanceUtils.updateRelativeURI(oldBase, newBase, URI.createFileURI(predicate.getIcon())).toFileString());
			}
		}
	}
	public static void updateResourceSet(ResourceSetImpl resourceSet, DSpecification newSpec, URI oldURI, URI newURI){
		Assert.isNotNull(resourceSet);
		URI modelFileURI = DPFModelPersistanceUtils.getModelURI(newURI);
		Resource diagram = resourceSet.createResource(newURI);
		Resource model = resourceSet.createResource(modelFileURI);
		resourceSet.getURIResourceMap().put(newURI, diagram);
		resourceSet.getURIResourceMap().put(modelFileURI, model);
		DSpecification iter = newSpec;
		while(iter != DPFConstants.REFLEXIVE_DSPECIFICATION){
			EcoreUtil.resolveAll(iter.getDType());
			iter = iter.getDType();
		}
		iter = newSpec;
		while(iter != DPFConstants.REFLEXIVE_DSPECIFICATION){
			updateMetaModelReference(iter, oldURI, newURI);
			model.getContents().add(iter.getSpecification());
			diagram.getContents().add(iter);
			if(iter.getDSignature() != null && iter.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE){
				updateSignatureReference(newSpec, newURI);
				model.getContents().add(iter.getDSignature().getSignature());
				diagram.getContents().add(iter.getDSignature());
			}
			iter = iter.getDType();
		}
	}

	public DSignature getDSignature() {
		return visualizations.getInstance().getDSignature();
	}

	public void doSave(final URI uri, IProgressMonitor monitor) {

		saveProperties(getGraphicalViewer());
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				
				// Save the resources to the file system.
			//	DPFModelPersistanceUtils.saveDSpecification(resourceSet, dSpecification, uri, resourceToDiagnosticMap);
				VisualizationModelPersistanceUtils.saveVisualizations(resourceSet, visualizations, uri, resourceToDiagnosticMap);
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

	@Override
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
				updateResourceSet(resourceSet, visualizations.getInstance(), visualizations.getInstance().eResource().getURI(), DPFModelPersistanceUtils.getFileURI(file));
				doSave(DPFModelPersistanceUtils.getFileURI(file), new NullProgressMonitor());
			}
		}
	}

	@Override
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
						source = modelPropertySourceProvider.getPropertySource(((DNodeEditPart) object).getDiagramModel());
					else if(object instanceof DComposedNodePart)
						source = modelPropertySourceProvider.getPropertySource((((DComposedNodePart)object).getDConstraint()));
//					else if(object instanceof DDataNodeEditPart)  
//						source = modelPropertySourceProvider.getPropertySource(((DDataNodeEditPart) object).getDDataNode());
//					else if(object instanceof DNodeDAttributeEditPart)
//						source = modelPropertySourceProvider.getPropertySource((((DNodeDAttributeEditPart)object).getDNodeDAttribute()));
//					else if(object instanceof DArrowDAttributeEditPart)
//						source = modelPropertySourceProvider.getPropertySource((((DArrowDAttributeEditPart)object).getDArrowDAttribute()));
					else if(object instanceof DGraphEditPart)
						source = modelPropertySourceProvider.getPropertySource((((DGraphEditPart)object).getDGraph()));
					else if(object instanceof DArrowEditPart)
						source = modelPropertySourceProvider.getPropertySource(((DArrowEditPart) object).getDArrow());
					else if(object instanceof DConstraintEditPart)
						source = modelPropertySourceProvider.getPropertySource(((DConstraintEditPart)object).getModel());
					else if(object instanceof ArrowLabelEditPart){
						ArrowLabelEditPart editpart = (ArrowLabelEditPart) object;
						DOffset offset = editpart.getDOffset();
						if (offset != null && (offset.eContainer() instanceof DConstraint || offset .eContainer() instanceof DArrow))
							source = modelPropertySourceProvider .getPropertySource(offset.eContainer());
//					}else if(object instanceof DNodeDAttributeLabelEditPart){
//						DNodeDAttributeLabelEditPart editpart = (DNodeDAttributeLabelEditPart) object;
//							DOffset offset = editpart.getDOffset();
//							if (offset != null && (offset.eContainer() instanceof DConstraint || offset .eContainer() instanceof DNodeDAttribute))
//								source = modelPropertySourceProvider .getPropertySource(offset.eContainer());
					}else if(object instanceof VCompartmentElementEditPart){
						source = modelPropertySourceProvider.getPropertySource(((VCompartmentElementEditPart) object).getDiagramModel());
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
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(visualizations.getInstance().getDGraph());
		validateModel(visualizations.getInstance().getDGraph().getGraph());
		getSite().setSelectionProvider(getGraphicalViewer());
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

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		IFile file = ((IFileEditorInput) input).getFile();
		
		visualizations = VisualizationModelPersistanceUtils.loadVisualizations(resourceSet, DPFModelPersistanceUtils.getFileURI(file), resourceToDiagnosticMap);
		DSpecification dSpecification = visualizations.getInstance();
		
		EcoreUtil.resolveAll(dSpecification);
		EcoreUtil.resolveAll(dSpecification.getSpecification());
		if(dSpecification.getDSignature() != null){
			EcoreUtil.resolveAll(dSpecification.getDSignature());
			EcoreUtil.resolveAll(dSpecification.getDSignature().getSignature());
		}
		Assert.isTrue(dSpecification != null);
		setPartName(file.getName());

		paletteFactory.updatePalette(visualizations);

		shapesEditPartFactory = new VisualizationEditPartFactory(visualizations);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		getSite().getPage().addPartListener(partListener);
	}

	List<IAction> constraintActions = new ArrayList<IAction>();

	protected IPartListener partListener = new IPartListener() {
		@Override
		public void partActivated(IWorkbenchPart p) {
			VisualizationEditor editor = VisualizationEditor.this;
			if (p != editor)
				return;
			IActionBars actionBars = editor.getEditorSite().getActionBars();
			IToolBarManager toolbar = actionBars.getToolBarManager();
			for (IAction action : constraintActions)
				toolbar.add(action);
			toolbar.update(true);
			actionBars.updateActionBars();
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart p) { }

		@Override
		public void partClosed(IWorkbenchPart p) { }

		@Override
		public void partDeactivated(IWorkbenchPart p) {
			VisualizationEditor editor = VisualizationEditor.this;
			if (p != editor)
				return;
			IActionBars actionBars = editor.getEditorSite().getActionBars();
			IToolBarManager toolbar = actionBars.getToolBarManager();
			for (IAction action : constraintActions)
				toolbar.remove(action.getId());
			toolbar.update(true);
			actionBars.updateActionBars();
		}

		@Override
		public void partOpened(IWorkbenchPart p) { }
	};

	@Override
	public void dispose() {
		if(!isDirty())
			doSave(null);
		getSite().getPage().removePartListener(partListener);
		super.dispose();
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
		doSave(DPFModelPersistanceUtils.getFileURI(file), monitor);
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

		@Override
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
			getViewer().setContents(visualizations.getInstance().getSpecification());
			// show outline viewer
		}

		@Override
		public void dispose() {
			// unhook outline viewer
			getSelectionSynchronizer().removeViewer(getViewer());
			getSite().getPage().removePartListener(partListener);
			// dispose
			super.dispose();
		}

		@Override
		public Control getControl() {
			return getViewer().getControl();
		}

		/**
		 * @see org.eclipse.ui.part.IPageBookViewPage#init(org.eclipse.ui.part.IPageSite)
		 */
		@Override
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
					DPFCoreUtil.logError(e);
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
						+ DPFModelPersistanceUtils.printConstraint(constraint) + "}");
				marker.setAttribute(IMarker.LOCATION, name);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute("constraint", constraint);
			} catch (CoreException e) {
				marker = null;
				DPFCoreUtil.logError(e);
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
			DNode dNode = visualizations.getInstance().getDGraph().getDNode((Node) iter);
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
						DPFCoreUtil.logError(e);
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
			DPFCoreUtil.logError(e);
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
