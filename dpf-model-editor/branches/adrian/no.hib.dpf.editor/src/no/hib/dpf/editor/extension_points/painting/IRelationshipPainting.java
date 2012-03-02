package no.hib.dpf.editor.extension_points.painting;

import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.extension_points.border.BasicNodeFigure;
import no.hib.dpf.editor.figures.EditableLabel;

public class IRelationshipPainting implements INodePainting {

	private class RelationshipFigure extends BasicNodeFigure{
		public RelationshipFigure(EditableLabel name) {
			this(name, null);
		}
		@SuppressWarnings("rawtypes")
		public RelationshipFigure(EditableLabel name, List colums) {
			super(name, colums);
			setBorder(new RelationshipBorder());
		}
	}
	private class RelationshipBorder extends BasicBorder {
		@Override
		public void draw(Graphics graphics) {
			double ration = ((double)tempRect.height) / ((double)tempRect.width);
			PointList points = new PointList();
			points.addPoint(tempRect.getLeft());
			points.addPoint(tempRect.getBottom());
			points.addPoint(tempRect.getRight());
			points.addPoint(tempRect.getTop());
			graphics.drawPolygon(points);
			tempRect.shrink(getWidth(), Math.max(getWidth(), (int) (getWidth() * ration)));
			points = new PointList();
			points.addPoint(tempRect.getLeft());
			points.addPoint(tempRect.getBottom());
			points.addPoint(tempRect.getRight());
			points.addPoint(tempRect.getTop());
			Color color = graphics.getBackgroundColor();
			graphics.setBackgroundColor(bgColor);
			graphics.fillPolygon(points);
			graphics.setBackgroundColor(color);
			int _short = tempRect.width;
			_short /= 20;
			if(_short == 0)
				_short = 2;
			_short += getWidth();
			tempRect.shrink(_short, (int) (_short * ration));
			
			points = new PointList();
			points.addPoint(tempRect.getLeft());
			points.addPoint(tempRect.getBottom());
			points.addPoint(tempRect.getRight());
			points.addPoint(tempRect.getTop());
			graphics.drawPolygon(points);
		}
	}
	@Override
	public Figure createNodeFigure() {
		return new RelationshipFigure(new EditableLabel("Relationship"));
	}
	ConnectionAnchor inAnchor = null;
	ConnectionAnchor[] outAnchors = null;

	private class RelationshipAnchor extends ChopboxAnchor{
		public RelationshipAnchor(IFigure figure) {
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
					index = Math.abs((double)dy/(double)dx) < (double)1 ? (dx > 0 ? 2 : 0) : (dy > 0 ? 3 : 1);

			return points[index];
		}
	}
	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new RelationshipAnchor(figure);
	}

}
