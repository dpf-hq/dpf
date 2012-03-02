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

import java.util.Iterator;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DConstraint;


/**
 * A command to create a constraint between two connections. The command can be
 * undone or redone.
 * TODO: generalize the class to accept more than two arrows.
 */
public class MultipleArrowConstraintCreateCommand extends VConstraintCreateCommand {
	private final DArrow source;
	private DArrow target;
	
	private DConstraint.ConstraintType constraintType;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public MultipleArrowConstraintCreateCommand(DArrow source, DArrow target, DConstraint.ConstraintType constraintType, Constraint IDObject) {
		super(IDObject);
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint creation");
		this.source = source;
		this.target = target;
		this.constraintType = constraintType;
	}

	public boolean canExecute() {
		if (source.equals(target)) {
			return false;
		}
		if (doSourceToTargetAlreadyExist()) {
			return false;
		}
		return true;
	}

	private boolean doSourceToTargetAlreadyExist() {
		for (Iterator<DConstraint> iter = source.getSourceConstraints().iterator(); iter.hasNext();) {
			DConstraint constraint = iter.next();
			if (constraint.getConnectionTarget().equals(target)) {
				return true;
			}
		}
		return false;
	}

	public void execute() {
		// create a new connection between source and target
		constraint = new DConstraint(source, target, constraintType, idObject);
	}

}
