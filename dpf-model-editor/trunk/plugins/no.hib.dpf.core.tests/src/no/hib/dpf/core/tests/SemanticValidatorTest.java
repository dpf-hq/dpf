/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.utils.internal.signature.InversePredicate;
import no.hib.dpf.utils.internal.signature.IrreflexivePredicate;
import no.hib.dpf.utils.internal.signature.MultiplicityPredicate;
import no.hib.dpf.utils.internal.signature.SurjectivePredicate;
import no.hib.dpf.utils.internal.signature.XORPredicate;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Semantic Validator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticValidator#validateSemantics(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SemanticValidatorTest extends TestCase {

	/**
	 * The fixture for this Semantic Validator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticValidator fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SemanticValidatorTest.class);
	}

	/**
	 * Constructs a new Semantic Validator test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticValidatorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Semantic Validator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SemanticValidator fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Semantic Validator test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticValidator getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createSemanticValidator());
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
	 * Tests the '{@link no.hib.dpf.core.SemanticValidator#validateSemantics(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.SemanticValidator#validateSemantics(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__EList_EList_EList_EList_EList() {
		testXORPredicate();
		testInversePredicate();
		testIrreflexivePredicate();
		testSurjectivePredicate();
		testMultiPredicate();
	}

//	public void testJSurPredicate() {
//		Predicate predicate = new Join();
//		Graph typeGraph = DPFConstants.REFLEXIVE_TYPE_GRAPH;
//		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:z:y");		
//		assertTrue(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:z:y,�:�:y");		
//		assertTrue(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:z:y,�:z:�");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//	}
	
//	public void testTransitiveIrreflexivePredicate() {
//		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
//		assertTrue(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("y", "g:y:y");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");		
//		assertTrue(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z,h:z:x");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,�,�,�", "a:a:x,x:x:�,b:b:y,y:y:�,c:c:z,z:z:�,�:�:�,�:�:�,xx:x:z");		
//		assertTrue(getFixture().validateSemantics(graph, "", null, null));
//		graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,�,�,�", "a:a:x,x:x:�,b:b:y,y:y:�,c:c:z,z:z:�,�:�:�,�:�:�,xx:x:z,b:�:c");		
//		assertFalse(getFixture().validateSemantics(graph, "", null, null));
//	}
	
	public void testSurjectivePredicate() {
		Predicate predicate = new SurjectivePredicate();
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type", "f_type:x_type:y_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("y", "");
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, false);
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);
		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);
	}
	public void testMultiPredicate() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type", "f_type:x_type:y_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		Predicate predicate = new MultiplicityPredicate();
		testPredicate("min:0,max:1", predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));

		testPredicate("min:1,max:1", predicate, typeGraph, graph, false);
		testPredicate("min:0,max:1", predicate, typeGraph, graph, true);
		
		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));

		testPredicate("min:1,max:1", predicate, typeGraph, graph, true);
		testPredicate("min:4,max:-1", predicate, typeGraph, graph, true);
		
		typeGraph = CoreFactory.eINSTANCE.createGraph("x_type", "f_type:x_type:x_type");
		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		
		testPredicate("min:1,max:1", predicate, typeGraph, graph, true);
		testPredicate("min:4,max:-1", predicate, typeGraph, graph, true);
		testPredicate("min:1,max:1", predicate, typeGraph, graph, false);
		
		typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type", "f_type:x_type:y_type");
		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		
		
		testPredicate("min:0,max:-1", predicate, typeGraph, graph, true);
		testPredicate("min:1,max:-1", predicate, typeGraph, graph, true);
		testPredicate("min:2,max:-1", predicate, typeGraph, graph, false);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		
		testPredicate("min:2,max:-1", predicate, typeGraph, graph, true);
	}
	public void testIrreflexivePredicate() {
		Predicate predicate = new IrreflexivePredicate();
		Graph typeGraph = DPFConstants.REFLEXIVE_TYPE_GRAPH;
		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
		testPredicate(predicate, typeGraph, graph, true);
		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		testPredicate(predicate, typeGraph, graph, true);
		graph = CoreFactory.eINSTANCE.createGraph("y", "g:y:y");		
		testPredicate(predicate, typeGraph, graph, false);
	}
	private void testPredicate(Predicate predicate, Graph type, Graph model, boolean result){
		Constraint constraint = predicate.createConstraint(predicate.getShape().getNodes(), predicate.getShape().getArrows(), type);
		if(constraint != null)
			assertEquals(predicate.validateSemantics(null, constraint.getMappings(), model), result);
	}
	private void testPredicate(String parameters, Predicate predicate, Graph type, Graph model, boolean result){
		Constraint constraint = predicate.createConstraint(predicate.getShape().getNodes(), predicate.getShape().getArrows(), type);
		if(constraint != null){
			constraint.setParameters(parameters);
			assertEquals(predicate.validateSemantics(null, constraint.getMappings(), model), result);
		}
	}
	
	public void testInversePredicate() {
		Predicate predicate = new InversePredicate();
		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");
		Graph typeGraph = DPFConstants.REFLEXIVE_TYPE_GRAPH;
		testPredicate(predicate, typeGraph, graph, true);
		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		testPredicate(predicate, typeGraph, graph, false);
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:y:x,h:y:z,i:z:y");		
		testPredicate(predicate, typeGraph, graph, true);
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:y:x,h:�:z");		
		testPredicate(predicate, typeGraph, graph, false);
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:y:x,h:�:z,i:z:�");		
		testPredicate(predicate, typeGraph, graph, true);
	}
	public void testXORPredicate() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type,z_type", "f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		Predicate predicate = new XORPredicate();
		
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		testPredicate(predicate, typeGraph, graph, false);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, false);
		
		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		testPredicate(predicate, typeGraph, graph, false);
	}
} //SemanticValidatorTest
