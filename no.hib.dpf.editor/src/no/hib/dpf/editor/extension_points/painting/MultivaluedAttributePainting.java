package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

public class MultivaluedAttributePainting implements INodePainting {

	private class MultivaluedAttributeFigure extends NodeFigure{
		public MultivaluedAttributeFigure(EditableLabel name) {
			super(name);
			setBorder(new MultivaluedAttributeBorder());
		}
	}
	private class MultivaluedAttributeBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			double ration = ((double)tempRect.height) / ((double)tempRect.width);
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
			int _short = tempRect.height > tempRect.width ? tempRect.height : tempRect.height;
			_short /= 20;
			if(_short == 0)
				_short = 2;
			_short += getWidth();
			tempRect.shrink(_short, Math.max(_short, (int) (_short * ration)));
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new MultivaluedAttributeFigure(new EditableLabel("entity"));
	}

	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
