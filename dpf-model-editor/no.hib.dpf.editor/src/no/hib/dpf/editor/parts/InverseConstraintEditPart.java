package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.OppositeArrowsConstraintConnection;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Inverse constraint elements.
 */
class InverseConstraintEditPart extends OppositeArrowsConstraintEditPart {

	public InverseConstraintEditPart() {
		super(false);
	}

	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(false);
	}
	
	@Override
	protected IFigure createFigureExec() {
		return new OppositeArrowsConstraintConnection(this, "[inv]");
	}
	
}