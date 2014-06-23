/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.actions;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.parts.arrow.DArrowEditPart;
import no.hib.dpf.editor.parts.attribute.DArrowDAttributeEditPart;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public abstract class SelectionActionForEditParts extends SelectionAction {

	protected DGraph dGraph;

	public SelectionActionForEditParts(IWorkbenchPart part, String ID, DGraph graph) {
		super(part);
		setId(ID);
		dGraph = graph;
	}
	
	protected void getSelectElements(EList<DNode> nodes, EList<DArrow> arrows, EList<DDataNode> datanodes, EList<DNodeDAttribute> nodeAttributes, EList<DArrowDAttribute> arrowAttributes){
		for(Object object : getSelectedObjects()){
			if(object instanceof DNodeEditPart){
				addDNode(nodes, ((DNodeEditPart)object).getDiagramModel());
			}else if(object instanceof DDataNodeEditPart){
				addDDataNode(datanodes, ((DDataNodeEditPart)object).getDDataNode());
			}else if(object instanceof DArrowEditPart){
				addDArrow(nodes, arrows, ((DArrowEditPart)object).getDArrow());
			}else if(object instanceof DArrowDAttributeEditPart){
				addDArrowDAttribute(nodes, arrows, datanodes, arrowAttributes, ((DArrowDAttributeEditPart)object).getDArrowDAttribute());
			}else if(object instanceof DNodeDAttributeEditPart){ 
				addDNodeDAttribute(nodes, arrows, datanodes, nodeAttributes, ((DNodeDAttributeEditPart)object).getDNodeDAttribute());
			}
		}
	}
	
	private void addDNode(EList<DNode> nodes, DNode node){
		if(node != null && !nodes.contains(node))
			nodes.add(node);
	}
	
	private void addDDataNode(EList<DDataNode> datanodes, DDataNode datanode){
		if(datanodes != null && datanode != null && !datanodes.contains(datanode)){
			datanodes.add(datanode);
		}
	}
	
	private void addDNodeDAttribute(EList<DNode> nodes, EList<DArrow> arrows, EList<DDataNode> datanodes, EList<DNodeDAttribute> attributes, DNodeDAttribute attribute){
		if(attributes != null && attribute != null && !attributes.contains(attribute))
			attributes.add(attribute);
		addDNode(nodes, attribute.getDSource());
		addDDataNode(datanodes, attribute.getDTarget());
	}
	
	private void addDArrowDAttribute(EList<DNode> nodes, EList<DArrow> arrows, EList<DDataNode> datanodes, EList<DArrowDAttribute> attributes, DArrowDAttribute attribute){
		if(attributes != null && attribute != null && !attributes.contains(attribute))
			attributes.add(attribute);
		addDArrow(nodes, arrows, attribute.getDSource());
		addDDataNode(datanodes, attribute.getDTarget());
	}
	
	private void addDArrow(EList<DNode> nodes, EList<DArrow> arrows, DArrow arrow){
		if(arrow != null && !arrows.contains(arrow))
			arrows.add(arrow);
		addDNode(nodes, arrow.getDSource());
		addDNode(nodes, arrow.getDTarget());
	}
}
