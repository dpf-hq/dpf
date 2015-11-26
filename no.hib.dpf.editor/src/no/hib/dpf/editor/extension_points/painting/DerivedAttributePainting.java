package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

public class DerivedAttributePainting implements INodePainting {

	private class DerivedAttributeFigure extends NodeFigure{
		public DerivedAttributeFigure(EditableLabel name) {
			super(name);
			setBorder(new DerivedAttributeBorder());
		}
	}
	private class DerivedAttributeBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.setLineStyle(SWT.LINE_DASH);
//			graphics.getLineAttributes().dashOffset = 1.5f;
			graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new DerivedAttributeFigure(new EditableLabel("entity"));
	}

	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
