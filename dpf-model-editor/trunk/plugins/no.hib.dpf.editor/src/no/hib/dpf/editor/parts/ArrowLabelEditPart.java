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


import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.policies.ArrowLabelMovePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.tracker.ArrowTextTracker;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.TextCellEditor;

public class ArrowLabelEditPart extends GraphicalEditPartWithListener{

	DirectEditManager manager = null;

	public void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ArrowLabelMovePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}

	public IFigure createFigure() {
		Label label = new Label();
		label.setOpaque(true);
		return label;
	}
	public DArrow getDArrow(){
		EditPart parent = getParent();
		if(parent instanceof DArrowEditPart){
			return ((DArrowEditPart)parent).getDArrow();
		}
		return null;
	}
	
	public DArrowEditPart getDArrowEditPart() {
		return (DArrowEditPart) getParent();
	}

	public DOffset getDOffset(){
		return (DOffset) getModel();
	}

	public DragTracker getDragTracker(Request request) {
		return new ArrowTextTracker(this, (DArrowEditPart)getParent());
	}
	
	protected String getFullName() {
		DArrow darrow = getDArrow();
		if(darrow == null)
			return "";
		String result = darrow.getArrow().getName();
		if(result == null) result = "";
		Arrow type = darrow.getArrow().getTypeArrow();
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames() && type != null && type.getName() != null)
			result += " : " + type.getName();
		return result;
	}
	
	public Label getLabel() { return (Label)getFigure(); }

	protected Point getOffset(){
		return getDOffset().getOffset();
	}

	protected void handleDiagramModelChanged(Notification msg){
		if(msg.getNotifier() != null && msg.getNotifier() == getDOffset()){ 
			switch(msg.getFeatureID(DOffset.class)){
			case DiagramPackage.DOFFSET__OFFSET:
			case DiagramPackage.DOFFSET__INDEX:
			case DiagramPackage.DOFFSET__LEN:
				refreshVisuals();
				break;
			}
		}
	}	
	protected void listen(){
		addUIAdapter(getDOffset(), diagrammodelListener);
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(propertyListener);
	}

	private void performDirectEdit() {
		if (manager == null) {
			manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator((Label) getFigure()));
		}
		manager.show();
	}

	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEdit();
		}
	}

	@Override
	protected void refreshVisuals() {
		String arrowName = getFullName();
		Label figure = getLabel();
		figure.setText(arrowName);
		figure.setVisible(DPFEditorPreferences.getDefault().getDisplayArrows());
		DArrowEditPart parent = (DArrowEditPart) getParent();
		ArrowLabelLocator constraint = new ArrowLabelLocator(arrowName, getDOffset(), parent);
		parent.setLayoutConstraint(this, getFigure(), constraint);
	}
	protected void unlisten(){
		DPFEditorPreferences.getDefault().getPreferenceStore().removePropertyChangeListener(propertyListener);
		removeUIAdapter(getDOffset(), diagrammodelListener);
	}
	
	
}