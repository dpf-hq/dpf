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
		doTestHomomorphisms();
		doTestHomomorphismsWithExtraGraphElements();		
//		
//		// Check the created mappings
//		
		doTestReturnedMappings(createGraphs("", "", "g_edge:null:null", "h_edge:null:null"), new String[]{}, new String[] { "g_edge:h_edge" }, true);		
		doTestReturnedMappings(createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", ""), new String[] { "g_node_1:h_node_1", "g_node_2:h_node_2" }, new String[]{}, true);		
		doTestReturnedMappings(createGraphs("g_node_1", "h_node_1", "g_edge_1:g_node_1:null,g_edge_2:g_node_1:null", "h_edge_1:h_node_1:null,h_edge_2:h_node_1:null"), new String[] { "g_node_1:h_node_1" }, new String[]{ "g_edge_1:h_edge_1", "g_edge_2:h_edge_2"}, true);		
		doTestReturnedMappings(createGraphs("gn1,gn2", "hn1,hn2", "ge:gn1:gn2", "he:hn2:hn1"), new String[] { "gn1:hn2", "gn2:hn1" }, new String[]{ "ge:he" }, true);		
		doTestReturnedMappings(createGraphs("g_node_1", "h_node_1", "g_edge_1:null:g_node_1,g_edge_2:null:g_node_1", "h_edge_1:null:h_node_1,h_edge_2:null:h_node_1"), new String[] { "g_node_1:h_node_1" }, new String[]{ "g_edge_1:h_edge_1", "g_edge_2:h_edge_2"}, true);		
	}
	
	/**
	 * @generated NOT
	 */
	private void doTestReturnedMappings(List<Graph> graphs, String[] nodeNames, String[] edgeNames, boolean expectedResult) {
		GraphHomomorphism graphHomomorphism = MetamodelFactory.eINSTANCE.createGraphHomomorphism();
		boolean res = graphHomomorphism.tryToCreateGraphHomomorphism(graphs.get(0), graphs.get(1).getNodes(), graphs.get(1).getEdges());
		assertEquals(true, res);
		for (String nodes : nodeNames) {			
			checkNodeMapping(graphs, nodes.split(":")[0], nodes.split(":")[1], graphHomomorphism);
		}
		for (String edges : edgeNames) {			
			checkEdgeMapping(graphs, edges.split(":")[0], edges.split(":")[1], graphHomomorphism);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void checkEdgeMapping(List<Graph> graphs, String sourceEdgeName, String targetEdgeName, GraphHomomorphism graphHomomorphism) {
		Edge source = getEdgeFromGraph(graphs.get(0), sourceEdgeName); 
		Edge target = getEdgeFromGraph(graphs.get(1), targetEdgeName);
		assertEquals(target, graphHomomorphism.getEdgeMapping().get(source));		
	}
	
	/**
	 * @generated NOT
	 */
	private void checkNodeMapping(List<Graph> graphs, String sourceNodeName, String targetNodeName, GraphHomomorphism graphHomomorphism) {
		Node source = getNodeFromGraph(graphs.get(0), sourceNodeName); 
		Node target = getNodeFromGraph(graphs.get(1), targetNodeName);
		assertEquals(target, graphHomomorphism.getNodeMapping().get(source));		
	}

	/**
	 * @generated NOT
	 */
	private Edge getEdgeFromGraph(Graph graph, String edgeName) {
		for (Edge edge : graph.getEdges()) {
			if (edge.getName().equals(edgeName)) {
				return edge;
			}
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	private Node getNodeFromGraph(Graph graph, String nodeName) {
		for (Node node : graph.getNodes()) {
			if (node.getName().equals(nodeName)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Testing simple homomorphisms
	 * @generated NOT
	 */
	private void doTestHomomorphisms() {
		testTryToCreateHomomorphism(createGraphs("", "", "", ""), true);
		// Single nodes, no edges:
		testTryToCreateHomomorphism(createGraphs("g_node_1", "h_node_1", "", ""), true);
		testTryToCreateHomomorphism(createGraphs("g_node_1,g_node_2", "h_node_1", "", ""), false);
		testTryToCreateHomomorphism(createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", ""), true);
		// Now with an edge:
		testTryToCreateHomomorphism(createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", ""), false);
		testTryToCreateHomomorphism(createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", "h_edge_1:h_node_1:h_node_2"), false);
		testTryToCreateHomomorphism(createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", "h_edge_1:h_node_1:h_node_2"), true);
		// Just edges
		testTryToCreateHomomorphism(createGraphs("", "", "g_edge:null:null", "h_edge:null:null"), true);		
		testTryToCreateHomomorphism(createGraphs("", "", "g_edge:null:null", "h_edge:null:null,h_2:null:null"), false);		
		// 3 nodes/2 edges:
		testTryToCreateHomomorphism(createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);
		// Now with the arrows going in different direction in the two graphs:
		testTryToCreateHomomorphism(createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn2:hn1,he2:hn2:hn3"), false);
		// 3 nodes, 2 edges, but the edges don't go between all 3 nodes in one graph
		testTryToCreateHomomorphism(createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn1:hn2"), false);
		
		testTryToCreateHomomorphism(createGraphs("gn1", "hn1", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn1:hn2"), true);
	}

	/**
	 * @generated NOT
	 */
	private void doTestHomomorphismsWithExtraGraphElements() {
		testHomomorphismWithExtraGraphElements(createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);		
		testHomomorphismWithExtraGraphElements2(createGraphs("gn1,gn2", "hn1,hn2", "ge1:gn1:gn2", "he1:hn1:null"), false);		
		testHomomorphismWithExtraGraphElements3(createGraphs("gn1,gn2", "hn1,hn2", "ge1:gn1:gn2", "he1:hn1:hn2"), true);
	}
	
	/**
	 * @generated NOT
	 */
	private List<Graph> createGraphs(String g_nodes, String h_nodes, String g_edges, String h_edges) {
		List<Graph> retval = new ArrayList<Graph>();		
		retval.add(MetamodelFactory.eINSTANCE.createGraph(g_nodes, g_edges));
		retval.add(MetamodelFactory.eINSTANCE.createGraph(h_nodes, h_edges));
		return retval;
	}
	
	/**
	 * @generated NOT
	 */
	private void testTryToCreateHomomorphism(List<Graph> graphs, boolean expectedResult) {
		testTryToCreateHomomorphism(graphs.get(0), graphs.get(1).getNodes(), graphs.get(1).getEdges(), expectedResult);
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
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
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
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
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
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}
	
	/**
	 * @generated NOT
	 */
	private void testTryToCreateHomomorphism(Graph sourceGraph, EList<?> nodes, EList<?> edges, boolean expectedResult) {
		GraphHomomorphism graphHomomorphism = MetamodelFactory.eINSTANCE.createGraphHomomorphism();
		boolean res = graphHomomorphism.tryToCreateGraphHomomorphism(sourceGraph, nodes, edges);
		assertEquals(expectedResult, res);
	}


} //GraphHomomorphismTest
