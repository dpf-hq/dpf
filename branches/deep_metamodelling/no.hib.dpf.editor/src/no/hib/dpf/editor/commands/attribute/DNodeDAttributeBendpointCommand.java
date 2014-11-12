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

 
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;

import org.eclipse.gef.commands.Command;

public class DNodeDAttributeBendpointCommand extends Command {

	protected int index;
	protected DOffset location;
	protected DNodeDAttribute dattribute;

	protected int getIndex() {
		return index;
	}

	protected DOffset getLocation() {
		return location;
	}

	protected DNodeDAttribute getDNodeDAttribute() {
		return dattribute;
	}

	@Override
	public void redo() {
		execute();
	}

	public void setIndex(int i) {
		index = i;
	}

	public void setLocation(DOffset p) {
		location = p;
	}

	public void setDNodeDAttribute(DNodeDAttribute w) {
		dattribute = w;
	}

	
}
