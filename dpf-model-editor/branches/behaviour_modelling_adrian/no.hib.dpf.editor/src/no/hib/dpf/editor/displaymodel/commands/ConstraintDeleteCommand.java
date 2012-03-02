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

import no.hib.dpf.editor.displaymodel.DConstraint;

import org.eclipse.gef.commands.Command;

/**
 * A command to disconnect (remove) a sonstraint from its endpoints. The command
 * can be undone or redone.
 */
public class ConstraintDeleteCommand extends Command {

	/** Connection instance to disconnect. */
	private final DConstraint constraint;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public ConstraintDeleteCommand(DConstraint constraint) {
		if (constraint == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint deletion");
		this.constraint = constraint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		constraint.disconnect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		constraint.reconnect();
	}
}
