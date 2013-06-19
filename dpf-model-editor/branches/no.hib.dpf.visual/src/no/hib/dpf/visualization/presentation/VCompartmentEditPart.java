package no.hib.dpf.visualization.presentation;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;

import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.figures.CompartmentFigure;

public class VCompartmentEditPart extends GraphicalEditPartWithListener {
	
	/**
     * Listener for the node notifications
     */
    protected UIAdapter listener = new UIAdapter()
    {
        /**
         * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        protected void safeNotifyChanged(Notification msg)
        {
        	refreshChildren();
        }

    };
    
    protected void listen(){
		super.listen();
		addUIAdapter((VCompartment)getModel(), listener);
	}
	
	protected void unlisten(){
		removeUIAdapter((VCompartment)getModel(), listener);
		super.unlisten();
	}

	@Override
	protected IFigure createFigure() {
		return new CompartmentFigure(((VCompartment)getModel()).getName());
	}
	
	public IFigure getContentPane(){
		return ((CompartmentFigure)getFigure()).getContentPane();
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}
	
	public VCompartment getCompartment() {
		return (VCompartment)getModel();
	}

	@Override
	protected List<VCompartmentElement> getModelChildren() {
		return getCompartment().getChildren();
	}
}
