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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.displaymodel.factories.DArrowDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DDataNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DPFConnectionCreationToolEntry;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Utility class that can create a GEF Palette.
 */
public class DPFEditorPaletteFactory extends AbstractDPFEditorPaletteFactory{	
	
	/**
	 * @author Ole Klokkhammer
	 * @param dSpec
	 */
	public void updatePalette(DSpecification dSpec) {
		Assert.isNotNull(dSpec);
		DGraph dgraph = dSpec.getDGraph();
		updatePalette(dgraph);
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dSpec
	 */
	public void updatePalette(DGraph dgraph) {
		Assert.isNotNull(dgraph);
		addPaletteElements(dgraph);
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dGraph
	 */
	private void addPaletteElements(DGraph dGraph) {
		
		// add arrows
		addDArrows(dGraph);
		addDNodeDAttributes(dGraph);
		addDArrowDAttributes(dGraph);

		// add palette seperators
		templateElementsGroup.add(new PaletteSeparator());
		if (palette.getChildren().contains(domainSpecificElementsGroup)) {
			domainSpecificElementsGroup.add(new PaletteSeparator());
		}

		// add nodes
		addDNodes(dGraph);
		addDDataNodes(dGraph);
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dGraph
	 */
	private void addDDataNodes(DGraph dGraph) {
		for (DDataNode ddatanode : dGraph.getDDataNodes()) {
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(ddatanode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			
			Assert.isTrue(ddatanode != null);
			DataNode datatype = ddatanode.getDatanode();
			Assert.isTrue(datatype != null);
			
			
			// seperate into groups
			if(!datatype.eIsSet(CorePackage.Literals.DATA_NODE__VALUE)){
				if (!palette.getChildren().contains(linguisticElementsGroup)) {
					palette.add(linguisticElementsGroup);
				}
				addDDataNodeEntry(linguisticElementsGroup, ddatanode, smallIcon, largeIcon);
			}else { // Check if the arrow can be instantiated or not:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDDataNodeEntry(domainSpecificElementsGroup, ddatanode, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dGraph
	 */
	private void addDNodes(DGraph dGraph) {
		for (DNode dnode : dGraph.getDNodes()) {
			IConfigurationElement configure = FigureConfigureManager
					.getInstance().getConfigurationElement(
							dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null
					: FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null
					: FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			
			// seperate into groups
			if(DPFCoreConstants.getMetaMetaTypes().contains(dnode.getName())){
				if (!palette.getChildren().contains(linguisticElementsGroup)) {
					palette.add(linguisticElementsGroup);
				}
				addDNodeEntry(linguisticElementsGroup, dnode, smallIcon, largeIcon);
			}else if(DPFTemplateUtils.getTemplateNodes(dGraph).contains(dnode.getName())){
				if (!palette.getChildren().contains(templateElementsGroup)) {
					palette.add(templateElementsGroup);
				}
				addDNodeEntry(templateElementsGroup, dnode, smallIcon, largeIcon);
			}else if(canAdd(node)){ // Check if the arrow can be instantiated or not:
				
				// if the palettegroup isnt already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDNodeEntry(domainSpecificElementsGroup, dnode, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dGraph
	 */
	private void addDArrowDAttributes(DGraph dGraph) {
		for (DArrowDAttribute dattribute : dGraph.getDArrowDAttributes()) {
			IConfigurationElement configure = FigureConfigureManager
					.getInstance().getConfigurationElement(
							dattribute.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null
					: FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null
					: FigureConfigureManager.getLargeIcon(configure);
			
			// seperate into groups
			if(DPFCoreConstants.getMetaMetaTypes().contains(dattribute.getName())){
				if (!palette.getChildren().contains(linguisticElementsGroup)) {
					palette.add(linguisticElementsGroup);
				}
				addDArrowDAttributeEntry(linguisticElementsGroup, dattribute, smallIcon, largeIcon);
			}else if(DPFTemplateUtils.getTemplateArrows(dGraph).contains(dattribute.getName())){
				if (!palette.getChildren().contains(templateElementsGroup)) {
					palette.add(templateElementsGroup);
				}
				addDArrowDAttributeEntry(templateElementsGroup, dattribute, smallIcon, largeIcon);
			}else{ // Check if the arrow can be instantiated or not:
				
				// if the palettegroup isnt already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDArrowDAttributeEntry(domainSpecificElementsGroup, dattribute, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dGraph
	 */
	private void addDNodeDAttributes(DGraph dGraph) {
		for (DNodeDAttribute dattribute : dGraph.getDNodeDAttributes()) {
			IConfigurationElement configure = FigureConfigureManager
					.getInstance().getConfigurationElement(
							dattribute.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null
					: FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null
					: FigureConfigureManager.getLargeIcon(configure);
			
			// seperate into groups
			if(DPFCoreConstants.getMetaMetaTypes().contains(dattribute.getName())){
				if (!palette.getChildren().contains(linguisticElementsGroup)) {
					palette.add(linguisticElementsGroup);
				}
				addDNodeDAttributeEntry(linguisticElementsGroup, dattribute, smallIcon, largeIcon);
			}else if(DPFTemplateUtils.getTemplateNodeAttributes(dGraph).contains(dattribute.getNodeAttribute().getName())){
				if (!palette.getChildren().contains(templateElementsGroup)) {
					palette.add(templateElementsGroup);
				}
				addDNodeDAttributeEntry(templateElementsGroup, dattribute, smallIcon, largeIcon);
			}else { // Check if the arrow can be instantiated or not:
				
				// if the palettegroup isnt already added, add it to the palette:
				if (!palette.getChildren().contains(domainSpecificElementsGroup)) {
					palette.add(domainSpecificElementsGroup);
					templateElementsGroup.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				}
				addDNodeDAttributeEntry(domainSpecificElementsGroup, dattribute, smallIcon, largeIcon);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dGraph
	 */
	private void addDArrows(DGraph dGraph) {
		for (DArrow darrow : dGraph.getDArrows()) {
			Assert.isNotNull(darrow);
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(
							darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isNotNull(arrow);
			// add Arrow:Node-->Node to tooltip in case several arrows with same
			// name showing up in the metamodel.
			
			// seperate into groups
			if(DPFCoreConstants.getMetaMetaTypes().contains(darrow.getName())){
				if (!palette.getChildren().contains(linguisticElementsGroup)) {
					palette.add(linguisticElementsGroup);
				}
				addDArrowEntry(linguisticElementsGroup, darrow, smallIcon, largeIcon);
			}else if(DPFTemplateUtils.getTemplateArrows(dGraph).contains(darrow.getName())){
				if (!palette.getChildren().contains(templateElementsGroup)) {
					palette.add(templateElementsGroup);
				}
				addDArrowEntry(templateElementsGroup, darrow, smallIcon, largeIcon);
			}else if(canAdd(arrow)){ // Check if the arrow can be instantiated or not:
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
	 *
	 * 
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dattribute
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDNodeDAttributeEntry(PaletteDrawer root,
			DNodeDAttribute dattribute, ImageDescriptor smallIcon,
			ImageDescriptor largeIcon) {
		NodeAttribute attribute = dattribute.getNodeAttribute();
		Assert.isNotNull(attribute);
		Assert.isNotNull(attribute.getSource());
		Assert.isNotNull(attribute.getTarget());
		root.add(new DPFConnectionCreationToolEntry(attribute
				.getName(), "Create a new " + attribute.getName() + ":"
				+ attribute.getSource().getName() 
				+ "-->" + attribute.getTarget().getValue(),
				new DNodeDAttributeFactory(dattribute),
				smallIcon != null ? smallIcon : SMALLARROW,
				largeIcon != null ? largeIcon : LARGEARROW));
	}
	
	/**
	 * TODO 
	 * 
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dattribute
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDArrowDAttributeEntry(PaletteDrawer root, DArrowDAttribute dattribute, ImageDescriptor smallIcon,
			ImageDescriptor largeIcon) {
		ArrowAttribute attribute = dattribute.getArrowAttribute();
		Assert.isNotNull(attribute);
		Assert.isNotNull(attribute.getSource());
		Assert.isNotNull(attribute.getTarget());
		root.add(new DPFConnectionCreationToolEntry(attribute
				.getName(), "Create a new " + attribute.getName() + ":"
				+ attribute.getSource().getName() 
				+ "-->" + attribute.getTarget().getValue(),
				new DArrowDAttributeFactory(dattribute),
				smallIcon != null ? smallIcon : SMALLARROW,
				largeIcon != null ? largeIcon : LARGEARROW));
	}

	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param ddatanode
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDDataNodeEntry(PaletteDrawer root, DDataNode ddatanode, ImageDescriptor smallIcon,
			ImageDescriptor largeIcon) {
		
		Assert.isTrue(ddatanode != null);
		DataNode datanode = ddatanode.getDatanode();
		Assert.isTrue(datanode != null);
		
		String name = "";
		String datavalue = datanode.getValue();
		if(datavalue != null){
			name += datavalue;
		}
		
		root.add(new CreationToolEntry(name,
				"Create a new " + name, new DDataNodeFactory(
						ddatanode), smallIcon != null ? smallIcon
						: SMALLICON, largeIcon != null ? largeIcon
						: LARGEICON));
	}

	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param darrow
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDArrowEntry(PaletteDrawer root, DArrow darrow, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Arrow arrow = darrow.getArrow();
		Assert.isNotNull(arrow);
		Assert.isNotNull(arrow.getSource());
		Assert.isNotNull(arrow.getTarget());
		root.add(new DPFConnectionCreationToolEntry(arrow
				.getName(), "Create a new " + arrow.getName() + ":"
				+ arrow.getSource().getName() + "-->"
				+ arrow.getTarget().getName(),
				new DArrowFactory(darrow),
				smallIcon != null ? smallIcon : SMALLARROW,
				largeIcon != null ? largeIcon : LARGEARROW));
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param root
	 * @param dnode
	 * @param smallIcon
	 * @param largeIcon
	 */
	private void addDNodeEntry(PaletteDrawer root, DNode dnode, ImageDescriptor smallIcon, ImageDescriptor largeIcon) {
		Node node = dnode.getNode();
		Assert.isNotNull(node);
		root.add(new CreationToolEntry(node.getName(),
				"Create a new " + node.getName(), new DNodeFactory(
						dnode), smallIcon != null ? smallIcon
						: SMALLICON, largeIcon != null ? largeIcon
						: LARGEICON));
	}
}