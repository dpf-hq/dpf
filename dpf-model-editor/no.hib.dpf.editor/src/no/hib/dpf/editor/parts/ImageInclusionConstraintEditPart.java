package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.ParallelArrowsConstraintConnection;

import org.eclipse.draw2d.IFigure;

/**
 * Edit part for Image Inclusion constraint elements.
 */
public class ImageInclusionConstraintEditPart extends ParallelArrowsConstraintEditPart {

	public ImageInclusionConstraintEditPart() {
		super(false);
	}

	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(false);
	}
	
	@Override
	protected IFigure createFigureExec() {
		return new ParallelArrowsConstraintConnection(this, "[⊒]");
	}
	
}