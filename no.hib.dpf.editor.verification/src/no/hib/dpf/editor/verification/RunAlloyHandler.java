package no.hib.dpf.editor.verification;

import no.hib.dpf.editor.DPFUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
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

public class RunAlloyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if(editor == null || !(editor.getEditorInput() instanceof IFileEditorInput)) return null; 
		IFile dpfFile = ((IFileEditorInput)editor.getEditorInput()).getFile();
			if(dpfFile != null){
				try {
					if(!dpfFile.getName().endsWith(".als")) return null;

					A4Reporter rep = new A4Reporter();
					Module world = CompUtil.parseEverything_fromFile(rep, null, dpfFile.getLocation().toOSString());
					A4Options options = new A4Options();
					options.solver = A4Options.SatSolver.SAT4J;
					options.skolemDepth = 1;

					/*
					 * Execute the commands
					 */
					for (Command command : world.getAllCommands()) {
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						if(ans != null) System.out.println(command.getHTML());
					}
				} catch (Exception e) {
					DPFUtils.logError(e);
				}
			}
		return null;
	}
}
