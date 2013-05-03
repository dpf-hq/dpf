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
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DiagramFactory;

import org.eclipse.gef.requests.CreationFactory;

public class ArrowFactory implements CreationFactory {

	private Arrow typeArrow;
	
	public ArrowFactory(Arrow darrow) {
		typeArrow = darrow;
	}

	@Override
	public Object getNewObject() {
		DArrow retval = DiagramFactory.eINSTANCE.createDefaultDArrow();
		retval.getArrow().setTypeArrow(typeArrow);
		retval.getArrow().setName("");
		return retval;
	}

	@Override
	public Object getObjectType() {
		return DArrow.class;
	}

}
