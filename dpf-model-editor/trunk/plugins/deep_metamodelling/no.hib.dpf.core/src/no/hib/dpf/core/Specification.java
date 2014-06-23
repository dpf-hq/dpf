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
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Specification#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getMetaFile <em>Meta File</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getSignatureFile <em>Signature File</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.Specification#getMetalevel <em>Metalevel</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_Graph()
	 * @model containment="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see no.hib.dpf.core.CorePackage#getSpecification_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Meta File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta File</em>' attribute.
	 * @see #setMetaFile(String)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_MetaFile()
	 * @model
	 * @generated
	 */
	String getMetaFile();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getMetaFile <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta File</em>' attribute.
	 * @see #getMetaFile()
	 * @generated
	 */
	void setMetaFile(String value);

	/**
	 * Returns the value of the '<em><b>Signature File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature File</em>' attribute.
	 * @see #setSignatureFile(String)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_SignatureFile()
	 * @model
	 * @generated
	 */
	String getSignatureFile();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getSignatureFile <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature File</em>' attribute.
	 * @see #getSignatureFile()
	 * @generated
	 */
	void setSignatureFile(String value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' reference.
	 * @see #setSignature(Signature)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_Signature()
	 * @model
	 * @generated
	 */
	Signature getSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getSignature <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(Signature value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Specification)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_Type()
	 * @model
	 * @generated
	 */
	Specification getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Specification value);

	/**
	 * Returns the value of the '<em><b>Metalevel</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metalevel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metalevel</em>' attribute.
	 * @see #setMetalevel(int)
	 * @see no.hib.dpf.core.CorePackage#getSpecification_Metalevel()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getMetalevel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Specification#getMetalevel <em>Metalevel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metalevel</em>' attribute.
	 * @see #getMetalevel()
	 * @generated
	 */
	void setMetalevel(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="no.hib.dpf.core.EIOException" uriDataType="no.hib.dpf.core.EURI" resourceSetDataType="no.hib.dpf.core.EResourceSet"
	 * @generated
	 */

	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @model
//	 * @generated
//	 */
//	Graph createOStar(Constraint constraint);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Graph createGraph(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model predicateRequired="true" parametersRequired="true" mappingRequired="true" stuckedNodesMany="true" stuckedArrowsMany="true" typeNodesMany="true" typeArrowsMany="true"
	 * @generated
	 */
	Constraint createConstraint(Predicate predicate, String parameters, GraphHomomorphism mapping, EList<Node> stuckedNodes, EList<Arrow> stuckedArrows, EList<Node> typeNodes, EList<Arrow> typeArrows);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Specification getTemplateSpecification();

} // Specification
