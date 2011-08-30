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
import java.util.Map;

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
		final Map<Node,Arrow> connectedArrows = new HashMap<Node,Arrow>();  
		for (Arrow arrow : oStar.getArrows()) {
			//If arrow start with node of start type:
			if(arrow.getSource().getTypeNode().equals(typeSourceNode)){
				//Is already to this start node a type connected:
				if(connectedArrows.containsKey(arrow.getSource())){
					//The arrow need to have the same type as the already connected one: 
					if(!connectedArrows.get(arrow.getSource()).equals(arrow.getTypeArrow())){
						System.out.println("breaks XOR: Arrow=" + arrow.getName());
						return false;
					}
				}else{
					//Save the arrow type to the node:
					connectedArrows.put(arrow.getSource(),arrow.getTypeArrow());
				}
			}
		}
		
		//Also check if there is at least one instance of one arrow type:
		for(Node n:oStar.getNodes()){
			if(n.getTypeNode().equals(typeSourceNode)){
				if(!connectedArrows.containsKey(n)){
					System.out.println("breaks XOR: Node=" + n.getName());
					return false;
				}
			}
		}
		
		
		return true;	
	}

} //XORSemanticsImpl
