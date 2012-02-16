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

import no.hib.dpf.diagram.DNode;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.commands.Command;


/**
 * A command to resize and/or move a VNode.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DNodeResizeCommand extends Command {
	/** Stores the new size and location. */
	private final Rectangle newBounds;
	/** Stores the old size and location. */
	private Rectangle oldBounds;

	/** Node to manipulate. */
	private final DNode node;

	/**
	 * Create a command that can resize and/or move a shape. 
	 * @param node	the shape to manipulate
	 * @param req		the move and resize request
	 * @param newBounds the new size and location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public DNodeResizeCommand(DNode node, Rectangle newBounds) {
		if (node == null || newBounds == null) {
			throw new IllegalArgumentException();
		}
		this.node = node;
		this.newBounds = newBounds.getCopy();
		setLabel("move / resize");
		oldBounds = new Rectangle(node.getLocation(), node.getSize());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		node.setSize(newBounds.getSize());
		node.setLocation(newBounds.getLocation());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		node.setSize(oldBounds.getSize());
		node.setLocation(oldBounds.getLocation());
	}
}
