/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>command</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandTests extends TestSuite {

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
		TestSuite suite = new CommandTests("command Tests");
		suite.addTestSuite(CreateNodeCommandTest.class);
		suite.addTestSuite(CreateEdgeCommandTest.class);
		suite.addTestSuite(DeleteNodeCommandTest.class);
		suite.addTestSuite(DeleteEdgeCommandTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandTests(String name) {
		super(name);
	}

} //CommandTests
