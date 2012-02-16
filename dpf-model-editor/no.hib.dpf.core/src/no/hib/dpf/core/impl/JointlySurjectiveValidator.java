package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class JointlySurjectiveValidator  extends SemanticValidatorImpl {

	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		if (stuckedArrows.size() != (stuckedNodes.size() - 1)) {
			return false;
		}
		if (stuckedNodes.size() == 1) {
			return false;
		}
		int nodesWithIncomingArrowsCount = 0;
		Node nodeWithOnlyIncoming = null;
		for (Node node : stuckedNodes) {
			if (node.getOutgoings().size() == 0) {
				nodesWithIncomingArrowsCount++;
				nodeWithOnlyIncoming = node;
			} else if (node.getOutgoings().size() != 1) {
				return false;
			}
		}
		if (nodesWithIncomingArrowsCount != 1) {
			return false;
		}
		for (Node node : stuckedNodes) {
			if (!node.equals(nodeWithOnlyIncoming)) {
				if (node.getArrowto(nodeWithOnlyIncoming) == null) {
					return false;
				}
			}
		}
		return true;
	}
}
