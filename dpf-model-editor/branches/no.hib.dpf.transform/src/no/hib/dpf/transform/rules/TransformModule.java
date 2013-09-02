package no.hib.dpf.transform.rules;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Specification;
import no.hib.dpf.core.impl.CorePackageImpl;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.transform.util.TransformConstants;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.AttributeCondition;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.TransformationUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.impl.HenshinFactoryImpl;
import org.eclipse.emf.henshin.model.impl.HenshinPackageImpl;
import org.eclipse.emf.henshin.model.impl.LoopUnitImpl;
import org.eclipse.emf.henshin.model.impl.NestedConditionImpl;
import org.eclipse.emf.henshin.model.impl.SequentialUnitImpl;
import org.eclipse.emf.henshin.model.impl.UnitImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.TraceFactory;
import org.eclipse.emf.henshin.trace.Trace;
import org.eclipse.emf.henshin.trace.TracePackage;
import org.eclipse.emf.henshin.trace.impl.TraceFactoryImpl;
import org.eclipse.emf.henshin.trace.impl.TracePackageImpl;


public class TransformModule {
	
	private Transform transform = null;
	private EPackage sourceMetaModel = null;
	private EPackage targetMetaModel = null;
	private HenshinResourceSet resourceSet = null;
	private HenshinFactory henshinFac = HenshinFactoryImpl.eINSTANCE;
	private EPackage core;
	private EPackage diagram;
	
	private TracePackage tracePackage = null;
	private TraceFactory traceFac = TraceFactoryImpl.eINSTANCE;
	private EClass traceClass = null;
	
	private CorePackage specificationPackage = null;
	
	private LoopUnit loopUnit = null;
	
	private HashMap<String,Node> traces = null;
	
	private String traceAdress1 = "org.eclipse.emf.henshin.trace.Trace";

	private Node graph = null;
	
	private static final String DEFAULT_ARROW = "Arrow";
	private static final String DEFAULT_NODE = "Node";
	private static final String ARROWTYPE = "ArrowType";	
	private static final String NODETYPE = "DNodeType";
	private static final String NODE = "Node";
	
	public TransformModule(Transform transform, HenshinResourceSet resourceSet){
		this.resourceSet = resourceSet;
		this.transform = transform;
		
		tracePackage = TracePackageImpl.init();
		specificationPackage = CorePackageImpl.init();

		traces = new HashMap<String,Node>();
		
//		URI sourceModelUri = URI.createURI(resourceSet.getBaseDir() +
//			transform.getSourceMetaModel().getSpecification().eResource().getURI().lastSegment().replace(".xmi", ".ecore"));
//		System.out.println(sourceModelUri);
//		Resource sourceModel = resourceSet.getResource(sourceModelUri, true);
//		sourceMetaModel = (EPackage) sourceModel.getContents().get(0);
//		resourceSet.getResources().add(sourceModel);
//		System.out.println("Her + " + sourceMetaModel.getEClassifiers());
//		
//		URI targetModelUri = URI.createURI(resourceSet.getBaseDir() +
//				transform.getSourceMetaModel().getSpecification().eResource().getURI().lastSegment().replace(".xmi", ".ecore"));
//		System.out.println(targetModelUri);
//		Resource targetModel = resourceSet.getResource(targetModelUri, true);
//		targetMetaModel = (EPackage) targetModel.getContents().get(0);
//		resourceSet.getResources().add(targetModel);
//		System.out.println("Her + " + targetMetaModel.getEClassifiers());
	}
	public Module createModule(){
		Module mainModule = henshinFac.createModule();
		
//		if(sourceMetaModel != null && sourceMetaModel instanceof EPackage){
//			mainModule.getImports().add(sourceMetaModel);
//		}
//		if(targetMetaModel != null && targetMetaModel instanceof EPackage && targetMetaModel!=sourceMetaModel){
//			mainModule.getImports().add(targetMetaModel);
//		}
		
//		mainModule.getUnits().add(generateInitialRuleSpecification(mainModule));
		
		Rule tempRule = null;
	
		mainModule.getImports().add(tracePackage);
		
		for(int i = 0;i<tracePackage.getEClassifiers().size();i++){
			System.out.println(i + " " + tracePackage.getEClassifiers().get(i).getName());
		}
		
		System.out.println("TRACEREN " + TraceFactoryImpl.eINSTANCE.getEPackage() + " " + TraceFactoryImpl.eINSTANCE.getTracePackage());
		
		for(int i = 0;i<transform.getRules().size();i++){
			loopUnit = new LoopUnitImpl();
			loopUnit.setName(transform.getRules().get(i).getName()+"_Loop");
			tempRule = generateRuleForCore(transform.getRules().get(i));
			mainModule.getUnits().add(tempRule);
			
			loopUnit.setSubUnit(tempRule);
			mainModule.getUnits().add(loopUnit);		
		}
		setSequentialUnit(mainModule);
		

		return mainModule;
	}
	public void setSequentialUnit(Module module){
		SequentialUnit seqUnit = new SequentialUnitImpl();
		seqUnit.setName("main");
		for(int i = 0;i<module.getUnits().size();i++){
			if(module.getUnits().get(i) instanceof LoopUnitImpl){
				seqUnit.getSubUnits().add(module.getUnits().get(i));
			}
			
		}
		module.getUnits().add(seqUnit);
		
	}

