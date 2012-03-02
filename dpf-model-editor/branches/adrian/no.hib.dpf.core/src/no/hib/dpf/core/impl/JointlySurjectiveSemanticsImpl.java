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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.JointlySurjectiveSemantics;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jointly Surjective Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JointlySurjectiveSemanticsImpl extends SemanticsValidatorImpl implements JointlySurjectiveSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JointlySurjectiveSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.JOINTLY_SURJECTIVE_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		if (oStar.getArrows().size() != (oStar.getNodes().size() - 1)) {
			return false;
		}
		if (oStar.getNodes().size() == 1) {
			return false;
		}
		int nodesWithIncomingArrowsCount = 0;
		Node nodeWithOnlyIncoming = null;
		for (Node node : oStar.getNodes()) {
			if (node.getOutgoingArrows().size() == 0) {
				nodesWithIncomingArrowsCount++;
				nodeWithOnlyIncoming = node;
			} else if (node.getOutgoingArrows().size() != 1) {
				return false;
			}
		}
		if (nodesWithIncomingArrowsCount != 1) {
			return false;
		}
		for (Node node : oStar.getNodes()) {
			if (!node.equals(nodeWithOnlyIncoming)) {
				if (node.getArrowto(nodeWithOnlyIncoming) == null) {
					return false;
				}
			}
		}
		return true;
	}


} //JointlySurjectiveSemanticsImpl
