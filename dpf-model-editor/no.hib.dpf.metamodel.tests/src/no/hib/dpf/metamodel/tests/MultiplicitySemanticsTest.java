/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.MultiplicitySemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multiplicity Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MultiplicitySemanticsTest extends TestCase {

	/**
	 * The fixture for this Multiplicity Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicitySemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiplicitySemanticsTest.class);
	}

	/**
	 * Constructs a new Multiplicity Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicitySemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Multiplicity Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MultiplicitySemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Multiplicity Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicitySemantics getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createMultiplicitySemantics());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph_String() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y");
		assertTrue(getFixture().validateSemantics(graph, "0,-1"));
		assertTrue(getFixture().validateSemantics(graph, "1,-1"));
		assertFalse(getFixture().validateSemantics(graph, "2,-1"));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");
		assertTrue(getFixture().validateSemantics(graph, "2,-1"));
		graph = MetamodelFactory.eINSTANCE.createGraph("x", "");
		assertFalse(getFixture().validateSemantics(graph, "2,-1"));
		assertTrue(getFixture().validateSemantics(graph, "0,-1"));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");
		assertFalse(getFixture().validateSemantics(graph, "0,1"));
		
	}

} //MultiplicitySemanticsTest
