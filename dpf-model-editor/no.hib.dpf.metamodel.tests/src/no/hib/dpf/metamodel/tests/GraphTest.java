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
 *   <li>{@link no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#createEdge(java.lang.String, no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node) <em>Create Edge</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}</li>
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
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#applyPredicate(no.hib.dpf.metamodel.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	public void testApplyPredicate__Predicate_EList_EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Graph#getGraphMember(java.lang.String)
	 * @generated
	 */
	public void testGetGraphMember__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}


} //GraphTest
