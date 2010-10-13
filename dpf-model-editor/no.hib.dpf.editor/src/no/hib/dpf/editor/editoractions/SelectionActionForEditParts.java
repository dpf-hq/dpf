package no.hib.dpf.editor.editoractions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.model.DPFDiagram;
import no.hib.dpf.editor.parts.ShapeEditPart;
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

	public SelectionActionForEditParts(IWorkbenchPart part, String ID, DPFDiagram diagram) {
		super(part);
		setId(ID);              // sets ID = joint image
		this.graph = diagram.getDpfGraph();
	}
	
	protected EList<Edge> getSelectionEdges() {
		EList<Edge> edges = new BasicEList<Edge>();
		for (ConnectionEditPart connectionEditPart : getSelectedConnectionEditParts()) {
			edges.add((Edge)connectionEditPart.getModel());
		}
		return edges;
	}

	protected EList<Node> getSelectionNodes() {
		EList<Node> nodes = new BasicEList<Node>();
		for (ShapeEditPart shapeEditPart : getSelectedShapeEditParts()) {
			nodes.add((Node)shapeEditPart.getModel());
		}
		return nodes;
	}	

	// TODO: make private after refactoring
	protected List<ConnectionEditPart> getSelectedConnectionEditParts() {
		List<ConnectionEditPart> connectionEditParts = new ArrayList<ConnectionEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ConnectionEditPart) {
				connectionEditParts.add((ConnectionEditPart)getSelectedObjects().get(i));
			}
		}
		return connectionEditParts;
	}
	
	protected List<ShapeEditPart> getSelectedShapeEditParts() {
		List<ShapeEditPart> shapeEditParts = new ArrayList<ShapeEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ShapeEditPart) {
				shapeEditParts.add((ShapeEditPart)getSelectedObjects().get(i));
			}
		}
		return shapeEditParts;
	}	
}
