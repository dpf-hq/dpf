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
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Constraint#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#getMappings <em>Mappings</em>}</li>
 *   <li>{@link no.hib.dpf.core.Constraint#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends IDObject {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Graph#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.core.CorePackage#getConstraint_Graph()
	 * @see no.hib.dpf.core.Graph#getConstraints
	 * @model opposite="constraints" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Constraint#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(Predicate)
	 * @see no.hib.dpf.core.CorePackage#getConstraint_Predicate()
	 * @model
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Constraint#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference.
	 * @see #setMappings(GraphHomomorphism)
	 * @see no.hib.dpf.core.CorePackage#getConstraint_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	GraphHomomorphism getMappings();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Constraint#getMappings <em>Mappings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * This is where the predicate's attribute values (if any) can be set.
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mappings</em>' containment reference.
	 * @see #getMappings()
	 * @generated
	 */
	void setMappings(GraphHomomorphism value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * This is where the predicate's attribute values (if any) can be get.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute.
	 * @see #setParameters(String)
	 * @see no.hib.dpf.core.CorePackage#getConstraint_Parameters()
	 * @model
	 * @generated
	 */
	String getParameters();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Constraint#getParameters <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' attribute.
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Node> getConstrainedNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Arrow> getConstrainedArrows();

} // Constraint
