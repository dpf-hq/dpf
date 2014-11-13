package no.hib.dpf.editor.signature;

import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.utils.DPFConstants.DefaultDSpecification;
import static no.hib.dpf.utils.DPFConstants.DefaultSpecification;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_SPECIFICATION;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.editor.DPFUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class SignatureUtils extends DPFUtils{

	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dpf", new XMLResourceFactoryImpl());
		Resource dGraph = resourceSet.createResource(DefaultDSpecification);
		dGraph.getContents().add(REFLEXIVE_DSPECIFICATION);
		resourceSet.getURIResourceMap().put(DefaultDSpecification, dGraph);
		Resource graph = resourceSet.createResource(DefaultSpecification);
		graph.getContents().add(REFLEXIVE_SPECIFICATION);
		resourceSet.getURIResourceMap().put(DefaultSpecification, graph);
		return resourceSet;
	}
	
	public static void saveDSignature(ResourceSetImpl resourceSet, URI osString, DSignature signature2, 
			Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource signature = createResource(resourceSet, osString, resourceToDiagnosticMap);
		signature.getContents().add(signature2);
		signature.getContents().add(signature2.getSignature());
		try {
			signature.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(signature, e, resourceToDiagnosticMap);
		}
	}
	public static AbstractUIPlugin getPlugin() {
		return SignaturePlugin.getDefault();
	}

	public static String getPluginID() {
		return SignaturePlugin.PLUGIN_ID;
	}
	
}
