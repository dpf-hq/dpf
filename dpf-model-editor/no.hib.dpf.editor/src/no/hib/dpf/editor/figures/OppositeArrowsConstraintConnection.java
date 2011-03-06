package no.hib.dpf.editor.figures;

import no.hib.dpf.editor.parts.ConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The arrows are supposed to be parallel, and (for the time being) in opposite directions.
 */
public class OppositeArrowsConstraintConnection extends TwoArrowConstraintConnection {
	
	public OppositeArrowsConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		super(constraintEditPart, labelText, new int[]{ 20, -20});
	}
	
}
