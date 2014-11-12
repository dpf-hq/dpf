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
package no.hib.dpf.editor.commands.node;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;
import no.hib.dpf.editor.commands.arrow.DArrowDeleteCommand;
import no.hib.dpf.editor.commands.attribute.DNodeAttributeDeleteCommand;
import no.hib.dpf.editor.commands.constraint.DConstraintDeleteCommand;

import org.eclipse.gef.commands.CompoundCommand;

/**
 * A command to remove a node from its parent. The command can be undone or
 * redone.
 */
public class DNodeDeleteCommand extends CompoundCommand {
	/** Node to remove. */
	private final DNode child;
	private final DGraph parent;


	/**
	 * Create a command that will remove the VNode from its parent.
	 * 
	 * @param parent the DPFDiagram containing the child
	 * @param child the VNode to remove
	 * @throws IllegalArgumentException if any parameter is null
	 */
	public DNodeDeleteCommand(DNode child) {

		if (child == null || child.getDGraph() == null) {
			throw new IllegalArgumentException();
		}
		setLabel("node deletion");
		if(child instanceof DConstraintNode){
			parent = null;
			this.child = child;
			add(new DConstraintDeleteCommand(((DConstraintNode)child).getDConstraint()));
			return;
		}
		this.parent = child.getDGraph();
		this.child = child;
		List<DElement> elements = new ArrayList<DElement>();
		for(DArrow arrow : child.getDIncomings()){
			if(!elements.contains(arrow)){
				add(new DArrowDeleteCommand(arrow));
				elements.add(arrow);
			}
		}
		for(DArrow arrow : child.getDOutgoings()){
			if(!elements.contains(arrow)){
				add(new DArrowDeleteCommand(arrow));
				elements.add(arrow);
			}
		}
		
		for(DNodeDAttribute attribute : child.getDOutgoingAttributes()){
			if(!elements.contains(attribute)){
				add(new DNodeAttributeDeleteCommand(attribute));
				elements.add(attribute);
			}
		}
		
		if(getCommands().size() == 0)
			add(EmptyExecutableCommand.INSTANCE);
	}

	@Override
	public boolean canExecute() {
		return ((parent != null || child instanceof DConstraintNode) && super.canExecute());
	}

	@Override
	public boolean canUndo() {
		return ((parent != null || child instanceof DConstraintNode) && super.canUndo());
	}
	
	@Override
	public void execute() {
		super.execute();
		if(parent != null)
			parent.removeDNode(child);
	}
	
	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		if(parent != null)
			parent.addDNode(child);
		super.undo();
	}
}