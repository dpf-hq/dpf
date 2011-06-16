/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.MetamodelFactory;
import no.hib.dpf.core.SurjectiveSemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Surjective Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SurjectiveSemanticsTest extends TestCase {

	/**
	 * The fixture for this Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SurjectiveSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SurjectiveSemanticsTest.class);
	}

	/**
	 * Constructs a new Surjective Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurjectiveSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SurjectiveSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Surjective Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SurjectiveSemantics getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createSurjectiveSemantics());
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
	 * Tests the '{@link no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph_String_EList_EList() {
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("x_type,y_type", "f_type:x_type:y_type");
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("y", "");
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("x_type"));
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		graph = MetamodelFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
	}

} //SurjectiveSemanticsTest
