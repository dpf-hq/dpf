/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.textui.TestRunner;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Graph#createNode(java.lang.String) <em>Create Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#createArrow(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node) <em>Create Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#applyPredicate(no.hib.dpf.core.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#deleteNode(no.hib.dpf.core.Node) <em>Delete Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#deleteArrow(no.hib.dpf.core.Arrow) <em>Delete Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getNodeByName(java.lang.String) <em>Get Node By Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getArrowByName(java.lang.String) <em>Get Arrow By Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#createNode(java.lang.String, no.hib.dpf.core.Node) <em>Create Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#createArrow(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node, no.hib.dpf.core.Arrow) <em>Create Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#extractSubgraph(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Extract Subgraph</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getNodesForConstraint(no.hib.dpf.core.Constraint) <em>Get Nodes For Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getArrowsForConstraint(no.hib.dpf.core.Constraint) <em>Get Arrows For Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getNodes(org.eclipse.emf.common.util.EList) <em>Get Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getArrows(org.eclipse.emf.common.util.EList) <em>Get Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getCopy() <em>Get Copy</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Graph getFixture() {
		return (Graph)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createGraph());
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
	 * Tests the '{@link no.hib.dpf.core.Graph#createNode(java.lang.String) <em>Create Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#createNode(java.lang.String)
	 * @generated NOT
	 */
	public void testCreateNode__String() {
		Node n = getFixture().createNode("test");
		assertTrue(getFixture().getNodes().contains(n));
		assertEquals("test", n.getName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#createArrow(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node) <em>Create Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#createArrow(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testCreateArrow__String_Node_Node() {
		Node n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Arrow e = getFixture().createArrow("test", n1, n2);
		
		assertTrue(getFixture().getArrows().contains(e));
		assertEquals(n1, e.getSource());
		assertEquals(n2, e.getTarget());
		assertEquals("test", e.getName());
	}
	
	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#createEdge(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node, no.hib.dpf.core.Edge) <em>Create Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#createEdge(java.lang.String, no.hib.dpf.core.Node, no.hib.dpf.core.Node, no.hib.dpf.core.Edge)
	 * @generated NOT
	 */
	public void testCreateArrow__String_Node_Node_Arrow() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2,tn_3", "te_1:tn_1:tn_2,te_2:tn_1:tn_3");

		getFixture().createNode("source", typeGraph.getNodeByName("tn_1"));
		getFixture().createNode("target", typeGraph.getNodeByName("tn_2"));

		Arrow newArrow = getFixture().createArrow("edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"), typeGraph.getArrowByName("te_1"));
		assertEquals(typeGraph.getArrowByName("te_1"), newArrow.getTypeArrow());
		try {
			getFixture().createArrow("edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"), typeGraph.getArrowByName("te_2"));
			fail();
		} catch (AssertionError e) {
		}
	}

	
	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#extractSubgraph(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Extract Subgraph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#extractSubgraph(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testExtractSubgraph__EList_EList() {
		Graph sourceGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2", "e_1:n_1:n_2");
		checkSubgraph(sourceGraph, sourceGraph.getNodes(), sourceGraph.getArrows());

		sourceGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2", "e_1:n_1:n_2");
		EList<Node> nodes = new BasicEList<Node>();
		nodes.add(sourceGraph.getNodeByName("n_1"));
		checkSubgraph(sourceGraph, nodes, new BasicEList<Arrow>());

		sourceGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		nodes = new BasicEList<Node>();
		nodes.add(sourceGraph.getNodeByName("n_1"));
		nodes.add(sourceGraph.getNodeByName("n_2"));
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(sourceGraph.getArrowByName("e_1"));
		checkSubgraph(sourceGraph, nodes, arrows);		
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getNodesForConstraint(no.hib.dpf.core.Constraint) <em>Get Nodes For Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getNodesForConstraint(no.hib.dpf.core.Constraint)
	 * @generated NOT
	 */
	public void testGetNodesForConstraint__Constraint() {
		Predicate pred = CoreFactory.eINSTANCE.createPredicate(null, "n_1,n_2", "e_1:n_1:n_2");
		Graph graph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		BasicEList<Node> nodes = new BasicEList<Node>();
		nodes.add(graph.getNodeByName("n_1"));
		nodes.add(graph.getNodeByName("n_2"));
	
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(graph.getArrowByName("e_1"));
		pred.createConstraint(nodes, arrows);
		Constraint constraint = graph.getNodeByName("n_1").getConstraints().get(0);
		
		EList<Node> constrainedNodes = constraint.getNodes();
		assertEquals(nodes.size(), constrainedNodes.size());
		for(Node nodeInGraph : constrainedNodes) {
			int count = 0;
			for (Node nodeInConstraint : nodes) {
				if(nodeInGraph.equals(nodeInConstraint)) {
					count ++;
				}
			}
			assertEquals("Did not find just 1 matched node", 1, count);
		}
		
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getArrowsForConstraint(no.hib.dpf.core.Constraint) <em>Get Arrows For Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getArrowsForConstraint(no.hib.dpf.core.Constraint)
	 * @generated NOT
	 */
	public void testGetArrowsForConstraint__Constraint() {
		Predicate pred = CoreFactory.eINSTANCE.createPredicate(null, "n_1,n_2", "e_1:n_1:n_2");
		Graph graph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		BasicEList<Node> nodes = new BasicEList<Node>();
		nodes.add(graph.getNodeByName("n_1"));
		nodes.add(graph.getNodeByName("n_2"));
	
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(graph.getArrowByName("e_1"));
		
		pred.createConstraint(nodes, arrows);
		Constraint constraint = graph.getArrowByName("e_1").getConstraints().get(0);
		
		EList<Arrow> constrainedArrows = constraint.getArrows();
		assertEquals(arrows.size(), constrainedArrows.size());
		for(Arrow arrowInGraph : constrainedArrows) {
			int count = 0;
			for (Arrow arrowInConstraint : arrows) {
				if(arrowInGraph.equals(arrowInConstraint)) {
					count ++;
				}
			}
			assertEquals("Did not find just 1 matched arrow", 1, count);
		}
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getNodes(org.eclipse.emf.common.util.EList) <em>Get Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getNodes(org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testGetNodes__EList() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2", "e_1:n_1:n_2");
		
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();
		Graph instanceGraph = CoreFactory.eINSTANCE.createGraph();
		
		for (Node node : typeGraph.getNodes()) {
			Node newNode = instanceGraph.createNode(node.getName(), node);
			nodeMap.put(node, newNode);
		}
		
		for (Arrow arrow : typeGraph.getArrows()) {
			instanceGraph.createArrow(arrow.getName(), nodeMap.get(arrow.getSource()), nodeMap.get(arrow.getTarget()), arrow);
		}
		
		EList<Node> types = new BasicEList<Node>();
		types.add(typeGraph.getNodeByName("n_1"));
		
		EList<Node> typedNodes = instanceGraph.getNodes(types);
		assertEquals(types.size(), typedNodes.size());
		assertEquals(types.get(0), typedNodes.get(0).getTypeNode());
		
		types.add(typeGraph.getNodeByName("n_2"));
		typedNodes = instanceGraph.getNodes(types);
		assertEquals(types.size(), typedNodes.size());
		//FIXME: this depends on the ordering, should be independent of it.
		assertEquals(types.get(0), typedNodes.get(0).getTypeNode());
		assertEquals(types.get(1), typedNodes.get(1).getTypeNode()); 

	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getArrows(org.eclipse.emf.common.util.EList) <em>Get Arrows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getArrows(org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testGetArrows__EList() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();
		Graph instanceGraph = CoreFactory.eINSTANCE.createGraph();
		
		for (Node node : typeGraph.getNodes()) {
			Node newNode = instanceGraph.createNode(node.getName(), node);
			nodeMap.put(node, newNode);
		}
		
		for (Arrow arrow : typeGraph.getArrows()) {
			instanceGraph.createArrow(arrow.getName(), nodeMap.get(arrow.getSource()), nodeMap.get(arrow.getTarget()), arrow);
		}
		
		EList<Arrow> types = new BasicEList<Arrow>();
		types.add(typeGraph.getArrowByName("e_1"));
		
		EList<Arrow> typedArrows = instanceGraph.getArrows(types);
		assertEquals(types.size(), typedArrows.size());
		assertEquals(types.get(0), typedArrows.get(0).getTypeArrow());
		
		types.add(typeGraph.getArrowByName("e_2"));
		typedArrows = instanceGraph.getArrows(types);
		assertEquals(types.size(), typedArrows.size());
		//FIXME: this depends on the ordering, should be independent of it.
		assertEquals(types.get(0), typedArrows.get(0).getTypeArrow());
		assertEquals(types.get(1), typedArrows.get(1).getTypeArrow()); 

	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getCopy() <em>Get Copy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getCopy()
	 * @generated NOT
	 */
	public void testGetCopy() {
		Graph sourceGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2", "e_1:n_1:n_2");
		Graph copy = sourceGraph.getCopy();
		assertEquals(sourceGraph.getNodes().size(), copy.getNodes().size());
		assertEquals(sourceGraph.getArrows().size(), copy.getArrows().size());
		assertNotSame(sourceGraph.getNodeByName("n_1"), copy.getNodeByName("n_1"));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#extractSubgraph(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Extract Subgraph</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#extractSubgraph(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testExtractSubgraph__EList_EList_throws() {
		Graph sourceGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2", "e_1:n_1:n_2");
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(sourceGraph.getArrowByName("e_1"));
		boolean ok = false;
		try {
			checkSubgraph(sourceGraph, new BasicEList<Node>(), arrows);
		} catch (IllegalArgumentException e) {
			ok = true;
		} 
		assert(ok);
	}
	
	
	private void checkSubgraph(Graph sourceGraph, EList<Node> nodes, EList<Arrow> arrows) {
		Graph extractedGraph = sourceGraph.extractSubgraph(nodes, arrows);
		EList<Node> extractedNodes = extractedGraph.getNodes();
		EList<Arrow> extractedArrows = extractedGraph.getArrows();
		
		assertEquals(nodes.size(), extractedNodes.size());
		assertEquals(arrows.size(), extractedArrows.size());
		for (Node node : extractedNodes) {
			assertEquals(node.getTypeNode(), sourceGraph.getNodeByName(node.getName()).getTypeNode());
		}
		for (Arrow arrow : extractedArrows) {
			assertEquals(arrow.getTypeArrow(), sourceGraph.getArrowByName(arrow.getName()).getTypeArrow());
		}
	}



	/**
	 * @generated NOT
	 */
	public void testCreateTypedEdge() {
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("tn_1,tn_2", "te_1:tn_1:tn_2");

		getFixture().createNode("source", typeGraph.getNodeByName("tn_1"));
		getFixture().createNode("target", typeGraph.getNodeByName("tn_2"));
		
		// Should not be able to make an untyped connection between two typed nodes:
		try {
			getFixture().createArrow("not_applicable", getFixture().getNodeByName("target"), getFixture().getNodeByName("source"));
			fail();
		} catch (AssertionError e) {
		}
		
		Arrow newArrow = getFixture().createArrow("new_edge", getFixture().getNodeByName("source"), getFixture().getNodeByName("target"));
		assertEquals(typeGraph.getArrowByName("te_1"), newArrow.getTypeArrow());

	}

	/**
	 * @generated NOT
	 */
	public void testCreateEdge__nullpointer_throws() {
		try {
			CoreFactory.eINSTANCE.createGraph("", "g_edge:null:null");
			fail("Expected exception when adding a dangling edge to a graph");
		} catch(NullPointerException e) {}
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#applyPredicate(no.hib.dpf.core.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Apply Predicate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#applyPredicate(no.hib.dpf.core.Predicate, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testApplyPredicate__Predicate_EList_EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		//fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#deleteNode(no.hib.dpf.core.Node) <em>Delete Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#deleteNode(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testDeleteNode__Node() {
		Node n1 = getFixture().createNode("n1");
		getFixture().deleteNode(n1);
		assertEquals(null, getFixture().getNodeByName("n1"));
		
		n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Arrow a = getFixture().createArrow("test", n1, n2);
		getFixture().deleteNode(n1);
		
		assertFalse(getFixture().getArrows().contains(a));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#deleteEdge(no.hib.dpf.core.Edge) <em>Delete Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#deleteEdge(no.hib.dpf.core.Edge)
	 * @generated NOT
	 */
	public void testDeleteArrow__Arrow() {
		Node n1 = getFixture().createNode("n1");
		Node n2 = getFixture().createNode("n2");
		Arrow a = getFixture().createArrow("test", n1, n2);
		getFixture().deleteArrow(a);
		
		assertFalse(getFixture().getArrows().contains(a));
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getNodeByName(java.lang.String) <em>Get Node By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getNodeByName(java.lang.String)
	 * @generated NOT
	 */
	public void testGetNodeByName__String() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Node n_1 = graph.getNodeByName("n_1");
		Node n_2 = graph.getNodeByName("n_2");
		assertEquals("n_1", n_1.getName());
		assertNotSame("getNodeByName returned wrong object", n_1, n_2);
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getEdgeByName(java.lang.String) <em>Get Edge By Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getEdgeByName(java.lang.String)
	 * @generated NOT
	 */
	public void testGetArrowByName__String() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Arrow e_1 = graph.getArrowByName("e_1");
		Node e_2 = graph.getNodeByName("e_2");
		assertEquals("e_1", e_1.getName());
		assertNotSame("getEdgeByName returned wrong object", e_1, e_2);
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#createNode(java.lang.String, no.hib.dpf.core.Node) <em>Create Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#createNode(java.lang.String, no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testCreateNode__String_Node() {
		Node typeNode = CoreFactory.eINSTANCE.createNode();
		Node typedNode = getFixture().createNode("b", typeNode);
		assertEquals(typeNode, typedNode.getTypeNode());
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Graph#getGraphMember(java.lang.String) <em>Get Graph Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Graph#getGraphMember(java.lang.String)
	 * @generated NOT
	 */
	public void testGetGraphMember__String() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		Arrow e_1 = graph.getArrowByName("e_1");
		Node n_2 = graph.getNodeByName("n_2");
		assertEquals(e_1, graph.getGraphMember(e_1.getId()));
		assertEquals(n_2, graph.getGraphMember(n_2.getId()));
	}

	/**
	 * @generated NOT
	 */
	public static List<Graph> createGraphs(String g_nodes, String h_nodes, String g_edges, String h_edges) {
		List<Graph> retval = new ArrayList<Graph>();		
		retval.add(CoreFactory.eINSTANCE.createGraph(g_nodes, g_edges));
		retval.add(CoreFactory.eINSTANCE.createGraph(h_nodes, h_edges));
		return retval;
	}


} //GraphTest
