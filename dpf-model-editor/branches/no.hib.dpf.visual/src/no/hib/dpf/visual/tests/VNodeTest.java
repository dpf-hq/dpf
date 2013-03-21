/**
 */
package no.hib.dpf.visual.tests;

import junit.textui.TestRunner;

import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>VNode</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VNodeTest extends VElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VNodeTest.class);
	}

	/**
	 * Constructs a new VNode test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VNodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this VNode test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected VNode getFixture() {
		return (VNode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VisualFactory.eINSTANCE.createVNode());
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

} //VNodeTest
