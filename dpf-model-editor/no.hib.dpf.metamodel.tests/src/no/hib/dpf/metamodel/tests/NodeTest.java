/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Arrow;
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
 *   <li>{@link no.hib.dpf.metamodel.Node#getOutgoingArrows() <em>Get Outgoing Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#arrowCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node) <em>Arrow Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#canReachTargetByOneArrow(no.hib.dpf.metamodel.Node) <em>Can Reach Target By One Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#arrowCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Arrow) <em>Arrow Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#canReachTargetByTypeArrow(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Arrow) <em>Can Reach Target By Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#getArrowto(no.hib.dpf.metamodel.Node) <em>Get Arrowto</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Node#getTypeName() <em>Get Type Name</em>}</li>
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
	public void testGetOutgoingArrows() {
		Graph g = MetamodelFactory.eINSTANCE.createGraph();
		Node n1 = g.createNode("n1");
		Node n2 = g.createNode("n2");
		Node n3 = g.createNode("n3");
		
		Arrow e1 = g.createArrow("e1", n1, n2);
		Arrow e2 = g.createArrow("e2", n2, n3);
		Arrow e3 = g.createArrow("e3", n2, n1);
		
		assertTrue(n1.getOutgoingArrows().size() == 1 &&
				n1.getOutgoingArrows().get(0) == e1);
		
		assertTrue(n2.getOutgoingArrows().size() == 2 &&
				n2.getOutgoingArrows().contains(e2) && 
				n2.getOutgoingArrows().contains(e3));
		
		assertTrue(n3.getOutgoingArrows().size() == 0);
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testArrowCanMakeConnectionAsTarget__Node() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		
		Node source = MetamodelFactory.eINSTANCE.createNode(source_tn_1);
		Node target = MetamodelFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(null));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source));		

		source = MetamodelFactory.eINSTANCE.createNode();
		target = MetamodelFactory.eINSTANCE.createNode();
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target));		
		assertTrue(source.arrowCanMakeConnectionAsTarget(source));
		assertTrue(source.arrowCanMakeConnectionAsTarget(null));		
	}


	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#canReachTargetByOneEdge(no.hib.dpf.metamodel.Node) <em>Can Reach Target By One Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#canReachTargetByOneEdge(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testCanReachTargetByOneArrow__Node() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByOneArrow(typeGraph.getNodeByName("tn_2")));
		assertFalse(typeGraph.getNodeByName("tn_2").canReachTargetByOneArrow(typeGraph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#canReachTargetByTypeEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Can Reach Target By Type Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#canReachTargetByTypeEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testCanReachTargetByTypeArrow__Node_Arrow() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "te_1:tn_1:tn_2,te_2:tn_1:tn_3");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByTypeArrow(typeGraph.getNodeByName("tn_2"), typeGraph.getArrowByName("te_1")));
		assertFalse(typeGraph.getNodeByName("tn_1").canReachTargetByTypeArrow(typeGraph.getNodeByName("tn_2"), typeGraph.getArrowByName("te_2")));
	}
	
	
	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#getEdgeto(no.hib.dpf.metamodel.Node) <em>Get Edgeto</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#getEdgeto(no.hib.dpf.metamodel.Node)
	 * @generated NOT
	 */
	public void testGetArrowto__Node() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertEquals(graph.getArrowByName("te_1"), graph.getNodeByName("tn_1").getArrowto(graph.getNodeByName("tn_2")));
		assertEquals(null, graph.getNodeByName("tn_2").getArrowto(graph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#getTypeName() <em>Get Type Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#getTypeName()
	 * @generated NOT
	 */
	public void testGetTypeName() {
		Node untypedNode = MetamodelFactory.eINSTANCE.createNode();
		String typeName = "thetype";
		untypedNode.setName(typeName);
		
		assertEquals("", untypedNode.getTypeName());
		
		Node typedNode = MetamodelFactory.eINSTANCE.createNode(untypedNode);
		assertEquals(typeName, typedNode.getTypeName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Edge)
	 * @generated NOT
	 */
	public void testArrowCanMakeConnectionAsTarget__Node_Arrow() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2,te_2:tn_2:tn_1");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		Arrow te_1 = typeGraph.getArrowByName("te_1");
		
		Node source = MetamodelFactory.eINSTANCE.createNode(source_tn_1);
		Node target = MetamodelFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(null, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source, te_1));		

		source = MetamodelFactory.eINSTANCE.createNode();
		target = MetamodelFactory.eINSTANCE.createNode();
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target, null));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source, te_1));
		assertFalse(source.arrowCanMakeConnectionAsTarget(null, te_1));		
	}
} //NodeTest
