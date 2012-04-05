package no.hib.dpf.editor.extension_points.painting;

import java.util.List;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.extension_points.border.BasicNodeFigure;
import no.hib.dpf.editor.figures.EditableLabel;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

public class EllipsePainting implements INodePainting {

	private class EllipseFigure extends BasicNodeFigure{
		public EllipseFigure(EditableLabel name) {
			this(name, null);
		}
		@SuppressWarnings("rawtypes")
		public EllipseFigure(EditableLabel name, List colums) {
			super(name, colums);
			setBorder(new BasicBorder (){
				@Override
				public void draw(Graphics graphics) {
					graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
				}
			});
		}
	}
	@Override
	public Figure createNodeFigure() {
		return new EllipseFigure(new EditableLabel("entity"));
	}


	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