	public Rule generateInitialRuleSpecification(Module module){
		Rule rule = henshinFac.createRule("initialiseSpecificationAndGraph");
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		String path = "file:/C:/Users/Petter/workspace/no.hib.dpf.core/model/Metamodel.ecore";
		URI coreModelURI = URI.createURI(path);
		System.out.println(coreModelURI);
		Resource coreModel = resourceSet.getResource(coreModelURI, true);
		core = (EPackage) coreModel.getContents().get(0);
		
		module.getImports().add(core);
		
		String diagrampath = "file:/C:/Users/Petter/workspace/no.hib.dpf.diagram/model/DiagramMetamodel.ecore";
		URI diagramModelURI = URI.createURI(diagrampath);
		System.out.println(diagramModelURI);
		Resource diagramModel = resourceSet.getResource(diagramModelURI, true);
		diagram = (EPackage) diagramModel.getContents().get(0);

		module.getImports().add(diagram);
		
//		EClass specificationType = (EClass) core.getEClassifier("Specification");
		Node specification = henshinFac.createNode(lhs, specificationPackage.getSpecification(), null);
		specification.setAction(new Action(Type.PRESERVE));
		
//		EClass graphType = (EClass) core.getEClassifier("Graph");
		graph = henshinFac.createNode(lhs, specificationPackage.getGraph(), null);
		graph.setAction(new Action(Type.PRESERVE));
		
		EReference ref_spec_graph = specificationPackage.getSpecification_Graph();
//		for(int i = 0;i<specificationType.getEReferences().size();i++){
//			if(specificationType.getEReferences().get(i).getEReferenceType()==graphType){
//				ref_spec_graph = specificationType.getEReferences().get(i);
//			}
//		}
		
		Edge specification_to_edgerule = henshinFac.createEdge(specification, graph, ref_spec_graph);
		specification_to_edgerule.setAction(new Action(Type.PRESERVE));
		
		//module.getImports().add(traceFac.getEPackage());
		
		//TracePackage trace = traceFac.getTracePackage();
		
		Trace trace = traceFac.createTrace();
		System.out.println("Trace" + trace);
		
//		for(int i = 0;i<trace.getEClassifiers().size();i++){
//			System.out.println("ECLass " + trace.getEClassifiers().get(i).getName());
//		}
		
//		henshinFac.createNode(lhs, (EClass) traceFac.getEPackage().getEClassifier("Trace"), null);
		
		return rule;
	}
	public Rule generateInitialRuleDSpecification(Module module){
		Rule rule = henshinFac.createRule("initialiseDSpecificationAndDGraph");
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		String path = "file:/C:/Users/Petter/workspace/no.hib.dpf.core/model/Metamodel.ecore";
		URI coreModelURI = URI.createURI(path);
		System.out.println(coreModelURI);
		Resource coreModel = resourceSet.getResource(coreModelURI, true);
		core = (EPackage) coreModel.getContents().get(0);
		
		module.getImports().add(core);
		
		String diagrampath = "file:/C:/Users/Petter/workspace/no.hib.dpf.diagram/model/DiagramMetamodel.ecore";
		URI diagramModelURI = URI.createURI(diagrampath);
		System.out.println(diagramModelURI);
		Resource diagramModel = resourceSet.getResource(diagramModelURI, true);
		diagram = (EPackage) diagramModel.getContents().get(0);

		module.getImports().add(diagram);
		
		EClass dSpecificationType = (EClass) diagram.getEClassifier(TransformConstants.D_SPECIFICATION);
		Node specification_lhs = henshinFac.createNode(lhs, dSpecificationType, null);
		Node specification_rhs = henshinFac.createNode(rhs, dSpecificationType, null);
		
		rule.getMappings().add(henshinFac.createMapping(specification_lhs, specification_rhs));
		
		EClass dGraphType = (EClass) diagram.getEClassifier(TransformConstants.D_GRAPH);
		Node graph_lhs = henshinFac.createNode(lhs, dGraphType, null);
		Node graph_rhs = henshinFac.createNode(rhs, dGraphType, null);
		
		rule.getMappings().add(henshinFac.createMapping(graph_lhs, graph_rhs));
		
		EReference ref_spec_graph = null;
		for(int i = 0;i<dSpecificationType.getEReferences().size();i++){
			if(dSpecificationType.getEReferences().get(i).getEReferenceType()==dGraphType){
				ref_spec_graph = dSpecificationType.getEReferences().get(i);
			}
		}
		
		rule.createEdge(specification_lhs, graph_lhs, ref_spec_graph);
		rule.createEdge(specification_rhs, graph_rhs, ref_spec_graph);
		
		return rule;
	}
	
