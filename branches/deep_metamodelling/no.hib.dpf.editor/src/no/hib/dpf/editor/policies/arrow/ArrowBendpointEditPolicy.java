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
package no.hib.dpf.editor.policies.arrow;


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.arrow.DArrowBendPointCreateCommand;
import no.hib.dpf.editor.commands.arrow.DArrowBendpointDeleteCommand;
import no.hib.dpf.editor.commands.arrow.DArrowBendpointMoveCommand;
import no.hib.dpf.editor.figures.draw2d.Draw2dUtil;
import no.hib.dpf.editor.parts.arrow.DArrowEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

public class ArrowBendpointEditPolicy extends BendpointEditPolicy {

	@Override
	protected Command getCreateBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		Point newBendPoint = request.getLocation();
		int index = request.getIndex();//bendpoints index
		DArrowBendPointCreateCommand com = new DArrowBendPointCreateCommand();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		DOffset offset = arrow.getNameOffset();
		PointList points = ((Connection)connection.getFigure()).getPoints();
		if(offset.getIndex() == index){
			Point label = Draw2dUtil.getAbsolutePoint(source, target, ((DArrowEditPart)connection).getRealPointList(), offset);
			if(Draw2dUtil.needToAdd(source, target, label, newBendPoint, offset))
				com.addOne(offset);
		}
		else if(offset.getIndex() >= index + 1){
			com.addOne(offset);
		}
		for(DConstraint constraint : arrow.getDConstraints())
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() == index){
					Point label = Draw2dUtil.getAbsolutePoint(source, target, points, offset);
					if(Draw2dUtil.needToAdd(source, target, label, newBendPoint, offset))
						com.addOne(offset);
				}
				else if(offset.getIndex() >= index + 1)
					com.addOne(offset);
			}
		com.setArrow(arrow);
		com.setIndex(index);
		com.setLabel("Create BendPoint at " + newBendPoint);
		if(source == target)
			com.setLocation(Draw2dUtil.getDOffset(source.getBounds().getTop(), source.getBounds().getBottom(), newBendPoint));
		else
			com.setLocation(Draw2dUtil.getDOffset(source.getBounds().getCenter(), target.getBounds().getCenter(), newBendPoint));
		return com;
	}

	@Override
	protected Command getMoveBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		DArrowBendpointMoveCommand com = new DArrowBendpointMoveCommand();
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		com.setArrow(arrow);
		int index = request.getIndex();
		com.setIndex(index);
		com.setLabel("Move BendPoint from " + com.getOldBendpoint() + " to " + p);
		com.setLocation(Draw2dUtil.getDOffset(source, target, p));
		return com;
	}

	@Override
	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		int index = request.getIndex();
		DArrow arrow = (DArrow) request.getSource().getModel();
		DOffset offset = arrow.getNameOffset();
		DArrowBendpointDeleteCommand com = new DArrowBendpointDeleteCommand();
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
