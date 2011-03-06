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
import no.hib.dpf.metamodel.InverseSemantics;
import no.hib.dpf.metamodel.MetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Inverse Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class InverseSemanticsTest extends TestCase {

	/**
	 * The fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InverseSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InverseSemanticsTest.class);
	}

	/**
	 * Constructs a new Inverse Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InverseSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InverseSemantics getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createInverseSemantics());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
		assertTrue(getFixture().validateSemantics(graph));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		assertFalse(getFixture().validateSemantics(graph));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:y:x,h:y:z,i:z:y");		
		assertTrue(getFixture().validateSemantics(graph));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z, ¾", "f:x:y,g:y:x,h:¾:z");		
		assertFalse(getFixture().validateSemantics(graph));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z, ¾", "f:x:y,g:y:x,h:¾:z,i:z:¾");		
		assertTrue(getFixture().validateSemantics(graph));
	}

} //InverseSemanticsTest
