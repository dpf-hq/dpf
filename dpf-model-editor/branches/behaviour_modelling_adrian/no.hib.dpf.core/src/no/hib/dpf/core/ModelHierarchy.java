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
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.ModelHierarchy#getSpecifications <em>Specifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getModelHierarchy()
 * @model
 * @generated
 */
public interface ModelHierarchy extends EObject {
	/**
	 * Returns the value of the '<em><b>Specifications</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Specification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifications</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifications</em>' containment reference list.
	 * @see no.hib.dpf.core.CorePackage#getModelHierarchy_Specifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Specification> getSpecifications();

} // ModelHierarchy
