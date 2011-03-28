package no.hib.dpf.editor.parts;

import org.eclipse.draw2d.IFigure;

import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.TwoArrowsOneNodeConstraintConnection;

public abstract class TwoArrowsOneNodeConstraintEditPart extends ConstraintEditPart {
	
	protected String labelText;

	public TwoArrowsOneNodeConstraintEditPart() {
		super(false);
	}

	@Override
	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(true);
	}
		
	/**
	 * Returns the primary Figure representing this GraphicalEditPart, a Constraint Figure.
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigureExec() {
		return new TwoArrowsOneNodeConstraintConnection(this, labelText);
	}
	
}
