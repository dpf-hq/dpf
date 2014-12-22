package no.hib.dpf.editor.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
//import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
//import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
//import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
//import no.hib.dpf.editor.displaymodel.factories.DArrowDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
//import no.hib.dpf.editor.displaymodel.factories.DNodeDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
/**
 * 
 * @author Ole Klokkhammer
 *
 */
public class DPFModelUtils {
	
	public static DSpecification getNewDSpecification(DSpecification dtype, DSignature typeDSig) {
		DSpecification newSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		newSpec.setDType(dtype);
		newSpec.setDSignature(typeDSig);
		
		Specification spec = newSpec.getSpecification();
		if(spec != null){
//			if(spec.getType() != null){
//				spec.setMetalevel(spec.getType().getMetalevel() + 1); // increase metalevel
//			}
			
			Graph graph = spec.getGraph();
			if(graph != null){
				// update potency on the Graph
				Graph typeGraph = graph.getType();
//				if(typeGraph != null && typeGraph.eIsSet(CorePackage.Literals.DEEP_ELEMENT__POTENCY)){
//					graph.setPotency(typeGraph.getPotency() - 1);
//				}
				
				spec.setGraph(graph);
			}
			
			newSpec.setSpecification(spec);
		}
		
		return newSpec;
	}
	/**
	 * @author Ole Klokkhammer
	 * @param dPredicate
	 * @param graHomomorphism
	 * @param dnodes
	 * @param darrows
	 * @return
	 */
	public static DConstraint createDConstraint(DPredicate dPredicate, GraphHomomorphism graHomomorphism,
			EList<DNode> dnodes, EList<DArrow> darrows){
		DConstraint result = null;//DiagramFactory.eINSTANCE.createDConstraint();
		switch(dPredicate.getVisualization().getType()){
		case ARROW_LABEL:
			result = DiagramFactory.eINSTANCE.createDArrowLabelConstraint();
			((DArrowLabelConstraint)result).setOffset(DiagramFactory.eINSTANCE.createDOffset());
			break;
		case NODE_TO_ARROW:
		case NODE_TO_NODE:
		case ARROW_TO_NODE:
		case ARROW_TO_ARROW:
			result = DiagramFactory.eINSTANCE.createDGenericArrowConstraint();
			break;
		case COMPOSED:
		case ON_NODE:
			DComposedConstraint newComposedConstraint = DiagramFactory.eINSTANCE.createDComposedConstraint();
			DConstraintNode dNode = DiagramFactory.eINSTANCE.createDConstraintNode();
			//TODO get fakenode's position automatically in the future
			dNode.setSize(null);
			dNode.setLocation(null);
			dNode.setDConstraint(newComposedConstraint);
			newComposedConstraint.setFakeNode(dNode);
			if(darrows.size() == 0){
				for (int i = 0; i < dnodes.size(); i++) 
					newComposedConstraint.getChildren().add(DiagramFactory.eINSTANCE.createDGenericArrowConstraint());
			}else{
				for (int i = 0; i < darrows.size(); i++) 
					newComposedConstraint.getChildren().add(DiagramFactory.eINSTANCE.createDGenericArrowConstraint());
			}
			result = newComposedConstraint;
			break;
				default:
			break;
		}
		result.setConstraint(CoreFactory.eINSTANCE.createConstraint());
		result.getConstraint().setMappings(graHomomorphism);
		result.setDPredicate(dPredicate);
		return result;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param nodeName
	 * @param dSpecification
	 * @return
	 */
	public static DNode getDNodeFromDGraph(String nodeName, DGraph dgraph) {
		Assert.isNotNull(nodeName);
		Assert.isNotNull(dgraph);
		Graph graph = dgraph.getGraph();
		Assert.isNotNull(graph);
		
		Node node = graph.getNodeByName(nodeName);
		if(node == null){
			return null;
		}
		
		DNode dnode = dgraph.getDNode(node);
		return dnode;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param arrowName
	 * @param dSpecification
	 * @return
	 */
	public static DArrow getDArrowFromDGraph(String arrowName, DGraph dgraph) {
		Assert.isNotNull(arrowName);
		Assert.isNotNull(dgraph);
		Graph graph = dgraph.getGraph();
		Assert.isNotNull(graph);
		
		Arrow arrow = graph.getArrowByName(arrowName);
		if(arrow == null){
			return null;
		}
		
		return dgraph.getDArrow(arrow);
	}

	/**
	 * @author Ole Klokkhammer
	 * @param typeDNode
	 * @return
	 */
	public static DNode createDNode(DNode typeDNode){
		DNodeFactory nodeFactory = new DNodeFactory(typeDNode);
		return (DNode) nodeFactory.getNewObject();
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param typeDArrow
	 * @return
//	 */
//	public static DNodeDAttribute createDNodeDAttribute(DNodeDAttribute typeDNodeDAttribute){
//		Assert.isNotNull(typeDNodeDAttribute);
//		DNodeDAttributeFactory arrowFactory = new DNodeDAttributeFactory(typeDNodeDAttribute);
//		return (DNodeDAttribute) arrowFactory.getNewObject();
//	}

	/**
	 * 
	 * @param typeDArrow
	 * @return
	 */
	public static DArrow createDArrow(DArrow typeDArrow){
		Assert.isNotNull(typeDArrow);
		DArrowFactory arrowFactory = new DArrowFactory(typeDArrow);
		return (DArrow) arrowFactory.getNewObject();
	}
	
	/**
	 * 
	 * @param typeDArrowDAttribute
	 * @return
	 */
//	public static DArrowDAttribute createDArrowDAttribute(DArrowDAttribute typeDArrowDAttribute){
//		Assert.isNotNull(typeDArrowDAttribute);
//		DArrowDAttributeFactory arrowFactory = new DArrowDAttributeFactory(typeDArrowDAttribute);
//		return (DArrowDAttribute) arrowFactory.getNewObject();
//	}


	/**
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @param connectionDArrow
	 * @param targetDNode
	 */
	public static void connectDArrow(DNode sourceDNode, DArrow connectionDArrow, DNode targetDNode){
		if(sourceDNode == null || connectionDArrow == null || targetDNode == null){
			throw new NullPointerException();
		}
		
		connectionDArrow.setDSource(sourceDNode);
		connectionDArrow.setDTarget(targetDNode);
	}
	
	/**
	 * 
	 * @param sourceDArrow
	 * @param connectionDArrowDAttribute
	 * @param targetDDataNode
	 */
//	public static void connectDArrowDAttribute(DArrow sourceDArrow, DArrow connectionDArrowDAttribute, DNode targetDDataNode){
//		if(sourceDArrow == null || connectionDArrowDAttribute == null || targetDDataNode == null){
//			throw new NullPointerException();
//		}
//		
//		connectionDArrowDAttribute.setDSource(sourceDArrow);
//		connectionDArrowDAttribute.setDTarget(targetDDataNode);
//	}
	
	
	/**
	 * 
	 * @param sourceDArrow
	 * @param connectionDArrowDAttribute
	 * @param targetDDataNode
	 */
//	public static void connectDNodeDAttribute(DNode sourceDNode, DNodeDAttribute connectionDNodeDAttribute, DDataNode targetDDataNode){
//		if(sourceDNode == null || connectionDNodeDAttribute == null || targetDDataNode == null){
//			throw new NullPointerException();
//		}
//		
//		connectionDNodeDAttribute.setDSource(sourceDNode);
//		connectionDNodeDAttribute.setDTarget(targetDDataNode);
//	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @param targetDNode
	 * @return
	 */
	public static String generateArrowName(DNode sourceDNode, DArrow darrow,  DNode targetDNode){
		String sourceNodeName = sourceDNode != null ? sourceDNode.getName() : "";
		String targetNodeName = targetDNode != null ? targetDNode.getName() : "";
		String arrowtypeName = darrow != null ? darrow.getDType() != null ? darrow.getDType().getName() : "" : "";
		
		sourceNodeName = sourceNodeName.substring(0,1).toLowerCase() + sourceNodeName.substring(1);
		targetNodeName = targetNodeName.substring(0,1).toUpperCase() + targetNodeName.substring(1);
		arrowtypeName = arrowtypeName.substring(0,1).toUpperCase() + arrowtypeName.substring(1);
		
		return sourceNodeName + targetNodeName + arrowtypeName;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param darrows
	 * @param typeDConstraint
	 */
	public static void addDConstraintFromType(ArrayList<DArrow> darrows, DConstraint typeDConstraint) {
		for (DArrow dArrow : darrows) {
			//TODO
		}
	}
	

}
