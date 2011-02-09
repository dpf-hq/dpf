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
import no.hib.dpf.editor.viewmodel.MovableAndSizable;
import no.hib.dpf.editor.viewmodel.VNode;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;



/**
 * Factory that maps model elements to TreeEditParts.
 * TreeEditParts are used in the outline view of the ShapesEditor.
 * @author Elias Volanakis
 */
public class VNodesTreeEditPartFactory implements EditPartFactory {

/* (non-Javadoc)
 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
 */
public EditPart createEditPart(EditPart context, Object model) {
	if (model instanceof VNode) {
		return new VNodeTreeEditPart((MovableAndSizable) model);
	}
	if (model instanceof DPFDiagram) {
		return new DiagramTreeEditPart((DPFDiagram) model);
	}
	return null; // will not show an entry for the corresponding model instance
}

}
