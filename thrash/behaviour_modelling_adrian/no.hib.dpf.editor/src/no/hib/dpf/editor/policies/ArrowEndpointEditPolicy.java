/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *     Øyvind Bech and Dag Viggo Lokøen - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.policies;

import org.eclipse.draw2d.PolylineConnection;

import org.eclipse.gef.GraphicalEditPart;

public class ArrowEndpointEditPolicy extends
		org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy {

	protected void addSelectionHandles() {
		super.addSelectionHandles();
		getConnectionFigure().setLineWidth(2);
	}

	protected PolylineConnection getConnectionFigure() {
		return (PolylineConnection) ((GraphicalEditPart) getHost()).getFigure();
	}

	protected void removeSelectionHandles() {
		super.removeSelectionHandles();
		getConnectionFigure().setLineWidth(0);
	}

}
