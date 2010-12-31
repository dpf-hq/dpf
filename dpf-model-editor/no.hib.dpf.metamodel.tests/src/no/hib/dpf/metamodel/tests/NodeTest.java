/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Node#getOutgoingEdges() <em>Get Outgoing Edges</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node) <em>Edge Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#canReachTargetByOneEdge(no.hib.dpf.metamodel.Node) <em>Can Reach Target By One Edge</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Edge Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#canReachTargetByTypeEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Can Reach Target By Type Edge</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#getEdgeto(no.hib.dpf.metamodel.Node) <em>Get Edgeto</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class NodeTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodeTest.class);
	}

	/**
	 * Constructs a new Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Node getFixture() {
		return (Node)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createNode());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Node#getOutgoingEdges() <em>Get Outgoing Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#getOutgoingEdges()
	 * @generated NOT
	 */
	public void testGetOutgoingEdges() {
		Graph g = MetamodelFactory.eINSTANCE.createGraph();
		Node n1 = g.createNode("n1");
		Node n2 = g.createNode("n2");
		Node n3 = g.createNode("n3");
		
		Edge e1 = g.createEdge("e1", n1, n2);
		Edge e2 = g.createEdge("e2", n2, n3);
		Edge e3 = g.createEdge("e3", n2, n1);
		
		assertTrue(n1.getOutgoingEdges().size() == 1 &&
				n1.getOutgoingEdges().get(0) == e1);
		
		assertTrue(n2.getOutgoingEdges().size() == 2 &&
				n2.getOutgoingEdges().contains(e2) && 
				n2.getOutgoingEdges().contains(e3));
		
		assertTrue(n3.getOutgoingEdges().size() == 0);
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testEdgeCanMakeConnectionAsTarget__Node() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		
		Node source = MetamodelFactory.eINSTANCE.createNode(source_tn_1);
		Node target = MetamodelFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.edgeCanMakeConnectionAsTarget(target));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(null));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(source));		

		source = MetamodelFactory.eINSTANCE.createNode();
		target = MetamodelFactory.eINSTANCE.createNode();
		
		assertTrue(source.edgeCanMakeConnectionAsTarget(target));		
		assertTrue(source.edgeCanMakeConnectionAsTarget(source));
		assertTrue(source.edgeCanMakeConnectionAsTarget(null));		
	}


	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#canReachTargetByOneEdge(no.hib.dpf.metamodel.Node) <em>Can Reach Target By One Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#canReachTargetByOneEdge(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testCanReachTargetByOneEdge__Node() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByOneEdge(typeGraph.getNodeByName("tn_2")));
		assertFalse(typeGraph.getNodeByName("tn_2").canReachTargetByOneEdge(typeGraph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#canReachTargetByTypeEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Can Reach Target By Type Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#canReachTargetByTypeEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testCanReachTargetByTypeEdge__Node_Edge() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "te_1:tn_1:tn_2,te_2:tn_1:tn_3");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByTypeEdge(typeGraph.getNodeByName("tn_2"), typeGraph.getEdgeByName("te_1")));
		assertFalse(typeGraph.getNodeByName("tn_1").canReachTargetByTypeEdge(typeGraph.getNodeByName("tn_2"), typeGraph.getEdgeByName("te_2")));
	}
	
	
	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#getEdgeto(no.hib.dpf.metamodel.Node) <em>Get Edgeto</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#getEdgeto(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testGetEdgeto__Node() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertEquals(graph.getEdgeByName("te_1"), graph.getNodeByName("tn_1").getEdgeto(graph.getNodeByName("tn_2")));
		assertEquals(null, graph.getNodeByName("tn_2").getEdgeto(graph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testEdgeCanMakeConnectionAsTarget__Node_Edge() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2,te_2:tn_2:tn_1");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		Edge te_1 = typeGraph.getEdgeByName("te_1");
		
		Node source = MetamodelFactory.eINSTANCE.createNode(source_tn_1);
		Node target = MetamodelFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.edgeCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(null, te_1));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(source, te_1));		

		source = MetamodelFactory.eINSTANCE.createNode();
		target = MetamodelFactory.eINSTANCE.createNode();
		
		assertTrue(source.edgeCanMakeConnectionAsTarget(target, null));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.edgeCanMakeConnectionAsTarget(source, te_1));
		assertFalse(source.edgeCanMakeConnectionAsTarget(null, te_1));		
	}
	


} //NodeTest
