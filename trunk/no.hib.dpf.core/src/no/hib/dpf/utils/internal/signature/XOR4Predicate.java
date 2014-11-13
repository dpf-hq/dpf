package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class XOR4Predicate extends AbstractBasePredicate {

	public XOR4Predicate() {
		super(XOR4, null, "X,Y1,Y2,Y3,Y4", "XY1:X:Y1,XY2:X:Y2,XY3:X:Y3,XY4:X:Y4,");
	}

	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 
		Map<Node, List<Arrow>> sourceWithNode = new HashMap<Node, List<Arrow>>();
		Map<Node, List<Arrow>> violated = new HashMap<Node, List<Arrow>>();
		List<Node> visitedZ = new ArrayList<Node>();
		for (int i = 1; i < 5; i++) {
			List<Arrow> zx = arrowMap.get(shape.getArrowByName("XY" + i));
			if(zx != null){ 
				for(Arrow arrow : zx){
					Node source = arrow.getSource();
					if(!visitedZ.contains(source)) 
						visitedZ.add(source);
					List<Arrow> value = sourceWithNode.containsKey(source) ? sourceWithNode.get(source) : new ArrayList<Arrow>();
					if(!value.isEmpty())
						violated.put(source, value);
					value.add(arrow); 
					sourceWithNode.put(source, value);
				}
			}
		}
		List<Node> zNodes = nodeMap.get(shape.getNodeByName("X"));
		if(zNodes != null){
			for(Node node : zNodes)
				if(!visitedZ.contains(node)) violated.put(node, null);
		}
		if(violated.size() == 0) return true;
		for(Entry<Node, List<Arrow>> entry : violated.entrySet()){
			System.out.println(entry.getKey().getName() + " violates XOR4 constraint");
			if(entry.getValue() == null){
				System.out.println("It has no outgoing arrows which has type homophomism to XY1, XY2, XY3 or XY4");
			}else{
				System.out.println("It has multiply typed outgoing arrows:");
				for(Arrow arrow : entry.getValue())
					System.out.println(arrow.getSource().getName() + "-->" + arrow.getTarget().getName());
			}
		}
		return false; 
	}
}
