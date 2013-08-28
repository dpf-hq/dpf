package no.hib.dpf.transform.rules;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformActivePage;
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
import org.eclipse.emf.henshin.model.impl.NestedConditionImpl;
import org.eclipse.emf.henshin.model.impl.SequentialUnitImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.henshin.trace.TraceFactory;
import org.eclipse.emf.henshin.trace.Trace;


public class TransformModule {
	
	private Transform transform = null;
	private EPackage sourceMetaModel = null;
	private EPackage targetMetaModel = null;
	private HenshinResourceSet resourceSet = null;
	private HenshinFactory henshinFac = HenshinFactoryImpl.eINSTANCE;
	private TraceFactory traceFac = TraceFactory.eINSTANCE;
	private EPackage core;
	private EPackage diagram;
	
	private Node graph = null;
	

	private static final String DEFAULT_ARROW = "Arrow";
	private static final String DEFAULT_NODE = "Node";
	private static final String ARROWTYPE = "ArrowType";	
	private static final String NODETYPE = "DNodeType";
	private static final String NODE = "Node";
	
	public TransformModule(Transform transform, HenshinResourceSet resourceSet){
		this.resourceSet = resourceSet;
		this.transform = transform;
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
		
		mainModule.getUnits().add(generateInitialRuleSpecification(mainModule));
		
		for(int i = 0;i<transform.getRules().size();i++){
			//mainModule.getUnits().add(generateRuleForDiagram(transform.getRules().get(i)));
			mainModule.getUnits().add(generateRuleForCore(transform.getRules().get(i)));
		}
		setSequentialUnit(mainModule);
		return mainModule;
	}
	public void setSequentialUnit(Module module){
		SequentialUnit seqUnit = new SequentialUnitImpl();
		seqUnit.setName("main");
		for(int i = 0;i<module.getUnits().size();i++){
			seqUnit.getSubUnits().add(module.getUnits().get(i));
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
		
		EClass specificationType = (EClass) core.getEClassifier("Specification");
		Node specification = henshinFac.createNode(lhs, specificationType, null);
		specification.setAction(new Action(Type.PRESERVE));
		
		EClass graphType = (EClass) core.getEClassifier("Graph");
		graph = henshinFac.createNode(lhs, graphType, null);
		graph.setAction(new Action(Type.PRESERVE));
		
		EReference ref_spec_graph = null;
		for(int i = 0;i<specificationType.getEReferences().size();i++){
			if(specificationType.getEReferences().get(i).getEReferenceType()==graphType){
				ref_spec_graph = specificationType.getEReferences().get(i);
			}
		}
		
		Edge specification_to_edgerule = henshinFac.createEdge(specification, graph, ref_spec_graph);
		specification_to_edgerule.setAction(new Action(Type.PRESERVE));
		
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
			String dNodeType = production.getLeftNodes().get(i).getTypeName();
			EClass node = (EClass) core.getEClassifier("Node");
			EReference referenceNode = null;
			for(int j = 0; j<node.getEReferences().size();j++){
				if(node.getEReferences().get(j).getName().contains("typeNode")){
					referenceNode = node.getEReferences().get(j);
					System.out.println(referenceNode);
				}
			}
			EClass nodeType = (EClass) core.getEClassifier("Node");
			EAttribute nodeTypeAttribute = null;
			for(int j = 0;j<nodeType.getEAttributes().size();j++){
				if(nodeType.getEAttributes().get(j).getName().contains("name")){
					nodeTypeAttribute = nodeType.getEAttributes().get(j);
				}
			}
			Trace trace = traceFac.createTrace();
			
			Node deletion = henshinFac.createNode(lhs, node, null);
			trace.getSource().add(deletion);
			deletion.setName(production.getLeftNodes().get(i).getName());
			nodes.put(production.getLeftNodes().get(i).getName(), deletion);
			
			Node deletionType = henshinFac.createNode(lhs, nodeType, null);
			trace.getTarget().add(deletionType);
			deletionType.setName(production.getLeftNodes().get(i).getName()+NODETYPE);
			nodes.put(production.getLeftNodes().get(i).getName()+NODETYPE, deletionType);
			Edge deleteTypeNodeRef = henshinFac.createEdge(deletion, deletionType, referenceNode);
			Attribute henshin_attribute = henshinFac.createAttribute(deletionType, nodeTypeAttribute, "\""+dNodeType+"\"");
			
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			deletionType.setAction(new Action(Type.PRESERVE));
			deletion.setAction(new Action(Type.DELETE));
			deleteTypeNodeRef.setAction(new Action(Type.DELETE));
		}
		for(int i = 0;i<production.getLeftArrows().size();i++){
			String dArrowType = production.getLeftArrows().get(i).getTypeName();
			EClass arrow = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EReference referenceArrow = null;
			for(int j = 0;j<arrow.getEReferences().size();j++){
				if(arrow.getEReferences().get(j).getName().contains("typeArrow")){
					referenceArrow = arrow.getEReferences().get(j);
					System.out.println(referenceArrow);
				}
			}
			EClass arrowType = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EAttribute arrowTypeAttribute = null;
			for(int j = 0;j<arrowType.getEAttributes().size();j++){
				if(arrowType.getEAttributes().get(j).getName().contains("name")){
					arrowTypeAttribute = arrowType.getEAttributes().get(j);
				}
			}
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
			String dNodeType = production.getCommonNodes().get(i).getTypeName();
			EClass node = (EClass) core.getEClassifier(TransformConstants.NODE);
			EReference referenceNode = null;
			for(int j = 0; j<node.getEReferences().size();j++){
				if(node.getEReferences().get(j).getName().contains("typeNode")){
					referenceNode = node.getEReferences().get(j);
					System.out.println(referenceNode);
				}
			}
			EClass nodeType = (EClass) core.getEClassifier("Node");
			EAttribute nodeTypeAttribute = null;
			for(int j = 0;j<nodeType.getEAttributes().size();j++){
				if(nodeType.getEAttributes().get(j).getName().contains("name")){
					nodeTypeAttribute = nodeType.getEAttributes().get(j);
				}
			}
			Node preserveNode = henshinFac.createNode(lhs, node, null);
			preserveNode.setName(production.getCommonNodes().get(i).getName());
			nodes.put(production.getCommonNodes().get(i).getName(), preserveNode);
			preserveNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonNodes().get(i).getName()+NODETYPE, preserveNode);
			
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
			String dArrowType = production.getCommonArrows().get(i).getTypeName();
			EClass arrow = (EClass) core.getEClassifier(TransformConstants.ARROW);
			
			EReference referenceArrow = null;
			for(int j = 0;j<arrow.getEReferences().size();j++){
				if(arrow.getEReferences().get(j).getName().contains("typeArrow")){
					referenceArrow = arrow.getEReferences().get(j);
					System.out.println(referenceArrow);
				}
			}
			
			EClass arrowType = (EClass) core.getEClassifier(TransformConstants.ARROW);
			EAttribute arrowTypeAttribute = null;
			for(int j = 0;j<arrowType.getEAttributes().size();j++){
				if(arrowType.getEAttributes().get(j).getName().contains("name")){
					arrowTypeAttribute = arrowType.getEAttributes().get(j);
				}
			}
			Node preserveArrowNode = henshinFac.createNode(lhs, arrow, null);
			preserveArrowNode.setName(production.getCommonArrows().get(i).getName());
			preserveArrowNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonArrows().get(i).getName(), preserveArrowNode);
			
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
			System.out.println("Her " + production.getRightNodes().get(i).getTypeName());
			String dNodeType = production.getRightNodes().get(i).getTypeName();
			EClass node = (EClass) core.getEClassifier("Node");
			EReference referenceNode = null;
			for(int j = 0; j<node.getEReferences().size();j++){
				if(node.getEReferences().get(j).getName().contains("typeNode")){
					referenceNode = node.getEReferences().get(j);
					System.out.println(referenceNode);
				}
			}
			EClass nodeType = (EClass) core.getEClassifier("Node");
			EAttribute nodeTypeAttribute = null;
			for(int j = 0;j<nodeType.getEAttributes().size();j++){
				if(nodeType.getEAttributes().get(j).getName().contains("name")){
					nodeTypeAttribute = nodeType.getEAttributes().get(j);
				}
			}
			Node insertionNode = henshinFac.createNode(rhs, node, null);
			insertionNode.setName(production.getRightNodes().get(i).getName());
			nodes.put(production.getRightNodes().get(i).getName(), insertionNode);
			insertionNode.setAction(new Action(Type.PRESERVE));
			
