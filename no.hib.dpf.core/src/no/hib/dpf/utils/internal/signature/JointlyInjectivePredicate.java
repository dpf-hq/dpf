package no.hib.dpf.utils.internal.signature;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class JointlyInjectivePredicate extends AbstractBasePredicate {

	public JointlyInjectivePredicate() {
		super(JOINT_INJECTIVE, null, "X,Y,Z", "XY:X:Y, XZ:X:Z");
		setId("p-joint-injective");
		initialIDs();
	}

	@Override
	public boolean check(Map<String, String> paras, Graph graph,
			Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		List<Arrow> xy = arrowMap.get(shape.getArrowByName("XY"));
		List<Arrow> xz = arrowMap.get(shape.getArrowByName("XZ"));
		Map<Node, Set<Node>> xtoy_z = new HashMap<Node, Set<Node>>();
		if (xy != null) {
			for (Arrow arrow : xy) {
				Node source = arrow.getSource(), target = arrow.getTarget();
				Set<Node> y_z = xtoy_z.containsKey(source) ? xtoy_z.get(source) : new HashSet<Node>();
				y_z.add(target);
				xtoy_z.put(source, y_z);
			}

		}
		if (xz != null) {
			for (Arrow arrow : xz) {
				Node source = arrow.getSource(), target = arrow.getTarget();
				Set<Node> y_z = xtoy_z.containsKey(source) ? xtoy_z.get(source) : new HashSet<Node>();
				y_z.add(target);
				xtoy_z.put(source, y_z);
			}

		}

		if (xtoy_z.isEmpty()) return true;

		for (Entry<Node, Set<Node>> xEntry : xtoy_z.entrySet()) {
			for (Entry<Node, Set<Node>> yEntry : xtoy_z.entrySet()) {
				if(xEntry.getKey() == yEntry.getKey()) continue;
				if(xEntry.getValue().size() != yEntry.getValue().size()) continue;
				if(xEntry.getValue().containsAll(yEntry.getValue())) return false;
			}
		}
		return true;
	}
}
