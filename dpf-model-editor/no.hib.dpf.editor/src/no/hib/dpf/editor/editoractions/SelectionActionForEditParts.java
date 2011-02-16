package no.hib.dpf.editor.editoractions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.parts.VArrowEditPart;
import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public abstract class SelectionActionForEditParts extends SelectionAction {

	protected Graph graph;

	public SelectionActionForEditParts(IWorkbenchPart part, String ID, Graph graph) {
		super(part);
		setId(ID);              // sets ID = joint image
		this.graph = graph;
	}
	
	/**
	 * Returns the selected arrows' contained EMF objects, NOT VArrows.
	 */
	protected EList<Arrow> getSelectionArrows() {
		EList<Arrow> selectionArrows = new BasicEList<Arrow>();
		for (VArrowEditPart vArrowEditPart : getSelectedConnectionEditParts()) {
			selectionArrows.add(vArrowEditPart.getModelAsEMFInstance());
		}
		return selectionArrows;
	}

	/**
	 * Returns the selected nodes' contained EMF objects, NOT VNodes.
	 */
	protected EList<Node> getSelectionNodes() {
		EList<Node> selectionNodes = new BasicEList<Node>();
		for (VNodeEditPart vNodeEditPart : getSelectedVNodeEditParts()) {
			selectionNodes.add(vNodeEditPart.getModelAsEMFInstance());
		}
		return selectionNodes;
	}

	protected EList<Node> addUnselectedNodesToSelection(EList<Node> selectionNodes, EList<Arrow> selectionArrows) {
		EList<Node> retval = new BasicEList<Node>(selectionNodes);		
		// Adds any nodes not selected, but directly connected to the selected edges
		for (Arrow arrow : selectionArrows) {
			addNodeToRetVal(retval, arrow.getSource());			
			addNodeToRetVal(retval, arrow.getTarget());			
		}
		return retval;
	}
	
	private void addNodeToRetVal(EList<Node> selectionNodes, Node node) {
		if (!nodeInList(selectionNodes, node)) {
			selectionNodes.add(node);
		}
	}	
	
	private boolean nodeInList(EList<Node> selectionNodes, Node node) {
		for (Node listNode : selectionNodes) {
			if (listNode.getId().equals(node.getId())) {
				return true;
			}
		}
		return false;
	}
	
	protected List<VArrowEditPart> getSelectedConnectionEditParts() {
		List<VArrowEditPart> vArrowEditParts = new ArrayList<VArrowEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof VArrowEditPart) {
				vArrowEditParts.add((VArrowEditPart)getSelectedObjects().get(i));
			}
		}
		return vArrowEditParts;
	}
	
	protected List<VNodeEditPart> getSelectedVNodeEditParts() {
		List<VNodeEditPart> vNodeEditParts = new ArrayList<VNodeEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof VNodeEditPart) {
				vNodeEditParts.add((VNodeEditPart)getSelectedObjects().get(i));
			}
		}
		return vNodeEditParts;
	}	
}
