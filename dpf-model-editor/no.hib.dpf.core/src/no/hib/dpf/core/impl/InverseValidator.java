package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class InverseValidator extends SemanticValidatorImpl {
	
	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		for (Node aNode : stuckedNodes) 
			if (!canReturn(aNode)) 
				return false;
		return true;
	}
	
	private boolean canReturn(Node aNode) {
		for (Arrow outgoing : aNode.getOutgoings()) {
			boolean gotBack = false;
			for (Arrow incoming : outgoing.getTarget().getOutgoings()) {
				if (incoming.getTarget().equals(aNode)) {
					gotBack = true;
				}
			}
			if (!gotBack) {
				return false;
			}
		}
		return true;
	}

}
