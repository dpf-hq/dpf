package no.hib.dpf.visual.util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class VisualUtil {

	public static Visuals loadEObjects(ResourceSetImpl resourceSet2,
			URI createFileURI,
			Map<Resource, Diagnostic> resourceToDiagnosticMap2) {
		Assert.isNotNull(resourceSet2);
		Resource resource = resourceSet2.createResource(createFileURI);
		try {
			resource.load(null);
		} catch (IOException e) {
			DPFErrorReport.logError(e);
		}finally{
			if(resource == null || resource.getContents().size() == 0)
				return VisualFactory.eINSTANCE.createVisuals();
		}
		return (Visuals) resource.getContents().get(0);
	}
	private static Resource getResource(URI modelFileURI){		
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		Resource model = resourceSet.createResource(modelFileURI);
		resourceSet.getURIResourceMap().put(modelFileURI, model);
		return model;
	}
	public static Visuals loadVisuals(URI modelFileURI){
		Resource model = getResource(modelFileURI);
		Assert.isNotNull(model);
		Visuals dsp = null;
		try {
			model.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (model == null || model.getContents().size() == 0) {
				dsp = VisualFactory.eINSTANCE.createVisuals();
				model.getContents().add(dsp);
			}else
				dsp = (Visuals) model.getContents().get(0);
		}
		return dsp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
