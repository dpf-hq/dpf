/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.ModelHierarchy;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelHierarchyTest extends TestCase {

	/**
	 * The fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelHierarchy fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelHierarchyTest.class);
	}

	/**
	 * Constructs a new Model Hierarchy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelHierarchyTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ModelHierarchy fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelHierarchy getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createModelHierarchy());
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

} //ModelHierarchyTest
