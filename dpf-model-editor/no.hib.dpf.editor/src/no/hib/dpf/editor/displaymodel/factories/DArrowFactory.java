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

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DiagramFactory;

import org.eclipse.gef.requests.CreationFactory;

public class DArrowFactory implements CreationFactory {

	DArrow typeDArrow;
	
	public DArrowFactory(DArrow darrow) {
		typeDArrow = darrow;
	}

	@Override
	public Object getNewObject() {
		DArrow result = DiagramFactory.eINSTANCE.createDArrow();
		result.setDType(typeDArrow);
		return result;
	}

	@Override
	public Object getObjectType() {
		return DArrow.class;
	}

}
