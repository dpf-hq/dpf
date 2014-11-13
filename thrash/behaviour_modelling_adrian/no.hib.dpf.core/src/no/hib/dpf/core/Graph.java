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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Graph#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.Graph#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends IDObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see no.hib.dpf.core.CorePackage#getGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Graph)
	 * @see no.hib.dpf.core.CorePackage#getGraph_Type()
	 * @model required="true"
	 * @generated
	 */
	Graph getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Graph#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Graph value);

	/**
	 * Returns the value of the '<em><b>Arrows</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Arrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrows</em>' containment reference list.
	 * @see no.hib.dpf.core.CorePackage#getGraph_Arrows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Arrow> getArrows();

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
	 * @see no.hib.dpf.core.CorePackage#getGraph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Graph#getName <em>Name</em>}' attribute.
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
	 * @model
	 * @generated
	 */
	Node createNode(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" edgesMany="true"
	 * @generated
	 */
	Constraint applyPredicate(Predicate predicate, EList<Node> nodes, EList<Arrow> edges);

	/**
	 * <!-- begin-user-doc -->
	 * Returns any IDPointer member of the graph having the provided id value.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	IDObject getGraphMember(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Arrow createArrow(String name, Node source, Node target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteArrow(Arrow edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node getNodeByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Arrow getArrowByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node createNode(String name, Node typeNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Arrow createArrow(String name, Node source, Node target, Arrow typeEdge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	Graph extractSubgraph(EList<Node> nodes, EList<Arrow> arrows);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Node> getNodesForConstraint(Constraint constraint);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Arrow> getArrowsForConstraint(Constraint constraint);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNodesMany="true"
	 * @generated
	 */
	EList<Node> getNodes(EList<Node> typeNodes);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typesMany="true"
	 * @generated
	 */
	EList<Arrow> getArrows(EList<Arrow> types);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Graph getCopy();
	
	void addNode(Node node);
	void addArrow(Arrow arrow);
	void removeNode(Node node);
	void removeArrow(Arrow arrow);
} // Graph
