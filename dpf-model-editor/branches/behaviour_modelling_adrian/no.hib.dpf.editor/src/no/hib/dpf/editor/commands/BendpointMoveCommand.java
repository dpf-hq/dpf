/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.commands;

import org.eclipse.draw2d.geometry.Point;

public class BendpointMoveCommand extends BendpointCommand {

	private Point oldBendpoint;

	public void execute() {
		getArrow().getBendpoints().set(getIndex(), getLocation());
		super.execute();
	}

	public Point getOldBendpoint() {
		return oldBendpoint;
	}

	public void setOldBendpoint(Point point) {
		oldBendpoint = point;
	}

	public void setIndex(int i) {
		super.setIndex(i);
		setOldBendpoint(getArrow().getBendpoints().get(i));
	}
	
	public void undo() {
		getArrow().getBendpoints().set(getIndex(), getOldBendpoint());
	}

}
