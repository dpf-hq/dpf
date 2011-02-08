/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.tests;

import junit.textui.TestRunner;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getTypeName() <em>Get Type Name</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#generateUniqueName() <em>Generate Unique Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ArrowTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArrowTest.class);
	}

	/**
	 * Constructs a new Arrow test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Arrow test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Arrow getFixture() {
		return (Arrow)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MetamodelFactory.eINSTANCE.createArrow());
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
	 * Tests the '{@link no.hib.dpf.metamodel.Arrow#getTypeName() <em>Get Type Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Arrow#getTypeName()
	 * @generated NOT
	 */
	public void testGetTypeName() {
		Arrow untypedArrow = MetamodelFactory.eINSTANCE.createArrow();
		String typeName = "thearrow";
		untypedArrow.setName(typeName);
		
		assertEquals("", untypedArrow.getTypeName());
		
		Arrow typedArrow = MetamodelFactory.eINSTANCE.createArrow(untypedArrow);
		assertEquals(typeName, typedArrow.getTypeName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.metamodel.Arrow#generateUniqueName() <em>Generate Unique Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.Arrow#generateUniqueName()
	 * @generated NOT NOT NOT!!!
	 */
	public void testGenerateUniqueName() {
		Arrow a1 = MetamodelFactory.eINSTANCE.createArrow();
		Arrow a2 = MetamodelFactory.eINSTANCE.createArrow();
		
		a1.setName(a1.generateUniqueName());
		a2.setName(a2.generateUniqueName());
		
		assertFalse(a1.getName().equals(a2.getName()));
	}
	
	public void testGenerateUniqueNameWhenInGraph() {
		Arrow a1 = MetamodelFactory.eINSTANCE.createArrow();
		Arrow a2 = MetamodelFactory.eINSTANCE.createArrow();
		
		Graph g = MetamodelFactory.eINSTANCE.createGraph();
		
		Node n1 = MetamodelFactory.eINSTANCE.createNode();
		n1.setGraph(g);
		
		a1.setSource(n1);
		a1.setTarget(n1);
		a2.setSource(n1);
		a2.setTarget(n1);
		
		a1.setGraph(g);
		a2.setGraph(g);
		
		a1.setName(a1.generateUniqueName());
		a2.setName(a2.generateUniqueName());
		
		assertFalse("Names are the same", a1.getName().equals(a2.getName()));

		
	}

} //ArrowTest
