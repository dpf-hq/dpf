package no.hib.dpf.verify;

import java.util.ArrayList;
import java.util.List;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class Temporary {

	public static void main(String[] args) throws Err {
		A4Options options = new A4Options();
		options.solver = A4Options.SatSolver.SAT4J;
		options.skolemDepth = 1;
		A4Reporter rep = new A4Reporter();
		Module world = CompUtil.parseEverything_fromFile(rep, null, "protocol_trans.als");
		for (Command command : world.getAllCommands()) {
			long start = System.nanoTime();    
			A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
			long elapsedTime = System.nanoTime() - start;
			System.out.println(elapsedTime/1000000);
		}

	}

}
