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
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.LabelConstraintConnection;
import no.hib.dpf.editor.figures.TwoArrowsOneNodeConstraintConnection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public class TwoArrowsOneNodeConstraintEditPart extends DConstraintEditPart {
	
	/**
	 * Returns the primary Figure representing this GraphicalEditPart, a Constraint Figure.
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		return new TwoArrowsOneNodeConstraintConnection(this);
	}
	
	protected void refreshVisuals() {
		if(getConstraint() == null) return;
		String labelText = getConstraint().getPredicate().getSymbol();
		Label label = ((LabelConstraintConnection)getFigure()).getLabel();
		label.setText("[" + labelText + "]");
	}
	public boolean isSelectable(){
		return getFigure() != null && getFigure().isShowing();
	}
}
