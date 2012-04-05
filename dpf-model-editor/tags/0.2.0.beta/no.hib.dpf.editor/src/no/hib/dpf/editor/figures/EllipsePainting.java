package no.hib.dpf.editor.figures;

import java.util.List;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class EllipsePainting implements INodePainting {

	private class EllipseFigure extends NodeFigure{
		public EllipseFigure(EditableLabel name) {
			this(name, null);
			setOpaque(true);
			setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
			listenToNodeColorProperty();
		}
		@SuppressWarnings("rawtypes")
		public EllipseFigure(EditableLabel name, List colums) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
			layout.setStretchMinorAxis(false);
			layout.setSpacing(2);
			setLayoutManager(layout);
			setBorder(new EllipseBorder());
			setOpaque(true);
			add(name);
			nameLabel = name;
		}
	}
	private class EllipseBorder extends AbstractBorder {
		public Insets getInsets(IFigure figure) {
			return new Insets(10);
		}
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			tempRect.setBounds(getPaintRectangle(figure, insets));		
			int width = graphics.getLineWidth();
			if(width == 0)
				width = 1;
			tempRect.shrink(width, width);
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
		}
	}
	@Override
	public Figure createNodeFigure() {
		return new EllipseFigure(new EditableLabel("choice"));
	}

	private class EllipseAnchor extends ChopboxAnchor{
		public EllipseAnchor(IFigure figure) {
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
			Point ref = r.getCenter().negate().translate(reference);

			  if (ref.x == 0)
			   return new Point(reference.x, (ref.y > 0) ? r.bottom() : r.y);
			  if (ref.y == 0)
			   return new Point((ref.x > 0) ? r.right() : r.x, reference.y);

			  float dx = (ref.x > 0) ? 0.5f : -0.5f;
			  float dy = (ref.y > 0) ? 0.5f : -0.5f;
			  
			  // ref.x, ref.y, r.width, r.height != 0 => safe to proceed
			  
			  float k = (float)(ref.y * r.width) / (ref.x * r.height);
			  k = k * k;
			  
			  return r.getCenter().translate(
			    (int) (r.width * dx / Math.sqrt(1 + k)),
			    (int) (r.height * dy / Math.sqrt(1 + 1/k)));
		}
	}
	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
