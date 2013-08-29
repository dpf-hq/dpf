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
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.TransformationUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.impl.HenshinFactoryImpl;
import org.eclipse.emf.henshin.model.impl.HenshinPackageImpl;
import org.eclipse.emf.henshin.model.impl.SequentialUnitImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;


public class CopyOfTransformModule {
	
	private Transform transform = null;
	private EPackage sourceMetaModel = null;
	private EPackage targetMetaModel = null;
	private HenshinResourceSet resourceSet = null;
	private HenshinFactory henshinFac = HenshinFactoryImpl.eINSTANCE;
	
	public CopyOfTransformModule(Transform transform, HenshinResourceSet resourceSet){
		this.resourceSet = resourceSet;
		this.transform = transform;
		URI sourceModelUri = URI.createURI(resourceSet.getBaseDir() +
			transform.getSourceMetaModel().getSpecification().eResource().getURI().lastSegment().replace(".xmi", ".ecore"));
		System.out.println(sourceModelUri);
		Resource sourceModel = resourceSet.getResource(sourceModelUri, true);
		sourceMetaModel = (EPackage) sourceModel.getContents().get(0);
		resourceSet.getResources().add(sourceModel);
		System.out.println("Her + " + sourceMetaModel.getEClassifiers());
		
		URI targetModelUri = URI.createURI(resourceSet.getBaseDir() +
				transform.getSourceMetaModel().getSpecification().eResource().getURI().lastSegment().replace(".xmi", ".ecore"));
		System.out.println(targetModelUri);
		Resource targetModel = resourceSet.getResource(targetModelUri, true);
		targetMetaModel = (EPackage) targetModel.getContents().get(0);
		resourceSet.getResources().add(targetModel);
		System.out.println("Her + " + targetMetaModel.getEClassifiers());
		
	}
	public Module createModule(){
		Module mainModule = henshinFac.createModule();
		
		if(sourceMetaModel != null && sourceMetaModel instanceof EPackage){
			mainModule.getImports().add(sourceMetaModel);
		}
		if(targetMetaModel != null && targetMetaModel instanceof EPackage && targetMetaModel!=sourceMetaModel){
			mainModule.getImports().add(targetMetaModel);
		}
		
		mainModule.getUnits().add(generateInitialRule(mainModule));
		
		for(int i = 0;i<transform.getRules().size();i++){
			mainModule.getUnits().add(generateRule(transform.getRules().get(i)));
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

	public Rule generateInitialRule(Module module){
		Rule rule = henshinFac.createRule("initialiseSpecificationAndGraph");
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		String path = "file:/C:/Users/Petter/workspace/no.hib.dpf.core/model/Metamodel.ecore";
		URI coreModelURI = URI.createURI(path);
		System.out.println(coreModelURI);
		Resource coreModel = resourceSet.getResource(coreModelURI, true);
		EPackage core = (EPackage) coreModel.getContents().get(0);
		
		EClass idObject = (EClass) core.getEClassifier("IDObject");
		sourceMetaModel.getEClassifiers().add(idObject);
		
		EClass node = (EClass) core.getEClassifier("Node");
		sourceMetaModel.getEClassifiers().add(node);
		
		EClass arrow = (EClass) core.getEClassifier("Arrow");
		sourceMetaModel.getEClassifiers().add(arrow);
		
		EClass graph = (EClass) core.getEClassifier("Graph");
		sourceMetaModel.getEClassifiers().add(graph);
		
		EClass specification = (EClass) core.getEClassifier("Specification");
		sourceMetaModel.getEClassifiers().add(specification);
		
		
		String henshinModelName = "dpfSpecification1"+".ecore";
		File file = new File(TransformUtils.activeWorkingDirectory()+"/"+henshinModelName);
		if(file.exists()){
			file.delete();
		}
		resourceSet.saveEObject(sourceMetaModel, henshinModelName);
		
		
		module.getImports().add(core);
		
		EClass specificationType = (EClass) sourceMetaModel.getEClassifier("Specification");
		Node specification_lhs = henshinFac.createNode(lhs, specificationType, null);
		Node specification_rhs = henshinFac.createNode(rhs, specificationType, null);
		
		rule.getMappings().add(henshinFac.createMapping(specification_lhs, specification_rhs));
		
		EClass graphType = (EClass) sourceMetaModel.getEClassifier("Graph");
		Node graph_lhs = henshinFac.createNode(lhs, graphType, null);
		Node graph_rhs = henshinFac.createNode(rhs, graphType, null);
		
		rule.getMappings().add(henshinFac.createMapping(graph_lhs, graph_rhs));
		
		EReference ref_spec_graph = null;
		for(int i = 0;i<specificationType.getEReferences().size();i++){
			if(specificationType.getEReferences().get(i).getEReferenceType()==graphType){
				ref_spec_graph = specificationType.getEReferences().get(i);
			}
		}
		
		rule.createEdge(specification_lhs, graph_lhs, ref_spec_graph);
		rule.createEdge(specification_rhs, graph_rhs, ref_spec_graph);
		
		return rule;
	}
	private Rule generateRule(Production production) {
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		System.out.println("name "+production.getName() );
		Rule rule = henshinFac.createRule(production.getName());
		rule.setActivated(true);
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
			String dNodeType = production.getLeftNodes().get(i).getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			Node deletion = henshinFac.createNode(lhs, nodeType, null);
			//deletion.setName(production.getLeftNodes().get(i).getNode().getName());
			
			nodes.put(production.getLeftNodes().get(i).getName(), deletion);
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
	}
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
//	private void findEReferencesDArrowsLHS_RHS(EList<DArrow> dArrows, 
//			HashMap<String, Node> nodes){
//		
//		EReference ref_DArrow_DNode = null;
//		
//		for(int i = 0;i<dArrows.size();i++){
//			DNode dNode_source = dArrows.get(i).getDSource();
//			DArrow dArrow_target = dArrows.get(i);
//			Node source_DNode_Node = nodes.get(dNode_source.getName());
//			Node target_DArrow_Node = nodes.get(dArrow_target.getName());
//			EClass source = (EClass) sourceMetaModel.getEClassifier(dNode_source.getTypeName());
//			EClass target = (EClass) sourceMetaModel.getEClassifier(dArrow_target.getTypeName());
//		
//			for(int k = 0; k<source.getEReferences().size();k++){
//				if(source.getEReferences().get(k).getEReferenceType()==target){
//					ref_DArrow_DNode = source.getEReferences().get(k);
//				}
//			}
//			henshinFac.createEdge(source_DNode_Node, target_DArrow_Node, ref_DArrow_DNode);
//		}
//		for(int i = 0;i<dArrows.size();i++){
//			DArrow dArrow_source = dArrows.get(i);
//			DNode dNode_target = dArrows.get(i).getDTarget();
//			Node source_DArrow_Node = nodes.get(dArrow_source.getName());
//			Node target_DNode_Node = nodes.get(dNode_target.getName());
//			EClass source = (EClass) sourceMetaModel.getEClassifier(dArrow_source.getTypeName());
//			EClass target = (EClass) sourceMetaModel.getEClassifier(dNode_target.getTypeName());
//		
//			for(int k = 0; k<source.getEReferences().size();k++){
//				if(target.getEReferences().get(k).getEReferenceType()==source){
//					ref_DArrow_DNode = target.getEReferences().get(k);
//				}
//			}
//			henshinFac.createEdge(source_DArrow_Node, target_DNode_Node, ref_DArrow_DNode);
//		}
//	}

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
