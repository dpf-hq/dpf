/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>core</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreTests extends TestSuite {

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
		TestSuite suite = new CoreTests("core Tests");
		suite.addTestSuite(GraphTest.class);
		suite.addTestSuite(NodeTest.class);
		suite.addTestSuite(ArrowTest.class);
		suite.addTestSuite(SignatureTest.class);
		suite.addTestSuite(PredicateTest.class);
		suite.addTestSuite(ConstraintTest.class);
		suite.addTestSuite(GraphHomomorphismTest.class);
		suite.addTestSuite(SpecificationTest.class);
		suite.addTestSuite(JointlySurjectiveSemanticsTest.class);
		suite.addTestSuite(InverseSemanticsTest.class);
		suite.addTestSuite(IrreflexiveSemanticsTest.class);
		suite.addTestSuite(MultiplicitySemanticsTest.class);
		suite.addTestSuite(XORSemanticsTest.class);
		suite.addTestSuite(TransitiveIrreflexiveSemanticsTest.class);
		suite.addTestSuite(SurjectiveSemanticsTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreTests(String name) {
		super(name);
	}

} //CoreTests
