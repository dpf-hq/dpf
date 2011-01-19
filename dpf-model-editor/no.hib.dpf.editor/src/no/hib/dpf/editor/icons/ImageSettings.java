package no.hib.dpf.editor.icons;

import java.io.File;

public class ImageSettings {

	public static final int SMALL_RECTANGLE = 0;
	public static final int LARGE_RECTANGLE = 1;
	public static final int SMALL_CONNECTION = 2;
	public static final int LARGE_CONNECTION = 3;
	
	private static String directoryPrefix = "icons" + File.separatorChar;
	
	private static ImageSettings singleton = new ImageSettings();
	
	public static ImageSettings getImageSettings() {
		return singleton;
	}
	
	public String getFilePath(int fileKey) {
		switch (fileKey) {
			case SMALL_RECTANGLE: return directoryPrefix + "rectangle32.png";
			case LARGE_RECTANGLE: return directoryPrefix + "rectangle48.png";
			case SMALL_CONNECTION: return directoryPrefix + "connection_s16.gif";
			case LARGE_CONNECTION: return directoryPrefix + "connection_s24.gif";
		}
		
		return "";
	}
	
	
}
