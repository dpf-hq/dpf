package no.hib.dpf.transform.util;

import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.provider.TransformEditPlugin;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;

public class TransformUtils extends DPFUtils{

		
	public static String activeTransformModel(){
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		IEditorInput input = editor.getEditorInput();
		//IPath path = ((FileEditorInput)input).getPath();		
		String path = ((FileEditorInput)input).getName();
		
		return path;
	}
	
	public static IWorkbenchWindow getActiveWorkBenchWindow(){
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		
		return win;
	}
	
	public static String activeWorkingDirectory(){
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		IEditorInput input = editor.getEditorInput();
		IPath path = ((FileEditorInput)input).getPath();
		
		return path.toFile().getParentFile().toString();
	}
	
	public static String trimActiveTransformModel(){
		String oldName = activeTransformModel();
		String trimmedString = oldName.replace(".xform", "");
		return trimmedString;
	}
	
	public static String getDSpecificationFileName(String file){
		URI fileName = URI.createFileURI(file);
		String trimmedString = fileName.lastSegment().replace(".dpf", "");
		return trimmedString;
		
	}
	
	public static String createCorrespondanceType(String source, String target){
		return source + "2" + target;
	}
	
	public static String activeWindowFileLocation(){
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart editor = page.getActiveEditor();
		IEditorInput input = editor.getEditorInput();
		IFile file = ((IFileEditorInput)input).getFile();
		return file.getLocation().toOSString();
	}

	public static IProject getCurrentProject(IWorkbench workbench, IStructuredSelection selection){
		
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IProject project = null;
	    if (window != null)
	    {
	    	Object firstElement = selection.getFirstElement();
	    	if (firstElement instanceof IAdaptable){
	    		project = (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
	        }
	    }
	    return project;
	}
	
	public static void updateFileName(WizardNewFileCreationPage newFileCreationPage, IStructuredSelection selection, String defaultModelBaseFilename, String defaultModelFilenameExtension){
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
	}

	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xform", new XMIResourceFactoryImpl());
		return resourceSet;
	}

	public static Transform loadTransform(ResourceSetImpl resourceSet,	URI createFileURI) {
		Assert.isNotNull(resourceSet);
		Resource transform = createResource(resourceSet, createFileURI);
		Object transfoObject = getObjectFromResource(transform);
		if(transfoObject instanceof Transform)
			return (Transform)transfoObject;
		return null;
	}
	
	public static Plugin getPlugin() {
		return TransformEditPlugin.getPlugin();
	}

	public static String getPluginID() {
		return TransformEditPlugin.getPlugin().getSymbolicName();
	}
}

