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
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
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
	private DSpecification correspondance = null;
	
	private HenshinResourceSet resourceSet = null;
	private HenshinFactory henshinFac = HenshinFactoryImpl.eINSTANCE;
	
	private TracePackage tracePackage = null;
	private CorePackage specificationPackage = null;
	private EcorePackage ecorePackage = null;
	
	private LoopUnit loopUnit = null;
	
	private HashMap<String, Node> traces = null;
	private HashMap<String, DNode> correspond = null;
	
	private static final String BRIDGEELEMENT = "Link";
	
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
		ecorePackage = EcorePackageImpl.init();

		traces = new HashMap<String,Node>();
		correspond = new HashMap<String, DNode>();
		
		correspondance = DPFUtils.loadDSpecification(URI.createFileURI(TransformUtils.activeWorkingDirectory()+"/metamodel2petriNetMetaModel.dpf"));
		
		for(int i = 0;i<correspondance.getDGraph().getDNodes().size();i++){
			correspond.put(correspondance.getDGraph().getDNodes().get(i).getNode().getName(), correspondance.getDGraph().getDNodes().get(i));
		}
	}
	public Module createModule(){
		Module mainModule = henshinFac.createModule();
		
		Rule tempRule = null;
	
		mainModule.getImports().add(specificationPackage);
		mainModule.getImports().add(tracePackage);
		
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

	private Rule generateRuleForCore(Production production) {
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		Rule rule = henshinFac.createRule(production.getName());
		rule.setActivated(true);
		int parameter = 0;
	
		HashMap<String, DElement> commonTraces = new HashMap<String, DElement>();
		HashMap<String, DElement> insertTraces = new HashMap<String, DElement>();
		
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
				
		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
			String dNodeType = TransformUtils.trimNumber(production.getLeftNodes().get(i).getName());
			EClass node = specificationPackage.getNode();
			EReference referenceNode_typeNode = specificationPackage.getNode_TypeNode();
			EClass nodeType = specificationPackage.getNode();
			EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
			
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
			String dArrowType = TransformUtils.trimNumber(production.getLeftArrows().get(i).getName());
			EClass arrow = specificationPackage.getArrow();
			EReference referenceArrow = specificationPackage.getArrow_TypeArrow();
			EClass arrowType = specificationPackage.getArrow();
			EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();
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
			String dNodeType = TransformUtils.trimNumber(production.getCommonNodes().get(i).getName());
			if(!dNodeType.equals("Trace")){
				EClass node = specificationPackage.getNode();
				EReference referenceNode = specificationPackage.getNode_TypeNode();
				EClass nodeType = specificationPackage.getNode();
				EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
				
				Node preserveNode = henshinFac.createNode(lhs, node, null);
				preserveNode.setName(production.getCommonNodes().get(i).getName());
				nodes.put(production.getCommonNodes().get(i).getName(), preserveNode);
				preserveNode.setAction(new Action(Type.PRESERVE));
				nodes.put(production.getCommonNodes().get(i).getName()+NODETYPE, preserveNode);
				
				
				traces.put(production.getCommonNodes().get(i).getNode().getId(),preserveNode);
				
				Node preserveNodeType = henshinFac.createNode(lhs, nodeType, null);
				preserveNodeType.setName(production.getCommonNodes().get(i).getName()+NODETYPE);
				preserveNodeType.setAction(new Action(Type.PRESERVE));
				Edge preserveTypeNodeRef = henshinFac.createEdge(preserveNode, preserveNodeType, referenceNode);
				preserveTypeNodeRef.setAction(new Action(Type.PRESERVE));
				
				Attribute henshin_attribute = henshinFac.createAttribute(preserveNodeType, nodeTypeAttribute, "\""+dNodeType+"\"");
				henshin_attribute.setAction(new Action(Type.REQUIRE));
			}	
			else{
				commonTraces.put(production.getCommonNodes().get(i).getNode().getId(), production.getCommonNodes().get(i));
			}
		}
		//Determing common arrows
		for(int i = 0; i<production.getCommonArrows().size();i++){
			String dArrowType = TransformUtils.trimNumber(production.getCommonArrows().get(i).getName());
			if(!dArrowType.equals("Trace")){
				EClass arrow = specificationPackage.getArrow();
				EReference referenceArrow = specificationPackage.getArrow_TypeArrow();
				EClass arrowType = specificationPackage.getArrow();
				EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();

				Node preserveArrowNode = henshinFac.createNode(lhs, arrow, null);
				preserveArrowNode.setName(production.getCommonArrows().get(i).getName());
				preserveArrowNode.setAction(new Action(Type.PRESERVE));
				nodes.put(production.getCommonArrows().get(i).getName(), preserveArrowNode);
				
				traces.put(production.getCommonArrows().get(i).getArrow().getId(),preserveArrowNode);

				Node preserveTypeArrowNode = henshinFac.createNode(lhs, arrowType, null);
				preserveTypeArrowNode.setName(production.getCommonArrows().get(i).getName()+ARROWTYPE);
				preserveTypeArrowNode.setAction(new Action(Type.PRESERVE));
				nodes.put(production.getCommonArrows().get(i).getName()+ARROWTYPE, preserveTypeArrowNode);
				
				Edge preserveTypeArrowRef = henshinFac.createEdge(preserveArrowNode, preserveTypeArrowNode, referenceArrow);
				preserveTypeArrowRef.setAction(new Action(Type.PRESERVE));
				
				Attribute henshin_attribute = henshinFac.createAttribute(preserveTypeArrowNode, arrowTypeAttribute, "\""+dArrowType+"\"");
				henshin_attribute.setAction(new Action(Type.REQUIRE));
			}
			else{
				commonTraces.put(production.getCommonArrows().get(i).getArrow().getId(), production.getCommonArrows().get(i));
			}
			
		}
		for(int i = 0; i<production.getRightNodes().size();i++){
			String dNodeType = TransformUtils.trimNumber(production.getRightNodes().get(i).getName());
			
			
			
			if(!dNodeType.equals("Trace")){
				String name = "name"+parameter;
				Parameter nameParameter = henshinFac.createParameter("name"+parameter);
				nameParameter.setType(ecorePackage.getEClassifier("EString"));
				parameter++;
				
				rule.getParameters().add(nameParameter);
				
				EClass node = specificationPackage.getNode();
				EClass nodeType = specificationPackage.getNode();
				EAttribute nodeTypeAttribute = specificationPackage.getNode_Name();
				
				EReference referenceNode = specificationPackage.getNode_TypeNode();

				Node insertionNode = henshinFac.createNode(rhs, node, null);
				insertionNode.setName(production.getRightNodes().get(i).getName());
				nodes.put(production.getRightNodes().get(i).getName(), insertionNode);
				traces.put(production.getRightNodes().get(i).getNode().getId(),insertionNode);
				
				Attribute node_name = henshinFac.createAttribute(insertionNode, nodeTypeAttribute, name);
				
				if(!hasCorrespondancePart(dNodeType)){
					node_name.setValue("\"\"");
				}
				else{
					map_lhs_rhs_parameter(production, dNodeType, name, production.getRightNodes().get(i));
				}
				
				setTargetTrace(rule, insertionNode, production.getRightNodes().get(i), production);
				
				Node insertionTypeNode = henshinFac.createNode(lhs, nodeType, null);
				insertionTypeNode.setName(production.getRightNodes().get(i).getName()+NODETYPE);
				nodes.put(production.getRightNodes().get(i).getName()+NODETYPE, insertionTypeNode);
				insertionTypeNode.setAction(new Action(Type.CREATE));

				
				
				Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeNode, nodeTypeAttribute, "\""+dNodeType+"\"");
				henshin_attribute.setAction(new Action(Type.CREATE));
				
				Edge insertionTypeNodeRef = henshinFac.createEdge(insertionNode, insertionTypeNode, referenceNode);
				insertionTypeNode.setAction(new Action(Type.CREATE));
				
				insertionNode.setAction(new Action(Type.CREATE));	
				insertionTypeNodeRef.setAction(new Action(Type.CREATE));
			}
			else{
				insertTraces.put(production.getRightNodes().get(i).getNode().getId(), production.getRightNodes().get(i));
			}
		}
		for(int i = 0;i<production.getRightArrows().size();i++){
			String dArrowType = TransformUtils.trimNumber(production.getRightArrows().get(i).getName());
			if(!dArrowType.equals("Trace")){
				String name = "name"+parameter;
				Parameter nameParameter = henshinFac.createParameter("name"+parameter);
				nameParameter.setType(ecorePackage.getEClassifier("EString"));
				parameter++;

				rule.getParameters().add(nameParameter);
				
				EClass arrow = specificationPackage.getArrow();
				EClass arrowType = specificationPackage.getArrow();
				
				EReference referenceArrow = specificationPackage.getArrow_TypeArrow();

				EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();

				Node insertionArrow = henshinFac.createNode(rhs, arrow, null);
				insertionArrow.setName(production.getRightArrows().get(i).getName());
				nodes.put(production.getRightArrows().get(i).getName(), insertionArrow);
				insertionArrow.setAction(new Action(Type.CREATE));
				
				Attribute arrow_name = henshinFac.createAttribute(insertionArrow, arrowTypeAttribute, name);
				
				if(!hasCorrespondancePart(dArrowType)){
					arrow_name.setValue("\"\"");
				}
				
				Node insertionTypeArrow = henshinFac.createNode(rhs, arrowType, null);
				insertionTypeArrow.setName(production.getRightArrows().get(i).getName()+ARROWTYPE);
				nodes.put(production.getRightArrows().get(i).getName()+ARROWTYPE, insertionTypeArrow);
				insertionTypeArrow.setAction(new Action(Type.CREATE));
		
				traces.put(production.getRightArrows().get(i).getArrow().getId(),insertionArrow);
				
				Attribute henshin_attribute = henshinFac.createAttribute(insertionTypeArrow, arrowTypeAttribute, "\""+dArrowType+"\"");
				henshin_attribute.setAction(new Action(Type.CREATE));
				
				Edge insertionTypeArrowRef = henshinFac.createEdge(insertionArrow, insertionTypeArrow, referenceArrow);
				insertionTypeArrowRef.setAction(new Action(Type.CREATE));
				
				insertionArrow.setAction(new Action(Type.CREATE));	
				insertionTypeArrowRef.setAction(new Action(Type.CREATE));
			}	
			else{
				insertTraces.put(production.getRightArrows().get(i).getArrow().getId(), production.getRightArrows().get(i));
			}
		}
		
		for (DElement value : commonTraces.values()) {
			DNode dNodeTrace = null;
			DArrow dArrowTrace = null;
			Node trace_preserveNode = null;
			if(value instanceof DNode){
				dNodeTrace = (DNode) value;
				trace_preserveNode = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
				trace_preserveNode.setName(dNodeTrace.getName());
			}
			else{
				dArrowTrace = (DArrow) value;
				trace_preserveNode = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
				trace_preserveNode.setName(dArrowTrace.getName());
			}
			
			trace_preserveNode.setAction(new Action(Type.PRESERVE));
			
			if(value instanceof DNode){
				DNode source = null;
				DNode target = null;
				for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
					if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceSource_")){
						source = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
						Node preserveNode = traces.get(source.getNode().getId());
						Edge edge_trace_preserveSource = henshinFac.createEdge(trace_preserveNode, preserveNode, tracePackage.getTrace_Source());
						edge_trace_preserveSource.setAction(new Action(Type.PRESERVE));
					}
				}
				for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
					if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceTarget_")){
						target = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
						Node preserveNode = traces.get(target.getNode().getId());
						
						Edge edge_trace_preserveTarget = henshinFac.createEdge(trace_preserveNode, preserveNode, tracePackage.getTrace_Target());
						edge_trace_preserveTarget.setAction(new Action(Type.PRESERVE));
					}
				}
			}
			else{
				DNode source = dArrowTrace.getDSource();
				DNode target = dArrowTrace.getDTarget();
			}		
		}
		for (DElement value : insertTraces.values()) {
			DNode dNodeTrace = null;
			DArrow dArrowTrace = null;
			Node trace_insertionNode = null;
			if(value instanceof DNode){
				dNodeTrace = (DNode) value;
				trace_insertionNode = henshinFac.createNode(rhs, tracePackage.getTrace(), null);
				trace_insertionNode.setName(dNodeTrace.getName());
			}
			else{
				dArrowTrace = (DArrow) value;
				trace_insertionNode = henshinFac.createNode(rhs, tracePackage.getTrace(), null);
				trace_insertionNode.setName(dArrowTrace.getName());
			}
			
			trace_insertionNode.setAction(new Action(Type.CREATE));
			
			if(value instanceof DNode){
				DNode source = null;
				DNode target = null;
				for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
					if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceSource_")){
						source = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
						Node insertionNode = traces.get(source.getNode().getId());
						henshinFac.createEdge(trace_insertionNode, rhs.getNode(insertionNode.getName()), tracePackage.getTrace_Source());
					
						Graph graph = henshinFac.createGraph();
						
						Node forbid_source_node = null;
						forbid_source_node = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
						forbid_source_node.setName(trace_insertionNode.getName());
						
						Node forbid_target_node = henshinFac.createNode(lhs, specificationPackage.getNode(), null);
						forbid_target_node.setName(insertionNode.getName());
						
						Edge forbid_edge = henshinFac.createEdge(forbid_source_node, forbid_target_node, tracePackage.getTrace_Source());
						
						graph.getNodes().add(forbid_source_node);
						graph.getNodes().add(forbid_target_node);
						graph.getEdges().add(forbid_edge);
						
						Mapping mapping = henshinFac.createMapping(insertionNode, forbid_target_node);
						
						rule.getLhs().createNAC("TempNAC");
						rule.getLhs().getNAC("TempNAC").getMappings().add(mapping);
						rule.getLhs().getNAC("TempNAC").setConclusion(graph);
					}
				}
				for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
					if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceTarget_")){
						target = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
						Node insertionNode = traces.get(target.getNode().getId());
						
						henshinFac.createEdge(trace_insertionNode, insertionNode, tracePackage.getTrace_Target());
					}
				}
			}
			else{
				DNode source = dArrowTrace.getDSource();
				DNode target = dArrowTrace.getDTarget();
				
			}		
		}

		findEReferencesDArrowsLHS_RHS(rule, production.getCommonArrows(), nodes, true);
		findEReferencesDArrowsLHS_RHS(rule, production.getLeftArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(rule, production.getRightArrows(), nodes, false);
		
		rule.setInjectiveMatching(false);
		rule.setCheckDangling(false);
		return rule;
	}
	
	private void map_lhs_rhs_parameter(Production production, String dNodeType, String parameter, DNode dNode) {
		boolean hasTraceOject = false;
		for(int i = 0;i<dNode.getDIncomings().size();i++){
			if(dNode.getDIncomings().get(i).getName().startsWith("trace")){
				DNode traceNode = dNode.getDIncomings().get(i).getDSource();
				for(int j = 0;j<traceNode.getDOutgoings().size();j++){
					if(traceNode.getDOutgoings().get(j).getName().contains("Source")){
						Node node = traces.get(traceNode.getDOutgoings().get(j).getDTarget().getNode().getId());
						System.out.println("Node " + node.getName());
						Attribute attribute = henshinFac.createAttribute(node, specificationPackage.getNode_Name(), parameter);
						attribute.setAction(new Action(Type.PRESERVE));
						
						hasTraceOject = true;
					}
				}
			}
		}
		if(!hasTraceOject){
			String type = null;
			for(DNode dnode : correspond.values()){
				if(dnode.getTypeName().equals(BRIDGEELEMENT)){
					DNode bridgeNode = dnode;
					for(int j = 0;j<bridgeNode.getDOutgoings().size();j++){
						if(bridgeNode.getDOutgoings().get(j).getTypeName().contains("sourceSequence")){
							type = bridgeNode.getDOutgoings().get(j).getDTarget().getTypeName();
						}
					}
					 
				}
			}
			for(Node node : traces.values()){
				if(node.getName().startsWith(type)){
					Attribute attribute = henshinFac.createAttribute(node, specificationPackage.getNode_Name(), parameter);
					attribute.setAction(new Action(Type.PRESERVE));
				}
			}
		}
	}
	private boolean hasCorrespondancePart(String type) {
		for(DNode node : correspond.values()){
			if(node.getTypeName().equals(type)){
				if(!node.getDIncomings().isEmpty()){
					System.out.println(type+" True");
					return true;
				}
				else{
					System.out.println(type+" False");
					return false;
				}
			}
		}
		return false;
	}
	private void setTargetTrace(Rule rule, Node insertionNode, DNode dNode,
			Production production) {
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		DNode sourceNode = null;
		DNode targetNode = dNode;
		Node trace_object = null;
		
		for(int i = 0;i<targetNode.getDIncomings().size();i++){
			if(targetNode.getDIncomings().get(i).getName().startsWith("linkTarget_")){
				DArrow targetDArrow = targetNode.getDIncomings().get(i);
				DNode trace = targetDArrow.getDSource();
				for(int j = 0; j<trace.getDOutgoings().size();j++){
					if(trace.getDOutgoings().get(j).getName().startsWith("linkource_")){
						sourceNode = trace.getDOutgoings().get(j).getDTarget();
						trace_object = traces.get(sourceNode.getNode().getId());
					}
				}	
			}
		}
		if(trace_object!=null){
			henshinFac.createEdge(trace_object, insertionNode, tracePackage.getTrace_Target());
		}
	}
	private void findEReferencesDArrowsLHS_RHS(Rule rule, EList<DArrow> dArrows, 
			HashMap<String, Node> nodes, boolean preserve){
		
		EReference source_node = specificationPackage.getArrow_Source();
		EReference target_node = specificationPackage.getArrow_Target();
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		for(int i = 0;i<dArrows.size();i++){
			DNode dNode_source = dArrows.get(i).getDSource();
			DNode dNode_target = dArrows.get(i).getDTarget();
			DArrow dArrow = dArrows.get(i);
			Node source_DNode_Node = traces.get(dNode_source.getNode().getId());
			Node target_DNode_Node = traces.get(dNode_target.getNode().getId());
			Node target_DArrow_Node = traces.get(dArrow.getArrow().getId());

			Edge source_edge = rule.createEdge(target_DArrow_Node, source_DNode_Node, source_node);
			Edge target_edge = rule.createEdge(target_DArrow_Node, target_DNode_Node, target_node);

			if(preserve){
				source_edge.setAction(new Action(Type.PRESERVE));
				target_edge.setAction(new Action(Type.PRESERVE));

			}
			else{
				source_edge.setAction(new Action(Type.CREATE));
				target_edge.setAction(new Action(Type.CREATE));
			}
		}
	}
}
