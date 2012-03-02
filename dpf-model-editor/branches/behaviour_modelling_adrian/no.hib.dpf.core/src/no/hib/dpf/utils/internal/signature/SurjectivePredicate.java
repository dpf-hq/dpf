package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class SurjectivePredicate extends AbstractSingleArrowPredicate {

	public SurjectivePredicate() {
		super("surj");
	}


	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 

		List<Node> yNodes = nodeMap.get(shape.getNodeByName("Y")); 
		List<Arrow> arrows = arrowMap.get(shape.getArrows().get(0)); 
		List<Node> visitedY = new ArrayList<Node>(); 
		if(arrows != null){
			for(Arrow arrow : arrows){
				if (!visitedY.contains(arrow.getTarget())) 
					visitedY.add(arrow.getTarget()); 

			}
		}		
		if (yNodes != null && visitedY.size() != yNodes.size()){
			for(Node node : yNodes){
				if(!visitedY.contains(node))
					System.out.println("Node " + node.getName() + " Violated Surjective Constraint");
			}
			return false; 
		} 
		return true; 
	} 

}
