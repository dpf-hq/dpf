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

import no.hib.dpf.diagram.util.DiagramUtil;
import no.hib.dpf.diagram.util.TransformS;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DConstraintEditPart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Geometry;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transform;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public abstract class TwoArrowConstraintConnection extends PolylineConnection implements RoutableFigure {
	
	protected String labelText;
	protected DConstraintEditPart constraintEditPart;
	private NodeFigure basicRectangleFigure;
	protected int [] controlPointsOffsets;

	public TwoArrowConstraintConnection(DConstraintEditPart constraintEditPart, String labelText, int [] controlPointsOffsets) {
		super();
		this.constraintEditPart = constraintEditPart;
		this.labelText = labelText;
		this.controlPointsOffsets = controlPointsOffsets;
		setMyBackgroundColor(ColorConstants.black);		
	}
	private void updateAnchorOwner(ConnectionAnchor anchor){
		if(anchor != null && anchor.getOwner() != null)
			anchor.getOwner().validate();
	}
	public void validate() {
		updateAnchorOwner(getSourceAnchor());
		updateAnchorOwner(getTargetAnchor());
		super.validate();
	}
	
	Bezier	bezier = null;
	@Override
	protected void outlineShape(Graphics g) {
		PointList points = getPoints();
		Point p1 = points.getFirstPoint();
		Point p2 = points.getLastPoint();
		EditPart source = constraintEditPart.getSource();
		EditPart target = constraintEditPart.getTarget();
		if(source instanceof DArrowEditPart && target instanceof DArrowEditPart){
			PointList sourcePointList = ((DArrowEditPart)source).getConnectionFigure().getPoints();
			PointList targetPointList = ((DArrowEditPart)target).getConnectionFigure().getPoints();
			Point sm = null, tm = null;
			Point sf = null, tf = null;
			Point se = null, te = null;
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
						sf = sprep;
						se = spostp;
						tf = tprep;
						te = tpostp;
						distance = mtom;
					}
				}
			}
			Point cross = DiagramUtil.getCross(sf, se, tf, te);
			bezier = new Bezier(p1, p2, sm, tm);
			if(cross != null)
			{
				Point mm = sm.getTranslated(tm).scale(0.5);
				TransformS.setBasic(mm, tm);
				Point tmr = TransformS.getRelative(tm);
				Transform trans = new Transform();
				trans.setRotation(Math.PI / 2);
				Point a = trans.getTransformed(tmr);
				a = TransformS.getAbsolute(a);
				trans.setRotation(-Math.PI / 2);
				Point b = trans.getTransformed(tmr);
				b = TransformS.getAbsolute(b);
				Point control = cross.getDistance(a) < cross.getDistance(b) ? b : a;
				double d1 = sm.getDistance(cross), d2 = tm.getDistance(cross);
				double ration = d1 > d2 ? d2 / d1 : d1 / d2;
				control = DiagramUtil.scableLine(mm, control, ration);
				bezier = new Bezier(sm, tm, control, control);
			}
			bezier.outlineShape(g);
			drawCenteredText(g, labelText, bezier.getPoints().getMidpoint());
			drawEndpointBlobs(g, p1, p2);
			return;
		}
	}
	
	protected NodeFigure getBasicRectangleFigure() {
		if (basicRectangleFigure == null) {
			basicRectangleFigure = constraintEditPart.getRectangleFigureForFigure();
		}
		return basicRectangleFigure;
	}
	
	
	protected Point[] getMidwayControlPoints(Point startPoint, Point endPoint, int offset1, int offset2) {
		Point[] firstCandidate = makeMidwayControlPoints(startPoint, endPoint, offset1, offset2);
		Point[] secondCandidate = makeMidwayControlPoints(endPoint, startPoint, offset1, offset2);
		
		if (getBasicRectangleFigure() == null) {
			return firstCandidate;
		}
		
		if ((getBasicRectangleFigure().getLocation().getDistance(firstCandidate[0]) >=
			(getBasicRectangleFigure().getLocation().getDistance(secondCandidate[0])))) {
			return firstCandidate;
		}
		return secondCandidate;
	}
	
	@SuppressWarnings("deprecation")
	private Point[] makeMidwayControlPoints(Point startPoint, Point endPoint, int offset1, int offset2) {
		// First point: to make control points for Bezier
		// Second point: to make center point for text
		int dx = endPoint.x - startPoint.x;
		int dy = endPoint.y - startPoint.y;
		
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);
		
		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * offset1, normOrthoVectorY  * offset1);		
		Point midway = new Point(startPoint.x + (dx/2), startPoint.y + (dy/2));
		
		Point[] retval = new Point[2];
		
		retval[0] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		finalVector = new Point(normOrthoVectorX * offset2, normOrthoVectorY  * offset2);		
		retval[1] = new Point(midway.x + finalVector.x, midway.y + finalVector.y);
		
		return retval;
	}	
	
	/**
	 * Returns <code>true</code> if this Figure uses local coordinates. This
	 * means its children are placed relative to this Figure's top-left corner.
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 * @since 2.0
	 */
	@Override
	protected boolean useLocalCoordinates() {
		return false;
	}	

	protected void drawAnchorBlob(Graphics g, Rectangle r) {
		g.fillArc(r.x, r.y, r.width, r.height, 0, 360);	
	}

	protected Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}

	protected Point getMidwayPoint(Point p1, Point p2) {		
		int maxY = Math.max(p1.y, p2.y);
		int minY = Math.min(p1.y, p2.y);
		
		int maxX = Math.max(p1.x, p2.x);
		int minX = Math.min(p1.x, p2.x);
		
		int dx = maxX - minX;
		int dy = maxY - minY;		
		return new Point(maxX - (dx/2), maxY - (dy/2));
	}

	@Override
	protected boolean shapeContainsPoint(int x, int y) {
		if(bezier != null)
			return Geometry.polylineContainsPoint(bezier.getPoints(), x, y, 2);
		return false;
	}

	/**
	 * SetBacgroundColor without update()
	 * @see IFigure#setBackgroundColor(Color)
	 */
	@SuppressWarnings("deprecation")
	public void setMyBackgroundColor(Color bg) {
		// Set background color to bg unless in high contrast mode.
		// In that case, get the color from system
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		Color highContrastClr = null;
		try {
			if (display.getHighContrast()) {
				highContrastClr = display
						.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
			}
		} catch (SWTException e) {
			highContrastClr = null;
		}
		bgColor = highContrastClr == null ? bg : highContrastClr;
	}

	@Override
	public int getRoutingPriority() {
		return 10;
	}

	protected void drawCenteredText(Graphics g, String text, Point point) {
		Dimension textSize = FigureUtilities.getTextExtents(text, g.getFont());
		
		Point textPoint = new Point(point.x - (textSize.width/2), point.y - (textSize.height/2));
		g.drawText(text, textPoint);		
	}

	protected void drawEndpointBlobs(Graphics g, Point p1, Point p2) {
		setMyBackgroundColor(ColorConstants.black);
		drawAnchorBlob(g, buildPointBox(p1));
		drawAnchorBlob(g, buildPointBox(p2));
	}
	
}