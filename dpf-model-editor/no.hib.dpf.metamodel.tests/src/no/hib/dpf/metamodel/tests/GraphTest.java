/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import java.util.ArrayList;
import java.util.List;

import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Graph#createNode(java.lang.String) <em>Create Node</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node) <em>Create Edge</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#deleteNode(no.hib.dpf.metamodel.Node) <em>Delete Node</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#deleteEdge(no.hib.dpf.metamodel.Edge) <em>Delete Edge</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getNodeByName(java.lang.String) <em>Get Node By Name</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getEdgeByName(java.lang.String) <em>Get Edge By Name</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#createNode(java.lang.String, no.hib.dpf.metamodel.Node) <em>Create Node</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Create Edge</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Graph getFixture() {
		return (Graph)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createGraph());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#createNode(java.lang.String) <em>Create Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#createNode(java.lang.String)
	 * @generated NOT
	 */
	public void testCreateNode__String() {
		Node n = getFixture().createNode("test");
		assertTrue(getFixture().getNodes().contains(n));
		assertEquals("test", n.getName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node) <em>Create Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testCreateEdge__String_Node_Node() {
		Node n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Edge e = getFixture().createEdge("test", n1, n2);
		
		assertTrue(getFixture().getEdges().contains(e));
		assertEquals(n1, e.getSource());
		assertEquals(n2, e.getTarget());
		assertEquals("test", e.getName());
	}
	
	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Create Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testCreateEdge__String_Node_Node_Edge() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "te_1:tn_1:tn_2,te_2:tn_1:tn_3");

		getFixture().createNode("source", typeGraph.getNodeByName("tn_1"));
		getFixture().createNode("target", typeGraph.getNodeByName("tn_2"));

		Edge newEdge = getFixture().createEdge("edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"), typeGraph.getEdgeByName("te_1"));
		assertEquals(typeGraph.getEdgeByName("te_1"), newEdge.getTypeEdge());
		try {
			getFixture().createEdge("edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"), typeGraph.getEdgeByName("te_2"));
			fail();
		} catch (AssertionError e) {
		}
	}

	
	/**
	 * @generated NOT
	 */
	public void testCreateTypedEdge() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");

		getFixture().createNode("source", typeGraph.getNodeByName("tn_1"));
		getFixture().createNode("target", typeGraph.getNodeByName("tn_2"));
		
		// Should not be able to make an untyped connection between two typed nodes:
		try {
			getFixture().createEdge("not_applicable", getFixture().getNodeByName("target"), getFixture().getNodeByName("source"));
			fail();
		} catch (AssertionError e) {
		}
		
		Edge newEdge = getFixture().createEdge("new_edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"));
		assertEquals(typeGraph.getEdgeByName("te_1"), newEdge.getTypeEdge());

	}

	/**
	 * @generated NOT
	 */
	public void testCreateEdge__nullpointer_throws() {
		try {
			MetamodelFactory.eINSTANCE.createGraph("", "g_edge:null:null");
			fail("Expected exception when adding a dangling edge to a graph");
		} catch(NullPointerException e) {}
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testApplyPredicate__Predicate_EList_EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		//fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#deleteNode(no.hib.dpf.metamodel.Node) <em>Delete Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#deleteNode(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testDeleteNode__Node() {
		Node n1 = getFixture().createNode("n1");
		getFixture().deleteNode(n1);
		assertEquals(null, getFixture().getNodeByName("n1"));
		
		n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Edge e = getFixture().createEdge("test", n1, n2);
		getFixture().deleteNode(n1);
		
		assertFalse(getFixture().getEdges().contains(e));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#deleteEdge(no.hib.dpf.metamodel.Edge) <em>Delete Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#deleteEdge(no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testDeleteEdge__Edge() {
		Node n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Edge e = getFixture().createEdge("test", n1, n2);
		getFixture().deleteEdge(e);
		
		assertFalse(getFixture().getEdges().contains(e));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#getNodeByName(java.lang.String) <em>Get Node By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#getNodeByName(java.lang.String)
	 * @generated NOT
	 */
	public void testGetNodeByName__String() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Node n_1 = graph.getNodeByName("n_1");
		Node n_2 = graph.getNodeByName("n_2");
		assertEquals("n_1", n_1.getName());
		assertNotSame("getNodeByName returned wrong object", n_1, n_2);
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#getEdgeByName(java.lang.String) <em>Get Edge By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#getEdgeByName(java.lang.String)
	 * @generated NOT
	 */
	public void testGetEdgeByName__String() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Edge e_1 = graph.getEdgeByName("e_1");
		Node e_2 = graph.getNodeByName("e_2");
		assertEquals("e_1", e_1.getName());
		assertNotSame("getEdgeByName returned wrong object", e_1, e_2);
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#createNode(java.lang.String, no.hib.dpf.metamodel.Node) <em>Create Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#createNode(java.lang.String, no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testCreateNode__String_Node() {
		Node typeNode = MetamodelFactory.eINSTANCE.createNode();
		Node typedNode = getFixture().createNode("b", typeNode);
		assertEquals(typeNode, typedNode.getTypeNode());
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String)
	 * @generated NOT
	 */
	public void testGetGraphMember__String() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Edge e_1 = graph.getEdgeByName("e_1");
		Node n_2 = graph.getNodeByName("n_2");
		assertEquals(e_1, graph.getGraphMember(e_1.getId()));
		assertEquals(n_2, graph.getGraphMember(n_2.getId()));
	}

	/**
	 * @generated NOT
	 */
	public static List<Graph> createGraphs(String g_nodes, String h_nodes, String g_edges, String h_edges) {
		List<Graph> retval = new ArrayList<Graph>();		
		retval.add(MetamodelFactory.eINSTANCE.createGraph(g_nodes, g_edges));
		retval.add(MetamodelFactory.eINSTANCE.createGraph(h_nodes, h_edges));
		return retval;
	}


} //GraphTest