	private Rule generateRuleForCore(Production production) {
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		System.out.println("name "+production.getName() );
		Rule rule = henshinFac.createRule(production.getName());
		rule.setActivated(true);
		
		/*EClass graphType = (EClass) core.getEClassifier("Graph");
		Parameter parameter = henshinFac.createParameter("graph");
		parameter.setType(graphType);
		
		EReference reference_graph_to_nodes = null;
		EReference reference_graph_to_arrows = null;
		for(int j = 0; j<graphType.getEReferences().size();j++){
			if(graphType.getEReferences().get(j).getName().contains("nodes")){
				reference_graph_to_nodes = graphType.getEReferences().get(j);
			}
			if(graphType.getEReferences().get(j).getName().contains("arrows")){
				reference_graph_to_arrows = graphType.getEReferences().get(j);
			}
		}
		
		rule.getParameters().add(parameter);
		
		Node parent_graph_lhs = henshinFac.createNode(lhs, graphType, null);
		parent_graph_lhs.setName("graph");
		Node parent_graph_rhs = henshinFac.createNode(rhs, graphType, null);
		parent_graph_rhs.setName("graph");
		rule.getMappings().add(henshinFac.createMapping(parent_graph_lhs, parent_graph_rhs));
		
		
		*/
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();

		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
//			String dNodeType = production.getLeftNodes().get(i).getTypeName();
			String dNodeType = TransformUtils.trimNumber(production.getLeftNodes().get(i).getName());
//			EClass node = (EClass) core.getEClassifier("Node");
			EClass node = specificationPackage.getNode();
			EReference referenceNode_typeNode = specificationPackage.getNode_TypeNode();
//			EReference referenceNode_typeNode = null;
//			for(int j = 0; j<node.getEReferences().size();j++){
//				if(node.getEReferences().get(j).getName().contains("typeNode")){
//					referenceNode_typeNode = node.getEReferences().get(j);
//					System.out.println(referenceNode_typeNode);
//				}
//			}
//			EClass nodeType = (EClass) core.getEClassifier("Node");
			EClass nodeType = specificationPackage.getNode();
			EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
//			EAttribute nodeTypeAttribute = null;
//			for(int j = 0;j<nodeType.getEAttributes().size();j++){
//				if(nodeType.getEAttributes().get(j).getName().contains("name")){
//					nodeTypeAttribute = nodeType.getEAttributes().get(j);
//				}
//			}
			
			Node deletion = henshinFac.createNode(lhs, node, null);
			deletion.setName(production.getLeftNodes().get(i).getName());
			nodes.put(production.getLeftNodes().get(i).getName(), deletion);
			
			Node deletionType = henshinFac.createNode(lhs, nodeType, null);
			deletionType.setName(production.getLeftNodes().get(i).getName()+NODETYPE);
			nodes.put(production.getLeftNodes().get(i).getName()+NODETYPE, deletionType);
			Edge deleteTypeNodeRef = henshinFac.createEdge(deletion, deletionType, referenceNode_typeNode);
			Attribute henshin_attribute = henshinFac.createAttribute(deletionType, nodeTypeAttribute, "\""+dNodeType+"\"");
			
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			deletionType.setAction(new Action(Type.PRESERVE));
			deletion.setAction(new Action(Type.DELETE));
			deleteTypeNodeRef.setAction(new Action(Type.DELETE));
		}
		for(int i = 0;i<production.getLeftArrows().size();i++){
//			String dArrowType = production.getLeftArrows().get(i).getTypeName();
			String dArrowType = TransformUtils.trimNumber(production.getLeftArrows().get(i).getName());
//			EClass arrow = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EClass arrow = specificationPackage.getArrow();
//			EReference referenceArrow = null;
			EReference referenceArrow = specificationPackage.getArrow_TypeArrow();
//			for(int j = 0;j<arrow.getEReferences().size();j++){
//				if(arrow.getEReferences().get(j).getName().contains("typeArrow")){
//					referenceArrow = arrow.getEReferences().get(j);
//					System.out.println(referenceArrow);
//				}
//			}
//			EClass arrowType = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EClass arrowType = specificationPackage.getArrow();
			EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();
//			EAttribute arrowTypeAttribute = null;
//			for(int j = 0;j<arrowType.getEAttributes().size();j++){
//				if(arrowType.getEAttributes().get(j).getName().contains("name")){
//					arrowTypeAttribute = arrowType.getEAttributes().get(j);
//				}
//			}
			Node deletion = henshinFac.createNode(lhs, arrow, null);
			deletion.setName(production.getLeftArrows().get(i).getName());
			nodes.put(production.getLeftArrows().get(i).getName(), deletion);
			
			Node deletionType = henshinFac.createNode(lhs, arrowType, null);
			deletionType.setName(production.getLeftArrows().get(i).getName()+ARROWTYPE);
			nodes.put(production.getLeftArrows().get(i).getName()+ARROWTYPE, deletionType);
			
			Edge deleteTypeArrowRef = henshinFac.createEdge(deletion, deletionType, referenceArrow);
			Attribute henshin_attribute = henshinFac.createAttribute(deletionType, arrowTypeAttribute, "\""+dArrowType+"\"");
			
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			deletionType.setAction(new Action(Type.PRESERVE));
			deleteTypeArrowRef.setAction(new Action(Type.DELETE));
			deletion.setAction(new Action(Type.DELETE));
		}
		for(int i = 0; i<production.getCommonNodes().size();i++){
//			String dNodeType = production.getCommonNodes().get(i).getTypeName();
			String dNodeType = TransformUtils.trimNumber(production.getCommonNodes().get(i).getName());
			if(dNodeType.isEmpty()){
				System.out.println("EMPTY!!!!!");	
			}
//			EClass node = (EClass) core.getEClassifier(TransformConstants.NODE);
			EClass node = specificationPackage.getNode();
			System.out.println("node " + dNodeType + " " + production.getCommonNodes().get(i).getName());
			EReference referenceNode = specificationPackage.getNode_TypeNode();
//			EReference referenceNode = null;
//			for(int j = 0; j<node.getEReferences().size();j++){
//				if(node.getEReferences().get(j).getName().contains("typeNode")){
//					referenceNode = node.getEReferences().get(j);
//					System.out.println(referenceNode);
//				}
//			}
			EClass nodeType = specificationPackage.getNode();
//			EClass nodeType = (EClass) core.getEClassifier("Node");
			EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
//			EAttribute nodeTypeAttribute = null;
//			for(int j = 0;j<nodeType.getEAttributes().size();j++){
//				if(nodeType.getEAttributes().get(j).getName().contains("name")){
//					nodeTypeAttribute = nodeType.getEAttributes().get(j);
//				}
//			}
			Node preserveNode = henshinFac.createNode(lhs, node, null);
			preserveNode.setName(production.getCommonNodes().get(i).getName());
			nodes.put(production.getCommonNodes().get(i).getName(), preserveNode);
			preserveNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonNodes().get(i).getName()+NODETYPE, preserveNode);
			
