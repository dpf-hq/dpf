/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.tests;

import junit.textui.TestRunner;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DiagramFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>DFake Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DFakeNodeTest extends DNodeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DFakeNodeTest.class);
	}

	/**
	 * Constructs a new DFake Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFakeNodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this DFake Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DFakeNode getFixture() {
		return (DFakeNode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DiagramFactory.eINSTANCE.createDFakeNode());
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

} //DFakeNodeTest
