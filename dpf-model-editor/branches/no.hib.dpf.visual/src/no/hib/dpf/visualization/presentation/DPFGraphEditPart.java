package no.hib.dpf.visualization.presentation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;

public class DPFGraphEditPart extends DGraphEditPart {
	EMap<IDObject, VElement> maps;
	
	public DPFGraphEditPart(EMap<IDObject, VElement> maps) {
		super();
		this.maps = maps;
	}
	
	@Override
	protected List<DNode> getModelChildren() {
		EList<DNode> child = new BasicEList<DNode>();
		child.addAll(getDGraph().getDNodes());
		for(DNode dNode : getDGraph().getDNodes()) {
			if(hasVArrowTargetTo(dNode.getNode().getTypeNode()))
				child.remove(dNode);
		}
		return child;
	}
	
	private DGraph getDGraph(){
		return (DGraph) getModel();
	}
	
	/*
	 * find if there is a composed visual configure for the arrow which target to the node. 
	 */
	private boolean hasVArrowTargetTo(Node node){
		for(Arrow arrow : node.getIncomings()){
			VElement aElement = maps.get(arrow);
			if(aElement instanceof VArrow && ((VArrow)aElement).isComposed()) 
				return true;
		}
		return false;
	}
}
