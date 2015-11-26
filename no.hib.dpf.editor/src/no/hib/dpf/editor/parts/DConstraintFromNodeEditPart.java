package no.hib.dpf.editor.parts;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.editor.figures.ConstraintConnection;
import no.hib.dpf.editor.figures.OpenArrowDecoration;

public class DConstraintFromNodeEditPart extends DConstraintEditPart {

	public void setTarget(EditPart target){
		super.setTarget(target);
		if(getTarget() == null) return;
		DConstraint dConstraint = getDConstraint();
		if(dConstraint instanceof DGenericArrowConstraint){
			dConstraint = (DConstraint) dConstraint.eContainer();
		}else
			return;
		Object predicateTarget = dConstraint.getDPredicate().getVisualization().getTarget();
		Object modelTarget = getTarget().getModel();
		if(modelTarget instanceof DArrow && 
				dConstraint.getConstraint().getMappings().getArrowMapping().get(predicateTarget) == ((DArrow)modelTarget).getArrow()){
			PolygonDecoration arrowHead = new OpenArrowDecoration();
			arrowHead.setFill(false);
			arrowHead.setForegroundColor(new Color(null, 204, 0, 204));
			arrowHead.setLineWidth(2);
			arrowHead.setScale(10, 5);
			((ConstraintConnection)getConnectionFigure()).setTargetDecoration(arrowHead); 
		}
	}
}
