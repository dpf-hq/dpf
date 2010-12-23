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

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.model.VEdge;
import no.hib.dpf.editor.model.DPFDiagram;
import no.hib.dpf.editor.model.VNode;

import org.eclipse.gef.commands.Command;

/**
 * A command to remove a node from its parent. The command can be undone or
 * redone.
 */
public class VNodeDeleteCommand extends Command {
	/** Node to remove. */
	private final VNode child;

	/** Diagram to remove from. */
	private final DPFDiagram parent;
	/** Holds a copy of the outgoing connections of child. */
	private List<ConnectionDeleteCommand> sourceConnectionsDeleteCommands;
	/** Holds a copy of the incoming connections of child. */
	private List<ConnectionDeleteCommand> targetConnectionsDeleteCommands;
	/** True, if child was removed from its parent. */
	private boolean wasRemoved;

	/**
	 * Create a command that will remove the VNode from its parent.
	 * 
	 * @param parent the DPFDiagram containing the child
	 * @param child the VNode to remove
	 * @throws IllegalArgumentException if any parameter is null
	 */
	public VNodeDeleteCommand(DPFDiagram parent, VNode child) {
		if (parent == null || child == null) {
			throw new IllegalArgumentException();
		}
		setLabel("node deletion");
		this.parent = parent;
		this.child = child;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canUndo() {
		return wasRemoved;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		sourceConnectionsDeleteCommands = getDeleteCommands(child.getSourceConnections());
		targetConnectionsDeleteCommands = getDeleteCommands(child.getTargetConnections());
		removeChildAndDisconnectConnections();
	}

	private List<ConnectionDeleteCommand> getDeleteCommands(List<VEdge> connections) {
		List<ConnectionDeleteCommand> retval = new ArrayList<ConnectionDeleteCommand>();
		for (VEdge connection : connections) {
			retval.add(new ConnectionDeleteCommand(connection));
		}
		return retval;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		removeChildAndDisconnectConnections();
	}

	private void removeChildAndDisconnectConnections() {
		wasRemoved = parent.removeChild(child);
		if (wasRemoved) {
			removeConnections(sourceConnectionsDeleteCommands);
			removeConnections(targetConnectionsDeleteCommands);
		}
	}

	/*
	 * Disconnects a List of Connections from their endpoints.
	 */
	private void removeConnections(List<ConnectionDeleteCommand> connections) {
		for (ConnectionDeleteCommand conn : connections) {
			conn.execute();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		// add the child and reconnect its connections
		if (parent.addChild(child)) {
			undoConnectionsRemoval(sourceConnectionsDeleteCommands);
			undoConnectionsRemoval(targetConnectionsDeleteCommands);
		}
	}

	private void undoConnectionsRemoval(List<ConnectionDeleteCommand> connections) {
		for (ConnectionDeleteCommand conn : connections) {
			conn.undo();
		}
	}
	
}