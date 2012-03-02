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
package no.hib.dpf.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = DPFEditorPreferences.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_DISPLAY_ARROWS, true);
		store.setDefault(PreferenceConstants.P_DISPLAY_TYPES, true);
		store.setDefault(PreferenceConstants.P_NODE_COLOR, "255,255,255");
		store.setDefault(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS, false);
		store.setDefault(PreferenceConstants.P_DISPLAY_TYPED_ARROWS, true);		
	}

}
