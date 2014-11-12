/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.ui.IEditorPart;

public abstract class GraphicalConnectionEditPart extends AbstractConnectionEditPart{

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
    
    @Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void refreshSourceConnections() {
		int i;
		ConnectionEditPart editPart;
		Object model;

		List sourceConnections = getSourceConnections();
		int size = sourceConnections.size();
		Map modelToEditPart = Collections.EMPTY_MAP;
		if (size > 0) {
			modelToEditPart = new HashMap(size);
			for (i = 0; i < size; i++) {
				editPart = (ConnectionEditPart) sourceConnections.get(i);
				modelToEditPart.put(editPart.getModel(), editPart);
			}
		}

		List modelObjects = getModelSourceConnections();
		if (modelObjects == null) {
			modelObjects = Collections.EMPTY_LIST;
		}
		for (i = 0; i < modelObjects.size(); i++) {
			model = modelObjects.get(i);

			if (i < sourceConnections.size() && ((EditPart) sourceConnections.get(i)).getModel() == model){
				((EditPart) sourceConnections.get(i)).refresh();
				continue;
			}

			editPart = (ConnectionEditPart) modelToEditPart.get(model);
			if (editPart != null)
				reorderSourceConnection(editPart, i);
			else {
				editPart = createOrFindConnection(model);
				addSourceConnection(editPart, i);
			}
		}

		// Remove the remaining EditParts
		size = sourceConnections.size();
		if (i < size) {
			List trash = new ArrayList(size - i);
			for (; i < size; i++)
				trash.add(sourceConnections.get(i));
			for (i = 0; i < trash.size(); i++)
				removeSourceConnection((ConnectionEditPart) trash.get(i));
		}
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void refreshTargetConnections() {
		int i;
		ConnectionEditPart editPart;
		Object model;

		List targetConnections = getTargetConnections();
		int size = targetConnections.size();
		Map modelToEditPart = Collections.EMPTY_MAP;
		if (size > 0) {
			modelToEditPart = new HashMap(size);
			for (i = 0; i < size; i++) {
				editPart = (ConnectionEditPart) targetConnections.get(i);
				modelToEditPart.put(editPart.getModel(), editPart);
			}
		}

		List modelObjects = getModelTargetConnections();
		if (modelObjects == null) {
			modelObjects = Collections.EMPTY_LIST;
		}
		for (i = 0; i < modelObjects.size(); i++) {
			model = modelObjects.get(i);

			if (i < targetConnections.size()
					&& ((EditPart) targetConnections.get(i)).getModel() == model){
				((EditPart) targetConnections.get(i)).refresh();
				continue;
			}

			editPart = (ConnectionEditPart) modelToEditPart.get(model);
			if (editPart != null)
				reorderTargetConnection(editPart, i);
			else {
				editPart = createOrFindConnection(model);
				addTargetConnection(editPart, i);
			}
		}

		// Remove the remaining EditParts
		size = targetConnections.size();
		if (i < size) {
			List trash = new ArrayList(size - i);
			for (; i < size; i++)
				trash.add(targetConnections.get(i));
			for (i = 0; i < trash.size(); i++)
				removeTargetConnection((ConnectionEditPart) trash.get(i));
		}
	}
    protected IPropertyChangeListener propertyListener = new IPropertyChangeListener() {
		@Override
		public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
			GraphicalConnectionEditPart.this.propertyChange(event);
		}
	};
	
	public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event){
		if ((event.getProperty().equals(PreferenceConstants.P_DISPLAY_ARROWS)) ||
				(event.getProperty().equals(PreferenceConstants.P_DISPLAY_TYPES))) {
				refreshVisuals();
			}
	}
    protected void handleModelChanged(Notification msg){}
	protected void handleDiagramModelChanged(Notification msg){
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			switch(msg.getFeatureID(DNode.class)){
			case DiagramPackage.DNODE__LOCATION:
			case DiagramPackage.DNODE__SIZE:
				refreshVisuals();
				break;
			}
			
			switch(msg.getFeatureID(DDataNode.class)){
			case DiagramPackage.DDATA_NODE__LOCATION:
			case DiagramPackage.DDATA_NODE__SIZE:
				refreshVisuals();
				break;
			}

		}
	}
	protected EObject getDiagramModel(){
		return (EObject) getModel();
	}
	
	/*
	 * listen to diagram model, DNode, DArrow
	 */
	protected void listen(){
		EObject diagramModel = getDiagramModel();
		if(diagramModel != null && !diagramModel.eAdapters().contains(diagrammodelListener))
			diagramModel.eAdapters().add(diagrammodelListener);
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(propertyListener);
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
	
	/**
	 * Upon activation, attach to the model element as a property change
	 * listener.
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			super.activate();
			listen();
		}
	}

	/**
	 * Upon deactivation, detach from the model element as a property change
	 * listener.
	 */
	@Override
	public void deactivate() {
		if (isActive()) {
			unlisten();
			super.deactivate();
		}
	}
	protected DPFEditor getEditor(){
		if(getRoot() == null || getRoot().getViewer() == null)
			return null;
		EditDomain editDomain = getRoot().getViewer().getEditDomain();
		if(editDomain instanceof DefaultEditDomain){
			IEditorPart editor = ((DefaultEditDomain)editDomain).getEditorPart();
			if(editor instanceof DPFEditor)
				return (DPFEditor) editor;
		}
		return null;
	}


}
