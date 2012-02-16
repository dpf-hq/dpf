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

import java.beans.PropertyChangeEvent;

import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.policies.TextDirectEditManager;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.TextCellEditor;

public class ArrowLabelEditPart extends LabelEditPart {

	@Override
	protected boolean getVisible() {
		return DPFEditorPreferences.getDefault().getDisplayArrows();
	}

	@Override
	protected boolean placeLabelAtEnd() {
		return false;
	}

	@Override
	protected String getFullName() {
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames()) {
			return getModelParent().getName() + " : " + getModelParent().getTypeName();
		} else {
			return getModelParent().getName();
		}
	}
	
	@Override
	protected DArrow getModelParent() {
		return (DArrow) getConnectionModel().getParent();
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		String request = evt.getPropertyName();
		if (request.equals(DArrow.NAME_PROP) || request.equals(DArrow.PROP_CONFIGURE))
			refreshVisuals();
		else
			super.propertyChange(evt);
	}
	
	public void performRequest(Request request) {
		if(getConnectionModel().isConstraintLabel())
			return;
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			if (manager == null) {
				manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator((Label) getFigure()));
			}
			manager.show();
		}
	}
	
	protected void listenToDisplayNameProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if ((event.getProperty().equals(PreferenceConstants.P_DISPLAY_ARROWS)) ||
					(event.getProperty().equals(PreferenceConstants.P_DISPLAY_TYPES))) {
					refreshVisuals();
				}
			}
		});
	}
	
	public void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}
	
}
