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
package no.hib.dpf.editor.displaymodel;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * Extracted from Shape. Validates integer properties.
 */
public class IntegerTextPropertyDescriptor extends TextPropertyDescriptor {
	
	public IntegerTextPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
		super.setValidator(new IntegerCellEditorValidator());
	}

	private class IntegerCellEditorValidator implements ICellEditorValidator {

		@Override
		public String isValid(Object value) {
			int intValue = -1;
			try {
				intValue = Integer.parseInt((String) value);
			} catch (NumberFormatException exc) {
				return "Not a number";
			}
			return (intValue >= 0) ? null : "Value must be >=  0";
		}
		
	}	
}

