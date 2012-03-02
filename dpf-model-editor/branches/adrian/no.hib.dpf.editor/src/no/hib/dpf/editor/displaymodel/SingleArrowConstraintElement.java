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
package no.hib.dpf.editor.displaymodel;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.IDObject;


public class SingleArrowConstraintElement extends DConstraint {

	private static final long serialVersionUID = -8335094106642818540L;

//	public static final String MULTIPLICITY_1_PROP = "Multiplicity1";
//	public static final String MULTIPLICITY_2_PROP = "Multiplicity2";
	
	private ArrowLabel constraintLabel;
	
	public SingleArrowConstraintElement(DArrow source, ConstraintType constraintType, Constraint IDObject) {
		this.setConstraintType(constraintType);
		// The dpf Constraint object must be initialized before the connection of the shapes.
		setIDObject(IDObject);
		reconnect(source, targets);
	}
		
	/**
	 * Reconnect this connection. The connection will reconnect with the shape
	 * it was previously attached to.
	 */
	@Override	
	public void reconnect() {
		if (!isConnected) {
			source.addSingleConstraint(this);
			isConnected = true;
		}
	}
	
	public void refreshSource() {
		if (isConnected) {
			source.refreshSingleConstraints();
		}
	}
	
	/**
	 * Disconnect this connection from the shape it is attached to.
	 */
	@Override
	public void disconnect() {
		if (isConnected) {
			source.removeSingleConstraint(this);
			isConnected = false;
		}
	}
	
	@Override
	public void setIDObject(IDObject idObject) {
		super.setIDObject(idObject);
		if (getConstraintLabel() == null) 
			constraintLabel = new ArrowLabel(this, true);
	}	

	public ArrowLabel getConstraintLabel() {
		return constraintLabel;
	}
	
}
