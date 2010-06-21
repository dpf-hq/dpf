/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;

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
		setFixture((Map.Entry<Node, Node>)MetamodelFactory.eINSTANCE.create(MetamodelPackage.Literals.NODE_TO_NODE_MAP));
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

} //NodeToNodeMapTest
