package no.hib.dpf.core.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class XORValidator extends SemanticValidatorImpl {

	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		//Check invairant constraint:
		if ((typeArrows.size() != 2) || (typeNodes.size() < 1)) {
			System.out.println("breaks XOR");
			return true;
		}
		
		//Check XOR:
		final Node typeSourceNode = typeArrows.get(0).getSource();
		//HashMap for saving arrowType for each source node:
		Map<Node, List<Arrow>> violateArrows = new HashMap<Node, List<Arrow>>();
		for(Node node : stuckedNodes)
			if(node.getTypeNode() == typeSourceNode){
				boolean xor = true;
				EList<Arrow> outgoing = node.getOutgoings();
				if(outgoing.size() > 0){
					Arrow type = outgoing.get(0).getTypeArrow();
					for(Arrow arrow : node.getOutgoings())
						if(arrow.getTypeArrow() != type){
							xor = false;
							break;
						}
				}else
					xor = false;
				if(!xor)
					violateArrows.put(node, outgoing);

			}
				
		if(!violateArrows.isEmpty()){
			System.out.println("Followings violate XOR Constraint: ");
			Arrow typeArrow0 = typeArrows.get(0);
			Arrow typeArrow1 = typeArrows.get(1);
			String xor0 = typeArrow0.getName() + ": " + typeArrow0.getSource().getName() + "->" + typeArrow0.getTarget().getName();
			String xor1 = typeArrow1.getName() + ": " + typeArrow1.getSource().getName() + "->" + typeArrow1.getTarget().getName();
			for(Entry<Node, List<Arrow>> entry : violateArrows.entrySet()){
				if(entry.getValue().isEmpty())
					System.out.println("\t" + entry.getKey().getName() + " should at least have one arrow typed of " + xor0 + " or " + xor1 + " going out");
			    else{
			    	System.out.println("\tArrows following from " + entry.getKey().getName() + " break XOR constraint on " + xor0 + " and " + xor1);
			    	for(Arrow arrow : entry.getValue())
			    		System.out.println("\t\t" + arrow.getName() + ":" + arrow.getSource().getName() + "->" + arrow.getTarget().getName());
			    }
			}
			System.out.println();  	
		}
		return violateArrows.isEmpty();	
}

}
