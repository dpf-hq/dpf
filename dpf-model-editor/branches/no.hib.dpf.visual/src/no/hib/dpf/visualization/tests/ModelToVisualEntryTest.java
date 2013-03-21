/**
 */
package no.hib.dpf.visualization.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.core.IDObject;

import no.hib.dpf.visual.VElement;

import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.VisualizationPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model To Visual Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelToVisualEntryTest extends TestCase {

	/**
	 * The fixture for this Model To Visual Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<IDObject, VElement> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelToVisualEntryTest.class);
	}

	/**
	 * Constructs a new Model To Visual Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelToVisualEntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model To Visual Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<IDObject, VElement> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model To Visual Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<IDObject, VElement> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<IDObject, VElement>)VisualizationFactory.eINSTANCE.create(VisualizationPackage.Literals.MODEL_TO_VISUAL_ENTRY));
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

} //ModelToVisualEntryTest
