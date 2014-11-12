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

import java.util.UUID;

import junit.framework.TestCase;
import no.hib.dpf.core.IDObject;

import org.junit.Test;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>ID Object</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public abstract class IDObjectTest extends TestCase {

	/**
	 * The fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDObject fixture = null;

	/**
	 * Constructs a new ID Object test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDObjectTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(IDObject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this ID Object test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IDObject getFixture() {
		return fixture;
	}

	@Test
	public void testConstructor() {
		String id = getFixture().getId();
		try {
			UUID.fromString(id);
		} catch (Exception e) {
			fail("Illegal id string from IDObject");
		}
	}

} //IDObjectTest
