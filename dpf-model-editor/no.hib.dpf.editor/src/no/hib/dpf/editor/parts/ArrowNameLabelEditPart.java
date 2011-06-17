/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.preferences.DPFEditorPreferences;

public class ArrowNameLabelEditPart extends ArrowLabelEditPart {

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
			return getConnectionModel().getLabelText() + " : " + ((ArrowEditPart) getParent()).getArrow().getTypeName();
		} else {
			return getConnectionModel().getLabelText();
		}
	}
	
}
