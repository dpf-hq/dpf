/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
�*******************************************************************************/
package no.hib.dpf.editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import no.hib.dpf.editor.editoractions.ConstraintProperties;
import no.hib.dpf.editor.editoractions.CreateConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlySurjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction;
import no.hib.dpf.editor.editoractions.CreateMultiplicityConstraintAction;
import no.hib.dpf.editor.editoractions.PrintAction;
import no.hib.dpf.editor.parts.EditPartFactoryImpl;
import no.hib.dpf.editor.parts.VNodesTreeEditPartFactory;
import no.hib.dpf.editor.viewmodel.DPFDiagram;
import no.hib.dpf.editor.viewmodel.ModelElement;
import no.hib.dpf.editor.viewmodel.ModelSerializationException;
import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.metamodel.IDObject;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.ModelHierarchy;
import no.hib.dpf.metamodel.Predicate;
import no.hib.dpf.metamodel.Signature;
import no.hib.dpf.metamodel.Specification;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
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
import org.eclipse.jface.viewers.ISelection;
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


/**
 * A graphical editor with flyout palette that can edit .shapes files. The
 * binding between the .shapes file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public class DPFEditor extends GraphicalEditorWithFlyoutPalette {

	/** This is the root of the editor's model. */
	private DPFDiagram diagram;
	private Specification specification = MetamodelFactory.eINSTANCE.createSpecification();
	// private ModelHierarchy modelHierarchy = MetamodelFactory.eINSTANCE.createModelHierarchy();
	private Signature signature = MetamodelFactory.eINSTANCE.createSignature();
		
	private static String dpfFilename;
	
//	/** Palette component, holding the tools and shapes. */
	private static PaletteRoot PALETTE_MODEL;
	
	private EditPartFactoryImpl shapesEditPartFactory;
	private DPFEditorPaletteFactory paletteFactory;
	private List<CreateConstraintAction> constraintActions = new ArrayList<CreateConstraintAction>();

	/** Create a new DPFEditor instance. This is called by the Workspace. */
	public DPFEditor() {
		specification.setTypeGraph(MetamodelFactory.eINSTANCE.createGraph("Node", "Arrow" + ":Node:Node"));
		paletteFactory = new DPFEditorPaletteFactory();
		setEditDomain(new DefaultEditDomain(this));
		shapesEditPartFactory = new EditPartFactoryImpl();
	}
	
	/**
	 * Test solution for buttons
	 */
//	@Override
//	public void createPartControl(Composite parent) {
		
//		Image image = new Image(parent.getDisplay(),"/Users/oyvind/Documents/model_workspace001/no.hib.dpf.editor/src/no/hib/dpf/editor/" +  ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_RECTANGLE));
		
//		Composite c = new Composite(parent, SWT.None);
//		c.setLayout(new GridLayout(1, true));
		
