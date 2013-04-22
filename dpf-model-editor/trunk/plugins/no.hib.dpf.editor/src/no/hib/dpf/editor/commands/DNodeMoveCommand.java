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

import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DNode;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;


/**
 * A command to resize and/or move a VNode.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DNodeMoveCommand extends Command {
	/** Stores the new size and location. */
	private final Point newLocation;
	/** Node to manipulate. */
	private final DNode node;

	/** Stores the old size and location. */
	private Point oldLocation;

	/**
	 * Create a command that can resize and/or move a shape. 
	 * @param node	the shape to manipulate
	 * @param newLocation the new location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public DNodeMoveCommand(DNode node, Point newLocation) {
		if (node == null || newLocation == null) {
			throw new IllegalArgumentException();
		}
		String name = null;
		if(node instanceof DConstraintNode){
			name = ((DConstraintNode)node).getDConstraint().getDPredicate().getPredicate().getSymbol();
		}else
			name = node.getNode().getName();
		setLabel("Move " + name);
		this.node = node;
		this.newLocation = newLocation.getCopy();
		oldLocation = node.getLocation();
	}

	public void execute() {
		node.setLocation(newLocation);
	}

	public void undo() {
		node.setLocation(oldLocation);
	}
}
