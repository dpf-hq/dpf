/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.displaymodel.factories;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.requests.CreationFactory;

public class DNodeFactory implements CreationFactory{

	private DNode typeDNode;
	
	public DNodeFactory(DNode dnode) {
		typeDNode = dnode;
	}

	@Override
	public Object getNewObject() {
		DNode newDNode = DiagramFactory.eINSTANCE.createDefaultDNode();
		newDNode.setDType(typeDNode);	
		if(typeDNode.getConfigureString() != null){
			newDNode.setConfigureString(typeDNode.getConfigureString());
		}
		updatePotency(newDNode);	
		updateMutability(newDNode);
		return newDNode;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param newDArrow
	 */
	private void updateMutability(DNode newDNode) {
		Node typeNode = typeDNode.getNode();
		Node newNode = newDNode.getNode();
		newNode.setMutability(typeNode.getMutability());
		
		DGraph dgraph = (DGraph) typeDNode.eContainer();
		if (!DPFTemplateUtils.getTemplateNodes(dgraph).contains(typeNode.getName())) {
			if(typeNode.getMutability() > 0){
				
				Node typeOfTypeNode = typeNode.getTypeNode();
				if(typeOfTypeNode != null && typeOfTypeNode.getMutability() > 0){
					String typeOfTypeNodeValue = typeOfTypeNode.getName();
					String typeNodeValue = typeNode.getName();
					if(!typeNodeValue.equals(typeOfTypeNodeValue)){
						typeNode.setMutability(typeNode.getMutability() - 1);
						newNode.setMutability(typeNode.getMutability());
					}
				}
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param newDNode
	 */
	private void updatePotency(DNode newDNode){
		Node newNode = newDNode.getNode();
		Assert.isNotNull(newNode);
		DNode typeDNode = newDNode.getDType();
		Assert.isNotNull(typeDNode);
		Node typeNode = typeDNode.getNode();
		Assert.isNotNull(typeNode);
		
		// if the potency is set on the typenode, we will decrease its current potency by 1
		if(typeNode.eIsSet(CorePackage.Literals.DEEP_ELEMENT__POTENCY)){
			int typePotency = typeNode.getPotency();
			newNode.setPotency(typePotency - 1);
			newDNode.setNode(newNode);
		}
	}

	@Override
	public Object getObjectType() {
		return DNode.class;
	}
}
