package no.hib.dpf.editor.extension_points.border;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class BasicAnchor extends ChopboxAnchor {

	public BasicAnchor(IFigure figure) {
		super(figure);
	}

	public BasicAnchor() {
		super();
	}
	@Override
	public Point getLocation(Point reference) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBox());
		r.translate(-1, -1);
		r.resize(1, 1);

		getOwner().translateToAbsolute(r);
		return getLocation(reference, r);
	}

	public abstract Point getLocation(Point reference, Rectangle r);
}
