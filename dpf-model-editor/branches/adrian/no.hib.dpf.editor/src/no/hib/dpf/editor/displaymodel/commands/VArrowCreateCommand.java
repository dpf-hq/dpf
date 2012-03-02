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
package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.SingleNodeConnection;

import org.eclipse.gef.commands.Command;

/**
 * A command to create an arrow between two nodes. The command can be
 * undone or redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command properly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getConnectionCreateCommand(...)</tt> method, to create a
 * new instance of this class and put it into the CreateConnectionRequest.</li>
 * <li>Override the <tt>getConnectionCompleteCommand(...)</tt> method, to obtain
 * the Command from the ConnectionRequest, call setTarget(...) to set the target
 * endpoint of the connection and return this command instance.</li>
 * </ol>
 * 
 * @see no.hib.dpf.editor.parts.NodeEditPart#createEditPolicies() for an example
 *      of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class VArrowCreateCommand extends Command {
	/** The connection instance. */
	private DArrow arrow;
	private Arrow typeArrow;

	/** Start endpoint for the connection. */
	private final DNode source;
	/** Target endpoint for the connection. */
	private DNode target;

	public VArrowCreateCommand(DNode source, Arrow typeArrow) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");
		this.source = source;
		this.typeArrow = typeArrow;
	}

	public VArrowCreateCommand(DArrow darrow, DNode source2) {
		if(source2 == null) throw new IllegalArgumentException();
		setLabel("connection creation");
		source = source2;
		arrow = darrow;
		typeArrow = darrow.getTypeArrow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		if ((target == null) || (source == null)) {
			return true;
		}
		if (typeArrow == null) {
			return source.canCreateTypedArrow(target);
		}
		return source.arrowCanMakeConnectionAsTarget(target, typeArrow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if (typeArrow == null) {
			typeArrow = source.getTypeArrow(target);
		}
		
		if (!source.equals(target)) {
			arrow = new DArrow(source, target, typeArrow);
		} else {
			arrow = new SingleNodeConnection(source, typeArrow);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		arrow.reconnect();
	}

	/**
	 * Set the target endpoint for the connection.
	 * 
	 * @param target
	 *            that target endpoint (a non-null Shape instance)
	 * @throws IllegalArgumentException
	 *             if target is null
	 */
	public void setTarget(DNode target) {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		arrow.disconnect();
	}
}
