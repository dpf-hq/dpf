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
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IrreflexiveSemantics;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.TransitiveIrreflexiveSemantics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transitive Irreflexive Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TransitiveIrreflexiveSemanticsImpl extends EObjectImpl implements TransitiveIrreflexiveSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitiveIrreflexiveSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.TRANSITIVE_IRREFLEXIVE_SEMANTICS;
	}

	/**
	 * @generated NOT
	 */
	private List<Node> getNodesWithNoIncomingEdges(Graph g) {
		List<Node> retval = new ArrayList<Node>();
		for (Node node : g.getNodes()) {
			if (node.getIncomingArrows().size() == 0) {
				retval.add(node);
			}
		}
		return retval;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		IrreflexiveSemantics irreflexiveSemantics = CoreFactory.eINSTANCE.createIrreflexiveSemantics();
		if (irreflexiveSemantics.validateSemantics(oStar, constraintParameters, typeNodes, typeArrows) == false) {
			return false;
		}
		/*		
		 * KAAAAAAHHHHNN!!!! (http://en.wikipedia.org/wiki/Topological_sorting)
		*/	
		Graph g = oStar.getCopy();
		List<Node> nodesWithNoIncomingEdges = getNodesWithNoIncomingEdges(g);
		while (!nodesWithNoIncomingEdges.isEmpty()) {
			Node aNode = nodesWithNoIncomingEdges.remove(0);
			for (Arrow outgoingArrow : aNode.getOutgoingArrows()) {
				Node target = outgoingArrow.getTarget();
				g.deleteArrow(outgoingArrow);
				if (target.getIncomingArrows().size() == 0) {
					nodesWithNoIncomingEdges.add(target);
				}
			}
		}
		return (g.getArrows().size() == 0);		
	}

} //TransitiveIrreflexiveSemanticsImpl
