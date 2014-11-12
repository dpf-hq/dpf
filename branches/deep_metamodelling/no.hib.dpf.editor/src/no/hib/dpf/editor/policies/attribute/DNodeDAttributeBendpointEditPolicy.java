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


import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.attribute.DNodeDAttributeBendPointCreateCommand;
import no.hib.dpf.editor.commands.attribute.DNodeDAttributeBendpointMoveCommand;
import no.hib.dpf.editor.commands.attribute.DNodeDattributeBendpointDeleteCommand;
import no.hib.dpf.editor.figures.draw2d.Draw2dUtil;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;
import org.eclipse.gef.requests.BendpointRequest;

public class DNodeDAttributeBendpointEditPolicy extends BendpointEditPolicy {

	@Override
	protected Command getCreateBendpointCommand(BendpointRequest request) {
		DNodeDAttribute dattribute = (DNodeDAttribute) request.getSource().getModel();
		Point newBendPoint = request.getLocation();
		int index = request.getIndex();//bendpoints index
		
		
		DNodeDAttributeBendPointCreateCommand com = new DNodeDAttributeBendPointCreateCommand();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) connection.getTarget()).getFigure();
		DOffset offset = dattribute.getNameOffset();
		PointList points = ((Connection)connection.getFigure()).getPoints();
		if(offset.getIndex() == index){
			Point label = Draw2dUtil.getAbsolutePoint(source, target, ((DNodeDAttributeEditPart)connection).getRealPointList(), offset);
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
		
		com.setDNodeDAttribute(dattribute);
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
		
		DNodeDAttribute dattribute = (DNodeDAttribute) request.getSource().getModel();
		DNodeDAttributeBendpointMoveCommand com = new DNodeDAttributeBendpointMoveCommand();
		
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) connection.getTarget()).getFigure();
		
		
		com.setDNodeDAttribute(dattribute);
		int index = request.getIndex();
		com.setIndex(index);
		com.setLabel("Move BendPoint from " + com.getOldBendpoint() + " to " + p);
		com.setLocation(Draw2dUtil.getDOffset(source, target, p));
		return com;
	}

	@Override
	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		int index = request.getIndex();
		
		DNodeDAttribute dattribute = (DNodeDAttribute) request.getSource().getModel();
		
		DOffset offset = dattribute.getNameOffset();
		DNodeDattributeBendpointDeleteCommand com = new DNodeDattributeBendpointDeleteCommand();
		DOffset p = dattribute.getBendpoints().get(request.getIndex());
		com.setDNodeDAttribute(dattribute);
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
