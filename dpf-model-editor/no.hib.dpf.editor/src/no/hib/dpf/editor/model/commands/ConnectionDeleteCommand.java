/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.model.commands;

import java.util.Iterator;
import java.util.List;

import no.hib.dpf.editor.model.VEdge;
import no.hib.dpf.editor.model.VConstraint;

import org.eclipse.gef.commands.Command;

/**
 * A command to disconnect (remove) a connection from its endpoints. The command
 * can be undone or redone.
 * 
 * @author Elias Volanakis
 */
public class ConnectionDeleteCommand extends Command {

	/** Connection instance to disconnect. */
	private final VEdge connection;

	/** Holds a copy of the outgoing constraints of child. */
	private List<VConstraint> sourceConstraints;
	/** Holds a copy of the incoming constraints of child. */
	private List<VConstraint> targetConstraints;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public ConnectionDeleteCommand(VEdge conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection deletion");
		this.connection = conn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		sourceConstraints = connection.getSourceConstraints();
		targetConstraints = connection.getTargetConstraints();
		disconnectConnectionAndDisconnectConstraints();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		disconnectConnectionAndDisconnectConstraints();
	}

	private void disconnectConnectionAndDisconnectConstraints() {
		connection.disconnect();
		removeConstraints(sourceConstraints);
		removeConstraints(targetConstraints);
	}

	/**
	 * Disconnects a List of Connections from their endpoints.
	 * 
	 * @param connections
	 *            a non-null List of connections
	 */
	private void removeConstraints(List<VConstraint> constraints) {
		for (VConstraint constraint : constraints) {
			constraint.disconnect();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		addConnections(sourceConstraints);
		addConnections(targetConstraints);
		connection.reconnect();
	}

	/*
	 * Reconnects a List of constraints with their previous endpoints.
	 */
	private void addConnections(List<VConstraint> constraints) {
		for (Iterator<VConstraint> iter = constraints.iterator(); iter
				.hasNext();) {
			VConstraint constraint = (VConstraint) iter.next();
			constraint.reconnect();
		}
	}

}
