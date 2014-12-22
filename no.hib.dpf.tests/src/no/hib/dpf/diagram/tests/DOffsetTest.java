/**
 */
package no.hib.dpf.diagram.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>DOffset</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DOffsetTest extends TestCase {

	/**
	 * The fixture for this DOffset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DOffset fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DOffsetTest.class);
	}

	/**
	 * Constructs a new DOffset test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DOffsetTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this DOffset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DOffset fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this DOffset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DOffset getFixture() {
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
		setFixture(DiagramFactory.eINSTANCE.createDOffset());
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

} //DOffsetTest
