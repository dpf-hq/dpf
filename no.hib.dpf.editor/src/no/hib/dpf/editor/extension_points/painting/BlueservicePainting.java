package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.NodeFigure;

public class BlueservicePainting extends EllipsePainting {

	@Override
	public NodeFigure createNodeFigure() {
		NodeFigure figure = super.createNodeFigure();
		figure.setOpaque(false);
		Color color = new Color(null, 57, 157, 218);
		figure.setBackgroundColor(color);
		figure.setForegroundColor(color);
		BasicBorder border = (BasicBorder) figure.getBorder();
		border.setColor(color);
		IFigure label = figure.getLabel();
		label.setOpaque(false);
		label.setBackgroundColor(color);
		label.setForegroundColor(ColorConstants.white);
		Font font = new Font(null, "Arial", 12, SWT.BOLD);
		label.setFont(font);
		return figure;
	}
}
