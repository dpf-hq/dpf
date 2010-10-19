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
import no.hib.dpf.editor.figures.JInjConstraintFigure;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Constraint model elements. THIS WILL BE REFACTORED USING
 * "THE OTHER ONE" AS A TEMPLATE!
 */
class JInjConstraintEditPart extends ConstraintEditPart {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		BasicRectangleFigure basicRectangleFigure = getRectangleFigureForFigure(true);
		// TODO: make factory:
		JInjConstraintFigure connection = new JInjConstraintFigure(basicRectangleFigure);
		connection.setLineStyle(getCastedModel().getLineStyle()); 
		return connection;
	}

}