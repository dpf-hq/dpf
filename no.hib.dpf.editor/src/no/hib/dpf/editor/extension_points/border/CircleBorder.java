package no.hib.dpf.editor.extension_points.border;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;

public class CircleBorder extends BasicBorder {
	public void draw(Graphics graphics) {
		Point c = tempRect.getCenter();
		int r = tempRect.height > tempRect.width ? tempRect.height : tempRect.width;
		graphics.drawOval(c.x - r/2, c.y - r/2 , r, r);
	}
}