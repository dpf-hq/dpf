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
import no.hib.dpf.core.XORSemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>XOR Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
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
		setFixture(CoreFactory.eINSTANCE.createXORSemantics());
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
		Graph typeGraph = CoreFactory.eINSTANCE.createGraph("x_type,y_type,z_type", "f_type:x_type:y_type,g_type:x_type:z_type");
		Graph graph = CoreFactory.eINSTANCE.createGraph("x", "");
		
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		
		assertTrue(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));

		graph = CoreFactory.eINSTANCE.createGraph("x,y", "f:x:y,g:x:y");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
		
		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:x:z");
		graph.getNodeByName("x").setTypeNode(typeGraph.getNodeByName("x_type"));		
		graph.getNodeByName("y").setTypeNode(typeGraph.getNodeByName("y_type"));
		graph.getNodeByName("z").setTypeNode(typeGraph.getNodeByName("z_type"));
		assertFalse(getFixture().validateSemantics(graph, "", typeGraph.getNodes(), typeGraph.getArrows()));
	}

} //XORSemanticsTest