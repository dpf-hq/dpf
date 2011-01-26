/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.MetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getTypeName() <em>Get Type Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ArrowTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArrowTest.class);
	}

	/**
	 * Constructs a new Arrow test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Arrow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Arrow getFixture() {
		return (Arrow)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createArrow());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Arrow#getTypeName() <em>Get Type Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Arrow#getTypeName()
	 * @generated NOT
	 */
	public void testGetTypeName() {
		Arrow untypedArrow = MetamodelFactory.eINSTANCE.createArrow();
		String typeName = "thearrow";
		untypedArrow.setName(typeName);
		
		assertEquals("", untypedArrow.getTypeName());
		
		Arrow typedArrow = MetamodelFactory.eINSTANCE.createArrow(untypedArrow);
		assertEquals(typeName, typedArrow.getTypeName());
	}

} //ArrowTest
