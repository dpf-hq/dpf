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

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;


public class DPFEditorPreferences {

	private static DPFEditorPreferences INSTANCE;

	public static DPFEditorPreferences getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new DPFEditorPreferences();
		}
		return INSTANCE;
	}
	
    public IPreferenceStore getPreferenceStore() {
    	return DPFPlugin.getDefault().getPreferenceStore();
    }
	
	public boolean getDisplayArrows() {
        return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_ARROWS);
	}
	
	public boolean getDisplayTypeNames() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_TYPES);
	}
	
	public boolean getDisplayDynamicallyTypedArrows() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS);
	}
	
	public boolean getDisplayStaticallyTypedArrows() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_TYPED_ARROWS);
	}

	public Color getNodeColor() {
        String colorString = getPreferenceStore().getString(PreferenceConstants.P_NODE_COLOR);
		
		try {
			return new Color(null, Integer.parseInt(colorString.split(",")[0]), Integer.parseInt(colorString.split(",")[1]), Integer.parseInt(colorString.split(",")[2]));
		} catch (Exception e) {
			return new Color(null, 255,255,255);
		}
	}
}
