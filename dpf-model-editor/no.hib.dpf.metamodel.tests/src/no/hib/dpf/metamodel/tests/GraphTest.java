/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.TestCase;

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
 *   <li>{@link no.hib.dpf.metamodel.Graph#createEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node) <em>Create Edge</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphTest extends TestCase {

	/**
	 * The fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph fixture = null;

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
	 * Sets the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Graph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph getFixture() {
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
	 * @generated
	 */
	public void testCreateNode__String() {
		Node n = fixture.createNode("test");
		assertTrue(fixture.getNodes().contains(n));
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#createEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node) <em>Create Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#createEdge(no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node)
	 * @generated
	 */
	public void testCreateEdge__Node_Node() {
		Node n1 = fixture.createNode("n1");
		Node n2 = fixture.createNode("n2");
		Edge e = fixture.createEdge(n1, n2);
		
		assertTrue(fixture.getEdges().contains(e));
		assertEquals(n1, e.getSource());
		assertEquals(n2, e.getTarget());
	}

} //GraphTest