			Node trace_preserveNode = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
			trace_preserveNode.setName(production.getCommonNodes().get(i).getName());
			Edge edge_trace_preserveSource = henshinFac.createEdge(trace_preserveNode, preserveNode, tracePackage.getTrace_Source());
			trace_preserveNode.setAction(new Action(Type.CREATE));
			edge_trace_preserveSource.setAction(new Action(Type.CREATE));
			System.out.println("Common Node ID " + production.getCommonNodes().get(i).getNode().getId());
			traces.put(production.getCommonNodes().get(i).getNode().getId(), trace_preserveNode);
			
			Node trace_forbid_duplicity = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
			trace_forbid_duplicity.setName(production.getCommonNodes().get(i).getName());
			Edge trace_forbid_duplicity_source = henshinFac.createEdge(trace_forbid_duplicity, preserveNode, tracePackage.getTrace_Source());
			trace_forbid_duplicity.setAction(new Action(Type.FORBID));
			trace_forbid_duplicity_source.setAction(new Action(Type.FORBID));
			
			Node preserveNodeType = henshinFac.createNode(lhs, nodeType, null);
			preserveNodeType.setName(production.getCommonNodes().get(i).getName()+NODETYPE);
			preserveNodeType.setAction(new Action(Type.PRESERVE));
			Edge preserveTypeNodeRef = henshinFac.createEdge(preserveNode, preserveNodeType, referenceNode);
			preserveTypeNodeRef.setAction(new Action(Type.PRESERVE));
			
