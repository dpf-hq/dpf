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

import no.hib.dpf.diagram.DOffset;


public class DNodeDAttributeBendpointMoveCommand extends DNodeDAttributeBendpointCommand {

	private DOffset oldBendpoint;

	@Override
	public void execute() {
		getDNodeDAttribute().getBendpoints().set(getIndex(), getLocation());
	}

	public DOffset getOldBendpoint() {
		return oldBendpoint;
	}

	public void setOldBendpoint(DOffset point) {
		oldBendpoint = point;
	}

	@Override
	public void setIndex(int i) {
		super.setIndex(i);
		setOldBendpoint(getDNodeDAttribute().getBendpoints().get(i));
	}
	
	@Override
	public void undo() {
		getDNodeDAttribute().getBendpoints().set(getIndex(), getOldBendpoint());
	}

}
