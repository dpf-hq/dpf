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
package no.hib.dpf.editor.commands.arrow;

import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;

/**
 * A command to create an arrow between two nodes. The command can be undone or
 * redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command properly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getConnectionCreateCommand(...)</tt> method, to create a
 * new instance of this class and put it into the CreateConnectionRequest.</li>
 * <li>Override the <tt>getConnectionCompleteCommand(...)</tt> method, to obtain
 * the Command from the ConnectionRequest, call setTarget(...) to set the target
 * endpoint of the connection and return this command instance.</li>
 * </ol>
 * 
 * @see no.hib.dpf.editor.parts.node.DNodeEditPart#createEditPolicies() for an
 *      example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class DArrowCreateCommand extends AbstractDArrowCommand {
	/** Start endpoint for the connection. */
	private DNode source;
	/** Target endpoint for the connection. */
	private DNode target;
	/*
	 * DArrow Type
	 */
	private DArrow newDArrow;

	public DArrowCreateCommand(DNode source, DArrow newObject) {
		if (source == null)
			throw new IllegalArgumentException();

		setLabel("connection creation");
		Assert.isTrue(newObject != null);
		this.source = source;
		this.newDArrow = newObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (target == null || source == null){
			return false;		
		}
		
		return canConnect(source, newDArrow, target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		newDArrow.reconnect(source, target);
		
		Node node = source.getNode();
		Specification spec = (Specification) node.eContainer().eContainer();
		int metalevel = spec.getMetalevel();
		if (metalevel >= 0) {
			DGraph parent = (DGraph) source.eContainer();
			DPFTemplateUtils.replicateTemplateArrowAttributesForArrow(newDArrow, parent);
		}
	}

	/**
	 * Set the target endpoint for the connection.
	 * 
	 * @param target
	 *            that target endpoint (a non-null Shape instance)
	 * @throws IllegalArgumentException
	 *             if target is null
	 */
	public void setTarget(DNode target) {
		if (target == null)
			throw new IllegalArgumentException();
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		newDArrow.disconnect();
	}
}
