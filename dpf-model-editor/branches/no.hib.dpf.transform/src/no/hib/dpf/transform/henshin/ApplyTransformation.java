package no.hib.dpf.transform.henshin;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DNodeDeleteCommand;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.rules.TransformModule;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class ApplyTransformation {
	
	public static final String PATH = "C:/Users/Petter/workspace/Henshin_Test/model/";
	public static final String HENSHIN = "generateHenshinRules.henshin";
	public static final String HENSHINNEW = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateHenshinRules.henshin";
	public static final String HENSHINUNITS = "C:/Users/Petter/workspace/no.hib.dpf.transform/model/generateLoopHenshin.henshin";
	
	public static void exeucteTransformation(String path, boolean save){
		//TranslateToEcore.translateToEcore(TransformActivePage.activeTransformModel(), true);

		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformActivePage.activeWorkingDirectory());
		Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
		URI newUri = URI.createFileURI(path);
		//Transform the metamodels
		//Engine engine = new EngineImpl();
		
		Resource model = resourceSet.getResource(newUri, true);
		Module module = resourceSet.getModule(TransformActivePage.trimActiveTransformModel()+"toHenshin.henshin", true);
//		Specification spec = (Specification) model.getContents().get(0);
//		//DSpecification spec =  (DSpecification) model.getContents().get(0);
//		System.out.println("model " + spec.getGraph().getNodes());
//		System.out.println("module " + module.getRules());
//		
		EGraph graph = new EGraphImpl();
		graph.addTree(model.getContents().get(0));
		System.out.println(graph);
		
		Engine engine = new EngineImpl();
		Specification specification = null;
		Graph DPF_Graph = null;
		Node node = null;
		for(int i = 0;i<module.getRules().size();i++){
			
			Rule rule = module.getRules().get(i);
//			Rule rule = module.getRule("deleteMessage");
			Match partialMatch = new MatchImpl(rule);  
			System.out.println("Matches for rule: " + rule.getName());
			
			for (Match match : engine.findMatches(rule, graph, partialMatch)) {
				
				for(int j = 0;j<match.getNodeTargets().size();j++){
					System.out.println(match.getNodeTargets().get(j));
				}
//				DSpecification spec = null;
//				spec.getDGraph().removeDNode(node);
//				DPFUtils.save
				System.out.println();
			}
			System.out.println();
		}
//		DSpecification dspecccs = DPFUtils.loadDSpecification(URI.createFileURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.dpf"));
//		Specification specccs = DPFUtils.loadSpecification(URI.createFileURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.xmi"));

//		Node nodePetter = specccs.getGraph().createNode("Petter");
//		
//		DNode dNode = null;
//		
//		for(int i = 0;i<dspecccs.getDGraph().getDNodes().size();i++){
//			if(dspecccs.getDGraph().getDNodes().get(i).getNode().equals(node)){
//				dNode = dspecccs.getDGraph().getDNodes().get(i);
//			}
//		}
//		
//		dspecccs.getDGraph().removeDNode(dNode);
//		new DNodeDeleteCommand(dNode);
//		
//		DPFUtils.saveSpecification(URI.createFileURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.xmi"), specccs);
//		DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), dspecccs, URI.createFileURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.dpf"), new LinkedHashMap<Resource, Diagnostic>());
//		Unit unit = module.getUnit(module.getRules().get(0).getName());
//		
//		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
//		
//		try{
//			InterpreterUtil.executeOrDie(unitApp);
//			ChangeImpl.PRINT_WARNINGS = false;
//		} catch (AssertionError e){
//			System.out.println("Errer " + e);
//		}
		
//		Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(TransformActivePage.activeWindowFileLocation()), resourceToDiagnosticMap);
//		TransformModule translateHenshinRules = new TransformModule(transform, resourceSet);
//				
//		Module result = (Module) translateHenshinRules.createModule();
//				
//		if(save){
//			String henshinModelName = TransformActivePage.trimActiveTransformModel()+"toHenshin.henshin";
//			File file = new File(TransformActivePage.activeWorkingDirectory()+"/"+henshinModelName);
//			if(file.exists()){
//				file.delete();
//			}
//			//resourceSet.createResource(null, TransformActivePage.trimActiveTransformModel()+"toHenshin.henshin");
//			resourceSet.saveEObject(result, henshinModelName);
//		}
//		System.out.println("Module" + result.getRules());
	}
}