			Attribute henshin_attribute = henshinFac.createAttribute(preserveNodeType, nodeTypeAttribute, "\""+dNodeType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			
		}
		//Determing common arrows
		for(int i = 0; i<production.getCommonArrows().size();i++){
//			String dArrowType = production.getCommonArrows().get(i).getTypeName();
			String dArrowType = TransformUtils.trimNumber(production.getCommonArrows().get(i).getName());
			
			EClass arrow = specificationPackage.getArrow();
			EReference referenceArrow = specificationPackage.getArrow_TypeArrow();
			EClass arrowType = (EClass) core.getEClassifier(TransformConstants.ARROW);
			EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();

			Node preserveArrowNode = henshinFac.createNode(lhs, arrow, null);
			preserveArrowNode.setName(production.getCommonArrows().get(i).getName());
			preserveArrowNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonArrows().get(i).getName(), preserveArrowNode);
			
			Node trace_preserveArrowNode = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
			preserveArrowNode.setName(production.getCommonArrows().get(i).getName());
			Edge edge_trace_preserveSource = henshinFac.createEdge(trace_preserveArrowNode, preserveArrowNode, tracePackage.getTrace_Source());
			trace_preserveArrowNode.setAction(new Action(Type.CREATE));
			edge_trace_preserveSource.setAction(new Action(Type.CREATE));
			
