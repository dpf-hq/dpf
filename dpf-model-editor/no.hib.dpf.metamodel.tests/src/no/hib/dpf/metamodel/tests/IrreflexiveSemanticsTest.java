/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.IrreflexiveSemantics;
import no.hib.dpf.metamodel.MetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Irreflexive Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IrreflexiveSemanticsTest extends TestCase {

	/**
	 * The fixture for this Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IrreflexiveSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IrreflexiveSemanticsTest.class);
	}

	/**
	 * Constructs a new Irreflexive Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IrreflexiveSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(IrreflexiveSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IrreflexiveSemantics getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createIrreflexiveSemantics());
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

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph_String_EList_EList() {
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = MetamodelFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = MetamodelFactory.eINSTANCE.createGraph("y", "g:y:y");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
	}

} //IrreflexiveSemanticsTest
