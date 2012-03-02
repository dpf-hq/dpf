/**
 * <copyright>
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, Øyvind Bech and Dag Viggo Lokøen - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Predicate#createConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph) <em>Create Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#canCreateConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph) <em>Can Create Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PredicateTest extends TestCase {

	/**
	 * The fixture for this Predicate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Predicate fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PredicateTest.class);
	}

	/**
	 * Constructs a new Predicate test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Predicate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Predicate fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Predicate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Predicate getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createPredicate());
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
	 * Tests the '{@link no.hib.dpf.core.Predicate#createConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph) <em>Create Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Predicate#createConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph)
	 * @generated NOT
	 */
	public void testCreateConstraint__EList_EList_Graph() {
		Predicate testPredicate = CoreFactory.eINSTANCE.createPredicate();
		Graph predicateGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		testPredicate.setShape(predicateGraph);
		
		Graph userGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		// Extract "user selected" elements:
		EList<Node> nodes = new BasicEList<Node>();
		nodes.add(userGraph.getNodeByName("n_1"));
		nodes.add(userGraph.getNodeByName("n_2"));
		nodes.add(userGraph.getNodeByName("n_3"));
		
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(userGraph.getArrowByName("e_1"));
		arrows.add(userGraph.getArrowByName("e_2"));
		
		Constraint constraint = testPredicate.createConstraint(nodes, arrows, userGraph);		
		assertNotNull(constraint);
		assertEquals(1, userGraph.getConstraints().size());		
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Predicate#canCreateConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph) <em>Can Create Constraint</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Predicate#canCreateConstraint(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Graph)
	 * @generated NOT
	 */
	public void testCanCreateConstraint__EList_EList_Graph() {
		Predicate testPredicate = CoreFactory.eINSTANCE.createPredicate();
		Graph predicateGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		testPredicate.setShape(predicateGraph);
		
		Graph userGraph = CoreFactory.eINSTANCE.createGraph("n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		
		// Extract "user selected" elements:
		EList<Node> nodes = new BasicEList<Node>();
		nodes.add(userGraph.getNodeByName("n_1"));
		
		EList<Arrow> arrows = new BasicEList<Arrow>();
		arrows.add(userGraph.getArrowByName("e_1"));
		arrows.add(userGraph.getArrowByName("e_2"));
		
		boolean canCreate = testPredicate.canCreateConstraint(nodes, arrows, userGraph);
		assertFalse(canCreate);

		
		nodes.add(userGraph.getNodeByName("n_2"));
		nodes.add(userGraph.getNodeByName("n_3"));
		
		canCreate = testPredicate.canCreateConstraint(nodes, arrows, userGraph);
		assertTrue(canCreate);
		
		assertEquals(0, userGraph.getConstraints().size());
		
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Predicate#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Predicate#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph_String_EList_EList() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:y:z");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		getFixture().setSemanticsValidator(CoreFactory.eINSTANCE.createJointlySurjectiveSemantics());
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
	}

} //PredicateTest
