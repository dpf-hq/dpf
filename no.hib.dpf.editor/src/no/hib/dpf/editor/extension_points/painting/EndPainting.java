package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;

import no.hib.dpf.editor.extension_points.border.CircleBorder;
import no.hib.dpf.editor.figures.NodeFigure;

public class EndPainting extends CirclePainting {

	public NodeFigure createNodeFigure() {
		NodeFigure nodeFigure = super.createNodeFigure();
		CircleBorder border = new CircleBorder(){
			public void draw(Graphics graphics) {
				tempRect.shrink(-4, -4);
				Point c = tempRect.getCenter();
				int r = tempRect.height;
				graphics.setLineWidth(1);
				graphics.drawOval(c.x - r/2, c.y - r/2 , r, r);
				tempRect.shrink(6, 6);
				r = tempRect.height;
				graphics.setLineWidth(3);
				graphics.drawOval(c.x - r/2, c.y - r/2 , r, r);
			}
		};
		border.setColor(ColorConstants.red);
		border.setWidth(10);
		nodeFigure.setBorder(border);
		return nodeFigure;
	}
}
