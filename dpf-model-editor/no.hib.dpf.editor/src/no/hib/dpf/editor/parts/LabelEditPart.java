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
package no.hib.dpf.editor.parts;
/**
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

import no.hib.dpf.editor.displaymodel.ArrowLabel;
import no.hib.dpf.editor.policies.LabelMovePolicy;
import no.hib.dpf.editor.tracker.ArrowTextTracker;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;

public abstract class LabelEditPart extends AbstractGraphicalEditPart implements
		PropertyChangeListener {

	protected DirectEditManager manager = null;

	public LabelEditPart() {
		listenToDisplayNameProperty();
	}
	
	protected void listenToDisplayNameProperty() { }
		
	public void activate() {
		if (isActive() == false) {
			super.activate();
			((ArrowLabel) getModel()).addPropertyChangeListener(this);
			((ArrowLabel) getModel()).getParent().addPropertyChangeListener(this);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((ArrowLabel) getModel()).removePropertyChangeListener(this);
			((ArrowLabel) getModel()).getParent().removePropertyChangeListener(this);
		}
	}

	public IFigure createFigure() {
		Label label = new Label(getFullName());
		label.setOpaque(true);
		return label;
	}

	public void propertyChange(PropertyChangeEvent evt) { 
		String request = evt.getPropertyName();
		if (request.equals(ArrowLabel.POSITION_PROP))
			refreshVisuals();
	}

	public void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new LabelMovePolicy());
	}

	public DragTracker getDragTracker(Request request) {
		return new ArrowTextTracker(this, (ArrowEditPart)getParent());
	}

	private Label getCastedFigure() {
		return (Label)getFigure();
	}
	
	protected abstract boolean getVisible();
	
	protected abstract boolean placeLabelAtEnd();
	
	protected abstract String getFullName();
	
	protected abstract Object getModelParent();
	
	@Override
	protected void refreshVisuals() {
		String arrowName = getFullName();
		Point offset = getConnectionModel().getOffset();
		Label figure = getCastedFigure();
		figure.setText(arrowName);
		figure.setVisible(getVisible());
		ArrowEditPart parent = (ArrowEditPart) getParent();
		PolylineConnection connFigure = (PolylineConnection)parent.getFigure();
		LabelLocator constraint = new LabelLocator(arrowName, offset, connFigure, placeLabelAtEnd());
		parent.setLayoutConstraint(this, getFigure(), constraint);
	}
	
	public ArrowLabel getConnectionModel() {
		return (ArrowLabel) getModel();
	}
}