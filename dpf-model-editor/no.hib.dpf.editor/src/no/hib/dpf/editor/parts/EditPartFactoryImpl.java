/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
�* All rights reserved. This program and the accompanying materials
�* are made available under the terms of the Eclipse Public License v1.0
�* which accompanies this distribution, and is available at
�* http://www.eclipse.org/legal/epl-v10.html
�*
�* Contributors:
�*����Elias Volanakis - initial API and implementation
�*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.displaymodel.ArrowLabel;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.SingleNodeConnection;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;


/**
 * Factory that maps model elements to edit parts.
 * @author Elias Volanakis
 */
public class EditPartFactoryImpl implements EditPartFactory {


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
private EditPart getPartForElement(Object modelElement) {
	if (modelElement instanceof DPFDiagram) {
		return new DiagramEditPart();
	}
	if (modelElement instanceof DNode) {
		return new NodeEditPart();
	}
	if (modelElement instanceof SingleNodeConnection) {
		return new SingleArrowEditPart();
	}
	if (modelElement instanceof DArrow) {
		return new ArrowEditPart();
	}
	if (modelElement instanceof ArrowLabel) {
		if (((ArrowLabel)modelElement).isConstraintLabel()) {
			return new ArrowConstraintLabelEditPart();
		} else {
			return new ArrowNameLabelEditPart();
		}
	}
	if (modelElement instanceof DConstraint) {
		// Edit part according to the type of constraint element:
		switch (((DConstraint)modelElement).getConstraintType()) {
			case JOINTLY_SURJECTIVE : return new JointlySurjectiveConstraintEditPart();
			case JOINTLY_INJECTIVE : return new JointlyInjectiveConstraintEditPart();
			case INVERSE : return new InverseConstraintEditPart();
			case IMAGE_INCLUSION : return new ImageInclusionConstraintEditPart();
			case XOR : return new XORConstraintEditPart();
		}
		throw new RuntimeException("The specified constraint type doesn't have an edit part association.");
	}
	throw new RuntimeException(
			"Can't create part for model element: "
			+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
}

}