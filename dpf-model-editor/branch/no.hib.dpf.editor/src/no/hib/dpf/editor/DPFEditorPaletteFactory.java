/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor;

import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.displaymodel.factories.ArrowCreationFactory;
import no.hib.dpf.editor.displaymodel.factories.VNodeFactory;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

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
	

	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory
	 * method to create a new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */
	public PaletteRoot createPalette(Graph typeGraph) {
		PaletteRoot palette = new PaletteRoot();
		palette.add(createToolsGroup(palette, typeGraph));
		palette.add(createArrowsGroup(typeGraph));
		palette.add(new PaletteSeparator());
		palette.add(createShapesGroup(typeGraph));
		return palette;
	}
	
	
	PaletteGroup getGroup(PaletteRoot root, String groupName) {
		@SuppressWarnings("rawtypes")
		List children = root.getChildren();
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i) instanceof PaletteGroup) {
				PaletteGroup entry = (PaletteGroup) children.get(i);
				if (entry.getLabel().equals(groupName)) {
					return entry;
				}
			}
		}
		return null;
	}
		
	public void updatePalette(PaletteRoot root, Graph typeGraph) {
		updateEntry(root, typeGraph, ARROWS);
		updateEntry(root, typeGraph, NODES);
	}
	
	private PaletteGroup createShapesGroup(Graph typeGraph) {
		PaletteGroup nodeGroup = new PaletteGroup(NODES);
		addNodeCreationToolsToGroup(typeGraph, nodeGroup);
		return nodeGroup;
	}

	private PaletteGroup createArrowsGroup(Graph typeGraph) {
		PaletteGroup arrowsGroup = new PaletteGroup(ARROWS);		
		addArrowCreationToolsToGroup(typeGraph, arrowsGroup);
		return arrowsGroup;
	}
		
	private void updateEntry(PaletteRoot root, Graph typeGraph, String entryName) {
		PaletteGroup entry = getGroup(root, entryName);
		removeEntryChildren(entry);
		if (entryName.equals(ARROWS)) {
			addArrowCreationToolsToGroup(typeGraph, entry);
		} else if (entryName.equals(NODES)) {
			addNodeCreationToolsToGroup(typeGraph, entry);			
		}
	}

	private void removeEntryChildren(PaletteGroup entry) {
		int size = entry.getChildren().size();
		for (int j = 0; j < size; j++) {
			entry.getChildren().remove(0);						
		}
	}
	
	private void addArrowCreationToolsToGroup(Graph typeGraph, PaletteGroup edgeGroup) {
		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.SMALL_CONNECTION.getFilePath());
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.LARGE_CONNECTION.getFilePath());

		boolean displayDyntypeArrow = ((typeGraph.getArrows().size() > 1) && (DPFEditorPreferences.getDefault().getDisplayDynamicallyTypedArrows())); 
		if (displayDyntypeArrow) {
			edgeGroup.add(new ConnectionCreationToolEntry("Arrow (dynamically typed)", "Create a new dynamically typed arrow", new ArrowCreationFactory(null, null), iconSmall, iconLarge));
		}
		
		if ((!displayDyntypeArrow) || (DPFEditorPreferences.getDefault().getDisplayStaticallyTypedArrows())) {
			for (Arrow typeArrow : typeGraph.getArrows()) {			
				edgeGroup.add(new ConnectionCreationToolEntry(typeArrow.getName(), "Create a new " + typeArrow.getName(), new ArrowCreationFactory(null, typeArrow), iconSmall, iconLarge));
			}
		}
	}
	
	public void addNodeCreationToolsToGroup(Graph typeGraph, PaletteGroup nodeGroup) {
		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.SMALL_RECTANGLE.getFilePath());
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.LARGE_RECTANGLE.getFilePath());

		for (Node typeNode : typeGraph.getNodes()) {
			nodeGroup.add(new CreationToolEntry(typeNode.getName(), "Create a new " + typeNode.getName(), new VNodeFactory(typeNode), iconSmall, iconLarge));
		}
	}
	
	/** Create the "Tools" group. */
	private PaletteContainer createToolsGroup(PaletteRoot palette, Graph typeGraph) {
		PaletteToolbar toolbar = new PaletteToolbar("Tools");

		// Add a selection tool to the group
		ToolEntry tool = new PanningSelectionToolEntry();
		toolbar.add(tool);
		palette.setDefaultEntry(tool);

		// Add a marquee tool to the group
		MarqueeToolEntry mqtool = new MarqueeToolEntry();
		mqtool.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR,
				MarqueeSelectionTool.BEHAVIOR_NODES_AND_CONNECTIONS);
		toolbar.add(mqtool);

		return toolbar;
	}

}