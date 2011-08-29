//TODO The validator is only called when a node is added but not when the arrow is added!

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
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.SurjectiveSemantics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <p>
 * An implementation of the model object '<em><b>Surjective Semantics</b></em>'.
 * </p>
 *
 * @generated
 */
public class SurjectiveSemanticsImpl extends EObjectImpl implements SurjectiveSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SurjectiveSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SURJECTIVE_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		
		//Invariant:
		if ((typeNodes.size() != 2) || (typeArrows.size() != 1)) {
			System.out.println(typeNodes + "break surjective constraint");
			return false;
		}

//TODO Why is the target typenode ***NODE 0***????
		final Node targetTypeNode = typeNodes.get(0);
		final Arrow typeArrow = typeArrows.get(0);
		final List<Node> targetNodes = new ArrayList<Node>();
		
		//Save all nodes that are target of arrows that have the correct type:
		for (Arrow arrow : oStar.getArrows()) {
			if(arrow.getTypeArrow().equals(typeArrow)){
				targetNodes.add(arrow.getTarget());
			}	
		}
		
		//If there is a node that is not in the targetNodeList there is an error:
		for (Node node : oStar.getNodes()) {
			if (node.getTypeNode().equals(targetTypeNode)) {
				if (!targetNodes.contains(node)) {
					System.out.println(node + "break surjective constraint: " + node);
					return false;
				}
			}
		}
		
		return true;	
	}

} //SurjectiveSemanticsImpl
