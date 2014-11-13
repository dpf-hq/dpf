/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.TransformFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Production</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionTest extends TestCase {

	/**
	 * The fixture for this Production test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Production fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProductionTest.class);
	}

	/**
	 * Constructs a new Production test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Production test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Production fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Production test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Production getFixture() {
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
		setFixture(TransformFactory.eINSTANCE.createProduction());
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

} //ProductionTest
