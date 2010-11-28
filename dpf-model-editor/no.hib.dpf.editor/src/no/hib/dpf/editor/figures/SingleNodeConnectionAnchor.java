package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class SingleNodeConnectionAnchor extends ChopboxAnchor {

	boolean isSourceAnchor;
	
	public SingleNodeConnectionAnchor(IFigure figure, boolean isSourceAnchor) {
		super(figure);
		this.isSourceAnchor = isSourceAnchor;
	}

	@Override
	public Point getLocation(Point reference) {
		Rectangle figureRect = getOwner().getBounds();
		
		if (isSourceAnchor) {
			return figureRect.getTop();
		} else {
			return figureRect.getBottom();
		}
	}
}
