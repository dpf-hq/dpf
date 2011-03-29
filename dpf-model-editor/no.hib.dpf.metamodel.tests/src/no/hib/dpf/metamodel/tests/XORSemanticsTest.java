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
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.XORSemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>XOR Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Semantics#validateSemantics(no.hib.dpf.metamodel.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class XORSemanticsTest extends TestCase {

	/**
	 * The fixture for this XOR Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XORSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(XORSemanticsTest.class);
	}

	/**
	 * Constructs a new XOR Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XORSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this XOR Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(XORSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this XOR Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XORSemantics getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createXORSemantics());
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
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("x_type,y_type,z_type", "f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = MetamodelFactory.eINSTANCE.createGraph("x", "");
		
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));

		graph = MetamodelFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));

		graph = MetamodelFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		
		graph = MetamodelFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
	}

} //XORSemanticsTest
