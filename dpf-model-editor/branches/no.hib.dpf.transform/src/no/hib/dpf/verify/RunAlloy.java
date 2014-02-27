package no.hib.dpf.verify;

import java.io.BufferedReader;
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

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

/**
 * The handler executes verification when users select a als file. In this way,  users can edit the file manually.
 *
 */
public class RunAlloy extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IFile alsFile = getSelectedFile(event);
		if(alsFile != null){
			try {
				IContainer folder = alsFile.getParent();
				/*
				 * Load the transform file in order to get the metamodel informations and rules
				 */
				IContainer xformFolder = folder.getParent();
				String dpfFileName = alsFile.getName().substring(0, alsFile.getName().lastIndexOf('.'));
				IFile xformFile = xformFolder.getFile(new Path(dpfFileName + ".xform"));
				if(!xformFile.exists())
					return null;
				URI dpfFileURI = URI.createFileURI(xformFile.getLocation().toOSString());
				ResourceSetImpl resourceSet = TransformEditor.getResourceSet();
				Map<Resource, Diagnostic> diagnose = new LinkedHashMap<Resource, Diagnostic>();
				Transform transform = TransformEditor.loadTransform(resourceSet, dpfFileURI, diagnose);
				/*
				 * read the command file to load the commands
				 */
				List<String> commands = new ArrayList<String>();
				String commandFile = folder.getFile(new Path(dpfFileName + ".command")).getLocation().toOSString();
				BufferedReader reader = new BufferedReader(new FileReader(commandFile));
				while(true){
					String line = reader.readLine();
					if(line == null)
						break;
					line += TranslateToAlloy.LINE;
					line += reader.readLine() + TranslateToAlloy.LINE;
					commands.add(line);
				}
				reader.close();
				Transform instance = generateInstance(transform, alsFile.getLocation().toOSString(), commands);
				TransformEditor.saveTransform(resourceSet, URI.createFileURI(folder.getFile(new Path(dpfFileName + "_counter.xform")).getLocation().toOSString()), instance, diagnose);
				folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
			} catch (CoreException | IOException e) {
				DPFUtils.logError(e);
			} 
		}
		return null;
	}

	private static final String DEFAULT_SCOPE = "for 5 but exactly 1 Trans, exactly 2 Graph, exactly 1 Rule";
	protected Transform generateInstance(Transform transform, String alloyFile, List<String> commands){
		Transform transformInstance = TransformFactory.eINSTANCE.createTransform();
		transformInstance.setElementTypeGraph(transform.getElementTypeGraph());
		try {
			/*
			 * Read Alloy Specification from a als file
			 */
			PrintWriter writer = new PrintWriter("temp.als");
			FileReader reader = new FileReader(alloyFile);
			char[] buffer = new char[1024];
			while(true){
				int read = reader.read(buffer, 0, 1024);
				if(read == -1) break;
				writer.write(read < 1024 ? Arrays.copyOfRange(buffer, 0, read) : buffer);
			}
			reader.close();
			/*
			 * Read Command from a command file
			 */
			for (int i = 0; i < commands.size(); i++) {
				String command = commands.get(i);
				writer.println("check{all trans: Trans|" + command + "}" + DEFAULT_SCOPE);
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
				Production rule = GenerateProductionFromAlloy.generateProductionFromAlloy(ans, transformInstance);
				System.out.println(ans.getOriginalCommand() + " Rule == " + (rule == null ? null : rule.getName()));
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
			e1.printStackTrace();
		}
		return transformInstance;
	}

	protected IFile getSelectedFile(ExecutionEvent event){
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection instanceof StructuredSelection){
			Object object = ((StructuredSelection)selection).getFirstElement();
			if(object instanceof IFile) return (IFile) object;
		}
		return null;
	}
}
