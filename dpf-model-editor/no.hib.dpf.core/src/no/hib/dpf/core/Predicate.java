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
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Predicate#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#getSemanticsValidator <em>Semantics Validator</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#getParameters <em>Parameters</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link no.hib.dpf.core.Predicate#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject  {
	/**
	 * Returns the value of the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' containment reference.
	 * @see #setShape(Graph)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_Shape()
	 * @model containment="true"
	 * @generated
	 */
	Graph getShape();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getShape <em>Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' containment reference.
	 * @see #getShape()
	 * @generated
	 */
	void setShape(Graph value);

	/**
	 * Returns the value of the '<em><b>Semantics Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantics Validator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantics Validator</em>' containment reference.
	 * @see #setSemanticsValidator(SemanticsValidator)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_SemanticsValidator()
	 * @model containment="true"
	 * @generated
	 */
	SemanticsValidator getSemanticsValidator();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getSemanticsValidator <em>Semantics Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantics Validator</em>' containment reference.
	 * @see #getSemanticsValidator()
	 * @generated
	 */
	void setSemanticsValidator(SemanticsValidator value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute.
	 * @see #setParameters(String)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_Parameters()
	 * @model
	 * @generated
	 */
	String getParameters();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getParameters <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' attribute.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(String value);

	/**
	 * Returns the value of the '<em><b>Visualization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visualization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visualization</em>' containment reference.
	 * @see #setVisualization(Visualization)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_Visualization()
	 * @model containment="true"
	 * @generated
	 */
	Visualization getVisualization();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getVisualization <em>Visualization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visualization</em>' containment reference.
	 * @see #getVisualization()
	 * @generated
	 */
	void setVisualization(Visualization value);

	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_Symbol()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see no.hib.dpf.core.CorePackage#getPredicate_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Predicate#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	Constraint createConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	boolean canCreateConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNodesMany="true" typeArrowsMany="true"
	 * @generated
	 */
	Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validateSemantics(String parameters, GraphHomomorphism mapping, Graph graph);

} // Predicate
