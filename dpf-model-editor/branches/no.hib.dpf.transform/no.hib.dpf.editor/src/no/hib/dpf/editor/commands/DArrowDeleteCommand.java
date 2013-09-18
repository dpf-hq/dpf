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
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;

import org.eclipse.gef.commands.CompoundCommand;

/**
 * A command to disconnect (remove) a connection from its endpoints. The command
 * can be undone or redone.
 * 
 * @author Elias Volanakis
 */
public class DArrowDeleteCommand extends CompoundCommand {

	/** Connection instance to disconnect. */
	private final DArrow connection;
	private DNode source, target;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public DArrowDeleteCommand(DArrow conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection deletion");
		this.connection = conn;
		source = conn.getDSource();
		target = conn.getDTarget();
		for(DConstraint constraint : connection.getDConstraints())
			add(new DConstraintDeleteCommand(constraint));
		if(getCommands().size() == 0)
			add(EmptyExecutableCommand.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		super.execute();
		if(connection.getDSource() == source && connection.getDTarget() == target && source.getDGraph() == target.getDGraph())
			connection.disconnect();
	}
	
	public void redo(){
		execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if(connection.getDSource() == null && connection.getDTarget() == null && source.getDGraph() == target.getDGraph())
			connection.reconnect(source, target);
		super.undo();
	}
}
