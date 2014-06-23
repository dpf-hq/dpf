package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class InjectivePredicate extends AbstractSingleArrowPredicate {

	public InjectivePredicate() {
		super("inj");
	}

	@Override
	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) { 

		List<Arrow> arrows = arrowMap.get(shape.getArrowByName("XY")); 
		Map<Node, List<Arrow>> violated = new HashMap<Node, List<Arrow>>();
		if(arrows != null){
			for(Arrow arrow : arrows){
				Node target = arrow.getTarget();
				List<Arrow> value = violated.containsKey(target) ? violated.get(target) : new ArrayList<Arrow>();
				value.add(arrow);
				violated.put(target, value);
			}
		}
		boolean result = true;
		for(Entry<Node, List<Arrow>> entry : violated.entrySet())
			if(entry.getValue().size() > 1){
				for(int a =0 ;a< entry.getValue().size()-1; a++)
					if(entry.getValue().get(a).getSource()!= entry.getValue().get(a+1).getSource()){
				           result = false;
				           System.out.println(entry.getKey().getName() + " violates INJECTIVE constraint");
				           System.out.println("It has multiply incoming arrows:");
				           for(Arrow arrow : entry.getValue())
				               System.out.println(arrow.getSource().getName() + "-->" + arrow.getTarget().getName());
					}
			}
		return result; 
	} 

}
