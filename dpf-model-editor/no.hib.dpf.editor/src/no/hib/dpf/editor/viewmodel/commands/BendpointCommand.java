/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package no.hib.dpf.editor.viewmodel.commands;

import no.hib.dpf.editor.viewmodel.VArrow;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import org.eclipse.gef.commands.Command;

public class BendpointCommand extends Command {

	protected int index;
	protected Point location;
	protected VArrow arrow;
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

	protected VArrow getArrow() {
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

	public void setArrow(VArrow w) {
		arrow = w;
	}

}
