package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ColorConstants;

import no.hib.dpf.editor.extension_points.border.CircleBorder;
import no.hib.dpf.editor.figures.NodeFigure;

public class StartPainting extends CirclePainting {

	@Override
	public NodeFigure createNodeFigure() {
		NodeFigure nodeFigure = super.createNodeFigure();
		CircleBorder border = (CircleBorder) nodeFigure.getBorder();
		border.setColor(ColorConstants.red);
		return nodeFigure;
	}

}
