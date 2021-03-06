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
package no.hib.dpf.editor.signature;

import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_TYPE_DGRAPH;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.editor.DPFEditorPaletteFactory;
import no.hib.dpf.editor.parts.DPFEditPartFactory;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite;
import org.eclipse.gef.ui.palette.FlyoutPaletteComposite.FlyoutPreferences;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * A graphical editor with flyout palette that can edit .dpf files. The
 * binding between the .dpf file extension and this editor is done in
 * plugin.xml
 * 
 * @author Elias Volanakis
 */
public abstract class PredicateEditor extends GraphicalEditorWithFlyoutPalette{

	/** This is the root of the editor's model. */

	protected DPredicate dPredicate;

	//	/** Palette component, holding the tools and shapes. */
	private PaletteRoot paletteRoot;

	private DPFEditPartFactory shapesEditPartFactory;
	private DPFEditorPaletteFactory paletteFactory;

	protected PropertySheetPage propertySheetPage;


	public PredicateEditor(){
		paletteFactory = new DPFEditorPaletteFactory();
	}
	/**
	 * Configure the graphical viewer before it receives contents.
	 * <p>
	 * This is the place to choose an appropriate RootEditPart and
	 * EditPartFactory for your editor. The RootEditPart determines the behavior
	 * of the editor's "work-area". For example, GEF includes zoomable and
	 * scrollable root edit parts. The EditPartFactory maps model elements to
	 * edit parts (controllers).
	 * </p>
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		paletteFactory.updatePalette(getPaletteRoot(), REFLEXIVE_TYPE_DGRAPH);
		shapesEditPartFactory = new DPFEditPartFactory();
		viewer.setEditPartFactory(shapesEditPartFactory);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		ContextMenuProvider cmProvider = new SignatureEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}

	

	@Override
	protected FlyoutPreferences getPalettePreferences() {
		FlyoutPreferences retval = super.getPalettePreferences();
		retval.setPaletteState(FlyoutPaletteComposite.STATE_PINNED_OPEN);
		retval.setPaletteWidth(200);
		return retval;
	}


	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		if (paletteRoot == null) {
			paletteRoot = paletteFactory.createPalette();
		}
		return paletteRoot;
	}
}