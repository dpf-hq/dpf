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
package no.hib.dpf.visual.presentation;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Node;

import org.eclipse.gef.requests.CreationFactory;

public class NodeFactory implements CreationFactory {
	
	private Node typeDNode;
	
	public NodeFactory(Node dnode) {
		typeDNode = dnode;
	}

	@Override
	public Object getNewObject() {
		Node retval = CoreFactory.eINSTANCE.createDefaultNode();
		retval.setTypeNode(typeDNode);
		return retval;
	}

	@Override
	public Object getObjectType() {
		return Node.class;
	}

}
