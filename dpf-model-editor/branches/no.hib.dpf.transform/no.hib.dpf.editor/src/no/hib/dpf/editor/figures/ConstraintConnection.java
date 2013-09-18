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

import no.hib.dpf.editor.parts.DConstraintEditPart;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;

public class ConstraintConnection extends PolylineConnection implements RoutableFigure {
	
	protected DConstraintEditPart editPart;
	protected Label label;
	
	public ConstraintConnection(DConstraintEditPart constraintEditPart) {
		super();
		editPart = constraintEditPart;
		label = new Label();
		GridLayout layout = new GridLayout(1, true);
		layout.setConstraint(label, new GridData(SWT.CENTER, SWT.CENTER, true, true));
		setLayoutManager(layout);
		add(label);
	}
	@Override
	public int getRoutingPriority() {
		return 6;
	}
	public void outlineShape(Graphics graphics) {
		recompute();
		super.outlineShape(graphics);
	}
	public void recompute(){
		if(editPart.getConstraint() == null) return;
		String labelText = editPart.getConstraint().getPredicate().getSymbol();
		label.setText("[" + labelText + "]");
		label.setLocation(getBounds().getCenter());
	}
	private void updateAnchorOwner(ConnectionAnchor anchor){
		if(anchor != null && anchor.getOwner() != null)
			anchor.getOwner().validate();
	}
	
	public void validate() {
		updateAnchorOwner(getSourceAnchor());
		updateAnchorOwner(getTargetAnchor());
		super.validate();
	}
}