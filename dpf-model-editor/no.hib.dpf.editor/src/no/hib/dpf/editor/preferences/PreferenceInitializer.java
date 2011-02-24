package no.hib.dpf.editor.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import no.hib.dpf.editor.DPFPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = DPFPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_DISPLAY_ARROWS, true);
		store.setDefault(PreferenceConstants.P_NODE_COLOR, "255,255,255");
		
//		store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
//		store.setDefault(PreferenceConstants.P_STRING, "Default value");
	}

}
