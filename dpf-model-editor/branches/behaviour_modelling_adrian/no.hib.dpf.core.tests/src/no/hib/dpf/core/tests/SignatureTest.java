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
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Signature#save(org.eclipse.emf.common.util.URI) <em>Save</em>}</li>
 *   <li>{@link no.hib.dpf.core.Signature#getPredicateBySymbol(java.lang.String) <em>Get Predicate By Symbol</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SignatureTest extends TestCase {

	/**
	 * The fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Signature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SignatureTest.class);
	}

	/**
	 * Constructs a new Signature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Signature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Signature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Signature getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createSignature());
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
	 * Tests the '{@link no.hib.dpf.core.Signature#save(org.eclipse.emf.common.util.URI) <em>Save</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Signature#save(org.eclipse.emf.common.util.URI)
	 * @generated NOT
	 */
	public void testSave__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		// fail();
	}

	/**
	 * Tests the '{@link no.hib.dpf.core.Signature#getPredicateBySymbol(java.lang.String) <em>Get Predicate By Symbol</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.Signature#getPredicateBySymbol(java.lang.String)
	 * @generated NOT
	 */
	public void testGetPredicateBySymbol__String() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		Predicate p1 = CoreFactory.eINSTANCE.createPredicate("p1", "n_1,n_2,n_3", "e_1:n_1:n_2,e_2:n_1:n_3");
		getFixture().getPredicates().add(p1);
		Predicate p2 = CoreFactory.eINSTANCE.createPredicate("p2", "n_1,n_2", "e_1:n_1:n_2");
		getFixture().getPredicates().add(p2);
		
		assertEquals(p2, getFixture().getPredicateBySymbol("p2"));
		assertEquals(p1, getFixture().getPredicateBySymbol("p1"));
		assertEquals(null, getFixture().getPredicateBySymbol("p3"));
	}

} //SignatureTest
