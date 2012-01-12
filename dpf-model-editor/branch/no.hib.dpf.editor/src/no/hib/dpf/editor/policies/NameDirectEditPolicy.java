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

import no.hib.dpf.editor.displaymodel.ArrowLabel;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.ModelElement;
import no.hib.dpf.editor.displaymodel.commands.ChangeNameCommand;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

/**
 * EditPolicy for the direct editing of node names
 * 
 * @author Phil Zoio
 */
public class NameDirectEditPolicy extends DirectEditPolicy {


	/**
	 * @see DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest request) {
		EditPart host = getHost();
		if(host instanceof NodeEditPart){
			String oldValue = ((DNode) host.getModel()).getNameExec();
			String newValue = (String) request.getCellEditor().getValue();
			return oldValue.equals(newValue) ? null : new ChangeNameCommand((DNode) getHost().getModel(), newValue);
		}
		if(getHost() instanceof ArrowLabelEditPart)
		{
			ModelElement parent = ((ArrowLabel) host.getModel()).getParent();
			if(parent instanceof DArrow){
				String oldValue = ((DArrow)parent).getName();
				String newValue = (String) request.getCellEditor().getValue();
				return oldValue.equals(newValue) ? null : new ChangeNameCommand((DArrow) parent, newValue);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		if(getHostFigure() instanceof NodeFigure)
			((NodeFigure)getHostFigure()).getNameLabel().setText(value);
		if(getHostFigure() instanceof Label)
			((Label)getHostFigure()).setText(value);
	}


}