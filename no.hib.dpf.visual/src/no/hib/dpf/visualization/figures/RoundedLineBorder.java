/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.visualization.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class RoundedLineBorder extends LineBorder {
	protected int arcLength;
	protected int lineStyle = Graphics.LINE_SOLID;

	public RoundedLineBorder(Color c, int width, int arcLength) {
		super(c, width);
		this.arcLength = arcLength;
	}

	public RoundedLineBorder(int width, int arcLength) {
		super(width);
		this.arcLength = arcLength;
	}

	public RoundedLineBorder(Color c, int width, int arcLength, int lineStyle) {
		super(c, width);
		this.arcLength = arcLength;
		this.lineStyle = lineStyle;
	}

	public RoundedLineBorder(int width, int arcLength, int lineStyle) {
		super(width);
		this.arcLength = arcLength;
		this.lineStyle = lineStyle;
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));
		int width = getWidth();
		Color color = getColor();
		if (width % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}
		tempRect.shrink(width / 2, width / 2);
		
		graphics.setLineWidth(width);
		graphics.setLineStyle(lineStyle);
		if (color != null){
			graphics.setForegroundColor(color);
		}
		graphics.setAntialias(SWT.ON); 
		graphics.drawRoundRectangle(tempRect, arcLength, arcLength);
	}
}