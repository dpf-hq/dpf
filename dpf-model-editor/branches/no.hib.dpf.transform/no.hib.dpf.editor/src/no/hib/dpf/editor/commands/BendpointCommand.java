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


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DOffset;

import org.eclipse.gef.commands.Command;

public class BendpointCommand extends Command {

	protected int index;
	protected DOffset location;
	protected DArrow arrow;

	protected int getIndex() {
		return index;
	}

	protected DOffset getLocation() {
		return location;
	}

	protected DArrow getArrow() {
		return arrow;
	}

	public void redo() {
		execute();
	}

	public void setIndex(int i) {
		index = i;
	}

	public void setLocation(DOffset p) {
		location = p;
	}

	public void setArrow(DArrow w) {
		arrow = w;
	}

	
}
