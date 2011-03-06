package no.hib.dpf.editor.figures;


import no.hib.dpf.editor.parts.ConstraintEditPart;

/**
 * Draws a figure located between two points (on arrows).
 * The figure is also "anchored" to a rectangle.
 */
public class TwoArrowsOneNodeConstraintConnection extends TwoArrowConstraintConnection  {

		
	public TwoArrowsOneNodeConstraintConnection(ConstraintEditPart constraintEditPart, String labelText) {
		super(constraintEditPart, labelText, new int[]{45, 30});
	}	
	
}
