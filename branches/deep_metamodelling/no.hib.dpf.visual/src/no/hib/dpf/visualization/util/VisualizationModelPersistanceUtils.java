package no.hib.dpf.visualization.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFDiagramConstants;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.visual.VisualPlugin;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class VisualizationModelPersistanceUtils extends DPFModelPersistanceUtils {
	
	public static void saveVisualizations(ResourceSetImpl resourceSet, Visualizations visualizations,
			URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		
		// finalize the metamodel
		DSpecification newDSpec = visualizations.getInstance();
		DPFTemplateUtils.replicateTemplateElements(newDSpec.getDGraph());
		
		Resource visual = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		visual.getContents().add(visualizations);
		
		URI diagramFileURI = getDiagramURI(createFileURI);
		Resource diagram = createResource(resourceSet, diagramFileURI, resourceToDiagnosticMap);
		diagram.getContents().add(newDSpec);

		URI modelFileURI = getModelURI(createFileURI);
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		model.getContents().add(newDSpec.getSpecification());
		
		DSpecification currentDSpec = newDSpec;
		while (currentDSpec != DPFDiagramConstants.REFLEXIVE_DSPECIFICATION) {
			diagram.getContents().add(currentDSpec);
			model.getContents().add(currentDSpec.getSpecification());
		
			if(currentDSpec.getDSignature() != null && currentDSpec.getDSignature() != DPFDiagramConstants.DEFAULT_DSIGNATURE){
				diagram.getContents().add(currentDSpec.getDSignature());
				model.getContents().add(currentDSpec.getSpecification().getSignature());
			}
			
			if(currentDSpec.getDSignature() != null && currentDSpec.getDSignature() != DPFDiagramConstants.DEFAULT_DSIGNATURE){
				diagram.getContents().add(currentDSpec.getDSignature());
				model.getContents().add(currentDSpec.getSpecification().getSignature());
			}
			
			currentDSpec = currentDSpec.getDType();
		}
		 

		try {
			visual.save(null);
			diagram.save(null);
			model.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
			logError(e);
		}
	}
	
	@SuppressWarnings("finally")
	public static Visualizations loadVisualizations(ResourceSet resourceSet, URI savaFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
	
		Resource visual = createResource(resourceSet, savaFileURI, resourceToDiagnosticMap);
		try {
			visual.load(null);
		} catch (Exception e) {
			logError(e);
			analyzeResourceProblems(visual, e, resourceToDiagnosticMap);
		} finally {
			Visualizations dsp = (Visualizations) visual.getContents().get(0);
			VCompartmentUtils.addCompartments(dsp);
			
			return dsp;
		}
	}
	
	public static Visualizations loadVisualizations(URI createFileURI) {
		return loadVisualizations(getResourceSet(), createFileURI, new HashMap<Resource, Diagnostic>());
	}

	/*
	 * Get Model URI from Diagam URI
	 */
	public static URI getModelURI(URI diagramURI) {
		return diagramURI.trimFileExtension().appendFileExtension("xmi");
	}
	
	
	public static URI getDiagramURI(URI diagramURI) {
		return diagramURI.trimFileExtension().appendFileExtension("dpf");
	}
	
	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = DPFModelPersistanceUtils.getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap() .put("visualization", new XMIResourceFactoryImpl());
		return resourceSet;
	}

	public static AbstractUIPlugin getPlugin() {
		return VisualPlugin.getPlugin();
	}

	public static String getPluginID() {
		return VisualPlugin.getDefault().getSymbolicName();
	}
}
