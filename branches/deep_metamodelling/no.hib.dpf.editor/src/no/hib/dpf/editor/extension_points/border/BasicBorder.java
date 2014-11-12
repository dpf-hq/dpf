package no.hib.dpf.editor.extension_points.border;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Color;


public abstract class BasicBorder extends LineBorder {
	protected static final Color bgColor = ColorConstants.lightGray;
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		tempRect.setBounds(getPaintRectangle(figure, insets));
		if (getWidth() % 2 == 1) {
			tempRect.width--;
			tempRect.height--;
		}
		tempRect.shrink(getWidth() / 2, getWidth() / 2);
		graphics.pushState();
		graphics.setLineWidth(getWidth());
		graphics.setLineStyle(getStyle());
		if (getColor() != null)
			graphics.setForegroundColor(getColor());
		draw(graphics);
		graphics.popState();
	}
	public abstract void draw(Graphics graphics);
	public BasicBorder(){
		super(ColorConstants.black, 1);
	}
}
