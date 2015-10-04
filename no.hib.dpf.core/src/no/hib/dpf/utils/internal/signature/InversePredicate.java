package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;


public class InversePredicate extends AbstractBasePredicate {
	
	public InversePredicate() {
		super(INVERSE, null, "X,Y", "XY:X:Y, YX:Y:X");
	}
	public boolean check(Map<String, String> paras, Graph graph, Map<Node, List<Node>> nodeMap,
			Map<Arrow, List<Arrow>> arrowMap) {
		List<Arrow> xys = arrowMap.get(graph.getArrowByName("XY"));
		List<Arrow> yxs = arrowMap.get(graph.getArrowByName("YX"));
		Map<Node, List<Node>> xy = new HashMap<Node, List<Node>>();
		if(xys != null){
			for (Arrow arrow : xys) 
				addToMapList(arrow.getSource(), arrow.getTarget(), xy);
		}
		Map<Node, List<Node>> yx = new HashMap<Node, List<Node>>();
		if(yxs != null){
			for (Arrow arrow : yxs) 
				addToMapList(arrow.getSource(), arrow.getTarget(), yx);
		}
		
		List<Node> removed = new ArrayList<Node>();
		for(Entry<Node, List<Node>> entry : xy.entrySet()){
			Node source = entry.getKey();
			List<Node> matches = new ArrayList<Node>();
			for(Node target : entry.getValue()){
				if(yx.get(target) != null && yx.get(target).contains(source))
					matches.add(target);
			}
			entry.getValue().removeAll(matches);
			if(entry.getValue().isEmpty())
				removed.add(source);
			for(Node target : matches){
				yx.get(target).remove(source);
				if(yx.get(target).isEmpty())
					yx.remove(target);
			}
		}
		for(Node remove : removed)
			xy.remove(remove);
		return xy.isEmpty() && yx.isEmpty();
	}
	public <T, U> void addToMapList(T key, U value, Map<T, List<U>> map){
		List<U> tos = map.get(key);
		if(tos == null){
			tos = new ArrayList<U>();
			tos.add(value);
			map.put(key, tos);
			return;
		}
		if(!tos.contains(value))
			tos.add(value);
	}

}
