package no.hib.dpf.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import no.hib.dpf.core.Arrow;
//import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CoreFactory;
//import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
//import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import org.eclipse.emf.common.util.URI;


public class DPFCoreConstants {
	
	public static int ENRICHED_GRAPH_METALEVEL = -2;
	public static int TEMPLATE_METALEVEL = -1;
	
	// Meta-Meta-language types
	//*************************************************************************************************
	public static final String ARROW = "Arrow";
	public static final String NODE_ATTRIBUTE = "NodeAttribute";
	public static final String ARROW_ATTRIBUTE = "ArrowAttribute";
	public static final String NODE = "Node";
	// datanodes are treated differently (based on their default value) as they only hold data and datatype
	
	/**
	 *
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static ArrayList<String> getMetaMetaTypes(){
		ArrayList<String> lingNames = new ArrayList<String>();
		lingNames.add(ARROW);
		lingNames.add(NODE_ATTRIBUTE);
		lingNames.add(ARROW_ATTRIBUTE);
		lingNames.add(NODE);
		return lingNames;
	}
	
	/**
	 *
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static Map<String, String> getEDataTypesMap(){
		Map<String, String> datatypes = new HashMap<String, String>();
		datatypes.put("EDataType", "DataType");
		datatypes.put("EString", "java.lang.string");
		datatypes.put("EBoolean", "boolean");
		datatypes.put("EInteger", "int");
		return datatypes;
	}
	
	// End of linguistic definition
	//*************************************************************************************************
	public static final String DGRAPH_CATEGORY = "DGraph";
	public static final String DNODE_CATEGORY = "DNode";
	public static final String DARROW_CATEGORY = "DArrow";
	public static final String DARROW_DATTRIBUTE_CATEGORY = "DArrowDAttribute";
	public static final String DNODE_DATTRIBUTE_CATEGORY = "DNodeDAttribute";
	public static final String DDATANODE_CATEGORY = "DDataNode";
	public static final String ARROW_CATEGORY = "Arrow";
	public static final String ARROW_ATTRIBUTE_CATEGORY = "ArrowAttribute";
	public static final String NODE_CATEGORY = "Node";
	public static final String NODE_ATTRIBUTE_CATEGORY = "NodeAttribute";
	public static final String DATANODE_CATEGORY = "DataNode";
	public static final String GRAPH_CATEGORY = "Graph";
	
	// Graph Elements
	public static final Node REFLEXIVE_TYPE_NODE = CoreFactory.eINSTANCE.createConstantNode();
	
	// node must be defined before arrow, since the arrow is pointing at the node
	public static final Arrow REFLEXIVE_TYPE_ARROW = CoreFactory.eINSTANCE.createConstantArrow();
	
	// attribute elements
	//public static final DataNode REFLEXIVE_TYPE_DATANODE = CoreFactory.eINSTANCE.createConstantDataNode();
	
	// datanode must be defined before arrow/node-attribute, since the arrow is pointing at the node
	//public static final NodeAttribute REFLEXIVE_TYPE_NODE_ATTRIBUTE = CoreFactory.eINSTANCE.createConstantNodeAttribute();
	//public static final ArrowAttribute REFLEXIVE_TYPE_ARROW_ATTRIBUTE = CoreFactory.eINSTANCE.createConstantArrowAttribute();
	public static final Graph REFLEXIVE_TYPE_GRAPH = CoreFactory.eINSTANCE.createConstantGraph();
	public static final Signature DEFAULT_SIGNATURE = CoreFactory.eINSTANCE.createConstantSignature();
	public static final Specification REFLEXIVE_SPECIFICATION = CoreFactory.eINSTANCE.createConstantSpecification();
	public static final URI DefaultDSpecification = URI.createPlatformResourceURI("DefaultDSpecification.dpf", false);
	public static final URI DefaultSpecification = URI.createPlatformResourceURI("DefaultSpecification.xmi", false);
	public static final URI DefaultSignature = URI.createPlatformResourceURI("DefaultSignature.xmi", false);
	public static final URI DefaultDSignature = URI.createPlatformResourceURI("DefaultDSignature.xmi", false);
	// public static final URI DefaultGraph = URI.createPlatformResourceURI("DefaultGraph.xmi", false);
	
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
					"	Map<Arrow, List<Arrow>> arrowMap) {\n" +
					"	return true;\n" +
					"	}\n" +
					"}\n";
	public static final String DefaultCheckerClass = "CheckInstance";
	public static String DCONSTRAINT_CATEGORY = "DConstraint";
}
