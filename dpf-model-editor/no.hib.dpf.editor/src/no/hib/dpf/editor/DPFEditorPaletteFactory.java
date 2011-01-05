/*******************************************************************************
 * Copyright (c) 2004, 2008 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor;

import no.hib.dpf.editor.model.VEdge;
import no.hib.dpf.editor.model.VNode;
import no.hib.dpf.editor.model.factories.VNodeFactory;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFEditorPaletteFactory {
	
	// /** Preference ID used to persist the palette location. */
	// private static final String PALETTE_DOCK_LOCATION =
	// "ShapesEditorPaletteFactory.Location";
	// /** Preference ID used to persist the palette size. */
	// private static final String PALETTE_SIZE =
	// "ShapesEditorPaletteFactory.Size";
	// /** Preference ID used to persist the flyout palette's state. */
	// private static final String PALETTE_STATE =
	// "ShapesEditorPaletteFactory.State";

	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory
	 * method to create a new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */
	public PaletteRoot createPalette(Graph typeGraph) {
		PaletteRoot palette = new PaletteRoot();
		palette.add(createToolsGroup(palette, typeGraph));
		palette.add(createShapesDrawer(typeGraph));
		return palette;
	}

	/** Create the "Shapes" drawer. */
	private PaletteContainer createShapesDrawer(Graph typeGraph) {
		PaletteDrawer componentsDrawer = new PaletteDrawer("Shapes");

		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, "icons/rectangle16.gif");
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, "icons/rectangle24.gif");

		CombinedTemplateCreationEntry component;
		for (Node typeNode : typeGraph.getNodes()) {
			component = new CombinedTemplateCreationEntry(typeNode.getName(), "Create a new " + typeNode.getName(), VNode.class, new VNodeFactory(typeNode), iconSmall, iconLarge);
			componentsDrawer.add(component);
		}

		return componentsDrawer;
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

		
		for (Edge typeEdge : typeGraph.getEdges()) {
			
			// Add (solid-line) connection tool
			tool = new ConnectionCreationToolEntry(typeEdge.getName(),
					"Create a " + typeEdge.getName(), new CreationFactory() {
						public Object getNewObject() {
							return null;
						}

						// see ShapeEditPart#createEditPolicies()
						// this is abused to transmit the desired line style
						public Object getObjectType() {
							return VEdge.SOLID_CONNECTION;
						}
					}, ImageDescriptor.createFromFile(DPFPlugin.class,
							"icons/connection_s16.gif"),
					ImageDescriptor.createFromFile(DPFPlugin.class,
							"icons/connection_s24.gif"));
			toolbar.add(tool);
		}
		


		return toolbar;
	}

//	/** Utility class. */
//	private DPFEditorPaletteFactory() {
//		// Utility class
//	}

}