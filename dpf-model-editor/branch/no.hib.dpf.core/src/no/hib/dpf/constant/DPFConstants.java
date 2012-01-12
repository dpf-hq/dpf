package no.hib.dpf.constant;

import org.eclipse.emf.common.util.URI;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class DPFConstants {
	public static final Graph REFLEXIVE_TYPE_GRAPH = CoreFactory.eINSTANCE.createGraph();
	static{
		Node node = REFLEXIVE_TYPE_GRAPH.createNode("Node");
		REFLEXIVE_TYPE_GRAPH.createArrow("Arrow", node, node);
	}
	public static final URI DefaultSignature = URI.createPlatformResourceURI("DefaultSignature", false);
	public static final URI DefaultGraph = URI.createPlatformResourceURI("DefaultGraph.xmi", false);
	public static final String DefaultChecker = 
			"import java.util.*; \n" +
			"import no.hib.dpf.core.Arrow; \n" +
			"import no.hib.dpf.core.Graph; \n" +
			"import no.hib.dpf.core.Node; \n" +
			"import no.hib.dpf.core.impl.Checker; \n" +
			"/*Limitations\n" +
			"The following elements of the Java programming language are not implemented:\n" +
			"assert (a rarely-used JDK 1.4 language feature)\n" +
			"J2SE 5.0: Parametrized types (generics)\n" +
			"J2SE 5.0: Enhanced FOR loop\n" +
			"J2SE 5.0: Typesafe enums\n" +
			"J2SE 5.0: Variable arguments\n" +
			"J2SE 5.0: Annotations*/\n" +
			"public class CheckInstance implements Checker { \n" +
			"	public boolean check(Graph shape, Map nodeMap, Map arrowMap) { \n" +
//			"		List yNodes = (List) nodeMap.get(shape.getNodeByName(\"Y\")); \n" +
//			"		List arrows = (List) arrowMap.get(shape.getArrows().get(0)); \n" +
//			"		List visitedY = new ArrayList(); \n" +
//			"		Iterator i = arrows.iterator(); \n" +		
//			"		while(i.hasNext()){ \n" +
//			"			Object arrow = i.next();\n" +				
//			"			if (!visitedY.contains(((Arrow)arrow).getTarget())) \n" +
//			"				visitedY.add(((Arrow)arrow).getTarget()); \n" +
//			"		} " +
//			"		if (visitedY.size() != yNodes.size()){ \n" +
//			"			System.out.println(\"Surjective Violated\"); \n" +
//			"		return false; \n" +
//			"		} \n" +
			"		return true; \n" +
			"	} \n" +
			"}\n";
//			"import java.util.List;\n" +
//			"import java.util.Map;\n" +
//			"import no.hib.dpf.core.Arrow;\n" +
//			"import no.hib.dpf.core.Graph;\n" +
//			"import no.hib.dpf.core.Node;\n" +
//			"import no.hib.dpf.core.Graph;\n" +
//			"import no.hib.dpf.core.impl.Checker;\n" +
//			"public class CheckInstance implements Checker{\n" +
//			"	//@Override\n" +
//			"	public boolean check(Graph graph, Map<Node, List<Node>> nodeMap,\n" +
//			"			Map<Arrow, List<Arrow>> arrowMap) {\n" +
//			"		//Dont change anything excepting the belowing line\n" +
//			"		return true;\n" +
//			"	}\n" +
//			"}\n";
	public static final String DefaultCheckerClass = "CheckInstance";
}
