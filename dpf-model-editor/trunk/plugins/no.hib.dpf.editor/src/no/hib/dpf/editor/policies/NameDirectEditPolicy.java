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

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.ChangeNameCommand;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.Label;
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
		String name = (String) request.getCellEditor().getValue();
		if(getHost() instanceof DNodeEditPart){
			DNode node = (DNode) getHost().getModel();
			if(!node.getName().equals(name));
			return new ChangeNameCommand(node, name);
		}
		if(getHost() instanceof ArrowLabelEditPart){
			DArrow arrow = (DArrow) getHost().getParent().getModel();
			if(!arrow.getName().equals(name))
			return new ChangeNameCommand(arrow, name);
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