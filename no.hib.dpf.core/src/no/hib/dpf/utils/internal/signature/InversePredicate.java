package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;


public class InversePredicate extends AbstractBasePredicate {
	
	public InversePredicate() {
		super(INVERSE, null, "X,Y", "XY:X:Y, YX:Y:X");
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
	public boolean check(Map<String, String> paras, Graph shape,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		boolean result = true;
		List<Node> xNodes = nodeMap.get(shape.getNodeByName("X"));
		for (Node Node : xNodes)
			if (!canReturn(Node))
				result=false;
		System.out.print("result ="+result+"\n");
		return result;
	}

}
