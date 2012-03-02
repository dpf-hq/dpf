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
import no.hib.dpf.core.ModelHierarchy;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Model Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelHierarchyTest extends TestCase {

	/**
	 * The fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelHierarchy fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ModelHierarchyTest.class);
	}

	/**
	 * Constructs a new Model Hierarchy test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelHierarchyTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ModelHierarchy fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Model Hierarchy test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelHierarchy getFixture() {
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
		setFixture(CoreFactory.eINSTANCE.createModelHierarchy());
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
	
	@Test
	public void testDefaultConstructedModelHierarchyHasOneSpecification() {
		assertEquals(1, getFixture().getSpecifications().size());
	}

} //ModelHierarchyTest
