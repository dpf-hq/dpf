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

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;

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
		this.parent = child.getDGraph();
		this.child = child;
		List<DArrow> arrows = new ArrayList<DArrow>();
		for(DArrow arrow : child.getDIncomings())
			if(!arrows.contains(arrow)){
				add(new DArrowDeleteCommand(arrow));
				arrows.add(arrow);
			}
		for(DArrow arrow : child.getDOutgoings())
			if(!arrows.contains(arrow)){
				add(new DArrowDeleteCommand(arrow));
				arrows.add(arrow);
			}
		if(getCommands().size() == 0)
			add(EmptyExecutableCommand.INSTANCE);
	}

	public void execute() {
		super.execute();
		child.setDGraph(null);
	}

	public void redo() {
		execute();
	}
	
	public boolean canExecute() {
		return (parent != null && child != null && super.canExecute());
	}
	
	public boolean canUndo() {
		return (parent != null && child != null && super.canUndo());
	}

	public void undo() {
		child.setDGraph(parent);
		super.undo();
	}
}