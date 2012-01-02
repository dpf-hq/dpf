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
import no.hib.dpf.core.IrreflexiveSemantics;
import no.hib.dpf.core.Node;

import no.hib.dpf.core.ValidatorType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Irreflexive Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IrreflexiveSemanticsImpl extends SemanticsValidatorImpl implements IrreflexiveSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IrreflexiveSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.IRREFLEXIVE_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		for (Arrow arrow : oStar.getArrows()) {
			if (arrow.getSource().equals(arrow.getTarget())) {
				return false;
			}
		}
		return true;
	}

} //IrreflexiveSemanticsImpl
