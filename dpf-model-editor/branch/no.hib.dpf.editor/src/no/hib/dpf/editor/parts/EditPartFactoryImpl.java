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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.displaymodel.ArrowLabel;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.ModelElement;
import no.hib.dpf.editor.displaymodel.SingleNodeConnection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.SWT;


/**
 * Factory that maps model elements to edit parts.
 * @author Elias Volanakis
 */
public class EditPartFactoryImpl implements EditPartFactory {

	DPFDiagram diagram;
	public EditPartFactoryImpl(DPFDiagram parent) {
		diagram = parent;
	}

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

private IConfigurationElement getConfigure(ModelElement element){
	if(diagram == null)
		return null;
	if(element instanceof DNode){
		DNode dnode = (DNode) element;
		Node node = dnode.getNodeComponent();
		Node type = node.getTypeNode();
		DNode dnodetype = diagram.findDNode(type);
		assert(dnodetype != null);
		return dnodetype.getConfigure();
	}
	if(element instanceof DArrow){
		DArrow darrow = (DArrow) element;
		Arrow arrow = darrow.getArrowComponent();
		Arrow type = arrow.getTypeArrow();
		DArrow arrowType = diagram.findDArrow(type);
		assert(arrowType != null);
		darrow.parentLineSytle = arrowType.getLineStyle();
		if(darrow.getLineStyle() != SWT.LINE_DASH)
			darrow.setLineStyle(darrow.parentLineSytle);
		return arrowType.getConfigure();
	}
	return null;
	
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
		IConfigurationElement figure = getConfigure((DNode)modelElement);
		if(figure == null)
			return new NodeEditPart();
		else
			return new NodeEditPart(figure);
	}
	if (modelElement instanceof SingleNodeConnection) {
		IConfigurationElement figure = getConfigure((SingleNodeConnection)modelElement);
		
		if(figure == null)
			return new SingleArrowEditPart();
		else
			return new SingleArrowEditPart(figure);
	}
	if (modelElement instanceof DArrow) {
		IConfigurationElement figure = getConfigure((DArrow)modelElement);
		if(figure == null)
			return new ArrowEditPart();
		else
			return new ArrowEditPart(figure);
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
			case NAND : return new NANDConstraintEditPart();
		}
		throw new RuntimeException("The specified constraint type doesn't have an edit part association.");
	}
	throw new RuntimeException(
			"Can't create part for model element: "
			+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
}

}