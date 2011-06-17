/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.impl.NodeToNodeMapImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Node To Node Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeToNodeMapTest extends TestCase {

	/**
	 * The fixture for this Node To Node Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Node, Node> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodeToNodeMapTest.class);
	}

	/**
	 * Constructs a new Node To Node Map test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeToNodeMapTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Node To Node Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<Node, Node> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Node To Node Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Node, Node> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<Node, Node>)CoreFactory.eINSTANCE.create(CorePackage.Literals.NODE_TO_NODE_MAP));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void testConstruction() {
		NodeToNodeMapImpl nodeToNodeMap = (NodeToNodeMapImpl)CoreFactory.eINSTANCE.create(CorePackage.Literals.NODE_TO_NODE_MAP);
		assertNotNull(nodeToNodeMap);
		
		Graph g = CoreFactory.eINSTANCE.createGraph();
		Graph h = CoreFactory.eINSTANCE.createGraph();

		Node g_n1 = g.createNode("g_n1");		
		Node h_n1 = h.createNode("h_n1");
		
		nodeToNodeMap.setKey(h_n1);
		nodeToNodeMap.setValue(g_n1);
		
		assertEquals(h_n1, nodeToNodeMap.getKey());
		assertEquals(g_n1, nodeToNodeMap.getValue());
	}

} //NodeToNodeMapTest
