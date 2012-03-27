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
package no.hib.dpf.editor.policies;
/*
 * Created on Jul 18, 2004
 */

import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.commands.ChangeVNodeNameCommand;
import no.hib.dpf.editor.parts.NodeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.viewers.CellEditor;

/**
 * EditPolicy for the direct editing of node names
 * 
 * @author Phil Zoio
 */
public class VNodeDirectEditPolicy extends DirectEditPolicy {

	private String oldValue;

	/**
	 * @see DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest request) {
		ChangeVNodeNameCommand cmd = new ChangeVNodeNameCommand();
		DNode vNode = (DNode) getHost().getModel();
		cmd.setShape(vNode);
		cmd.setOldName(vNode.getNameExec());
		CellEditor cellEditor = request.getCellEditor();
		cmd.setName((String) cellEditor.getValue());
		return cmd;
	}

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		NodeEditPart vNodeEditPart = (NodeEditPart) getHost();
		vNodeEditPart.handleNameChange(value);
	}

	/**
	 * @param to
	 *            Saves the initial text value so that if the user's changes are not committed then 
	 */
	protected void storeOldEditValue(DirectEditRequest request) {
		CellEditor cellEditor = request.getCellEditor();
		oldValue = (String) cellEditor.getValue();
	}

	/**
	 * @param request
	 */
	protected void revertOldEditValue(DirectEditRequest request) {
		CellEditor cellEditor = request.getCellEditor();
		cellEditor.setValue(oldValue);
		NodeEditPart vNodeEditPart = (NodeEditPart)getHost();
		vNodeEditPart.revertNameChange();
	}
}