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

import no.hib.dpf.diagram.DOffset;

public class BendPointCreateCommand extends BendpointCommand {

	protected List<DOffset> invalid = new ArrayList<DOffset>();
	protected List<ArrowLabelMoveCommand> commands = new ArrayList<ArrowLabelMoveCommand>();
	public void execute() {
		getArrow().getBendpoints().add(location.getIndex(), location);
		for(DOffset offset : invalid)
			offset.setIndex(offset.getIndex() + 1);
		for(ArrowLabelMoveCommand cmd : commands){
			cmd.execute();
		}
	}

	public void undo() {
		for(DOffset offset : invalid)
			offset.setIndex(offset.getIndex() - 1);
		getArrow().getBendpoints().remove(location.getIndex());
		for(ArrowLabelMoveCommand cmd : commands){
			cmd.undo();
		}
	}

	public void addInvalid(DOffset offset) {
		invalid.add(offset);
	}
	public void add(ArrowLabelMoveCommand cmd){
		commands.add(cmd);
	}

}
