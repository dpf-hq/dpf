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
package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.core.Graph;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.commands.MultipleArrowConstraintCreateCommand;
import no.hib.dpf.editor.parts.ArrowEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

public class CreateInverseConstraintAction extends CreateConstraintAction {
	public static final String ID = "no.hib.dpf.editor.editoractions.CreateInverseConstraintAction";
	
	public CreateInverseConstraintAction(IWorkbenchPart part, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph, constraintProperties);
	}
	
	@Override
	protected Command getConstraintCreateCommand(List<ArrowEditPart> connectionEditParts, List<NodeEditPart> shapeEditParts) {
		return new MultipleArrowConstraintCreateCommand((DArrow)connectionEditParts.get(0).getModel(), (DArrow)connectionEditParts.get(1).getModel(), DConstraint.ConstraintType.INVERSE, createIDObject());
	}

}
