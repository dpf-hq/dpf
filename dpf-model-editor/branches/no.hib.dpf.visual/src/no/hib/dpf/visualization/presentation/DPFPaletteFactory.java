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


import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DPFConnectionCreationToolEntry;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.presentation.ArrowFactory;
import no.hib.dpf.visual.presentation.NodeFactory;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFPaletteFactory {
	
	private static final String NODES = "Nodes";
	private static final String ARROWS = "Arrows";
	private PaletteGroup nodeGroup = new PaletteGroup(NODES);
	private PaletteGroup arrowGroup = new PaletteGroup(ARROWS);
	private PaletteRoot palette;
	
	public static final ImageDescriptor SMALLICON = ImageSettings.SMALL_RECTANGLE.getImageDescriptor();
	public static final ImageDescriptor LARGEICON = ImageSettings.LARGE_RECTANGLE.getImageDescriptor();
	public final static ImageDescriptor SMALLARROW = ImageSettings.SMALL_CONNECTION.getImageDescriptor();
	public final static ImageDescriptor LARGEARROW = ImageSettings.LARGE_CONNECTION.getImageDescriptor();
	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory
	 * method to create a new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */
	
	public PaletteRoot createPalette() {
		if(palette == null){
			 palette = new PaletteRoot();
			 palette.add(createToolsGroup(palette));
			 palette.add(arrowGroup);
			 palette.add(new PaletteSeparator());
			 palette.add(nodeGroup);
		}
		return palette;
	}
	
	public void updatePalette(PaletteRoot root, Graph graph, EMap<IDObject, VElement> maps) {
		for(Node node : graph.getNodes()){
			VElement element = maps.get(node);
			if(element instanceof VNode){
				VNode vNode = (VNode) element;
				ImageDescriptor smallIcon = vNode.getIcon() == null || vNode.getIcon().isEmpty() ? null : ImageDescriptor.createFromFile(null, vNode.getIcon());
				nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new NodeFactory(node), 
							smallIcon != null ? smallIcon : SMALLICON, LARGEICON));
			}
		}
 		for(Arrow arrow : graph.getArrows()){
 			VElement element = maps.get(arrow);
			if(element instanceof VArrow){
				VArrow vArrow = (VArrow) element;
				if(vArrow.isComposed()) {
					ImageDescriptor smallIcon = vArrow.getIcon() == null || vArrow.getIcon().isEmpty() ? null : ImageDescriptor.createFromFile(null, vArrow.getIcon());
					nodeGroup.add(new CreationToolEntry(arrow.getName(), "Create a new " + arrow.getName(), new ArrowFactory(arrow), 
								smallIcon != null ? smallIcon : SMALLICON, LARGEICON));
				} else {
					ImageDescriptor smallIcon = vArrow.getIcon() == null || vArrow.getIcon().isEmpty() ? null : ImageDescriptor.createFromFile(null, vArrow.getIcon());
					arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new ArrowFactory(arrow), 
							smallIcon != null ? smallIcon : SMALLARROW, LARGEARROW));
				}
			}
		}
	}
	
	/** Create the "Tools" group. */
	private PaletteContainer createToolsGroup(PaletteRoot palette) {
		PaletteToolbar toolbar = new PaletteToolbar("Tools");

		// Add a selection tool to the group
		ToolEntry tool = new PanningSelectionToolEntry();
		toolbar.add(tool);
		palette.setDefaultEntry(tool);

		// Add a marquee tool to the group
		MarqueeToolEntry mqtool = new MarqueeToolEntry();
		mqtool.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR,
				MarqueeSelectionTool.BEHAVIOR_NODES_CONTAINED_AND_RELATED_CONNECTIONS);
		toolbar.add(mqtool);

		return toolbar;
	}

}