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
	
	private HashMap<String, Node> insertionPart;
	private HashMap<String, Node> commonPart;
	private HashMap<String, DElement> commonArrows;
	
	private HashMap<String, String> mappedElements;
	
	private static final String BRIDGEELEMENT = "Link";
	
	private static final String DEFAULT_ARROW = "Arrow";
	private static final String DEFAULT_NODE = "Node";
	private static final String ARROWTYPE = "ArrowType";	
	private static final String NODETYPE = "DNodeType";
	private static final String NODE = "Node";
	private static final String MAPARROW = "->";
	
	public TransformModule(Transform transform, HenshinResourceSet resourceSet){
		this.resourceSet = resourceSet;
		this.transform = transform;
		
		tracePackage = TracePackageImpl.init();
		specificationPackage = CorePackageImpl.init();
		ecorePackage = EcorePackageImpl.init();

		traces = new HashMap<String,Node>();
		
		correspond = new HashMap<String, DNode>();
		
		insertionPart = new HashMap<String,Node>();
		commonPart = new HashMap<String,Node>();
		commonArrows  = new HashMap<String,DElement>();
		mappedElements = new HashMap<String, String>();
		
		URI source = URI.createFileURI(transform.getSourceLocation());
		URI target = URI.createFileURI(transform.getTargetLocation());
		
		String dpfFilename = TransformUtils.activeWorkingDirectory()+"/"+TransformConstants.GENERATE_FOLDER+"/"+TransformUtils.createCorrespondanceType(source.lastSegment().replace(".dpf", ""), 
				target.lastSegment());
		
		//correspondance = DPFUtils.loadDSpecification(URI.createFileURI(TransformUtils.activeWorkingDirectory()+"/"+TransformConstants.GENERATE_FOLDER+"/metamodel2petriNetMetaModel.dpf"));
		correspondance = DPFUtils.loadDSpecification(URI.createFileURI(dpfFilename));
		//DPFUtils.load
		System.out.println("corresp" + correspondance.getDGraph().getDNodes());
		
		for(int i = 0;i<correspondance.getDGraph().getDNodes().size();i++){
			correspond.put(correspondance.getDGraph().getDNodes().get(i).getNode().getName(), correspondance.getDGraph().getDNodes().get(i));
			System.out.println("Type " + correspondance.getDGraph().getDNodes().get(i).getNode().getName());
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
	
//		HashMap<String, DElement> commonTraces = new HashMap<String, DElement>();
//		HashMap<String, DElement> insertTraces = new HashMap<String, DElement>();
		HashMap<String, DNode> commonTraces = new HashMap<String, DNode>();
		HashMap<String, DNode> insertTraces = new HashMap<String, DNode>();
		
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
//			String dNodeType = TransformUtils.trimNumber(production.getLeftNodes().get(i).getName());
			String dNodeType = production.getLeftNodes().get(i).getTypeName();
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
//			String dArrowType = TransformUtils.trimNumber(production.getLeftArrows().get(i).getName());
			String dArrowType = production.getLeftArrows().get(i).getTypeName();
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
			//String dNodeType = TransformUtils.trimNumber(production.getCommonNodes().get(i).getName());
			String dNodeType = production.getCommonNodes().get(i).getTypeName();
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
				commonPart.put(production.getCommonNodes().get(i).getNode().getId(), preserveNode);
				
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
//			String dArrowType = TransformUtils.trimNumber(production.getCommonArrows().get(i).getName());
			String dArrowType = production.getCommonArrows().get(i).getTypeName();
			boolean hasMappedItem = false;
			String mappedItem = "";
			
			EClass arrow = specificationPackage.getArrow();
			EReference referenceArrow = specificationPackage.getArrow_TypeArrow();
			EClass arrowType = specificationPackage.getArrow();
			EAttribute arrowTypeAttribute = specificationPackage.getArrow_Name();

			String name = production.getCommonArrows().get(i).getName();
			System.out.println("Pelle " + name + " " + name.length());
			if(name.contains(MAPARROW)){
				hasMappedItem = true;
				int index = name.indexOf(MAPARROW);
				mappedItem = name.substring(index+MAPARROW.length(), name.length());
				
				mappedElements.put(mappedItem, production.getCommonArrows().get(i).getArrow().getId());
				
				name = name.substring(0, index);
				System.out.println("HER " + name + " " + mappedItem);
			}
			
			Node preserveArrowNode = henshinFac.createNode(lhs, arrow, null);
			preserveArrowNode.setName(name);
			preserveArrowNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonArrows().get(i).getName(), preserveArrowNode);
				
			traces.put(production.getCommonArrows().get(i).getArrow().getId(),preserveArrowNode);
			commonPart.put(production.getCommonArrows().get(i).getArrow().getId(), preserveArrowNode);

			Node preserveTypeArrowNode = henshinFac.createNode(lhs, arrowType, null);
			preserveTypeArrowNode.setName(name+ARROWTYPE);
			preserveTypeArrowNode.setAction(new Action(Type.PRESERVE));
			nodes.put(production.getCommonArrows().get(i).getName()+ARROWTYPE, preserveTypeArrowNode);
				
			Edge preserveTypeArrowRef = henshinFac.createEdge(preserveArrowNode, preserveTypeArrowNode, referenceArrow);
			preserveTypeArrowRef.setAction(new Action(Type.PRESERVE));
				
			Attribute henshin_attribute = henshinFac.createAttribute(preserveTypeArrowNode, arrowTypeAttribute, "\""+dArrowType+"\"");
			henshin_attribute.setAction(new Action(Type.REQUIRE));
			
			
			for(DNode dNode : correspond.values()){
				if(dNode.getTypeName().equals(dArrowType)){
					commonArrows.put(production.getCommonArrows().get(i).getArrow().getId(), production.getCommonArrows().get(i));
				}
			}
		}
		for(int i = 0; i<production.getRightNodes().size();i++){
//			String dNodeType = TransformUtils.trimNumber(production.getRightNodes().get(i).getName());
			String dNodeType = production.getRightNodes().get(i).getTypeName();

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
				insertionPart.put(production.getRightNodes().get(i).getNode().getId(), insertionNode);
				
				Attribute node_name = henshinFac.createAttribute(insertionNode, nodeTypeAttribute, name);
				
				if(!hasCorrespondancePart(dNodeType)){
					node_name.setValue("\"\"");
				}
				else if(hasTraceObject(production.getRightNodes().get(i))){
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
				
				for(DNode dNode : correspond.values()){
					if(dNode.getTypeName().equals(dNodeType)){
						commonArrows.put(production.getRightNodes().get(i).getNode().getId(), production.getRightNodes().get(i));
					}
				}
			}
			else{
				insertTraces.put(production.getRightNodes().get(i).getNode().getId(), production.getRightNodes().get(i));
			}
		}
		for(int i = 0;i<production.getRightArrows().size();i++){
			//String dArrowType = TransformUtils.trimNumber(production.getRightArrows().get(i).getName());
			String dArrowType = production.getRightArrows().get(i).getTypeName();
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
			insertionPart.put(production.getRightArrows().get(i).getArrow().getId(), insertionArrow);
			insertionArrow.setAction(new Action(Type.CREATE));
				
			Attribute arrow_name = henshinFac.createAttribute(insertionArrow, arrowTypeAttribute, name);
				
			if(!hasCorrespondancePart(dArrowType)){
				arrow_name.setValue("\"\"");
			}
			else{
				map_lhs_rhs_parameter(production, dArrowType, name, production.getRightArrows().get(i));
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
		for(DNode corrNode : correspond.values()){
			for(int i = 0;i<production.getSum().getDGraph().getDArrows().size();i++){
				if(corrNode.getTypeName().equals(production.getSum().getDGraph().getDArrows().get(i).getTypeName())){
					boolean match = false;
					
					DArrow dArrow = production.getSum().getDGraph().getDArrows().get(i);
					String target_id = "";
					DNode sourceNode = corrNode;
					String sourceType = dArrow.getTypeName();
					System.out.println("Type to change " +  sourceType);
					String linkNode = corrNode.getDIncomings().get(0).getDSource().getTypeName();
					DNode link = corrNode.getDIncomings().get(0).getDSource();
					String targetType = "";
					for(int j = 0;j<link.getDOutgoings().size();j++){
						if(link.getDOutgoings().get(j).getTypeName().startsWith("target")){
							targetType = link.getDOutgoings().get(j).getDTarget().getTypeName();
						}
					}
					for(int j = 0;j<production.getSum().getDGraph().getDArrows().size();j++){
						if(production.getSum().getDGraph().getDArrows().get(j).getTypeName().equals(targetType) && !sourceType.equals(targetType)){
							System.out.println("Match found " + production.getSum().getDGraph().getDArrows().get(j).getTypeName());
							target_id = production.getSum().getDGraph().getDArrows().get(j).getArrow().getId();
							match = true;
						}
					}
					for(int j = 0;j<production.getSum().getDGraph().getDNodes().size();j++){
						if(production.getSum().getDGraph().getDNodes().get(j).getTypeName().equals(targetType)){
							System.out.println("Match found " + production.getSum().getDGraph().getDNodes().get(j).getTypeName());
							target_id = production.getSum().getDGraph().getDNodes().get(j).getNode().getId();
							match = true;
						}
					}
					
					if(match && !target_id.isEmpty()){
						Node source_trace_node = traces.get(dArrow.getArrow().getId());
						Node target_trace_node = traces.get(target_id);
						Node trace_node = null;
						
						//set parameter
						if(!target_trace_node.getAttributes().isEmpty()){
							EAttribute attributeType = null;
							if(traces.get(target_trace_node) instanceof DArrow){
								attributeType = specificationPackage.getArrow_Name();
							}
							else{
								attributeType = specificationPackage.getNode_Name();
							}
							Attribute temp = target_trace_node.getAttribute(attributeType);
							Attribute attribute = henshinFac.createAttribute(source_trace_node, attributeType, temp.getValue());
							attribute.setAction(new Action(Type.PRESERVE));
							
						}
						
						System.out.println("Navnet på Noden " + traces.get(target_id).getName());
						
						if(traces.get(target_id).getAction().toString().equals("create")){
							trace_node = henshinFac.createNode(rhs, tracePackage.getTrace(), null);
							trace_node.setName(traces.get(target_id).getName());
							
							trace_node.setAction(new Action(Type.CREATE));
							
							henshinFac.createEdge(trace_node, target_trace_node, tracePackage.getTrace_Target());
							henshinFac.createEdge(trace_node, rhs.getNode(source_trace_node.getName()), tracePackage.getTrace_Source());
							
							
							
							
							
							boolean exisitNAC = false;
							Graph graph = henshinFac.createGraph();
							NestedCondition nac = null;
								
							Node forbid_source_node = null;
							forbid_source_node = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
							forbid_source_node.setName(trace_node.getName());
								
							Node forbid_target_node = henshinFac.createNode(lhs, specificationPackage.getArrow(), null);
							forbid_target_node.setName(source_trace_node.getName());
								
							Edge forbid_edge = henshinFac.createEdge(forbid_source_node, forbid_target_node, tracePackage.getTrace_Source());
								
							Mapping mapping = henshinFac.createMapping(source_trace_node, forbid_target_node);
							
							for(int k = 0;k<rule.getLhs().getNestedConditions().size();k++){
								if(rule.getLhs().getNestedConditions().get(k).isNAC()){
									exisitNAC = true;
									nac = rule.getLhs().getNestedConditions().get(k);
								}
							}
							
							if(!exisitNAC){
								graph.getNodes().add(forbid_source_node);
								graph.getNodes().add(forbid_target_node);
								graph.getEdges().add(forbid_edge);
			
								rule.getLhs().createNAC("TempNAC");
								rule.getLhs().getNAC("TempNAC").getMappings().add(mapping);
								rule.getLhs().getNAC("TempNAC").setConclusion(graph);
							}
							else{
								nac.getConclusion().getNodes().add(forbid_source_node);
								nac.getConclusion().getNodes().add(forbid_target_node);
								nac.getConclusion().getEdges().add(forbid_edge);
								
								nac.getMappings().add(mapping);
							}
							
						}
					}
				}
			}
		}
		
		for (DNode value : insertTraces.values()) {
			DNode dNodeTrace = value;
			
			Node trace_insertionNode = null;
			trace_insertionNode = henshinFac.createNode(rhs, tracePackage.getTrace(), null);
			trace_insertionNode.setName(dNodeTrace.getName());

			trace_insertionNode.setAction(new Action(Type.CREATE));
			
			DNode source = null;
			DNode target = null;
			for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
//				if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceSource_")){
				if(dNodeTrace.getDOutgoings().get(j).getTypeName().startsWith("traceSource_")){
					source = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
					Node insertionNode = traces.get(source.getNode().getId());
					henshinFac.createEdge(trace_insertionNode, rhs.getNode(insertionNode.getName()), tracePackage.getTrace_Source());
					
					boolean exisitNAC = false;
					Graph graph = henshinFac.createGraph();
					NestedCondition nac = null;
						
					Node forbid_source_node = null;
					forbid_source_node = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
					forbid_source_node.setName(trace_insertionNode.getName());
						
					Node forbid_target_node = henshinFac.createNode(lhs, specificationPackage.getNode(), null);
					forbid_target_node.setName(insertionNode.getName());
						
					Edge forbid_edge = henshinFac.createEdge(forbid_source_node, forbid_target_node, tracePackage.getTrace_Source());
						
					Mapping mapping = henshinFac.createMapping(insertionNode, forbid_target_node);
					
					for(int k = 0;k<rule.getLhs().getNestedConditions().size();k++){
						if(rule.getLhs().getNestedConditions().get(k).isNAC()){
							exisitNAC = true;
							nac = rule.getLhs().getNestedConditions().get(k);
						}
					}
					
					if(!exisitNAC){
						graph.getNodes().add(forbid_source_node);
						graph.getNodes().add(forbid_target_node);
						graph.getEdges().add(forbid_edge);
	
						rule.getLhs().createNAC("TempNAC");
						rule.getLhs().getNAC("TempNAC").getMappings().add(mapping);
						rule.getLhs().getNAC("TempNAC").setConclusion(graph);
					}
					else{
						nac.getConclusion().getNodes().add(forbid_source_node);
						nac.getConclusion().getNodes().add(forbid_target_node);
						nac.getConclusion().getEdges().add(forbid_edge);
						
						nac.getMappings().add(mapping);
					}
				}
			}
			for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
//				if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceTarget_")){
				if(dNodeTrace.getDOutgoings().get(j).getTypeName().startsWith("traceTarget_")){
					target = dNodeTrace.getDOutgoings().get(j).getDTarget();
						
					Node insertionNode = traces.get(target.getNode().getId());
						
					henshinFac.createEdge(trace_insertionNode, insertionNode, tracePackage.getTrace_Target());
				}
			}	
		}
		
		for (DNode value : commonTraces.values()) {
			DNode dNodeTrace = value;
			Node trace_preserveNode = null;

			trace_preserveNode = henshinFac.createNode(lhs, tracePackage.getTrace(), null);
			trace_preserveNode.setName(dNodeTrace.getName());
			
			trace_preserveNode.setAction(new Action(Type.PRESERVE));
			
			DNode source = null;
			DNode target = null;
			for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
//				if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceSource_")){
				if(dNodeTrace.getDOutgoings().get(j).getTypeName().startsWith("traceSource_")){
					source = dNodeTrace.getDOutgoings().get(j).getDTarget();
					
					Node preserveNode = traces.get(source.getNode().getId());
					Edge edge_trace_preserveSource = henshinFac.createEdge(trace_preserveNode, preserveNode, tracePackage.getTrace_Source());
					edge_trace_preserveSource.setAction(new Action(Type.PRESERVE));
				}
			}
			for(int j = 0;j<dNodeTrace.getDOutgoings().size();j++){
//				if(dNodeTrace.getDOutgoings().get(j).getName().startsWith("traceTarget_")){
				if(dNodeTrace.getDOutgoings().get(j).getTypeName().startsWith("traceTarget_")){
					target = dNodeTrace.getDOutgoings().get(j).getDTarget();
					
					Node preserveNode = traces.get(target.getNode().getId());
					
					Edge edge_trace_preserveTarget = henshinFac.createEdge(trace_preserveNode, preserveNode, tracePackage.getTrace_Target());
					edge_trace_preserveTarget.setAction(new Action(Type.PRESERVE));
				}
			}

		}
		
		
		
		for(DNode dNode : correspond.values()){
			if(dNode.getTypeName().equals(BRIDGEELEMENT)){
				
			}
		}
		
		
		
		
		
		findEReferencesDArrowsLHS_RHS(rule, production.getCommonArrows(), nodes, true);
		findEReferencesDArrowsLHS_RHS(rule, production.getLeftArrows(), nodes, false);
		findEReferencesDArrowsLHS_RHS(rule, production.getRightArrows(), nodes, false);
		
		rule.setInjectiveMatching(false);
		rule.setCheckDangling(false);
		return rule;
	}
	
	private void map_lhs_rhs_parameter(Production production, String dNodeType, String parameter, DElement dElement) {
	
		if(hasTraceObject(dElement)){
			DNode dNode = (DNode) dElement;
			for(int i = 0;i<dNode.getDIncomings().size();i++){
				if(dNode.getDIncomings().get(i).getName().startsWith("trace")){
					DNode traceNode = dNode.getDIncomings().get(i).getDSource();
					for(int j = 0;j<traceNode.getDOutgoings().size();j++){
						if(traceNode.getDOutgoings().get(j).getName().contains("Source")){
							Node node = traces.get(traceNode.getDOutgoings().get(j).getDTarget().getNode().getId());
							System.out.println("Node " + node.getName());
							Attribute attribute = henshinFac.createAttribute(node, specificationPackage.getNode_Name(), parameter);
							attribute.setAction(new Action(Type.PRESERVE));
						}
					}
				}
			}
		}
	}
	
	private void insertTraces(HashMap<String, DNode> insertTraces, Rule rule){
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
	}
	
	private boolean hasTraceObject(DElement dElement){
		if(dElement instanceof DNode){
			DNode dNode = (DNode) dElement;
			for(int i = 0;i<dNode.getDIncomings().size();i++){
				if(dNode.getDIncomings().get(i).getTypeName().startsWith("traceTarget")){
					System.out.println("HAR TRACE");
					return true;
					
				}
			}
		}
		return false;
	}
	
	private DNode getCorrespondType(String dNodeType){
		DNode correspondType = null;
		for(DNode correspondNode : correspond.values()){
			if(correspondNode.getTypeName().equals(BRIDGEELEMENT)){
				for(int j = 0; j<correspondNode.getDOutgoings().size();j++){
					if(correspondNode.getDOutgoings().get(j).getDTarget().getTypeName().equals(dNodeType)){
						correspondType = correspondNode;
					}
				}
			}
		}
		return correspondType;
	}
	
	private boolean hasCorrespondancePart(String type) {
		for(DNode node : correspond.values()){
			if(node.getTypeName().equals(type)){
				if(!node.getDIncomings().isEmpty()){
					return true;
				}
				else{
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
