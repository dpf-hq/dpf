package no.hib.dpf.editor.verification;


import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;
import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4compiler.ast.Browsable;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class GetUnsatCoreHandler extends AbstractHandler {

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
					DSpecification dpf = DPFUtils.loadDSpecification(DPFUtils.getResourceSet(), dpfModelURI);
					TranslateDPFToAlloy translate = new TranslateDPFToAlloy(dpf);
					translate.translate();
					/*
					 * Write the translated Alloy Specification into the file *Name*.als
					 */
					IFolder folder = (IFolder) dpfFile.getParent();
					String dpfFileName = dpfFile.getName();
					String fileName = dpfFileName.substring(0, dpfFileName.lastIndexOf('.')), alloyFileName = fileName + ".als";
					File alloyFile = new File(folder.getLocation().toOSString(), alloyFileName);
					System.out.println(alloyFile.getAbsolutePath());
					if(!alloyFile.exists())
					translate.writeToFile(alloyFile);

					A4Reporter rep = new A4Reporter();
					CompModule world = CompUtil.parseEverything_fromFile(rep, null, "/home/wxlfrank/runtime-EclipseApplication/no.hib.dpf.examples/civi.als");
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

					System.out.println(System.getProperty("java.library.path"));
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

					/*
					 * Execute the commands
					 */
//					for (Command command : world.getAllCommands()) {
//						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
//						IFile insFile = folder.getFile(fileName + "_instance.dpf");
//						if(insFile.exists()){
//							insFile.delete(true, new NullProgressMonitor());
//						}
//						if(ans == null) continue;
//						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, dpf);
//						DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), 
//								instance, 
//								URI.createFileURI(insFile.getLocation().toOSString()), new HashMap<Resource, Diagnostic>());
//					}
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return null;
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
	private static boolean contained(Pos cur, Pos iter){
		return !(iter.y2 < cur.y2 || iter.y > cur.y 
				|| (iter.y == cur.y && iter.x > cur.x) || (iter.y2 == cur.y2 && iter.x2 < cur.x2));
	}
	public static void main(String[] arg) throws Err{
		A4Reporter rep = new A4Reporter();
		Module world = CompUtil.parseEverything_fromFile(rep, null, "civi.als");
		A4Options options = new A4Options();
		options.solver = A4Options.SatSolver.SAT4J;
		options.skolemDepth = 1;
		options.coreGranularity = 3;

		/*
		 * Execute the commands
		 */
		for (Command command : world.getAllCommands()) {
			A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
			System.out.println(ans.highLevelCore());
		}
	}
}
