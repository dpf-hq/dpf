package no.hib.dpf.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import no.hib.dpf.editor.DPFPlugin;


public class DPFEditorPreferences {

	private static DPFEditorPreferences singleton;

	public static DPFEditorPreferences getDefault() {
		if (singleton == null) {
			singleton = new DPFEditorPreferences();
		}
		return singleton;
	}
	
	public boolean getDisplayArrows() {
        IPreferenceStore store = DPFPlugin.getDefault().getPreferenceStore();
        
        return store.getBoolean(PreferenceConstants.P_DISPLAY_ARROWS);
	}
}
