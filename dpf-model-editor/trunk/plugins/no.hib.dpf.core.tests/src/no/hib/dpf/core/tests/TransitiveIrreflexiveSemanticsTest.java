/**
 * <copyright>
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.TransitiveIrreflexiveSemantics;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Transitive Irreflexive Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#validateSemantics(no.hib.dpf.core.Graph, java.lang.String, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Validate Semantics</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TransitiveIrreflexiveSemanticsTest extends TestCase {

	/**
	 * The fixture for this Transitive Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitiveIrreflexiveSemantics fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TransitiveIrreflexiveSemanticsTest.class);
	}

	/**
	 * Constructs a new Transitive Irreflexive Semantics test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitiveIrreflexiveSemanticsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Transitive Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(TransitiveIrreflexiveSemantics fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Transitive Irreflexive Semantics test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitiveIrreflexiveSemantics getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createTransitiveIrreflexiveSemantics());
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
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:x:y");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("y", "g:y:y");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x, y", "f:x:y,g:y:x");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("x,y,z", "f:x:y,g:y:z,h:z:x");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,¾,¿,Œ", "a:a:x,x:x:¾,b:b:y,y:y:¿,c:c:z,z:z:Œ,¾:¾:¿,¿:¿:Œ,xx:x:z");		
		assertTrue(getFixture().validateSemantics(graph, "", null, null));
		graph = CoreFactory.eINSTANCE.createGraph("a,b,c,x,y,z,¾,¿,Œ", "a:a:x,x:x:¾,b:b:y,y:y:¿,c:c:z,z:z:Œ,¾:¾:¿,¿:¿:Œ,xx:x:z,b:Œ:c");		
		assertFalse(getFixture().validateSemantics(graph, "", null, null));
	}

} //TransitiveIrreflexiveSemanticsTest
