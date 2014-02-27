package no.hib.dpf.verify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Predicate;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.util.TransformConstants;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;


/**
 * The hander executes verification when user select a transform file.
 *
 */
public class TranslateToAlloyHandler extends RunAlloy {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile transformFile = getSelectedFile(event);
		if(transformFile != null){
			try {
				/*
				 * load transform and translate it into Alloy specification
				 */
				URI transformFileURI = URI.createFileURI(transformFile.getLocation().toOSString());
				ResourceSetImpl resourceSet = TransformEditor.getResourceSet();
				Map<Resource, Diagnostic> diagnose = new LinkedHashMap<Resource, Diagnostic>();
				Transform transform = TransformEditor.loadTransform(resourceSet, transformFileURI, diagnose);
				TranslateToAlloy translate = new TranslateToAlloy(transform);
				translate.translate();
				/*
				 * Write the translated Alloy Specification into the file *Name*.als
				 */
				IFolder folder = transformFile.getParent().getFolder(new Path(TransformConstants.GENERATE_FOLDER));
				String transformFileName = transformFile.getName();
				String fileName = transformFileName.substring(0, transformFileName.lastIndexOf('.'));
				File alloyFile = new File(folder.getLocation().toOSString(), fileName + ".als"); 
				FileWriter writer = new FileWriter(alloyFile);
				writer.write(translate.getBuffer().toString());
				writer.close();
				
				for(Predicate predicate : DPFConstants.REFLEXIVE_SPECIFICATION.getSignature().getPredicates())
					System.out.println(predicate);
				/*
				 * Verify the Alloy Specification and write the generated counterexamples into a transform file.
				 */
				Transform instance = generateInstance(transform, alloyFile.getAbsolutePath(), translate.commands);
				TransformEditor.saveTransform(resourceSet, URI.createFileURI(folder.getFile(fileName + "_counter.xform").getLocation().toOSString()), instance,  diagnose);
				folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
			} catch (CoreException | IOException e) {
				DPFUtils.logError(e);
			}
		}
		return null;
	}

}
