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

import no.hib.dpf.editor.displaymodel.ArrowBendpoint;

import org.eclipse.draw2d.Bendpoint;

public class MoveBendpointCommand extends BendpointCommand {

	private Bendpoint oldBendpoint;

	public void execute() {
		ArrowBendpoint bp = new ArrowBendpoint();
		bp.setRelativeDimensions(getFirstRelativeDimension(),
				getSecondRelativeDimension());
		setOldBendpoint((Bendpoint) getArrow().getBendpoints().get(getIndex()));
		getArrow().setBendpoint(getIndex(), bp);
		super.execute();
	}

	protected Bendpoint getOldBendpoint() {
		return oldBendpoint;
	}

	public void setOldBendpoint(Bendpoint bp) {
		oldBendpoint = bp;
	}

	public void undo() {
		super.undo();
		getArrow().setBendpoint(getIndex(), getOldBendpoint());
	}

}
