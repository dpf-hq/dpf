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
package no.hib.dpf.editor.displaymodel.factories;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.parts.arrow.ArrowLabelEditPart;
import no.hib.dpf.editor.parts.arrow.DArrowEditPart;
import no.hib.dpf.editor.parts.attribute.DArrowDAttributeEditPart;
import no.hib.dpf.editor.parts.attribute.DArrowDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.constraint.DConstraintFromNodeEditPart;
import no.hib.dpf.editor.parts.constraint.SingleArrowConstraintEditPart;
import no.hib.dpf.editor.parts.constraint.TwoArrowsOneNodeConstraintEditPart;
import no.hib.dpf.editor.parts.node.DComposedNodePart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;

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
	@Override
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
		if (modelElement instanceof DDataNode) {
			return new DDataNodeEditPart();
		}
		if (modelElement instanceof DArrow) {
			return new DArrowEditPart();
		}
		if (modelElement instanceof DNodeDAttribute) {
			return new DNodeDAttributeEditPart();
		}
		
		if (modelElement instanceof DArrowDAttribute) {
			return new DArrowDAttributeEditPart();
		}
		
		if (modelElement instanceof DOffset) {
			DOffset offset = (DOffset) modelElement;
			if(offset.eContainer() instanceof DArrow){
				return new ArrowLabelEditPart();
			}else if(offset.eContainer() instanceof DNodeDAttribute){
				return new DNodeDAttributeLabelEditPart();
			}else if(offset.eContainer() instanceof DArrowDAttribute){
				return new DArrowDAttributeLabelEditPart();
			}
		}
		if(modelElement instanceof DGenericArrowConstraint){
			DGenericArrowConstraint constraint = (DGenericArrowConstraint) modelElement;
			return constraint.getDPredicate() != null ? new TwoArrowsOneNodeConstraintEditPart() : new DConstraintFromNodeEditPart();
		}
		if(modelElement instanceof DArrowLabelConstraint){
			return new SingleArrowConstraintEditPart();
		}
		
		throw new RuntimeException("Can't create part for model element: "
						+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
	}

}