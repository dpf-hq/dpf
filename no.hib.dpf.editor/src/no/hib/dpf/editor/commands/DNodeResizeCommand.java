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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;


/**
 * A command to resize and/or move a VNode.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DNodeResizeCommand extends Command {
	/** Stores the new size and location. */
	private final Dimension newDimension;
	/** Node to manipulate. */
	private final DNode node;

	/** Stores the old size and location. */
	private Dimension oldDimension;

	/**
	 * Create a command that can resize and/or move a shape. 
	 * @param node	the shape to manipulate
	 * @param newDimension the new size
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public DNodeResizeCommand(DNode node, Dimension newDimension) {
		if (node == null || newDimension == null) {
			throw new IllegalArgumentException();
		}
		this.node = node;
		this.newDimension = newDimension.getCopy();
		setLabel("Resize " + node.getNode().getName());
		oldDimension = node.getSize();
	}

	public void execute() {
		node.setSize(newDimension);
	}

	public void undo() {
		node.setSize(oldDimension);
	}
}
