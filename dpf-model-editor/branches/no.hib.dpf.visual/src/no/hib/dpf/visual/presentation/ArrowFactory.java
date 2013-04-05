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


import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;

import org.eclipse.gef.requests.CreationFactory;

public class ArrowFactory implements CreationFactory {

	Arrow typeArrow;
	
	public ArrowFactory(Arrow darrow) {
		typeArrow = darrow;
	}

	@Override
	public Object getNewObject() {
		Arrow result = CoreFactory.eINSTANCE.createDefaultArrow();
		result.setTypeArrow(typeArrow);
		return result;
	}

	@Override
	public Object getObjectType() {
		return Arrow.class;
	}

}
