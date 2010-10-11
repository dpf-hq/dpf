/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#tryToCreateGraphHomomorphism(no.hib.dpf.metamodel.Graph, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Try To Create Graph Homomorphism</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphHomomorphismTest extends TestCase {

	/**
	 * The fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphism fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphHomomorphismTest.class);
	}

	/**
	 * Constructs a new Graph Homomorphism test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphismTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(GraphHomomorphism fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphism getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createGraphHomomorphism());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}


	/**
	 * Tests the '{@link no.hib.dpf.metamodel.GraphHomomorphism#canCreateBijectiveGraphHomomorphism(no.hib.dpf.metamodel.Graph, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Can Create Bijective Graph Homomorphism</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.GraphHomomorphism#canCreateBijectiveGraphHomomorphism(no.hib.dpf.metamodel.Graph, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testTryToCreateGraphHomomorphism__Graph_EList_EList() {		
		testHomomorphism(createGraphContent("", "", "", ""), true);
		// Single nodes, no edges:
		testHomomorphism(createGraphContent("g_node_1", "h_node_1", "", ""), true);
		testHomomorphism(createGraphContent("g_node_1,g_node_2", "h_node_1", "", ""), false);
		testHomomorphism(createGraphContent("g_node_1,g_node_2", "h_node_1,h_node_2", "", ""), true);
		// Now with an edge:
		testHomomorphism(createGraphContent("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", ""), false);
		testHomomorphism(createGraphContent("g_node_1,g_node_2", "h_node_1,h_node_2", "", "h_edge_1:h_node_1:h_node_2"), false);
		testHomomorphism(createGraphContent("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", "h_edge_1:h_node_1:h_node_2"), true);
		// Just edges
		testHomomorphism(createGraphContent("", "", "g_edge:null:null", "h_edge:null:null"), true);		
		testHomomorphism(createGraphContent("", "", "g_edge:null:null", "h_edge:null:null,h_2:null:null"), false);		
		// 3 nodes/2 edges:
		testHomomorphism(createGraphContent("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);
		// Now with the arrows going in different direction in the two graphs:
		testHomomorphism(createGraphContent("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn2:hn1,he2:hn2:hn3"), false);
		// 3 nodes, 2 edges, but the edges don't go between all 3 nodes in one graph
		testHomomorphism(createGraphContent("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn1:hn2"), false);
		
		testHomomorphism(createGraphContent("gn1", "hn1", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn1:hn2"), true);

		testHomomorphismWithExtraGraphElements(createGraphContent("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);		
		testHomomorphismWithExtraGraphElements2(createGraphContent("gn1,gn2", "hn1,hn2", "ge1:gn1:gn2", "he1:hn1:null"), false);		
		testHomomorphismWithExtraGraphElements3(createGraphContent("gn1,gn2", "hn1,hn2", "ge1:gn1:gn2", "he1:hn1:hn2"), true);		
	}
	
	/**
	 * @generated NOT
	 */
	private List<Graph> createGraphContent(String g_nodes, String h_nodes, String g_edges, String h_edges) {
		return createGraphContent(g_nodes.split(","), h_nodes.split(","), g_edges.split(","), h_edges.split(","));
	}
	
	/**
	 * @generated NOT
	 */
	private List<Graph> createGraphContent(String[] g_nodes, String[] h_nodes, String[] g_edges, String[] h_edges) {
		List<Graph> retval = new ArrayList<Graph>();
		retval.add(createGraphNodes(g_nodes));
		retval.add(createGraphNodes(h_nodes));
		addEdgesToGraph(retval.get(0), g_edges);
		addEdgesToGraph(retval.get(1), h_edges);
		return retval;
	}
	
	/**
	 * @generated NOT
	 */
	private Graph createGraphNodes(String[] nodes) {
		Graph g = MetamodelFactory.eINSTANCE.createGraph();
		if (!((nodes.length == 1) && (nodes[0].equals("")))) {
			for (String node_name : nodes) {
				g.createNode(node_name.trim());
			}
		}
		return g;
	}
	
	/**
	 * @generated NOT
	 */
	private void addEdgesToGraph(Graph g, String[] edges) {
		if (!((edges.length == 1) && (edges[0].equals("")))) {
			for (String edgeDetails : edges) {
				String[] edgeDetailsSplit = edgeDetails.split(":");
				g.createEdge(edgeDetailsSplit[0].trim(), getNodeByString(g, edgeDetailsSplit[1].trim()), getNodeByString(g, edgeDetailsSplit[2].trim()));
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	private Node getNodeByString(Graph g, String nodeName) {
		for (Node node : g.getNodes()) {
			if (node.getName().equals(nodeName)) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * @generated NOT
	 */
	private void testHomomorphism(List<Graph> graphs, boolean expectedResult) {
		testHomomorphism(graphs.get(0), graphs.get(1).getNodes(), graphs.get(1).getEdges(), expectedResult);
	}
		
	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation.
	 * @generated NOT
	 */
	private void testHomomorphismWithExtraGraphElements(List<Graph> graphs, boolean expectedResult) {
		EList<?> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<?> edges = new BasicEList<Edge>(graphs.get(1).getEdges());
		Node n2 = graphs.get(1).createNode("dust");
		graphs.get(1).createEdge("dust", n2, graphs.get(1).getNodes().get(0));
		testHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}

	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation II.
	 * @generated NOT
	 */
	private void testHomomorphismWithExtraGraphElements2(List<Graph> graphs, boolean expectedResult) {
		EList<?> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<?> edges = new BasicEList<Edge>(graphs.get(1).getEdges());
		graphs.get(1).createEdge("hn1", graphs.get(1).getNodes().get(0), graphs.get(1).getNodes().get(1));
		testHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}
	
	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation III.
	 * @generated NOT
	 * */
	private void testHomomorphismWithExtraGraphElements3(List<Graph> graphs, boolean expectedResult) {
		EList<?> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<?> edges = new BasicEList<Edge>(graphs.get(1).getEdges());
		graphs.get(1).createEdge("hn1", graphs.get(1).getNodes().get(0), null);
		testHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}
	
	/**
	 * @generated NOT
	 */
	private void testHomomorphism(Graph sourceGraph, EList<?> nodes, EList<?> edges, boolean expectedResult) {
		GraphHomomorphism graphHomomorphism = MetamodelFactory.eINSTANCE.createGraphHomomorphism();
		boolean res = graphHomomorphism.tryToCreateGraphHomomorphism(sourceGraph, nodes, edges);
		assertEquals(expectedResult, res);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void testGraphHomomorphismCreation() {
		// Creates two simple graphs, with a simple homomorphism between them
//		Graph g = MetamodelFactory.eINSTANCE.createGraph();
//		Graph h = MetamodelFactory.eINSTANCE.createGraph();
//
//		Node g_n1 = g.createNode("g_n1");
//		Node g_n2 = g.createNode("g_n2");
//		Edge g_e1 = g.createEdge("g_e1", g_n1, g_n2);
//		
//		Node h_n1 = g.createNode("h_n1");
//		Node h_n2 = g.createNode("h_n2");
//		Edge h_e1 = g.createEdge("h_e1", h_n1, h_n2);
		
	}

} //GraphHomomorphismTest
