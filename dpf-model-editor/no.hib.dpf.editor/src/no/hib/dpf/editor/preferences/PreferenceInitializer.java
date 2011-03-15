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
	}

}
