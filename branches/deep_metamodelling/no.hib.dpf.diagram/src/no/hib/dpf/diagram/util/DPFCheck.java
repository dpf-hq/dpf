package no.hib.dpf.diagram.util;

import static no.hib.dpf.diagram.util.DPFDiagramConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.diagram.util.DPFDiagramConstants.REFLEXIVE_TYPE_DARROW;
import static no.hib.dpf.diagram.util.DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH;
import static no.hib.dpf.diagram.util.DPFDiagramConstants.REFLEXIVE_TYPE_DNODE;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
//Check the dpf model. Only use for test
public class DPFCheck {
	
	private static void checkNode(Node node) {
		if(node != DPFCoreConstants.REFLEXIVE_TYPE_NODE){
			Node type = node.getTypeNode();
			Assert.isNotNull(type);
			checkNode(type);
		}
	}
	
	private static void checkDNode(DNode dNode) {
		if(dNode != REFLEXIVE_TYPE_DNODE){
			DNode type = dNode.getDType();
			Assert.isNotNull(dNode.getNode());
			Assert.isNotNull(type);
			Assert.isTrue(type.getNode() == dNode.getNode().getTypeNode());
			checkDNode(type);
			checkNode(type.getNode());
			checkNode(dNode.getNode());
		}
	}

	private static void checkArrow(Arrow arrow) {
		if(arrow != DPFCoreConstants.REFLEXIVE_TYPE_ARROW){
			Arrow type = arrow.getTypeArrow();
			Assert.isNotNull(type);
			Assert.isTrue(arrow.getSource() != null || arrow.getTarget() == null);
			if(arrow.getSource() != null){
				Assert.isTrue(arrow.getSource().getTypeNode() == type.getSource());
				Assert.isTrue(arrow.getTarget().getTypeNode() == type.getTarget());
				checkNode(type.getSource());
				checkNode(type.getTarget());
			}
			checkArrow(type);
		}
	}

	private static void checkDArrow(DArrow dArrow) {
		if(dArrow != REFLEXIVE_TYPE_DARROW){
			DArrow type = dArrow.getDType();
			Assert.isNotNull(dArrow.getArrow());
			Assert.isNotNull(type);
			Assert.isTrue(type.getArrow() == dArrow.getArrow().getTypeArrow());
			Assert.isTrue(dArrow.getDSource() != null || dArrow.getDTarget() == null);
			if(dArrow.getDSource() != null){
				Assert.isTrue(dArrow.getDSource().getNode() == dArrow.getArrow().getSource());
				Assert.isTrue(dArrow.getDTarget().getNode() == dArrow.getArrow().getTarget());
			}
			checkDArrow(type);
			checkArrow(type.getArrow());
			checkArrow(dArrow.getArrow());
		}
	}

	private static void checkSpecification(Specification specification){
		if(specification != DPFCoreConstants.REFLEXIVE_SPECIFICATION){
			Specification type = specification.getType();
			Assert.isNotNull(type);
			checkSpecification(type);
			Assert.isNotNull(specification.getGraph());
			Assert.isTrue(specification.getType().getGraph() == specification.getGraph().getType());
			checkGraph(specification.getGraph());
		}
	}

	private static void checkDGraphWithGraph(DGraph dGraph, Graph graph){
		Assert.isTrue(dGraph.getGraph() == graph);
		for(DNode dNode : dGraph.getDNodes())
			graph.getNodes().contains(dNode.getNode());
		for(DArrow dArrow : dGraph.getDArrows())
			graph.getArrows().contains(dArrow.getArrow());
	}
	
	public static void checkDSpecification(DSpecification dSpecification){
		if(dSpecification != REFLEXIVE_DSPECIFICATION){
			DSpecification type = dSpecification.getDType();
			Assert.isNotNull(type);
			Assert.isNotNull(dSpecification.getSpecification());
			Assert.isTrue(type.getSpecification() == dSpecification.getSpecification().getType());
			Assert.isTrue(type.getDGraph() == dSpecification.getDGraph().getDType());
			checkDSpecification(type);
			checkSpecification(dSpecification.getSpecification());
			checkDGraph(dSpecification.getDGraph());
			checkDGraphWithGraph(dSpecification.getDGraph(), dSpecification.getSpecification().getGraph());
		}

	}

	private static void checkGraph(Graph graph) {
		if(graph != DPFCoreConstants.REFLEXIVE_TYPE_GRAPH){
			Graph type = graph.getType();
			Assert.isNotNull(type);
			for(Node node : graph.getNodes())
				checkNode(node);
			for(Arrow arrow : graph.getArrows())
				checkArrow(arrow);
			checkGraph(type);
		}
	}

	private static void checkDGraph(DGraph dGraph) {
		if(dGraph != REFLEXIVE_TYPE_DGRAPH){
			DGraph type = dGraph.getDType();
			Assert.isNotNull(dGraph.getGraph());
			Assert.isNotNull(type != null);
			checkDGraph(type);
			for(DArrow dArrow : dGraph.getDArrows())
				checkDArrow(dArrow);
			for(DNode dNode : dGraph.getDNodes())
				checkDNode(dNode);
			checkGraph(dGraph.getGraph());
		}
	}




}
