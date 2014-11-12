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
package no.hib.dpf.editor.policies.attribute;


import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.attribute.DArrowDAttributeBendPointCreateCommand;
import no.hib.dpf.editor.commands.attribute.DArrowDAttributeBendpointMoveCommand;
import no.hib.dpf.editor.commands.attribute.DArrowDattributeBendpointDeleteCommand;
import no.hib.dpf.editor.figures.draw2d.Draw2dUtil;
import no.hib.dpf.editor.parts.arrow.DArrowEditPart;
import no.hib.dpf.editor.parts.attribute.DArrowDAttributeEditPart;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

public class DArrowDAttributeBendpointEditPolicy extends BendpointEditPolicy {

	@Override
	protected Command getCreateBendpointCommand(BendpointRequest request) {
		DArrowDAttribute dattribute = (DArrowDAttribute) request.getSource().getModel();
		Point newBendPoint = request.getLocation();
		int index = request.getIndex();//bendpoints index
		
		
		DArrowDAttributeBendPointCreateCommand com = new DArrowDAttributeBendPointCreateCommand();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DArrowEditPart) connection.getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) connection.getTarget()).getFigure();
		DOffset offset = dattribute.getNameOffset();
		PointList points = ((Connection)connection.getFigure()).getPoints();
		if(offset.getIndex() == index){
			Point label = Draw2dUtil.getAbsolutePoint(source, target, ((DArrowDAttributeEditPart)connection).getRealPointList(), offset);
			if(Draw2dUtil.needToAdd(source, target, label, newBendPoint, offset)){
				com.addOne(offset);
			}
		}
		else if(offset.getIndex() >= index + 1){
			com.addOne(offset);
		}
		
		
		for(DConstraint constraint : dattribute.getDConstraints())
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
		
		com.setDArrowDAttribute(dattribute);
		com.setIndex(index);
		com.setLabel("Create BendPoint at " + newBendPoint);
		if(source == target){
			com.setLocation(Draw2dUtil.getDOffset(source.getBounds().getTop(), source.getBounds().getBottom(), newBendPoint));
		}else{
			com.setLocation(Draw2dUtil.getDOffset(source.getBounds().getCenter(), target.getBounds().getCenter(), newBendPoint));
		}
		
		return com;
	}

	@Override
	protected Command getMoveBendpointCommand(BendpointRequest request) {
		
		DArrowDAttribute dattribute = (DArrowDAttribute) request.getSource().getModel();
		DArrowDAttributeBendpointMoveCommand com = new DArrowDAttributeBendpointMoveCommand();
		
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DArrowEditPart) connection.getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) connection.getTarget()).getFigure();
		
		
		com.setDArrowDAttribute(dattribute);
		int index = request.getIndex();
		com.setIndex(index);
		com.setLabel("Move BendPoint from " + com.getOldBendpoint() + " to " + p);
		com.setLocation(Draw2dUtil.getDOffset(source, target, p));
		return com;
	}

	@Override
	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		int index = request.getIndex();
		
		DArrowDAttribute dattribute = (DArrowDAttribute) request.getSource().getModel();
		
		DOffset offset = dattribute.getNameOffset();
		DArrowDattributeBendpointDeleteCommand com = new DArrowDattributeBendpointDeleteCommand();
		DOffset p = dattribute.getBendpoints().get(request.getIndex());
		com.setDArrowDAttribute(dattribute);
		com.setIndex(index);
		com.setLabel("Delete BendPoint at " + p);
		com.setLocation(p);
		if(offset.getIndex() >= index + 1)
			com.addOne(offset);
		for(DConstraint constraint : dattribute.getDConstraints())
			if(constraint instanceof DArrowLabelConstraint){
				offset = ((DArrowLabelConstraint)constraint).getOffset();
				if(offset.getIndex() >= index + 1)
					com.addOne(offset);
			}
		return com;
	}

}
