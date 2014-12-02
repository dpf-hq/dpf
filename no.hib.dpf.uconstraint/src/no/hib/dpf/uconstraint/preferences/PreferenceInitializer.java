package no.hib.dpf.uconstraint.preferences;


import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		
		IPreferenceStore store = ConstraintsEditorPreferences.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstraintsConstants.P_NODE_FGCOLOR, "0,0,0");
		store.setDefault(PreferenceConstraintsConstants.P_DISPLAY_TYPES, true);
		store.setDefault(PreferenceConstraintsConstants.P_NODE_BGCOLOR, "255,255,255");
		store.setDefault(PreferenceConstraintsConstants.PRESERVE_ITEMS_COLOR, "192,192,192");
		store.setDefault(PreferenceConstraintsConstants.INSERT_ITEMS_COLOR, "102,255,102");
		store.setDefault(PreferenceConstraintsConstants.DELETE_ITEMS_COLOR, "255,100,100");

	}
}


