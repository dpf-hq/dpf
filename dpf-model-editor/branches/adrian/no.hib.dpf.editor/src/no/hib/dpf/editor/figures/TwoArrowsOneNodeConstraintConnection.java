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
package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.parts.ConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class TwoArrowsOneNodeConstraintConnection extends TwoArrowConstraintConnection  {

		
	public TwoArrowsOneNodeConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		super(constraintEditPart, labelText, new int[]{45, 30});
	}	
	
}
