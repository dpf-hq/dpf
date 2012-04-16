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
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core;


import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Arrow#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#getTypeArrow <em>Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.Arrow#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getArrow()
 * @model
 * @generated
 */
public interface Arrow extends IDObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Node#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see no.hib.dpf.core.CorePackage#getArrow_Target()
	 * @see no.hib.dpf.core.Node#getIncomings
	 * @model opposite="incomings"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Arrow#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arrow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arrow</em>' reference.
	 * @see #setTypeArrow(Arrow)
	 * @see no.hib.dpf.core.CorePackage#getArrow_TypeArrow()
	 * @model required="true"
	 * @generated
	 */
	Arrow getTypeArrow();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Arrow#getTypeArrow <em>Type Arrow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Arrow</em>' reference.
	 * @see #getTypeArrow()
	 * @generated
	 */
	void setTypeArrow(Arrow value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Constraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Constraint#getArrows <em>Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getArrow_Constraints()
	 * @see no.hib.dpf.core.Constraint#getArrows
	 * @model opposite="arrows"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Node#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see no.hib.dpf.core.CorePackage#getArrow_Source()
	 * @see no.hib.dpf.core.Node#getOutgoings
	 * @model opposite="outgoings"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Arrow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see no.hib.dpf.core.CorePackage#getArrow_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Arrow#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String generateUniqueName();

	Graph getGraph();
} // Arrow
