package no.hib.dpf.editor.editoractions;

import java.util.List;

import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.ui.IWorkbenchPart;

public abstract class CreateConstraintAction extends SelectionActionForEditParts {

	private Predicate testPredicate; 
	
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
		return testPredicate.canCreateConstraint(addUnselectedNodesToSelection(selectionNodes, selectionArrows), selectionArrows, graph);
	}	

	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<VNodeEditPart> shapeEditParts = getSelectedShapeEditParts();
		
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
	
	protected abstract Command getConstraintCreateCommand(List<ConnectionEditPart> connectionEditParts, List<VNodeEditPart> shapeEditParts);
	
}
