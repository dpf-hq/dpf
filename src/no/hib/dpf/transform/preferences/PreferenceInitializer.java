package no.hib.dpf.transform.preferences;


import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		
		IPreferenceStore store = TransformEditorPreferences.getDefault().getPreferenceStore();
		store.setDefault(PreferenceTransformConstants.P_NODE_FGCOLOR, "0,0,0");
		store.setDefault(PreferenceTransformConstants.P_DISPLAY_TYPES, true);
		store.setDefault(PreferenceTransformConstants.P_NODE_BGCOLOR, "255,255,255");
		store.setDefault(PreferenceTransformConstants.PRESERVE_ITEMS_COLOR, "192,192,192");
		store.setDefault(PreferenceTransformConstants.INSERT_ITEMS_COLOR, "102,255,102");
		store.setDefault(PreferenceTransformConstants.DELETE_ITEMS_COLOR, "255,100,100");

	}
}

