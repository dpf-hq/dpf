package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class IrreflexivePredicate extends AbstractBasePredicate {
	
	public IrreflexivePredicate() {
		super("irref", null, "X", "XY:X:X");
	}

	public boolean check(Map<String, String> maps, Graph shape, Map<Node, List<Node>> nodeMap,
			Map<Arrow, List<Arrow>> arrowMap) {
		List<Arrow> violated = new ArrayList<Arrow>();
		List<Arrow> xx = arrowMap.get(shape.getArrowByName("XY"));
		if (xx != null) 
			for (Arrow arrow : xx)
				if (arrow.getTarget() == arrow.getSource())
					violated.add(arrow);
		if (violated.size() == 0)
			return true;
		for (Arrow entry : violated)
			System.out.println(entry.getName()
					+ " violates Irreflexive constraint. "
					+ entry.getSource().getName() + " goes back to itself.");
		return false;
	}

}
