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
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.InverseSemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Inverse Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class InverseSemanticsTest extends TestCase {

	/**
	 * The fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InverseSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InverseSemanticsTest.class);
	}

	/**
	 * Constructs a new Inverse Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InverseSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InverseSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Inverse Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InverseSemantics getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createInverseSemantics());
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
	 * Tests the '{@link no.hib.dpf.core.Semantics#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Semantics#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 * @generated NOT
	 */
	public void testValidateSemantics__Graph_String_EList_EList() {
		Graph graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z", "f:x:y,g:y:x,h:y:z,i:z:y");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:y:x,h:�:z");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y, z, �", "f:x:y,g:y:x,h:�:z,i:z:�");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
	}

} //InverseSemanticsTest
