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
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.XORSemantics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XOR Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class XORSemanticsImpl extends EObjectImpl implements XORSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XORSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.XOR_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		if ((typeArrows.size() != 2) || (typeNodes.size() < 1)) {
			return true;
		}
		
		Node typeSourceNode = typeArrows.get(0).getSource();
		
		List<Node> sourceNodes = new ArrayList<Node>();		
		for (Node node : oStar.getNodes()) {
			if (node.getTypeNode().equals(typeSourceNode)) {
				sourceNodes.add(node);
			}
		}
		
				
		for (Node sourceNode : sourceNodes) {
			int outgoingArrowCount = sourceNode.getOutgoingArrows().size();
			if (outgoingArrowCount != 1) {
				// Too many or few connections
				return false;
			}
		}
		
		return true;	
	}

} //XORSemanticsImpl
