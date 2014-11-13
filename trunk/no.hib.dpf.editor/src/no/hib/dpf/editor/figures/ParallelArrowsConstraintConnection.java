/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.DConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The arrows are supposed to be parallel, and (for the time being) in the same direction.
 */
public class ParallelArrowsConstraintConnection extends ConstraintConnection {
	
	public ParallelArrowsConstraintConnection(DConstraintEditPart constraintEditPart, String labelText) {
		super();
	}
	
//	@Override
//	protected void outlineShape(Graphics g) {
//		PointList points = getPoints();
//		Point p1 = points.getFirstPoint();
//		Point p2 = points.getLastPoint();
//								
//		Point [] controlpoints = getMidwayControlPoints(p1, p2, controlPointsOffsets[0], controlPointsOffsets[1]);
//		
//// Draws the control points for your viewing pleasure		
////		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[1], p1)));
////		drawAnchorBlob(g, buildPointBox(getMidwayPoint(controlpoints[1], p2)));
//		
//		
//		Bezier bezier = new Bezier(p1, p2, getMidwayPoint(controlpoints[1], p1), getMidwayPoint(controlpoints[1], p2));
//		bezier.outlineShape(g);		
//		
//		drawCenteredText(g, labelText, controlpoints[0]);
//		setMyBackgroundColor(ColorConstants.black);
//		drawAnchorBlob(g, buildPointBox(p1));
//		drawArrowhead(g, p1, p2, controlpoints);
//	}

//	private void drawArrowhead(Graphics g, Point p1, Point p2, Point[] controlpoints) {
//		OpenArrowDecoration r = new OpenArrowDecoration();
//		
//		r.setFill(false);
//		r.setScale(14, 6);
//		r.setLocation(p2);
//		// TODO: remove this Q&D-solution and make a "movable" point along a line section.
//		r.setReferencePoint(getMidwayPoint(getMidwayPoint(controlpoints[1], getMidwayPoint(controlpoints[1], getMidwayPoint(p1, p2))), 
//							getMidwayPoint(controlpoints[1], getMidwayPoint(p1, p2))));
//		r.outlineShape(g);
//	}


}
