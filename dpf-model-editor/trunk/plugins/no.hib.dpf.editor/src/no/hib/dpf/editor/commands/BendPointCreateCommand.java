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
package no.hib.dpf.editor.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramFactory;

public class BendPointCreateCommand extends BendpointCommand {

	protected List<DOffset> one = new ArrayList<DOffset>();
	protected Map<DOffset, DOffset> newMap = new HashMap<DOffset, DOffset>();
	protected Map<DOffset, DOffset> oldMap = new HashMap<DOffset, DOffset>();
	public void execute() {
		getArrow().getBendpoints().add(getIndex(), getLocation());
		for(DOffset offset : one)
			offset.setIndex(offset.getIndex() + 1);
		
		for(Entry<DOffset, DOffset>  entry : newMap.entrySet()){
			entry.getKey().setDOffset(entry.getValue());
		}
	}

	public void undo() {
		for(DOffset offset : one)
			offset.setIndex(offset.getIndex() - 1);
		
		for(Entry<DOffset, DOffset>  entry : oldMap.entrySet()){
			entry.getKey().setDOffset(entry.getValue());
		}
		getArrow().getBendpoints().remove(getIndex());
	}

	public void addUpdate(DOffset offset, DOffset newOffset) {
		newMap.put(offset, newOffset);
		DOffset oldOffset = DiagramFactory.eINSTANCE.createDOffset();
		oldOffset.setDOffset(offset);
		oldMap.put(offset, oldOffset);
	}

	public void addOne(DOffset offset) {
		one.add(offset);
	}

}
