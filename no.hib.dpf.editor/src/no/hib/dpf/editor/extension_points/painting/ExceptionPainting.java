package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.NodeFigure;

public class ExceptionPainting extends EllipsePainting {

	@Override
	public NodeFigure createNodeFigure() {
		NodeFigure figure = super.createNodeFigure();
		figure.setOpaque(false);
		Color color = new Color(null, 160, 0, 0);
		figure.setBackgroundColor(color);
		figure.setForegroundColor(color);
		BasicBorder border = (BasicBorder) figure.getBorder();
		border.setColor(color);
		IFigure label = figure.getLabel();
		label.setBackgroundColor(color);
		label.setForegroundColor(ColorConstants.white);
		Font font = new Font(null, "Arial", 12, SWT.BOLD);
		label.setFont(font);
		return figure;
	}
}
