/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.transform.Reduction;
import no.hib.dpf.transform.TransformFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reduction</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReductionTest extends TestCase {

	/**
	 * The fixture for this Reduction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Reduction fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReductionTest.class);
	}

	/**
	 * Constructs a new Reduction test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReductionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Reduction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Reduction fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Reduction test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Reduction getFixture() {
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
		setFixture(TransformFactory.eINSTANCE.createReduction());
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

} //ReductionTest
