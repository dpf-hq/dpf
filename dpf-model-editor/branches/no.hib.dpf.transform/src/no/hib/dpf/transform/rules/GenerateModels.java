package no.hib.dpf.transform.rules;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.util.TransformConstants;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;

public class GenerateModels {

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
	
	public GenerateModels(Transform transform){
		this.transform= transform;
		
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();

		createNodes = new HashMap<String, DNode>();

		defaultDSpecification =  DPFConstants.REFLEXIVE_DSPECIFICATION;
		defaultArrow = defaultDSpecification.getDGraph().getDArrows().get(0);
		defaultNode = defaultDSpecification.getDGraph().getDNodes().get(0);
		
		
	}
	public DSpecification generateElementTypeGraph(DSpecification source, DSpecification target){

		DSpecification elementTypeGraph = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		elementTypeGraph.setDType(defaultDSpecification);
		DGraph correspondanceDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		elementTypeGraph.setDGraph(correspondanceDGraph);
		
		DSpecification sourceDSpecification = source;
		DSpecification targetDSpecification = target;
		
		DNode bridgeElement = elementTypeGraph.getDGraph().
				createDNode("Trace", defaultNode);
		

		boolean sourceIsDefault = sourceDSpecification.getDGraph().getDNodes().isEmpty();
		boolean targetIsDefault = targetDSpecification.getDGraph().getDNodes().isEmpty();
		
		if(sourceIsDefault && targetIsDefault){
			DNode dNode = elementTypeGraph.getDGraph().createDNode("Node", defaultNode);
			
			elementTypeGraph.getDGraph().createDArrow("traceSource_Node", bridgeElement, dNode, defaultArrow);
			elementTypeGraph.getDGraph().createDArrow("traceTarget_Node", bridgeElement, dNode, defaultArrow);

			elementTypeGraph.getDGraph().createDArrow("Arrow", dNode, dNode, defaultArrow);
		}
		else{
			if(sourceIsDefault){
				sourceDSpecification = DPFConstants.REFLEXIVE_DSPECIFICATION;
			}
			if(targetIsDefault && !transform.getTargetLocation().isEmpty()){
				targetDSpecification = DPFConstants.REFLEXIVE_DSPECIFICATION;
			}
			
			for(int i = 0;i<sourceDSpecification.getDGraph().getDNodes().size();i++){
				DNode dNode = sourceDSpecification.getDGraph().getDNodes().get(i);
				DNode newNode = elementTypeGraph.getDGraph().createDNode(dNode.getName(), defaultNode);
				createNodes.put("source"+newNode.getName(), newNode);
				elementTypeGraph.getDGraph().createDArrow("traceSource_"+dNode.getName(), bridgeElement, newNode, defaultArrow);
				
			}
			for(int i = 0;i<targetDSpecification.getDGraph().getDNodes().size();i++){
				DNode dNode = targetDSpecification.getDGraph().getDNodes().get(i);
				DNode newNode = elementTypeGraph.getDGraph().createDNode(dNode.getName(), defaultNode);
				createNodes.put("target"+newNode.getName(), newNode);
				elementTypeGraph.getDGraph().createDArrow("traceTarget_"+dNode.getName(), bridgeElement, newNode, defaultArrow);
			}
			for(int i = 0;i<sourceDSpecification.getDGraph().getDArrows().size();i++){
				DArrow dArrow = sourceDSpecification.getDGraph().getDArrows().get(i);
				DNode sourceNode = dArrow.getDSource();
				DNode targetNode = dArrow.getDTarget();
				elementTypeGraph.getDGraph().createDArrow(dArrow.getName(), createNodes.get("source"+sourceNode.getName()), createNodes.get("source"+targetNode.getName()), defaultArrow);
			}
			for(int i = 0;i<targetDSpecification.getDGraph().getDArrows().size();i++){
				DArrow dArrow = targetDSpecification.getDGraph().getDArrows().get(i);
				DNode sourceNode = dArrow.getDSource();
				DNode targetNode = dArrow.getDTarget();
				elementTypeGraph.getDGraph().createDArrow(dArrow.getName(), createNodes.get("target"+sourceNode.getName()), createNodes.get("target"+targetNode.getName()), defaultArrow);
			}
			
		}
		return elementTypeGraph;
	}
	public DSpecification generateCorrespondanceGraph(){
		
		DSpecification correspondanceDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		correspondanceDSpecification.setDType(defaultDSpecification);
		DGraph correspondanceDGraph = DiagramFactory.eINSTANCE.createDefaultDGraph();
		correspondanceDSpecification.setDGraph(correspondanceDGraph);
		
		boolean sourceIsDefault = sourceDSpecification.getDGraph().getDNodes().isEmpty();
		boolean targetIsDefault = targetDSpecification.getDGraph().getDNodes().isEmpty();
		
		DNode bridgeElement = correspondanceDSpecification.getDGraph().
				createDNode("Link", defaultNode);
		
		if(sourceIsDefault && targetIsDefault){
			DNode dNode = correspondanceDSpecification.getDGraph().createDNode("Node", defaultNode);
			DNode dArrow = correspondanceDSpecification.getDGraph().createDNode("Arrow", defaultNode);
			
			correspondanceDSpecification.getDGraph().createDArrow("sourceNode", bridgeElement, dNode, defaultArrow);
			correspondanceDSpecification.getDGraph().createDArrow("sourceArrow", bridgeElement, dArrow, defaultArrow);
			
			correspondanceDSpecification.getDGraph().createDArrow("targetNode", bridgeElement, dNode, defaultArrow);
			correspondanceDSpecification.getDGraph().createDArrow("targetArrow", bridgeElement, dArrow, defaultArrow);
		}
		else{
			
			if(targetIsDefault){
				targetDSpecification = DPFConstants.REFLEXIVE_DSPECIFICATION;
			}
			
			if(sourceIsDefault){
				sourceDSpecification = DPFConstants.REFLEXIVE_DSPECIFICATION;
			}
		
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
		}
		
		
		return correspondanceDSpecification;
	}
}
