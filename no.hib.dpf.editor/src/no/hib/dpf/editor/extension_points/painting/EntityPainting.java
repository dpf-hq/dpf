package no.hib.dpf.editor.extension_points.painting;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;



public class EntityPainting implements INodePainting {

	public class EntityFigure extends NodeFigure{
		public EntityFigure(EditableLabel name) {
			super(name);
			setBorder(new EntityBorder());
		}
	}

	public class EntityBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.setBackgroundColor(color);
			graphics.fillRectangle(tempRect);
			graphics.drawRectangle(tempRect);
		}
	}
	@Override
	public NodeFigure createNodeFigure() {
		return new EntityFigure(new EditableLabel("Entity"));
	}

	@Override
	public ConnectionAnchor createConnectionAnchor(IFigure figure) {
		return null;
	}

}
