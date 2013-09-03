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
		String transformFile = TransformUtils.activeWindowFileLocation(); 
		
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformUtils.activeWorkingDirectory());
		Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
		Transform transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(transformFile), resourceToDiagnosticMap);

		String newPath = path.replace(".dpf", ".xmi");
		
		int buffer = 0;
		
		URI dSpecUri = URI.createFileURI(newPath);
		
		Resource model = resourceSet.getResource(dSpecUri, true);
		Module module = resourceSet.getModule(TransformUtils.trimActiveTransformModel()+"toHenshin.henshin", true);
		Specification spec = (Specification) model.getContents().get(0);
		
		EGraph graph = new EGraphImpl(model);
		Engine engine = new EngineImpl();
		
		RuleApplication ruleApplication = new RuleApplicationImpl(engine);
		ruleApplication.setEGraph(graph);
		
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
		System.out.println("ANNTALL ELEMENTER ETTER TRANS : " + buffer);
		
		System.out.println("nybuffer " + buffer);

		Graph newGraph = newSpec.getType().getGraph();
		
		System.out.println("Her da? : " + unitApp.getResultAssignment());
		
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
			//if(unitApp.getEGraph().getRoots().get(k) instanceof Node && ((Node) unitApp.getEGraph().getRoots().get(k)).getName() != null){
			if(unitApp.getEGraph().getRoots().get(k) instanceof Node){
				Node node = (Node) unitApp.getEGraph().getRoots().get(k);
				
				node.setTypeNode(newGraph.getNodeByName(node.getTypeName()));
				newSpec.getGraph().addNode(node);
				System.out.println("Buffer : " + k + " Node " + node.getName() + " " + node.getTypeName());

			}
			if(unitApp.getEGraph().getRoots().get(k) instanceof Arrow){
				Arrow arrow = (Arrow) unitApp.getEGraph().getRoots().get(k);
				arrow.setTypeArrow(newGraph.getArrowByName(arrow.getTypeName()));
				newSpec.getGraph().addArrow(arrow);
				
				System.out.println("Buffer : " + k + " Arrow " + arrow.getName() + " " + arrow.getTypeName());
			}
		}
		
		System.out.println("Complete" + unitApp.getEGraph().getRoots().size());
		
		String uriNew = TransformUtils.activeWorkingDirectory() + "/spec.xmi";
		
		
		DPFUtils.saveSpecification(URI.createFileURI(uriNew), newSpec);
		
	}
}