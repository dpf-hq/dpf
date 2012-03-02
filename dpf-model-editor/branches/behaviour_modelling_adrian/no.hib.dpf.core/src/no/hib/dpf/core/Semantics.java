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
 * A representation of the model object '<em><b>Semantics</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see no.hib.dpf.core.MetamodelPackage#getSemantics()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Semantics extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNodesMany="true" typeArrowsMany="true"
	 * @generated
	 */
	Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows);
} // Semantics
