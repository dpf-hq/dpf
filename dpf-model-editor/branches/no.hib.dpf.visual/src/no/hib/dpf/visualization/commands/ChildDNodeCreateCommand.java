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
package no.hib.dpf.visualization.commands;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.AbstractCreateCommand;
import no.hib.dpf.visual.presentation.ArrowFactory;
import no.hib.dpf.visualization.VCompartment;

/**
 * A command to add a Shape to a ShapeDiagram.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class ChildDNodeCreateCommand extends AbstractCreateCommand {

	/** Diagram to add to. */
	private final VCompartment compartment;
	private final DNode parent;
	private final DGraph dGraph;

	/**
	 * Create a command that will add a new Shape to a ShapesDiagram.
	 * @param newVNode the new VNode that is to be added
	 * @param parent the ShapesDiagram that will hold the new element
	 * @param dGraph 
	 * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
	 * @throws IllegalArgumentException if any parameter is null, or the request
	 * 						  does not provide a new Shape instance
	 */
	public ChildDNodeCreateCommand(DNode newVNode, DNode parent, VCompartment compartment, DGraph dGraph) {
		this.newObject = newVNode;
		this.parent = parent;
		this.compartment = compartment;
		this.dGraph = dGraph;
		setLabel("shape creation");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return newObject instanceof DNode && compartment != null && parent != null && dGraph != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		// Add the node to the graph
		dGraph.addDNode(newObject);
		
		//compartment.addChild(newObject);
		
		// Add an arrow between the nodes
		Arrow typeArrow = null;
		for(Arrow arrow : dGraph.getGraph().getType().getArrows()) {
			if(arrow.getSource() == parent.getNode().getTypeNode() && arrow.getTarget() == newObject.getNode().getTypeNode())
				typeArrow = arrow;
		}
		ArrowFactory arrowFactory = new ArrowFactory(typeArrow);
		DArrow arrow = (DArrow)arrowFactory.getNewObject();
		arrow.getArrow().setName("child of");
		arrow.reconnect(parent, newObject);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		// Remove figure...
		//parentDGraph.removeDNode((DNode) newObject);
	}

}