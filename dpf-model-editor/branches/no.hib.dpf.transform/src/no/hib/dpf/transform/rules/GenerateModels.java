package no.hib.dpf.transform.rules;

import java.util.HashMap;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import static no.hib.dpf.diagram.util.DPFConstants.*;
import no.hib.dpf.transform.Transform;

public class GenerateModels {


	private DSpecification sourceDSpecification = null;
	private DSpecification targetDSpecification = null;
	
	private HashMap<String, DNode> createNodes = null;
	
	
	public static final String SOURCE_PREFIX = "source";
	public static final String TARGET_PREFIX = "target";
	public static final String SOURCE_TRACE = "tracesource_";
	public static final String TARGET_TRACE = "tracetarget_";
	public static final String TRACE_SOURCE_ARROW = "traceSource_Node";
	public static final String TRACE_TARGET_ARROW = "traceTarget_Node";
	
	public static final int startx = 10, starty = 10, sizew = 100, sizeh = 50, leftspan = 50, rightspan = 50;
	public GenerateModels(Transform transform){
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();
		createNodes = new HashMap<String, DNode>();
	}
	public DSpecification generateElementTypeGraph(){
		DSpecification elementTypeGraph = DiagramFactory.eINSTANCE.createDefaultDSpecification();

		boolean sourceIsDefault = sourceDSpecification == REFLEXIVE_DSPECIFICATION;
		boolean targetIsDefault = targetDSpecification == REFLEXIVE_DSPECIFICATION;  
		
		DGraph graph = elementTypeGraph.getDGraph();
		DNode bridgeElement = graph.createDNode("Trace", REFLEXIVE_TYPE_DNODE);
		bridgeElement.setSize(new Dimension(sizew, sizeh));
		int x = startx;
		int y = starty;
		if(sourceIsDefault && targetIsDefault){
			DNode node = graph.createDNode("Node", REFLEXIVE_TYPE_DNODE);
			node.setLocation(new Point(x, y));
			node.setSize(new Dimension(sizew, sizeh));
			x = x + sizew + leftspan;
			bridgeElement.setLocation(new Point(x, y));
			graph.createDArrow(TRACE_SOURCE_ARROW, bridgeElement, node, REFLEXIVE_TYPE_DARROW);
			graph.createDArrow(TRACE_TARGET_ARROW, bridgeElement, node, REFLEXIVE_TYPE_DARROW);
			return elementTypeGraph;
		}
		DNode theNode = null;
		if(sourceIsDefault){
			DNode node = graph.createDNode("Node", REFLEXIVE_TYPE_DNODE);
			theNode = node;
			node.setLocation(new Point(x, y));
			node.setSize(new Dimension(sizew, sizeh));
			x = x + sizew + leftspan;
			bridgeElement.setLocation(new Point(x, y));
			graph.createDArrow(TRACE_SOURCE_ARROW, bridgeElement, node, REFLEXIVE_TYPE_DARROW);
			x = x + sizew + rightspan;
		}
		else{
			Point current = null;
			Dimension size = null;
			for(DNode dNode : sourceDSpecification.getDGraph().getDNodes()){
				DNode newNode = graph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				current = dNode.getLocation();
				newNode.setLocation(new Point(current));
				size = dNode.getSize();
				newNode.setSize(new Dimension(size));
				if(x < current.x + size.width) x = current.x + size.width;
				if(y < current.y + size.height) y = current.y + size.height;
				createNodes.put(SOURCE_PREFIX + newNode.getName(), newNode);
				graph.createDArrow(SOURCE_TRACE + dNode.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : sourceDSpecification.getDGraph().getDArrows()){
				DNode sourceNode = dArrow.getDSource();
				DNode targetNode = dArrow.getDTarget();
				graph.createDArrow(dArrow.getName(), createNodes.get(SOURCE_PREFIX + sourceNode.getName()), createNodes.get(SOURCE_PREFIX + targetNode.getName()), REFLEXIVE_TYPE_DARROW);
			}
		}
		x = x + leftspan;
		y = y / 2;
		bridgeElement.setLocation(new Point(x, y));
		x = x + sizew + rightspan;
		if(targetIsDefault){
			DNode node = graph.createDNode("Node", REFLEXIVE_TYPE_DNODE);
			node.setLocation(new Point(x, y));
			node.setSize(new Dimension(sizew, sizeh));
			graph.createDArrow(TRACE_TARGET_ARROW, bridgeElement, node, REFLEXIVE_TYPE_DARROW);
		}
		else if(sourceDSpecification != targetDSpecification){
			int mid = y;
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				DNode newNode = graph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				newNode.setLocation(new Point(x + dNode.getLocation().x, dNode.getLocation().y));
				newNode.setSize(new Dimension(dNode.getSize()));
				if(mid < dNode.getLocation().y) mid = dNode.getLocation().y;
				createNodes.put(TARGET_PREFIX + newNode.getName(), newNode);
				graph.createDArrow(TARGET_TRACE + dNode.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : targetDSpecification.getDGraph().getDArrows()){
				DNode sourceNode = dArrow.getDSource();
				DNode targetNode = dArrow.getDTarget();
				graph.createDArrow(dArrow.getName(), createNodes.get(TARGET_PREFIX + sourceNode.getName()), createNodes.get(TARGET_PREFIX + targetNode.getName()), REFLEXIVE_TYPE_DARROW);
			}
			mid = mid / 2;
			if(sourceIsDefault)
				theNode.setLocation(new Point(theNode.getLocation().x, mid));
			bridgeElement.setLocation(new Point(bridgeElement.getLocation().x, mid));
		}else{
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				graph.createDArrow(TARGET_TRACE + dNode.getName(), bridgeElement, createNodes.get(SOURCE_PREFIX + dNode.getName()), REFLEXIVE_TYPE_DARROW);
			}
		}
		return elementTypeGraph;
	}
	public DSpecification generateCorrespondanceGraph(){
		
		DSpecification correspondanceDSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		
		boolean sourceIsDefault = sourceDSpecification != REFLEXIVE_DSPECIFICATION;
		boolean targetIsDefault = targetDSpecification != REFLEXIVE_DSPECIFICATION;
		
		DGraph dGraph = correspondanceDSpecification.getDGraph();
		DNode bridgeElement = dGraph.createDNode("Link", REFLEXIVE_TYPE_DNODE);
		
		if(sourceIsDefault && targetIsDefault){
			DNode dNode = dGraph.createDNode("Node", REFLEXIVE_TYPE_DNODE);
			DNode dArrow = dGraph.createDNode("Arrow", REFLEXIVE_TYPE_DNODE);
			
			dGraph.createDArrow("sourceNode", bridgeElement, dNode, REFLEXIVE_TYPE_DARROW);
			dGraph.createDArrow("sourceArrow", bridgeElement, dArrow, REFLEXIVE_TYPE_DARROW);
			
			dGraph.createDArrow("targetNode", bridgeElement, dNode, REFLEXIVE_TYPE_DARROW);
			dGraph.createDArrow("targetArrow", bridgeElement, dArrow, REFLEXIVE_TYPE_DARROW);
		}
		else{
			for(DNode dNode : sourceDSpecification.getDGraph().getDNodes()){
				DNode newNode = dGraph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				createNodes.put(SOURCE_PREFIX + newNode.getName(), newNode);
				dGraph.createDArrow(SOURCE_PREFIX + dNode.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
			
			for(DArrow dArrow : sourceDSpecification.getDGraph().getDArrows()){
				DNode newNode = dGraph.createDNode(dArrow.getName(), REFLEXIVE_TYPE_DNODE);
				createNodes.put(SOURCE_PREFIX + newNode.getName(), newNode);
				dGraph.createDArrow(SOURCE_PREFIX + dArrow.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
			
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				DNode newNode = dGraph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				createNodes.put(TARGET_PREFIX + newNode.getName(), newNode);
				dGraph.createDArrow(TARGET_PREFIX + dNode.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
			
			for(DArrow dArrow : targetDSpecification.getDGraph().getDArrows()){
				DNode newNode = dGraph.createDNode(dArrow.getName(), REFLEXIVE_TYPE_DNODE);
				createNodes.put(TARGET_PREFIX+newNode.getName(), newNode);
				dGraph.createDArrow(TARGET_PREFIX+dArrow.getName(), bridgeElement, newNode, REFLEXIVE_TYPE_DARROW);
			}
		}
		return correspondanceDSpecification;
	}
}