			Node trace_forbid_duplicity = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
			trace_forbid_duplicity.setName(production.getCommonArrows().get(i).getName());
			Edge trace_forbid_duplicity_source = henshinFac.createEdge(trace_forbid_duplicity, preserveArrowNode, tracePackage.getTrace_Source());
			trace_forbid_duplicity.setAction(new Action(Type.FORBID));
			trace_forbid_duplicity_source.setAction(new Action(Type.FORBID));
			
			Node preserveTypeArrowNode = henshinFac.createNode(lhs, arrowType, null);
			preserveTypeArrowNode.setName(production.getCommonArrows().get(i).getName()+ARROWTYPE);
			preserveTypeArrowNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonArrows().get(i).getName()+ARROWTYPE, preserveTypeArrowNode);
			
			Edge preserveTypeArrowRef = henshinFac.createEdge(preserveArrowNode, preserveTypeArrowNode, referenceArrow);
			preserveTypeArrowRef.setAction(new Action(Type.PRESERVE));
			
			Attribute henshin_attribute = henshinFac.createAttribute(preserveTypeArrowNode, arrowTypeAttribute, "\""+dArrowType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
		}
		for(int i = 0; i<production.getRightNodes().size();i++){
			System.out.println("Her " + TransformUtils.trimNumber(production.getRightNodes().get(i).getName()));
//			String dNodeType = production.getRightNodes().get(i).getTypeName();
			String dNodeType = TransformUtils.trimNumber(production.getRightNodes().get(i).getName());
			EClass node = specificationPackage.getNode();
			EClass nodeType = specificationPackage.getNode();
			
			EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
			
			EReference referenceNode = specificationPackage.getNode_TypeNode();

			Node insertionNode = henshinFac.createNode(rhs, node, null);
			insertionNode.setName(production.getRightNodes().get(i).getName());
			nodes.put(production.getRightNodes().get(i).getName(), insertionNode);
			
			setTargetTrace(rule, insertionNode, production.getRightNodes().get(i), production);
			
			Node insertionTypeNode = henshinFac.createNode(lhs, nodeType, null);
			insertionTypeNode.setName(production.getRightNodes().get(i).getName()+NODETYPE);
			nodes.put(production.getRightNodes().get(i).getName()+NODETYPE, insertionTypeNode);
			insertionTypeNode.setAction(new Action(Type.CREATE));

			
			Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeNode, nodeTypeAttribute, "\""+dNodeType+"\"");
			henshin_attribute.setAction(new Action(Type.CREATE));
			
			Edge insertionTypeNodeRef = henshinFac.createEdge(insertionNode, insertionTypeNode, referenceNode);
			insertionTypeNode.setAction(new Action(Type.CREATE));
			
//			henshinFac.createEdge(parent_graph_lhs, insertionNode, reference_graph_to_nodes);
			
			insertionNode.setAction(new Action(Type.CREATE));	
			insertionTypeNodeRef.setAction(new Action(Type.CREATE));
		}
		for(int i = 0;i<production.getRightArrows().size();i++){
			System.out.println("Her " + TransformUtils.trimNumber(production.getRightArrows().get(i).getName()));
//			String dArrowType = production.getRightArrows().get(i).getTypeName();
			String dArrowType = TransformUtils.trimNumber(production.getRightArrows().get(i).getName());
			EClass arrow = specificationPackage.getArrow();
			EClass arrowType = specificationPackage.getArrow();
			
			EReference referenceArrow = specificationPackage.getArrow_TypeArrow();

			EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();

			Node insertionArrow = henshinFac.createNode(rhs, arrow, null);
			insertionArrow.setName(production.getRightArrows().get(i).getName());
			nodes.put(production.getRightArrows().get(i).getName(), insertionArrow);
			insertionArrow.setAction(new Action(Type.CREATE));
			
			Node insertionTypeArrow = henshinFac.createNode(rhs, arrowType, null);
			insertionTypeArrow.setName(production.getRightArrows().get(i).getName()+ARROWTYPE);
			nodes.put(production.getRightArrows().get(i).getName()+ARROWTYPE, insertionTypeArrow);
			insertionTypeArrow.setAction(new Action(Type.CREATE));
	
			Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeArrow, arrowTypeAttribute, "\""+dArrowType+"\"");
			henshin_attribute.setAction(new Action(Type.CREATE));
			
			Edge insertionTypeArrowRef = henshinFac.createEdge(insertionArrow, insertionTypeArrow, referenceArrow);
			insertionTypeArrowRef.setAction(new Action(Type.CREATE));
			
