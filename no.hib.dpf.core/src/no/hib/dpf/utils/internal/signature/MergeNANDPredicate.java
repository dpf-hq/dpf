package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;


public class MergeNANDPredicate  extends AbstractBasePredicate {
	public MergeNANDPredicate() {
		super(MERGE_NOT_AND, null, "X,Y,Z", "XZ:X:Z, YZ:Y:Z");
	}
	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 
		Map<Node, List<Arrow>> sourceWithX = new HashMap<Node, List<Arrow>>();
		Map<Node, List<Arrow>> violated = new HashMap<Node, List<Arrow>>();
		List<Arrow> xz = arrowMap.get(shape.getArrowByName("XZ"));
		if(xz != null){
			for(Arrow arrow : xz){
				Node target = arrow.getTarget();
				List<Arrow> value = sourceWithX.containsKey(target) ? sourceWithX.get(target) : new ArrayList<Arrow>();
				value.add(arrow);
				sourceWithX.put(target, value);
			}
		}
		List<Arrow> yz = arrowMap.get(shape.getArrowByName("YZ"));
		if(yz != null){
			for(Arrow arrow : yz){
				Node target = arrow.getTarget();
				if(sourceWithX.containsKey(target)){
					List<Arrow> value = violated.containsKey(target) ? violated.get(target) : new ArrayList<Arrow>();
					if(value.isEmpty())
						value.addAll(sourceWithX.get(target));
					value.add(arrow);
					violated.put(target, value);
				}
			}
		}
		if(violated.size() == 0)
			return true;
		for(Entry<Node, List<Arrow>> entry : violated.entrySet()){
			System.out.println(entry.getKey().getName() + " violates Merge-NAND constraint");
			System.out.println("It has multiply typed incoming arrows:");
		}
		return false; 
	} 
}
