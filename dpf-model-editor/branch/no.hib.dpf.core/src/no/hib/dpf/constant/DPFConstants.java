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
	public static final URI DefaultGraph = URI.createPlatformResourceURI("DefaultGraph.xmi", false);
}
