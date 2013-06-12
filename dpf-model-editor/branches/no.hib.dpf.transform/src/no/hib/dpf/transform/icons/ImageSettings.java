package no.hib.dpf.transform.icons;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public enum ImageSettings {
	IMG_GENERATE("GenerateHenshin_rules_16.png"),
	IMG_GENERATE2("ModelToVisualEntry.gif");
	
	private String fileName;
	
	ImageSettings(String filename) {
		fileName = "/icons/" + filename;
	}
	Map<String, ImageDescriptor> maps = new HashMap<String, ImageDescriptor>();
	public String getFileName(){
		return fileName;
	}
	public Image getImage(){
		Image result = null;
		try {
			result = new Image(null, DPFPlugin.getDefault().getBundle().getResource(fileName).openStream());
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor result = maps.get(fileName);
		if(result == null){
			result = ImageDescriptor.createFromURL(DPFPlugin.getDefault().getBundle().getResource(fileName));
			maps.put(fileName, result);
		}
		return result;
	}
}
