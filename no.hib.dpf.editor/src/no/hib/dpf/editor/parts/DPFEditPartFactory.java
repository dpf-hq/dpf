/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;


/**
 * Factory that maps model elements to edit parts.
 * @author Elias Volanakis
 */
public class DPFEditPartFactory implements EditPartFactory {

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object modelElement) {
		// get EditPart for model element
		EditPart part = getPartForElement(modelElement);
		// store model element in EditPart
		part.setModel(modelElement);
		return part;
	}

	/**
	 * Maps an object to an EditPart. 
	 * @throws RuntimeException if no match was found (programming error)
	 */
	protected EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof DGraph) {
			return new DGraphEditPart();
		}
		if (modelElement instanceof DNode) {
			if(modelElement instanceof DConstraintNode)
				return new DComposedNodePart();
			else
				return new DNodeEditPart();
		}
		if (modelElement instanceof DArrow) {
			return new DArrowEditPart();
		}
		if (modelElement instanceof DOffset) {
			DOffset offset = (DOffset) modelElement;
			if(offset.eContainer() instanceof DArrow)
				return new ArrowLabelEditPart();
		}
		if(modelElement instanceof DGenericArrowConstraint){
			DGenericArrowConstraint constraint = (DGenericArrowConstraint) modelElement;
			return constraint.getDPredicate() != null ? new TwoArrowsOneNodeConstraintEditPart()
			: new DConstraintFromNodeEditPart();
		}
		if(modelElement instanceof DArrowLabelConstraint)
			return new SingleArrowConstraintEditPart();
		throw new RuntimeException(
				"Can't create part for model element: "
						+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
	}

}