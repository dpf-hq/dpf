package no.hib.dpf.editor.icons;

import java.io.File;

public enum ImageSettings {
	SMALL_RECTANGLE("rectangle32.png"),
	LARGE_RECTANGLE("rectangle48.png"),
	SMALL_CONNECTION("connection_s16.gif"),
	LARGE_CONNECTION("connection_s24.gif"),
	MULTIPLICITY("mult_36.png"),
	INVERSE("inv_36.png"),
	JOINTLY_INJECTIVE("ji_36.png"),
	JOINTLY_SURJECTIVE("js_36.png"),
	IMAGE_INCLUSION("img_incl_36.png"),
	COMPOSITION("ji_36.png"),
	INJECTIVE("ji_36.png"),
	IRREFLEXIVE("ji_36.png"),
	SURJECTIVE("ji_36.png");
	
	private String filePath;
	
	ImageSettings(String filename) {
		String directoryPrefix = "icons" + File.separatorChar;
		filePath = directoryPrefix + filename;
	}
	
	public String getFilePath() {
		return filePath;
	}
}
