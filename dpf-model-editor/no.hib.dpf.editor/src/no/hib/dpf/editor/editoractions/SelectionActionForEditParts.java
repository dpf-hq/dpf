package no.hib.dpf.editor.editoractions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.parts.VEdgeEditPart;
import no.hib.dpf.editor.parts.VNodeEditPart;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public abstract class SelectionActionForEditParts extends SelectionAction {

	protected Graph graph;

	public SelectionActionForEditParts(IWorkbenchPart part, String ID, Graph graph) {
		super(part);
		setId(ID);              // sets ID = joint image
		this.graph = graph;
	}
	
	protected EList<Edge> getSelectionEdges() {
		EList<Edge> edges = new BasicEList<Edge>();
		for (ConnectionEditPart connectionEditPart : getSelectedConnectionEditParts()) {
			edges.add((Edge)connectionEditPart.getModel());
		}
		return edges;
	}

	protected EList<Node> getSelectionNodes() {
		EList<Node> selectionNodes = new BasicEList<Node>();
		for (VNodeEditPart shapeEditPart : getSelectedShapeEditParts()) {
			selectionNodes.add((Node)shapeEditPart.getModel());
		}
		// Add any nodes not selected, but directly connected to the selected edges
		return selectionNodes;
	}

	protected EList<Node> addUnselectedNodesToSelection(EList<Node> selectionNodes, EList<Edge> selectionEdges) {
		for (Edge edge : selectionEdges) {
			addNodeToRetVal(selectionNodes, edge.getSource());			
			addNodeToRetVal(selectionNodes, edge.getTarget());			
		}
		return selectionNodes;
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
	
	protected List<ConnectionEditPart> getSelectedConnectionEditParts() {
		List<ConnectionEditPart> connectionEditParts = new ArrayList<ConnectionEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof VEdgeEditPart) {
				connectionEditParts.add((ConnectionEditPart)getSelectedObjects().get(i));
			}
		}
		return connectionEditParts;
	}
	
	protected List<VNodeEditPart> getSelectedShapeEditParts() {
		List<VNodeEditPart> shapeEditParts = new ArrayList<VNodeEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof VNodeEditPart) {
				shapeEditParts.add((VNodeEditPart)getSelectedObjects().get(i));
			}
		}
		return shapeEditParts;
	}	
}
