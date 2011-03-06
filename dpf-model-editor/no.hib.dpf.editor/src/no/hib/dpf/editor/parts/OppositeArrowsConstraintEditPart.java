package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.OppositeArrowsConstraintAnchor;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.EditPart;

/**
 * Works with constraints that go across opposite arrows.
 */
public abstract class OppositeArrowsConstraintEditPart extends ConstraintEditPart {

	public OppositeArrowsConstraintEditPart(boolean constraintFromTargetEnd) {
		super(constraintFromTargetEnd);
	}

	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * constraint. The source (or target) needs to be an instance of 
	 * <code>ArrowEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new ConnectionAnchor.
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		// Constructing the anchor with "isSource" ensures that the target end
		// of one arrow is used as well as the source end of the opposite arrow
		// (the negation is to make the anchor appear on the right side)
		ConstraintAnchor retval = new OppositeArrowsConstraintAnchor(!isSource);
		if ((supplier == null)  || (!(supplier instanceof ArrowEditPart))) {
			return retval;
		}
		updateAnchor(retval, supplier, isSource);
		
		return retval;
	}		
}
