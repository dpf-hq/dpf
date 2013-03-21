/**
 */
package no.hib.dpf.visualization.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.Visualizations;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Visualizations</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualizationsTest extends TestCase {

	/**
	 * The fixture for this Visualizations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visualizations fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VisualizationsTest.class);
	}

	/**
	 * Constructs a new Visualizations test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Visualizations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Visualizations fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Visualizations test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visualizations getFixture() {
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
		setFixture(VisualizationFactory.eINSTANCE.createVisualizations());
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

} //VisualizationsTest
