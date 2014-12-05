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

import org.eclipse.draw2d.PolylineConnection;

public class OppositeArrowsConstraintAnchor extends ConstraintAnchor {

	private static final int maxDistanceToConnectionPoint = 250;

	public OppositeArrowsConstraintAnchor() { super(); }

	public OppositeArrowsConstraintAnchor(PolylineConnection figure) { super(figure); }

	protected double findDistanceToConnectionPoint(double distanceBetweenFirstPoints) {
		double distanceToConnectionPoint = distanceBetweenFirstPoints*4/6;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		return distanceToConnectionPoint;
	}

}
