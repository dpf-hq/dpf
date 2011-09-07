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

import no.hib.dpf.core.Arrow;

import org.eclipse.gef.requests.CreationFactory;

public class ArrowCreationFactory implements CreationFactory {

	Arrow typeEdge;
	
	public ArrowCreationFactory(Object newObject, Arrow typeArrow) {
		this.typeEdge = typeArrow;
	}
	
	@Override
	public Object getNewObject() {
		return null;
	}

	@Override
	public Object getObjectType() {
		return typeEdge;
	}

}
