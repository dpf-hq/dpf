package no.hib.dpf.utils;

import org.eclipse.emf.common.util.URI;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;

public class DPFConstants {
	public static final String ARROW = "Arrow";
	public static final String NODE = "Node";
	public static final String DNODE_CATEGORY = "DNode";
	public static final String DARROW_CATEGORY = "DArrow";
	public static final String ARROW_CATEGORY = "Arrow";
	public static final String NODE_CATEGORY = "Node";
	
	public static final Node REFLEXIVE_TYPE_NODE = CoreFactory.eINSTANCE.createDefaultNode();
	public static final Arrow REFLEXIVE_TYPE_ARROW = CoreFactory.eINSTANCE.createDefaultArrow();
	public static final Graph REFLEXIVE_TYPE_GRAPH = CoreFactory.eINSTANCE.createDefaultGraph();
	public static final Signature DEFAULT_SIGNATURE = CoreFactory.eINSTANCE.createDefaultSignature();
	public static final Specification REFLEXIVE_SPECIFICATION = CoreFactory.eINSTANCE.createDefaultSpecification();
	
	public static final DNode REFLEXIVE_TYPE_DNODE = DiagramFactory.eINSTANCE.createDefaultDNode();
	public static final DArrow REFLEXIVE_TYPE_DARROW = DiagramFactory.eINSTANCE.createDefaultDArrow();
	public static final DGraph REFLEXIVE_TYPE_DGRAPH = DiagramFactory.eINSTANCE.createDefaultDGraph();
	public static final DSignature DEFAULT_DSIGNATURE = DiagramFactory.eINSTANCE.createDefaultDSignature();
	public static final DSpecification REFLEXIVE_DSPECIFICATION = DiagramFactory.eINSTANCE.createDefaultDSpecification();
	
	public static final URI DefaultDSpecification = URI.createPlatformResourceURI("DefaultDSpecification.dpf", false);
	public static final URI DefaultSpecification = URI.createPlatformResourceURI("DefaultSpecification.xmi", false);
	public static final URI DefaultSignature = URI.createPlatformResourceURI("DefaultSignature.xmi", false);
	public static final URI DefaultDSignature = URI.createPlatformResourceURI("DefaultDSignature.xmi", false);
	
//	public static final URI DefaultGraph = URI.createPlatformResourceURI("DefaultGraph.xmi", false);
	public static final String DefaultChecker = 
			"import java.util.List;\n" +
			"import java.util.Map;\n" +
			"import no.hib.dpf.core.Arrow;\n" +
			"import no.hib.dpf.core.Graph;\n" +
			"import no.hib.dpf.core.Node;\n" +
			"import no.hib.dpf.utils.Checker;\n" +
			"public class CheckInstance implements Checker{\n" +
			"	@Override\n" +
			"	public boolean check(Map<String, String> paras, Graph graph, Map<Node, List<Node>> nodeMap,\n" +
			"			Map<Arrow, List<Arrow>> arrowMap) {\n" +
			"		return true;\n" +
			"	}\n" +
			"}\n";
	public static final String DefaultCheckerClass = "CheckInstance";
}
