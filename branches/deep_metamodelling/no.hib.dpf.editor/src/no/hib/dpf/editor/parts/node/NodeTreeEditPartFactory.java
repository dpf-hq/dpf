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
package no.hib.dpf.editor.parts.node;

import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.displaymodel.MovableAndSizable;
import no.hib.dpf.editor.parts.DiagramTreeEditPart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;



/**
 * Factory that maps model elements to TreeEditParts.
 * TreeEditParts are used in the outline view of the ShapesEditor.
 * @author Elias Volanakis
 */
public class NodeTreeEditPartFactory implements EditPartFactory {

/* (non-Javadoc)
 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
 */
@Override
public EditPart createEditPart(EditPart context, Object model) {
	if (model instanceof DNode || model instanceof DDataNode) {
		return new NodeTreeEditPart((MovableAndSizable) model);
	}
	
	if (model instanceof DGraph) {
		return new DiagramTreeEditPart((DGraph) model);
	}
	return null; // will not show an entry for the corresponding model instance
}

}
