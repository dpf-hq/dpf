/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.commands;

public class BendpointDeleteCommand extends BendpointCommand {

	public void execute() {
		setLocation(getArrow().getBendpoints().get(getIndex()));
		getArrow().getBendpoints().remove(getIndex());
	}

	public void undo() {
		getArrow().getBendpoints().add(getIndex(), getLocation());
	}

}
