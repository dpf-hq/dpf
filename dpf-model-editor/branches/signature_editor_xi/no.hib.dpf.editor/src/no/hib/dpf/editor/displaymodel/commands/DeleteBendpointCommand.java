/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;

import org.eclipse.draw2d.Bendpoint;

public class DeleteBendpointCommand extends BendpointCommand {

	private Bendpoint bendpoint;

	public void execute() {
		bendpoint = (Bendpoint) getArrow().getBendpoints().get(getIndex());
		getArrow().removeBendpoint(getIndex());
		super.execute();
	}

	public void undo() {
		super.undo();
		getArrow().insertBendpoint(getIndex(), bendpoint);
	}

}
