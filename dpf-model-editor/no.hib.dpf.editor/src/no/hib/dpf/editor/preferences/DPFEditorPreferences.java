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
	
    public IPreferenceStore getPreferenceStore() {
    	return DPFPlugin.getDefault().getPreferenceStore();
    }
	
	public boolean getDisplayArrows() {
        return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_ARROWS);
	}
	
	public boolean getDisplayTypeNames() {
		return getPreferenceStore().getBoolean(PreferenceConstants.P_DISPLAY_TYPES);
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
