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

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Edge To Edge Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgeToEdgeMapTest extends TestCase {

	/**
	 * The fixture for this Edge To Edge Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Edge, Edge> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EdgeToEdgeMapTest.class);
	}

	/**
	 * Constructs a new Edge To Edge Map test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdgeToEdgeMapTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Edge To Edge Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<Edge, Edge> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Edge To Edge Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Edge, Edge> getFixture() {
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
		setFixture((Map.Entry<Edge, Edge>)MetamodelFactory.eINSTANCE.create(MetamodelPackage.Literals.EDGE_TO_EDGE_MAP));
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

} //EdgeToEdgeMapTest
