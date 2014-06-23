/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

public class ArrowBendpoint implements java.io.Serializable, Bendpoint {

	private static final long serialVersionUID = -2557091205828337347L;
	private float weight = 0.5f;
	private Dimension d1, d2;

	public ArrowBendpoint() {
	}

	public Dimension getFirstRelativeDimension() {
		return d1;
	}

	@Override
	public Point getLocation() {
		return null;
	}

	public Dimension getSecondRelativeDimension() {
		return d2;
	}

	public float getWeight() {
		return weight;
	}

	public void setRelativeDimensions(Dimension dim1, Dimension dim2) {
		d1 = dim1;
		d2 = dim2;
	}

	public void setWeight(float w) {
		weight = w;
	}

}
