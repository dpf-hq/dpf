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
package no.hib.dpf.uconstraint.presentation;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public abstract class SelectionActionForEditParts extends SelectionAction {


	public SelectionActionForEditParts(IWorkbenchPart part, String ID) {
		super(part);
		setId(ID);
	}
	
	protected void getSelectElements(EList<DNode> nodes, EList<DArrow> arrows){
		for(Object object : getSelectedObjects()){
			if(object instanceof DNodeEditPart)
				addDNode(nodes, ((DNodeEditPart)object).getDNode());
			if(object instanceof DArrowEditPart)
				addDArrow(nodes, arrows, ((DArrowEditPart)object).getDArrow());
		}
	}
	
	private void addDNode(EList<DNode> nodes, DNode node){
		if(node != null && !nodes.contains(node))
			nodes.add(node);
	}
	
	private void addDArrow(EList<DNode> nodes, EList<DArrow> arrows, DArrow arrow){
		if(arrow != null && !arrows.contains(arrow))
			arrows.add(arrow);
		addDNode(nodes, arrow.getDSource());
		addDNode(nodes, arrow.getDTarget());
	}
}
