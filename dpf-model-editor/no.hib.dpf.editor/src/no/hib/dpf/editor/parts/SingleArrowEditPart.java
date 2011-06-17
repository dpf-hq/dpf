/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.displaymodel.SingleNodeConnection;
import no.hib.dpf.editor.figures.EpiArrowConnection;

public class SingleArrowEditPart extends ArrowEditPart {

	@Override
	protected void createConnectionFigure() { // EditableLabel label) {
		connectionFigure = new EpiArrowConnection(); //label);
	}
	
	@Override
	protected SingleNodeConnection getCastedModel() {
		return (SingleNodeConnection)getModel();
	}
	
	
}
