package no.hib.dpf.editor;

import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Point;

public class GenerateDiagramFromModel {
	private static final int START_X = DNode.DEFAULT_DIMENSION.width, 
			START_Y = DNode.DEFAULT_DIMENSION.height, 
			NEXT_X = 2 * START_X, NEXT_Y = 2 * START_Y;

	public DSpecification result = null;
	Map<Node, DNode> nodeMaps = new HashMap<Node, DNode>();
	Map<Arrow, DArrow> arrowMaps = new HashMap<Arrow, DArrow>();

	public GenerateDiagramFromModel(Specification specification, DSpecification dType){
		Assert.isNotNull(dType);
		result = DiagramFactory.eINSTANCE.createDSpecification();
		result.setSpecification(specification);
		result.setDType(dType);
		DGraph dGraph = createDGraphFromGraph(specification.getGraph(), dType.getDGraph());
		result.setDGraph(dGraph);
	}

	private DGraph createDGraphFromGraph(Graph graph, DGraph dType){
		DGraph dGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		dGraph.setGraph(graph);
		dGraph.setDType(dType);
		boolean isTypeReflexive = dType == DPFConstants.REFLEXIVE_TYPE_DGRAPH;
		Map<String, DNode> typeMap = new HashMap<String, DNode>();
		if(!isTypeReflexive)
			for(DNode dNode : dType.getDNodes()){
				if(dNode instanceof DConstraintNode)
					continue;
				typeMap.put(dNode.getNode().getId(), dNode);
			}
		int x = START_X, y = START_Y;
		int column = (int) Math.sqrt(graph.getNodes().size());
		for(Node node : graph.getNodes()){
			DNode dNode = createDNodeFromNode(node, isTypeReflexive ? DPFConstants.REFLEXIVE_TYPE_DNODE : typeMap.get(node.getTypeNode().getId()));
			dNode.setLocation(new Point(x, y));
			x += NEXT_X;
			if(column < x / NEXT_X ) {
				x = START_X;
				y += NEXT_Y;
			}
			dGraph.getDNodes().add(dNode);
			nodeMaps.put(node, dNode);
		}
		Map<String, DArrow> typeArrowMap = new HashMap<String, DArrow>();
		for(DArrow dArrow : dType.getDArrows())
			typeArrowMap.put(dArrow.getArrow().getId(), dArrow);
		for(Arrow arrow : graph.getArrows()){
			DArrow dArrow = createDArrowFromArrow(arrow, nodeMaps.get(arrow.getSource()), nodeMaps.get(arrow.getTarget()), 
					isTypeReflexive ? DPFConstants.REFLEXIVE_TYPE_DARROW : typeArrowMap.get(arrow.getTypeArrow().getId()));
			arrowMaps.put(arrow, dArrow);
			dGraph.getDArrows().add(dArrow);
		}
		return dGraph;
	}
	private DArrow createDArrowFromArrow(Arrow arrow, DNode source, DNode target, DArrow dType) {
		DArrow result = DiagramFactory.eINSTANCE.createDArrow();
		result.setArrow(arrow);
		result.setDType(dType);
		result.setDSource(source);
		result.setDTarget(target);
		result.setNameOffset(DiagramFactory.eINSTANCE.createDefaultDOffset());
		return result;
	}

	private DNode createDNodeFromNode(Node node, DNode dType){
		DNode result = DiagramFactory.eINSTANCE.createDNode();
		result.setNode(node);
		result.setDType(dType);
		result.setLocation(new Point());
		result.setSize(DNode.DEFAULT_DIMENSION);;
		return result;
	}

	public DNode getDNode(Node node) {
		return nodeMaps.get(node);
	}

	public DArrow getDArrow(Arrow arrow) {
		return arrowMaps.get(arrow);
	}
}
