package no.hib.dpf.visual.presentation;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.visual.VisualPlugin;
import no.hib.dpf.visual.VisualUtils;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.FileEditorInput;

public class VisualFormEditor extends FormEditor implements CommandStackListener{

	Visuals visuals = null;
	private boolean isChanged = false;
	private DefaultEditDomain editDomain;
	
	private String visualFile;
	public String getSignatureFile() {
		return visualFile;
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
			VisualFormPage editor = new VisualFormPage(this);
			int index = addPage(editor, getEditorInput());
			setPageText(index, editor.getTitle());
		}catch(PartInitException e){
			VisualPlugin.INSTANCE.log(e);
		}
		if (getPageCount() == 1 && getContainer() instanceof CTabFolder) 
			((CTabFolder) getContainer()).setTabHeight(0);
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
			VisualPlugin.INSTANCE.log(exception);
		}
	}

	private ResourceSetImpl resourceSet = VisualUtils.getResourceSet();
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	
	private void saveSignature() {
		VisualUtils.saveVisuals(resourceSet, URI.createFileURI(visualFile), visuals, resourceToDiagnosticMap);
	}
	
	public boolean isDirty() {
		return isChanged || super.isDirty() || getCommandStack().isDirty();
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
				visualFile = file.getLocation().toOSString();
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
		IFile file = ((IFileEditorInput)input).getFile();
		visualFile = file.getLocation().toOSString();
		setPartName(file.getName());
		visuals = VisualUtils.loadVisuals(resourceSet, URI.createFileURI(visualFile), resourceToDiagnosticMap);
	}

	protected CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	
	public void setDirty(boolean isDirty){
		isChanged = isDirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	public Visuals getVisuals() {
		return visuals;
	}
	
	private List<String> selectionActions = new ArrayList<String>();
	@Override
	public void commandStackChanged(EventObject event) {
		setDirty(true);
	}
	
	public void dispose() {
		getCommandStack().removeCommandStackListener(this);
		getEditDomain().setActiveTool(null);
		super.dispose();
	}
	
	protected List<String> getSelectionActions() {
		return selectionActions;
	}
	
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == CommandStack.class)
			return getCommandStack();
		return super.getAdapter(type);
	}
}
