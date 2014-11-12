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
package no.hib.dpf.editor.parts.constraint;

import no.hib.dpf.editor.figures.ConstraintConnection;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Inverse constraint elements.
 */
public class InverseConstraintEditPart extends DConstraintEditPart {

	
	@Override
	protected IFigure createFigure() {
		return new ConstraintConnection(this);
	}
	
}