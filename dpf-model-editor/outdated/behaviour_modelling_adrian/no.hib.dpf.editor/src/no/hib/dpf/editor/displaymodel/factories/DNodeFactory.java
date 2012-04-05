/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.factories;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramFactory;

import org.eclipse.gef.requests.CreationFactory;

public class DNodeFactory implements CreationFactory {
	
	private DNode typeDNode;
	
	public DNodeFactory(DNode dnode) {
		typeDNode = dnode;
	}

	@Override
	public Object getNewObject() {
		DNode retval = DiagramFactory.eINSTANCE.createDNode();
		retval.setDType(typeDNode);
		return retval;
	}

	@Override
	public Object getObjectType() {
		return DNode.class;
	}

}
