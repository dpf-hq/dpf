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

import java.util.List;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphHomomorphismTest extends TestCase {

	/**
	 * The fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphism fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphHomomorphismTest.class);
	}

	/**
	 * Constructs a new Graph Homomorphism test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphismTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(GraphHomomorphism fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Graph Homomorphism test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphism getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createGraphHomomorphism());
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
	 * @generated NOT
	 */
	private void doTestGHs() {
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn2:gn3", "he1:hn1:hn2,he2:hn1:hn3"), false);		
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn2:hn3"), false);		
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.GraphHomomorphism#canCreateBijectiveGraphHomomorphism(no.hib.dpf.core.Graph, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Can Create Bijective Graph Homomorphism</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.GraphHomomorphism#canCreateBijectiveGraphHomomorphism(no.hib.dpf.core.Graph, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testTryToCreateGraphHomomorphism__Graph_EList_EList() {		
		doTestGHs();
		doTestHomomorphisms();
		doTestHomomorphismsWithExtraGraphElements();		
//		
//		// Check the created mappings
//		
		doTestReturnedMappings(GraphTest.createGraphs("g_node_1", "g_node_1", "g_edge:g_node_1:g_node_1", "h_edge:g_node_1:g_node_1"), new String[]{}, new String[] { "g_edge:h_edge" }, true);		
		doTestReturnedMappings(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", ""), new String[] { "g_node_1:h_node_1", "g_node_2:h_node_2" }, new String[]{}, true);		
		doTestReturnedMappings(GraphTest.createGraphs("g_node_1,g_node_2,g_node_3", "h_node_1,h_node_2,h_node_3", "g_edge_1:g_node_1:g_node_2,g_edge_2:g_node_1:g_node_3", "h_edge_1:h_node_1:h_node_2,h_edge_2:h_node_1:h_node_3"), new String[] { "g_node_1:h_node_1" }, new String[]{ "g_edge_1:h_edge_1", "g_edge_2:h_edge_2"}, true);		
		doTestReturnedMappings(GraphTest.createGraphs("gn1,gn2", "hn1,hn2", "ge:gn1:gn2", "he:hn2:hn1"), new String[] { "gn1:hn2", "gn2:hn1" }, new String[]{ "ge:he" }, true);		
		doTestReturnedMappings(GraphTest.createGraphs("g_node_1,g_node_2,g_node_3", "h_node_1,h_node_2,h_node_3", "g_edge_1:g_node_2:g_node_1,g_edge_2:g_node_3:g_node_1", "h_edge_1:h_node_2:h_node_1,h_edge_2:h_node_3:h_node_1"), new String[] { "g_node_1:h_node_1" }, new String[]{ "g_edge_1:h_edge_1", "g_edge_2:h_edge_2"}, true);
		
		
	}
	
	/**
	 * @generated NOT
	 */
	private void doTestReturnedMappings(List<Graph> graphs, String[] nodeNames, String[] edgeNames, boolean expectedResult) {
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
		graphHomomorphism = graphHomomorphism.createGraphHomomorphism(graphs.get(0), graphs.get(1).getNodes(), graphs.get(1).getArrows());
		assertNotNull(graphHomomorphism);
		for (String nodes : nodeNames) {			
			checkNodeMapping(graphs, nodes.split(":")[0], nodes.split(":")[1], graphHomomorphism);
		}
		for (String edges : edgeNames) {			
			checkEdgeMapping(graphs, edges.split(":")[0], edges.split(":")[1], graphHomomorphism);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void checkEdgeMapping(List<Graph> graphs, String sourceArrowName, String targetArrowName, GraphHomomorphism graphHomomorphism) {
		Arrow source = getArrowFromGraph(graphs.get(0), sourceArrowName); 
		Arrow target = getArrowFromGraph(graphs.get(1), targetArrowName);
		assertEquals(target, graphHomomorphism.getArrowMapping().get(source));		
	}
	
	/**
	 * @generated NOT
	 */
	private void checkNodeMapping(List<Graph> graphs, String sourceNodeName, String targetNodeName, GraphHomomorphism graphHomomorphism) {
		Node source = getNodeFromGraph(graphs.get(0), sourceNodeName); 
		Node target = getNodeFromGraph(graphs.get(1), targetNodeName);
		assertEquals(target, graphHomomorphism.getNodeMapping().get(source));		
	}

	/**
	 * @generated NOT
	 */
	private Arrow getArrowFromGraph(Graph graph, String edgeName) {
		for (Arrow arrow : graph.getArrows()) {
			if (arrow.getName().equals(edgeName)) {
				return arrow;
			}
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	private Node getNodeFromGraph(Graph graph, String nodeName) {
		for (Node node : graph.getNodes()) {
			if (node.getName().equals(nodeName)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Testing simple homomorphisms
	 * @generated NOT
	 */
	private void doTestHomomorphisms() {
		testTryToCreateHomomorphism(GraphTest.createGraphs("", "", "", ""), true);
		// Single nodes, no edges:
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1", "h_node_1", "", ""), true);
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1", "", ""), false);
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", ""), true);
		// Now with an edge:
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", ""), false);
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "", "h_edge_1:h_node_1:h_node_2"), false);
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1,h_node_2", "g_edge_1:g_node_1:g_node_2", "h_edge_1:h_node_1:h_node_2"), true);
		// Map to single edge on single node:
		testTryToCreateHomomorphism(GraphTest.createGraphs("g_node_1,g_node_2", "h_node_1", "g_edge_1:g_node_1:g_node_2", "h_edge_1:h_node_1:h_node_1"), true);

		// Just edges
		testTryToCreateHomomorphism(GraphTest.createGraphs("null", "null", "g_edge:null:null", "h_edge:null:null"), true);		
		testTryToCreateHomomorphism(GraphTest.createGraphs("null", "null", "g_edge:null:null", "h_edge:null:null,h_2:null:null"), false);		
		// 3 nodes/2 edges:
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);
		// Now with the arrows going in different direction in the two graphs:
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn2:hn1,he2:hn2:hn3"), false);
		// 3 nodes, 2 edges, but the edges don't go between all 3 nodes in one graph
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn1:gn3", "he1:hn1:hn2,he2:hn1:hn2"), false);
		// 3 nodes, 3 edges, different order
		testTryToCreateHomomorphism(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn1:gn3,ge3:gn2:gn3", "he1:hn1:hn2,he2:hn2:hn3,he3:hn3:hn1"), false);



	}

	/**
	 * @generated NOT
	 */
	private void doTestHomomorphismsWithExtraGraphElements() {
		testHomomorphismWithExtraGraphElements(GraphTest.createGraphs("gn1,gn2,gn3", "hn1,hn2,hn3", "ge1:gn1:gn2,ge2:gn3:gn2", "he1:hn1:hn2,he2:hn3:hn2"), true);		
		testHomomorphismWithExtraGraphElements2(GraphTest.createGraphs("gn1,gn2", "hn1,hn2,hn3", "ge1:gn1:gn2", "he1:hn1:hn3"), true);		
		testHomomorphismWithExtraGraphElements3(GraphTest.createGraphs("gn1,gn2", "hn1,hn2", "ge1:gn1:gn2", "he1:hn1:hn2"), true);
	}
	
	/**
	 * @generated NOT
	 */
	private void testTryToCreateHomomorphism(List<Graph> graphs, boolean expectedResult) {
		testTryToCreateHomomorphism(graphs.get(0), graphs.get(1).getNodes(), graphs.get(1).getArrows(), expectedResult);
	}
		
	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation.
	 * @generated NOT
	 */
	private void testHomomorphismWithExtraGraphElements(List<Graph> graphs, boolean expectedResult) {
		EList<Node> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<Arrow> edges = new BasicEList<Arrow>(graphs.get(1).getArrows());
		Node n2 = graphs.get(1).createNode("dust");
		graphs.get(1).createArrow("dust", n2, graphs.get(1).getNodes().get(0));
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}

	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation II.
	 * @generated NOT
	 */
	private void testHomomorphismWithExtraGraphElements2(List<Graph> graphs, boolean expectedResult) {
		EList<Node> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<Arrow> edges = new BasicEList<Arrow>(graphs.get(1).getArrows());
		graphs.get(1).createArrow("hn1", graphs.get(1).getNodes().get(0), graphs.get(1).getNodes().get(1));
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}
	
	/**
	 * Mucking about to make shure that only the nodes and edges given in the arguments interfere with
	 * the homomorphism generation III.
	 * @generated NOT
	 * */
	private void testHomomorphismWithExtraGraphElements3(List<Graph> graphs, boolean expectedResult) {
		EList<Node> nodes = new BasicEList<Node>(graphs.get(1).getNodes());
		EList<Arrow> edges = new BasicEList<Arrow>(graphs.get(1).getArrows());
		graphs.get(1).createArrow("hn1", graphs.get(1).getNodes().get(0), graphs.get(1).getNodes().get(0));
		testTryToCreateHomomorphism(graphs.get(0), nodes, edges, expectedResult);
	}
	
	/**
	 * @generated NOT
	 */
	private void testTryToCreateHomomorphism(Graph sourceGraph, EList<Node> nodes, EList<Arrow> edges, boolean expectedResult) {
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
		graphHomomorphism = graphHomomorphism.createGraphHomomorphism(sourceGraph, nodes, edges);
		assertEquals(graphHomomorphism != null, expectedResult);
	}


} //GraphHomomorphismTest
