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

/**
 * A customized Label based on the label used in the flow example. 
 * Primary selection is denoted by highlight and focus rectangle. 
 * Normal selection is denoted by highlight only. Borrowed from the Flow Editor example
 * @author Daniel Lee
 */
public class EditableLabel extends Label
{

	private boolean selected;
	
	public EditableLabel(String text)
	{
		super(text);
		setForegroundColor(ColorConstants.black);
	}
	
	private Rectangle getSelectionRectangle()
	{
		Rectangle bounds = getTextBounds().getCopy();
		bounds.expand(new Insets(2, 2, 0, 0));
		translateToParent(bounds);
		bounds.intersect(getBounds());
		return bounds;
	}

	/**
	 * paints figure differently depends on the whether the figure has focus or is selected 
	 */
	protected void paintFigure(Graphics graphics)
	{
		if (selected)
		{
			graphics.pushState();
			graphics.setBackgroundColor(ColorConstants.menuBackgroundSelected);
			graphics.fillRectangle(getSelectionRectangle());
			graphics.popState();
			graphics.setForegroundColor(ColorConstants.white);
		}
		super.paintFigure(graphics);
	}

	/**
	 * Sets the selection state of this SimpleActivityLabel
	 * 
	 * @param b
	 *            true will cause the label to appear selected
	 */
	public void setSelected(boolean b)
	{
		selected = b;
		repaint();
	}


}