			Node insertionTypeNode = henshinFac.createNode(lhs, nodeType, null);
			insertionTypeNode.setName(production.getRightNodes().get(i).getName()+NODETYPE);
			nodes.put(production.getRightNodes().get(i).getName()+NODETYPE, insertionTypeNode);
			insertionTypeNode.setAction(new Action(Type.PRESERVE));

			
			Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeNode, nodeTypeAttribute, "\""+dNodeType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			
			Edge insertionTypeNodeRef = henshinFac.createEdge(insertionNode, insertionTypeNode, referenceNode);
			insertionTypeNode.setAction(new Action(Type.PRESERVE));
			
//			henshinFac.createEdge(parent_graph_lhs, insertionNode, reference_graph_to_nodes);
			
			insertionNode.setAction(new Action(Type.CREATE));	
			insertionTypeNodeRef.setAction(new Action(Type.CREATE));
		}
		for(int i = 0;i<production.getRightArrows().size();i++){
			System.out.println("Her " + production.getRightArrows().get(i).getTypeName());
			String dArrowType = production.getRightArrows().get(i).getTypeName();
			EClass arrow = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EReference referenceArrow = null;
			for(int j = 0;j<arrow.getEReferences().size();j++){
				if(arrow.getEReferences().get(j).getName().contains("typeArrow")){
					referenceArrow = arrow.getEReferences().get(j);
					System.out.println(referenceArrow);
				}
			}
			EClass arrowType = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EAttribute arrowTypeAttribute = null;
			for(int j = 0;j<arrowType.getEAttributes().size();j++){
				if(arrowType.getEAttributes().get(j).getName().contains("name")){
					arrowTypeAttribute = arrowType.getEAttributes().get(j);
				}
			}
			
			Node insertionArrow = henshinFac.createNode(rhs, arrow, null);
			insertionArrow.setName(production.getRightArrows().get(i).getName());
			nodes.put(production.getRightArrows().get(i).getName(), insertionArrow);
			insertionArrow.setAction(new Action(Type.PRESERVE));
			
			Node insertionTypeArrow = henshinFac.createNode(lhs, arrowType, null);
			insertionTypeArrow.setName(production.getRightArrows().get(i).getName()+ARROWTYPE);
			nodes.put(production.getRightArrows().get(i).getName()+ARROWTYPE, insertionTypeArrow);
			insertionTypeArrow.setAction(new Action(Type.PRESERVE));
	
			Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeArrow, arrowTypeAttribute, "\""+dArrowType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			
			Edge insertionTypeArrowRef = henshinFac.createEdge(insertionArrow, insertionTypeArrow, referenceArrow);
			insertionTypeArrowRef.setAction(new Action(Type.PRESERVE));
			
//			henshinFac.createEdge(parent_graph_lhs, insertionArrow, reference_graph_to_arrows);
			
			insertionArrow.setAction(new Action(Type.CREATE));	
			insertionTypeArrowRef.setAction(new Action(Type.CREATE));
		}
		
		
		findEReferencesDArrowsLHS_RHS(production.getLeftArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(production.getRightArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(production.getCommonArrows(), nodes, true);
		
		
		
//		for(int i = 0; i<production.getRightNodes().size();i++){
//			String dNodeType = production.getRightNodes().get(i).getTypeName();
//			EClass node = (EClass) core.getEClassifier("Node");
//			EReference typeNode = null;
//			for(int j = 0; j<node.getEReferences().size();j++){
//				if(node.getEReferences().get(j).getName().contains("typeNode")){
//					typeNode = node.getEReferences().get(j);
//					System.out.println(typeNode);
//				}
//			}
//			EClass nodeType = (EClass) core.getEClassifier("Node");
//			EAttribute attribute = null;
//			for(int j = 0;j<nodeType.getEAttributes().size();j++){
//				if(nodeType.getEAttributes().get(j).getName().contains("name")){
//					attribute = nodeType.getEAttributes().get(j);
//				}
//			}
//			
//			Node insertion = henshinFac.createNode(rhs, node, null);
//			insertion.setAction(new Action(Type.CREATE));
//			Node insertionType = henshinFac.createNode(rhs, nodeType, null);
//			insertionType.setAction(new Action(Type.CREATE));
//			Edge edge = henshinFac.createEdge(insertion, insertionType, typeNode);
//			edge.setAction(new Action(Type.CREATE));
//			
//			Attribute henshin_attribute = henshinFac.createAttribute(insertionType, attribute, "\""+dNodeType+"\"");
//			insertionType.setName(production.getRightNodes().get(i).getNode().getName());
//			
//			henshin_attribute.setAction(new Action(Type.REQUIRE));
//		}
		rule.setInjectiveMatching(false);
		rule.setCheckDangling(false);
		return rule;
	}
	private Rule generateRuleForDiagram(Production production) {
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		System.out.println("name "+production.getName());
		Rule rule = henshinFac.createRule(production.getName());
		rule.setActivated(true);
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
			String type = production.getLeftNodes().get(i).getTypeName();
			EClass dNode = (EClass) diagram.getEClassifier(TransformConstants.D_NODE);
			EReference reference_to_DNode = null;
			for(int j = 0; j<dNode.getEReferences().size();j++){
				if(dNode.getEReferences().get(j).getName().contains(TransformConstants.D_TYPE)){
					reference_to_DNode = dNode.getEReferences().get(j);
					System.out.println(reference_to_DNode);
				}
			}
			EClass dNodeType = (EClass) diagram.getEClassifier(TransformConstants.D_NODE);
			EReference reference_to_Node = null;
			for(int j = 0; j<dNodeType.getEReferences().size();j++){
				if(dNodeType.getEReferences().get(j).getName().contains(TransformConstants.DNODE_TYPE_NODE)){
					reference_to_Node = dNodeType.getEReferences().get(j);
					System.out.println(reference_to_Node);
				}
			}
			
			EClass nodeType = (EClass) core.getEClassifier(TransformConstants.NODE);
			EAttribute nodeTypeAttribute = null;
			for(int j = 0;j<nodeType.getEAttributes().size();j++){
				if(nodeType.getEAttributes().get(j).getName().contains("name")){
					nodeTypeAttribute = nodeType.getEAttributes().get(j);
				}
			}
			Node deletion_DNode = henshinFac.createNode(lhs, dNode, null);
			deletion_DNode.setName(production.getLeftNodes().get(i).getName());
			nodes.put(production.getLeftNodes().get(i).getName(), deletion_DNode);
			
			Node deletion_DNode_Type = henshinFac.createNode(lhs, dNodeType, null);
			deletion_DNode_Type.setName(production.getLeftNodes().get(i).getName()+NODETYPE);
			nodes.put(production.getLeftNodes().get(i).getName()+NODETYPE, deletion_DNode_Type);
			henshinFac.createEdge(deletion_DNode, deletion_DNode_Type, reference_to_DNode);
			
			Node deletion_DNode_NodeType = henshinFac.createNode(lhs, nodeType, null);
			nodes.put(production.getLeftNodes().get(i).getName()+NODE, deletion_DNode_NodeType);
			henshinFac.createEdge(deletion_DNode_Type, deletion_DNode_NodeType, reference_to_Node);
			
			Attribute henshin_attribute = henshinFac.createAttribute(deletion_DNode_NodeType, nodeTypeAttribute, "\""+type+"\"");
			
			henshin_attribute.setAction(new Action(Type.REQUIRE));
		}
		/*for(int i = 0;i<production.getLeftArrows().size();i++){
			String dArrowType = production.getLeftArrows().get(i).getTypeName();
			EClass arrow = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EReference referenceArrow = null;
			for(int j = 0;j<arrow.getEReferences().size();j++){
				if(arrow.getEReferences().get(j).getName().contains("typeArrow")){
					referenceArrow = arrow.getEReferences().get(j);
					System.out.println(referenceArrow);
				}
			}
			EClass arrowType = (EClass) core.getEClassifier(DEFAULT_ARROW);
			EAttribute arrowTypeAttribute = null;
			for(int j = 0;j<arrowType.getEAttributes().size();j++){
				if(arrowType.getEAttributes().get(j).getName().contains("name")){
					arrowTypeAttribute = arrowType.getEAttributes().get(j);
				}
			}
			Node deletion = henshinFac.createNode(lhs, arrow, null);
			deletion.setName(production.getLeftArrows().get(i).getName());
			nodes.put(production.getLeftArrows().get(i).getName(), deletion);
			Node deletionType = henshinFac.createNode(lhs, arrowType, null);
			deletionType.setName(production.getLeftArrows().get(i).getName()+ARROWTYPE);
			nodes.put(production.getLeftArrows().get(i).getName()+ARROWTYPE, deletionType);
			
			henshinFac.createEdge(deletion, deletionType, referenceArrow);
			Attribute henshin_attribute = henshinFac.createAttribute(deletionType, arrowTypeAttribute, "\""+dArrowType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
		}
		for(int i = 0; i<production.getCommonNodes().size();i++){
			String dNodeType = production.getCommonNodes().get(i).getTypeName();
			EClass node = (EClass) core.getEClassifier(DEFAULT_NODE);
			EReference referenceNode = null;
			for(int j = 0; j<node.getEReferences().size();j++){
				if(node.getEReferences().get(j).getName().contains("typeNode")){
					referenceNode = node.getEReferences().get(j);
					System.out.println(referenceNode);
				}
			}
			EClass nodeType = (EClass) core.getEClassifier("Node");
			EAttribute nodeTypeAttribute = null;
			for(int j = 0;j<nodeType.getEAttributes().size();j++){
				if(nodeType.getEAttributes().get(j).getName().contains("name")){
					nodeTypeAttribute = nodeType.getEAttributes().get(j);
				}
			}
			Node preserveNode = henshinFac.createNode(lhs, node, null);
			preserveNode.setName(production.getCommonNodes().get(i).getName());
			nodes.put(production.getCommonNodes().get(i).getName(), preserveNode);
			preserveNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonNodes().get(i).getName()+NODETYPE, preserveNode);
			Node preserveNodeType = henshinFac.createNode(lhs, nodeType, null);
			preserveNodeType.setName(production.getCommonNodes().get(i).getName()+NODETYPE);
			preserveNodeType.setAction(new Action(Type.PRESERVE));
			Edge edge = henshinFac.createEdge(preserveNode, preserveNodeType, referenceNode);
			edge.setAction(new Action(Type.PRESERVE));
			
			Attribute henshin_attribute = henshinFac.createAttribute(preserveNodeType, nodeTypeAttribute, "\""+dNodeType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			
		}
		//Determing common arrows
		for(int i = 0; i<production.getCommonArrows().size();i++){
			String dArrowType = production.getCommonArrows().get(i).getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			Node preserve_lhs = henshinFac.createNode(lhs, arrowType, null);
			Node preserve_rhs = henshinFac.createNode(rhs, arrowType, null);
			
			preserve_lhs.setName(production.getCommonArrows().get(i).getName());
			preserve_rhs.setName(production.getCommonArrows().get(i).getName());
			
			Mapping m2 = henshinFac.createMapping(preserve_lhs, preserve_rhs);
			rule.getMappings().add(m2);

			nodes.put(production.getCommonArrows().get(i).getName()+"_LHS", preserve_lhs);
			nodes.put(production.getCommonArrows().get(i).getName()+"_RHS", preserve_rhs);
		}
		
//		for(int i = 0; i<production.getRightNodes().size();i++){
//			String dNodeType = production.getRightNodes().get(i).getTypeName();
//			EClass node = (EClass) core.getEClassifier("Node");
//			EReference typeNode = null;
//			for(int j = 0; j<node.getEReferences().size();j++){
//				if(node.getEReferences().get(j).getName().contains("typeNode")){
//					typeNode = node.getEReferences().get(j);
//					System.out.println(typeNode);
//				}
//			}
//			EClass nodeType = (EClass) core.getEClassifier("Node");
//			EAttribute attribute = null;
//			for(int j = 0;j<nodeType.getEAttributes().size();j++){
//				if(nodeType.getEAttributes().get(j).getName().contains("name")){
//					attribute = nodeType.getEAttributes().get(j);
//				}
//			}
//			
//			Node insertion = henshinFac.createNode(rhs, node, null);
//			insertion.setAction(new Action(Type.CREATE));
//			Node insertionType = henshinFac.createNode(rhs, nodeType, null);
//			insertionType.setAction(new Action(Type.CREATE));
//			Edge edge = henshinFac.createEdge(insertion, insertionType, typeNode);
//			edge.setAction(new Action(Type.CREATE));
//			
//			Attribute henshin_attribute = henshinFac.createAttribute(insertionType, attribute, "\""+dNodeType+"\"");
//			insertionType.setName(production.getRightNodes().get(i).getNode().getName());
//			
//			henshin_attribute.setAction(new Action(Type.REQUIRE));
//		}*/
		rule.setCheckDangling(false);
		return rule;
	}
	private void findEReferencesDArrowsLHS_RHS(EList<DArrow> dArrows, 
			HashMap<String, Node> nodes, boolean preserve){
		
		EReference ref_DArrow_DNode = null;
		
		for(int i = 0;i<dArrows.size();i++){
			DNode dNode_source = dArrows.get(i).getDSource();
			DArrow dArrow_target = dArrows.get(i);
			Node source_DNode_Node = nodes.get(dNode_source.getName());
			System.out.println(source_DNode_Node.getName());
			Node target_DArrow_Node = nodes.get(dArrow_target.getName());
			System.out.println(target_DArrow_Node.getName());
			EClass arrow = (EClass) core.getEClassifier("Arrow");
		
			for(int k = 0; k<arrow.getEReferences().size();k++){
				if(arrow.getEReferences().get(k).getName().contains("source")){
					ref_DArrow_DNode = arrow.getEReferences().get(k);
				}
			}
			if(preserve){
				Edge edge = henshinFac.createEdge(target_DArrow_Node, source_DNode_Node, ref_DArrow_DNode);
				edge.setAction(new Action(Type.PRESERVE));
			}else{
				henshinFac.createEdge(target_DArrow_Node, source_DNode_Node, ref_DArrow_DNode);
			}
			
		}
		for(int i = 0;i<dArrows.size();i++){
			DArrow dArrow_source = dArrows.get(i);
			DNode dNode_target = dArrows.get(i).getDTarget();
			Node source_DArrow_Node = nodes.get(dArrow_source.getName());
			Node target_DNode_Node = nodes.get(dNode_target.getName());
			EClass arrow = (EClass) core.getEClassifier("Arrow");
		
			for(int k = 0; k<arrow.getEReferences().size();k++){
				if(arrow.getEReferences().get(k).getName().contains("target")){
					ref_DArrow_DNode = arrow.getEReferences().get(k);
				}
			}
			if(preserve){
				Edge edge = henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, ref_DArrow_DNode);
				edge.setAction(new Action(Type.PRESERVE));
			}else{
				Edge edge = henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, ref_DArrow_DNode);
			}
			
		}
	}
	
	private void setEData(EClass node, EClass nodeType, EReference typeNode, EAttribute attribute){
		node = (EClass) core.getEClassifier("Node");
		typeNode = null;
		for(int j = 0; j<node.getEReferences().size();j++){
			if(node.getEReferences().get(j).getName().contains("typeNode")){
				typeNode = node.getEReferences().get(j);
				System.out.println(typeNode);
			}
		}
		nodeType = (EClass) core.getEClassifier("Node");
		attribute = null;
		for(int j = 0;j<nodeType.getEAttributes().size();j++){
			if(nodeType.getEAttributes().get(j).getName().contains("name")){
				attribute = nodeType.getEAttributes().get(j);
			}
		}
	}
			
			/*nodes.put(production.getLeftNodes().get(i).getName(), deletion);
		}
		//Create Arrows LHS
		for(int i = 0;i<production.getLeftArrows().size();i++){
			String dArrowType = production.getLeftArrows().get(i).getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			Node deletion = henshinFac.createNode(lhs, arrowType, null);
			//deletion.setName(production.getLeftArrows().get(i).getArrow().getName());
			
			nodes.put(production.getLeftArrows().get(i).getName(), deletion);
		}
		//Create Nodes on RHS
		for(int i = 0; i<production.getRightNodes().size();i++){
			String dNodeType = production.getRightNodes().get(i).getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			Node insertion = henshinFac.createNode(rhs, nodeType, null);
			insertion.setName(production.getRightNodes().get(i).getName());
			
			nodes.put(production.getRightNodes().get(i).getName(), insertion);
		}
		//Create Arrows on RHS
		for(int i = 0;i<production.getRightArrows().size();i++){
			String dArrowType = production.getRightArrows().get(i).getTypeName();
			System.out.println("DarrowType "+ dArrowType);
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			Node insertion = henshinFac.createNode(rhs, arrowType, null);
			insertion.setName(production.getRightArrows().get(i).getArrow().getName());
			
			nodes.put(production.getRightArrows().get(i).getName(), insertion);
		}
		//Determing common nodes
		for(int i = 0; i<production.getCommonNodes().size();i++){
			String dNodeType = production.getCommonNodes().get(i).getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			Node preserve_lhs = henshinFac.createNode(lhs, nodeType, null);
			Node preserve_rhs = henshinFac.createNode(rhs, nodeType, null);
			preserve_lhs.setName(production.getCommonNodes().get(i).getName());
			preserve_rhs.setName(production.getCommonNodes().get(i).getName());
			
			Mapping m1 = henshinFac.createMapping(preserve_lhs, preserve_rhs);
			rule.getMappings().add(m1);
			
			nodes.put(production.getCommonNodes().get(i).getName()+"_LHS", preserve_lhs);
			nodes.put(production.getCommonNodes().get(i).getName()+"_RHS", preserve_rhs);
		}
		//Determing common arrows
		for(int i = 0; i<production.getCommonArrows().size();i++){
			String dArrowType = production.getCommonArrows().get(i).getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			Node preserve_lhs = henshinFac.createNode(lhs, arrowType, null);
			Node preserve_rhs = henshinFac.createNode(rhs, arrowType, null);
			
			preserve_lhs.setName(production.getCommonArrows().get(i).getName());
			preserve_rhs.setName(production.getCommonArrows().get(i).getName());
			
			Mapping m2 = henshinFac.createMapping(preserve_lhs, preserve_rhs);
			rule.getMappings().add(m2);

			nodes.put(production.getCommonArrows().get(i).getName()+"_LHS", preserve_lhs);
			nodes.put(production.getCommonArrows().get(i).getName()+"_RHS", preserve_rhs);
		}
		
		for (String key : nodes.keySet()) {
		    System.out.println(key);
		}
		//Create Edges LHS
		findEReferencesDNodesLHS_RHS(production.getLeftNodes(), nodes, "");
		findEReferencesDArrowsLHS_RHS(production.getLeftArrows(), nodes, "");		
		//Create Edges RHS
		findEReferencesDNodesLHS_RHS(production.getRightNodes(), nodes, "");
		findEReferencesDArrowsLHS_RHS(production.getRightArrows(), nodes, "");
		//Create Edges Preserve LHS
		findEReferencesDNodesLHS_RHS(production.getCommonNodes(), nodes, "_LHS");
		findEReferencesDArrowsLHS_RHS(production.getCommonArrows(), nodes, "_LHS");
		//Create Edges Preserve RHS		
		findEReferencesDNodesLHS_RHS(production.getCommonNodes(), nodes, "_RHS");
		findEReferencesDArrowsLHS_RHS(production.getCommonArrows(), nodes, "_RHS");
		
		return rule;
	}
	private void findEReferencesDNodesLHS_RHS(EList<DNode> dNodes, 
			HashMap<String, Node> nodes, String preserveElement){
		
		EReference ref_DNode_DArrow = null;
		
		for(int i = 0;i<dNodes.size();i++){
			DNode dNode = dNodes.get(i);
			Node dNode_node = nodes.get(dNode.getName()+preserveElement);
			System.out.println("Her " + dNode_node+preserveElement);
			for(int j = 0; j<dNode.getDIncomings().size();j++){
				DArrow dArrow = dNode.getDIncomings().get(j);
				Node dArrow_node = nodes.get(dArrow.getName()+preserveElement);
				EClass source = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
				EClass target = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
				for(int k = 0; k<source.getEReferences().size();k++){
					if(source.getEReferences().get(k).getEReferenceType()==target){
						ref_DNode_DArrow = source.getEReferences().get(k);
					}
				}
				henshinFac.createEdge(dArrow_node, dNode_node, ref_DNode_DArrow);
			}
			for(int j = 0; j<dNode.getDOutgoings().size();j++){
				DArrow dArrow = dNode.getDOutgoings().get(j);
				Node dArrow_node = nodes.get(dArrow.getName()+preserveElement);
				EClass source = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
				EClass target = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
				for(int k = 0; k<source.getEReferences().size();k++){
					if(source.getEReferences().get(k).getEReferenceType()==target){
						ref_DNode_DArrow = target.getEReferences().get(0);
					}
				}
				henshinFac.createEdge(dNode_node, dArrow_node, ref_DNode_DArrow);
			}
		}
	}
	private void findEReferencesDArrowsLHS_RHS(EList<DArrow> dArrows, 
			HashMap<String, Node> nodes, String preserveElement){
		
		EReference ref_DArrow_DNode = null;
		
		for(int i = 0;i<dArrows.size();i++){
			DNode dNode_source = dArrows.get(i).getDSource();
			DArrow dArrow_target = dArrows.get(i);
			Node source_DNode_Node = nodes.get(dNode_source.getName()+preserveElement);
			Node target_DArrow_Node = nodes.get(dArrow_target.getName()+preserveElement);
			EClass source = (EClass) sourceMetaModel.getEClassifier(dNode_source.getTypeName());
			EClass target = (EClass) sourceMetaModel.getEClassifier(dArrow_target.getTypeName());
		
			for(int k = 0; k<source.getEReferences().size();k++){
				if(source.getEReferences().get(k).getEReferenceType()==target){
					ref_DArrow_DNode = source.getEReferences().get(k);
				}
			}
			henshinFac.createEdge(source_DNode_Node, target_DArrow_Node, ref_DArrow_DNode);
		}
		for(int i = 0;i<dArrows.size();i++){
			DArrow dArrow_source = dArrows.get(i);
			DNode dNode_target = dArrows.get(i).getDTarget();
			Node source_DArrow_Node = nodes.get(dArrow_source.getName()+preserveElement);
			Node target_DNode_Node = nodes.get(dNode_target.getName()+preserveElement);
			EClass source = (EClass) sourceMetaModel.getEClassifier(dArrow_source.getTypeName());
			EClass target = (EClass) sourceMetaModel.getEClassifier(dNode_target.getTypeName());
		
			for(int k = 0; k<source.getEReferences().size();k++){
				if(target.getEReferences().get(k).getEReferenceType()==source){
					ref_DArrow_DNode = target.getEReferences().get(k);
				}
			}
			henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, ref_DArrow_DNode);
		}
	}*/
