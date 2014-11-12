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

import no.hib.dpf.core.DataNode;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.gef.requests.CreationFactory;

public class DDataNodeFactory implements CreationFactory{

	private DDataNode typeDDatanode;
	
	public DDataNodeFactory(DDataNode ddatanode) {
		this.typeDDatanode = ddatanode;
	}

	@Override
	public Object getNewObject() {
		DDataNode newDDataNode = DiagramFactory.eINSTANCE.createDefaultDDataNode();
		newDDataNode.setDType(typeDDatanode);
		if(typeDDatanode.getConfigureString() != null){
			newDDataNode.setConfigureString(typeDDatanode.getConfigureString());
		}
		newDDataNode.getDatanode().setValue(typeDDatanode.getDatanode().getValue());
		newDDataNode.getDatanode().setDatatype(typeDDatanode.getDatanode().getDatatype());
		updateMutability(newDDataNode);
		return newDDataNode;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param newDArrow
	 */
	private void updateMutability(DDataNode newDDataNode) {
		DataNode typeDataNode = typeDDatanode.getDatanode();
		DataNode newDataNode = newDDataNode.getDatanode();
		newDataNode.setMutability(typeDataNode.getMutability());
		
		if(typeDataNode.getMutability() > 0){
			
			DataNode typeOfTypeDatanode = typeDataNode.getTypeDataNode();
			if(typeOfTypeDatanode != null && typeOfTypeDatanode.getMutability() > 0){
				String typeOfTypeDataNodeValue = typeOfTypeDatanode.getValue();
				String typeDataNodeValue = typeDataNode.getValue();
				if(!typeDataNodeValue.equals(typeOfTypeDataNodeValue)){
					typeDataNode.setMutability(typeDataNode.getMutability() - 1);
					newDataNode.setMutability(typeDataNode.getMutability());
				}
			}
		}
	}

	@Override
	public Object getObjectType() {
		return DDataNode.class;
	}
}
