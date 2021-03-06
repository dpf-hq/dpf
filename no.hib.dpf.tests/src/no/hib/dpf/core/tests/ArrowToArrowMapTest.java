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

import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arrow To Arrow Map</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArrowToArrowMapTest extends TestCase {

	/**
	 * The fixture for this Arrow To Arrow Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Arrow, Arrow> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArrowToArrowMapTest.class);
	}

	/**
	 * Constructs a new Arrow To Arrow Map test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowToArrowMapTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Arrow To Arrow Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<Arrow, Arrow> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Arrow To Arrow Map test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<Arrow, Arrow> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<Arrow, Arrow>)CoreFactory.eINSTANCE.create(CorePackage.Literals.ARROW_TO_ARROW_MAP));
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
	public void testDefault() {
		// Put in here to avoid error message from no tests in this class
	}
	
} //ArrowToArrowMapTest
