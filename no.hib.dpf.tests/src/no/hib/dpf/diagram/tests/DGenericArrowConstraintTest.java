/**
 */
package no.hib.dpf.diagram.tests;

import junit.textui.TestRunner;

import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DiagramFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>DGeneric Arrow Constraint</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DGenericArrowConstraintTest extends DConstraintTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DGenericArrowConstraintTest.class);
	}

	/**
	 * Constructs a new DGeneric Arrow Constraint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DGenericArrowConstraintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this DGeneric Arrow Constraint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DGenericArrowConstraint getFixture() {
		return (DGenericArrowConstraint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DiagramFactory.eINSTANCE.createDGenericArrowConstraint());
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

} //DGenericArrowConstraintTest
