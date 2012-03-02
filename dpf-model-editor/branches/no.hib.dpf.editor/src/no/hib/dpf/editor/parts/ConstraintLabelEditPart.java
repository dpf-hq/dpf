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

import no.hib.dpf.editor.displaymodel.DConstraint;


public class ConstraintLabelEditPart extends LabelEditPart {

	@Override
	protected boolean getVisible() {
		return true;
	}

	@Override
	protected boolean placeLabelAtEnd() {
		return true;
	}

	@Override
	protected String getFullName() {
		DConstraint constraint = getModelParent();
		String[] values = constraint.getValues();
		String result = constraint.getPredicate().getSymbol();
		for (int i = 0; i < values.length; i++) {
			String string = values[i];
			if(i == 0)
				result += "[";
			if(string.equals("-1"))
				string = "*";
			result += string;
			result += i == values.length - 1 ? "]" : ",";
		}
		return result;
	}

	@Override
	protected DConstraint getModelParent() {
		return (DConstraint) getConnectionModel().getParent();
	}
	public void propertyChange(PropertyChangeEvent evt) { 
		String request = evt.getPropertyName();
		if (request.equals(DConstraint.PARAMETER_PROP))
			refreshVisuals();
		else
			super.propertyChange(evt);
	}
}
