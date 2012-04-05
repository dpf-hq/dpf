/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>diagram</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramTests extends TestSuite {

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
		TestSuite suite = new DiagramTests("diagram Tests");
		suite.addTestSuite(DSpecificationTest.class);
		suite.addTestSuite(DGraphTest.class);
		suite.addTestSuite(DNodeTest.class);
		suite.addTestSuite(DFakeNodeTest.class);
		suite.addTestSuite(DArrowTest.class);
		suite.addTestSuite(DConstraintTest.class);
		suite.addTestSuite(DArrowLabelConstraintTest.class);
		suite.addTestSuite(DGenericArrowConstraintTest.class);
		suite.addTestSuite(DComposedConstraintTest.class);
		suite.addTestSuite(DSignatureTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramTests(String name) {
		super(name);
	}

} //DiagramTests
