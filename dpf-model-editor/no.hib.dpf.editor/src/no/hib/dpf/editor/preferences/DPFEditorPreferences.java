package no.hib.dpf.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;

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
	
	public Color getNodeColor() {
        IPreferenceStore store = DPFPlugin.getDefault().getPreferenceStore();
        String colorString = store.getString(PreferenceConstants.P_NODE_COLOR);
		
		try {
			return new Color(null, Integer.parseInt(colorString.split(",")[0]), Integer.parseInt(colorString.split(",")[1]), Integer.parseInt(colorString.split(",")[2]));
		} catch (Exception e) {
			return new Color(null, 255,255,255);
		}
	}
}
