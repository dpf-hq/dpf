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


public class ArrowConstraintLabelEditPart extends ArrowLabelEditPart {

	@Override
	protected boolean getVisible() {
		return true;
	}

	@Override
	protected boolean placeLabelAtEnd() {
		return true;
	}

	@Override
	protected String getFullName() {
		return getConnectionModel().getLabelText();
	}
	

}
