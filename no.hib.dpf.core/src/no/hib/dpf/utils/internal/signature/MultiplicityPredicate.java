/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.utils.internal.signature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.utils.DPFCoreUtil;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MultiplicityPredicate extends AbstractSingleArrowPredicate {

	public MultiplicityPredicate() {
		super(ARROW_MULTIPLICITY, "min:0;max:1");
	}

	public boolean check(Map<String, String> maps, Graph graph, Map<Node, List<Node>> nodeMap,
			Map<Arrow, List<Arrow>> arrowMap) {
		int min, max;
		try{
			min = Integer.parseInt(maps.get("min"));
			if(maps.get("max").equals("*"))
				max = -1;
			else
				max = Integer.parseInt(maps.get("max"));
		}catch(NumberFormatException e){
			DPFCoreUtil.logError(e);
			return true;
		}
		List<Arrow> arrows = arrowMap.get(graph.getArrowByName("XY"));
		Map<Node, Integer> record = new HashMap<Node, Integer>();
		if(arrows != null) {
			for (Arrow arrow : arrows) {
				Node source = arrow.getSource();
				Integer times = record.get(source);
				record.put(source, times == null ? 1 : times + 1); 
			}
		}
		List<Node> nodes = nodeMap.get(graph.getNodeByName("X"));
		if(nodes != null){
			for(Node node : nodes)
				if(!record.containsKey(node))
					record.put(node, 0);
		}
		boolean result = true;
		for(Entry<Node, Integer>  entry : record.entrySet()){
			Integer value = entry.getValue();
			if(value==0 && value == min)
				result=true;
			else
				if(value < min || (max != -1 && value > max)){
					System.out.println(entry.getKey().getName() + " has violates Multi[" + min + "," + max + "] constraints. It has " + value + " outgoings.");
					result = false;
				}
		}
		return result;
	}

} 
