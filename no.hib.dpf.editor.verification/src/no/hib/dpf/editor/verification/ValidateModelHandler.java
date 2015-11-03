package no.hib.dpf.editor.verification;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
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
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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

	protected static String ALLOY = ".als";
	protected static String INSTANCE = "_instance.dpf";
	protected static String KEYWORD = "fact$";
	protected String[] preds = null;
	protected DPF2Alloy translate;
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
						A4Solution ans = TranslateAlloyToKodkod.execute_commandFromBook(rep, world.getAllReachableSigs(), command, options);
						IFile instanceFile = createDPFInstanceFile(folder, dpfFileName, index);
						if(!ans.satisfiable()) {
							List<String> ucs = new ArrayList<String>();
							Map<String, List<String>> ats = new HashMap<String, List<String>>();
							getCoreConstraints(ans.highLevelCore().a, hash, ucs, ats);
							getCoreConstraints(ans.highLevelCore().b, hash, ucs, ats);

							//show the atomic constraints which cause contradiction by red coloring those constraints 
							List<DConstraint> atms = getCoreAtomicConstraints(dpf.getDGraph(), ats);
							for(DConstraint con: atms){
								Object key = con;
								if(con instanceof DComposedConstraint){
									key = ((DComposedConstraint)con).getFakeNode();
								}
								Object value = graphicalViewer.getEditPartRegistry().get(key);
								if(value instanceof GraphicalEditPart)
									((GraphicalEditPart)value).getFigure().setForegroundColor(ColorConstants.red);
							}
							//Show the names of the universal constraints which cause contradiction in a message dialog
							for(String iter : ucs)
								dialogMessage += iter + DPF2Alloy.LINE;
							continue;
						}
						DSpecification instance = GenerateInstanceFromAlloy.generateDSpecificationFromAlloy(ans, translate.model, translate.sig2DPF);
						DPFUtils.saveDSpecification((ResourceSetImpl) translate.model.eResource().getResourceSet(), instance, URI.createFileURI(instanceFile.getLocation().toOSString()));
					}
					if(!dialogMessage.isEmpty()){
						MessageDialog dialog = new MessageDialog(graphicalViewer.getControl().getShell(), 
								"Conflict Universal Constraints in " + dpfFileName + ".uc", null, dialogMessage,
								MessageDialog.ERROR, 
								new String[] { IDialogConstants.OK_LABEL }, 0){
							protected void setShellStyle(int newShellStyle) {
								if(getShellStyle() != SWT.SHELL_TRIM){
									setShellStyle(SWT.SHELL_TRIM);
								}
							};

							protected Control createMessageArea(Composite composite) {
								Control result = super.createMessageArea(composite);
								FontData[] data = messageLabel.getFont().getFontData();
								for (int i = 0; i < data.length; i++) {
									data[i].setHeight((int)(data[i].getHeight() * 2));
								}
								messageLabel.setFont(new Font(messageLabel.getDisplay(), data));
								return result;
							}
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

	protected String getFileNameWithoutExtension(String fileNameWithExtension){
		int index = fileNameWithExtension.indexOf('.');
		return index == -1 ? fileNameWithExtension : fileNameWithExtension.substring(0, index);
	}
	/*
	 * Write the translated Alloy Specification into the file *Name*.als
	 */
	protected File translateDPF2Alloy(DSpecification dpf, IContainer folder, String dpfFileName) throws IOException{
		ResourceSetImpl resourceSet = (ResourceSetImpl) dpf.eResource().getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("uc", new XMIResourceFactoryImpl());
		translate = getDPFToAlloy(dpf);
		IFile insFile = folder.getFile(new Path(dpfFileName + ".uc"));
		if(insFile.exists()){
			Constraints constraints = ConstraintsUtils.loadConstraints(resourceSet, URI.createFileURI(insFile.getLocation().toOSString()));
			if(constraints != null)
				translate.setUConstraints(constraints);
		}
		translate.translate();
		File alloyFile = new File(folder.getLocation().toOSString(), dpfFileName + ALLOY );
		translate.writeToFile(alloyFile);
		return alloyFile;
	}
	protected DPF2Alloy getDPFToAlloy(DSpecification dpf) {
		return new DPF2Alloy(dpf);
	}

	protected Map<Pos, String> getKeyExpressionPoistions(Module world){
		Map<Pos, String> hash = new HashMap<Pos, String>();
		for(Pair<String, Expr> fact : world.getAllFacts()){
			if(!fact.a.startsWith(KEYWORD))
				hash.put(fact.b.pos, fact.a);
		}
		return hash;
	}
	/**
	 * Get the constraints which cause the contradiction
	 * @param cores the positions of the expressions in Alloy which cause contradiction
	 * @param hash the position of key expression, e.g., facts  
	 * @param ucs the names of the universal constraints causing contradiction
	 * @param ats the names of the atomic constraints causing contradiction and the names of elements that are restricted by the constraints
	 */
	protected void getCoreConstraints(Set<Pos> cores, Map<Pos, String> hash, List<String> ucs, Map<String, List<String>> ats){
		for(Pos pos : cores){
			String result = getCore(pos, hash);
			if(result != null) {
				List<String> splits = Arrays.asList(result.split("_"));
				if(splits.size() == 1)
					ucs.add(result);
				else
					ats.put(splits.get(0), splits.subList(1, splits.size()));
			}
		}
	}

	protected DConstraint getAtomicConstraint(String pred, List<String> elements, DGraph graph){
		List<DElement> ds = new ArrayList<DElement>();
		boolean isNode = true;
		for(String ele : elements){
			if(ele.startsWith("N")){
				DNode node = null;
				if(ele.matches("N\\d*")){
					Node cur = (Node) translate.sig2DPF.get(Integer.parseInt(ele.substring(1)));
					for(DNode dn : graph.getDNodes())
						if(dn.getNode() == cur) {node = dn; break;}
				}else{
					for(DNode dn : graph.getDNodes())
						if(dn.getName().equals(ele.substring(1))) {node = dn; break;}
				}
				if(node != null){
					ds.add(node);
					isNode = true;
				}
			}else{
				DArrow edge = null;
				if(ele.matches("E\\d*")){
					Arrow cur = (Arrow) translate.sig2DPF.get(Integer.parseInt(ele.substring(1)));
					for(DArrow dn : graph.getDArrows())
						if(dn.getArrow() == cur) {edge = dn; break;}
				}else{
					for(DArrow dn : graph.getDArrows())
						if(dn.getName().equals(ele.substring(1))) {edge = dn; break;}
				}
				if(edge != null){
					ds.add(edge);
					isNode = false;
				}
			}
		}
		if(ds.isEmpty()) return null;;
		DElement one = ds.get(0);
		List<DConstraint> candidates = (isNode ? ((DNode)one).getDConstraints() : ((DArrow)one).getDConstraints());
		for(DConstraint con : candidates){
			if(con.getConstraint().getPredicate().getSymbol().equals(pred)){
				if(con.getDNodes().containsAll(ds) || con.getDArrows().containsAll(ds)){
					return con;
				}
			}
		}
		return null;
	}

	protected List<DConstraint> getCoreAtomicConstraints(DGraph graph, Map<String, List<String>> ats){
		List<DConstraint> atms = new ArrayList<DConstraint>();
		for(Entry<String, List<String>> iter : ats.entrySet()){
			DConstraint atom = getAtomicConstraint(iter.getKey(), iter.getValue(), graph);
			if(atom != null)
				atms.add(atom);
		}
		return atms;
	}

	protected A4Options getAlloyOption(){
		A4Options options = new A4Options();
		options.solver = A4Options.SatSolver.MiniSatProverJNI;
		options.skolemDepth = 1;
		options.coreGranularity = 3;
		options.coreMinimization = 0;
		return options;
	}

	protected IFile createDPFInstanceFile(IContainer folder, String fileName, int index) throws CoreException{
		IFile insFile = folder.getFile(new Path(fileName + INSTANCE));
		if(insFile.exists()){
			insFile.delete(true, new NullProgressMonitor());
		}
		return insFile;
	}
	private boolean contained(Pos cur, Pos iter){
		return !(iter.y2 < cur.y2 || iter.y > cur.y 
				|| (iter.y == cur.y && iter.x > cur.x) || (iter.y2 == cur.y2 && iter.x2 < cur.x2));
	}
	protected String getCore(Pos cur, Map<Pos, String> hash) {
		for(Entry<Pos, String> rep : hash.entrySet()){
			if(contained(cur, rep.getKey())) return rep.getValue();
		}
		return null;
	}
}
