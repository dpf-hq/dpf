package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class InversePredicate extends AbstractBasePredicate {
	
	public InversePredicate() {
		super("inv", null, "X,Y", "XY:X:Y, YX:Y:X");
	}

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

	@Override
	public boolean check(Map<String, String> paras, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		return false;
	}

}
