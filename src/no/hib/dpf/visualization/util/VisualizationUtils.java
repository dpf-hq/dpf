package no.hib.dpf.visualization.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualPlugin;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class VisualizationUtils extends DPFUtils {
	
	public static void saveVisualizations(ResourceSetImpl resourceSet, Visualizations visualizations,
			URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		URI diagramFileURI = getDiagramURI(createFileURI);
		URI modelFileURI = getModelURI(diagramFileURI);
		Resource visual = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		visual.getContents().add(visualizations);
		DSpecification newSpec = visualizations.getInstance();
		Resource diagram = createResource(resourceSet, diagramFileURI, resourceToDiagnosticMap);
		diagram.getContents().add(newSpec);
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		model.getContents().add(newSpec.getSpecification());
		if(newSpec.getDType() != DPFConstants.REFLEXIVE_DSPECIFICATION){
			diagram.getContents().add(newSpec.getDType());
			model.getContents().add(newSpec.getDType().getSpecification());
		}
		if(newSpec.getDSignature() != null && newSpec.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE){
			diagram.getContents().add(newSpec.getDSignature());
			model.getContents().add(newSpec.getSpecification().getSignature());
		}
		try {
			model.save(null);
			diagram.save(null);
			visual.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
			logError(e);
		}
	}
	
	@SuppressWarnings("finally")
	public static Visualizations loadVisualizations(ResourceSet resourceSet,
			URI savaFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		URI diagramFileURI = getDiagramURI(savaFileURI);
		URI modelFileURI = getModelURI(diagramFileURI);
		Resource visual = createResource(resourceSet, savaFileURI, resourceToDiagnosticMap);
		createResource(resourceSet, diagramFileURI, resourceToDiagnosticMap);
		createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		try {
			visual.load(null);
		} catch (Exception e) {
			logError(e);
			analyzeResourceProblems(visual, e, resourceToDiagnosticMap);
		} finally {
			if (visual.getContents().size() == 0) {
				//TODO fix this later
//				DSpecification result = DiagramFactory.eINSTANCE .createDefaultDSpecification();
//				diagram.getContents().add(result);
//				model.getContents().add(result.getSpecification());
				return null;
			}
			Visualizations dsp = (Visualizations) visual.getContents().get(0);
			
			for(DNode dNode : dsp.getInstance().getDGraph().getDNodes()){
				Node typeNode = dNode.getNode().getTypeNode();
				VElement element = dsp.getEntries().get(typeNode);
				if(element instanceof VNode){
					VNode vNode = (VNode) element;
					if(vNode.isComposite()) {
						// Add compartments to composite nodes
						for(Arrow arrow : typeNode.getOutgoings()) {
							if(dsp.getEntries().containsKey(arrow) && ((VArrow) dsp.getEntries().get(arrow)).isComposed()) {
								VCompartment vCompartment = VisualizationFactory.eINSTANCE.createVCompartment();
								vCompartment.setName(arrow.getTarget().getName());
								vCompartment.setParent(dNode);
								dsp.getCompartments().add(vCompartment);
							}
						}
						// Add compartmentElements to compartments if any are saved
						for(DArrow dArrow : dNode.getDOutgoings()){
							Arrow arrow = dArrow.getArrow();
							if(dsp.getEntries().containsKey(arrow.getTypeArrow()) && ((VArrow) dsp.getEntries().get(arrow.getTypeArrow())).isComposed()) {
								VCompartmentElement compElement = VisualizationFactory.eINSTANCE.createVCompartmentElement();
								compElement.setDNode(dArrow.getDTarget());
								for(VCompartment compartment : dsp.getCompartments()) {
									if(compartment.getParent() == dNode && compartment.getName().equals(compElement.getDNode().getNode().getTypeNode().getName()))
										compartment.addChild(compElement);
								}
							}
						}
					}
				}
			}
			
			
			return dsp;
		}
	}
	public static Visualizations loadVisualizations(URI createFileURI) {
		return loadVisualizations(getResourceSet(), createFileURI, new HashMap<Resource, Diagnostic>());
	}
	
	public static DSignature loadDSignature(ResourceSetImpl resourceSet, URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource signature = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		try {
			signature.load(null);
		} catch (IOException e) {
			logError(e);
			analyzeResourceProblems(signature, e, resourceToDiagnosticMap);
		}
		int size = signature.getContents().size();
		return size == 2 ? (DSignature) signature.getContents().get(0) : null;
	}
	
	/*
	 * Get Model file name from Diagram file name
	 */
	public static String getModelFromDiagram(String filename) {
		int index = filename.lastIndexOf(DEFAULT_DIAGRAM_MODEL_EXTENSION);
		if(index == -1)
			return filename + DEFAULT_MODEL_EXTENSION;
		return filename.substring(0, index) + DEFAULT_MODEL_EXTENSION;
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
	/*
	 * Get Diagram file name from Model file name
	 */
	public static String getDiagramFromModel(String filename) {
		int index = filename.lastIndexOf(DEFAULT_MODEL_EXTENSION);
		if(index == -1)
			return filename + DEFAULT_DIAGRAM_MODEL_EXTENSION;
		return filename.substring(0, index) + DEFAULT_DIAGRAM_MODEL_EXTENSION;
	}
	public static final String DEFAULT_DIAGRAM_MODEL_EXTENSION = ".dpf";
	public static final String DEFAULT_MODEL_EXTENSION = ".xmi";
	public static DSignature loadDSignature(URI createFileURI) {
		return loadDSignature(new ResourceSetImpl(), createFileURI, new HashMap<Resource, Diagnostic>());
	}

	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
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
