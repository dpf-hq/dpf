package no.hib.dpf.editor.extension_points.painting;
import java.util.List;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.extension_points.border.BasicNodeFigure;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;



public class EntityPainting implements INodePainting {

	public class EntityFigure extends BasicNodeFigure{
		public EntityFigure(EditableLabel name) {
			this(name, null);
		}
		@SuppressWarnings("rawtypes")
		public EntityFigure(EditableLabel name, List colums) {
			super(name, colums);
			setBorder(new EntityBorder());
		}
	}

	public class EntityBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			graphics.setBackgroundColor(bgColor);
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
