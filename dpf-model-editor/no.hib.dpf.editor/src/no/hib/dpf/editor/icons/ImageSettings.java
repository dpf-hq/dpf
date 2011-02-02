package no.hib.dpf.editor.icons;

import java.io.File;

public enum ImageSettings {
	SMALL_RECTANGLE("rectangle32.png"),
	LARGE_RECTANGLE("rectangle48.png"),
	SMALL_CONNECTION("connection_s16.gif"),
	LARGE_CONNECTION("connection_s24.gif");
	
	private String filePath;
	
	ImageSettings(String filename) {
		String directoryPrefix = "icons" + File.separatorChar;
		filePath = directoryPrefix + filename;
	}
	
	public String getFilePath() {
		return filePath;
	}
}
