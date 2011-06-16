package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
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
		
		if (!deselectInViewer(connectionEditParts)) {
			deselectInViewer(shapeEditParts);
		}
		execute(getConstraintCreateCommand(connectionEditParts, shapeEditParts));
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
