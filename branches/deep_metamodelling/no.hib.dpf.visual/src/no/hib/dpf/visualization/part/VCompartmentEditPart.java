package no.hib.dpf.visualization.part;

import java.util.List;

import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.figures.CompartmentFigure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;

public class VCompartmentEditPart extends GraphicalEditPartWithListener {
	
	@Override
	protected void listen(){
		super.listen();
		addUIAdapter((VCompartment)getModel(), modelListener);
	}
	
	@Override
	protected void unlisten(){
		removeUIAdapter((VCompartment)getModel(), modelListener);
		super.unlisten();
	}

	@Override
	protected IFigure createFigure() {
		return new CompartmentFigure(((VCompartment)getModel()).getName());
	}
	
	@Override
	public IFigure getContentPane(){
		return ((CompartmentFigure)getFigure()).getContentPane();
	}

	@Override
	protected void createEditPolicies() {
	}
	
	public VCompartment getCompartment() {
		return (VCompartment)getModel();
	}
	

	@Override
	protected List<VCompartmentElement> getModelChildren() {
		List<VCompartmentElement> list = getCompartment().getChildren();
		return list;
	}
	
	@Override
	protected void handleModelChanged(Notification msg) {
		refreshChildren();
	}
	
	@Override
	public DragTracker getDragTracker(Request request) {
	    if (REQ_SELECTION.equals(request.getType())) {
	        return getParent().getDragTracker(request);
	    } else return super.getDragTracker(request);
	}
}
