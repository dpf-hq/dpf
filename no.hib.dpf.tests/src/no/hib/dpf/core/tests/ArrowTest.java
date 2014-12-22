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
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Arrow#getTypeName() <em>Get Type Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#generateUniqueName() <em>Generate Unique Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#getTemplateElementType() <em>Get Template Element Type</em>}</li>
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
		setFixture(CoreFactory.eINSTANCE.createArrow());
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
	 * Tests the '{@link no.hib.dpf.core.Arrow#getTypeName() <em>Get Type Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Arrow#getTypeName()
	 * @generated NOT
	 */
	public void testGetTypeName() {
		Arrow untypedArrow = CoreFactory.eINSTANCE.createArrow();
		String typeName = "thearrow";
		untypedArrow.setName(typeName);
		
		assertEquals("Arrow", untypedArrow.getTypeName());
		
		Arrow typedArrow = CoreFactory.eINSTANCE.createArrow(null, null, untypedArrow);
		assertEquals(typeName, typedArrow.getTypeName());
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Arrow#generateUniqueName() <em>Generate Unique Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Arrow#generateUniqueName()
	 * @generated NOT NOT NOT!!!
	 */
	public void testGenerateUniqueName() {
		Arrow a1 = CoreFactory.eINSTANCE.createArrow();
		Arrow a2 = CoreFactory.eINSTANCE.createArrow();
		
		a1.setName(a1.generateUniqueName());
		a2.setName(a2.generateUniqueName());
		
		assertFalse(a1.getName().equals(a2.getName()));
	}
	
	/**
	 * Tests the '{@link no.hib.dpf.core.Arrow#getTemplateElementType() <em>Get Template Element Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Arrow#getTemplateElementType()
	 * @generated
	 */
	public void testGetTemplateElementType() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	public void testGenerateUniqueNameWhenInGraph() {
		Arrow a1 = CoreFactory.eINSTANCE.createArrow();
		Arrow a2 = CoreFactory.eINSTANCE.createArrow();
		
		Graph g = CoreFactory.eINSTANCE.createGraph();
		
		Node n1 = CoreFactory.eINSTANCE.createNode();
		g.addNode(n1);
		
		a1.setSource(n1);
		a1.setTarget(n1);
		a2.setSource(n1);
		a2.setTarget(n1);
		
		g.addArrow(a1);
		g.addArrow(a2);
		
		a1.setName(a1.generateUniqueName());
		a2.setName(a2.generateUniqueName());
		
		assertFalse("Names are the same", a1.getName().equals(a2.getName()));

		
	}

} //ArrowTest
