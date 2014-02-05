package no.hib.dpf.transform.presentation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.verify.TranslateToAlloy;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

public class TranslateToAlloyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil .getActiveWorkbenchWindowChecked(event);
		if (window == null)
			return null;
		
		IWorkbenchPage page = window.getActivePage();
		if (page == null)
			return null;
		
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof TransformEditor){
			TransformEditor transformEditor = (TransformEditor) editor;
			IEditorInput input = transformEditor.getEditorInput();
			if(input instanceof FileEditorInput){
				FileEditorInput fileInput = (FileEditorInput) input;
				IFile file = fileInput.getFile();
				try {
					IFolder folder = file.getParent().getFolder(new Path(TransformConstants.GENERATE_FOLDER));
					Transform transform = transformEditor.getTransform();
					TranslateToAlloy translate = new TranslateToAlloy(transform);
					translate.translate();
					String name = file.getName().replaceAll("." + file.getFileExtension(), "");
					FileWriter writer = new FileWriter(new File(folder.getLocation().toOSString(), name  + ".als"));
					writer.write(translate.getBuffer().toString());
					writer.close();
					file.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
				} catch (CoreException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
