/**
 */
package no.hib.dpf.visual.tests;

import junit.textui.TestRunner;

import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VisualFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>VArrow</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VArrowTest extends VElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VArrowTest.class);
	}

	/**
	 * Constructs a new VArrow test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VArrowTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this VArrow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected VArrow getFixture() {
		return (VArrow)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VisualFactory.eINSTANCE.createVArrow());
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

} //VArrowTest
