package no.hib.dpf.transform.rules;

import java.util.HashMap;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import static no.hib.dpf.diagram.util.DPFConstants.*;
import no.hib.dpf.transform.Transform;

public class GenerateModels {


	private DSpecification sourceDSpecification = null;
	private DSpecification targetDSpecification = null;

	private HashMap<DElement, DNode> createNodes = null;

	public static final String NODE = "Node";
	public static final String ARROW = "Arrow";
	public static final String TRACE = "Trace";
	public static final String LINK = "Link";
	public static final String SOURCE = "source";
	public static final String TARGET = "target";

	public static final int startx = 10, starty = 10, sizew = 100, sizeh = 50, leftspan = 50, rightspan = 50, downspan = 20;
	public GenerateModels(Transform transform){
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();
		createNodes = new HashMap<DElement, DNode>();
	}
	public DSpecification generateElementTypeGraph(){
		DSpecification jointmeta = DiagramFactory.eINSTANCE.createDefaultDSpecification();

		boolean sourceIsDefault = sourceDSpecification == REFLEXIVE_DSPECIFICATION;
		boolean targetIsDefault = targetDSpecification == REFLEXIVE_DSPECIFICATION;  

		DGraph graph = jointmeta.getDGraph();
		DNode trace = graph.createDNode(TRACE, REFLEXIVE_TYPE_DNODE);
		trace.setSize(new Dimension(sizew, sizeh));
		int x = startx;
		int y = starty;
		if(sourceIsDefault){
			DNode node = graph.createDNode(NODE, REFLEXIVE_TYPE_DNODE);
			node.setLocation(new Point(x, y));
			node.setSize(new Dimension(sizew, sizeh));
			createNodes.put(REFLEXIVE_TYPE_DNODE, node);
			graph.createDArrow(SOURCE + NODE, trace, node, REFLEXIVE_TYPE_DARROW);
			x = x + sizew + leftspan;
		}else{
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
				createNodes.put(dNode, newNode);
				graph.createDArrow(SOURCE + dNode.getName(), trace, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : sourceDSpecification.getDGraph().getDArrows()){
				graph.createDArrow(dArrow.getName(), createNodes.get(dArrow.getDSource()), createNodes.get(dArrow.getDTarget()), REFLEXIVE_TYPE_DARROW);
			}
		}
		if(targetIsDefault){
			if(!sourceIsDefault){
				y = y / 2;
				DNode node = graph.createDNode(NODE, REFLEXIVE_TYPE_DNODE);
				node.setLocation(new Point(x + sizew + rightspan, y));
				node.setSize(new Dimension(sizew, sizeh));
				graph.createDArrow(TARGET + NODE, trace, node, REFLEXIVE_TYPE_DARROW);
			}else{
				graph.createDArrow(TARGET + NODE, trace, createNodes.get(REFLEXIVE_TYPE_DNODE), REFLEXIVE_TYPE_DARROW);
			}
			trace.setLocation(new Point(x, y));
		}else if(sourceDSpecification != targetDSpecification){
			int t = x;
			x = x + sizew + rightspan;
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				DNode newNode = graph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				newNode.setLocation(new Point(x + dNode.getLocation().x, dNode.getLocation().y));
				newNode.setSize(new Dimension(dNode.getSize()));
				if(y < dNode.getLocation().y) y = dNode.getLocation().y;
				createNodes.put(dNode, newNode);
				graph.createDArrow(TARGET + dNode.getName(), trace, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : targetDSpecification.getDGraph().getDArrows()){
				graph.createDArrow(dArrow.getName(), createNodes.get(dArrow.getDSource()), createNodes.get(dArrow.getDTarget()), REFLEXIVE_TYPE_DARROW);
			}
			if(sourceIsDefault){
				DNode theNode = createNodes.get(REFLEXIVE_TYPE_DNODE);
				theNode.setLocation(new Point(theNode.getLocation().x, y/2));
			}
			trace.setLocation(new Point(t, y/2));
		}else{
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				graph.createDArrow(TARGET + dNode.getName(), trace, createNodes.get(dNode), REFLEXIVE_TYPE_DARROW);
			}
			trace.setLocation(new Point(x, y/2));
		}
		return jointmeta;
	}
	public DSpecification generateCorrespondanceGraph(){
		DSpecification correspond = DiagramFactory.eINSTANCE.createDefaultDSpecification();

		boolean sourceIsDefault = sourceDSpecification == REFLEXIVE_DSPECIFICATION;
		boolean targetIsDefault = targetDSpecification == REFLEXIVE_DSPECIFICATION;  

		DGraph graph = correspond.getDGraph();
		DNode trace = graph.createDNode(LINK, REFLEXIVE_TYPE_DNODE);
		trace.setSize(new Dimension(sizew, sizeh));
		int x = startx;
		int y = starty;
		if(sourceIsDefault){
			DNode node = graph.createDNode(NODE, REFLEXIVE_TYPE_DNODE);
			node.setLocation(new Point(x, y));
			node.setSize(new Dimension(sizew, sizeh));
			createNodes.put(REFLEXIVE_TYPE_DNODE, node);
			graph.createDArrow(SOURCE + NODE, trace, node, REFLEXIVE_TYPE_DARROW);
			y = y + sizeh + downspan;
			DNode arrow = graph.createDNode(ARROW, REFLEXIVE_TYPE_DNODE);
			arrow.setLocation(new Point(x, y));
			arrow.setSize(new Dimension(sizew, sizeh));
			createNodes.put(REFLEXIVE_TYPE_DARROW, arrow);
			graph.createDArrow(SOURCE + ARROW, trace, arrow, REFLEXIVE_TYPE_DARROW);
			x = x + sizew + leftspan;
			y = starty;
		}else{
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
				createNodes.put(dNode, newNode);
				graph.createDArrow(SOURCE + dNode.getName(), trace, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : sourceDSpecification.getDGraph().getDArrows()){
				Point s = createNodes.get(dArrow.getDSource()).getLocation(), t = createNodes.get(dArrow.getDTarget()).getLocation();
				DNode arrow = graph.createDNode(dArrow.getName(), REFLEXIVE_TYPE_DNODE);
				arrow.setLocation(new Point((s.x + t.x) / 2, (s.y + t.y) / 2));
				arrow.setSize(new Dimension(sizew, sizeh));
				createNodes.put(dArrow, arrow);
				graph.createDArrow(SOURCE + dArrow.getName(), trace, arrow, REFLEXIVE_TYPE_DARROW);
			}
		}
		if(targetIsDefault){
			if(!sourceIsDefault){
				y = y / 2;
				DNode node = graph.createDNode(NODE, REFLEXIVE_TYPE_DNODE);
				node.setLocation(new Point(x, y));
				node.setSize(new Dimension(sizew, sizeh));
				createNodes.put(REFLEXIVE_TYPE_DNODE, node);
				graph.createDArrow(TARGET + NODE, trace, node, REFLEXIVE_TYPE_DARROW);
				y = y + sizeh + downspan;
				DNode arrow = graph.createDNode(ARROW, REFLEXIVE_TYPE_DNODE);
				arrow.setLocation(new Point(x, y));
				arrow.setSize(new Dimension(sizew, sizeh));
				createNodes.put(REFLEXIVE_TYPE_DARROW, arrow);
				graph.createDArrow(TARGET + NODE, trace, arrow, REFLEXIVE_TYPE_DARROW);
			}else{
				graph.createDArrow(TARGET + NODE, trace, createNodes.get(REFLEXIVE_TYPE_DNODE), REFLEXIVE_TYPE_DARROW);
				graph.createDArrow(TARGET + ARROW, trace, createNodes.get(REFLEXIVE_TYPE_DARROW), REFLEXIVE_TYPE_DARROW);
			}
			trace.setLocation(new Point(x, y));
		}else if(sourceDSpecification != targetDSpecification){
			int t = x;
			x = x + sizew + rightspan;
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				DNode newNode = graph.createDNode(dNode.getName(), REFLEXIVE_TYPE_DNODE);
				newNode.setLocation(new Point(x + dNode.getLocation().x, dNode.getLocation().y));
				newNode.setSize(new Dimension(dNode.getSize()));
				if(y < dNode.getLocation().y) y = dNode.getLocation().y;
				createNodes.put(dNode, newNode);
				graph.createDArrow(TARGET + dNode.getName(), trace, newNode, REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : targetDSpecification.getDGraph().getDArrows()){
				Point s = createNodes.get(dArrow.getDSource()).getLocation(), ts = createNodes.get(dArrow.getDTarget()).getLocation();
				DNode arrow = graph.createDNode(dArrow.getName(), REFLEXIVE_TYPE_DNODE);
				arrow.setLocation(new Point((s.x + ts.x) / 2, (s.y + ts.y) / 2));
				arrow.setSize(new Dimension(sizew, sizeh));
				createNodes.put(dArrow, arrow);
				graph.createDArrow(TARGET + dArrow.getName(), trace, arrow, REFLEXIVE_TYPE_DARROW);
			}
			trace.setLocation(new Point(t, y/2));
		}else{
			for(DNode dNode : targetDSpecification.getDGraph().getDNodes()){
				graph.createDArrow(TARGET + dNode.getName(), trace, createNodes.get(dNode), REFLEXIVE_TYPE_DARROW);
			}
			for(DArrow dArrow : targetDSpecification.getDGraph().getDArrows()){
				graph.createDArrow(TARGET + dArrow.getName(), trace, createNodes.get(dArrow), REFLEXIVE_TYPE_DARROW);
			}
			trace.setLocation(new Point(x, y/2));
		}
		return correspond;
	}
}
