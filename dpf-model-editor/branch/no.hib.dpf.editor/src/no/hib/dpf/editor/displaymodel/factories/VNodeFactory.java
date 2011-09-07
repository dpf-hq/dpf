/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.factories;

import no.hib.dpf.core.Node;
import no.hib.dpf.editor.displaymodel.DNode;

import org.eclipse.gef.requests.CreationFactory;

public class VNodeFactory implements CreationFactory {
	
	private Node typeNode;

	public VNodeFactory(Node typeNode) {
		this.typeNode = typeNode;
	}
	
	@Override
	public Object getNewObject() {
		DNode retval = new DNode(typeNode);
		return retval;
	}

	@Override
	public Object getObjectType() {
		return DNode.class;
	}

}
