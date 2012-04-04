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

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;

/**
 * A command to add a Shape to a ShapeDiagram.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class DNodeCreateCommand extends AbstractCreateCommand {

	/** Diagram to add to. */
	private final DGraph parent;
	/** The bounds of the new VNode. */


	/**
	 * Create a command that will add a new Shape to a ShapesDiagram.
	 * @param newVNode the new VNode that is to be added
	 * @param parent the ShapesDiagram that will hold the new element
	 * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
	 * @throws IllegalArgumentException if any parameter is null, or the request
	 * 						  does not provide a new Shape instance
	 */
	public DNodeCreateCommand(DNode newVNode, DGraph parent) {
		this.newObject =  newVNode;
		this.parent = parent;
		setLabel("shape creation");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return newObject instanceof DNode && parent != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		parent.addDNode((DNode) newObject);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		parent.removeDNode((DNode) newObject);
	}

}