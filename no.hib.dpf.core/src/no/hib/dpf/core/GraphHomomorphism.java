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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.GraphHomomorphism#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.core.GraphHomomorphism#getArrowMapping <em>Arrow Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getGraphHomomorphism()
 * @model
 * @generated
 */
public interface GraphHomomorphism extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Mapping</b></em>' map.
	 * The key is of type {@link no.hib.dpf.core.Node},
	 * and the value is of type {@link no.hib.dpf.core.Node},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Mapping</em>' map.
	 * @see no.hib.dpf.core.CorePackage#getGraphHomomorphism_NodeMapping()
	 * @model mapType="no.hib.dpf.core.NodeToNodeMap<no.hib.dpf.core.Node, no.hib.dpf.core.Node>"
	 * @generated
	 */
	EMap<Node, Node> getNodeMapping();

	/**
	 * Returns the value of the '<em><b>Arrow Mapping</b></em>' map.
	 * The key is of type {@link no.hib.dpf.core.Arrow},
	 * and the value is of type {@link no.hib.dpf.core.Arrow},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow Mapping</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow Mapping</em>' map.
	 * @see no.hib.dpf.core.CorePackage#getGraphHomomorphism_ArrowMapping()
	 * @model mapType="no.hib.dpf.core.ArrowToArrowMap<no.hib.dpf.core.Arrow, no.hib.dpf.core.Arrow>"
	 * @generated
	 */
	EMap<Arrow, Arrow> getArrowMapping();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" edgesMany="true"
	 * @generated NOT
	 */
	public List<GraphHomomorphism> createGraphHomomorphism(Graph sourceGraph, EList<Node> nodes, EList<Arrow> edges, boolean test);

} // GraphHomomorphism
