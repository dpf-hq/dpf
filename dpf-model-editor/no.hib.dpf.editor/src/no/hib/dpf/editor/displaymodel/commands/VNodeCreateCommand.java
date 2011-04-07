/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
Ê* All rights reserved. This program and the accompanying materials
Ê* are made available under the terms of the Eclipse Public License v1.0
Ê* which accompanies this distribution, and is available at
Ê* http://www.eclipse.org/legal/epl-v10.html
Ê*
Ê* Contributors:
Ê*ÊÊÊÊElias Volanakis - initial API and implementation
Ê*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;



/**
 * A command to add a Shape to a ShapeDiagram.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class VNodeCreateCommand extends Command {
	
/** The new node. */ 
private DNode newVNode;
/** Diagram to add to. */
private final DPFDiagram parent;
/** The bounds of the new VNode. */
private Rectangle bounds;


/**
 * Create a command that will add a new Shape to a ShapesDiagram.
 * @param newVNode the new VNode that is to be added
 * @param parent the ShapesDiagram that will hold the new element
 * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
 * @throws IllegalArgumentException if any parameter is null, or the request
 * 						  does not provide a new Shape instance
 */
public VNodeCreateCommand(DNode newVNode, DPFDiagram parent, Rectangle bounds) {
	this.newVNode = newVNode;
	this.parent = parent;
	this.bounds = bounds;
	setLabel("shape creation");
}

/**
 * Can execute if all the necessary information has been provided. 
 * @see org.eclipse.gef.commands.Command#canExecute()
 */
public boolean canExecute() {
	return newVNode != null && parent != null && bounds != null;
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#execute()
 */
public void execute() {
	newVNode.setLocation(bounds.getLocation());
	Dimension size = bounds.getSize();
	if (size.width > 0 && size.height > 0)
		newVNode.setSize(size);
	addNewShapeToParent();
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#redo()
 */
public void redo() {
	addNewShapeToParent();
}

private void addNewShapeToParent() {
	parent.addChild(newVNode);
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#undo()
 */
public void undo() {
	parent.removeChild(newVNode);
}
	
}