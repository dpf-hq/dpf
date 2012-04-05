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
 * A representation of the model object '<em><b>Semantics Validator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.SemanticsValidator#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getSemanticsValidator()
 * @model
 * @generated
 */
public interface SemanticsValidator extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hib.dpf.core.ValidatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.core.ValidatorType
	 * @see #setType(ValidatorType)
	 * @see no.hib.dpf.core.CorePackage#getSemanticsValidator_Type()
	 * @model
	 * @generated
	 */
	ValidatorType getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.SemanticsValidator#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.core.ValidatorType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValidatorType value);

	/**
	 * Returns the value of the '<em><b>Validator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validator</em>' attribute.
	 * @see #setValidator(String)
	 * @see no.hib.dpf.core.CorePackage#getSemanticsValidator_Validator()
	 * @model
	 * @generated
	 */
	String getValidator();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.SemanticsValidator#getValidator <em>Validator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validator</em>' attribute.
	 * @see #getValidator()
	 * @generated
	 */
	void setValidator(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNodesMany="true" typeArrowsMany="true"
	 * @generated
	 */
	Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows);

} // SemanticsValidator
