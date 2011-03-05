package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.ConnectionConstraintAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.OppositeArrowsConstraintConnection;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;

/**
 * Edit part for Inverse constraint elements.
 */
class InverseConstraintEditPart extends ConstraintEditPart {

	public InverseConstraintEditPart() {
		super(false);
	}

	public NodeFigure getRectangleFigureForFigure() {
		return getRectangleFigureForFigure(true);
	}
	
	
	
	/**
	 * Returns the primary Figure representing this GraphicalEditPart, a Constraint Figure.
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigureExec() {
		return new OppositeArrowsConstraintConnection(this, "[inv]");
	}

	
	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * connection. The source (or target) needs to be an instance of 
	 * <code>ShapeConnectionEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new LineConstraintAnchor.
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		// Now, the connection constraint anchor is constructed, setting from which end of the line it
		// should anchor itself:
		ConnectionConstraintAnchor retval = new ConnectionConstraintAnchor(new Point(200, 200), isSource);
		if ((supplier == null)  || (!(supplier instanceof ArrowEditPart))) {
			return retval;
		}
		updateAnchor(retval, supplier, isSource);
		
		return retval;
	}	
}