package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class TransitiveIrreflexiveValidator extends SemanticValidatorImpl {
	
	private List<Node> getNodesWithNoIncomingEdges(List<Node> nodes) {
		List<Node> retval = new ArrayList<Node>();
		for (Node node : nodes) 
			if (node.getIncomings().size() == 0) 
				retval.add(node);
		return retval;
	}
	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		if (new IrreflexiveValidator().validateSemantics(constraintParameters, typeNodes, typeArrows, stuckedNodes, stuckedArrows) == false) {
			return false;
		}
		/*		
		 * KAAAAAAHHHHNN!!!! (http://en.wikipedia.org/wiki/Topological_sorting)
		*/	
		//TODO need to recode, the change is not right
		List<Node> nodesWithNoIncomingEdges = getNodesWithNoIncomingEdges(stuckedNodes);
		while (!nodesWithNoIncomingEdges.isEmpty()) {
			Node aNode = nodesWithNoIncomingEdges.remove(0);
			for (Arrow outgoingArrow : aNode.getOutgoings()) {
				Node target = outgoingArrow.getTarget();
				stuckedArrows.remove(outgoingArrow);
				if (target.getIncomings().size() == 0) {
					nodesWithNoIncomingEdges.add(target);
				}
			}
		}
		return (stuckedArrows.size() == 0);	
	}

}
