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

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.actions.CreateConstraintToolEntry;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFEditorPaletteFactory implements ISelectionChangedListener {

	public static final String ARROWS = "Arrows";
	public static final String NODES = "Nodes";

	public static final ImageDescriptor LARGEARROW = ImageSettings.LARGE_CONNECTION.getImageDescriptor();
	public static final ImageDescriptor LARGEICON = ImageSettings.LARGE_RECTANGLE.getImageDescriptor();
	public static final ImageDescriptor SMALLARROW = ImageSettings.SMALL_CONNECTION.getImageDescriptor();
	public static final ImageDescriptor SMALLICON = ImageSettings.SMALL_RECTANGLE.getImageDescriptor();

	protected PaletteGroup arrowGroup = new PaletteGroup(ARROWS);
	protected PaletteGroup nodeGroup = new PaletteGroup(NODES);
	protected PaletteGroup constraintGroup = new PaletteGroup("Constraints");
	protected PaletteRoot palette;

	protected Shell shell;

	/**
	 * Creates the PaletteRoot and adds all palette elements. Use this factory
	 * method to create a new palette for your graphical editor.
	 * 
	 * @return a new PaletteRoot
	 */

	public PaletteRoot createPalette() {
		if (palette == null) {
			palette = new PaletteRoot();
			palette.add(createToolsGroup(palette));
			palette.add(arrowGroup);
			palette.add(new PaletteSeparator());
			palette.add(nodeGroup);
			palette.add(new PaletteSeparator());
			palette.add(constraintGroup);
		}
		return palette;
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

	public void updatePalette(PaletteRoot root, DGraph dGraph) {
		for (DNode dnode : dGraph.getDNodes()) {
			IConfigurationElement configure = FigureConfigureManager
					.getConfigurationElement(dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			if (node == null)
				continue;
			Assert.isTrue(dnode != null);
			nodeGroup.add(
					new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode),
							smallIcon != null ? smallIcon : SMALLICON, largeIcon != null ? largeIcon : LARGEICON));
		}
		for (DArrow darrow : dGraph.getDArrows()) {
			IConfigurationElement configure = FigureConfigureManager
					.getConfigurationElement(darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
			// add Arrow:Node-->Node to tooltip in case several arrows with same
			// name showing up in the metamodel.
			arrowGroup.add(new ConnectionCreationToolEntry(arrow.getName(),
					"Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->"
							+ arrow.getTarget().getName(),
					new DArrowFactory(darrow), smallIcon != null ? smallIcon : SMALLARROW,
					largeIcon != null ? largeIcon : LARGEARROW));
		}
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof StructuredSelection) {
			StructuredSelection str = (StructuredSelection) selection;
			Object[] selectedParObjects = str.toArray();
			if (selectedParObjects.length == 0)
				return;
			EList<DArrow> selectionDArrows = new BasicEList<DArrow>();
			EList<DNode> selectionDNodes = new BasicEList<DNode>();
			getSelectElements(Arrays.asList(str.toArray()), selectionDNodes, selectionDArrows);
			for (CreateConstraintToolEntry entry : entries) {
				EList<Arrow> selectionArrows = getArrows(selectionDArrows);
				EList<Node> selectionNodes = getNodes(selectionDNodes);
				boolean keep = true;
				for (Node node : selectionNodes) {
					for (Constraint constraint : node.getConstraints())
						if (constraint.getPredicate() == entry.getDPredicate().getPredicate()) {
							boolean repeat = constraint.getArrows().equals(selectionArrows)
									&& constraint.getNodes().equals(selectionNodes);
							if (repeat)
								keep = false;
						}
				}
				if (keep) {
					keep = entry.getDPredicate().getPredicate().canCreateConstraint(selectionNodes, selectionArrows);
					if (keep) {
						entry.setNodes(selectionDNodes, selectionNodes);
						entry.setArrows(selectionDArrows, selectionArrows);
					}
				}
				boolean in = constraintGroup.getChildren().contains(entry);
				if (keep && !in)
					constraintGroup.add(entry);
				if (!keep && in)
					constraintGroup.remove(entry);
			}
		}
	}

	public void updatePalette(DSpecification dSpecification) {
		DSignature signature = dSpecification.getDSignature();
		if (signature != null) {
			for (DPredicate predicate : signature.getDPredicates())
				entries.add(new CreateConstraintToolEntry(dSpecification, predicate));
			if (signature != DEFAULT_DSIGNATURE) {
				for (DPredicate predicate : DEFAULT_DSIGNATURE.getDPredicates())
					entries.add(new CreateConstraintToolEntry(dSpecification, predicate));
			}
		}
	}

	List<CreateConstraintToolEntry> entries = new ArrayList<CreateConstraintToolEntry>();

	private void getSelectElements(List<Object> selectedParts, EList<DNode> nodes, EList<DArrow> arrows) {
		for (Object object : selectedParts) {
			if (object instanceof DNodeEditPart)
				addDNode(nodes, ((DNodeEditPart) object).getDNode());
			if (object instanceof DArrowEditPart)
				addDArrow(nodes, arrows, ((DArrowEditPart) object).getDArrow());
		}
	}

	private EList<Node> getNodes(List<DNode> nodes) {
		EList<Node> result = new BasicEList<Node>();
		for (DNode node : nodes)
			if (node.getNode() != null)
				result.add(node.getNode());
		return result;
	}

	private EList<Arrow> getArrows(List<DArrow> arrows) {
		EList<Arrow> result = new BasicEList<Arrow>();
		for (DArrow arrow : arrows)
			if (arrow.getArrow() != null)
				result.add(arrow.getArrow());
		return result;
	}

	private void addDNode(EList<DNode> nodes, DNode node) {
		if (node != null && !nodes.contains(node))
			nodes.add(node);
	}

	private void addDArrow(EList<DNode> nodes, EList<DArrow> arrows, DArrow arrow) {
		if (arrow != null && !arrows.contains(arrow))
			arrows.add(arrow);
		addDNode(nodes, arrow.getDSource());
		addDNode(nodes, arrow.getDTarget());
	}

	public void setShell(Shell shell2) {
		shell = shell2;
	}
}