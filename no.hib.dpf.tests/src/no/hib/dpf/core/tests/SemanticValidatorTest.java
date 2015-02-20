/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.utils.internal.signature.InjectivePredicate;
import no.hib.dpf.utils.internal.signature.IrreflexivePredicate;
import no.hib.dpf.utils.internal.signature.JointlyInjectivePredicate;
import no.hib.dpf.utils.internal.signature.JointlySurjectiveValidator;
import no.hib.dpf.utils.internal.signature.MultiplicityPredicate;
import no.hib.dpf.utils.internal.signature.MergeNANDPredicate;
import no.hib.dpf.utils.internal.signature.SurjectivePredicate;
import no.hib.dpf.utils.internal.signature.XORPredicate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A test case for the model object '
 * <em><b>Semantic Validator</b></em>'. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticValidator fixture = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SemanticValidatorTest.class);
	}

	/**
	 * Constructs a new Semantic Validator test case with the given name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SemanticValidatorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Semantic Validator test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void setFixture(SemanticValidator fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Semantic Validator test case. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SemanticValidator getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createSemanticValidator());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '
	 * {@link no.hib.dpf.core.SemanticValidator#validateSemantics(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * <em>Validate Semantics</em>}' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see no.hib.dpf.core.SemanticValidator#validateSemantics(org.eclipse.emf.common.util.EList,
	 *      org.eclipse.emf.common.util.EList,
	 *      org.eclipse.emf.common.util.EList,
	 *      org.eclipse.emf.common.util.EList,
	 *      org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__EList_EList_EList_EList_EList() {
		testJSurPredicate();
		testInjectivePredicate();
		testXORPredicate();
		//testInversePredicate();
		testIrreflexivePredicate();
		testSurjectivePredicate();
		testMultiPredicate();
		testJInjPredicate();
		testNANDPredicate();
	}

	private void testPredicate(Predicate predicate, EList<Node> nodes, EList<Arrow> arrows, Graph model, boolean result) {
		Constraint constraint = predicate.createConstraint(nodes, arrows);
		if (constraint != null)
			assertEquals(predicate.validateSemantics(null, constraint.getMappings(), model.getNodes(), model.getArrows()), result);
	}

	private void testPredicate(String parameters, Predicate predicate,EList<Node> nodes, EList<Arrow> arrows, Graph model, boolean result) {
		Constraint constraint = predicate.createConstraint(nodes, arrows);// predicate.getShape().getNodes(),
		if (constraint != null) {
			constraint.setParameters(parameters);
			assertEquals( predicate.validateSemantics(parameters,constraint.getMappings(), model.getNodes(), model.getArrows()), result);
		}
	}

	private void testPredicate(Predicate predicate, Graph type, Graph model,boolean result) {
		testPredicate(predicate, type.getNodes(), type.getArrows(), model,result);
	}

	private void testPredicate(String parameters, Predicate predicate,Graph type, Graph model, boolean result) {
		testPredicate(parameters, predicate, type.getNodes(), type.getArrows(),model, result);
	}

	/*public void testInversePredicate() {
		Predicate predicate = new InversePredicate();
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type","f_type:x_type:y_type,g_type:y_type:x_type");

		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, false);
	}*/

	public void testXORPredicate() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph(
				"x_type,y_type,z_type",
				"f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		Predicate predicate = new XORPredicate();

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, false);

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));

		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, false);
	}
	public void testNANDPredicate() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type,z_type","f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		Predicate predicate = new MergeNANDPredicate();

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));

		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);
	}


	public void testJSurPredicate() {
		Predicate predicate = new JointlySurjectiveValidator();

		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type,z_type","f_type:x_type:z_type,g_type:y_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("z", "");
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		testPredicate(predicate, typeGraph, graph, false);

		graph = CoreFactory.eINSTANCE.createGraph("x,z", "f:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:z,g:y:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x1,y,z1,x2,z2", "f:x1:z1,g:y:z1,h:y:z2,i:y:z2");
		graph.getNodeByName("x1").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("x2").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z1").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getNodeByName("z2").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		graph.getArrowByName("h").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("i").setTypeArrow(typeGraph.getArrowByName("g_type"));
		// consider this later
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x1,x2,z", "f:x1:z,g:x2:z");
		graph.getNodeByName("x1").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("x2").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);
	}
	public void testJInjPredicate() {
		Predicate predicate = new JointlyInjectivePredicate();
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type,z_type","f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("z", "");
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,z", "f:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x1,x2,z", "f:x1:z,g:x2:z");
		graph.getNodeByName("x1").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("x2").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("g_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("g_type"));
		testPredicate(predicate, typeGraph, graph, false);

	}

	// public void testTransitiveIrreflexivePredicate() {
	// Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");
	// assertFalse(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");
	// assertTrue(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("y", "g:y:y");
	// assertFalse(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");
	// assertFalse(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");
	// assertTrue(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z,h:z:x");
	// assertFalse(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,�,�,�",
	// "a:a:x,x:x:�,b:b:y,y:y:�,c:c:z,z:z:�,�:�:�,�:�:�,xx:x:z");
	// assertTrue(getFixture().validateSemantics(graph, "", null, null));
	// graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,�,�,�",
	// "a:a:x,x:x:�,b:b:y,y:y:�,c:c:z,z:z:�,�:�:�,�:�:�,xx:x:z,b:�:c");
	// assertFalse(getFixture().validateSemantics(graph, "", null, null));
	// }

	public void testSurjectivePredicate() {
		Predicate predicate = new SurjectivePredicate();
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type",
				"f_type:x_type:y_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("y", "");

		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, false);

		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);

	}

	public void testInjectivePredicate() {
		Predicate predicate = new InjectivePredicate();
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type","f_type:x_type:y_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("y", "");

		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate(predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x1,y,x2", "f:x1:y,g:x2:y");
		graph.getNodeByName("x1").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("x2").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, false);

		graph = CoreFactory.eINSTANCE.createGraph("x1,y1,x2,y2","f:x1:y1,g:x2:y2");
		graph.getNodeByName("x1").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("x2").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y1").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("y2").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));
		testPredicate(predicate, typeGraph, graph, true);
	}

	private void printGraph(Graph graph){
		System.out.println("Graph Node NO. " + graph.getNodes().size());
		System.out.println("Graph Arrow NO. " + graph.getArrows().size());
	}
	public void testMultiPredicate() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type",
				"f_type:x_type:y_type");
		Predicate predicate = new MultiplicityPredicate();

		
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate("min:1;max:1", predicate, typeGraph, graph, false);
		testPredicate("min:0;max:1", predicate, typeGraph, graph, true);

		
		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		testPredicate("min:1;max:1", predicate, typeGraph, graph, true);
		testPredicate("min:4;max:-1", predicate, typeGraph, graph, true);

		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		testPredicate("min:3;max:5", predicate, typeGraph, graph, false);

		typeGraph = CoreFactory.eINSTANCE.createGraph("x_type","f_type:x_type:x_type");
		graph = CoreFactory.eINSTANCE.createGraph("x", "");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		printGraph(graph);
		printGraph(typeGraph);
		testPredicate("min:1;max:1", predicate, typeGraph, graph, false);
		testPredicate("min:4;max:-1", predicate, typeGraph, graph, false);

		typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type","f_type:x_type:y_type");
		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));

		testPredicate("min:0;max:-1", predicate, typeGraph, graph, true);
		testPredicate("min:1;max:5", predicate, typeGraph, graph, true);
		testPredicate("min:2;max:5", predicate, typeGraph, graph, false);

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getArrowByName("f").setTypeArrow(typeGraph.getArrowByName("f_type"));
		graph.getArrowByName("g").setTypeArrow(typeGraph.getArrowByName("f_type"));

		testPredicate("min:2;max:10", predicate, typeGraph, graph, true);
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
} //SemanticValidatorTest
