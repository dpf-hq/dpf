package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;


public class SplitNANDPredicate  extends XORPredicate {
	public SplitNANDPredicate() {
		super();
		symbol = SPLIT_NOT_AND;
	}
	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 
		Map<Node, List<Arrow>> targetWithX = new HashMap<Node, List<Arrow>>();
		Map<Node, List<Arrow>> violated = new HashMap<Node, List<Arrow>>();
		List<Arrow> zx = arrowMap.get(shape.getArrowByName("ZX"));
		if(zx != null){
			for(Arrow arrow : zx){
				Node source = arrow.getSource();
				List<Arrow> value = targetWithX.containsKey(source) ? targetWithX.get(source) : new ArrayList<Arrow>();
				value.add(arrow);
				targetWithX.put(source, value);
			}
		}
		List<Arrow> zy = arrowMap.get(shape.getArrowByName("ZY"));
		if(zy != null){
			for(Arrow arrow : zy){
				Node source = arrow.getSource();
				if(targetWithX.containsKey(source)){
					List<Arrow> value = violated.containsKey(source) ? violated.get(source) : new ArrayList<Arrow>();
					if(value.isEmpty())
						value.addAll(targetWithX.get(source));
					value.add(arrow);
					violated.put(source, value);
				}
			}
		}
		if(violated.size() == 0)
			return true;
		for(Entry<Node, List<Arrow>> entry : violated.entrySet()){
			System.out.println(entry.getKey().getName() + " violates Split NAND constraint");
			System.out.println("It has multiply typed outgoing arrows:");
		}
		return false; 
	} 
}
