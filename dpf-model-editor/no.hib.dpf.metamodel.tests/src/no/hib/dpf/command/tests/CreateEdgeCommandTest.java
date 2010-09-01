/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.tests;

import junit.textui.TestRunner;

import no.hib.dpf.command.CommandFactory;
import no.hib.dpf.command.CreateEdgeCommand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Create Edge Command</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateEdgeCommandTest extends CommandTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CreateEdgeCommandTest.class);
	}

	/**
	 * Constructs a new Create Edge Command test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateEdgeCommandTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Create Edge Command test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CreateEdgeCommand getFixture() {
		return (CreateEdgeCommand)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CommandFactory.eINSTANCE.createCreateEdgeCommand());
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

} //CreateEdgeCommandTest
