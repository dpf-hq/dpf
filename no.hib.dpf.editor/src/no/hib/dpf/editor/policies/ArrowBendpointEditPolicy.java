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


import java.util.List;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.ArrowLabelMoveCommand;
import no.hib.dpf.editor.commands.BendPointCreateCommand;
import no.hib.dpf.editor.commands.BendpointDeleteCommand;
import no.hib.dpf.editor.commands.BendpointMoveCommand;
import no.hib.dpf.editor.figures.Draw2dUtil;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
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
		/*
		 * Set the arrow where bendpoint is created
		 */
		ConnectionEditPart connection = request.getSource();
		DArrow arrow = (DArrow) connection.getModel();
		com.setArrow(arrow);
		/*
		 * Set the offset of the new bendpoint
		 */
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		Point newBendpoint = request.getLocation();
		getConnection().translateToRelative(newBendpoint);//This step is necessary to transform the absolute location to the relative location of the diagram
		DOffset newBP = Draw2dUtil.getDOffset(source, target, newBendpoint);
		newBP.setIndex(request.getIndex());
		com.setLabel("Create BendPoint at " + newBendpoint);
		com.setLocation(newBP);
		/*
		 * Use ArrowLabelMove command to update the offset of named labels and label constraint
		 */
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();

		int bpIndex = request.getIndex();//bendpoints index
		List<?> bendpoints = (List<?>) getConnection().getRoutingConstraint();
		if(bpIndex > 0) start = (Point) bendpoints.get(bpIndex - 1);
		if(bpIndex < bendpoints.size() - 1) end = (Point) bendpoints.get(bpIndex + 1);

		for(Object child : connection.getChildren()){
			if(child instanceof ArrowLabelEditPart){
				DOffset offset = ((ArrowLabelEditPart)child).getDOffset();
				if(offset.getIndex() == bpIndex){
					Point absolute = Draw2dUtil.getAbsoluteBendPoint(start, end, offset);
					if(offset.getOffset().x > newBP.getOffset().x){
						DOffset theoffset = Draw2dUtil.getDOffset(newBendpoint, end, absolute);
						theoffset.setIndex(bpIndex + 1);
						com.add(new ArrowLabelMoveCommand(offset, theoffset));
					}else{
						DOffset theoffset = Draw2dUtil.getDOffset(start, newBendpoint, absolute);
						theoffset.setIndex(bpIndex);
						com.add(new ArrowLabelMoveCommand(offset, theoffset));
					}
				}else if(offset.getIndex() > bpIndex) 
					com.addInvalid(offset);
			}
		}
		return com;
	}

	protected Command getMoveBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		BendpointMoveCommand com = new BendpointMoveCommand();
		Point p = request.getLocation();
		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		getConnection().translateToRelative(p);
		com.setArrow(arrow);
		com.setOldBendpoint(arrow.getBendpoints().get(request.getIndex()));
		com.setLabel("Move BendPoint to " + p);
		DOffset moved = Draw2dUtil.getDOffset(source, target, p);
		moved.setIndex(request.getIndex());
		com.setLocation(moved);
		return com;
	}

	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		DArrow arrow = (DArrow) request.getSource().getModel();
		BendpointDeleteCommand com = new BendpointDeleteCommand();
		com.setArrow(arrow);

		int bpIndex = request.getIndex();
		DOffset p = arrow.getBendpoints().get(bpIndex);
		com.setLabel("Delete BendPoint at " + p);
		com.setLocation(p);

		ConnectionEditPart connection = request.getSource();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();

		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();

		List<?> bendpoints = (List<?>) getConnection().getRoutingConstraint();
		if(bpIndex > 0) start = (Point) bendpoints.get(bpIndex - 1);
		if(bpIndex < bendpoints.size()) end = (Point) bendpoints.get(bpIndex);
		Point oldBP = request.getLocation();
		getConnection().translateToRelative(oldBP);

		for(Object child : connection.getChildren()){
			if(child instanceof ArrowLabelEditPart){
				DOffset offset = ((ArrowLabelEditPart)child).getDOffset();
				if(offset.getIndex() == bpIndex){
					Point absolute = Draw2dUtil.getAbsoluteBendPoint(start, oldBP, offset);
					DOffset theoffset = Draw2dUtil.getDOffset(start, end, absolute);
					theoffset.setIndex(bpIndex);
					com.add(new ArrowLabelMoveCommand(offset, theoffset));
				}else if(offset.getIndex() == bpIndex + 1){
					Point absolute = Draw2dUtil.getAbsoluteBendPoint(oldBP, end, offset);
					DOffset theoffset = Draw2dUtil.getDOffset(start, end, absolute);
					theoffset.setIndex(bpIndex);
					com.add(new ArrowLabelMoveCommand(offset, theoffset));
				}else if(offset.getIndex() > bpIndex + 1) 
					com.addInvalid(offset);
			}
		}
		return com;
	}
}