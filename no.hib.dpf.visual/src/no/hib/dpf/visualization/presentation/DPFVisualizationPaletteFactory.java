/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.visualization.presentation;


import java.util.ArrayList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.AbstractDPFEditorPaletteFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.presentation.ComposedNodeFactory;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFVisualizationPaletteFactory extends AbstractDPFEditorPaletteFactory{
	
	ArrayList<String> templateArrows = new ArrayList<String>();
	ArrayList<String> templateNodes = new ArrayList<String>();
	ArrayList<String> templateNodeAttributes = new ArrayList<String>();
	ArrayList<String> templateArrowAttributes = new ArrayList<String>();
	
	
	/**
	 * @author Ole Klokkhammer
	 * @param dSpec
	 * @param visualizations
	 */
	
	public void updatePalette(Visualizations visualizations) { 
		DSpecification dSpec = visualizations.getInstance();
		Assert.isNotNull(dSpec);
		DSpecification typeDSpec = dSpec.getDType();
		Assert.isNotNull(typeDSpec);
		DGraph typeDGraph = typeDSpec.getDGraph();
		
		templateArrows = DPFTemplateUtils.getTemplateArrows(typeDGraph);
		templateNodes =  DPFTemplateUtils.getTemplateNodes(typeDGraph);
//		templateNodeAttributes = DPFTemplateUtils.getTemplateNodeAttributes(typeDGraph);
//		templateArrowAttributes = DPFTemplateUtils.getTemplateArrowAttributes(typeDGraph);
		
		addPaletteElements(typeDGraph, visualizations.getEntries());
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dGraph
	 */
	private void addPaletteElements(DGraph dgraph, EMap<DElement, VElement> maps) {
		System.out.println("Adding pallet elements: "+maps+"\n from: "+dgraph.getDNodes());
		
		// add nodes
		addDNodes(dgraph, maps);
	
		// add palette seperators
		templateElementsGroup.add(new PaletteSeparator());
		if (palette.getChildren().contains(domainSpecificElementsGroup)) {
			domainSpecificElementsGroup.add(new PaletteSeparator());
		}
	
		// add arrows
		addDArrows(dgraph, maps);
		
		// set the defaultElementsgroup to closed
		if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
			templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
		}else{
			templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
		}
	}

	private void addDNodes(DGraph dgraph, EMap<DElement,VElement> maps) {
		ArrayList<DNode> paletteDNodes = getPaletteDNodes(dgraph.getDNodes(), maps);
		for(DNode dnode : paletteDNodes){
			System.out.println("adding node: "+dnode);
			ImageDescriptor smallIcon = null;
			ImageDescriptor largeIcon = null;

			VElement element = VisualizationModelUtils.getVElement(dnode, maps);
			if(!VisualizationModelUtils.isVCompartmentElement(dnode, maps)) {
				if(element instanceof VNode){
					VNode vNode = (VNode) element;
					smallIcon = vNode.getIcon() == null || vNode.getIcon().isEmpty() ? null : ImageDescriptor.createFromFile(null, vNode.getIcon());	
				}
				addDNodeToPalette(dnode, smallIcon, largeIcon);
			}
		}
	}

	private void addDArrows(DGraph dgraph, EMap<DElement,VElement> maps) {
		ArrayList<DArrow> paletteDArrows = getPaletteDArrows(dgraph.getDArrows(), maps);
		for(DArrow darrow :paletteDArrows){
			System.out.println("adding arrow: "+darrow);
			ImageDescriptor smallIcon= null;
			ImageDescriptor largeIcon = null;
			
			VElement element = VisualizationModelUtils.getVElement(darrow, maps);
			if(VisualizationModelUtils.isComposedVArrow(element)){
				VArrow vArrow = (VArrow) element;
				smallIcon = vArrow.getIcon() == null || vArrow.getIcon().isEmpty() ? null : ImageDescriptor.createFromFile(null, vArrow.getIcon());
				addComposedNodeToPalette(darrow, smallIcon, largeIcon);
			}else{
				addDArrowToPalette(darrow, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dNodes
	 * @param maps
	 * @return
	 */
	private ArrayList<DNode> getPaletteDNodes(EList<DNode> dNodes, EMap<DElement, VElement> maps) {
		ArrayList<DNode> paletteDNodes = new ArrayList<DNode>();
		for (DNode dNode : dNodes) {
			
			VElement velement = VisualizationModelUtils.getVElement(dNode, maps);
			if(velement != null && velement instanceof VNode){
				paletteDNodes.add(dNode);
			}
		}
		
		return paletteDNodes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dArrows
	 * @param maps
	 * @return
	 */
	private ArrayList<DArrow> getPaletteDArrows(EList<DArrow> dArrows, EMap<DElement, VElement> maps) {
		ArrayList<DArrow> paletteDArrows = new ArrayList<DArrow>();
		for (DArrow dArrow : dArrows) {
			DNode sourceDNode = dArrow.getDSource();
			Assert.isNotNull(sourceDNode);
			
			VElement vnode = VisualizationModelUtils.getVElement(sourceDNode, maps);
			if(vnode != null && vnode instanceof VNode && VisualizationModelUtils.isCompositeVNode(vnode)){
				paletteDArrows.add(dArrow);
				continue;
			}
			
			VElement varrow = VisualizationModelUtils.getVElement(dArrow, maps);
			if(varrow != null && !VisualizationModelUtils.isComposedVArrow(varrow)){
				paletteDArrows.add(dArrow);
			}
		}
		
		return paletteDArrows;
	}


	/**
	 * Seperates the default nodes and dsl elements into two groups and adds them to 
	 * the palette accordingly
	 * 
	 * @author Ole Klokkhammer
	 * @param dnode
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDNodeToPalette(DNode dnode, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		System.out.println("adding node to Pallet: "+dnode);
		Node node = dnode.getNode();
		Assert.isNotNull(node);
		
		// seperate into two groups, default and dsl elements:
		if(templateNodes.contains(dnode.getName())){
			if (!palette.getChildren().contains(templateElementsGroup)) {
				palette.add(templateElementsGroup);
			}
			addDNodeEntry(templateElementsGroup, dnode, smallIcon, largeIcon);
		}else { 
			System.out.println("canAdd: "+canAdd(node));
			// Check if the arrow can be instantiated or not:
			if(canAdd(node)){
				
				// if the palettegroup is not already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDNodeEntry(domainSpecificElementsGroup, dnode, smallIcon, largeIcon); 
			}
		}
	}
	
	/**
	 * Seperates the default arrows and dsl elements into two groups and adds them to 
	 * the palette accordingly
	 * 
	 * @author Ole Klokkhammer
	 * @param dnode
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDArrowToPalette(DArrow darrow, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Arrow arrow = darrow.getArrow();
		Assert.isNotNull(arrow);
		
		// seperate into two groups, default and dsl elements:
		if(templateArrows.contains(darrow.getName())){
			if (!palette.getChildren().contains(templateElementsGroup)) {
				palette.add(templateElementsGroup);
			}
			addDArrowEntry(templateElementsGroup, darrow, smallIcon, largeIcon); 
		}else{ 
			
			// Check if the arrow can be instantiated or not:
			if(canAdd(arrow)){
				
				// if the palettegroup is not already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDArrowEntry(domainSpecificElementsGroup, darrow, smallIcon, largeIcon);
			}
		}
	}
	
	/**
	 * Seperates the default arrows and dsl elements into two groups and adds them to 
	 * the palette accordingly
	 * 
	 * @author Ole Klokkhammer
	 * @param dnode
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addComposedNodeToPalette(DArrow darrow, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Arrow arrow = darrow.getArrow();
		Assert.isNotNull(arrow);
		DNode targetDNode = darrow.getDTarget();
		Assert.isNotNull(targetDNode);		
		
		// seperate into two groups, default and dsl elements:
		if(templateNodes.contains(targetDNode.getName())){
			if (!palette.getChildren().contains(templateElementsGroup)) {
				palette.add(templateElementsGroup);
			}
			addComposedDNodeEntry(templateElementsGroup, darrow, smallIcon, largeIcon);
		}else { 
			
			// Check if the arrow can be instantiated or not:
			if(canAdd(arrow)){
				// if the palettegroup is not already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addComposedDNodeEntry(domainSpecificElementsGroup, darrow, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dnode
	 * @param smallIcon
	 * @param largeIcon
	 */
	protected void addDNodeEntry(PaletteDrawer root, DNode dnode, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Assert.isNotNull(dnode);
		Assert.isNotNull(root);
		Node node = dnode.getNode();
		String nodeName = node.getName();
		if(node != null){		
			root.add(new CreationToolEntry(nodeName, 
					"Create a new " + nodeName, new DNodeFactory(dnode), smallIcon != null ? smallIcon
							: SMALLICON, largeIcon != null ? largeIcon
							: LARGEICON));
		}
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param darrow
	 * @param smallIcon
	 * @param largeIcon
	 */
	protected void addDArrowEntry(PaletteDrawer root, DArrow darrow, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Assert.isNotNull(darrow);
		Assert.isNotNull(root);
		Arrow arrow = darrow.getArrow();
		if(arrow != null && arrow.getSource() != null && arrow.getTarget() != null){
			root.add(new ConnectionCreationToolEntry(arrow
					.getName(), "Create a new " + arrow.getName() + ":"
					+ arrow.getSource().getName() + "-->"
					+ arrow.getTarget().getName(),
					new DArrowFactory(darrow),
					smallIcon != null ? smallIcon : SMALLARROW,
					largeIcon != null ? largeIcon : LARGEARROW));
		}
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param darrow
	 * @param smallIcon
	 * @param largeicon
	 */
	private void addComposedDNodeEntry(PaletteDrawer root, DArrow darrow, ImageDescriptor smallIcon, ImageDescriptor largeicon) {
		Assert.isNotNull(darrow);
		Assert.isNotNull(root);
		Arrow arrow = darrow.getArrow();
		
		Node node = arrow.getTarget();
//		if(canAdd(node) && arrow != null){
		if(canAdd(node) ){
			String nodeName = node.getName();
			root.add(new CreationToolEntry(nodeName, "Create a new " + nodeName, new ComposedNodeFactory(darrow.getDTarget()), 
					smallIcon != null ? smallIcon : SMALLICON, largeicon != null ? largeicon : LARGEICON));
		}
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @return
	 */
//	@Override
	protected boolean canAdd(Node node) {
		
		//add either way
		
		return true;
//		
//		// if its a default type, then add it
//		if(templateNodes.contains(node.getName())){
//			return true;
//		}
//
//		// ... otherwise only add the node if its template arrow-mutability is not set and and potency != 0
////		Node templateNode = (Node) node.getTemplateElement();
////		if(templateNode != null && !templateNode.eIsSet(CorePackage.Literals.MUTABLE_ELEMENT__MUTABILITY)){
////			if(node.getPotency() != 0 && (node.getMutability() > 1 || node.getMutability() == -1)){
////				return true;
////			}
////		}
//		return false;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @return
	 */
	@Override
	protected boolean canAdd(Arrow arrow) {
		
		return true;
		
//		// if its a template type, then add it
//		if(templateArrows.contains(arrow.getName())){
//			return true;
//		}
//		
//		// ... otherwise only add the arrow if its template arrow-mutability is not set and potency != 0
////		Arrow templateArrow = (Arrow) arrow.getTemplateElement();
////		if(templateArrow != null && !templateArrow.eIsSet(CorePackage.Literals.MUTABLE_ELEMENT__MUTABILITY)){
////			if(arrow.getPotency() != 0 && (arrow.getMutability() > 1 || arrow.getMutability() == -1)){
////				return true;
////			}
////		}
//		return false;
	}
}