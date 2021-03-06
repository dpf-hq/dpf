/*******************************************************************************
 * Copyright (c) 2011 Hï¿½yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ï¿½yvind Bech and Dag Viggo Lokï¿½en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

public class NodeFigure extends Figure implements RoutableFigure {

	protected EditableLabel nameLabel;
	public static final org.eclipse.swt.graphics.Image IMAGE = ImageSettings.IMG_ERROR.getImage();

	public boolean isStandard = true;
	public Color backgroundColor = null;
	public NodeFigure(EditableLabel name) {
		nameLabel = name;
		GridLayout layout = new GridLayout(1, true);
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(DPFEditorPreferences.getDefault().getNodeBackgroundColor());
		setForegroundColor(DPFEditorPreferences.getDefault().getNodeForegroundColor());
		setOpaque(true);
		name.setForegroundColor(DPFEditorPreferences.getDefault().getNodeForegroundColor());
		add(nameLabel);
		layout.setConstraint(nameLabel, new GridData(SWT.CENTER, SWT.CENTER, true, true));
		setOpaque(true); // non-transparent figure
		listenToNodeColorProperty();
	}

	public NodeFigure(){ }

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
				if (isStandard && event.getProperty().equals(PreferenceConstants.P_NODE_BGCOLOR)){
					backgroundColor = DPFEditorPreferences.getDefault().getNodeBackgroundColor();
					setBackgroundColor(backgroundColor);
					
				}

				if (isStandard && event.getProperty().equals(PreferenceConstants.P_NODE_FGCOLOR))
					setForegroundColor(DPFEditorPreferences.getDefault().getNodeForegroundColor());
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public NodeFigure(EditableLabel name, List colums) {
		super();
		
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
	public boolean valid = false;

	@Override
	protected void paintChildren(Graphics graphics) {
		if(valid)
			graphics.drawImage(IMAGE, getBounds().x(),getBounds().y());
		super.paintChildren(graphics);
	}

	public void setErrorFlag(boolean bool) {
		if(valid != bool){
			valid = bool;
			repaint();
		}
	}
	
	public void setBounds(Rectangle rect) {
		boolean resize = (rect.width != bounds.width)
				|| (rect.height != bounds.height);
		super.setBounds(rect);
		if(resize)
			revalidate();
	}

	public IFigure getLabel() {
		return nameLabel.getLabel();
	}
}