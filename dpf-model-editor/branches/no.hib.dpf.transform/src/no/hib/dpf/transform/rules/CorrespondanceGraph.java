package no.hib.dpf.transform.rules;

import java.util.HashMap;
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
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.util.TransformUtils;
import no.hib.dpf.transform.util.TransformConstants;

public class CorrespondanceGraph {

	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	private DSpecification defaultDSpecification = null;
	private DSpecification sourceDSpecification = null;
	private DSpecification targetDSpecification = null;
	
	private HashMap<String, DNode> createNodes = null;
	
	private String sourceModel = null;
	private String targetModel = null;
	
	private DGraph defaultDGraph = null;
	private DNode defaultNode = null;
	private DArrow defaultArrow = null;
	
	private Transform transform = null;
	
	public CorrespondanceGraph(Transform transform){
		this.transform= transform;
		
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();
		
		
		
		createNodes = new HashMap<String, DNode>();

		defaultDSpecification =  DPFConstants.REFLEXIVE_DSPECIFICATION;
		defaultArrow = defaultDSpecification.getDGraph().getDArrows().get(0);
		defaultNode = defaultDSpecification.getDGraph().getDNodes().get(0);
		
		
	}
	public DSpecification getCommonGraph(DSpecification source, DSpecification target){
//		DSpecification defaultDSpec = DiagramFactory.eINSTANCE.createConstantDSpecification();
//		defaultDSpec.setDType(defaultDSpecification);
		
		DSpecification correspondanceDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		correspondanceDSpecification.setDType(defaultDSpecification);
		DGraph correspondanceDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		correspondanceDSpecification.setDGraph(correspondanceDGraph);
		
		DSpecification sourceDSpecification = source;
		DSpecification targetDSpecification = target;
		
//		defaultArrow = defaultDSpec.getDGraph().getDArrows().get(0);
//		defaultNode = defaultDSpec.getDGraph().getDNodes().get(0);
		
		sourceModel = TransformUtils.getDSpecificationFileName(transform.getSourceLocation());
		if(targetDSpecification.getDType() != DPFConstants.REFLEXIVE_DSPECIFICATION){
			targetModel = TransformUtils.getDSpecificationFileName(transform.getTargetLocation());
		}
		else{
			targetModel = "default";
		}
		
		
		DNode bridgeElement = correspondanceDSpecification.getDGraph().
				createDNode("Trace", defaultNode);
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = sourceDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			createNodes.put("source"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("traceSource_"+dNode.getName(), bridgeElement, newNode, defaultArrow);
			
		}
		for(int i = 0;i<targetDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = targetDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			createNodes.put("target"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("traceTarget_"+dNode.getName(), bridgeElement, newNode, defaultArrow);
		}
		for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode sourceNode = dArrow.getDSource();
			DNode targetNode = dArrow.getDTarget();
			correspondanceDSpecification.getDGraph().createDArrow(dArrow.getName(), createNodes.get("source"+sourceNode.getName()), createNodes.get("source"+targetNode.getName()), defaultArrow);
		}
		for(int i = 0;i<targetDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = targetDSpecification.getDGraph().getDArrows().get(i);
			DNode sourceNode = dArrow.getDSource();
			DNode targetNode = dArrow.getDTarget();
			correspondanceDSpecification.getDGraph().createDArrow(dArrow.getName(), createNodes.get("target"+sourceNode.getName()), createNodes.get("target"+targetNode.getName()), defaultArrow);
		}
		
		return correspondanceDSpecification;
	}
	public DSpecification createCorrespondanceGraph(){
		
		DSpecification correspondanceDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		correspondanceDSpecification.setDType(defaultDSpecification);
		DGraph correspondanceDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		correspondanceDSpecification.setDGraph(correspondanceDGraph);
		
		if(targetDSpecification.getDGraph().getDNodes().isEmpty()){
			DSpecification temp = targetDSpecification.getDType();
			targetDSpecification = temp;
		}
		
		DNode bridgeElement = correspondanceDSpecification.getDGraph().
				createDNode("Link", defaultNode);
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = sourceDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			createNodes.put("source"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("source"+dNode.getName(), bridgeElement, newNode, defaultArrow);
			
		}
		
		for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dArrow.getName(), defaultNode);
			createNodes.put("source"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("source"+dArrow.getName(), bridgeElement, newNode, defaultArrow);
		}
		
		for(int i = 0;i<targetDSpecification.getDGraph().getDNodes().size();i++){
			DNode dNode = targetDSpecification.getDGraph().getDNodes().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dNode.getName(), defaultNode);
			createNodes.put("target"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("target"+dNode.getName(), bridgeElement, newNode, defaultArrow);
		}
		
		for(int i = 0;i<targetDSpecification.getDGraph().getDArrows().size();i++){
			DArrow dArrow = targetDSpecification.getDGraph().getDArrows().get(i);
			DNode newNode = correspondanceDSpecification.getDGraph().createDNode(dArrow.getName(), defaultNode);
			createNodes.put("target"+newNode.getName(), newNode);
			correspondanceDSpecification.getDGraph().createDArrow("target"+dArrow.getName(), bridgeElement, newNode, defaultArrow);
		}
		return correspondanceDSpecification;
	}
}
