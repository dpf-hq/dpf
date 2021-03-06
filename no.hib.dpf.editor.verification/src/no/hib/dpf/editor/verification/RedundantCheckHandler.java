package no.hib.dpf.editor.verification;

import java.io.BufferedWriter;
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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;



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
					writer.write("} for 3"+ LINE);
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
					DSpecification dpf = (DSpecification) ((EObject)graphicalViewer.getContents().getModel()).eContainer();

					IContainer folder = dpfFile.getParent();
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
						System.out.println("" + index + ":" + command);
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						if(!ans.satisfiable()) {
							List<String> ucs = new ArrayList<String>();
							List<String> ats = new ArrayList<String>();
							getCoreConstraints(ans.highLevelCore().a, hash, ucs, ats, preds[index]);
							getCoreConstraints(ans.highLevelCore().b, hash, ucs, ats, preds[index]);

							//show the atomic constraints which cause contradiction by red coloring those constraints 
							List<DConstraint> atms = getCoreAtomicConstraints(dpf.getDGraph(), ats);
							String atoms = "";
							for(DConstraint con: atms){
								atoms += DPF2Alloy.LINE;
								atoms += "\t" + con.getConstraint();
							}
							//Show the names of the universal constraints which cause contradiction in a message dialog
							List<String> splits = Arrays.asList(preds[index].split("_"));
							if(splits.size() > 1){
								DConstraint cur = getAtomicConstraint(splits.get(0), splits.subList(1, splits.size()), dpf.getDGraph());
								if(cur != null){
									dialogMessage += cur.getConstraint();
								}else{
									dialogMessage += "[" + splits.get(0) + "] on "; 
									String ele = splits.get(1);
									Arrow arrow = (Arrow) translate.sig2DPF.get(ele);
									dialogMessage += arrow.getName() + ":"  + arrow.getSource().getName() + "->" + arrow.getTarget().getName();
								}
							}else
								dialogMessage += preds[index];
							dialogMessage += " can be derived by"+ atoms;
							if(atoms.isEmpty()) dialogMessage +=  DPF2Alloy.LINE + "\t";
							for(String iter : ucs)
								dialogMessage += iter + "\t";

							dialogMessage +=  DPF2Alloy.LINE;
							if(dialogMessage.startsWith("[xor] on Arrows{bloodtype is unknown or screening is not done or invalid(screen is valid within 4 days)"))
								break;
							dialogMessage = "";
							continue;
						}
//						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, translate.model, translate.sig2DPF);
//						DPFUtils.saveDSpecification((ResourceSetImpl) translate.model.eResource().getResourceSet(), instance, URI.createFileURI(instanceFile.getLocation().toOSString()));
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
							protected Control createMessageArea(Composite parent) {
								Control result = super.createMessageArea(parent);
								if(messageLabel != null)
									messageLabel.setFont(new Font(messageLabel.getDisplay(), "Arial", 12, SWT.BOLD));
								return result;
							}
							protected int getMessageLabelStyle(){
								return super.getMessageLabelStyle() | SWT.V_SCROLL;
							}
						};
						String report = folder.getLocation().toString() + "/report.txt";
						BufferedWriter writer = new BufferedWriter(new FileWriter(new File(report)));
						writer.write(dialogMessage);
						writer.close();
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
	protected void getCoreConstraints(Set<Pos> cores, Map<Pos, String> hash, List<String> ucs, List<String> ats, String cur){
		for(Pos pos : cores){
			String result = getCore(pos, hash);
			if(result != null) {
				if(result.equals(cur)) continue;
				int index = result.indexOf('_');
				if(index < 0)
					ucs.add(result);
				else
					ats.add(result);
			}
		}
	}
}
