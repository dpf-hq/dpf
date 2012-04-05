package no.hib.dpf.editor.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

public class CirclePainting implements INodePainting {

	private class CircleFigure extends NodeFigure{
		public CircleFigure(EditableLabel name) {
			this(name, null);
			setOpaque(true);
			setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
			listenToNodeColorProperty();
		}
		@SuppressWarnings("rawtypes")
		public CircleFigure(EditableLabel name, List colums) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layout.setStretchMinorAxis(false);
			layout.setSpacing(2);
			setLayoutManager(layout);
			setBorder(new CircleBorder());
			setOpaque(true);
			add(name);
			nameLabel = name;
		}
	}
	private class CircleBorder extends AbstractBorder {
		public Insets getInsets(IFigure figure) {
			return new Insets(10);
		}
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			tempRect.setBounds(getPaintRectangle(figure, insets));		
			int width = graphics.getLineWidth();
			if(width == 0)
				width = 1;
			tempRect.shrink(width, width);
			Point c = tempRect.getCenter();
			
			int r = tempRect.height > tempRect.width ? tempRect.width : tempRect.height;
			graphics.drawOval(c.x - r/2, c.y - r/2 , r, r);
		}
	}
	@Override
	public Figure createNodeFigure() {
		return new CircleFigure(new EditableLabel("choice"));
	}

	private class CircleAnchor extends ChopboxAnchor{
		public CircleAnchor(IFigure figure) {
			super(figure);
		}

		@Override
		public Point getLocation(Point reference) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBox());
			r.translate(-1, -1);
			r.resize(1, 1);
			getOwner().translateToAbsolute(r);
			r.shrink(1, 1);
			float centerX = r.x + 0.5f * r.width;
			float centerY = r.y + 0.5f * r.height;
			float R = r.height > r.width ? r.width : r.height;
			R/=2.0f;
			double exp = R/Math.sqrt((reference.x - centerX)*(reference.x - centerX) + (reference.y - centerY)*(reference.y - centerY));
			if (r.isEmpty() || (reference.x == (int) centerX && reference.y == (int) centerY)) {
				double x = Math.random()*R;
				double y = Math.sqrt(R*R - x*x);
				return new PrecisionPoint(x, y);
			}
			return new PrecisionPoint(exp*(reference.x-centerX) + centerX, exp*(reference.y-centerY) + centerY);
		}
	}
	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new CircleAnchor(figure);
	}

}
