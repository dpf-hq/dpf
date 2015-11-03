package no.hib.dpf.utils;

import org.eclipse.emf.common.util.URI;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.internal.signature.InjectivePredicate;
import no.hib.dpf.utils.internal.signature.InversePredicate;
import no.hib.dpf.utils.internal.signature.IrreflexivePredicate;
import no.hib.dpf.utils.internal.signature.JointlyInjectivePredicate;
import no.hib.dpf.utils.internal.signature.JointlySurjectiveValidator;
import no.hib.dpf.utils.internal.signature.MergeNANDPredicate;
import no.hib.dpf.utils.internal.signature.MultiplicityOnNodePredicate;
import no.hib.dpf.utils.internal.signature.MultiplicityPredicate;
import no.hib.dpf.utils.internal.signature.ReflexivePredicate;
import no.hib.dpf.utils.internal.signature.SplitNANDPredicate;
import no.hib.dpf.utils.internal.signature.SurjectivePredicate;
import no.hib.dpf.utils.internal.signature.XOR4Predicate;
import no.hib.dpf.utils.internal.signature.XORPredicate;

public class DPFConstants {
	public static final String ARROW = "Arrow";
	public static final String NODE = "Node";
	public static final String DNODE_CATEGORY = "DNode";
	public static final String DARROW_CATEGORY = "DArrow";
	public static final String ARROW_CATEGORY = "Arrow";
	public static final String NODE_CATEGORY = "Node";
	
	public static final Node REFLEXIVE_TYPE_NODE = CoreFactory.eINSTANCE.createConstantNode();
	public static final Arrow REFLEXIVE_TYPE_ARROW = CoreFactory.eINSTANCE.createConstantArrow();
	public static final Graph REFLEXIVE_TYPE_GRAPH = CoreFactory.eINSTANCE.createConstantGraph();
	public static final Predicate INJECTIVE  = new InjectivePredicate(),
			SURJECTIVE = new SurjectivePredicate(),
			IRREFLEXIVE = new IrreflexivePredicate(),
			ARROW_MULTI = new MultiplicityPredicate(),
			INVERSE = new InversePredicate(),
			JOINT_SURJ = new JointlySurjectiveValidator(),
			JOINT_INJE = new JointlyInjectivePredicate(),
			XOR = new XORPredicate(),
			XOR4 = new XOR4Predicate(),
			SPLIT_NAND = new SplitNANDPredicate(),
			MERGE_NAND = new MergeNANDPredicate(),
			NODE_MULTI = new MultiplicityOnNodePredicate(),
			REFLEXIVE = new ReflexivePredicate();
	
	public static final Signature DEFAULT_SIGNATURE = CoreFactory.eINSTANCE.createConstantSignature();
	public static final Specification REFLEXIVE_SPECIFICATION = CoreFactory.eINSTANCE.createConstantSpecification();
	
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
	public static String DCONSTRAINT_CATEGORY = "DConstraint";
}
