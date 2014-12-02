package no.hib.dpf.verify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * The handler executes verification when users select a als file. In this way,  users can edit the file manually.
 *
 */
public class GenerateSMT extends RunAlloy {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile transformFile = getSelectedFile(event);
		if(transformFile != null){
			try {
				/*
				 * load transform and translate it into Alloy specification
				 */
				URI transformFileURI = URI.createFileURI(transformFile.getLocation().toOSString());
				ResourceSetImpl resourceSet = TransformUtils.getResourceSet();
				Transform transform = TransformUtils.loadTransform(resourceSet, transformFileURI);
				TranslateToSMT translate = new TranslateToSMT(transform);
				translate.translate();
				/*
				 * Write the translated Alloy Specification into the file *Name*.als
				 */
				IFolder folder = transformFile.getParent().getFolder(new Path(TransformConstants.GENERATE_FOLDER));
				String transformFileName = transformFile.getName();
				String fileName = transformFileName.substring(0, transformFileName.lastIndexOf('.'));
//				File alloyFile = new File(folder.getLocation().toOSString(), fileName + ".smt2"); 
				translate.writeToFile(new File(folder.getLocation().toOSString(), fileName + ".smt2"));
				folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				/*
				 * Verify the Alloy Specification and write the generated counterexamples into a transform file.
				 */
			} catch (CoreException  | IOException e) {
				DPFUtils.logError(e);
			}
		}
		return null;
	}
	protected Transform generateInstance(Transform transform, String alloyFile, List<String> commands){
		Transform transformInstance = TransformFactory.eINSTANCE.createTransform();
		transformInstance.setElementTypeGraph(transform.getElementTypeGraph());
		try {
			/*
			 * Read Alloy Specification from a als file
			 */
			FileWriter writer = new FileWriter(alloyFile, true);
			/*
			 * Read Command from a command file
			 */
			for (int i = 3; i < 20; i++) {
				String scope = "for " + i + " but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule";
				for (int index = 0; index < commands.size(); index++) {
					String command = commands.get(index);
					writer.write("check{all t: Trans|" + command + "}" + scope + System.lineSeparator());
				}
//				for(Production rule : transform.getRules()){
//					writer.write("run{}" + scope + ", exactly 1 " + rule.getName() + System.lineSeparator());
//				}
			}
			writer.close();

		} catch (IOException e1) {
			DPFUtils.logError(e1);
		}
		return transformInstance;
	}
}
	
