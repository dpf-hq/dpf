package no.hib.mums.shared;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class ImageProvider extends AbstractImageProvider{

	protected static final String IMG_PREFIX = "no.hib.mums.shared.";
	
	public static final String ARROW_REFERENCE = IMG_PREFIX + "arrow_reference";
	
	public static final String ADD_ATTRIBUTE = IMG_PREFIX + "add";
	
	public static final String PROPULSOR = IMG_PREFIX + "prop";
	@Override
	protected void addAvailableImages() {
		addImageFilePath(ARROW_REFERENCE, "icons/reference.gif");
		addImageFilePath(ADD_ATTRIBUTE, "icons/add.gif");
		addImageFilePath(PROPULSOR, "icons/propeller.gif");
	}

}
