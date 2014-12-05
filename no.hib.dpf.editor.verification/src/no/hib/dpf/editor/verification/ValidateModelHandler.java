package no.hib.dpf.editor.verification;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.util.ConstraintsUtils;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Pair;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
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
					DSpecification dpf = (DSpecification) ((EObject)graphicalViewer.getContents().getModel()).eContainer();//.DPFUtils.loadDSpecification(resourceSet, dpfModelURI);
					ResourceSetImpl resourceSet = (ResourceSetImpl) dpf.eResource().getResourceSet();
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("uc", new XMIResourceFactoryImpl());
					TranslateDPFToAlloy translate = new TranslateDPFToAlloy(dpf);
					/*
					 * Write the translated Alloy Specification into the file *Name*.als
					 */
					IFolder folder = (IFolder) dpfFile.getParent();
					String dpfFileName = dpfFile.getName();
					String fileName = dpfFileName.substring(0, dpfFileName.lastIndexOf('.')), alloyFileName = fileName + ".als";
					IFile insFile = folder.getFile(fileName + ".uc");
					if(insFile.exists()){
						Constraints constraints = ConstraintsUtils.loadConstraints(resourceSet, dpfModelURI.trimFileExtension().appendFileExtension("uc"));
						if(constraints != null)
							translate.setUConstraints(constraints);
					}
					translate.translate();
					File alloyFile = new File(folder.getLocation().toOSString(), alloyFileName);
					translate.writeToFile(alloyFile);

					A4Reporter rep = new A4Reporter();
					Module world = CompUtil.parseEverything_fromFile(rep, null, alloyFile.getAbsolutePath());
					A4Options options = new A4Options();
					options.solver = A4Options.SatSolver.MiniSatProverJNI;
					options.skolemDepth = 1;
					options.coreGranularity = 3;
					options.coreMinimization = 0;

					Map<Pos, String> hash = new HashMap<Pos, String>();
					for(Pair<String, Expr> fact : world.getAllFacts()){
						if(!fact.a.startsWith("fact$"))
							hash.put(fact.b.pos, fact.a);
					}
					/*
					 * Execute the commands
					 */
					for (Command command : world.getAllCommands()) {
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						insFile = folder.getFile(fileName + "_instance.dpf");
						if(insFile.exists()){
							insFile.delete(true, new NullProgressMonitor());
						}
						if(!ans.satisfiable()) {
							List<String> ucs = new ArrayList<String>();
							Map<String, List<String>> ats = new HashMap<String, List<String>>();
							for( Pos pos : ans.highLevelCore().a){
								String result = getCore(pos, hash);
								if(result != null) {
									List<String> splits = Arrays.asList(result.split("_"));
									if(splits.size() == 1)
										ucs.add(result);
									else
										ats.put(splits.get(0), splits.subList(1, splits.size()));
								}
							}
							for( Pos pos : ans.highLevelCore().b){
								String result = getCore(pos, hash);
								if(result != null) {
									List<String> splits = Arrays.asList(result.split("_"));
									if(splits.size() == 1)
										ucs.add(result);
									else
										ats.put(splits.get(0), splits.subList(1, splits.size()));
								}
							}
							String ucstring = "";
							for(String iter : ucs){
								ucstring += iter + TranslateDPFToAlloy.LINE;
							}
							DGraph graph = dpf.getDGraph();
							List<DConstraint> atms = new ArrayList<DConstraint>();
							for(Entry<String, List<String>> iter : ats.entrySet()){
								List<DElement> ds = new ArrayList<DElement>();
								boolean isNode = true;
								for(String ele : iter.getValue()){
									if(ele.startsWith("N")){
										DNode node = null;
										for(DNode dn : graph.getDNodes())
											if(dn.getName().equals(ele.substring(1))) {node = dn; break;}
										ds.add(node);
										isNode = true;
									}else{
										DArrow edge = null;
										for(DArrow dn : graph.getDArrows())
											if(dn.getName().equals(ele.substring(1))) {edge = dn; break;}
										ds.add(edge);
										isNode = false;
									}
								}
								DElement one = ds.get(0);
								DConstraint theone = null;
								List<DConstraint> candidates = (isNode ? ((DNode)one).getDConstraints() : ((DArrow)one).getDConstraints());
								for(DConstraint con : candidates){
									if(con.getConstraint().getPredicate().getSymbol().equals(iter.getKey())){
										if(con.getDNodes().containsAll(ds) || con.getDArrows().containsAll(ds)){
											theone = con;
											atms.add(theone);
											break;
										}
									}
								}
							}
							for(DConstraint con: atms){
								Object key = con;
								if(con instanceof DComposedConstraint){
									key = ((DComposedConstraint)con).getFakeNode();
								}
								Object value = graphicalViewer.getEditPartRegistry().get(key);
								if(value instanceof GraphicalEditPart)
									((GraphicalEditPart)value).getFigure().setForegroundColor(ColorConstants.red);
							}
							if(!ucstring.isEmpty())
							MessageDialog.openError(graphicalViewer.getControl().getShell(), "Conflict Universal Constraints in " + dpfModelURI.trimFileExtension().appendFileExtension("uc"),
									ucstring);
							continue;
						}
						resourceSet = ConstraintsUtils.getResourceSet();
						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, DPFUtils.loadDSpecification(resourceSet, dpfModelURI));
						DPFUtils.saveDSpecification(resourceSet, instance, 
								URI.createFileURI(insFile.getLocation().toOSString()));
					}
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (Exception e) {
					DPFUtils.logError(e);
				}
			}
		}
		return null;
	}
//	private static void printPos(Pos cur){
//		System.out.println("line: " + cur.y + " column: " + cur.x);
//		System.out.println("line: " + cur.y2 + " column: " + cur.x2);
//	}
	private static boolean contained(Pos cur, Pos iter){
		return !(iter.y2 < cur.y2 || iter.y > cur.y 
				|| (iter.y == cur.y && iter.x > cur.x) || (iter.y2 == cur.y2 && iter.x2 < cur.x2));
	}
	private static String getCore(Pos cur, Map<Pos, String> hash) {
		for(Entry<Pos, String> rep : hash.entrySet()){
			if(contained(cur, rep.getKey())) return rep.getValue();
		}
		return null;
	}
}
