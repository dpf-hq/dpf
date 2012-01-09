package no.hib.dpf.signature;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.ModelElement;
import no.hib.dpf.editor.displaymodel.ModelSerializationException;
import no.hib.dpf.editor.displaymodel.SingleArrowConstraintElement;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.DefaultEditDomain;
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

public class SignatureEditor extends FormEditor implements CommandStackListener, ISelectionListener{

	Signature signature = null;
	private boolean isSignatureChanged = false;
	private DefaultEditDomain editDomain;
	
	List<DPFDiagram> diagrams = new ArrayList<DPFDiagram>();
	private String signatureFile;
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
			SignatureFormPage editor = new SignatureFormPage(this);
			int index = addPage(editor, getEditorInput());
			setPageText(index, editor.getTitle());
		}catch(PartInitException e){
			DPFErrorReport.logError(e);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
					saveSignature();
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
			DPFErrorReport.logError(exception);
		}
	}

	private void saveSignature() {
		try {
			signature.save(URI.createFileURI(signatureFile));
			if(diagrams.size() == 0)
				return;
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(signatureFile + ".graph"));
			for(DPFDiagram diagram : diagrams)
				oos.writeObject(diagram);
			oos.writeObject(null);
			oos.close();
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
	}
	public boolean isDirty() {
		return isSignatureChanged || super.isDirty() || getCommandStack().isDirty();
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
				signatureFile = file.getLocation().toOSString();
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
		signatureFile = ((IFileEditorInput)input).getFile().getLocation().toOSString();
		loadSignature(signatureFile);
		
		
	}

	protected CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	private void setDpfReferencesInViewModel(DPFDiagram diagram) {
		Map<String, ModelElement> children = diagram.getChildrenWithID();
		for (String id : children.keySet()) {
			IDObject idObject = diagram.getDpfGraph().getGraphMember(id);
			if (idObject == null) {
				throw new ModelSerializationException("A deserialized view model object had no serialized counterpart in the dpf model");
			}
			children.get(id).setIDObject(idObject);
			
		}
		for (ModelElement modelElement : children.values()) {
			if (modelElement instanceof DArrow) {
				// Q&D fix to get single constraints out of this. TODO: refactor all
				// constraints into "connection" constraints and "connected" constraints
				DArrow arrow = (DArrow)modelElement;
				for (SingleArrowConstraintElement singleLineConstraintElement : arrow.getSingleConstraints()) {
				
					IDObject idObject2 = diagram.getDpfGraph().getGraphMember(singleLineConstraintElement.getIDObjectID());
					if (idObject2 == null) {
						throw new ModelSerializationException("A deserialized view model object had no serialized counterpart in the dpf model");
					}
					singleLineConstraintElement.setIDObject(idObject2);
					singleLineConstraintElement.refreshSource();
				}
			}			
		}
	}
	private void loadSignature(String file){
		
		try {
			URI uri = URI.createFileURI(file);
			signature = CoreFactory.eINSTANCE.loadSignature(uri);
			if(ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(file + ".graph")) == null)
				return;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file + ".graph"));
			while(true){
				Object object = ois.readObject();
				if(object instanceof DPFDiagram){
					DPFDiagram diagram = (DPFDiagram)object;
					diagram.setDpfGraph(getGraph(signature, diagram.getGraphID()));
					diagrams.add(diagram);
					setDpfReferencesInViewModel(diagram);
				}else
					break;
			}
			ois.close();
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		} catch (ClassNotFoundException e) {
			DPFErrorReport.logError(e);
		}
	}

	private Graph getGraph(Signature signature2, String graphID) {
		for(Predicate predicate : signature2.getPredicates())
			if(predicate.getShape().getId().equals(graphID))
				return predicate.getShape();
		return null;
	}
	public void setDirty(boolean isDirty){
		isSignatureChanged = isDirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	public Signature getSignature() {
		return signature;
	}
	public void addDGraph(List<DPFDiagram> dGraphs) {
		if(!diagrams.containsAll(dGraphs))
			diagrams.addAll(dGraphs);
	}
	
	public void removeDGraph(List<DPFDiagram> dGraphs) {
		if(diagrams.containsAll(dGraphs))
			diagrams.removeAll(dGraphs);
	}
	public DPFDiagram findDGraph(Graph shape) {
		for(DPFDiagram diagram : diagrams)
			if(diagram.getDpfGraph() == shape)
				return diagram;
		return null;
	}
	
	private List<String> stackActions = new ArrayList<String>();
	private List<String> selectionActions = new ArrayList<String>();
	private ActionRegistry actionRegistry;
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

//		action = new SaveAction(this);
//		registry.registerAction(action);
//		getPropertyActions().add(action.getId());

//		registry.registerAction(new PrintAction(this));
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
	
	public List<DPFDiagram> findDGraph(List<?> selected) {
		List<DPFDiagram> result = new ArrayList<DPFDiagram>();
		for(Object predicate : selected)
			if(predicate instanceof Predicate)
				result.add(findDGraph(((Predicate)predicate).getShape()));
			else
				return result;
		return result;
	}
	
	public static void saveSignature(String osString, Signature signature2) {
		try {
			signature2.save(URI.createFileURI(osString));
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
	}

}
