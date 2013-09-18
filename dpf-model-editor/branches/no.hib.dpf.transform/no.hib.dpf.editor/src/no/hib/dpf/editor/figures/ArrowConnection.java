/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;

/**
 * Experimental class. Should draw a point or similar halfway out on the first line.
 */
public class ArrowConnection extends PolylineConnection implements RoutableFigure {

	public ArrowConnection(){
		super();
		setForegroundColor(DPFEditorPreferences.getDefault().getArrowForegroundColor());
		setBackgroundColor(DPFEditorPreferences.getDefault().getArrowBackgroundColor());
		listenToArrowColorProperty();
	}
	private void listenToArrowColorProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if (event.getProperty().equals(PreferenceConstants.P_ARROW_BGCOLOR))
					setBackgroundColor(DPFEditorPreferences.getDefault().getArrowBackgroundColor());

				if (event.getProperty().equals(PreferenceConstants.P_ARROW_FGCOLOR))
					setForegroundColor(DPFEditorPreferences.getDefault().getArrowForegroundColor());
			}
		});

	}
	@Override
	protected void outlineShape(Graphics g) {
		g.pushState();
		g.setAntialias(SWT.ON); //FIXME: this is a hack, it should really be set globally somewhere?
		if (getLocalBackgroundColor() != null)
			g.setBackgroundColor(getBackgroundColor());
		if (getLocalForegroundColor() != null){
			g.setForegroundColor(getForegroundColor());
			if(invalid) 
				g.setForegroundColor(DPFEditorPreferences.getDefault().getArrowValidationErrorColor());
		}
		super.outlineShape(g);
		g.popState();
	}


	public Rectangle getOwnerBounds() {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof NodeFigure)) {
			return ((NodeFigure)getSourceAnchor().getOwner()).getBounds().getCopy();
		}
		return null;
	}

	public boolean invalid = false;
	public void setErrorImageFlag(boolean bool) {
		if(invalid != bool){
			invalid = bool;
			revalidate();
			repaint();
		}		
	}
	@Override
	public int getRoutingPriority() {
		return 6;
	}

}
