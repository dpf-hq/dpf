/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.policies.ArrowTextMovePolicy;
import no.hib.dpf.editor.policies.DConstraintDeletePolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;


public class SingleArrowConstraintEditPart extends ArrowLabelEditPart {

	public void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ArrowTextMovePolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DConstraintDeletePolicy());
	}

	protected String getFullName() {
		DConstraint dConstraint = getDConstraint();
		String result = dConstraint.getDPredicate().getSimpleName();
		String parameter = dConstraint.getConstraint().getParameters();
		if(parameter != null && !parameter.isEmpty()){
			String[] pairs = parameter.split(";");
			result += "[";
			for (int i = 0; i < pairs.length; i++) {
				String[] pair = pairs[i].split(":");
				result += pair[1];
				if(i != pairs.length - 1)
					result += ",";
			}
			result += "]";
		}
		return result;
	}
	
	@Override
	protected void refreshVisuals() {
		String arrowName = getFullName();
		Label figure = getLabel();
		figure.setText(arrowName);
		figure.setVisible(true);
		DArrowEditPart parent = (DArrowEditPart) getParent();
		PolylineConnection connFigure = (PolylineConnection)parent.getFigure();
		ArrowLabelLocator constraint = new ArrowLabelLocator(arrowName, getOffset(), connFigure, true);
		parent.setLayoutConstraint(this, getFigure(), constraint);
	}
	
	public void performRequest(Request request) { }
	
	protected DConstraint getDConstraint(){
		DOffset offset = getDOffset();
		EObject eObject = offset.eContainer();
		Assert.isTrue(eObject instanceof DConstraint);
		return (DConstraint) eObject;
	}
	protected void listen(){
		super.listen();
		addUIAdapter(getDConstraint().getConstraint(), diagrammodelListener);
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(propertyListener);
	}
	protected void unlisten(){
		super.unlisten();
		DPFEditorPreferences.getDefault().getPreferenceStore().removePropertyChangeListener(propertyListener);
		removeUIAdapter(getDConstraint().getConstraint(), diagrammodelListener);
	}
	
	protected void handleDiagramModelChanged(Notification msg){
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDConstraint().getConstraint()){ 
			switch(msg.getFeatureID(Constraint.class)){
			case CorePackage.CONSTRAINT__PARAMETERS:
				refreshVisuals();
				break;
			}
		}
	}
}
