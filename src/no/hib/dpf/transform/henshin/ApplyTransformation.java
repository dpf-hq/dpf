package no.hib.dpf.transform.henshin;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.ChangeImpl;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.interpreter.util.InterpreterUtil;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class ApplyTransformation {
	
	public static void exeucteTransformation(String path, boolean save, String fileName){
		String transformFile = TransformUtils.activeWindowFileLocation(); 
		
		HenshinResourceSet resourceSet = new HenshinResourceSet(TransformUtils.activeWorkingDirectory());
		Transform transform = TransformUtils.loadTransform(TransformUtils.getResourceSet(), URI.createFileURI(transformFile));
		
		String newPath = path.replace(".dpf", ".xmi");
		
		int buffer = 0;
		
		URI dSpecUri = URI.createFileURI(newPath);
		
		Resource model = resourceSet.getResource(dSpecUri, true);
		Module module = resourceSet.getModule(TransformUtils.trimActiveTransformModel()+"toHenshin.henshin", true);
		
		EGraph graph = new EGraphImpl(model);
		Engine engine = new EngineImpl();
		
		RuleApplication ruleApplication = new RuleApplicationImpl(engine);
		ruleApplication.setEGraph(graph);
		
		DSpecification dType = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(transform.getTargetLocation()));
		
		DSpecification dSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		dSpecification.setDSignature(DiagramFactory.eINSTANCE.createDefaultDSignature());
		dSpecification.setDType(dType);
		
		
		Specification targetSpec = DPFUtils.loadSpecification(URI.createFileURI(transform.getTargetLocation().replace(".dpf", ".xmi")));
		
		Specification newSpec = CoreFactory.eINSTANCE.createDefaultSpecification();
		newSpec.setGraph(CoreFactory.eINSTANCE.createDefaultGraph());
		newSpec.setType(targetSpec);
		newSpec.setSignature(DPFConstants.DEFAULT_SIGNATURE);
		
		dSpecification.setSpecification(newSpec);

		Unit unit = module.getUnit("main");
		UnitApplication unitApp = new UnitApplicationImpl(engine, graph, unit, null);
		
		buffer = unitApp.getEGraph().getRoots().size();
		
		try{
			InterpreterUtil.executeOrDie(unitApp);
			ChangeImpl.PRINT_WARNINGS = false;
		} catch (AssertionError e){
			DPFUtils.logError("Error when executing transformation rules", e);
		}

		Graph newGraph = newSpec.getType().getGraph();
		
		for(int k = buffer-2;k<unitApp.getEGraph().getRoots().size();k++){
			if(unitApp.getEGraph().getRoots().get(k) instanceof Node){
				Node node = (Node) unitApp.getEGraph().getRoots().get(k);
				node.setTypeNode(newGraph.getNodeByName(node.getTypeName()));
				newSpec.getGraph().addNode(node);

			}
			if(unitApp.getEGraph().getRoots().get(k) instanceof Arrow){
				Arrow arrow = (Arrow) unitApp.getEGraph().getRoots().get(k);
				arrow.setTypeArrow(newGraph.getArrowByName(arrow.getTypeName()));
				newSpec.getGraph().addArrow(arrow);
			}
		}
		
		System.out.println("Transformation Complete" + unitApp.getEGraph().getRoots().size());
		
		URI targetLocation = URI.createFileURI(transform.getTargetLocation());
		String uriNew = transform.getTargetLocation().replace(targetLocation.lastSegment(), fileName+".xmi");
		DPFUtils.saveSpecification(URI.createFileURI(uriNew), newSpec);
	}
}