//		ToolBar tb = new ToolBar(c, SWT.None);
//		tb.setLayoutData(new org.eclipse.swt.layout.GridData(
//				org.eclipse.swt.layout.GridData.FILL_HORIZONTAL));
		
		
//		this.getEditorSite().getActionBars().getToolBarManager().add(constraintActions.get(0));
//		ToolItem ti1 = new ToolItem(tb, SWT.PUSH);
//		ti1.setText("Tool item 1");
//		ti1.setImage(image);
//
//		ToolItem ti2 = new ToolItem(tb, SWT.PUSH);
//		ti2.setText("Tool item 2");
//		ToolItem ti3 = new ToolItem(tb, SWT.PUSH);
//		ti3.setText("Tool item 3");
//		Composite composite = new Composite(c, SWT.None);
//		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
//		composite.setLayout(new FillLayout());
//		super.createPartControl(composite);
//	}
	
	/**
	 * Overridden to create our own actions
	 */
	@Override
	protected void createActions() {
		super.createActions(); // to get the default actions
		
		// First step to move the predicates out of the editor:
		// There remains to make some coupling between these predicates
		// and the parts/figures that implement them.
		
		Predicate predicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");		
		ConstraintProperties jointlyInjectiveProperties = new ConstraintProperties(
				predicate, 
				"Create new [jointly-injective] Constraint",
				"Creates a new Jointly Injective Constraint",
				VConstraint.ConstraintType.JOINTLY_INJECTIVE);
		
		constraintActions.add(new CreateJointlyInjectiveConstraintAction(this, diagram.getDpfGraph(), jointlyInjectiveProperties));
		
		
		predicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_2:n_1,e_2:n_3:n_1");
		
		ConstraintProperties jointlySurjectiveProperties = new ConstraintProperties(
				predicate, 
				"Create new [jointly-surjective] Constraint",
				"Creates a new Jointly Surjective Constraint",
				VConstraint.ConstraintType.JOINTLY_SURJECTIVE);
		
		constraintActions.add(new CreateJointlySurjectiveConstraintAction(this, diagram.getDpfGraph(), jointlySurjectiveProperties));
		
		
		predicate = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2", "e_1:n_1:n_2");

		ConstraintProperties multiplicityProperties = new ConstraintProperties(
				predicate, 
				"Create new Multiplicity Constraint",
				"Creates a new Multiplicity Constraint",
				VConstraint.ConstraintType.MULTIPLICITY);

		constraintActions.add(new CreateMultiplicityConstraintAction(this, diagram.getDpfGraph(), multiplicityProperties));
		
		for (CreateConstraintAction createConstraintAction : constraintActions) {
			registerAction(createConstraintAction);
		}		
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
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));

		// configure the context menu provider
		ContextMenuProvider cmProvider = new DPFEditorContextMenuProvider(
				viewer, getActionRegistry(), null);
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
		
		PrintAction printAction = new PrintAction(viewer);
		printAction.setText("Print");
		getEditorSite().getActionBars().getToolBarManager().add(printAction);
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

	private void createOutputStream(OutputStream os) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(getModel());
		oos.close();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor
	 * )
	 */
	public void doSave(IProgressMonitor monitor) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			createOutputStream(out);
			IFile file = ((IFileEditorInput) getEditorInput()).getFile();
			file.setContents(new ByteArrayInputStream(out.toByteArray()), true, // keep
																				// saving,
																				// even
																				// if
																				// IFile
																				// is
																				// out
																				// of
																				// sync
																				// with
																				// the
																				// Workspace
					false, // dont keep history
					monitor); // progress monitor
			getCommandStack().markSaveLocation();
		} catch (CoreException ce) {
			ce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		saveDPF(dpfFilename, getSpecification());
	}
	
	public static Specification loadDPF(String fileName) {
		URI uri = URI.createFileURI(fileName);
		Specification ret = null;
		
		try {
			ret = MetamodelFactory.eINSTANCE.loadSpecification(uri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}
	
	private void loadSignature() {
		if (new File(getSignatureFileName()).exists()) {
			try {
				signature = MetamodelFactory.eINSTANCE.loadSignature(URI.createFileURI(getSignatureFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else {

			signature.getPredicates().add(MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3"));
			signature.getPredicates().add(MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "e_1:n_2:n_1,e_2:n_3:n_1"));
			signature.getPredicates().add(MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2", "e_1:n_1:n_2"));
			
			try {
				signature.save(URI.createFileURI(getSignatureFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void saveDPF(String dpfFileName, Specification specification) {		
		try {
			specification.save(URI.createFileURI(dpfFileName));
		} catch (IOException e) {
			e.printStackTrace();
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

		IPath path = dialog.getResult();
		if (path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(path);
			try {
				new ProgressMonitorDialog(shell).run(false, // don't fork
						false, // not cancelable
						new WorkspaceModifyOperation() { // run this operation
							public void execute(final IProgressMonitor monitor) {
								try {
									ByteArrayOutputStream out = new ByteArrayOutputStream();
									createOutputStream(out);
									file.create(
											new ByteArrayInputStream(out
													.toByteArray()), // contents
											true, // keep saving, even if IFile
													// is out of sync with the
													// Workspace
											monitor); // progress monitor
								} catch (CoreException ce) {
									ce.printStackTrace();
								} catch (IOException ioe) {
									ioe.printStackTrace();
								}
							}
						});
				// set input to the new file
				setInput(new FileEditorInput(file));
				getCommandStack().markSaveLocation();
			} catch (InterruptedException ie) {
				// should not happen, since the monitor dialog is not cancelable
				ie.printStackTrace();
			} catch (InvocationTargetException ite) {
				ite.printStackTrace();
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class)
			return new ShapesOutlinePage(new TreeViewer());
		return super.getAdapter(type);
	}

	DPFDiagram getModel() {
		return diagram;
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
		if (PALETTE_MODEL == null) {
			PALETTE_MODEL = paletteFactory.createPalette(getSpecification().getTypeGraph());
		}
		return PALETTE_MODEL;
//		return paletteFactory.createPalette(specification.getTypeGraph());
	}

	private void handleLoadException(Exception e) {
		System.err.println("** Load failed. Using default model. **");
		e.printStackTrace();
		setSpecification(MetamodelFactory.eINSTANCE.createSpecification());
		diagram = new DPFDiagram();
		diagram.setDpfGraph(getSpecification().getGraph());
	}

	/**
	 * Set up the editor's inital content (after creation).
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(getModel()); // set the contents of this editor

//		// listen for dropped parts
//		viewer.addDropTargetListener(createTransferDropTargetListener());
	}

	@Override
	public void setFocus() {
		super.setFocus();
		paletteFactory.updatePalette(getPaletteRoot(), getSpecification().getTypeGraph());		
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
//		if (this.equals(getSite().getPage().getActiveEditor())) {
//			paletteFactory.updateConstraints(constraintActions, getPaletteRoot(), selection);			
//		}
	}	
	
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
			ObjectInputStream in = new ObjectInputStream(file.getContents());
			diagram = (DPFDiagram) in.readObject();
			in.close();
			setPartName(file.getName());

			// -------------------------------------------------------------------
			// D P F   S T U F F
			// -------------------------------------------------------------------
			setDpfFilePaths(file);
			
			//FIXME: We should only refresh the project if needed
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
			deserializeDpfModel();
			setDpfReferencesInViewModel(diagram.getChildrenWithID());
			
		} catch (IOException e) {
			handleLoadException(e);
		} catch (CoreException e) {
			handleLoadException(e);
		} catch (java.lang.ClassNotFoundException e) {
			handleLoadException(e);
		}
	}

	private void setDpfReferencesInViewModel(Map<String, ModelElement> children) {
		for (String id : children.keySet()) {
			IDObject idObject = diagram.getDpfGraph().getGraphMember(id);
			if (idObject == null) {
				throw new ModelSerializationException("A deserialized view model object had no serialized counterpart in the dpf model");
			}
			children.get(id).setIDObject(idObject);
		}
//		for (String id : children.keySet()) {
//			ModelElement child = children.get(id);
//			if (child instanceof ConstraintElement) {
//				((ConstraintElement)child).resetConstraintFigure();
//			}
//		}
	}

	private void deserializeDpfModel() {
		File serializedDPF = new File(dpfFilename);
		if (serializedDPF.exists()) {
			setSpecification(loadDPF(dpfFilename));
		}
		diagram.setDpfGraph(getSpecification().getGraph());
//		paletteFactory.updatePalette(getPaletteRoot(), getSpecification().getTypeGraph());
	}

	/**
	 * Returns the path to the workspace of this editor.
	 */
	public static String getWorkspaceDirectory() {
		return ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
	}

	/**
	 * Returns the name of the "DPF" file from a "base" file name
	 */
	public static String getDPFFileName(String filename) {
		return getWorkspaceDirectory() + File.separator + filename + ".xmi";
	}
	
	private static String getSignatureFileName() {
		return getWorkspaceDirectory() + File.separator + "signature01.xmi";
	}
		
	private void setDpfFilePaths(IFile file) {
		dpfFilename = getDPFFileName(file.getFullPath().toString());
	}
	
	private void setSpecification(Specification specification) {
		this.specification = specification;
	}

	private Specification getSpecification() {
		return specification;
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
			getViewer().setEditPartFactory(new VNodesTreeEditPartFactory());
			// configure & add context menu to viewer
			ContextMenuProvider cmProvider = new DPFEditorContextMenuProvider(getViewer(), getActionRegistry(), null);
			getViewer().setContextMenu(cmProvider);
			getSite().registerContextMenu(
					"org.eclipse.gef.examples.shapes.outline.contextmenu",
					cmProvider, getSite().getSelectionProvider());
			// hook outline viewer
			getSelectionSynchronizer().addViewer(getViewer());
			// initialize outline viewer with model
			getViewer().setContents(getModel());
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
		}
	}

}