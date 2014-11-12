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
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * 
 * @author Ole Klokkhammer
 */
public abstract class AbstractDPFEditorPaletteFactory {

	public final static ImageDescriptor SMALLARROW = ImageSettings.SMALL_CONNECTION.getImageDescriptor();
	public final static ImageDescriptor LARGEARROW = ImageSettings.LARGE_CONNECTION.getImageDescriptor();
	public static final ImageDescriptor SMALLICON = ImageSettings.SMALL_RECTANGLE.getImageDescriptor();
	public static final ImageDescriptor LARGEICON = ImageSettings.LARGE_RECTANGLE.getImageDescriptor();
	
	private static final String LINGUISTIC_ELEMENTS = "Linguistic Elements";
	private static final String DOMAIN_SPECIFIC_ELEMENTS = "DSL Elements";
	private static final String TEMPLATE_ELEMENTS = "Template Elements";

	protected PaletteDrawer linguisticElementsGroup = new PaletteDrawer(LINGUISTIC_ELEMENTS);
	protected PaletteDrawer domainSpecificElementsGroup = new PaletteDrawer(DOMAIN_SPECIFIC_ELEMENTS);
	protected PaletteDrawer templateElementsGroup = new PaletteDrawer(TEMPLATE_ELEMENTS);
	protected PaletteRoot palette;
	
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
		mqtool.setToolProperty(
				MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR,
				MarqueeSelectionTool.BEHAVIOR_NODES_CONTAINED_AND_RELATED_CONNECTIONS);

		toolbar.add(mqtool);

		return toolbar;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @return
	 */
	protected boolean canAdd(Node node) {
		if (node.getPotency() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @return
	 */
	protected boolean canAdd(Arrow arrow) {
		if(arrow.getTemplateElementType().equals(DPFCoreConstants.ARROW_ATTRIBUTE)){
			if(!arrow.eIsSet(CorePackage.Literals.DEEP_ELEMENT__POTENCY) || arrow.getPotency() == 1){
				return true;
			}
		}else{
			if (arrow.getPotency() != 0) {
				return true;
			}			
		}
		return false;
	}
}