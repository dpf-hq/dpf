package no.hib.dpf.transform.preferences;

import no.hib.dpf.transform.provider.TransformEditPlugin;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Color;

public class TransformEditorPreferences {

	private static TransformEditorPreferences INSTANCE;

	public static TransformEditorPreferences getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new TransformEditorPreferences();
		}
		return INSTANCE;
	}
	
    public IPreferenceStore getPreferenceStore() {
    	return TransformEditPlugin.getPlugin().getPreferenceStore();
    }
    
	public boolean getDisplayTypeNames() {
		return getPreferenceStore().getBoolean(PreferenceTransformConstants.P_DISPLAY_TYPES);
	}
    
    public Color getNodeBackgroundColor(){
		return getColor(PreferenceTransformConstants.P_NODE_BGCOLOR);
	}
	public Color getNodeForegroundColor(){
		return getColor(PreferenceTransformConstants.P_NODE_FGCOLOR);
	}
	public Color getPreserveForegroundColor(){
		return getColor(PreferenceTransformConstants.PRESERVE_ITEMS_COLOR);
	}
	public Color getInsertForegroundColor(){
		return getColor(PreferenceTransformConstants.INSERT_ITEMS_COLOR);
	}
	public Color getDeleteForegroundColor(){
		return getColor(PreferenceTransformConstants.DELETE_ITEMS_COLOR);
	}

	private Color getColor(String prefrence){
		String color = getPreferenceStore().getString(prefrence);
		Color result = getColorFromString(color);
		if(result == null){
			color = getPreferenceStore().getDefaultString(prefrence);
			return getColorFromString(color);
		}
		return result;
	}
	private Color getColorFromString(String colorString) {
		try {
			String[] colors = colorString.split(",");
			return new Color(null, Integer.parseInt(colors[0].trim()), Integer.parseInt(colors[1].trim()), Integer.parseInt(colors[2].trim()));
		} catch (Exception e) {
			return null;
		}
	}

	public Color getNodeColor() {
        String colorString = getPreferenceStore().getString(PreferenceTransformConstants.P_NODE_COLOR);
		
		try {
			return new Color(null, Integer.parseInt(colorString.split(",")[0]), Integer.parseInt(colorString.split(",")[1]), Integer.parseInt(colorString.split(",")[2]));
		} catch (Exception e) {
			return new Color(null, 255,255,255);
		}
	}
}
