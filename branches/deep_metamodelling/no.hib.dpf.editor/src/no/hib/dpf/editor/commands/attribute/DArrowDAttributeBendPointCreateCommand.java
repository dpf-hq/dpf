/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.commands.attribute;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DOffset;

public class DArrowDAttributeBendPointCreateCommand extends DArrowDAttributeBendpointCommand {

	protected List<DOffset> one = new ArrayList<DOffset>();
	@Override
	public void execute() {
		getDArrowDAttribute().getBendpoints().add(getIndex(), getLocation());
		for(DOffset offset : one)
			offset.setIndex(offset.getIndex() + 1);
	}

	@Override
	public void undo() {
		for(DOffset offset : one)
			offset.setIndex(offset.getIndex() - 1);
		getDArrowDAttribute().getBendpoints().remove(getIndex());
	}

	public void addOne(DOffset offset) {
		one.add(offset);
	}

}
