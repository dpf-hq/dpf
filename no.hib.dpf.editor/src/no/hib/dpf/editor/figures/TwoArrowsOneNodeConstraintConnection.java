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


import no.hib.dpf.editor.figures.Draw2dUtil.Transform;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DConstraintEditPart;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
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

	/*
	 * Get the two midpoints which has the shortest distance
	 */
	public PointList getNearestPoint(PointList source, PointList target, PointList constraint){
		PointList result = new PointList(6);
		Point start = constraint.getFirstPoint(), end = constraint.getLastPoint();
		int si = -1, ti = -1;
		double distance = Integer.MAX_VALUE;
		for(int i = 0; i < source.size() - 1; i++){
			Point current = Draw2dUtil.mid(source.getPoint(i), source.getPoint(i+1));
			double temp = current.getDistance(start);
			if(temp < distance){
				si = i;
				distance = temp;
			}
		}
		distance = Integer.MAX_VALUE;
		for(int i = 0; i < target.size() - 1; i++){
			Point current = Draw2dUtil.mid(target.getPoint(i), target.getPoint(i+1));
			double temp = current.getDistance(end);
			if(temp < distance){
				ti = i;
				distance = temp;
			}
		}
		if(si == source.size() - 1) si = si - 1;
		if(ti == target.size() - 1) ti = ti - 1;
		result.addPoint(source.getPoint(si));
		result.addPoint(Draw2dUtil.mid(source.getPoint(si), source.getPoint(si + 1)));
		result.addPoint(source.getPoint(si + 1));
		result.addPoint(target.getPoint(ti));
		result.addPoint(Draw2dUtil.mid(target.getPoint(ti), target.getPoint(ti + 1)));
		result.addPoint(target.getPoint(ti + 1));
		return result;
	}

	/*
	 * When setting points by the router, recalculate the bezier points.
	 */
	public void setPoints(PointList points){
		Point first_n = points.getFirstPoint(), end_n = points.getLastPoint();
		EditPart source = editPart.getSource();
		EditPart target = editPart.getTarget();
		if(source instanceof DArrowEditPart && target instanceof DArrowEditPart){
			DArrowEditPart sarrow = (DArrowEditPart) source, tarrow = (DArrowEditPart) target;
			PointList shortest = getNearestPoint(sarrow.getConnectionFigure().getPoints(), 
					tarrow.getConnectionFigure().getPoints(), points);
			Point[] controls = getControlPoints(shortest);
			bezier.setStart(shortest.getPoint(1));
			bezier.setEnd(shortest.getPoint(4));

			bezier.setStartControl(controls[0]);
			bezier.setEndControl(controls[1]);
			bezier.reCompute();
			PointList final_points = bezier.getPoints().getCopy();
			final_points.setPoint(first_n, 0);
			final_points.setPoint(end_n, final_points.size() - 1);
			super.setPoints(final_points);
		}else
			super.setPoints(points);
	}

	static Point[] getControlPoints(PointList list){
		Point start = list.getPoint(1), last = list.getPoint(4);
		Point mid = Draw2dUtil.mid(start, last);
		Transform transform = Draw2dUtil.getTransform(mid, last);
		Point[] line0 = new Point[]{list.getPoint(0),  list.getPoint(2)};
		Point[] line1 = new Point[]{list.getPoint(3), list.getPoint(5)};
		Point[] t_line0 = new Point[]{transform.getTransformed(line0[0]), transform.getTransformed(line0[1])};
		Point[] t_line1 = new Point[]{transform.getTransformed(line1[0]), transform.getTransformed(line1[1])};

		int[] ups = new int[2], downs = new int[2];
		ups[0] = t_line0[0].y > 0 ? 0 : 1;
		ups[1] = t_line1[0].y > 0 ? 0 : 1;
		downs[0] = 1 - ups[0];
		downs[1] = 1 - ups[1];
		int up = Math.abs(t_line0[ups[0]].x - t_line1[ups[1]].x), down = Math.abs(t_line0[downs[0]].x - t_line1[downs[1]].x);
		if(up < down){
			int[] temp = ups;
			ups = downs;
			downs = temp;
		}
		Point[] result = new Point[]{t_line0[downs[0]], t_line1[downs[1]]};
		result[0].y = -result[0].y;
		result[0].x = -result[0].x;
		result[1].y = -result[1].y;
		result[1].x = -result[1].x;
		Point temp = transform.getTransformBack(result[0]);
		result[0] = transform.getTransformBack(result[1]);
		result[1] = temp;
		return result;
	}
}
