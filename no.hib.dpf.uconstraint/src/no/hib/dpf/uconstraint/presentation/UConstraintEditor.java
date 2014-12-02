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
package no.hib.dpf.uconstraint.presentation;

import no.hib.dpf.uconstraint.UConstraint;

import org.eclipse.gef.GraphicalViewer;
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
public abstract class UConstraintEditor extends GraphicalEditorWithFlyoutPalette{

	/** This is the root of the editor's model. */

	protected UConstraint uconstraint;

	protected PaletteRoot paletteRoot;

	protected DPFConstraintsPaletteFactory paletteFactory;

	protected PropertySheetPage propertySheetPage;

	public void setUConstraint(UConstraint prod){
		uconstraint = prod;
	}

	public UConstraintEditor(){
		paletteFactory = new DPFConstraintsPaletteFactory();
	}

	public DPFConstraintsPaletteFactory getpaletteFactory(){
		return paletteFactory;
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

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}
};