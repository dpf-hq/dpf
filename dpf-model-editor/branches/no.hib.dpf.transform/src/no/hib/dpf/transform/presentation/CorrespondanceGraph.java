package no.hib.dpf.transform.presentation;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformActivePage;
import no.hib.dpf.transform.util.TransformConstants;

public class CorrespondanceGraph {

	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	private DSpecification defaultDSpecification = null;
	private DSpecification sourceDSpecification = null;
	private DSpecification targetDSpecification = null;
	
	private DGraph defaultDGraph = null;
	private DNode defaultNode = null;
	private DArrow defaultArrow = null;
	
	private Transform transform = null;
	
	public CorrespondanceGraph(){
		String transformFile = TransformActivePage.activeWindowFileLocation();
		transform = TransformEditor.loadTransform(DPFUtils.getResourceSet(), URI.createFileURI(transformFile), resourceToDiagnosticMap);

		defaultDSpecification =  DPFConstants.REFLEXIVE_DSPECIFICATION;
		
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();
	}
	public DSpecification getCorrespondanceDSpecification(){
		DSpecification defaultDSpec = DiagramFactory.eINSTANCE.createConstantDSpecification();
		defaultDSpec.setDType(defaultDSpecification);
		
		DSpecification correspondanceDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		correspondanceDSpecification.setDType(defaultDSpecification);
		DGraph correspondanceDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		correspondanceDSpecification.setDGraph(correspondanceDGraph);
		
		defaultArrow = defaultDSpec.getDGraph().getDArrows().get(0);
		defaultNode = defaultDSpec.getDGraph().getDNodes().get(0);
		
		System.out.println("Target" + targetDSpecification.eResource().getURI());
		
		DNode bridgeElement = correspondanceDSpecification.getDGraph().createDNode("BridgeElement", defaultNode);
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = sourceDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			correspondanceDSpecification.getDGraph().createDArrow("source"+dNode.getName(), bridgeElement, newNode, defaultArrow);
		}
		for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dArrow.getName(), defaultNode);
			correspondanceDSpecification.getDGraph().createDArrow("source"+dArrow.getName(), bridgeElement, newNode, defaultArrow);
		}
		for(int i = 0;i<targetDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = targetDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			correspondanceDSpecification.getDGraph().createDArrow("target"+dNode.getName(), bridgeElement, newNode, defaultArrow);
		}

		for(int i = 0;i<targetDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dArrow.getName(), defaultNode);
			correspondanceDSpecification.getDGraph().createDArrow("source"+dArrow.getName(), bridgeElement, newNode, defaultArrow);
		}
		return correspondanceDSpecification;
	}
}
