/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>transform</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new TransformTests("transform Tests");
		suite.addTestSuite(TransformTest.class);
		suite.addTestSuite(CopiedNodeTest.class);
		suite.addTestSuite(MapArrowTest.class);
		suite.addTestSuite(CopiedArrowTest.class);
		suite.addTestSuite(CopiedConstraintTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformTests(String name) {
		super(name);
	}

} //TransformTests