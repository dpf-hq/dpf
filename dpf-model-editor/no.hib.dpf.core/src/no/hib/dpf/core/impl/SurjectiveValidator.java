package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class SurjectiveValidator extends SemanticValidatorImpl {
	
	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		//Invariant:
		if ((typeNodes.size() != 2) || (typeArrows.size() != 1)) {
			System.out.println(typeNodes + "break surjective constraint");
			return false;
		}

		final Arrow typeArrow = typeArrows.get(0);
		final Node targetTypeNode = typeArrow.getTarget();
		final Node sourceTypeNode = typeArrow.getSource();
		final List<Node> violateNodes = new ArrayList<Node>();
		for(Node node : stuckedNodes){
			if(node.getTypeNode() == targetTypeNode){
				boolean exist = false;
				for(Arrow arrow : node.getIncomings())
					if(arrow.getSource() != null && arrow.getSource().getTypeNode() == sourceTypeNode){
						exist = true;
						break;
					}
				if(!exist)
					violateNodes.add(node);
						
			}
		}
		if(!violateNodes.isEmpty()){
			System.out.println("Following Nodes violates Surjective constrait:");
			for(Node node : violateNodes)
				System.out.println("\t" + node.getName());
			System.out.println("They don't have any arrow typed by " + typeArrow.getName() + " coming from a node typed by " + sourceTypeNode.getName());
			System.out.println();
			return false;
		}
		return true;
}

}
