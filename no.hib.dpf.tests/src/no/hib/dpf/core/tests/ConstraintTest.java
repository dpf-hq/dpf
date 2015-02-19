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

import junit.textui.TestRunner;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Constraint#reconnect(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Specification) <em>Reconnect</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#disconnect() <em>Disconnect</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#addArrow(no.hib.dpf.core.Arrow) <em>Add Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#addNode(no.hib.dpf.core.Node) <em>Add Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ConstraintTest extends IDObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConstraintTest.class);
	}

	/**
	 * Constructs a new Constraint test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Constraint test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Constraint getFixture() {
		return (Constraint)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CoreFactory.eINSTANCE.createConstraint());
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
	 * Tests the '{@link no.hib.dpf.core.Constraint#reconnect(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Specification) <em>Reconnect</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#reconnect(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList, no.hib.dpf.core.Specification)
	 * @generated NOT
	 */
	public void testReconnect__EList_EList_Specification() {
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#disconnect() <em>Disconnect</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#disconnect()
	 * @generated NOT
	 */
	public void testDisconnect() {
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#addArrow(no.hib.dpf.core.Arrow) <em>Add Arrow</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#addArrow(no.hib.dpf.core.Arrow)
	 * @generated NOT
	 */
	public void testAddArrow__Arrow() {
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#addNode(no.hib.dpf.core.Node) <em>Add Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#addNode(no.hib.dpf.core.Node)
	 * @generated NOT
	 */
	public void testAddNode__Node() {
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidate__EList_EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#validate(no.hib.dpf.core.Graph) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#validate(no.hib.dpf.core.Graph)
	 * @generated NOT
	 */
	public void testValidate__Graph() {
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#getConstrainedNodes() <em>Get Constrained Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#getConstrainedNodes()
	 * @generated NOT
	 */
	public void testGetConstrainedNodes() {
		// No test here, getNodesForConstraint() is already tested in Graph.
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Constraint#getConstrainedArrows() <em>Get Constrained Arrows</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Constraint#getConstrainedArrows()
	 * @generated NOT
	 */
	public void testGetConstrainedArrows() {
		// No test here, getNodesForConstraint() is already tested in Graph.
	}

} //ConstraintTest
