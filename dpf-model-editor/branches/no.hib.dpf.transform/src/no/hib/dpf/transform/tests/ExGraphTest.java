/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.transform.ExGraph;
import no.hib.dpf.transform.TransformFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Ex Graph</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExGraphTest extends TestCase {

	/**
	 * The fixture for this Ex Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExGraphTest.class);
	}

	/**
	 * Constructs a new Ex Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Ex Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ExGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Ex Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExGraph getFixture() {
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
		setFixture(TransformFactory.eINSTANCE.createExGraph());
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

} //ExGraphTest
