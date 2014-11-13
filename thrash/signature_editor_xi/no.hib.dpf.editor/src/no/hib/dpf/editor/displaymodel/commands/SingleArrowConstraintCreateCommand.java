/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.SingleArrowConstraintElement;


/**
 * A command to create a constraint on one arrow. The command can be
 * undone or redone.
 */
public class SingleArrowConstraintCreateCommand extends VConstraintCreateCommand {
	private final DArrow arrow;	
	private DConstraint.ConstraintType constraintType;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public SingleArrowConstraintCreateCommand(DArrow arrow, DConstraint.ConstraintType constraintType, Constraint IDObject) {
		super(IDObject);
		if (arrow == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint creation");
		this.arrow = arrow;
		this.constraintType = constraintType;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		// TODO: check for some constraint already set(?)
		return super.canExecute();
	}	

	public void execute() {
		// create a new connection between source and target
		constraint = new SingleArrowConstraintElement(arrow, constraintType, idObject);
	}

}
