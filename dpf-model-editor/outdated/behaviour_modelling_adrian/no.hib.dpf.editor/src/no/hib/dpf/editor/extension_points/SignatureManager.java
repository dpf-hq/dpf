package no.hib.dpf.editor.extension_points;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.utils.DPFConstants;

public class SignatureManager {
	public static final String EXTENSION_POINT_ID = "Signature";
	public static final String PLUGIN_ID = "no.hib.dpf.editor";
	public static final String NAME_ATT = "name";
	public static final String SIMPLENAME_ATT = "simpleName";
	public static final String NODES_ATT = "nodes";
	public static final String ARROWS_ATT = "arrows";
	public static final String ICON_ATT = "actionIcon";
	public static final String CHECKER_ATT = "checker";
	public static final String EDITPART_ATT = "editpart";
	private static Map<String, DSignature> dSignatures = null; //
	static Map<Predicate, IConfigurationElement> predicateToEditPartMaps = null;
	
	public static Map<String, DSignature> getSignatures(){
		if(dSignatures == null){
			dSignatures = new HashMap<String, DSignature>();
			initSignatures();
		}
		return dSignatures;
	}
	

	private static void initSignatures() {
		//get all the extensions for figureconfigure
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID, EXTENSION_POINT_ID) .getExtensions();
		for (int i = 0; i < extensions.length; i++) 
			dSignatures.put(extensions[i].getUniqueIdentifier(), getDSignature(extensions[i].getConfigurationElements()));
	}

	private static DSignature getDSignature( IConfigurationElement[] configElements) {
		DSignature result = DiagramFactory.eINSTANCE.createDSignature();
		for(int j = 0; j < configElements.length; ++j)
			updateDSignature(result, configElements[j]);
		return result;
	}
	
	private static ImageDescriptor getImageDescriptor(IConfigurationElement configElement) {
		String iconName = configElement.getAttribute(ICON_ATT);
		if (iconName == null)
			return null;
		IExtension extension = configElement.getDeclaringExtension();
		String extendingPluginId = extension.getNamespaceIdentifier();
		ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(extendingPluginId, iconName);
		return imageDescriptor;
	}

	private static void initPredicate(Predicate predicate, String name, String nodes, String arrows) {
		predicate.setSymbol(name);
		Graph graph = CoreFactory.eINSTANCE.createGraph(name, nodes, arrows);
		graph.setType(DPFConstants.REFLEXIVE_TYPE_GRAPH);
		predicate.setShape(graph);
	}
	
	private static void updateDSignature(DSignature result, IConfigurationElement iConfigurationElement) {
		DPredicate dPredicate = DiagramFactory.eINSTANCE.createDPredicate();
		dPredicate.setSimpleName(iConfigurationElement.getAttribute(SIMPLENAME_ATT));
		dPredicate.setIcon(iConfigurationElement.getAttribute(ICON_ATT));
		String nodes = iConfigurationElement.getAttribute(NODES_ATT);
		String arrows = iConfigurationElement.getAttribute(ARROWS_ATT);
		/*
		 * TODO validate nodes and arrows
		 */
		Predicate predicate = CoreFactory.eINSTANCE.createPredicate();
		initPredicate(predicate, iConfigurationElement.getAttribute(NAME_ATT), nodes, arrows);
		dPredicate.setPredicate(predicate);
		try {
			predicate.setValidator((SemanticValidator) iConfigurationElement.createExecutableExtension(CHECKER_ATT));
		} catch (CoreException e) {
			DPFErrorReport.logError(e);
		}
		result.getDPredicates().add(dPredicate);
		result.getSignature().getPredicates().add(dPredicate.getPredicate());
		getDPredicateToEditPartMap().put(predicate, iConfigurationElement);
	}

	public static Map<Predicate, IConfigurationElement> getDPredicateToEditPartMap() {
		if(predicateToEditPartMaps == null)
			predicateToEditPartMaps = new HashMap<Predicate, IConfigurationElement>();
		return predicateToEditPartMaps;
	}


	public static EditPart createEditPart(Predicate predicate) {
		try {
			return (EditPart) getDPredicateToEditPartMap().get(predicate).createExecutableExtension(EDITPART_ATT);
		} catch (CoreException e) {
			DPFErrorReport.logError(e);
		}
		return null;
	}

	public static String getActionID(DPredicate dPredicate) {
		return "no.hib.dpf.editor.editoractions.Create" + dPredicate.getPredicate().getSymbol() + "Action";
	}

	public static ImageDescriptor getImageDescriptor(Predicate predicate) {
		return getImageDescriptor(getDPredicateToEditPartMap().get(predicate));
	}


}
