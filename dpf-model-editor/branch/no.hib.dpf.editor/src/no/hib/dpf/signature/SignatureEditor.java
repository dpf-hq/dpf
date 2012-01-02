package no.hib.dpf.signature;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Signature;
import no.hib.dpf.editor.DPFErrorReport;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
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

public class SignatureEditor extends FormEditor{

	Signature signature = null;
	private URI uri = null;
	private boolean isSignatureChanged = false;

	protected FormToolkit createToolkit(Display display){
		return new FormToolkit(display);
	}
	@Override
	protected void addPages() {
		try{
			addPage(new SignatureFormPage(this));
		}catch(PartInitException e){
			DPFErrorReport.logError(e);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			@Override
			public void execute(IProgressMonitor monitor) {
				for(Resource resource : resourceSet.getResources())
					try {
						resource.save(null);
					} catch (IOException e) {
						DPFErrorReport.logError(e);
					}
			}
		};

		try {
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
			IFile file = ((IFileEditorInput)getEditorInput()).getFile();
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, monitor);
			setDirty(false);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public boolean isDirty() {
		return isSignatureChanged || super.isDirty();
	}
	@Override
	public void doSaveAs() {
		super.isDirty();
		// Show a SaveAs dialog
		Shell shell = getSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();

		final IPath path = dialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				Resource oldResource = resourceSet.getResource(uri, false);
				resourceSet.getResources().remove(oldResource);
				IFileEditorInput newInput = new FileEditorInput(file);
				setInputWithNotify(newInput);
				setPartName(newInput.getName());
				uri = EditUIUtil.getURI(newInput);
				Resource newResource = resourceSet.getResource(uri, true);
				newResource.getContents().add(signature);
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
		uri = EditUIUtil.getURI(input);
		getResourceSet();
		loadSignature();
	}

	private void loadSignature() {
		Resource resource = null;
		resource = getResource(resourceSet, uri, resourceToDiagnosticMap);
		if(resource != null){
			try {
				resource.load(null);
			} catch (IOException exception) {
				DPFErrorReport.logError(exception);
				signature = getDefaultSignature(resource);
				setDirty(true);
			}
			if(resource.getContents().size() > 0)
				signature = (Signature) resource.getContents().get(0);
			else{
				signature = getDefaultSignature(resource);
				setDirty(true);
			}
		}

	}

	public void setDirty(boolean isDirty){
		isSignatureChanged = isDirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
	private Signature getDefaultSignature(Resource resource) {
		Signature result = CoreFactory.eINSTANCE.createSignature();
		result.setName("Default_Signature");
		resource.getContents().clear();
		resource.getContents().add(result);
		try {
			resource.save(null);
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}
		return result;
	}

	public void getResourceSet(){
		if(resourceSet == null){
			resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMLResourceFactoryImpl());
			resourceSet.getLoadOptions().put(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		}
	}
	private ResourceSet resourceSet = null;
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	public static Resource getResource(ResourceSet resourceSet, URI resourceURI, Map<Resource, Diagnostic> resourceToDiagnosticMap){
		assert(resourceSet != null);
		assert(resourceToDiagnosticMap != null);
		Resource resource = null;
		try{
			resource = getResource(resourceSet, resourceURI);
		}
		catch(Exception exception){
			analyzeResourceProblems(resource, exception, resourceToDiagnosticMap);
		}
		return resource;
	}

	@SuppressWarnings("finally")
	public static Resource getResource(ResourceSet resourceSet, URI resourceURI){
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = resourceSet.getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(resourceURI, false);
			throw e;
		}
		finally{
			return resource;
		}
	}

	public static  void analyzeResourceProblems(Resource resource, Exception exception, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  analyzeResourceProblems(resource, exception));
		}
	}
	public static  Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic =
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"no.hib.dpf.editor",
							0,
							fileError(resource.getURI()),
							new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null) {
			return
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"no.hib.dpf.editor",
							0,
							fileError(resource.getURI()),
							new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	private static String fileError(URI uri) {
		return "Problems encountered in file " + uri.toString();
	}

	public Signature getSignature() {
		return signature;
	}

}
