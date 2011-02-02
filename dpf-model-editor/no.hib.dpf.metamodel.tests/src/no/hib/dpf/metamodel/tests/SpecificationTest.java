/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import org.junit.Test;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Specification;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI) <em>Save</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SpecificationTest extends TestCase {

	/**
	 * The fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Specification fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificationTest.class);
	}

	/**
	 * Constructs a new Specification test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Specification fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Specification getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createSpecification());
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
	
	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI) <em>Save</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI)
	 * @generated
	 */
	public void testSave__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	@Test
	public void testDefaultSpecificationHasTypeAndGraphGraph() {
		assertNotNull(getFixture().getTypeGraph());
		assertNotNull(getFixture().getGraph());
	}

} //SpecificationTest
