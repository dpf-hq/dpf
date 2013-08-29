package no.hib.dpf.transform.util;

import java.io.File;

import no.hib.dpf.editor.DPFUtils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class TransformUtils {

		
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
		//String path = ((FileEditorInput)input).getName();
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
}
