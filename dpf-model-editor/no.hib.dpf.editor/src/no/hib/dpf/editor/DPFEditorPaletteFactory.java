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
package no.hib.dpf.editor;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.constant.DPFConstants;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.DPFDiagram;
import no.hib.dpf.editor.displaymodel.factories.ArrowCreationFactory;
import no.hib.dpf.editor.displaymodel.factories.VNodeFactory;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
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
public class DPFEditorPaletteFactory {
	
	private static final String NODES = "Nodes";
	private static final String ARROWS = "Arrows";
	private PaletteGroup nodeGroup = new PaletteGroup(NODES);
	private PaletteGroup arrowGroup = new PaletteGroup(ARROWS);
	private PaletteRoot palette;
	

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
	
	public void updatePalette(PaletteRoot root, DPFDiagram parent, Graph typeGraph) {
		if(parent == null){
			nodeGroup.add(new CreationToolEntry("Node", "Create a new node", new VNodeFactory(DPFConstants.REFLEXIVE_TYPE_GRAPH.getNodes().get(0)), DNode.SMALLICON, DNode.LARGEICON));
			arrowGroup.add(new ConnectionCreationToolEntry("Arrow", "Create a new arrow", new ArrowCreationFactory(null, DPFConstants.REFLEXIVE_TYPE_GRAPH.getArrows().get(0)), DArrow.SMALLARROW, DArrow.LARGEARROW));
			return;
		}
		List<DArrow> hash = new ArrayList<DArrow>();
		for(DNode dnode : parent.getChildren()){
			IConfigurationElement configure = dnode.getConfigure();
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = (Node) typeGraph.getGraphMember(dnode.getIDObjectID());
			assert(node != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new VNodeFactory(node, dnode), 
					smallIcon != null ? smallIcon : DNode.SMALLICON, 
							largeIcon != null ? largeIcon : DNode.LARGEICON));
			for(DArrow darrow : dnode.getSourceConnections())
				updateArrowGroup(hash, darrow, typeGraph);
			for(DArrow darrow : dnode.getTargetConnections())
				updateArrowGroup(hash, darrow, typeGraph);
		}
	}
	
	private void updateArrowGroup(List<DArrow> hash, DArrow darrow, Graph typGraph) {
		if(!hash.contains(darrow)){
			IConfigurationElement configure = darrow.getConfigure();
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = (Arrow) typGraph.getGraphMember(darrow.getIDObjectID());
			assert(arrow != null);
			arrowGroup.add(new ConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName(), new ArrowCreationFactory(null, arrow, darrow), 
					smallIcon != null ? smallIcon : DArrow.SMALLARROW, 
							largeIcon != null ? largeIcon : DArrow.LARGEARROW));
			hash.add(darrow);
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