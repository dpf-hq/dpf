package no.hib.dpf.editor.verification;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4compiler.ast.Browsable;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Type;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;


public class TestAlloy {

	public static void printPosOfExpr(Browsable expr, int n) throws Err{
		if(expr instanceof Expr){
			Type type = ((Expr)expr).type();
			if(!(type.is_bool || type.arity() < 1)) {
				return;
			}
		}
		char[] chars = new char[n];
		Arrays.fill(chars, ' ');
		String result = new String(chars);
		System.out.println(result + expr.pos());
		System.out.println(expr.getHTML());
		for(Browsable iter : expr.getSubnodes()){
			printPosOfExpr( (Browsable) iter, n + 1);
		}
	}
	public static void main(String[] args) throws Err {
		A4Reporter rep = new A4Reporter();
		CompModule world = CompUtil.parseEverything_fromFile(rep, null, "civi.als");
		A4Options options = new A4Options();
		options.solver = A4Options.SatSolver.MiniSatProverJNI;
		options.skolemDepth = 1;
		options.coreGranularity = 3;
		

		/*
		 * Execute the commands
		 */
		Map<Pos, String> hash = new HashMap<Pos, String>();
		for(Func iter : world.getAllFunc())
			if(iter.isPred){
				Expr body = iter.getBody();
				hash.put(new Pos(iter.pos.filename, iter.pos.x, iter.pos.y, body.pos.x2, body.pos.y2),
						iter.label.replaceFirst("this/", ""));
			}

		Set<String> cores = new HashSet<String>();
		for (Command command : world.getAllCommands()) {
			A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
			Set<Pos> iter = ans.highLevelCore().a;
			for(Pos cur : iter){
				String loc = getCore(cur, hash);
				if(loc != null)
					cores.add(loc);
			}
			Pos com = command.pos;
			printPos(com);
			Expr commexpr = null;
			for(Browsable sub : command.getSubnodes())
				if(sub instanceof Expr){
					for(Browsable inner : sub.getSubnodes())
						if(inner instanceof Expr){
							commexpr = findExpr(com, (Expr) inner);
							if(commexpr != null) break;
						}
					if(commexpr != null) break;
				}
			if(commexpr != null)
				System.out.println(commexpr);
		}
		for(String iter : cores)
			System.out.println(iter);

	}
	private static void printPos(Pos cur){
		System.out.println("line: " + cur.y + " column: " + cur.x);
		System.out.println("line: " + cur.y2 + " column: " + cur.x2);
	}
	private static Expr findExpr(Pos pos, Expr expr){
		if(contained(expr.pos(), pos)) return expr;
		if(contained(pos, expr.pos()))
			for(Browsable iter : expr.getSubnodes())
				if(iter instanceof Expr)
					return findExpr(pos, (Expr) iter);
		return null;
	}
	private static String getCore(Pos cur, Map<Pos, String> hash) {
		for(Entry<Pos, String> rep : hash.entrySet()){
			if(contained(cur, rep.getKey())) return rep.getValue();
		}
		return null;
	}
	/*
	 * cur contained by iter
	 */
	private static boolean contained(Pos cur, Pos iter){
		return !(iter.y2 < cur.y2 || iter.y > cur.y 
				|| (iter.y == cur.y && iter.x > cur.x) || (iter.y2 == cur.y2 && iter.x2 < cur.x2));
	}

}
