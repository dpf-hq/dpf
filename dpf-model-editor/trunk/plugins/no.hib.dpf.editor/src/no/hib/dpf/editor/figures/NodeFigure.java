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

import java.util.List;

import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class NodeFigure extends Figure implements RoutableFigure {

	public static Color tableColor = new Color(null, 255, 255, 206);
	protected EditableLabel nameLabel;

	public NodeFigure(EditableLabel name) {
		this(name, null);
		setOpaque(true); // non-transparent figure
		setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
		listenToNodeColorProperty();
		
	}
	
	public NodeFigure(){}

	
	/**
	 * Returns the leftmost figure of two, calculated from the centre.
	 * If both figure's centres are equal, the lowest figure is returned.
	 */
	public NodeFigure getLeftmostOrLowest(NodeFigure nodeFigure) {
		
		Rectangle myRect = getBounds();
		Rectangle otherRect = nodeFigure.getBounds();
		
		float myCenterX = myRect.x + 0.5f * myRect.width;
		float myCenterY = myRect.y + 0.5f * myRect.height;

		float otherCenterX = otherRect.x + 0.5f * otherRect.width;
		float other2CenterY = otherRect.y + 0.5f * otherRect.height;
		
		if ((myCenterX < otherCenterX) ||
			((myCenterX == otherCenterX) && (myCenterY < other2CenterY))) {
			return this;
		}
		
		return nodeFigure;
	}
	
	protected void listenToNodeColorProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if (event.getProperty().equals(PreferenceConstants.P_NODE_COLOR)) {
					setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
					repaint();
				}
			}
		});
	}
	
	@SuppressWarnings("rawtypes")
	public NodeFigure(EditableLabel name, List colums) {

		nameLabel = name;
		GridLayout layout = new GridLayout(1, true);
		layout.setConstraint(nameLabel, new GridData(SWT.CENTER, SWT.CENTER, true, true));
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(tableColor);
		setForegroundColor(ColorConstants.black);
		setOpaque(true);

		name.setForegroundColor(ColorConstants.black);
		add(name);

	}

	/**
	 * @return returns the label used to edit the name
	 */
	public EditableLabel getNameLabel()
	{
		return nameLabel;
	}

	@Override
	public int getRoutingPriority() {
		return 0;
	}

	private static final Color[] colors = {DPFEditorPreferences.getDefault().getNodeColor(), ColorConstants.green, ColorConstants.darkGreen};
	public void showFeedBack(int state) {
		setBackgroundColor(colors[state]);
	}
}