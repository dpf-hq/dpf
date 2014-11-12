package no.hib.dpf.visual;

import java.io.IOException;
import java.util.Map;

import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class VisualUtils extends DPFModelPersistanceUtils {

	
	public static Visuals loadVisuals(ResourceSetImpl resourceSet,
			URI diagramURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource model = createResource(resourceSet, diagramURI, resourceToDiagnosticMap);
		Visuals dsp = null;
		try {
			model.load(null);
		} catch (Exception e) {
			logError(e);
			analyzeResourceProblems(model, e, resourceToDiagnosticMap);
		} finally {
			if (model == null || model.getContents().size() == 0) {
				dsp = VisualFactory.eINSTANCE.createVisuals();
				model.getContents().add(dsp);
			}else{
				dsp = (Visuals) model.getContents().get(0);
			}
		}
		return dsp;
	}

	public static void saveVisuals(ResourceSetImpl resourceSet, URI osString, Visuals visuals, 
			Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource resource = createResource(resourceSet, osString, resourceToDiagnosticMap);
		resourceSet.getURIResourceMap().put(osString, resource);
		resource.getContents().add(visuals);
		try {
			resource.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(resource, e, resourceToDiagnosticMap);
		}
	}

}
