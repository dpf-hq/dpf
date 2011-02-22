/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;
import no.hib.dpf.metamodel.Specification;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI) <em>Save</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Specification#createOStar(no.hib.dpf.metamodel.Constraint) <em>Create OStar</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SpecificationTest extends TestCase {

	/**
	 * The fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Specification fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SpecificationTest.class);
	}

	/**
	 * Constructs a new Specification test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Specification fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Specification test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Specification getFixture() {
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
		setFixture(MetamodelFactory.eINSTANCE.createSpecification());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI) <em>Save</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Specification#save(org.eclipse.emf.common.util.URI)
	 * @generated
	 */
	public void testSave__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Specification#createOStar(no.hib.dpf.metamodel.Constraint) <em>Create OStar</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Specification#createOStar(no.hib.dpf.metamodel.Constraint)
	 * @generated NOT
	 */
	public void testCreateOStar__Constraint() {
		// Predicates:
		Predicate pred = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2", "e_1:n_1:n_2");
		
		// Creates a type graph, constrained by the predicate:
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		BasicEList<Node> nodes = new BasicEList<Node>();
		nodes.add(typeGraph.getNodeByName("n_1"));
		nodes.add(typeGraph.getNodeByName("n_2"));
	
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(typeGraph.getArrowByName("e_1"));

		Constraint constraint = pred.createConstraint(nodes, arrows, typeGraph);

		Graph instanceGraph = createDefaultInstanceGraph(typeGraph);
		
		
		Specification specification = MetamodelFactory.eINSTANCE.createSpecification();
		specification.setGraph(instanceGraph);
		specification.setTypeGraph(typeGraph);
		
		Graph oStar = specification.createOStar(constraint);
		
		assertNotNull(oStar);
		
		assertEquals(2, oStar.getNodes().size());
		assertEquals(1, oStar.getArrows().size());
		
		assertNotNull(oStar.getNodeByName("n_1"));
		assertNotNull(oStar.getNodeByName("n_2"));
		assertNotNull(oStar.getArrowByName("e_1"));
		
	}
	
	/**
	 * @generated NOT
	 */
	public void testCreateOStar__Constraint__2() {
		// Predicates:
		Predicate pred = MetamodelFactory.eINSTANCE.createPredicate("n_1,n_2,n_3", "a_1:n_1:n_2,a_2:n_3:n_2");
		
		// Creates a type graph, constrained by the predicate:
		Graph typeGraph = MetamodelFactory.eINSTANCE.createGraph("x,y,z,¾", "f:x:y,g:z:y,Œ:z:¾");
		
		BasicEList<Node> nodes = new BasicEList<Node>();
		nodes.add(typeGraph.getNodeByName("x"));
		nodes.add(typeGraph.getNodeByName("y"));
		nodes.add(typeGraph.getNodeByName("z"));
	
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(typeGraph.getArrowByName("f"));
		arrows.add(typeGraph.getArrowByName("g"));
		
		Constraint constraint = pred.createConstraint(nodes, arrows, typeGraph);
		
		Graph instanceGraph = createDefaultInstanceGraph(typeGraph);
		//add the second edge typed by g
		Node y2 = instanceGraph.createNode("y2", typeGraph.getNodeByName("y"));
		instanceGraph.createArrow("g2", instanceGraph.getNodeByName("z"), y2);
		
		// graph: x -> y <- z -> y2
		Specification specification = MetamodelFactory.eINSTANCE.createSpecification();
		specification.setGraph(instanceGraph);
		specification.setTypeGraph(typeGraph);
		
		Graph oStar = specification.createOStar(constraint);
		assertNotNull(oStar);
		
		assertEquals(4, oStar.getNodes().size());
		assertEquals(3, oStar.getArrows().size());
		
		assertNotNull(oStar.getNodeByName("x"));
		assertNotNull(oStar.getNodeByName("y"));
		assertNotNull(oStar.getNodeByName("y2"));
		assertNotNull(oStar.getNodeByName("z"));
		assertNotNull(oStar.getArrowByName("f"));
		assertNotNull(oStar.getArrowByName("g"));
		assertNotNull(oStar.getArrowByName("g2"));
		
		assertEquals("x", oStar.getArrowByName("f").getSource().getName()); 
		assertEquals("y", oStar.getArrowByName("f").getTarget().getName()); 
		assertEquals("z", oStar.getArrowByName("g").getSource().getName()); 
		assertEquals("y", oStar.getArrowByName("g").getTarget().getName()); 
		assertEquals("z", oStar.getArrowByName("g2").getSource().getName()); 
		assertEquals("y2", oStar.getArrowByName("g2").getTarget().getName()); 
	
	}

	private Graph createDefaultInstanceGraph(Graph typeGraph) {
		// Creates an instance graph:
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();
		
		Graph instanceGraph = MetamodelFactory.eINSTANCE.createGraph();
		
		for (Node node : typeGraph.getNodes()) {
			Node newNode = instanceGraph.createNode(node.getName(), node);
			nodeMap.put(node, newNode);
		}
		
		for (Arrow arrow : typeGraph.getArrows()) {
			instanceGraph.createArrow(arrow.getName(), nodeMap.get(arrow.getSource()), nodeMap.get(arrow.getTarget()), arrow);
		}
		return instanceGraph;
	}

	@Test
	public void testDefaultSpecificationHasTypeAndGraphGraph() {
		assertNotNull(getFixture().getTypeGraph());
		assertNotNull(getFixture().getGraph());
	}

} //SpecificationTest
