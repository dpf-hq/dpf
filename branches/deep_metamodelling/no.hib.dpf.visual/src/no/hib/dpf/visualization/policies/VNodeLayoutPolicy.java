package no.hib.dpf.visualization.policies;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.commands.ChildDNodeCreateCommand;
import no.hib.dpf.visualization.part.VNodeEditPart;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

public class VNodeLayoutPolicy extends LayoutEditPolicy {

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return null;
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		VNodeEditPart editpart =(VNodeEditPart)getHost();
		Object childClass = request.getNewObjectType();
		if (childClass == VCompartmentElement.class) {
			
			// create a new compartmentElement and set its location:
			VCompartmentElement newCompartmentElement = (VCompartmentElement)request.getNewObject();
			newCompartmentElement.getDNode().setLocation(editpart.getDiagramModel().getLocation());
			
			// check the current editparts compartments to see if it can be added
			for(VCompartment compartment : editpart.getCompartments()) {
					
				if(VisualizationModelUtils.canAdd(newCompartmentElement, compartment)){
					DGraph currentDGraph = (DGraph)editpart.getParent().getModel();
					DNode newDNode = newCompartmentElement.getDNode();
					DNode parentDNode = editpart.getDiagramModel();
					
					// sanity check
					if(currentDGraph == null || newDNode == null || parentDNode == null){
						return null;
					}
					
					return new ChildDNodeCreateCommand(newDNode, parentDNode, compartment, currentDGraph);
				}
			}
		}
		return null;
	}
	
	

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
