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

import no.hib.dpf.editor.viewmodel.DPFDiagram;
import no.hib.dpf.editor.viewmodel.SingleNodeConnection;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.editor.viewmodel.VNode;

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
	if (modelElement instanceof VNode) {
		return new VNodeEditPart();
	}
	if (modelElement instanceof SingleNodeConnection) {
		return new VNodeSingleConnectionEditPart();
	}
	if (modelElement instanceof VArrow) {
		return new VArrowEditPart();
	}
	if (modelElement instanceof VConstraint) {
		// Edit part according to the type of constraint element:
		switch (((VConstraint)modelElement).getConstraintType()) {
			case JointImage : return new JointlySurjectiveConstraintEditPart();
			case JointlyInjective : return new JointlyInjectiveConstraintEditPart();
			//case Multiplicity : return new MultiplicityConstraintEditPart();
		}
		throw new RuntimeException("The specified constraint type doesn't have an edit part association.");
	}
	throw new RuntimeException(
			"Can't create part for model element: "
			+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
}

}