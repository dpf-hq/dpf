/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.utils.internal.signature;

import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.utils.DPFCoreUtil;


/**
 * The predicate specify how many instances of a node should exist.
 * For example, in metamodel, Node A has a constraint Mulit[min, max], then
 * in a valid instance, the number of the nodes which are typed by A should 
 * be >= min and <= max.   
 * @author wxlfrank
 *
 */
public class MultiplicityOnNodePredicate extends AbstractSingleNodePredicate {

	public MultiplicityOnNodePredicate() {
		super(NODE_MULTIPLICITY, "min:0;max:1");
	}

	public boolean check(Map<String, String> maps, Graph graph, Map<Node, List<Node>> nodeMap,
			Map<Arrow, List<Arrow>> arrowMap) {
		int min, max;
		try{
			min = Integer.parseInt(maps.get("min"));
			String max_string = maps.get("max");
			if(max_string.equals("*") || max_string.equals("-1"))
				max = Integer.MAX_VALUE;
			else
				max = Integer.parseInt(max_string);
		}catch(NumberFormatException e){
			DPFCoreUtil.logError(e);
			return true;
		}
		List<Node> nodes = nodeMap.get(graph.getNodeByName("X"));
		int size = nodes.size();
		boolean result = size >= min && size <= max;
		if(!result)
			System.out.println(nodes.toString() + " violates multiplicity constraint " + "[" + min + "," + max + "]");
		return result;
	}

} 
