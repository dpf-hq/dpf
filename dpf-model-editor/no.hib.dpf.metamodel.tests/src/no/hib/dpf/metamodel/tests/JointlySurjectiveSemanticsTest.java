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
import no.hib.dpf.metamodel.JointlySurjectiveSemantics;
import no.hib.dpf.metamodel.MetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Jointly Surjective Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class JointlySurjectiveSemanticsTest extends TestCase {

	/**
	 * The fixture for this Jointly Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JointlySurjectiveSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(JointlySurjectiveSemanticsTest.class);
	}

	/**
	 * Constructs a new Jointly Surjective Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JointlySurjectiveSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Jointly Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(JointlySurjectiveSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Jointly Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JointlySurjectiveSemantics getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createJointlySurjectiveSemantics());
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
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:z:y");		
		assertTrue(getFixture().validateSemantics(graph, ""));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z, ¾", "f:x:y,g:z:y,Œ:¾:y");		
		assertTrue(getFixture().validateSemantics(graph, ""));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y, z, ¾", "f:x:y,g:z:y,Œ:z:¾");		
		assertFalse(getFixture().validateSemantics(graph, ""));
	}


} //JointlySurjectiveSemanticsTest
