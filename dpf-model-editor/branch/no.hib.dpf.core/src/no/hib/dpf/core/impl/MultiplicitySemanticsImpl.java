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
import no.hib.dpf.core.MultiplicitySemantics;
import no.hib.dpf.core.Node;

import no.hib.dpf.core.ValidatorType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MultiplicitySemanticsImpl extends SemanticsValidatorImpl implements MultiplicitySemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicitySemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.MULTIPLICITY_SEMANTICS;
	}

	/**
	 * @generated NOT
	 */
	private int convertValue(int value) {
		if (value == -1) {
			return Integer.MAX_VALUE;
		}
		return value;
	}
	
	/**
	 * @generated NOT
	 */
	private int [] getValuesFromParameters(String parameters) {
		try {
			int [] retval =  new int[2];
			retval[0] = Integer.parseInt(parameters.split(",")[0]);
			retval[1] = Integer.parseInt(parameters.split(",")[1]);
			return retval;
		} catch (Exception e) {
			return new int[]{1, -1};
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		
		if ((typeArrows.size() != 1) || (typeNodes.size() < 1)) {
			return true;
		}
		
		Node typeSourceNode = typeArrows.get(0).getSource();
				
		int [] maxMinValues = getValuesFromParameters(constraintParameters);
		
		
		
		List<Node> sourceNodes = new ArrayList<Node>();		
		for (Node node : oStar.getNodes()) {
			if (node.getTypeNode().equals(typeSourceNode)) {
				sourceNodes.add(node);
			}
		}
		
				
		for (Node sourceNode : sourceNodes) {
			int outgoingArrowCount = sourceNode.getOutgoingArrows().size();
			if (outgoingArrowCount > convertValue(maxMinValues[1])) {
				// Too many connections
				return false;
			} else if (outgoingArrowCount < convertValue(maxMinValues[0])) {
				// Too few connections
				return false;
			}
		}
		
		return true;
	}

} //MultiplicitySemanticsImpl
