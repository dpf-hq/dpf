package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.DPFEpiConnectionFigure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;

public class ShapeSingleConnectionEditPart extends ShapeConnectionEditPart {

	
	@Override
	protected IFigure createFigure() {
		connectionFigure = new DPFEpiConnectionFigure();
//		PolygonDecoration arrowHead = new PolygonDecoration();
//		arrowHead.setScale(16, 6);
//		connectionFigure.setTargetDecoration(arrowHead); // arrow at target endpoint
		return connectionFigure;
	}

}
