package no.hib.dpf.editor.commands;

import java.io.File;
import java.util.HashMap;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class ValidateModelHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if(editor instanceof DPFEditor){
			final GraphicalViewer graphicalViewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class); // get it from your editor
			if(graphicalViewer == null) return null;

			IFile dpfFile = ((IFileEditorInput)editor.getEditorInput()).getFile();
			if(dpfFile != null){
				try {
					/*
					 * load transform and translate it into Alloy specification
					 */
					URI dpfModelURI = URI.createFileURI(dpfFile.getLocation().toOSString());
					DSpecification dpf = DPFUtils.loadDModel(dpfModelURI);
					TranslateDPFToAlloy translate = new TranslateDPFToAlloy(dpf);
					translate.translate();
					/*
					 * Write the translated Alloy Specification into the file *Name*.als
					 */
					IFolder folder = (IFolder) dpfFile.getParent();
					String dpfFileName = dpfFile.getName();
					String fileName = dpfFileName.substring(0, dpfFileName.lastIndexOf('.')), alloyFileName = fileName + ".als";
					File alloyFile = new File(folder.getLocation().toOSString(), alloyFileName);
					translate.writeToFile(alloyFile);

					A4Reporter rep = new A4Reporter();
					Module world = CompUtil.parseEverything_fromFile(rep, null, alloyFile.getAbsolutePath());
					A4Options options = new A4Options();
					options.solver = A4Options.SatSolver.SAT4J;
					options.skolemDepth = 1;

					/*
					 * Execute the commands
					 */
					for (Command command : world.getAllCommands()) {
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						IFile insFile = folder.getFile(fileName + "_instance.dpf");
						if(insFile.exists()){
							insFile.delete(true, new NullProgressMonitor());
						}
						if(ans == null) continue;
						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, dpf);
						DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), 
								instance, 
								URI.createFileURI(insFile.getLocation().toOSString()), new HashMap<Resource, Diagnostic>());
					}
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (Exception e) {
					DPFUtils.logError(e);
				}
			}
		}
		return null;
	}
}
