package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

public class KeyAttributePainting implements INodePainting {

	private class KeyAttributeFigure extends NodeFigure{
		public KeyAttributeFigure(EditableLabel name) {
			super(name);
			setBorder(new KeyAttributeBorder());
		}
	}
	private class KeyAttributeBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new KeyAttributeFigure(new EditableLabel("KeyAttribute"){
			protected void paintFigure(Graphics graphics){
				super.paintFigure(graphics);
				Rectangle bounds = getBounds();
				Rectangle _bounds = bounds.getCopy();
				_bounds.translate(-bounds.x, -bounds.y);
				_bounds.shrink(1, 1);
				graphics.translate(bounds.x, bounds.y);
				graphics.drawLine(_bounds.getBottomLeft(), _bounds.getBottomRight());
				graphics.translate(-bounds.x, -bounds.y);
			}
			
		});
	}

	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
