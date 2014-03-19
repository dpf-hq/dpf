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


import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DConstraintEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.EditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class TwoArrowsOneNodeConstraintConnection extends LabelConstraintConnection  {

	Bezier bezier = new Bezier(new Point(), new Point(), new Point(), new Point());
	DConstraintEditPart editPart = null;
	public TwoArrowsOneNodeConstraintConnection(DConstraintEditPart constraintEditPart) {
		super();
		editPart = constraintEditPart;
	}
	public PointList getNearestPoint(PointList sourcePointList, PointList targetPointList){
		PointList result = new PointList(2);
		Point sm = null, tm = null;
		double distance = Integer.MAX_VALUE;
		for (int i = 0; i < sourcePointList.size() - 1; i++) {
			Point sprep = sourcePointList.getPoint(i);
			Point spostp = sourcePointList.getPoint(i + 1);
			Point smidp = sprep.getTranslated(spostp).scale(0.5);
			for (int j = 0; j < targetPointList.size() - 1; j++) {
				Point tprep = targetPointList.getPoint(j);
				Point tpostp = targetPointList.getPoint(j + 1);
				Point tmidp = tprep.getTranslated(tpostp).scale(0.5);
				double mtom = smidp.getDistance(tmidp);
				if(mtom < distance){
					sm = smidp;
					tm = tmidp;
					distance = mtom;
				}
			}
		}
		result.addPoint(sm);
		result.addPoint(tm);
		return result;
	}
	public DNodeEditPart getNodeEditPart(DArrowEditPart sarrow, DArrowEditPart tarrow){
		DNodeEditPart node = null;
		if(sarrow.getSource() == tarrow.getSource()){
			node = (DNodeEditPart) sarrow.getSource();
		}
		else if(sarrow.getSource() == tarrow.getTarget()){
			node = (DNodeEditPart) sarrow.getSource();
		}
		else if(sarrow.getTarget() == tarrow.getTarget()){
			node = (DNodeEditPart) sarrow.getTarget();
		}
		else if(sarrow.getTarget() == tarrow.getSource()){
			node = (DNodeEditPart) sarrow.getTarget();
		}
		return node;
	}
	/*
	 * When setting points by the router, recalculate the bezier points.
	 */
	public void setPoints(PointList points){
		Point first = getPoints().getFirstPoint(), end = getPoints().getLastPoint();
		Point first_n = points.getFirstPoint(), end_n = points.getLastPoint();
		if(first.x  == first_n.x && first.y == first_n.y && end.x == end_n.x && end.y == end_n.y){
			if(getPoints().size() <= points.size()) super.setPoints(points);
		}
		else{
			EditPart source = editPart.getSource();
			EditPart target = editPart.getTarget();
			if(source instanceof DArrowEditPart && target instanceof DArrowEditPart){
				DArrowEditPart sarrow = (DArrowEditPart) source, tarrow = (DArrowEditPart) target;
				DNodeEditPart node = getNodeEditPart(sarrow, tarrow);
				if(node != null){
					PointList furthest = getNearestPoint(sarrow.getConnectionFigure().getPoints(), 
							tarrow.getConnectionFigure().getPoints());
					PrecisionPoint p1 = new PrecisionPoint(furthest.getFirstPoint());
					PrecisionPoint p2 = new PrecisionPoint(furthest.getLastPoint());
					PrecisionPoint ps = new PrecisionPoint(node.getFigure().getBounds().getCenter());
					bezier.setStart(p1);
					bezier.setEnd(p2);
					Point p = p1.getTranslated(p2).translate(ps.getNegated());

					bezier.setStartControl(p);
					bezier.setEndControl(p);
					bezier.reCompute();
					PointList final_points = bezier.getPoints().getCopy();
					final_points.setPoint(first_n, 0);
					final_points.setPoint(end_n, final_points.size() - 1);
					super.setPoints(final_points);
				}
			}
		}
	}
	
}
