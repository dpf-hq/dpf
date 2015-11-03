package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class ReflexivePredicate extends AbstractBasePredicate {

	public ReflexivePredicate() {
		super(REFLEXIVE, null, "X", "XY:X:X");
		setId("p-reflexive");
		initialIDs();
	}

	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 

		List<Arrow> arrows = arrowMap.get(shape.getArrowByName("XY")); 
		boolean result = true;
		if(arrows != null)
		for(Arrow arrow : arrows){
			if(arrow.getSource() != arrow.getTarget()){
				result = false;
				System.out.println(arrow.getName() + " violates INJECTIVE constraint. ");
				System.out.println("The source node and the target node should be the same.");
			}
		}
		return result; 
	} 

}
