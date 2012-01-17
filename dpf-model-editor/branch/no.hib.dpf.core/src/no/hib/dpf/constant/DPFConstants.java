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
			"import java.util.List;\n" +
			"import java.util.Map;\n" +
			"import no.hib.dpf.core.Arrow;\n" +
			"import no.hib.dpf.core.Graph;\n" +
			"import no.hib.dpf.core.Node;\n" +
			"import no.hib.dpf.core.Graph;\n" +
			"import no.hib.dpf.core.impl.Checker;\n" +
			"public class CheckInstance implements Checker{\n" +
			"	//@Override\n" +
			"	public boolean check(Graph graph, Map<Node, List<Node>> nodeMap,\n" +
			"			Map<Arrow, List<Arrow>> arrowMap) {\n" +
			"		return true;\n" +
			"	}\n" +
			"}\n";
	public static final String DefaultCheckerClass = "CheckInstance";
}
