package no.hib.dpf.visual.util;

import java.io.IOException;
import java.util.Map;

import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

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
		}
		if(resource.getContents().size() == 0)
			return VisualFactory.eINSTANCE.createVisuals();
		return (Visuals) resource.getContents().get(0);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
