/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>metamodel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelTests extends TestSuite {

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
		TestSuite suite = new MetamodelTests("metamodel Tests");
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
	public MetamodelTests(String name) {
		super(name);
	}

} //MetamodelTests
