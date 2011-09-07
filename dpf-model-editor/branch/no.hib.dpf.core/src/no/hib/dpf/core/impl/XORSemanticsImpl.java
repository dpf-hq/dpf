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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.XORSemantics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <p>
 * XOR: Semantics: Allow only arrows of one type! But at least one arrow have to be present.
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
		
		//Check invairant constraint:
		if ((typeArrows.size() != 2) || (typeNodes.size() < 1)) {
			System.out.println("breaks XOR");
			return true;
		}
		
		//Check XOR:
		final Node typeSourceNode = typeArrows.get(0).getSource();
		//HashMap for saving arrowType for each source node:
		Map<Node, List<Arrow>> violateArrows = new HashMap<Node, List<Arrow>>();
		for(Node node : oStar.getNodes())
			if(node.getTypeNode() == typeSourceNode){
				boolean xor = true;
				EList<Arrow> outgoing = node.getOutgoingArrows();
				if(outgoing.size() > 0){
					Arrow type = outgoing.get(0).getTypeArrow();
					for(Arrow arrow : node.getOutgoingArrows())
						if(arrow.getTypeArrow() != type){
							xor = false;
							break;
						}
				}else
					xor = false;
				if(!xor)
					violateArrows.put(node, outgoing);

			}
				
		if(!violateArrows.isEmpty()){
			System.out.println("Followings violate XOR Constraint: ");
			Arrow typeArrow0 = typeArrows.get(0);
			Arrow typeArrow1 = typeArrows.get(1);
			String xor0 = typeArrow0.getName() + ": " + typeArrow0.getSource().getName() + "->" + typeArrow0.getTarget().getName();
			String xor1 = typeArrow1.getName() + ": " + typeArrow1.getSource().getName() + "->" + typeArrow1.getTarget().getName();
			for(Entry<Node, List<Arrow>> entry : violateArrows.entrySet()){
				if(entry.getValue().isEmpty())
					System.out.println("\t" + entry.getKey().getName() + " should at least have one arrow typed of " + xor0 + " or " + xor1 + " going out");
			    else{
			    	System.out.println("\tArrows following from " + entry.getKey().getName() + " break XOR constraint on " + xor0 + " and " + xor1);
			    	for(Arrow arrow : entry.getValue())
			    		System.out.println("\t\t" + arrow.getSource().getName() + "->" + arrow.getTarget().getName());
			    }
			}
			System.out.println();  	
		}
		return violateArrows.isEmpty();	
	}

} //XORSemanticsImpl
