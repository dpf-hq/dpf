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
import no.hib.dpf.diagram.util.DiagramUtil;
import no.hib.dpf.editor.commands.BendPointCreateCommand;
import no.hib.dpf.editor.commands.BendpointDeleteCommand;
import no.hib.dpf.editor.commands.BendpointMoveCommand;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

public class ArrowBendpointEditPolicy extends BendpointEditPolicy {

	protected Command getCreateBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		Point newBendPoint = request.getLocation();
		int index = request.getIndex();//bendpoints index
		BendPointCreateCommand com = new BendPointCreateCommand();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		DOffset offset = arrow.getNameOffset();
		PointList points = ((Connection)connection.getFigure()).getPoints();
		if(offset.getIndex() == index){
			Point label = DiagramUtil.getAbsolutePoint(source, target, ((DArrowEditPart)connection).getRealPointList(), offset);
			if(DiagramUtil.needToAdd(source, target, label, newBendPoint, offset))
				com.addOne(offset);
		}
		else if(offset.getIndex() >= index + 1){
			com.addOne(offset);
		}
		for(DConstraint constraint : arrow.getDConstraints())
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() == index){
					Point label = DiagramUtil.getAbsolutePoint(source, target, points, offset);
					if(DiagramUtil.needToAdd(source, target, label, newBendPoint, offset))
						com.addOne(offset);
				}
				else if(offset.getIndex() >= index + 1)
					com.addOne(offset);
			}
		com.setArrow(arrow);
		com.setIndex(index);
		com.setLabel("Create BendPoint at " + newBendPoint);
		if(source == target)
			com.setLocation(DiagramUtil.getDOffset(source.getBounds().getTop(), source.getBounds().getBottom(), newBendPoint));
		else
			com.setLocation(DiagramUtil.getDOffset(source.getBounds().getCenter(), target.getBounds().getCenter(), newBendPoint));
		return com;
	}

	protected Command getMoveBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		BendpointMoveCommand com = new BendpointMoveCommand();
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		com.setArrow(arrow);
		int index = request.getIndex();
		com.setIndex(index);
		com.setLabel("Move BendPoint from " + com.getOldBendpoint() + " to " + p);
		com.setLocation(DiagramUtil.getDOffset(source, target, p));
		return com;
	}

	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		int index = request.getIndex();
		DArrow arrow = (DArrow) request.getSource().getModel();
		DOffset offset = arrow.getNameOffset();
		BendpointDeleteCommand com = new BendpointDeleteCommand();
		DOffset p = arrow.getBendpoints().get(request.getIndex());
		com.setArrow(arrow);
		com.setIndex(index);
		com.setLabel("Delete BendPoint at " + p);
		com.setLocation(p);
		if(offset.getIndex() >= index + 1)
			com.addOne(offset);
		for(DConstraint constraint : arrow.getDConstraints())
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() >= index + 1)
					com.addOne(offset);
			}
		return com;
	}

}
