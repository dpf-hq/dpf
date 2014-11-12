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

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;

import org.eclipse.gef.requests.CreationFactory;

public class ComposedNodeFactory implements CreationFactory {
	
	private DNode typeDNode;
	
	public ComposedNodeFactory(DNode dnode) {
		typeDNode = dnode;
	}

	@Override
	public Object getNewObject() {
		VCompartmentElement retval = VisualizationFactory.eINSTANCE.createVCompartmentElement();
		DNodeFactory dnFactory = new DNodeFactory(typeDNode);
		retval.setDNode((DNode)dnFactory.getNewObject());
		return retval;
	}

	@Override
	public Object getObjectType() {
		return VCompartmentElement.class;
	}
}
