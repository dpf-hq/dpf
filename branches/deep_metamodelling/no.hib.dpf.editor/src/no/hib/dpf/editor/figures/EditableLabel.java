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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;

/**
 * A customized Label based on the label used in the flow example. Primary
 * selection is denoted by highlight and focus rectangle. Normal selection is
 * denoted by highlight only. Borrowed from the Flow Editor example
 * 
 * @author Daniel Lee
 */
public class EditableLabel extends Label {

	private Integer potency;
	private Integer mutability;
	private boolean selected;

	public EditableLabel(String text) {
		this(text, null, null);
	}
	
	public EditableLabel(String text, Integer potency, Integer mutability) {
		super(text);
		this.potency = potency;
		this.mutability = mutability;
	}

	private Rectangle getSelectionRectangle() {
		Rectangle bounds = getTextBounds().getCopy();
		bounds.expand(new Insets(2, 2, 0, 0));
		translateToParent(bounds);
		bounds.intersect(getBounds());
		return bounds;
	}

	/**
	 * paints figure differently depends on the whether the figure has focus or
	 * is selected
	 */
	@Override
	protected void paintFigure(Graphics graphics) {
		paintPotency(graphics);
		paintMutability(graphics);
		if (selected) {
			graphics.pushState();
			graphics.setBackgroundColor(ColorConstants.menuBackgroundSelected);
			graphics.fillRectangle(getSelectionRectangle());
			graphics.popState();
			graphics.setForegroundColor(ColorConstants.white);
		}
		super.paintFigure(graphics);
	}

	/**
	 * @author Ole Klokkhammer
	 * @param graphics
	 * @param potency
	 */
	private void paintPotency(Graphics graphics) {
		if(potency == null){
			return;
		}
		
		Rectangle r = getTextBounds();
		Display display = Display.getCurrent();
	    if (display == null){
	    	display = Display.getDefault();
	    }
	    
	    TextLayout superLayout = new TextLayout(display);
	    if(potency < 0){
	    	superLayout.setText("*");
	    } else{
	    	superLayout.setText("" + potency);
	    }
	    
	    // get font data
	    FontData data = display.getSystemFont().getFontData()[0];
	    Font font = new Font(display, data.getName(), (int)(data.getHeight() / 1.2), SWT.NORMAL);
	    superLayout.setFont(font);
	    
	    // rise the potency text
	    FontMetrics metrics = graphics.getFontMetrics();
	    final int baseline = metrics.getAscent() + metrics.getLeading();
	    final int smallBaseline = metrics.getAscent() + metrics.getLeading();
	    TextStyle superscript = new TextStyle(font, null, null);
	    superscript.rise =  baseline - smallBaseline;
	    superLayout.setStyle(superscript, 0, 5);
	   
	    // draw the potency text
		int xPos = r.x + r.width + 1;
		int yPos = r.y - 2;
	    graphics.setAntialias(SWT.ON);
		graphics.drawTextLayout(superLayout, xPos, yPos);
		
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param graphics
	 * @param potency
	 */
	private void paintMutability(Graphics graphics) {
		if(mutability == null){
			return;
		}
		
		Rectangle r = getTextBounds();
		Display display = Display.getCurrent();
	    if (display == null){
	    	display = Display.getDefault();
	    }
	    
	    TextLayout superLayout = new TextLayout(display);
	    if(mutability < 0){
	    	superLayout.setText("");
	    } else{
	    	superLayout.setText("   { " + mutability +" }");
	    }
	    
	    // get font data
	    FontData data = display.getSystemFont().getFontData()[0];
	    Font font = new Font(display, data.getName(), (int)(data.getHeight() / 1.35), SWT.NORMAL);
	    superLayout.setFont(font);
	    
	    // rise the mutability text
	    FontMetrics metrics = graphics.getFontMetrics();
	    final int baseline = metrics.getAscent() + metrics.getLeading();
	    final int smallBaseline = metrics.getAscent() + metrics.getLeading();
	    TextStyle superscript = new TextStyle(font, null, null);
	    superscript.rise =  baseline - smallBaseline;
	    superLayout.setStyle(superscript, 0, 5);
	   
	    // draw the potency text
		int xPos = r.x + r.width + 1;
		int yPos = r.y - 2;
	    graphics.setAntialias(SWT.ON);
		graphics.drawTextLayout(superLayout, xPos, yPos);
	}

	/**
	 * Sets the selection state of this SimpleActivityLabel
	 * 
	 * @param b
	 *            true will cause the label to appear selected
	 */
	public void setSelected(boolean b) {
		selected = b;
		repaint();
	}
}
