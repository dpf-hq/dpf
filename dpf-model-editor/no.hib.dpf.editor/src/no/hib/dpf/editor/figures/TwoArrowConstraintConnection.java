package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class TwoArrowConstraintConnection extends PolylineConnection implements RoutableFigure {

	public TwoArrowConstraintConnection() {
		super();
	}
	
	/**
	 * Returns <code>true</code> if this Figure uses local coordinates. This
	 * means its children are placed relative to this Figure's top-left corner.
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 * @since 2.0
	 */
	@Override
	protected boolean useLocalCoordinates() {
		return false;
	}	

	protected void drawAnchorBlob(Graphics g, Rectangle r) {
		g.fillArc(r.x, r.y, r.width, r.height, 0, 360);	
	}

	protected Rectangle buildPointBox(Point p) {
		return new Rectangle(p.x - 3, p.y - 3, 6, 6);
	}

	protected Point getMidwayPoint(Point p1, Point p2) {		
		int maxY = Math.max(p1.y, p2.y);
		int minY = Math.min(p1.y, p2.y);
		
		int maxX = Math.max(p1.x, p2.x);
		int minX = Math.min(p1.x, p2.x);
		
		int dx = maxX - minX;
		int dy = maxY - minY;		
		return new Point(maxX - (dx/2), maxY - (dy/2));
	}

	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			super.getBounds();
			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
			bounds.expand(90, 90);
		}
		return bounds;
		
	}

	/**
	 * SetBacgroundColor without update()
	 * @see IFigure#setBackgroundColor(Color)
	 */
	@SuppressWarnings("deprecation")
	public void setMyBackgroundColor(Color bg) {
		// Set background color to bg unless in high contrast mode.
		// In that case, get the color from system
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		Color highContrastClr = null;
		try {
			if (display.getHighContrast()) {
				highContrastClr = display
						.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
			}
		} catch (SWTException e) {
			highContrastClr = null;
		}
		bgColor = highContrastClr == null ? bg : highContrastClr;
	}

	@Override
	public int getRoutingPriority() {
		return 10;
	}

}