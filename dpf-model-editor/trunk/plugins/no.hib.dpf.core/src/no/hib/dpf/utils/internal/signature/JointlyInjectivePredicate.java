package no.hib.dpf.utils.internal.signature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class JointlyInjectivePredicate extends AbstractBasePredicate {

	public JointlyInjectivePredicate() {
		super("ji", null, "X,Y,Z", "XY:X:Y, XZ:X:Y");

	}

	@Override
	public boolean check(Map<String, String> paras, Graph graph,
		Map<Node, List<Node>> nodeMap, Map<Arrow, List<Arrow>> arrowMap) {
		List<Arrow> xy = arrowMap.get(shape.getArrowByName("XY"));
		List<Arrow> xz = arrowMap.get(shape.getArrowByName("XZ"));
		Map<Node, List<Arrow>> zViolated = new HashMap<Node, List<Arrow>>();
		Map<Node, List<Arrow>> yViolated = new HashMap<Node, List<Arrow>>();
		boolean result = true;
		if (xy != null) {
//			List<Arrow> yValue= new ArrayList<Arrow>();
			for (Arrow arrow : xy) {
				Node target = arrow.getTarget();
				List<Arrow> yValue = yViolated.containsKey(target) ? yViolated.get(target) : new ArrayList<Arrow>();
				yValue.add(arrow);
				yViolated.put(target, yValue);
			}

		}
		if (xz != null) {
				for (Arrow arrow : xz) {
				Node target = arrow.getTarget();
				List<Arrow> zValue = zViolated.containsKey(target) ? zViolated.get(target) : new ArrayList<Arrow>();
				zValue.add(arrow);
				zViolated.put(target, zValue);
			}
		}

		List<Node> xNodes = nodeMap.get(shape.getNodeByName("X"));

		 if (yViolated.size() == 0 && zViolated.size()==0)
		 result= true;
		
		 if (xNodes != null)
		 for (Entry<Node, List<Arrow>> xEntry : yViolated.entrySet()) {
			 if(xEntry.getValue().size() >1){
				 for(int a =0 ;a< xEntry.getValue().size()-1; a++)
						if(xEntry.getValue().get(a).getSource()!= xEntry.getValue().get(a+1).getSource()){
				        result = false;
							System.out.println(xEntry.getKey().getName()
									+ " violates Jointly Injective constraint");
							if (xEntry.getValue() == null) {
								System.out
										.println("It has no outgoing arrows which has type homophomism to XZ or YZ");
							} else {
								System.out
										.println("It has multiple outgoing arrows of same type:");
								for (Arrow arrow : xEntry.getValue())
									System.out.println(arrow.getSource()
											.getName()
											+ "-->"
											+ arrow.getTarget().getName());
							}
						}
				}
			}
		 for (Entry<Node, List<Arrow>> xEntry : zViolated.entrySet()) {
			if (xEntry.getValue().size() > 1) {
				for (int a = 0; a < xEntry.getValue().size() - 1; a++)
					if (xEntry.getValue().get(a).getSource() != xEntry
							.getValue().get(a + 1).getSource()) {
						result = false;
						System.out.println(xEntry.getKey().getName()
								+ " violates Jointly Injective constraint");
						if (xEntry.getValue() == null) {
							System.out
									.println("It has no outgoing arrows which has type homophomism to XZ or YZ");
						} else {
							System.out
									.println("It has multiple outgoing arrows of same type:");
							for (Arrow arrow : xEntry.getValue())
								System.out.println(arrow.getSource().getName()
										+ "-->" + arrow.getTarget().getName());
						}
					}
			}
		}
		return result;
	}

}
