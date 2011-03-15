package no.hib.dpf.editor.parts;

/**
 * Original code taken from now-defunct site qvtp.org.
 * 
 * Copyright (c) 2004, QVT-Partners.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the QVT-Partners nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS 
 BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
 OF SUCH DAMAGE. 
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import no.hib.dpf.editor.model.ArrowLabel;
import no.hib.dpf.editor.policies.ArrowTextEditPolicy;
import no.hib.dpf.editor.policies.ArrowTextMovePolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;
import no.hib.dpf.editor.tracker.ArrowTextTracker;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.TextCellEditor;

public class ArrowLabelEditPart extends AbstractGraphicalEditPart implements
		PropertyChangeListener {

	TextEditManager manager = null;

	public ArrowLabelEditPart() {
		listenToDisplayNameProperty();
	}
	
	private void listenToDisplayNameProperty() {
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
	
	private String getFullName(String name) {
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames()) {
			return name + " : " + ((ArrowEditPart) getParent()).getArrow().getTypeName();
		} else {
			return name;
		}
	}
	
	public void activate() {
		if (isActive() == false) {
			super.activate();
			((ArrowLabel) getModel()).addPropertyChangeListener(this);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((ArrowLabel) getModel()).removePropertyChangeListener(this);
		}
	}

	public IFigure createFigure() {
		String text = getConnectionModel().getLabelText();
		Label label = new Label();
		label.setText(text);
		return label;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		String request = evt.getPropertyName();
		if (request.equals(ArrowLabel.POSITION_PROP) || request.equals(ArrowLabel.NAME_PROP))
			refreshVisuals();
	}

	public void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ArrowTextMovePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new ArrowTextEditPolicy());
	}

	public DragTracker getDragTracker(Request request) {
		return new ArrowTextTracker(this, (ArrowEditPart)getParent());
	}

	private Label getCastedFigure() {
		return (Label)getFigure();
	}
	
	protected void refreshVisuals() {
		String arrowName = getFullName(getConnectionModel().getLabelText());
		Point offset = getConnectionModel().getOffset();
		Label figure = getCastedFigure();
		figure.setText(arrowName);
		figure.setVisible(DPFEditorPreferences.getDefault().getDisplayArrows());
		ArrowEditPart parent = (ArrowEditPart) getParent();
		PolylineConnection connFigure = (PolylineConnection)parent.getFigure();
		ArrowLabelConstraint constraint = new ArrowLabelConstraint(arrowName, offset, connFigure);
		parent.setLayoutConstraint(this, getFigure(), constraint);
	}

	public ArrowLabel getConnectionModel() {
		return (ArrowLabel) getModel();
	}

	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEdit();
		}
	}

	private void performDirectEdit() {
		if (manager == null) {
			manager = new TextEditManager(this, TextCellEditor.class, new TextCellEditorLocator((Label) getFigure()));
		}
		manager.show();
	}
}