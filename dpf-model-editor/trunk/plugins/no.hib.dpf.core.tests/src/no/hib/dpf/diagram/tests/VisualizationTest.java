/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.Visualization;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Visualization</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualizationTest extends TestCase {

	/**
	 * The fixture for this Visualization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visualization fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VisualizationTest.class);
	}

	/**
	 * Constructs a new Visualization test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Visualization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Visualization fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Visualization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visualization getFixture() {
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
		setFixture(DiagramFactory.eINSTANCE.createVisualization());
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

} //VisualizationTest
