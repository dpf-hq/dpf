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
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.commands.ChangeNameCommand;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.arrow.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.attribute.DArrowDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;

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
	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		String name = (String) request.getCellEditor().getValue();
		EditPart host = getHost();
		if(host instanceof DNodeEditPart){
			DNode node = (DNode) host.getModel();
			if(!node.getName().equals(name))
			return new ChangeNameCommand(node, name);
		}
		
		if(host instanceof DDataNodeEditPart){
			DDataNode node = (DDataNode) host.getModel();
			if(!node.getDatanode().getValue().equals(name))
			return new ChangeNameCommand(node, name);
		}
		
		if(host instanceof DNodeDAttributeLabelEditPart){
			DNodeDAttribute attribute = (DNodeDAttribute) host.getParent().getModel();
			if(!attribute.getName().equals(name))
			return new ChangeNameCommand(attribute, name);
		} 
		
		if(host instanceof DArrowDAttributeLabelEditPart){
			DArrowDAttribute attribute = (DArrowDAttribute) host.getParent().getModel();
			if(!attribute.getName().equals(name))
			return new ChangeNameCommand(attribute, name);
		}
		
		if(host instanceof ArrowLabelEditPart){
			DArrow arrow = (DArrow)host.getParent().getModel();
			if(!arrow.getName().equals(name))
			return new ChangeNameCommand(arrow, name);
		}
		return null;
	} 

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		if(getHostFigure() instanceof NodeFigure)
			((NodeFigure)getHostFigure()).getNameLabel().setText(value);
		if(getHostFigure() instanceof Label)
			((Label)getHostFigure()).setText(value);
	}


}