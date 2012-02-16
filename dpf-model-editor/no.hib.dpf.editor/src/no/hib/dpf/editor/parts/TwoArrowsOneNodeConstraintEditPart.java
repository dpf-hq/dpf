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

import org.eclipse.draw2d.IFigure;

import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.TwoArrowsOneNodeConstraintConnection;

public class TwoArrowsOneNodeConstraintEditPart extends DConstraintEditPart {
	
	public TwoArrowsOneNodeConstraintEditPart() {
		super();
	}

	@Override
	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(true);
	}
		
	/**
	 * Returns the primary Figure representing this GraphicalEditPart, a Constraint Figure.
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigureExec() {
		return new TwoArrowsOneNodeConstraintConnection(this, ((DConstraint)getModel()).getConstraint().getPredicate().getSymbol());
	}
	
}
