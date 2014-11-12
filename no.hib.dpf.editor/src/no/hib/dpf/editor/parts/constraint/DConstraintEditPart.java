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
package no.hib.dpf.editor.parts.constraint;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.editor.commands.constraint.DConstraintDeleteCommand;
import no.hib.dpf.editor.parts.GraphicalConnectionEditPart;
import no.hib.dpf.editor.parts.arrow.DArrowEditPart;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public abstract class DConstraintEditPart extends GraphicalConnectionEditPart {


	@Override	
	protected void createEditPolicies() {
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			@Override
			protected Command getDeleteCommand(GroupRequest request) {
				return new DConstraintDeleteCommand(getDConstraint());
			}
		});
	}

	protected DConstraint getDConstraint(){
		return (DConstraint) getModel();
	}

	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
	 * the connection. If the source is an instance of {@link DArrowEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the source end of the Connection
	 */
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor() {
		if (getSource() instanceof DArrowEditPart) {
			DArrowEditPart editPart = (DArrowEditPart) getSource();
			return editPart.getSourceConnectionAnchor(this);
		}
		return super.getSourceConnectionAnchor();
	}

	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>target</i> end of
	 * the connection. If the target is an instance of {@link DArrowEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the target end of the Connection
	 */
	@Override
	protected ConnectionAnchor getTargetConnectionAnchor() {
		if (getTarget() instanceof DArrowEditPart) {
			DArrowEditPart editPart = (DArrowEditPart) getTarget();
			return editPart.getTargetConnectionAnchor(this);
		}
		return super.getTargetConnectionAnchor();
	}

	public Constraint getConstraint() {
		return ((DConstraint)getModel()).getConstraint();
	}
}