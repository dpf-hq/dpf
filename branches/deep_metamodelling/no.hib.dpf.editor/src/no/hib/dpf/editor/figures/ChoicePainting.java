package no.hib.dpf.editor.figures;

import java.util.List;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class ChoicePainting implements INodePainting {

	private class ChoiceFigure extends NodeFigure{
		public ChoiceFigure(EditableLabel name) {
			this(name, null);
			setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
			listenToNodeColorProperty();
		}
		@SuppressWarnings("rawtypes")
		public ChoiceFigure(EditableLabel name, List colums) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setMinorAlignment(OrderedLayout.ALIGN_CENTER);
			layout.setStretchMinorAxis(false);
			layout.setSpacing(2);
			setLayoutManager(layout);
			setBorder(new ChoiceBorder());
			setOpaque(true);
			add(name);
			nameLabel = name;
		}
		@Override
		public void paint(Graphics graphics){
			super.paint(graphics);
		}
	}
	private class ChoiceBorder extends AbstractBorder {
		@Override
		public Insets getInsets(IFigure figure) {
			return new Insets(1);
		}
		@Override
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			int width = graphics.getLineWidth();
			if(width == 0)
				width = 1;
			getPaintRectangle(figure, insets);
			tempRect.shrink(width, width);
			graphics.drawLine(tempRect.getLeft(), tempRect.getBottom());
			graphics.drawLine(tempRect.getLeft(), tempRect.getTop());
			graphics.drawLine(tempRect.getTop(), tempRect.getRight());
			graphics.drawLine(tempRect.getBottom(), tempRect.getRight());
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new ChoiceFigure(new EditableLabel("choice"));
	}
	ConnectionAnchor inAnchor = null;
	ConnectionAnchor[] outAnchors = null;

	private class ChoiceAnchor extends ChopboxAnchor{
		public ChoiceAnchor(IFigure figure) {
			super(figure);
		}

		//-----1-----
		//|         |
		//0         2
		//|         |
		//-----3-----
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
			Point[] points = new Point[4];
			Point start = new Point(r.x, r.y);
			points[0] = start.getTranslated(0, (int) (0.5f * r.height));
			points[1] = start.getTranslated((int) (0.5f * r.width), 0);
			points[2] = start.getTranslated(r.width, (int) (0.5f * r.height));
			points[3] = start.getTranslated((int) (0.5f * r.width), r.height);

			int index = 0;
			if (r.isEmpty() || (reference.x == (int) centerX && reference.y == (int) centerY)) {
				index = (int) (Math.random() * 4);
				return points[index];
			}
			float dx = reference.x - centerX;
			float dy = reference.y - centerY;
			if(reference.x == ((int)centerX))
				index = dy > 0 ? 3 : 1;
				else
					index = Math.abs((double)dy/(double)dx) < 1 ? (dx > 0 ? 2 : 0) : (dy > 0 ? 3 : 1);

			return points[index];
		}
	}
	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new ChoiceAnchor(figure);
	}

}
