/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 * @generate NOT
 */
package no.hib.dpf.transform.presentation;



import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Specification;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.SelectAllAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.FileEditorInput;
public class TransformEditor extends FormEditor implements CommandStackListener, ISelectionListener{

	Transform transform = null;
	private boolean isTransformChanged = false;
	private DefaultEditDomain editDomain;
	
	private String transformFile;
	
	public String getTransformFile() {
		return transformFile;
	}
	public DefaultEditDomain getEditDomain() {
		return editDomain;
	}
	public void setEditDomain(DefaultEditDomain editDomain) {
		this.editDomain = editDomain;
	}
	protected FormToolkit createToolkit(Display display){
		return new FormToolkit(display);
	}
	@Override
	protected void addPages() {
		try{
			TransformFormPage editor = new TransformFormPage(this);
			int index = addPage(editor, getEditorInput());
			setPageText(index, editor.getTitle());
		}catch(PartInitException e){
			DPFUtils.logError(e);
		}
		if (getPageCount() == 1 && getContainer() instanceof CTabFolder) 
			((CTabFolder) getContainer()).setTabHeight(0);
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
					saveTransform();
			}
		};

		try {
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
			IFile file = ((IFileEditorInput)getEditorInput()).getFile();
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
			getCommandStack().markSaveLocation();
			setDirty(false);
		}
		catch (Exception exception) {
			DPFUtils.logError(exception);
		}
	}

	
	private ResourceSetImpl resourceSet = getResourceSet();
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	
	private void saveTransform() {
		saveTransform(resourceSet, URI.createFileURI(transformFile), transform, resourceToDiagnosticMap);
	}
	
	public boolean isDirty() {
		return isTransformChanged || super.isDirty() || getCommandStack().isDirty();
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
				transformFile = file.getLocation().toOSString();
				doSave(new NullProgressMonitor());
			}
		}
	}


	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}
	
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		setEditDomain(new DefaultEditDomain(this));
		getCommandStack().addCommandStackListener(this);
		initializeActionRegistry();
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
		IFile file = ((IFileEditorInput)input).getFile();
		transformFile = file.getLocation().toOSString();
		setPartName(file.getName());
		transform = loadTransform(resourceSet, URI.createFileURI(transformFile), resourceToDiagnosticMap);
	}

	protected CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	
	public void setDirty(boolean isDirty){
		isTransformChanged = isDirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	public Transform getTransform() {
		return transform;
	}
	
	private List<String> stackActions = new ArrayList<String>();
	private List<String> selectionActions = new ArrayList<String>();
	private ActionRegistry actionRegistry;
	private boolean isSnapEnable;
	private boolean isGridEnable;
	private boolean isGridVisible;
	@Override
	public void commandStackChanged(EventObject event) {
		updateActions(stackActions);
		setDirty(true);
	}
	
	protected void updateActions(List<String> actionIds) {
		ActionRegistry registry = getActionRegistry();
		Iterator<String> iter = actionIds.iterator();
		while (iter.hasNext()) {
			IAction action = registry.getAction(iter.next());
			if (action instanceof UpdateAction)
				((UpdateAction) action).update();
		}
	}
	
	protected ActionRegistry getActionRegistry() {
		if (actionRegistry == null)
			actionRegistry = new ActionRegistry();
		return actionRegistry;
	}
	
	protected List<String> getStackActions() {
		return stackActions;
	}
	
	protected void createActions() {
		ActionRegistry registry = getActionRegistry();
		IAction action;

		action = new UndoAction(this);
		registry.registerAction(action);
		getStackActions().add(action.getId());

		action = new RedoAction(this);
		registry.registerAction(action);
		getStackActions().add(action.getId());

		action = new SelectAllAction(this);
		registry.registerAction(action);

		action = new DeleteAction((IWorkbenchPart) this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
	}
	
	protected void initializeActionRegistry() {
		createActions();
		updateActions(stackActions);
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// If not the active editor, ignore selection changed.
		if (this.equals(getSite().getPage().getActiveEditor()))
			updateActions(selectionActions);
	}
	
	public void dispose() {
		getCommandStack().removeCommandStackListener(this);
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
		getEditDomain().setActiveTool(null);
		getActionRegistry().dispose();
		super.dispose();
	}
	
	protected List<String> getSelectionActions() {
		return selectionActions;
	}
	
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == CommandStack.class)
			return getCommandStack();
		if (type == ActionRegistry.class)
			return getActionRegistry();
		return super.getAdapter(type);
	}
	
	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xform", new XMIResourceFactoryImpl());
		return resourceSet;
	}
	
	public static void saveTransform(ResourceSetImpl resourceSet, URI osString, Transform transform, 
			Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Assert.isNotNull(resourceSet);
		Resource tranfromResource = resourceSet.getResource(osString, false);
		if(tranfromResource == null){
			tranfromResource = resourceSet.createResource(osString);
			resourceSet.getURIResourceMap().put(osString, tranfromResource);
			tranfromResource.getContents().add(transform);
		}
		try {
			List<EObject> has = new ArrayList<EObject>();
			has.addAll(tranfromResource.getContents());
			has.remove(transform);
			for(Production rule : transform.getRules()){
				Specification spec = rule.getSum().getSpecification();
				if(has.contains(spec))
					has.remove(spec);
				else
					tranfromResource.getContents().add(spec);
			}
			for(EObject e : has)
				tranfromResource.getContents().remove(e);
				
			tranfromResource.save(null);
		} catch (IOException e) {
			DPFCoreUtil.analyzeResourceProblems(tranfromResource, e, resourceToDiagnosticMap);
			System.out.println(e);
		}
	}
	
	protected void loadProperties(GraphicalViewer viewer) {
		// Snap to Geometry property
		viewer.setProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED, new Boolean(isSnapEnable));		
		// Grid properties
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_ENABLED, new Boolean(isGridEnable));
		// We keep grid visibility and enablement in sync
		viewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, new Boolean(isGridVisible));
//		// Zoom
//		ZoomManager manager = (ZoomManager)getGraphicalViewer().getProperty(ZoomManager.class.toString());
//		if (manager != null) {
//			manager.setZoom(diagram.getZoom());
//		}
	}
	public static Transform loadTransform(ResourceSetImpl resourceSet,
			URI diagramURI,
			Map<Resource, Diagnostic> resourceToDiagnosticMap2) {
		Assert.isNotNull(resourceSet);
		Resource transform = resourceSet.createResource(diagramURI);
		try {
			transform.load(null);
		} catch (IOException e) {
			DPFUtils.logError(e);
		}
		return (Transform) transform.getContents().get(0);
	}	
	
	
}

