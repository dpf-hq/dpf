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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;

public class ConstraintAnchor implements ConnectionAnchor {


	@SuppressWarnings("rawtypes")
	protected List listeners = new ArrayList(1);
	protected PolylineConnection connectionFigure;

	/**
	 * Constructs a ConnectionConstraintAnchor at the Point p.
	 * 
	 * @param useTargetEnd
	 *            instructs the anchor to anchor from the target end of the
	 *            connection.
	 * 
	 * @since 2.0
	 */
	public ConstraintAnchor() { }
	
	public ConstraintAnchor(PolylineConnection figure) { connectionFigure = figure; }

	/**
	 * Adds a listener interested in the movement of this ConnectionAnchor.
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#addAnchorListener(AnchorListener)
	 */
	@SuppressWarnings("unchecked")
	public void addAnchorListener(AnchorListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the listener.
	 * 
	 * @see org.eclipse.draw2d.ConnectionAnchor#removeAnchorListener(AnchorListener)
	 */
	public void removeAnchorListener(AnchorListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Notifies all the listeners in the list of a change in position of this
	 * anchor. This is called from one of the implementing anchors when its
	 * location is changed.
	 * 
	 * @since 2.0
	 */
	@SuppressWarnings("rawtypes")
	protected void fireAnchorMoved() {
		Iterator iter = listeners.iterator();
		while (iter.hasNext())
			((AnchorListener) iter.next()).anchorMoved(this);
	}

	/**
	 * Returns the location of this anchor. The reference point is ignored in
	 * this implementation.
	 */
	public Point getLocation(Point reference) {
		PrecisionPoint loc = null;
		if(connectionFigure != null){
			PointList points = connectionFigure.getPoints();
			if(points.size() == 2){
				PrecisionPoint start = new PrecisionPoint(points.getFirstPoint()), end = new PrecisionPoint(points.getLastPoint());
				loc = Draw2dUtil.mid(start, end);
			}
			else{
				PrecisionPoint ref = new PrecisionPoint(reference);
				connectionFigure.translateToRelative(ref);
				double len = Integer.MAX_VALUE;
				for (int i = 0; i < points.size() - 1; i++) {
					PrecisionPoint middle = Draw2dUtil.mid(points.getPoint(i), points.getPoint(i+1));
					double temp = middle.getDistance(ref);
					if(temp < len){
						len = temp;
						loc = middle;
					}
				}
			}
			connectionFigure.translateToAbsolute(loc);
			return loc;
		}
		return null;
	}

	/**
	 * Returns the connection figure.
	 */
	public IFigure getOwner() {
		return this.connectionFigure;
	}

	/**
	 * Returns the point which is used as the reference by this connection
	 * anchor.
	 */
	public Point getReferencePoint() {
		return connectionFigure != null ? connectionFigure.getPoints().getBounds().getCenter() : null;
	}

}
