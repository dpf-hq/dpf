/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.OppositeArrowsConstraintAnchor;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.EditPart;

public abstract class ParallelArrowsConstraintEditPart extends ConstraintEditPart {

	public ParallelArrowsConstraintEditPart(boolean constraintFromTargetEnd) {
		super(constraintFromTargetEnd);
	}

	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * constraint. The source (or target) needs to be an instance of
	 * <code>ArrowEditPart</code>,
	 * 
	 * @param supplier
	 *            the source or target of this edit part.
	 * @param isSource
	 *            true if supplier is source, false if not.
	 * @return A new ConnectionAnchor.
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		// Constructing the anchor with "isSource" ensures that the target end
		// of both arrow is used.
		ConstraintAnchor retval = new OppositeArrowsConstraintAnchor(true);
		if ((supplier == null) || (!(supplier instanceof ArrowEditPart))) {
			return retval;
		}
		updateAnchor(retval, supplier, isSource);

		return retval;
	}
}