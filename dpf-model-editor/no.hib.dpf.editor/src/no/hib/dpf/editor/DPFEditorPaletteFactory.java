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

import java.util.List;

import no.hib.dpf.editor.editoractions.CreateConstraintAction;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.model.factories.EdgeCreationFactory;
import no.hib.dpf.editor.model.factories.VNodeFactory;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFEditorPaletteFactory {
	
	private static final String NODES = "Nodes";
	private static final String EDGES = "Edges";
	private static final String CONSTRAINTS = "Constaints";
	
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
		palette.add(createEdgesGroup(typeGraph));
		palette.add(new PaletteSeparator());
		palette.add(createShapesGroup(typeGraph));
		
//		palette.add(createConstraintToolbar());
//		palette.add(new PaletteSeparator());
//		palette.add(createConstraintGroup());
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
	
	public void updateConstraints(List<CreateConstraintAction> constraintActions, PaletteRoot root, ISelection selection) {
		
		if (constraintActions == null) {
			return;
		}
		
		PaletteGroup entry = getGroup(root, CONSTRAINTS);
		removeEntryChildren(entry);
		
		if (selection instanceof IStructuredSelection) {
			for (CreateConstraintAction createConstraintAction : constraintActions) {
				if (createConstraintAction.isEnabled()) {
					ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_CONNECTION));
					ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.LARGE_CONNECTION));

					entry.add(new ConnectionCreationToolEntry(createConstraintAction.getDescription(), "Create a new dings", new EdgeCreationFactory(null, null), iconSmall, iconLarge));
				}
			}
			
		}
//		return Collections.EMPTY_LIST;
//	return ((IStructuredSelection) getSelection()).toList();

		
		
		
	}
	
	public void updatePalette(PaletteRoot root, Graph typeGraph) {
		updateEntry(root, typeGraph, EDGES);
		updateEntry(root, typeGraph, NODES);
	}
	
	private PaletteGroup createShapesGroup(Graph typeGraph) {
		PaletteGroup nodeGroup = new PaletteGroup(NODES);
		addNodeCreationToolsToGroup(typeGraph, nodeGroup);
		return nodeGroup;
	}

	private PaletteGroup createEdgesGroup(Graph typeGraph) {
		PaletteGroup edgeGroup = new PaletteGroup(EDGES);		
		addEdgeCreationToolsToGroup(typeGraph, edgeGroup);
		return edgeGroup;
	}
	
	private PaletteToolbar createConstraintToolbar() {
//		Composite c = new Composite(parent, SWT.None);
//		c.setLayout(new GridLayout(1, true));
		
	
		PaletteToolbar constraintBar = new PaletteToolbar("DING");
		
		
		
		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_RECTANGLE));
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.LARGE_RECTANGLE));

		constraintBar.add(new CreationToolEntry("Navn", "Create a new ", null, iconSmall, iconLarge));
		return constraintBar;
		
	}
	
	private PaletteGroup createConstraintGroup() {
		return new PaletteGroup(CONSTRAINTS);		
	}
	
	private void updateEntry(PaletteRoot root, Graph typeGraph, String entryName) {
		PaletteGroup entry = getGroup(root, entryName);
		removeEntryChildren(entry);
		if (entryName.equals(EDGES)) {
			addEdgeCreationToolsToGroup(typeGraph, entry);
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
	
	private void addEdgeCreationToolsToGroup(Graph typeGraph, PaletteGroup edgeGroup) {
		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_CONNECTION));
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.LARGE_CONNECTION));

		for (Edge typeEdge : typeGraph.getEdges()) {			
			edgeGroup.add(new ConnectionCreationToolEntry(typeEdge.getName(), "Create a new " + typeEdge.getName(), new EdgeCreationFactory(null, typeEdge), iconSmall, iconLarge));
		}
	}
	
	public void addNodeCreationToolsToGroup(Graph typeGraph, PaletteGroup nodeGroup) {
		ImageDescriptor iconSmall = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_RECTANGLE));
		ImageDescriptor iconLarge = ImageDescriptor.createFromFile(DPFPlugin.class, ImageSettings.getImageSettings().getFilePath(ImageSettings.LARGE_RECTANGLE));

		for (Node typeNode : typeGraph.getNodes()) {
//			component = new CombinedTemplateCreationEntry(typeNode.getName(), "Create a new " + typeNode.getName(), VNode.class, new VNodeFactory(typeNode), iconSmall, iconLarge);
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

		
//		for (Edge typeEdge : typeGraph.getEdges()) {
//			
//			// Add (solid-line) connection tool
//			tool = new ConnectionCreationToolEntry(
//					typeEdge.getName(),
//					"Create a " + typeEdge.getName(),
//					new EdgeCreationFactory(null, typeEdge),
//					ImageDescriptor.createFromFile(DPFPlugin.class, "icons/connection_s16.gif"),
//					ImageDescriptor.createFromFile(DPFPlugin.class, "icons/connection_s24.gif"));
//			toolbar.add(tool);
//		}		

		return toolbar;
	}

//	/** Utility class. */
//	private DPFEditorPaletteFactory() {
//		// Utility class
//	}

}