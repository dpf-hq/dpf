package no.hib.dpf.transform.rules;

import java.io.File;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.henshin.model.impl.HenshinFactoryImpl;
import org.eclipse.emf.henshin.model.impl.HenshinPackageImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;


public class TransformModule {
	
	private Transform transform = null;
	private EPackage sourceMetaModel = null;
	private EPackage targetMetaModel = null;
	private HenshinResourceSet resourceSet = null;
	private HenshinFactory henshinFac = HenshinFactoryImpl.eINSTANCE;
	
	public TransformModule(Transform transform, String sourcePath, HenshinResourceSet resourceSet){
		this.resourceSet = resourceSet;
		this.transform = transform;
		
		URI modelUri = URI.createFileURI(new File(sourcePath)
			.getAbsolutePath());
		Resource resourceModel = resourceSet.getResource(modelUri, true);
		sourceMetaModel = (EPackage) resourceModel.getContents().get(0);
		resourceSet.getResources().add(resourceModel);
		
	}
	public Module createModule(){
		Module mainModule = henshinFac.createModule();
		
		if(sourceMetaModel != null && sourceMetaModel instanceof EPackage){
			mainModule.getImports().add(sourceMetaModel);
		}
		for(int i = 0;i<transform.getRules().size();i++){
			mainModule.getUnits().add(generateRule(transform.getRules().get(i)));
		}
		
		return mainModule;
	}
	private Rule generateRule(Production production) {
		Rule rule = henshinFac.createRule(production.getName());
		rule.setActivated(true);
		
		Graph lhs = rule.getLhs();
		Graph rhs = rule.getRhs();
		
		//Create Nodes on LHS
		for(int i = 0; i<production.getLeftNodes().size();i++){
			String dNodeType = production.getLeftNodes().get(i).getDType().getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			henshinFac.createNode(lhs, nodeType, production.getLeftNodes().get(i).getNode().getName());
		}
		//Create Arrows LHS
		for(int i = 0;i<production.getLeftArrows().size();i++){
			String dArrowType = production.getLeftArrows().get(i).getDType().getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			henshinFac.createNode(lhs, arrowType, production.getLeftArrows().get(i).getArrow().getName());
		}
		//Create Nodes on RHS
		for(int i = 0; i<production.getRightNodes().size();i++){
			String dNodeType = production.getRightNodes().get(i).getDType().getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			henshinFac.createNode(rhs, nodeType, production.getRightNodes().get(i).getName());
		}
		//Create Arrows on RHS
		for(int i = 0;i<production.getRightArrows().size();i++){
			String dArrowType = production.getRightArrows().get(i).getDType().getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			henshinFac.createNode(rhs, arrowType, production.getRightArrows().get(i).getArrow().getName());
		}
		//Determing common nodes
		for(int i = 0; i<production.getCommonNodes().size();i++){
			String dNodeType = production.getCommonNodes().get(i).getDType().getTypeName();
			EClass nodeType = (EClass) sourceMetaModel.getEClassifier(dNodeType);
			
			Node lhs_preserve = henshinFac.createNode(lhs, nodeType, production.getCommonNodes().get(i).getName());
			Node rhs_preserve = henshinFac.createNode(rhs, nodeType, production.getCommonNodes().get(i).getName());
			
			Mapping m1 = henshinFac.createMapping(lhs_preserve, rhs_preserve);
			rule.getMappings().add(m1);
		}
		//Determing common arrows
		for(int i = 0; i<production.getCommonArrows().size();i++){
			String dArrowType = production.getCommonArrows().get(i).getDType().getTypeName();
			EClass arrowType = (EClass) sourceMetaModel.getEClassifier(dArrowType);
			
			Node lhs_preserve = henshinFac.createNode(lhs, arrowType, production.getCommonArrows().get(i).getName());
			Node rhs_preserve = henshinFac.createNode(rhs, arrowType, production.getCommonArrows().get(i).getName());
			
			Mapping m2 = henshinFac.createMapping(lhs_preserve, rhs_preserve);
			rule.getMappings().add(m2);
		}
		//Create Edges
		
		
		return rule;
	}
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