//	private void findEReferencesDNodesLHS_RHS(EList<DNode> dNodes, 
//			HashMap<String, Node> nodes){
//		
//		EReference ref_DNode_DArrow = null;
//		
//		for(int i = 0;i<dNodes.size();i++){
//			DNode dNode = dNodes.get(i);
//			Node dNode_node = nodes.get(dNode.getName());
//			System.out.println("Her " + dNode_node);
//			for(int j = 0; j<dNode.getDIncomings().size();j++){
//				DArrow dArrow = dNode.getDIncomings().get(j);
//				Node dArrow_node = nodes.get(dArrow.getName());
//				EClass source = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
//				EClass target = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
//				for(int k = 0; k<source.getEReferences().size();k++){
//					if(source.getEReferences().get(k).getEReferenceType()==target){
//						ref_DNode_DArrow = source.getEReferences().get(k);
//					}
//				}
//				henshinFac.createEdge(dArrow_node, dNode_node, ref_DNode_DArrow);
//			}
//			for(int j = 0; j<dNode.getDOutgoings().size();j++){
//				DArrow dArrow = dNode.getDOutgoings().get(j);
//				Node dArrow_node = nodes.get(dArrow.getName());
//				EClass source = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
//				EClass target = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
//				for(int k = 0; k<source.getEReferences().size();k++){
//					if(source.getEReferences().get(k).getEReferenceType()==target){
//						ref_DNode_DArrow = target.getEReferences().get(0);
//					}
//				}
//				henshinFac.createEdge(dNode_node, dArrow_node, ref_DNode_DArrow);
//			}
//		}
//	}
//	

