package no.hib.dpf.transform.util;

import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.transform.ExSpecification;
import no.hib.dpf.transform.TransformFactory;

import org.eclipse.emf.common.util.EMap;

public class TranformUtils {
	public static final CopyResult combine(Specification source, Specification target){
		ExSpecification result = TransformFactory.eINSTANCE.createExSpecification();
		GraphHomomorphism map = CoreFactory.eINSTANCE.createGraphHomomorphism();
		GraphHomomorphism typeMap = null;
		Specification sMeta = source.getType();
		Specification tMeta = target.getType();
		if(sMeta == tMeta || sMeta.getMetaFile().equals(tMeta.getMetaFile())){
			result.setType(sMeta);
		}
		else{
			CopyResult copied = combine(source, target);
			result.setType(copied.specification);
			typeMap = copied.mapping;
		}
		combineGraph(typeMap, map, result.getGraph(), source.getGraph());
		combineGraph(typeMap, map, result.getGraph(), target.getGraph());
		combineConstraint(map, result, source);
		combineConstraint(map, result, target);
		return new CopyResult(result, map);
	}

	private static void combineConstraint(GraphHomomorphism map, Specification result, Specification source) {
		for(Constraint constraint : source.getConstraints()){
			Constraint copied = CoreFactory.eINSTANCE.createConstraint();
			copied.setId(constraint.getId());
			copied.setParameters(constraint.getParameters());
			copied.setPredicate(constraint.getPredicate());
			GraphHomomorphism hom = constraint.getMappings();
			GraphHomomorphism copiedHom = CoreFactory.eINSTANCE.createGraphHomomorphism();
			for(Map.Entry<Node, Node> entry : hom.getNodeMapping())
				copiedHom.getNodeMapping().put(entry.getKey(), map.getNodeMapping().get(entry.getValue()));
					for(Map.Entry<Arrow, Arrow> entry : hom.getArrowMapping())
						copiedHom.getArrowMapping().put(entry.getKey(), map.getArrowMapping().get(entry.getValue()));
			copied.setMappings(copiedHom);
			
			for(Node node : constraint.getNodes()){
				copied.getNodes().add(map.getNodeMapping().get(node));
			}
			for(Arrow arrow : constraint.getArrows()){
				copied.getArrows().add(map.getArrowMapping().get(arrow));
			}
		}
		
	}

	private static void combineGraph(GraphHomomorphism typeMap, GraphHomomorphism map, Graph copiedGraph, Graph graph) {
		for(Arrow arrow : graph.getArrows()){
			Node copiedS = copy(typeMap == null ? null : typeMap.getNodeMapping(), map.getNodeMapping(), copiedGraph, arrow.getSource());
			Node copiedT = copy(typeMap == null ? null : typeMap.getNodeMapping(), map.getNodeMapping(), copiedGraph, arrow.getTarget());
			copy(typeMap == null ? null : typeMap.getArrowMapping(), map.getArrowMapping(), copiedGraph, arrow, copiedS, copiedT);
		}
		for(Node node : graph.getNodes())
			if(map.getNodeMapping().get(node) == null){
				Node copied = copy(typeMap == null ? null : typeMap.getNodeMapping(), node);
				copiedGraph.addNode(copied);
				map.getNodeMapping().put(node, copied);
			}
	}

	private static void copy(EMap<Arrow, Arrow> type, EMap<Arrow, Arrow> map, Graph graph, Arrow arrow, Node copiedS, Node copiedT) {
		Arrow copied = copy(type == null ? null : type, arrow);
		copied.setSource(copiedS);
		copied.setTarget(copiedT);
		graph.addArrow(copied);
		map.put(arrow, copied);
	}


	private static Node copy(EMap<Node, Node> type, EMap<Node, Node> map, Graph graph, Node node) {
		Node result = map.get(node);
		if(result == null){
			result = copy(type == null ? null : type, node);
			graph.addNode(result);
			map.put(node, result);
		}
		return result;
	}
	private static Arrow copy(EMap<Arrow, Arrow> arrowMap, Arrow arrow) {
		Arrow result = CoreFactory.eINSTANCE.createArrow();
		result.setId(new String(arrow.getId()));
		result.setName(new String(arrow.getName()));
		result.setTypeArrow(arrowMap == null ? arrow.getTypeArrow() : arrowMap.get(arrow));
		return result;
	}

	private static Node copy(EMap<Node, Node> nodeMap, Node node) {
		Node result = CoreFactory.eINSTANCE.createNode();
		result.setId(new String(node.getId()));
		result.setName(new String(node.getName()));
		result.setTypeNode(nodeMap == null ? node.getTypeNode() : nodeMap.get(node));
		return result;
	}
}
class CopyResult{
	public CopyResult(Specification result, GraphHomomorphism map) {
		specification = result;
		mapping = map;
	}
	public Specification specification;
	public GraphHomomorphism mapping;
}
