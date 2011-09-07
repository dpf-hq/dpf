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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.ModelElement;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;



/**
 * TreeEditPart for a DPFDiagram instance.
 * This is used in the Outline View of the ShapesEditor.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
class DiagramTreeEditPart extends AbstractTreeEditPart
	implements PropertyChangeListener {

/** 
 * Create a new instance of this edit part using the given model element.
 * @param model a non-null DPFDiagram instance
 */
DiagramTreeEditPart(DPFDiagram model) {
	super(model);
}

/**
 * Upon activation, attach to the model element as a property change listener.
 */
public void activate() {
	if (!isActive()) {
		super.activate();
		((ModelElement) getModel()).addPropertyChangeListener(this);
	}
}

/* (non-Javadoc)
 * @see org.eclipse.gef.examples.shapes.parts.ShapeTreeEditPart#createEditPolicies()
 */
protected void createEditPolicies() {
	// If this editpart is the root content of the viewer, then disallow removal
	if (getParent() instanceof RootEditPart) {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
	}
}

/**
 * Upon deactivation, detach from the model element as a property change listener.
 */
public void deactivate() {
	if (isActive()) {
		super.deactivate();
		((ModelElement) getModel()).removePropertyChangeListener(this);
	}
}

private DPFDiagram getCastedModel() {
	return (DPFDiagram) getModel();
}

/**
 * Convenience method that returns the EditPart corresponding to a given child.
 * @param child a model element instance
 * @return the corresponding EditPart or null
 */
private EditPart getEditPartForChild(Object child) {
	return (EditPart) getViewer().getEditPartRegistry().get(child);
}

/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
 */
@Override
protected List<DNode> getModelChildren() {
	return getCastedModel().getChildren(); // a list of shapes
}

/* (non-Javadoc)
* @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
*/
public void propertyChange(PropertyChangeEvent evt) {
	String prop = evt.getPropertyName();
	if (DPFDiagram.CHILD_ADDED_PROP.equals(prop)) {
		// add a child to this edit part
		// causes an additional entry to appear in the tree of the outline view
		addChild(createChild(evt.getNewValue()), -1);
	} else if (DPFDiagram.CHILD_REMOVED_PROP.equals(prop)) {
		// remove a child from this edit part
		// causes the corresponding edit part to disappear from the tree in the outline view
		removeChild(getEditPartForChild(evt.getNewValue()));
	} else {
		refreshVisuals();
	}
}
}
