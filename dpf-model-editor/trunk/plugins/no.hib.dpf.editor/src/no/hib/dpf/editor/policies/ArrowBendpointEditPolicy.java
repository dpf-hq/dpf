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
import no.hib.dpf.editor.commands.BendPointCreateCommand;
import no.hib.dpf.editor.commands.BendpointCommand;
import no.hib.dpf.editor.commands.BendpointDeleteCommand;
import no.hib.dpf.editor.commands.BendpointMoveCommand;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Point;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;

public class ArrowBendpointEditPolicy extends BendpointEditPolicy {

	private Bendpoint getBendPoint(Connection connectionFigure, Point p, float weight){
		connectionFigure.translateToRelative(p);
		Point ref1 = connectionFigure.getSourceAnchor().getReferencePoint();
		Point ref2 = connectionFigure.getTargetAnchor().getReferencePoint();

		connectionFigure.translateToRelative(ref1);
		connectionFigure.translateToRelative(ref2);

		RelativeBendpoint rbp = new RelativeBendpoint(connectionFigure);
		rbp.setRelativeDimensions(p.getDifference(ref1), p.getDifference(ref2));
		rbp.setWeight(weight);//(index + 1) / ((float)arrow.getBendpoints().size() + 1));
		return rbp;
	}
	
	protected Command getCreateBendpointCommand(BendpointRequest request) {
		BendPointCreateCommand com = new BendPointCreateCommand();
		Point p = request.getLocation();
		int index = request.getIndex();
		DArrow arrow = (DArrow) request.getSource().getModel();
		com.setArrow(arrow);
		com.setIndex(index);
		com.setLabel("Create BendPoint at " + p);
		com.setLocation(getBendPoint((Connection)request.getSource().getFigure(), p, (index + 1) / ((float)arrow.getBendpoints().size() + 1)).getLocation());
		return com;
	}

	protected Command getMoveBendpointCommand(BendpointRequest request) {
		BendpointMoveCommand com = new BendpointMoveCommand();
		Point p = request.getLocation();
		DArrow arrow = (DArrow) request.getSource().getModel();
		com.setArrow(arrow);
		int index = request.getIndex();
		com.setIndex(index);
		com.setLabel("Move BendPoint from " + com.getOldBendpoint() + " to " + p);
		com.setLocation(getBendPoint((Connection)request.getSource().getFigure(), p, (index + 1) / ((float)arrow.getBendpoints().size() + 1)).getLocation());
		return com;
	}

	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		BendpointCommand com = new BendpointDeleteCommand();
		Point p = request.getLocation();
		com.setLocation(p);
		com.setArrow((DArrow) request.getSource().getModel());
		com.setIndex(request.getIndex());
		com.setLabel("Delete BendPoint at " + p);
		return com;
	}

}
