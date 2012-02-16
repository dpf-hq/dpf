/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.commands;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;

/**
 * A command to disconnect (remove) a sonstraint from its endpoints. The command
 * can be undone or redone.
 */
public class DConstraintDeleteCommand extends Command {

	/** Connection instance to disconnect. */
	private final DConstraint constraint;
	private EList<DNode> dnodes = new BasicEList<DNode>();
	private EList<DArrow> darrows = new BasicEList<DArrow>();
	private DSpecification specification;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public DConstraintDeleteCommand(DConstraint constraint) {
		if (constraint == null || constraint.eContainer() == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint deletion");
		this.constraint = constraint;
		darrows.addAll(constraint.getDArrows());
		dnodes.addAll(constraint.getDNodes());
		specification = (DSpecification) constraint.eContainer();
		
	}

	public void execute() {
		if(darrows.size() > 1){
		constraint.setSource(null);
		constraint.setTarget(null);
		}
		constraint.disconnect();
	}

	public void undo() {
		constraint.reconnect(dnodes, darrows, specification);
		if(darrows.size() > 1){
		constraint.setSource(darrows.get(0));
		constraint.setTarget(darrows.get(1));
		}
	}
}
