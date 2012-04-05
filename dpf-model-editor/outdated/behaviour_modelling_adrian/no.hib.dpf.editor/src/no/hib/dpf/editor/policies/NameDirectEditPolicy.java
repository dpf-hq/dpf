/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
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
		if(getHost() instanceof DNodeEditPart)
			return new ChangeNameCommand((DNode) getHost().getModel(), (String) request.getCellEditor().getValue());
		if(getHost() instanceof ArrowLabelEditPart)
			return new ChangeNameCommand((DArrow) getHost().getParent().getModel(), (String) request.getCellEditor().getValue());
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