package no.hib.dpf.visualization.presentation;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;

import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.figures.CompartmentFigure;

public class VCompartmentEditPart extends GraphicalEditPartWithListener {

	@Override
	protected IFigure createFigure() {
		return new CompartmentFigure(((VCompartment)getModel()).getName());
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}

}
