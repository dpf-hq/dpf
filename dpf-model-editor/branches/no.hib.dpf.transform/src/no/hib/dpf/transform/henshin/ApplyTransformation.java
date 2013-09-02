package no.hib.dpf.transform.henshin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DNodeDeleteCommand;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.execute.TranslateDPFModel;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.rules.TransformModule;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.ApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.InterpreterFactory;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.TraceFactory;

public class ApplyTransformation {
	
	public static final String PATH = "C:/Users/Petter/workspace/Henshin_Test/model/";
	public static final String HENSHIN = "generateHenshinRules.henshin";
	public static final String HENSHINNEW = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateHenshinRules.henshin";
	public static final String HENSHINUNITS = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateLoopHenshin.henshin";
	
	public static void exeucteTransformation(String path, boolean save){
		//TranslateToEcore.translateToEcore(TransformActivePage.activeTransformModel(), true);

		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformUtils.activeWorkingDirectory());
		Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
		
		String transformFile = TransformUtils.activeWindowFileLocation();
		Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(transformFile), resourceToDiagnosticMap); 
		
		String newPath = path.replace(".dpf", ".xmi");
		
		int buffer = 0;
		
		URI dSpecUri = URI.createFileURI(newPath);
		
//		DSpecification dSpec = DPFUtils.loadDSpecification(dSpecUri);
		//Transform the metamodels
		//Engine engine = new EngineImpl();
		
		Resource model = resourceSet.getResource(dSpecUri, true);
		Module module = resourceSet.getModule(TransformUtils.trimActiveTransformModel()+"toHenshin.henshin", true);
//		//DSpecification spec =  (DSpecification) model.getContents().get(0);
//		System.out.println("model " + spec.getGraph().getNodes());
//		System.out.println("module " + module.getRules());
//		URI dSpecUri = URI.createFileURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.dpf");
//		DSpecification dSpec = DPFUtils.loadDSpecification(dSpecUri);
		Specification spec = (Specification) model.getContents().get(0);
		Graph spec_graph = spec.getGraph();
		
		EGraph graph = new EGraphImpl(model);
		//graph.addTree(model.getContents().get(0));
		
		Engine engine = new EngineImpl();
		
		RuleApplication ruleApplication = new RuleApplicationImpl(engine);
		ruleApplication.setEGraph(graph);
		ApplicationMonitor monitor = InterpreterFactory.INSTANCE.createApplicationMonitor();
		
	
		
		Rule initialRule = module.getRules().get(0);
		Match initialMatch = new MatchImpl(initialRule);  
