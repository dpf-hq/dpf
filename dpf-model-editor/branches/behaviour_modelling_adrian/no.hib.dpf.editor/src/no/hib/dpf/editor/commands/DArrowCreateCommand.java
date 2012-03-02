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

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;

import org.eclipse.core.runtime.Assert;
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
 * @see no.hib.dpf.editor.parts.DNodeEditPart#createEditPolicies() for an example
 *      of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class DArrowCreateCommand extends Command {
	/** Start endpoint for the connection. */
	private DNode source;
	/** Target endpoint for the connection. */
	private DNode target;
	/*
	 * DArrow Type
	 */
	
	private DArrow newDArrow;

	public DArrowCreateCommand(DNode source, DArrow newObject) {
		if (source == null) throw new IllegalArgumentException();
		
		setLabel("connection creation");
		Assert.isTrue(newObject != null);
		this.source = source;
		this.newDArrow = newObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		if (target == null || source == null) 
			return false;
		DArrow type = newDArrow.getDType();
		return type.getDSource() == source.getDType() && type.getDTarget() == target.getDType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		newDArrow.reconnect(source, target);
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
		if (target == null) throw new IllegalArgumentException();
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		newDArrow.disconnect();
	}
}
