package no.hib.dpf.editor.verification;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.uconstraint.util.ConstraintsUtils;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;



public class RedundantCheckHandler extends ValidateModelHandler {

	protected static String ALLOY = "2.als";
	protected static String KEYWORD = "pred$";
	protected DPF2Alloy getDPFToAlloy(DSpecification dpf) {
		return new DPF2Alloy(dpf){
			public void write(FileWriter writer) throws IOException{
				writer.write(LINE + "//preds" + LINE);
				for(Entry<String, String> iter : name2cons_alloy.entrySet()){
					writer.write("pred " + iter.getKey() + "[]{" + LINE);
					writer.write("\t" + iter.getValue());
					writer.write("}" + LINE + LINE);
				}
				preds = name2cons_alloy.keySet().toArray(new String[name2cons_alloy.size()]);
				for (int i = 0; i < preds.length; i++) {
					writer.write("run{not " + preds[i] + "[]");
					for (int j = 0; j < preds.length; j++) {
						if(i == j) continue;
						writer.write(" and " + preds[j] + "[]");
					}
					writer.write("} for 5"+ LINE);
				}
			}
		};
	}
	protected IFile createDPFInstanceFile(IFolder folder, String fileName, int index) throws CoreException{
		IFile insFile = folder.getFile(fileName + "_" + preds[index] + ".dpf");
		if(insFile.exists()){
			insFile.delete(true, new NullProgressMonitor());
		}
		return insFile;
	}
	protected static String PRED_PREFIX = "this/";
	protected Map<Pos, String> getKeyExpressionPoistions(Module world){
		Map<Pos, String> hash = new HashMap<Pos, String>();
		for(Func pred : world.getAllFunc()){
			if(pred.isPred){
				String name = pred.label;
				if(name.startsWith(PRED_PREFIX + "run")) continue;
				int index = pred.label.indexOf(PRED_PREFIX);
				if(index != -1) name = name.substring(index + PRED_PREFIX.length());
				hash.put(pred.pos, name);
			}
		}
		return hash;
	}

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
					DSpecification dpf = (DSpecification) ((EObject)graphicalViewer.getContents().getModel()).eContainer();

					IFolder folder = (IFolder) dpfFile.getParent();
					String dpfFileName = getFileNameWithoutExtension(dpfFile.getName());

					File alloyFile = translateDPF2Alloy(dpf, folder, dpfFileName);
					A4Reporter rep = new A4Reporter();
					Module world = CompUtil.parseEverything_fromFile(rep, null, alloyFile.getAbsolutePath());
					A4Options options = getAlloyOption();

					Map<Pos, String> hash = getKeyExpressionPoistions(world);
					String dialogMessage = "";
					/*
					 * Execute the commands
					 */
					for(int index = 0; index < world.getAllCommands().size(); index++){
						Command command = world.getAllCommands().get(index);
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						IFile instanceFile = createDPFInstanceFile(folder, dpfFileName, index);
						if(!ans.satisfiable()) {
							List<String> ucs = new ArrayList<String>();
							Map<String, List<String>> ats = new HashMap<String, List<String>>();
							getCoreConstraints(ans.highLevelCore().a, hash, ucs, ats, preds[index]);
							getCoreConstraints(ans.highLevelCore().b, hash, ucs, ats, preds[index]);

							//show the atomic constraints which cause contradiction by red coloring those constraints 
							List<DConstraint> atms = getCoreAtomicConstraints(dpf.getDGraph(), ats);
							String atoms = "";
							for(DConstraint con: atms){
								atoms += DPF2Alloy.LINE;
								atoms += "\t[" + con.getDPredicate().getPredicate().getSymbol() + "] on "; 
								if(!con.getDNodes().isEmpty()) 
									atoms += "Nodes:";
								for(DNode dNode : con.getDNodes()){
									atoms += dNode.getName() + " ";
								}
								if(!con.getDNodes().isEmpty()) atoms += " ";
								if(!con.getDArrows().isEmpty()) 
									atoms += " Arrows:";
								for(DArrow dNode : con.getDArrows()){
									atoms += dNode.getName() + " ";
								}
							}
							//Show the names of the universal constraints which cause contradiction in a message dialog
							List<String> splits = Arrays.asList(preds[index].split("_"));
							if(splits.size() > 1){
								DConstraint cur = getAtomicConstraint(splits.get(0), splits.subList(1, splits.size()), dpf.getDGraph());
								if(cur != null){
									dialogMessage += "[" + cur.getDPredicate().getPredicate().getSymbol() + "] on "; 
									if(!cur.getDNodes().isEmpty()) 
										dialogMessage += "Nodes:";
									for(DNode dNode : cur.getDNodes()){
										dialogMessage += dNode.getName() + " ";
									}
									if(!cur.getDNodes().isEmpty()) dialogMessage += " ";
									if(!cur.getDArrows().isEmpty()) 
										dialogMessage += "Arrows:";
									for(DArrow dNode : cur.getDArrows()){
										dialogMessage += dNode.getName() + " ";
									}
								}
							}else
								dialogMessage += preds[index];
							dialogMessage += " can be derived by"+ atoms;
							if(atoms.isEmpty()) dialogMessage +=  DPF2Alloy.LINE + "\t";
							for(String iter : ucs)
								dialogMessage += iter + "\t";

							dialogMessage +=  DPF2Alloy.LINE;
							continue;
						}
						ResourceSetImpl resourceSet = ConstraintsUtils.getResourceSet();
						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, DPFUtils.loadDSpecification(resourceSet, dpfModelURI));
						DPFUtils.saveDSpecification(resourceSet, instance, URI.createFileURI(instanceFile.getLocation().toOSString()));
					}
					if(!dialogMessage.isEmpty()){
						MessageDialog dialog = new MessageDialog(graphicalViewer.getControl().getShell(), 
								"Redundant Constraints Report", null, dialogMessage,
								MessageDialog.ERROR, 
								new String[] { IDialogConstants.OK_LABEL }, 0){
							protected void setShellStyle(int newShellStyle) {
								if(getShellStyle() != SWT.SHELL_TRIM){
									setShellStyle(SWT.SHELL_TRIM);
								}
							};
						};
						dialog.open();
					}
					folder.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				} catch (Exception e) {
					DPFUtils.logError(e);
				}
			}
		}
		return null;
	}
	protected void getCoreConstraints(Set<Pos> cores, Map<Pos, String> hash, List<String> ucs, Map<String, List<String>> ats, String cur){
		for(Pos pos : cores){
			String result = getCore(pos, hash);
			if(result != null) {
				if(result.equals(cur)) continue;
				List<String> splits = Arrays.asList(result.split("_"));
				if(splits.size() == 1 && !ucs.contains(result))
					ucs.add(result);
				else
					ats.put(splits.get(0), splits.subList(1, splits.size()));
			}
		}
	}
}
