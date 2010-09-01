/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.tests;

import junit.textui.TestRunner;

import no.hib.dpf.command.CommandFactory;
import no.hib.dpf.command.DeleteEdgeCommand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Delete Edge Command</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeleteEdgeCommandTest extends CommandTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeleteEdgeCommandTest.class);
	}

	/**
	 * Constructs a new Delete Edge Command test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteEdgeCommandTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Delete Edge Command test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeleteEdgeCommand getFixture() {
		return (DeleteEdgeCommand)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommandFactory.eINSTANCE.createDeleteEdgeCommand());
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

} //DeleteEdgeCommandTest
