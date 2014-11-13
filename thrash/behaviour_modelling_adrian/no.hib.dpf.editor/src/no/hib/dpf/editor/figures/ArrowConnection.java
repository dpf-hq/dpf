/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.figures;


import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 */
public class ArrowConnection extends PolylineConnection implements RoutableFigure {
	private boolean isEpi = false;

	boolean isEpi(){
		return isEpi;
	}
	@Override
	protected void outlineShape(Graphics g) {
		g.pushState();
		g.setAntialias(SWT.ON); //FIXME: this is a hack, it should really be set globally somewhere? 		
		super.outlineShape(g);
		g.popState();
	}

	@Override
	public int getRoutingPriority() {
		return isEpi ? 6 : 5;
	}
	public void setLocation(Point p) {
		super.setLocation(p);
	}
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
	}
	
	public Rectangle getOwnerBounds() {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof NodeFigure)) {
			return ((NodeFigure)getSourceAnchor().getOwner()).getBounds().getCopy();
		}
		return null;
	}
	public void setEpi(boolean b) {
		isEpi = b;
	}
	
}
