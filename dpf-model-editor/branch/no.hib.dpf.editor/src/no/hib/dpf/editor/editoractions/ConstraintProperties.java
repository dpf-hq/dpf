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
package no.hib.dpf.editor.editoractions;

import no.hib.dpf.core.Predicate;
import no.hib.dpf.editor.displaymodel.DConstraint;

/**
 * Class for managing the properties needed to construct a constraint action.
 */
public class ConstraintProperties {
	
	private Predicate predicate;
	private String text;
	private String tooltipText;
	private DConstraint.ConstraintType constraintType;
	
	public ConstraintProperties(Predicate predicate, String text, String tooltipText, DConstraint.ConstraintType constraintType) {
		this.predicate = predicate;
		this.text = text;
		this.tooltipText = tooltipText;
		this.constraintType = constraintType;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public String getText() {
		return text;
	}

	public String getTooltipText() {
		return tooltipText;
	}

	public DConstraint.ConstraintType getConstraintType() {
		return constraintType;
	}

}
