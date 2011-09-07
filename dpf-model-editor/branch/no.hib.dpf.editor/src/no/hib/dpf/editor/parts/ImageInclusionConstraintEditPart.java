/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.ParallelArrowsConstraintConnection;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Image Inclusion constraint elements.
 */
public class ImageInclusionConstraintEditPart extends ParallelArrowsConstraintEditPart {

	public ImageInclusionConstraintEditPart() {
		super(false);
	}

	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(false);
	}
	
	@Override
	protected IFigure createFigureExec() {
		return new ParallelArrowsConstraintConnection(this, "[⊒]");
	}
	
}