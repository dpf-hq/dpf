/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *     �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.policies;


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.BendPointCreateCommand;
import no.hib.dpf.editor.commands.BendpointDeleteCommand;
import no.hib.dpf.editor.commands.BendpointMoveCommand;
import no.hib.dpf.editor.figures.Draw2dUtil;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

public class ArrowBendpointEditPolicy extends BendpointEditPolicy {

	protected Command getCreateBendpointCommand(BendpointRequest request) {
		BendPointCreateCommand com = new BendPointCreateCommand();
		ConnectionEditPart connection = request.getSource();
		DArrow arrow = (DArrow) connection.getModel();
		int index = request.getIndex();//bendpoints index
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		DOffset offset = arrow.getNameOffset();
		if(offset.getIndex() > index) com.addInvalid(offset);
		for(DConstraint constraint : arrow.getDConstraints()){
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() > index) com.addInvalid(offset);
			}
		}
		Point newPoint = request.getLocation();
		source.translateToRelative(newPoint);
		com.setArrow(arrow);
		com.setLabel("Create BendPoint at " + newPoint);
		DOffset newOffset = Draw2dUtil.getDOffset(source, target, newPoint);
		newOffset.setIndex(index);
		com.setLocation(newOffset);
		return com;
	}

	protected Command getMoveBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		BendpointMoveCommand com = new BendpointMoveCommand();
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		source.translateToRelative(p);
		com.setArrow(arrow);
		com.setOldBendpoint(arrow.getBendpoints().get(request.getIndex()));
		com.setLabel("Move BendPoint to " + p);
		DOffset moved = Draw2dUtil.getDOffset(source, target, p);
		moved.setIndex(request.getIndex());
		com.setLocation(moved);
		return com;
	}

	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		int index = request.getIndex();
		DArrow arrow = (DArrow) request.getSource().getModel();
		BendpointDeleteCommand com = new BendpointDeleteCommand();
		com.setArrow(arrow);
		DOffset p = arrow.getBendpoints().get(index);
		p.setIndex(index);
		com.setLabel("Delete BendPoint at " + p);
		com.setLocation(p);
		DOffset offset = arrow.getNameOffset();
		if(offset.getIndex() > index) com.addInvalid(offset);
		for(DConstraint constraint : arrow.getDConstraints()){
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() > index)
					com.addInvalid(offset);
			}
		}
		return com;
	}

}
