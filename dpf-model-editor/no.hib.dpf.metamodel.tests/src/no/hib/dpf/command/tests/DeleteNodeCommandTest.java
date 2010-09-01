/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.tests;

import junit.textui.TestRunner;

import no.hib.dpf.command.CommandFactory;
import no.hib.dpf.command.DeleteNodeCommand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Delete Node Command</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeleteNodeCommandTest extends CommandTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeleteNodeCommandTest.class);
	}

	/**
	 * Constructs a new Delete Node Command test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNodeCommandTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Delete Node Command test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeleteNodeCommand getFixture() {
		return (DeleteNodeCommand)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommandFactory.eINSTANCE.createDeleteNodeCommand());
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

} //DeleteNodeCommandTest
