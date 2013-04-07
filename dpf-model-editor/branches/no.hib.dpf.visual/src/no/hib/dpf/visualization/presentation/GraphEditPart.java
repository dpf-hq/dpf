package no.hib.dpf.visualization.presentation;


import java.util.List;

import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class GraphEditPart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		IFigure figure = new FreeformLayer();
		figure.setBorder(new MarginBorder(3));
		figure.setLayoutManager(new FreeformLayout());
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		
	}
	protected List<Node> getModelChildren() {
		return getGraph().getNodes();
	}

	private Graph getGraph() {
		return (Graph) getModel();
	}
	
}
