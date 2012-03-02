package no.hib.dpf.editor.extension_points.painting;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.extension_points.border.BasicNodeFigure;
import no.hib.dpf.editor.figures.EditableLabel;

public class AttributePainting implements INodePainting {

	private class AttributeFigure extends BasicNodeFigure{
		public AttributeFigure(EditableLabel name) {
			this(name, null);
		}
		@SuppressWarnings("rawtypes")
		public AttributeFigure(EditableLabel name, List colums) {
			super(name, colums);
			setBorder(new AttributeBorder());
		}
	}
	private class AttributeBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
		}
	}
	@Override
	public Figure createNodeFigure() {
		return new AttributeFigure(new EditableLabel("Attribute"));
	}

	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
