/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import java.util.UUID;

import org.junit.Test;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.MetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>ID Object</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IDObjectTest extends TestCase {

	/**
	 * The fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDObject fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IDObjectTest.class);
	}

	/**
	 * Constructs a new ID Object test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDObjectTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(IDObject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDObject getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createIDObject());
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
	
	@Test
	public void testConstructor() {
		String id = getFixture().getId();
		try {
			UUID.fromString(id);
		} catch (Exception e) {
			fail("Illegal id string from IDObject");
		}
	}

} //IDObjectTest
