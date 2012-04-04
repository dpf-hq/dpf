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
package no.hib.dpf.editor.actions;

import no.hib.dpf.diagram.DPredicate;

/**
 * Class for managing the properties needed to construct a constraint action.
 */
public class ConstraintProperties {
	
	private DPredicate predicate;
	private String text;
	private String tooltipText;
	
	public ConstraintProperties(DPredicate predicate, String text, String tooltipText) {
		this.predicate = predicate;
		this.text = text;
		this.tooltipText = tooltipText;
	}
	public ConstraintProperties(DPredicate predicate) {
		this.predicate = predicate;
		this.text = "Create new " + predicate.getPredicate().getSymbol() + " Constraint";
		this.tooltipText = "Creates a new " + predicate.getPredicate().getSymbol() + " Constraint";
	}

	public DPredicate getDPredicate() {
		return predicate;
	}

	public String getText() {
		return text;
	}

	public String getTooltipText() {
		return tooltipText;
	}
}
