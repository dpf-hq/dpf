package no.hib.dpf.verify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
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

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;


/**
 * The hander executes verification when user select a transform file.
 *
 */
public class VerifyTransformSequential extends RunAlloy {

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

				IFolder folder = transformFile.getParent().getFolder(new Path(TransformConstants.GENERATE_FOLDER));
				String transformFileName = transformFile.getName();
				String fileName = DPFUtils.getFileNameWithExtension(transformFileName);
				IFile alloyFile = folder.getFile(fileName + ".als");
				TranslateToAlloy translate = null;
				if(!alloyFile.exists()){
					translate = new TranslateToAlloy(transform);
					translate.translate();
					/*
					 * Write the translated Alloy Specification into the file *Name*.als
					 */
					translate.writeToFile(new File(folder.getLocation().toOSString(), fileName + ".als"));
					/*
					 * Verify the Alloy Specification and write the generated counterexamples into a transform file.
					 */
					Transform instance = super.generateInstance(transform, alloyFile.getLocation().toOSString(), translate.commands);
					TransformEditor.saveTransform(resourceSet, URI.createFileURI(folder.getFile(fileName + "_counter.xform").getLocation().toOSString()), instance,  diagnose);
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				}
				int i = 2;
				while(true){
					IFile file = folder.getFile(fileName + i + ".als");
					if(!file.exists()) break;
					++i;
				}

				List<String> commands = new ArrayList<String>();
				IFile commandFile = folder.getFile(new Path(fileName + ".command"));
				String commandFileName = commandFile.getLocation().toOSString();
				if(commandFile.exists()){
					BufferedReader reader = new BufferedReader(new FileReader(commandFileName));
					while(true){
						String line = reader.readLine();
						if(line == null) break;
						line += TranslateToAlloy.LINE;
						line += reader.readLine() + TranslateToAlloy.LINE;
						commands.add(line);
					}
					reader.close();
				}
				if(!commands.isEmpty()){
					Transform instance = generateInstance(transform, alloyFile.getLocation().toOSString(), i, translate.commands);
				}

			} catch (CoreException | IOException e) {
				DPFUtils.logError(e);
			}
		}
		return null;
	}

	protected Transform generateInstance(Transform transform, String alloyFile, int step, List<String> commands){
		Transform transformInstance = TransformFactory.eINSTANCE.createTransform();
		transformInstance.setElementTypeGraph(transform.getElementTypeGraph());
		try {
			/*
			 * Read Alloy Specification from a als file
			 */
			PrintWriter writer = new PrintWriter("temp.als");
			BufferedReader reader = new BufferedReader(new FileReader(alloyFile));
			while(true){
				String line = reader.readLine();
				if(line == null) break;
				if(line.startsWith("pred source_valid[trans:Trans]{")){
					writer.println("pred valid[graph:Graph]{");
					while(true){
						line = reader.readLine();
						if(line == null) break;
						if(line.equals("}")){
							writer.println(line);
							writer.println("pred invalid[graph:Graph]{");
							break;
						}
						line = line.replaceAll("&trans.source.nodes", "&graph.nodes");
						line = line.replaceAll("&trans.source.arrows", "&graph.arrows");
						writer.println(line);
					}
				}else if(line.startsWith("fact{ all trans: Trans|")){
					String left = line.substring(new String("fact{ all trans: Trans|").length());
					writer.println(left);
					line = reader.readLine();
					writer.print(line);
					reader.readLine();
				}

			}
			reader.close();
			/*
			 * Read Command from a command file
			 */
			for (int i = 0; i < commands.size(); i++) {
				String command = commands.get(i);
				if(i != 0)
					writer.print("or ");
				command = command.replaceAll("&trans.source.nodes", "&graph.nodes");
				command = command.replaceAll("&trans.source.arrows", "&graph.arrows");
				writer.println(command);
			}
			writer.println("}");
			/*
			 * Writer Path signature
			 */
			writer.print("sig Path{");
			for(int iter = 1; iter <= step; ++iter){
				writer.print("trans" + iter + ":one Trans");
				if(iter != step)
					writer.print(",");
			}
			writer.print("}{");
			for(int iter = 1; iter < step; ++iter){
				writer.print("trans" + iter + ".target=trans" + (iter + 1) + ".source");
				if(iter + 1 != step)
					writer.print(" and ");
			}
			writer.print("}");
			
			writer.print("fact{all path : Path | valid[path.trans1.source]) and ");
			for(int iter = 1; iter < step; ++iter){
				writer.print("and (invalid[path.trans" + iter + "target])");
			}
			writer.println("}");
			String scope = "for " + (step + 2) + " but exactly 1 Path, exactly " + step + " Trans, exactly " + (step + 2) + " Graph, exactly 2 Rule";
			for (int i = 0; i < commands.size(); i++) {
				String command = commands.get(i);
				command = command.replaceAll("&trans.source.nodes", "&path.trans" + step + ".target.nodes");
				command = command.replaceAll("&trans.source.arrows", "&path.trans" + step + ".target.arrows");
				writer.println("check{all path: Path |" + command + "}" + scope);
			}
			for(Production rule : transform.getRules()){
				writer.println("run{}" + DEFAULT_SCOPE + ", exactly 1 " + rule.getName());
			}
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
			int index = 0;
			List<String> verified = new ArrayList<String>(), violated = new ArrayList<String>();
			for (Command command : world.getAllCommands()) {
				A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
				Production rule = GenerateInstanceFromAlloy.generateProductionFromAlloy(ans, transformInstance);
				if(rule != null){
					transformInstance.getRules().add(rule);
					if(!ans.getOriginalCommand().startsWith("Run")){
						String current = commands.get(index);
						int line = current.indexOf(TranslateToAlloy.LINE);
						violated.add(current);
						current = current.substring(0, line);
						current += " violated by " + rule.getName();
						rule.setName(current);
					}
				}else{
					if(!ans.getOriginalCommand().startsWith("Run")){
						verified.add(commands.get(index));
					}
				}
				++index;
			}
			/*
			 * Write each verified command as a fact 
			 */
			FileWriter alloyWriter = new FileWriter(alloyFile, true);
			for(String command : verified)
				alloyWriter.write("fact{ all trans: Trans|" + command + "}" + TranslateToAlloy.LINE);
			alloyWriter.close();

			/*
			 * Write each violated command to the old command file
			 */
			String commandFile = alloyFile.substring(0, alloyFile.lastIndexOf('.')) + ".command";
			FileWriter commandWriter = new FileWriter(commandFile);
			for(String command : violated)
				commandWriter.write(command);
			commandWriter.close();
		} catch ( Err | IOException e1) {
			DPFUtils.logError(e1);
		}
		return transformInstance;
	}
}
