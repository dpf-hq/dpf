package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class JointlySurjectiveValidator extends AbstractBasePredicate {

	public JointlySurjectiveValidator() {
		super("js", null, "X,Y,Z", " YZ:Y:Z,XZ:X:Z");
	}

	@Override
	public boolean check(Map<String, String> paras, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		Map<Node, List<Arrow>> zViolated = new HashMap<Node, List<Arrow>>();
		List<Node> visitedZ = new ArrayList<Node>();
		List<Arrow> xz = arrowMap.get(shape.getArrowByName("XZ"));
		List<Arrow> yz = arrowMap.get(shape.getArrowByName("YZ"));
		if (yz != null) {
			for (Arrow arrow : yz) {
				Node target = arrow.getTarget();
				if (!visitedZ.contains(target))
					visitedZ.add(target);
			}
		}
		if (xz != null) {
			for (Arrow arrow : xz) {
				Node target = arrow.getTarget();
				if (!visitedZ.contains(target))
					visitedZ.add(target);
			}
		}
		List<Node> zNodes = nodeMap.get(shape.getNodeByName("Z"));
		if (zNodes != null) {
			for (Node node : zNodes) {
				if (!visitedZ.contains(node))
					zViolated.put(node, null);
			}
		}
		boolean result=true;
		if (zViolated.size() == 0)
			return result;
		
		if (zNodes != null)
			for (Entry<Node, List<Arrow>> zEntry : zViolated.entrySet()) {
								System.out.println(zEntry.getKey().getName()
						+ " violates Jointly surjective constraint");
								result=false;
				if (zEntry.getValue() == null) {
					System.out
							.println("It has no incoming arrows which has type homophomism to XZ or YZ");
				} 
			}
        return result;
	}
}
