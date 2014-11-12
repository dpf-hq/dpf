package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class XORPredicate extends AbstractBasePredicate {

	public XORPredicate() {
		super("xor", null, "X,Y,Z", "ZX:Z:X, ZY:Z:Y");
	}

	@Override
	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 
		Map<Node, List<Arrow>> targetWithX = new HashMap<Node, List<Arrow>>();
		Map<Node, List<Arrow>> violated = new HashMap<Node, List<Arrow>>();
		List<Node> visitedZ = new ArrayList<Node>();
		List<Arrow> zx = arrowMap.get(shape.getArrowByName("ZX"));
		if(zx != null){ for(Arrow arrow : zx){
				Node source = arrow.getSource();
				if(!visitedZ.contains(source)) visitedZ.add(source);
				List<Arrow> value = targetWithX.containsKey(source) ? targetWithX.get(source) : new ArrayList<Arrow>();
				value.add(arrow); targetWithX.put(source, value);
			}
		}
		List<Arrow> zy = arrowMap.get(shape.getArrowByName("ZY"));
		if(zy != null){
			for(Arrow arrow : zy){
				Node source = arrow.getSource();
				if(!visitedZ.contains(source)) visitedZ.add(source);
				if(targetWithX.containsKey(source)){
					List<Arrow> value = violated.containsKey(source) ? violated.get(source) : new ArrayList<Arrow>();
					if(value.isEmpty()) value.addAll(targetWithX.get(source));
					value.add(arrow); violated.put(source, value);
				}
			}
		}
		List<Node> zNodes = nodeMap.get(shape.getNodeByName("Z"));
		if(zNodes != null){
			for(Node node : zNodes)
				if(!visitedZ.contains(node)) violated.put(node, null);
		}
		if(violated.size() == 0) return true;
		for(Entry<Node, List<Arrow>> entry : violated.entrySet()){
			System.out.println(entry.getKey().getName() + " violates XOR constraint");
			if(entry.getValue() == null){
				System.out.println("It has no outgoing arrows which has type homophomism to ZX or ZY");
			}else{
				System.out.println("It has multiply typed outgoing arrows:");
				for(Arrow arrow : entry.getValue())
					System.out.println(arrow.getSource().getName() + "-->" + arrow.getTarget().getName());
			}
		}
		return false; 
	}
}
