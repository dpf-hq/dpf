package no.hib.dpf.visualization.presentation;

import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.visualization.VCompartment;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

public class VCompartmentEditPart extends GraphicalEditPartWithListener {

	VCompartment compartment = null;
	
	public VCompartmentEditPart(VCompartment compartment) {
		this.compartment = compartment;
	}
	
	@Override
	protected IFigure createFigure() {
		//DNode dNode = DiagramFactory.eINSTANCE.createDefaultDNode();
		//compartment.addChild(dNode);
		return null;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}

}
