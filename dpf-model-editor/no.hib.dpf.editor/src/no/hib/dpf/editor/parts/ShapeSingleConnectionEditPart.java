package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.DPFEpiConnectionFigure;

import org.eclipse.draw2d.IFigure;

public class ShapeSingleConnectionEditPart extends ShapeConnectionEditPart {

	@Override
	protected IFigure createFigure() {
		connectionFigure = new DPFEpiConnectionFigure();			
		return connectionFigure;
	}

}
