/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.editor.displaymodel.DArrow;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import org.eclipse.gef.commands.Command;

public class BendpointCommand extends Command {

	protected int index;
	protected Point location;
	protected DArrow arrow;
	private Dimension d1, d2;

	protected Dimension getFirstRelativeDimension() {
		return d1;
	}

	protected Dimension getSecondRelativeDimension() {
		return d2;
	}

	protected int getIndex() {
		return index;
	}

	protected Point getLocation() {
		return location;
	}

	protected DArrow getArrow() {
		return arrow;
	}

	public void redo() {
		execute();
	}

	public void setRelativeDimensions(Dimension dim1, Dimension dim2) {
		d1 = dim1;
		d2 = dim2;
	}

	public void setIndex(int i) {
		index = i;
	}

	public void setLocation(Point p) {
		location = p;
	}

	public void setArrow(DArrow w) {
		arrow = w;
	}

}
