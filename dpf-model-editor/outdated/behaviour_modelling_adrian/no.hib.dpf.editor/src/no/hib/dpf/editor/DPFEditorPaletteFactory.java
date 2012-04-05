/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor;


import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.icons.ImageSettings;

import org.eclipse.core.runtime.Assert;
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
	
	public void updatePalette(PaletteRoot root, DGraph dGraph) {
		for(DNode dnode : dGraph.getDNodes()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					smallIcon != null ? smallIcon : SMALLICON, 
							largeIcon != null ? largeIcon : LARGEICON));
		}
		for(DArrow darrow : dGraph.getDArrows()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
			arrowGroup.add(new ConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName(), new DArrowFactory(darrow), 
					smallIcon != null ? smallIcon : SMALLARROW, 
							largeIcon != null ? largeIcon : LARGEARROW));
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