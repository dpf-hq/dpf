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
package no.hib.dpf.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = DPFEditorPreferences.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_DISPLAY_ARROWS, true);
		store.setDefault(PreferenceConstants.P_DISPLAY_TYPES, true);
		store.setDefault(PreferenceConstants.P_NODE_COLOR, "255,255,255");
		store.setDefault(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS, false);
		store.setDefault(PreferenceConstants.P_DISPLAY_TYPED_ARROWS, true);	
		store.setDefault(PreferenceConstants.P_NODE_FGCOLOR, "0,0,0");
		store.setDefault(PreferenceConstants.P_NODE_BGCOLOR, "255,255,255");
		store.setDefault(PreferenceConstants.P_ARROW_FGCOLOR, "0,0,0");
		store.setDefault(PreferenceConstants.P_ARROW_BGCOLOR, "255,255,255");
		store.setDefault(PreferenceConstants.P_ARROW_SOURCE_COLOR, "0, 255, 0");
		store.setDefault(PreferenceConstants.P_ARROW_TARGET_COLOR, "0, 127, 0");
		store.setDefault(PreferenceConstants.P_ARROW_LABEL_SELECTED_ARROW_COLOR, "0, 0, 255");
		store.setDefault(PreferenceConstants.P_ARROW_VALIDATION_ERROR_ARROW_COLOR, "255, 0, 0");
	}

}