//	private void findEReferences(Graph rhs, Production production, HashMap<String, Node> nodes){
//		EReference ref_DNode_DArrow = null;
//		
//		for(int i = 0;i<production.getRightNodes().size();i++){
//			DNode dNode = production.getRightNodes().get(i);
//			Node dNode_node = nodes.get(dNode.getName());
//			System.out.println("Her " + dNode_node);
//			for(int j = 0; j<dNode.getDIncomings().size();j++){
//				DArrow dArrow = dNode.getDIncomings().get(j);
//				Node dArrow_node = nodes.get(dArrow.getName());
//				EClass source = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
//				EClass target = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
//				for(int k = 0; k<source.getEReferences().size();k++){
//					if(source.getEReferences().get(k).getEReferenceType()==target){
//						ref_DNode_DArrow = source.getEReferences().get(k);
//					}
//				}
//				Edge src_trg = henshinFac.createEdge(dArrow_node, dNode_node, ref_DNode_DArrow);
//			}
//			for(int j = 0; j<dNode.getDOutgoings().size();j++){
//				DArrow dArrow = dNode.getDOutgoings().get(j);
//				Node dArrow_node = nodes.get(dArrow.getName());
//				EClass source = (EClass) sourceMetaModel.getEClassifier(dNode.getTypeName());
//				EClass target = (EClass) sourceMetaModel.getEClassifier(dArrow.getTypeName());
//				for(int k = 0; k<source.getEReferences().size();k++){
//					if(source.getEReferences().get(k).getEReferenceType()==target){
//						ref_DNode_DArrow = source.getEReferences().get(k);
//					}
//				}
//				Edge src_trg = henshinFac.createEdge(dNode_node, dArrow_node, ref_DNode_DArrow);
//			}
//		}
//	}

	private Graph generateLHSGraph(Graph lhs, Production production){
		Graph lhs_graph = lhs;
		for(int i = 0; i<production.getLeftNodes().size();i++){
			DNode dNode = production.getLeftNodes().get(i);
			String dNodeType = dNode.getDType().getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			if(dNode.getDIncomings().isEmpty() && dNode.getDOutgoings().isEmpty()){
				henshinFac.createNode(lhs, nodeType, production.getLeftNodes().get(i).getNode().getName());
			}
			Node src_node = henshinFac.createNode(lhs, nodeType, production.getLeftNodes().get(i).getNode().getName());
			
			for(int j = 0; j<dNode.getDIncomings().size();j++){
				DArrow dArrow = dNode.getDIncomings().get(j);
				EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrow.getDType().getTypeName());
				henshinFac.createNode(lhs, arrowType, dArrow.getName());
			}	
		}

		return lhs_graph;
	}	
}