//		for (Match initial : engine.findMatches(initialRule, graph, initialMatch)) {
//			for(int j = 0;j<initial.getNodeTargets().size();j++){
//				if(initial.getNodeTargets().get(j) instanceof Specification){
//					specification = (Specification) initial.getNodeTargets().get(j);
//				}
//				if(initial.getNodeTargets().get(j) instanceof Graph){
//					core_graph = (Graph) initial.getNodeTargets().get(j);
//				}
//			}
//		}
		
		
		/*for(int i = 1;i<module.getRules().size();i++){
			
			Rule rule = module.getRules().get(i);
			Unit unit = module.getUnit("main");
			
			//ruleApplication.setRule(rule);
//			ruleApplication.setParameterValue("graph", spec_graph);
//			
			Match partialMatch = new MatchImpl(rule);  
			if(rule.getParameter("name") != null){
				partialMatch.setParameterValue(rule.getParameter("name"), "Send Money");
			}
				
			System.out.println("Matches for rule: " + rule.getName());
			HashMap<Rule, List<EObject>> matches = new HashMap<Rule, List<EObject>>();
			int tall = 0;
			for (Match match : engine.findMatches(rule, graph, partialMatch)) {
				List<EObject> list = new ArrayList<EObject>();
				
				for(int j = 0;j<match.getNodeTargets().size();j++){
					list.add(match.getNodeTargets().get(j));
//					matches.put(rule, match.getNodeTargets().get(j));
					//System.out.println(match.getNodeTargets().get(j));
				}		
				tall++;
				System.out.println("tall: " + tall + " " + match.getNodeTargets());
				
				ruleApplication.setUnit(unit);
				ruleApplication.setRule(rule);
//				ruleApplication.setParameterValue("graph", spec_graph);
			//	ruleApplication.setCompleteMatch(match);
				ruleApplication.setPartialMatch(match);
				ruleApplication.execute(monitor);
				
				for(int k = 0;k<ruleApplication.getEGraph().getRoots().size();k++){
					
					if(ruleApplication.getEGraph().getRoots().get(k) instanceof Node){
						Node node = (Node) ruleApplication.getEGraph().getRoots().get(k);
						System.out.println("Node " + node.getName() + " " + node.getTypeName());
					}else if(ruleApplication.getEGraph().getRoots().get(k) instanceof Specification){
						Specification testSpec = (Specification) ruleApplication.getEGraph().getRoots().get(k);
						for(int p = 0;p<testSpec.getGraph().getNodes().size();p++){
							System.out.println("Specification " + testSpec.getGraph().getNodes().get(p).getName() + " " + testSpec.getGraph().getNodes().get(p).getTypeName());
						}
					} else{
						System.out.println("HER " + ruleApplication.getEGraph().getRoots().get(k));
					}
					
				}
				
				LoggingApplicationMonitor log = new LoggingApplicationMonitor();
				log.notifyExecute(ruleApplication, true);

				
//				
//				TranslateDPFModel translate_DPF = new TranslateDPFModel(list, rule, 
//						newUri, spec, dSpec, true, resourceSet);
//				translate_DPF.executeChanges();
				
//				for (int j = 0;j<list.size();j++){
//					System.out.println(list.get(j));
//				}
//				
				
//				DSpecification spec = null;
//				spec.getDGraph().removeDNode(node);
//				DPFUtils.save
				System.out.println();
			}
			
			System.out.println(tall);
		}*/
		for(int k = 0; k<model.getContents().size();k++){
			Specification specTest = (Specification) model.getContents().get(k);
			for(int i = 0;i<specTest.getGraph().getNodes().size();i++){
				System.out.println(k+ ", " + i + " " + specTest.getGraph().getNodes().get(i).getName());
			}
		}
		
		
		try {
			model.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Specification targetSpec = DPFUtils.loadSpecification(URI.createFileURI("C:/Users/Petter/runtime-EclipseApplication/model/petriNetMetaModel.xmi"));
		
		Specification newSpec = CoreFactory.eINSTANCE.createDefaultSpecification();
		newSpec.setType(targetSpec);
		newSpec.setSignature(DPFConstants.DEFAULT_SIGNATURE);

		Unit unit = module.getUnit("main");
		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
		
		buffer = unitApp.getEGraph().getRoots().size();
		System.out.println("ANNTALL ELEMENTER : " + buffer);
		
		
		
		try{
			InterpreterUtil.executeOrDie(unitApp);
			ChangeImpl.PRINT_WARNINGS = false;
		} catch (AssertionError e){
			System.out.println("Error " + e);
		}
		buffer = unitApp.getEGraph().getRoots().size() - buffer;

		Graph newGraph = newSpec.getType().getGraph();
		
		for(int k = 0;k<ruleApplication.getEGraph().getRoots().size();k++){
			
			if(ruleApplication.getEGraph().getRoots().get(k) instanceof Node){
				Node node = (Node) ruleApplication.getEGraph().getRoots().get(k);
				System.out.println("Node " + node.getName() + " " + node.getTypeName());
			}else if(ruleApplication.getEGraph().getRoots().get(k) instanceof Specification){
				Specification testSpec = (Specification) ruleApplication.getEGraph().getRoots().get(k);
				for(int p = 0;p<testSpec.getGraph().getNodes().size();p++){
					System.out.println("Specification " + testSpec.getGraph().getNodes().get(p).getName() + " " + testSpec.getGraph().getNodes().get(p).getTypeName());
				}
			} else{
				System.out.println("HER " + ruleApplication.getEGraph().getRoots().get(k));
			}
			
		}
		
		for(int k = 0;k<newSpec.getType().getGraph().getNodes().size();k++){
			System.out.println("JAAAAAAAA " + newSpec.getType().getGraph().getNodes().get(k).getName());
		}		
		for(int k = buffer;k<unitApp.getEGraph().getRoots().size();k++){
			if(unitApp.getEGraph().getRoots().get(k) instanceof Node){
				
				Node node = (Node) unitApp.getEGraph().getRoots().get(k);
				
				node.setTypeNode(newGraph.getNodeByName(node.getTypeName()));
				newSpec.getGraph().addNode(node);
				System.out.println("Node " + node.getName() + " " + node.getTypeName());

	
//				Node type1 = spec.getType().getGraph().getNodeByName(node.getTypeName());
			}
			if(unitApp.getEGraph().getRoots().get(k) instanceof Arrow){
				Arrow arrow = (Arrow) unitApp.getEGraph().getRoots().get(k);
				arrow.setTypeArrow(newGraph.getArrowByName(arrow.getTypeName()));
				newSpec.getGraph().addArrow(arrow);
			}

//			if(unitApp.getEGraph().getRoots().get(k) instanceof Node){
//				Node node = (Node) unitApp.getEGraph().getRoots().get(k);
//				System.out.println("Node " + node.getName() + " " + node.getTypeName());
//			}else if(unitApp.getEGraph().getRoots().get(k) instanceof Specification){
//				Specification testSpec = (Specification) unitApp.getEGraph().getRoots().get(k);
//				for(int p = 0;p<testSpec.getGraph().getNodes().size();p++){
//					System.out.println("Specification " + testSpec.getGraph().getNodes().get(p).getName() + " " + testSpec.getGraph().getNodes().get(p).getTypeName());
//				}
//			} else{
//				System.out.println("HER " + unitApp.getEGraph().getRoots().get(k));
//			}
			
		}
		/*for(int k = 0;k<newGraph.getNodes().size();k++){
			System.out.println("Node " + k + " " + newGraph.getNodes().get(k).getTypeName());
		}*/
		
		System.out.println("Complete" + unitApp.getEGraph().getRoots().size());
		
		String uriNew = TransformUtils.activeWorkingDirectory() + "/spec.xmi";
		
	//	spec.setType(transform.getTargetMetaModel().getSpecification());
		
		DPFUtils.saveSpecification(URI.createFileURI(uriNew), newSpec);
		
	}
}