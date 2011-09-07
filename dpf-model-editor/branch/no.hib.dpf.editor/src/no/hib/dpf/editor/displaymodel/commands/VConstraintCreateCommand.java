/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.editor.displaymodel.DConstraint;

import org.eclipse.gef.commands.Command;

public abstract class VConstraintCreateCommand extends Command {

	protected DConstraint constraint;
	
	protected Constraint idObject;

	public VConstraintCreateCommand(Constraint idObject) {
		super();
		this.idObject = idObject;
	}

	public VConstraintCreateCommand(String label) {
		super(label);
	}

	public void redo() {
		constraint.reconnect();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		constraint.disconnect();
	}	

}