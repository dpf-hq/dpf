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

import java.util.List;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.jface.util.IPropertyChangeListener;



/**
 * TreeEditPart for a DPFDiagram instance.
 * This is used in the Outline View of the ShapesEditor.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
class DiagramTreeEditPart extends AbstractTreeEditPart{

/**
 * Listener for the node notifications
 */
protected UIAdapter diagrammodelListener = new UIAdapter()
{
    /**
     * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void safeNotifyChanged(Notification msg)
    {
        handleDiagramModelChanged(msg);
    }

};



/**
 * Listener for the node notifications
 */
protected UIAdapter modelListener = new UIAdapter()
{
    /**
     * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void safeNotifyChanged(Notification msg)
    {
        handleModelChanged(msg);
    }

};

protected IPropertyChangeListener propertyListener = new IPropertyChangeListener() {
	@Override
	public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
		DiagramTreeEditPart.this.propertyChange(event);
	}
};

/** 
 * Create a new instance of this edit part using the given model element.
 * @param model a non-null DPFDiagram instance
 */
DiagramTreeEditPart(DGraph model) {
	super(model);
}

/**
 * Upon activation, attach to the model element as a property change
 * listener.
 */
public void activate() {
	if (!isActive()) {
		super.activate();
		listen();
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
 * Upon deactivation, detach from the model element as a property change
 * listener.
 */
public void deactivate() {
	if (isActive()) {
		unlisten();
		super.deactivate();
	}
}
private DSpecification getCastedModel() {
	return (DSpecification) getModel();
}

protected DGraph getDiagramModel(){
	return (DGraph) getModel();
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
	return getCastedModel().getDGraph().getDNodes(); // a list of shapes
}

protected void handleDiagramModelChanged(Notification msg){
	if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
		switch(msg.getFeatureID(DGraph.class)){
		case DiagramPackage.DGRAPH__DNODES:
			if(msg.getEventType() == Notification.ADD)
				addChild(createChild(msg.getNotifier()), -1);
			else
				removeChild(getEditPartForChild(msg.getNotifier()));
		case DiagramPackage.DGRAPH__DARROWS:
			refreshVisuals();
			break;
		}
	}
}


protected void handleModelChanged(Notification msg){}

/*
 * listen to diagram model, DNode, DArrow
 */
protected void listen(){
	EObject diagramModel = getDiagramModel();
	if(diagramModel != null && !diagramModel.eAdapters().contains(diagrammodelListener))
		diagramModel.eAdapters().add(diagrammodelListener);
	DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(propertyListener);
}

protected void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
	// TODO Auto-generated method stub
	if ((event.getProperty().equals(PreferenceConstants.P_DISPLAY_ARROWS)) ||
			(event.getProperty().equals(PreferenceConstants.P_DISPLAY_TYPES))) {
		refreshVisuals();
	}
	
}

/*
 * Unlisten to diagram model
 */
protected void unlisten(){
	DPFEditorPreferences.getDefault().getPreferenceStore().removePropertyChangeListener(propertyListener);
	EObject diagramModel = getDiagramModel();
	if(diagramModel != null && diagramModel.eAdapters().contains(diagrammodelListener))
		diagramModel.eAdapters().remove(diagrammodelListener);
}
}
