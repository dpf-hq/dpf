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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.editor.parts.ArrowEditPart;
import no.hib.dpf.editor.parts.NodeEditPart;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.ui.IWorkbenchPart;

public abstract class CreateConstraintAction extends SelectionActionForEditParts {

	private Predicate testPredicate;
	private EList<Arrow> selectionArrows;
	private EList<Node> selectionNodes;
	
	public CreateConstraintAction(IWorkbenchPart part, String ID, Graph graph, ConstraintProperties constraintProperties) {
		super(part, ID, graph);
		setText(constraintProperties.getText());
		setToolTipText(constraintProperties.getTooltipText());
		this.testPredicate = constraintProperties.getPredicate();
		if(constraintProperties.getConstraintType() == null)
			return;
		switch (constraintProperties.getConstraintType()) {
		case INVERSE: 
			setImageDescriptor(ImageSettings.INVERSE.getImageDescriptor());
			break;
		case JOINTLY_INJECTIVE:
			setImageDescriptor(ImageSettings.JOINTLY_INJECTIVE.getImageDescriptor());
			break;
		case JOINTLY_SURJECTIVE:
			setImageDescriptor(ImageSettings.JOINTLY_SURJECTIVE.getImageDescriptor());
			break;
		case MULTIPLICITY:
			setImageDescriptor(ImageSettings.MULTIPLICITY.getImageDescriptor());
			break;
		case IMAGE_INCLUSION:
			setImageDescriptor(ImageSettings.IMAGE_INCLUSION.getImageDescriptor());
			break;
		case COMPOSITION:
			setImageDescriptor(ImageSettings.COMPOSITION.getImageDescriptor());
			break;
		case INJECTIVE:
			setImageDescriptor(ImageSettings.INJECTIVE.getImageDescriptor());
			break;
		case SURJECTIVE:
			setImageDescriptor(ImageSettings.SURJECTIVE.getImageDescriptor());
			break;
		case IRREFLEXIVE:
			setImageDescriptor(ImageSettings.IRREFLEXIVE.getImageDescriptor());
			break;
		case TRANSITIVE_IRREFLEXIVE:
			setImageDescriptor(ImageSettings.TRANSITIVE_IRREFLEXIVE.getImageDescriptor());
			break;
		case XOR:
			setImageDescriptor(ImageSettings.XOR.getImageDescriptor());
			break;
		case NAND:
			setImageDescriptor(ImageSettings.NAND.getImageDescriptor());
			break;
		}
	}
	
	@Override
	protected boolean calculateEnabled() {
		EList<Arrow> selectionArrows = getSelectionArrows();
		EList<Node> selectionNodes = getSelectionNodes();
		if (testPredicate.canCreateConstraint(addUnselectedNodesToSelection(selectionNodes, selectionArrows), selectionArrows, graph)) {
			// Keep the selection arrows and nodes from the last successfull enabled-calculation.
			// The reason for this is: as the "createIDObject" method is called, the user has already de-selected the arrows and nodes.
			this.selectionArrows = selectionArrows;
			this.selectionNodes = selectionNodes;
			return true;
		}
		return false;
	}	
	
	/*
	 * Must trust that calculateEnabled has been called by GEF, and that selected arrows and nodes are kept.
	 */
	protected Constraint createIDObject() {
		if (testPredicate.canCreateConstraint(addUnselectedNodesToSelection(selectionNodes, selectionArrows), selectionArrows, graph)) {			
			return testPredicate.createConstraint(addUnselectedNodesToSelection(selectionNodes, selectionArrows), selectionArrows, graph);
		}
		return null;
	}
	
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		List<ArrowEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<NodeEditPart> shapeEditParts = getSelectedVNodeEditParts();
		
		execute(getConstraintCreateCommand(connectionEditParts, shapeEditParts));
		if (!deselectInViewer(connectionEditParts)) {
			deselectInViewer(shapeEditParts);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private boolean deselectInViewer(List editParts) {
		if (editParts.size() < 1) {
			return false;	
		}
		// Any EditPart can access its viewer
		EditPartViewer viewer = ((AbstractEditPart)editParts.get(0)).getViewer();
		// Deselect an existing selection
		viewer.deselectAll();
		// Flush this
		viewer.flush();
		return true;
	}
	
	protected abstract Command getConstraintCreateCommand(List<ArrowEditPart> connectionEditParts, List<NodeEditPart> shapeEditParts);
	
}
