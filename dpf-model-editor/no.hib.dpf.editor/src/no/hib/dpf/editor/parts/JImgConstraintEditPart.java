/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.BasicRectangleFigure;
import no.hib.dpf.editor.figures.BetweenArrowsConstraintFigure;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Constraint model elements.
 */
class JImgConstraintEditPart extends ConstraintEditPart {

	public JImgConstraintEditPart() {
		super(true);
	}

	/**
	 * Returns the primary Figure representing this GraphicalEditPart, a Constraint Figure.
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigureExec() {
		BasicRectangleFigure basicRectangleFigure = getRectangleFigureForFigure(false);
		BetweenArrowsConstraintFigure connection = new BetweenArrowsConstraintFigure(basicRectangleFigure, "[Joint Image]");
		connection.setLineStyle(getCastedModel().getLineStyle());
		return connection;
	}

}