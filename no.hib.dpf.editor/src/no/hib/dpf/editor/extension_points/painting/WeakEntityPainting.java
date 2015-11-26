package no.hib.dpf.editor.extension_points.painting;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;



public class WeakEntityPainting implements INodePainting {

	public class WeakEntityFigure extends NodeFigure{
		public WeakEntityFigure(EditableLabel name) {
			super(name);
			setBorder(new WeakEntityBorder());
		}
	}

	public class WeakEntityBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.drawRectangle(tempRect);
			double ration = ((double)tempRect.height) / ((double)tempRect.width);
			tempRect.shrink(getWidth(), Math.max(getWidth(), (int) (getWidth() * ration)));
			Color color = graphics.getBackgroundColor();
			graphics.setBackgroundColor(color);
			graphics.fillRectangle(tempRect);
			graphics.setBackgroundColor(color);
			int _short = tempRect.height > tempRect.width ? tempRect.height : tempRect.height;
			_short /= 20;
			if(_short == 0)
				_short = 2;
			_short += getWidth();
			tempRect.shrink(_short, Math.max(_short, (int) (_short * ration)));
			graphics.drawRectangle(tempRect);
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new WeakEntityFigure(new EditableLabel("WeakEntity"));
	}

	@Override
	public ConnectionAnchor createConnectionAnchor(IFigure figure) {
		return null;
	}

}
