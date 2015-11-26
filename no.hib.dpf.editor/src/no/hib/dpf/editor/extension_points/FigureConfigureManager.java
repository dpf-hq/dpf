package no.hib.dpf.editor.extension_points;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class FigureConfigureManager {

	private static final String EXTENSION_POINT_ID = "FigureConfigure";
	private static final String PLUGIN_ID = "no.hib.dpf.editor";
	private static final String ARROWCONFIGURE = "ArrowConfigure";
	private static final String NODECONFIGURE = "NodeConfigure";
	public static final String SMALLICON_ATT = "smallicon";
	public static final String LARGEICON_ATT = "largeicon";
	public static final String PAINT_ATT = "paint";
	public static final String NAME_ATT = "name";


	static Map<String, IConfigurationElement> nodeMap = new HashMap<String, IConfigurationElement>(), arrowMap = new HashMap<String, IConfigurationElement>();
	static String[] nodeNames = null, arrowNames = null;

	static{
		initConfigures();
	}


	public static String getName(IConfigurationElement element){
		return element != null ? element.getAttribute(NAME_ATT) : "";
	}

	public Collection<IConfigurationElement> getNodeConfigurationElements(){
		return nodeMap.values();
	}

	public Collection<IConfigurationElement> getArrowConfigurationElements(){
		return arrowMap.values();
	}

	public static String[] getNodeNames(){
		return getConfigurationNames(true);
	}

	public static String[] getArrowNames(){
		return getConfigurationNames(false);
	}

	private static String[] getConfigurationNames(boolean node){
		String[] names = node ? nodeNames : arrowNames;
		if(names == null){
			Map<String, IConfigurationElement> map = node ? nodeMap : arrowMap;
			Set<String> keys = map.keySet();
			names = new String[keys.size() + 1];
			names[0] = "";
			System.arraycopy(keys.toArray(), 0, names, 1, keys.size());
		}
		return names;
	}

	private static void initConfigures(){
		//get all the extensions for figureconfigure
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID, EXTENSION_POINT_ID) .getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
			for(int j = 0; j < configElements.length; ++j){
				IConfigurationElement current = configElements[j];
				if(current.getName().equals(NODECONFIGURE))
					nodeMap.put(current.getAttribute(NAME_ATT), current);
				else if(current.getName().equals(ARROWCONFIGURE))
					arrowMap.put(current.getAttribute(NAME_ATT), current);
			}
		}
	}
	private static Map<String, ImageDescriptor> imageDesMap = new HashMap<String, ImageDescriptor>();

	private static Map<String, Image> imageMaps = new HashMap<String, Image>();;
	
	private static ImageDescriptor getImageDescriptor(IConfigurationElement configElement, String att) {
		if(configElement == null) return null;
		String iconName = configElement.getAttribute(att);
		if (iconName == null)
			return null;
		ImageDescriptor imageDescriptor = imageDesMap.get(iconName);
		if(imageDescriptor != null)
			return imageDescriptor;
		IExtension extension = configElement.getDeclaringExtension();
		String extendingPluginId = extension.getNamespaceIdentifier();
		imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(extendingPluginId, iconName);
		imageDesMap.put(iconName, imageDescriptor);
		return imageDescriptor;
	}

	public static IConfigurationElement getConfigurationElement(String name) {
		if(name == null || name.isEmpty())
			return null;
		if(nodeMap.containsKey(name))
			return nodeMap.get(name);
		if(arrowMap.containsKey(name))
			return arrowMap.get(name);
		return null;
	}

	public static ImageDescriptor getSmallIcon(IConfigurationElement configElement) {
		return getImageDescriptor(configElement, SMALLICON_ATT);
	}

	public static ImageDescriptor getLargeIcon(IConfigurationElement configElement) {
		return getImageDescriptor(configElement, LARGEICON_ATT);
	}

	public static Image getIcon(String name) {
		Image result = imageMaps.get(name);
		if(result != null) return result;
		ImageDescriptor descriptor = getImageDescriptor(getConfigurationElement(name), SMALLICON_ATT);
		if(descriptor != null){
			result = descriptor.createImage();
			result = new Image(result.getDevice(), result.getImageData().scaledTo(result.getBounds().width/2, result.getBounds().height/2));
			imageMaps.put(name, result);
		}
		return result;
	}
}
