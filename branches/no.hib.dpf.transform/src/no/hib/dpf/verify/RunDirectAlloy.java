package no.hib.dpf.verify;

import no.hib.dpf.editor.DPFUtils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

/**
 * The handler executes verification when users select a als file. In this way,  users can edit the file manually.
 *
 */
public class RunDirectAlloy extends RunAlloy {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IFile alsFile = getSelectedFile(event);
		if(alsFile != null){
			try {
				/*
				 * Parse the Alloy Specification and the commands
				 */
				A4Options options = new A4Options();
				options.solver = A4Options.SatSolver.SAT4J;
				options.skolemDepth = 1;
				A4Reporter rep = new A4Reporter();
				Module world = CompUtil.parseEverything_fromFile(rep, null, alsFile.getLocation().toOSString());

				/*
				 * Execute the commands
				 */
				for (Command command : world.getAllCommands()) {
					long start = System.nanoTime();    
					TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
					long elapsedTime = System.nanoTime() - start;
					System.out.println(elapsedTime/1000000);
				}
			} catch ( Err e) {
				DPFUtils.logError(e);
			} 
		}
		return null;
	}
}
