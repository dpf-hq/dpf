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

import no.hib.dpf.diagram.DOffset;


public class BendpointMoveCommand extends BendpointCommand {

	private DOffset oldBendpoint;

	public void execute() {
		getArrow().getBendpoints().set(location.getIndex(), location);
	}

	public DOffset getOldBendpoint() {
		return oldBendpoint;
	}

	public void setOldBendpoint(DOffset point) {
		oldBendpoint = point;
	}

	public void setLocation(DOffset p) {
		setOldBendpoint(location);
		location = p;
	}
	public void undo() {
		if(getOldBendpoint() != null)
			getArrow().getBendpoints().set(location.getIndex(), getOldBendpoint());
	}

}
