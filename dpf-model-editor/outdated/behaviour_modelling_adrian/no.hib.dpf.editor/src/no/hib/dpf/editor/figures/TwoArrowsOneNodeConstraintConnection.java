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
package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.parts.DConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class TwoArrowsOneNodeConstraintConnection extends TwoArrowConstraintConnection  {

		
	public TwoArrowsOneNodeConstraintConnection(DConstraintEditPart constraintEditPart, String labelText) {
		super(constraintEditPart, labelText, new int[]{45, 30});
	}	
	
}