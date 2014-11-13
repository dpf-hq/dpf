package no.hib.dpf.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.presentation.TransformEditor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

/**
 * Given a diagramModel or a model, generate a random instance by Alloy.
 * In this way, we can verify if any valid instance exists for the metamodel.
 *
 */
public class GenerateInstance extends RunAlloy {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile file = getSelectedFile(event);

		if(file != null){
			String fileName = file.getName();
			DSpecification diagramModel = null;
			ResourceSetImpl resourceSet = TransformEditor.getResourceSet();
			Map<Resource, Diagnostic> diagnose = new LinkedHashMap<Resource, Diagnostic>();
			URI fileURI = URI.createFileURI(file.getLocation().toOSString());
			if(fileName.endsWith(".dpf"))
				diagramModel = DPFUtils.loadDModel(resourceSet, fileURI, diagnose);
			else if(fileName.endsWith(".xmi")){
				Specification model = DPFUtils.loadSpecification(resourceSet, fileURI, diagnose);
				diagramModel = DPFUtils.createDSpecificationFromSpecification(resourceSet, fileURI, model, null, diagnose);
			}
			if(diagramModel != null){
				TranslateToAlloy translate = new TranslateToAlloy(diagramModel);
				translate.translate();

				try {
					IContainer folder = file.getParent();
					String alloyFile = DPFUtils.getFileNameWithExtension(file.getLocation().toOSString());
					DSpecification dSpecification = generateInstance(diagramModel, translate.getBuffer().toString());
					DPFUtils.saveDSpecification(resourceSet, dSpecification, URI.createFileURI(alloyFile + "_instance.dpf"), diagnose);
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (CoreException e) {
					DPFUtils.logError(e);
				}
			}
		}
		return null;
	}
	protected DSpecification generateInstance(DSpecification transform, String alloy){
		try {
			/*
			 * Read Alloy Specification from a als file
			 */
			PrintWriter writer = new PrintWriter("temp.als");
			writer.println(alloy);
			writer.println("run{}");
			writer.close();

			/*
			 * Parse the Alloy Specification and the commands
			 */
			A4Options options = new A4Options();
			options.solver = A4Options.SatSolver.SAT4J;
			options.skolemDepth = 1;
			A4Reporter rep = new A4Reporter();
			Module world = CompUtil.parseEverything_fromFile(rep, null, "temp.als");

			/*
			 * Execute the commands
			 */
			for (Command command : world.getAllCommands()) {
				A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
				DSpecification rule = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, transform);
				return rule;
			}

		} catch ( Err | IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
