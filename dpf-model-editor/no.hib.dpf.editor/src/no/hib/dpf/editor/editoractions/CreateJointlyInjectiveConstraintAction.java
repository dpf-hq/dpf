package no.hib.dpf.editor.editoractions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.DPFDiagram;
import no.hib.dpf.editor.model.commands.ConstraintCreateCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJointlyInjectiveConstraintAction extends SelectionAction {
	
	private Graph graph;
	
	// an identifier for the action
	public static final String ID="no.hib.dpf.editor.editoractions.CreateJointlyInjectiveConstraintAction";	

	public CreateJointlyInjectiveConstraintAction(IWorkbenchPart part, DPFDiagram diagram) {
		super(part);
		setId(ID);              // sets ID = joint image
		setText("Create new Jointly Injective Constraint"); // sets text displayed in the menu
		setToolTipText("Creates a new Jointly Injective Constraint");
		this.graph = diagram.getDpfGraph();
	}

	private List<ConnectionEditPart> getSelectedConnectionEditParts() {
		List<ConnectionEditPart> connectionEditParts = new ArrayList<ConnectionEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ConnectionEditPart) {
				connectionEditParts.add((ConnectionEditPart)getSelectedObjects().get(i));
			}
		}
		return connectionEditParts;
	}
	
	private List<ShapeEditPart> getSelectedShapeEditParts() {
		List<ShapeEditPart> shapeEditParts = new ArrayList<ShapeEditPart>();
		for (int i = 0; i < getSelectedObjects().size(); i++) {
			if (getSelectedObjects().get(i) instanceof ShapeEditPart) {
				shapeEditParts.add((ShapeEditPart)getSelectedObjects().get(i));
			}
		}
		return shapeEditParts;
	}

	@Override
	protected boolean calculateEnabled() {
		// we only want enabled if one node w/two outgoing edges are selected.
		// TODO: Make this configurable
		
		Predicate testPredicate = MetamodelFactory.eINSTANCE.createPredicate("n_1", "e_1:null:n_1,e_2:null:n_1");
						
		no.hib.dpf.metamodel.Constraint constraint =
			testPredicate.createConstraint(getSelectionNodes(), getSelectionEdges(), graph);
		return (constraint != null);
		
	}

	private EList<Edge> getSelectionEdges() {
		EList<Edge> edges = new BasicEList<Edge>();
		for (ConnectionEditPart connectionEditPart : getSelectedConnectionEditParts()) {
			edges.add((Edge)connectionEditPart.getModel());
		}
		return edges;
	}

	private EList<Node> getSelectionNodes() {
		EList<Node> nodes = new BasicEList<Node>();
		for (ShapeEditPart shapeEditPart : getSelectedShapeEditParts()) {
			nodes.add((Node)shapeEditPart.getModel());
		}
		return nodes;
	}

	
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		List<ConnectionEditPart> connectionEditParts = getSelectedConnectionEditParts();
		List<ShapeEditPart> shapeEditParts = getSelectedShapeEditParts();
		
		// Any EditPart can access its viewer
		EditPartViewer viewer = shapeEditParts.get(0).getViewer();

		// Deselect an existing selection
		viewer.deselectAll();

		// Flush this
		viewer.flush();
		
// TODO: make ConstraintElement dependant on a "Real" constraint...
		ConstraintCreateCommand constraintCreateCommand = new ConstraintCreateCommand((Connection)connectionEditParts.get(0).getModel(), (Connection)connectionEditParts.get(1).getModel(), ConstraintElement.SOLID_CONNECTION);
		
		execute(constraintCreateCommand);
	}
	
	
}
