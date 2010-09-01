/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.tests;

import junit.textui.TestRunner;

import no.hib.dpf.command.CommandFactory;
import no.hib.dpf.command.CreateNodeCommand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Create Node Command</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateNodeCommandTest extends CommandTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CreateNodeCommandTest.class);
	}

	/**
	 * Constructs a new Create Node Command test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateNodeCommandTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Create Node Command test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CreateNodeCommand getFixture() {
		return (CreateNodeCommand)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommandFactory.eINSTANCE.createCreateNodeCommand());
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

} //CreateNodeCommandTest
