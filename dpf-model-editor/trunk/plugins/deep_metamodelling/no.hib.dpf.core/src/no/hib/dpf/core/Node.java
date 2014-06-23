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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Node#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getTypeNode <em>Type Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.Node#getOutgoingAttributes <em>Outgoing Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getNode()
 * @model
 * @generated
 */
public interface Node extends IDObject, MutableElement, DeepElement {
	

	
	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Arrow}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Arrow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getNode_Outgoings()
	 * @see no.hib.dpf.core.Arrow#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Arrow> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Arrow}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Arrow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getNode_Incomings()
	 * @see no.hib.dpf.core.Arrow#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Arrow> getIncomings();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Constraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Constraint#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getNode_Constraints()
	 * @see no.hib.dpf.core.Constraint#getNodes
	 * @model opposite="nodes"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Type Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Node</em>' reference.
	 * @see #setTypeNode(Node)
	 * @see no.hib.dpf.core.CorePackage#getNode_TypeNode()
	 * @model required="true"
	 * @generated
	 */
	Node getTypeNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Node#getTypeNode <em>Type Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Node</em>' reference.
	 * @see #getTypeNode()
	 * @generated
	 */
	void setTypeNode(Node value);

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
	 * @see no.hib.dpf.core.CorePackage#getNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Outgoing Attributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.NodeAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.NodeAttribute#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Attributes</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getNode_OutgoingAttributes()
	 * @see no.hib.dpf.core.NodeAttribute#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<NodeAttribute> getOutgoingAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean arrowCanMakeConnectionAsTarget(Node intendedTarget);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canReachTargetByOneArrow(Node target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean arrowCanMakeConnectionAsTarget(Node intendedTarget, Arrow typeEdge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean canReachTargetByTypeArrow(Node target, Arrow typeEdge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Arrow getArrowto(Node target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String generateUniqueName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean canCreateTypedArrow(Node intendedTarget);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Arrow getTypeArrow(Node intendedTarget);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTypeName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTemplateElementType();

	Graph getGraph();

} // Node