//			henshinFac.createEdge(parent_graph_lhs, insertionArrow, reference_graph_to_arrows);
			
			insertionArrow.setAction(new Action(Type.CREATE));	
			insertionTypeArrowRef.setAction(new Action(Type.CREATE));
		}
		
		
		findEReferencesDArrowsLHS_RHS(production.getLeftArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(production.getRightArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(production.getCommonArrows(), nodes, true);
		
		rule.setInjectiveMatching(false);
		rule.setCheckDangling(false);
		return rule;
	}
	private void setTargetTrace(Rule rule, Node insertionNode, DNode dNode,
			Production production) {
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		DNode sourceNode = null;
		DNode targetNode = dNode;
		Node trace_object = null;
		
		System.out.println("Node : " + targetNode.getName() + "Production : " + production.getName());
		for(int i = 0;i<targetNode.getDIncomings().size();i++){
			System.out.println(targetNode.getName() + " " + targetNode.getDIncomings().get(i).getName());
			if(targetNode.getDIncomings().get(i).getName().startsWith("linkTarget_")){
				DArrow targetDArrow = targetNode.getDIncomings().get(i);
				System.out.println("Target!!!!" + targetDArrow.getName());
				DNode trace = targetDArrow.getDSource();
				System.out.println("Trace " + trace.getName());
				for(int j = 0; j<trace.getDOutgoings().size();j++){
					if(trace.getDOutgoings().get(j).getName().startsWith("linkource_")){
						sourceNode = trace.getDOutgoings().get(j).getDTarget();
						System.out.println("S " + sourceNode.getNode().getName());
						System.out.println("S " + sourceNode.getNode().getId());
						trace_object = traces.get(sourceNode.getNode().getId());
					}
				}	
			}
		}
		if(trace_object!=null){
			henshinFac.createEdge(trace_object, insertionNode, tracePackage.getTrace_Target());
			System.out.println(trace_object.getType() + " " + insertionNode.getName() + " " + tracePackage.getTrace_Target().getName());
		}

		
		
		System.out.println();
	}
	private void findEReferencesDArrowsLHS_RHS(EList<DArrow> dArrows, 
			HashMap<String, Node> nodes, boolean preserve){
		
		EReference source_node = specificationPackage.getArrow_Source();
		EReference target_node = specificationPackage.getArrow_Target();
		
		for(int i = 0;i<dArrows.size();i++){
			DNode dNode_source = dArrows.get(i).getDSource();
			DArrow dArrow_target = dArrows.get(i);
			Node source_DNode_Node = nodes.get(dNode_source.getName());
			System.out.println(source_DNode_Node.getName());
			Node target_DArrow_Node = nodes.get(dArrow_target.getName());
			System.out.println(target_DArrow_Node.getName());
		
			if(preserve){
				Edge edge = henshinFac.createEdge(target_DArrow_Node, source_DNode_Node, source_node);
				edge.setAction(new Action(Type.PRESERVE));
			}else{
				henshinFac.createEdge(target_DArrow_Node, source_DNode_Node, source_node);
			}
			
		}
		for(int i = 0;i<dArrows.size();i++){
			DArrow dArrow_source = dArrows.get(i);
			DNode dNode_target = dArrows.get(i).getDTarget();
			Node source_DArrow_Node = nodes.get(dArrow_source.getName());
			Node target_DNode_Node = nodes.get(dNode_target.getName());

			if(preserve){
				Edge edge = henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, target_node);
				edge.setAction(new Action(Type.PRESERVE));
			}else{
				Edge edge = henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, target_node);
			}
			
		}
	}
}
