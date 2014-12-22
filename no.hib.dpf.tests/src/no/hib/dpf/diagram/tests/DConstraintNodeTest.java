/**
 */
package no.hib.dpf.diagram.tests;

import junit.textui.TestRunner;

import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DiagramFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>DConstraint Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DConstraintNodeTest extends DNodeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DConstraintNodeTest.class);
	}

	/**
	 * Constructs a new DConstraint Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DConstraintNodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this DConstraint Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DConstraintNode getFixture() {
		return (DConstraintNode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DiagramFactory.eINSTANCE.createDConstraintNode());
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

} //DConstraintNodeTest
