package protoedit.editparts.graphs;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;

import protomodel.Diagram;
import muvitorkit.gef.editparts.AdapterGraphicalEditPart;

public class DiagramEditPart extends AdapterGraphicalEditPart<Diagram> {

	public DiagramEditPart(Diagram model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IFigure createFigure() {
		return new FreeformLayer();
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}

}
