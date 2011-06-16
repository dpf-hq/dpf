/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.textui.TestRunner;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Node#getOutgoingArrows() <em>Get Outgoing Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#arrowCanMakeConnectionAsTarget(no.hib.dpf.core.Node) <em>Arrow Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#canReachTargetByOneArrow(no.hib.dpf.core.Node) <em>Can Reach Target By One Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#arrowCanMakeConnectionAsTarget(no.hib.dpf.core.Node, no.hib.dpf.core.Arrow) <em>Arrow Can Make Connection As Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#canReachTargetByTypeArrow(no.hib.dpf.core.Node, no.hib.dpf.core.Arrow) <em>Can Reach Target By Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getArrowto(no.hib.dpf.core.Node) <em>Get Arrowto</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getTypeName() <em>Get Type Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#generateUniqueName() <em>Generate Unique Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#canCreateTypedArrow(no.hib.dpf.core.Node) <em>Can Create Typed Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getTypeArrow(no.hib.dpf.core.Node) <em>Get Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getIncomingArrows() <em>Get Incoming Arrows</em>}</li>
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
		setFixture(CoreFactory.eINSTANCE.createNode());
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
	 * Tests the '{@link no.hib.dpf.core.Node#getOutgoingEdges() <em>Get Outgoing Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#getOutgoingEdges()
	 * @generated NOT
	 */
	public void testGetOutgoingArrows() {
		Graph g = CoreFactory.eINSTANCE.createGraph();
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
	 * Tests the '{@link no.hib.dpf.core.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.core.Node) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testArrowCanMakeConnectionAsTarget__Node() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		
		Node source = CoreFactory.eINSTANCE.createNode(source_tn_1);
		Node target = CoreFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(null));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source));		

		source = CoreFactory.eINSTANCE.createNode();
		target = CoreFactory.eINSTANCE.createNode();
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target));		
		assertTrue(source.arrowCanMakeConnectionAsTarget(source));
		assertTrue(source.arrowCanMakeConnectionAsTarget(null));		
	}


	/**
	 * Tests the '{@link no.hib.dpf.core.Node#canReachTargetByOneEdge(no.hib.dpf.core.Node) <em>Can Reach Target By One Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#canReachTargetByOneEdge(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testCanReachTargetByOneArrow__Node() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByOneArrow(typeGraph.getNodeByName("tn_2")));
		assertFalse(typeGraph.getNodeByName("tn_2").canReachTargetByOneArrow(typeGraph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#canReachTargetByTypeEdge(no.hib.dpf.core.Node, no.hib.dpf.core.Edge) <em>Can Reach Target By Type Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#canReachTargetByTypeEdge(no.hib.dpf.core.Node, no.hib.dpf.core.Edge)
	 * @generated NOT
	 */
	public void testCanReachTargetByTypeArrow__Node_Arrow() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "te_1:tn_1:tn_2,te_2:tn_1:tn_3");
		assertTrue(typeGraph.getNodeByName("tn_1").canReachTargetByTypeArrow(typeGraph.getNodeByName("tn_2"), typeGraph.getArrowByName("te_1")));
		assertFalse(typeGraph.getNodeByName("tn_1").canReachTargetByTypeArrow(typeGraph.getNodeByName("tn_2"), typeGraph.getArrowByName("te_2")));
	}
	
	
	/**
	 * Tests the '{@link no.hib.dpf.core.Node#getEdgeto(no.hib.dpf.core.Node) <em>Get Edgeto</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#getEdgeto(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testGetArrowto__Node() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");
		assertEquals(graph.getArrowByName("te_1"), graph.getNodeByName("tn_1").getArrowto(graph.getNodeByName("tn_2")));
		assertEquals(null, graph.getNodeByName("tn_2").getArrowto(graph.getNodeByName("tn_1")));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#getTypeName() <em>Get Type Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#getTypeName()
	 * @generated NOT
	 */
	public void testGetTypeName() {
		Node untypedNode = CoreFactory.eINSTANCE.createNode();
		String typeName = "thetype";
		untypedNode.setName(typeName);
		
		assertEquals("", untypedNode.getTypeName());
		
		Node typedNode = CoreFactory.eINSTANCE.createNode(untypedNode);
		assertEquals(typeName, typedNode.getTypeName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#generateUniqueName() <em>Generate Unique Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#generateUniqueName()
	 * @generated NOT HOT DOT!
	 */
	public void testGenerateUniqueName() {
		Node n1 = CoreFactory.eINSTANCE.createNode();
		Node n2 = CoreFactory.eINSTANCE.createNode();
		
		n1.setName(n1.generateUniqueName());
		n2.setName(n2.generateUniqueName());
		
		assertFalse(n1.getName().equals(n2.getName()));
	}
	
	/**
	 * Tests the '{@link no.hib.dpf.core.Node#canCreateTypedArrow(no.hib.dpf.core.Node) <em>Can Create Typed Arrow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#canCreateTypedArrow(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testCanCreateTypedArrow__Node() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "ta_1:tn_1:tn_2,ta_2:tn_2:tn_1,t1_3:tn_3:tn_1,ta_4:tn_1:tn_1:ta_5:tn_1:tn_2");		
		Node tn_1 = typeGraph.getNodeByName("tn_1");
		Node tn_2 = typeGraph.getNodeByName("tn_2");
		Node tn_3 = typeGraph.getNodeByName("tn_3");		
		
		Node source = CoreFactory.eINSTANCE.createNode();
		Node target = CoreFactory.eINSTANCE.createNode();

		assertFalse(source.canCreateTypedArrow(null));		
		assertFalse(source.canCreateTypedArrow(target));		
		assertFalse(target.canCreateTypedArrow(source));				
		assertFalse(source.canCreateTypedArrow(source));		
		target = CoreFactory.eINSTANCE.createNode(tn_2);
		assertFalse(source.canCreateTypedArrow(target));		
		
		source = CoreFactory.eINSTANCE.createNode(tn_1);
		
		assertFalse(source.canCreateTypedArrow(null));
		assertTrue(source.canCreateTypedArrow(target));
		assertTrue(source.canCreateTypedArrow(source));		
		
		target = CoreFactory.eINSTANCE.createNode(tn_3);
		assertFalse(source.canCreateTypedArrow(target));

		source = CoreFactory.eINSTANCE.createNode(tn_3);
		target = CoreFactory.eINSTANCE.createNode(tn_2);
		assertFalse(source.canCreateTypedArrow(target));
		assertFalse(source.canCreateTypedArrow(source));	
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#getTypeArrow(no.hib.dpf.core.Node) <em>Get Type Arrow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#getTypeArrow(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testGetTypeArrow__Node() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "ta_1:tn_1:tn_2,ta_2:tn_2:tn_1,t1_3:tn_3:tn_1,ta_4:tn_1:tn_1");		
		Node tn_1 = typeGraph.getNodeByName("tn_1");
		Node tn_2 = typeGraph.getNodeByName("tn_2");
		
		Node source = CoreFactory.eINSTANCE.createNode();
		Node target = CoreFactory.eINSTANCE.createNode();
		
		assertEquals(null, source.getTypeArrow(target));
		
		
		source = CoreFactory.eINSTANCE.createNode(tn_1);
		target = CoreFactory.eINSTANCE.createNode(tn_2);
		Arrow typeArrow = source.getTypeArrow(target);
		assertEquals(typeGraph.getArrowByName("ta_1"), typeArrow);
		typeArrow = source.getTypeArrow(source);
		assertEquals(typeGraph.getArrowByName("ta_4"), typeArrow);	
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#getIncomingArrows() <em>Get Incoming Arrows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#getIncomingArrows()
	 * @generated NOT
	 */
	public void testGetIncomingArrows() {
		Graph g = CoreFactory.eINSTANCE.createGraph();
		Node n1 = g.createNode("n1");
		Node n2 = g.createNode("n2");
		Node n3 = g.createNode("n3");
		Node n4 = g.createNode("n4");
		
		Arrow e1 = g.createArrow("e1", n1, n2);
		Arrow e4 = g.createArrow("e4", n3, n2);
		Arrow e2 = g.createArrow("e2", n2, n3);
		Arrow e3 = g.createArrow("e3", n2, n1);
		
		assertTrue(n4.getIncomingArrows().size() == 0);

		assertTrue(n1.getIncomingArrows().size() == 1 &&
				n1.getIncomingArrows().get(0) == e3);
		
		assertTrue(n2.getIncomingArrows().size() == 2 &&
				n2.getIncomingArrows().contains(e1) && 
				n2.getIncomingArrows().contains(e4));
		
		assertTrue(n3.getIncomingArrows().size() == 1 &&
				n3.getIncomingArrows().get(0) == e2);
		
		g.deleteArrow(e2);
		assertTrue(n3.getIncomingArrows().size() == 0);
	}

	public void testGenerateUniqueNameWhenInGraph() {
		Node n1 = CoreFactory.eINSTANCE.createNode();
		Node n2 = CoreFactory.eINSTANCE.createNode();
		
		Graph g = CoreFactory.eINSTANCE.createGraph();
		n1.setGraph(g);
		n2.setGraph(g);
		
		n1.setName(n1.generateUniqueName());
		n2.setName(n2.generateUniqueName());
		
		assertFalse(n1.getName().equals(n2.getName()));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.core.Node, no.hib.dpf.core.Edge) <em>Edge Can Make Connection As Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Node#edgeCanMakeConnectionAsTarget(no.hib.dpf.core.Node, no.hib.dpf.core.Edge)
	 * @generated NOT
	 */
	public void testArrowCanMakeConnectionAsTarget__Node_Arrow() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2,te_2:tn_2:tn_1");		
		Node source_tn_1 = typeGraph.getNodeByName("tn_1");
		Node target_tn_2 = typeGraph.getNodeByName("tn_2");
		Arrow te_1 = typeGraph.getArrowByName("te_1");
		
		Node source = CoreFactory.eINSTANCE.createNode(source_tn_1);
		Node target = CoreFactory.eINSTANCE.createNode(target_tn_2);
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(null, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source, te_1));		

		source = CoreFactory.eINSTANCE.createNode();
		target = CoreFactory.eINSTANCE.createNode();
		
		assertTrue(source.arrowCanMakeConnectionAsTarget(target, null));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(target, te_1));		
		assertFalse(source.arrowCanMakeConnectionAsTarget(source, te_1));
		assertFalse(source.arrowCanMakeConnectionAsTarget(null, te_1));		
	}
} //NodeTest
