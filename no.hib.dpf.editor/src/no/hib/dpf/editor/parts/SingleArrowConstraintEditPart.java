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

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.figures.ArrowLabelLocator;
import no.hib.dpf.editor.policies.ArrowLabelMovePolicy;
import no.hib.dpf.editor.policies.DConstraintDeletePolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;


public class SingleArrowConstraintEditPart extends ArrowLabelEditPart {

	public void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ArrowLabelMovePolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DConstraintDeletePolicy());
	}

	protected DConstraint getDConstraint(){
		return (DConstraint) getModel();
	}
	
	public DOffset getDOffset(){
		return ((DArrowLabelConstraint)getModel()).getOffset();
	}
	
	protected String getFullName() {
		DConstraint dConstraint = getDConstraint();
		String result = dConstraint.getDPredicate().getSimpleName();
		result = "[" + result + "]";
		String parameter = dConstraint.getConstraint().getParameters();
		if(parameter != null && !parameter.isEmpty()){
			result += "(" + parameter + ")";
		}
		return result;
	}
	
	protected void handleModelChanged(Notification msg){
		super.handleModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDConstraint().getConstraint()){ 
			switch(msg.getFeatureID(Constraint.class)){
			case CorePackage.CONSTRAINT__PARAMETERS:
				refreshVisuals();
				break;
			}
		}
	}
	
	protected void listen(){
		super.listen();
		addUIAdapter(getDConstraint().getConstraint(), modelListener);
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(propertyListener);
	}
	public void performRequest(Request request) { }
	@Override
	protected void refreshVisuals() {
		String arrowName = getFullName();
		Label figure = getLabel();
		figure.setText(arrowName);
		figure.setVisible(true);
		DArrowEditPart parent = (DArrowEditPart) getParent();
		ArrowLabelLocator constraint = new ArrowLabelLocator(arrowName, getDOffset(), parent);
		parent.setLayoutConstraint(this, getFigure(), constraint);
	}
	
	protected void unlisten(){
		DPFEditorPreferences.getDefault().getPreferenceStore().removePropertyChangeListener(propertyListener);
		removeUIAdapter(getDConstraint().getConstraint(), modelListener);
		super.unlisten();
	}
}
