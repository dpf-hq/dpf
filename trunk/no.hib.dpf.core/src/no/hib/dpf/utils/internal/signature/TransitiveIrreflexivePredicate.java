package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class TransitiveIrreflexivePredicate extends AbstractBasePredicate {
	
	public TransitiveIrreflexivePredicate(String symbol, String parameter,
			String nodes, String edges) {
		super(symbol, parameter, nodes, edges);
		// TODO Auto-generated constructor stub
	}
//	private List<Node> getNodesWithNoIncomingEdges(List<Node> nodes) {
//		List<Node> retval = new ArrayList<Node>();
//		for (Node node : nodes) 
//			if (node.getIncomings().size() == 0) 
//				retval.add(node);
//		return retval;
//	}
//	@Override
//	public Boolean validateSemantics(EList<String> constraintParameters,
//			EList<Node> typeNodes, EList<Arrow> typeArrows,
//			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
//		if (new IrreflexiveValidator().validateSemantics(constraintParameters, typeNodes, typeArrows, stuckedNodes, stuckedArrows) == false) {
//			return false;
//		}
//		/*		
//		 * KAAAAAAHHHHNN!!!! (http://en.wikipedia.org/wiki/Topological_sorting)
//		*/	
//		//TODO need to recode, the change is not right
//		List<Node> nodesWithNoIncomingEdges = getNodesWithNoIncomingEdges(stuckedNodes);
//		while (!nodesWithNoIncomingEdges.isEmpty()) {
//			Node aNode = nodesWithNoIncomingEdges.remove(0);
//			for (Arrow outgoingArrow : aNode.getOutgoings()) {
//				Node target = outgoingArrow.getTarget();
//				stuckedArrows.remove(outgoingArrow);
//				if (target.getIncomings().size() == 0) {
//					nodesWithNoIncomingEdges.add(target);
//				}
//			}
//		}
//		return (stuckedArrows.size() == 0);	
//	}
	@Override
	public boolean check(Map<String, String> paras, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		// TODO Auto-generated method stub
		return false;
	}

}
