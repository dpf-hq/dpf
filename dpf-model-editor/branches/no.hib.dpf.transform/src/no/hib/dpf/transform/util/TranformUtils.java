package no.hib.dpf.transform.util;

import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.transform.CopiedArrow;
import no.hib.dpf.transform.CopiedConstraint;
import no.hib.dpf.transform.CopiedNode;
import no.hib.dpf.transform.CopiedType;
import no.hib.dpf.transform.TransformFactory;

import org.eclipse.emf.common.util.EMap;

public class TranformUtils {
	public static final CopyResult combine(Specification source, Specification target){
		Specification result = CoreFactory.eINSTANCE.createSpecification();
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
		combineGraph(typeMap, map, result.getGraph(), source.getGraph(), CopiedType.SOURCE);
		combineGraph(typeMap, map, result.getGraph(), target.getGraph(), CopiedType.TARGET);
		combineConstraint(map, result, source, CopiedType.SOURCE);
		combineConstraint(map, result, target, CopiedType.TARGET);
		return new CopyResult(result, map);
	}

	private static void combineConstraint(GraphHomomorphism map, Specification result, Specification source, CopiedType target) {
		for(Constraint constraint : source.getConstraints()){
			CopiedConstraint copied = TransformFactory.eINSTANCE.createCopiedConstraint();
			copied.setId(constraint.getId());
			copied.setParameters(constraint.getParameters());
			copied.setPredicate(constraint.getPredicate());
			copied.setCopiedType(target);
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

	private static void combineGraph(GraphHomomorphism typeMap, GraphHomomorphism map, Graph copiedGraph, Graph graph, CopiedType source) {
		for(Arrow arrow : graph.getArrows()){
			Node copiedS = copy(typeMap == null ? null : typeMap.getNodeMapping(), map.getNodeMapping(), copiedGraph, arrow.getSource(), source);
			Node copiedT = copy(typeMap == null ? null : typeMap.getNodeMapping(), map.getNodeMapping(), copiedGraph, arrow.getTarget(), source);
			copy(typeMap == null ? null : typeMap.getArrowMapping(), map.getArrowMapping(), copiedGraph, arrow, copiedS, copiedT, source);
		}
		for(Node node : graph.getNodes())
			if(map.getNodeMapping().get(node) == null){
				Node copied = copy(typeMap == null ? null : typeMap.getNodeMapping(), node);
				copiedGraph.addNode(copied);
				map.getNodeMapping().put(node, copied);
			}
	}

	private static void copy(EMap<Arrow, Arrow> type, EMap<Arrow, Arrow> map, Graph graph, Arrow arrow, Node copiedS, Node copiedT, CopiedType source) {
		CopiedArrow copied = copy(type == null ? null : type, arrow);
		copied.setSource(copiedS);
		copied.setTarget(copiedT);
		graph.addArrow(copied);
		copied.setCopiedType(source);
		map.put(arrow, copied);
	}


	private static Node copy(EMap<Node, Node> type, EMap<Node, Node> map, Graph graph, Node node, CopiedType source) {
		CopiedNode result = (CopiedNode) map.get(node);
		if(result == null){
			result = copy(type == null ? null : type, node);
			result.setCopiedType(source);
			graph.addNode(result);
			map.put(node, result);
		}
		return result;
	}
	private static CopiedArrow copy(EMap<Arrow, Arrow> arrowMap, Arrow arrow) {
		CopiedArrow result = TransformFactory.eINSTANCE.createCopiedArrow();
		result.setId(new String(arrow.getId()));
		result.setName(new String(arrow.getName()));
		result.setTypeArrow(arrowMap == null ? arrow.getTypeArrow() : arrowMap.get(arrow));
		return result;
	}

	private static CopiedNode copy(EMap<Node, Node> nodeMap, Node node) {
		CopiedNode result = TransformFactory.eINSTANCE.createCopiedNode();
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
