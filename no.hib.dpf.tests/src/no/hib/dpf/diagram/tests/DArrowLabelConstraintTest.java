/**
 */
package no.hib.dpf.diagram.tests;

import junit.textui.TestRunner;

import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DiagramFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>DArrow Label Constraint</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DArrowLabelConstraintTest extends DConstraintTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DArrowLabelConstraintTest.class);
	}

	/**
	 * Constructs a new DArrow Label Constraint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrowLabelConstraintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this DArrow Label Constraint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DArrowLabelConstraint getFixture() {
		return (DArrowLabelConstraint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DiagramFactory.eINSTANCE.createDArrowLabelConstraint());
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

} //DArrowLabelConstraintTest
