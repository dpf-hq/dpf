package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.border.CircleBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

public class CirclePainting implements INodePainting {

	@Override
	public NodeFigure createNodeFigure() {
		NodeFigure nodeFigure = new NodeFigure(new EditableLabel("choice")){
			public void setBounds(Rectangle rect) {
				if(rect.width > rect.height) 
					rect.height = rect.width;
				else 
					rect.width = rect.height;
				super.setBounds(rect);
			}
		};
		nodeFigure.setBorder(new CircleBorder());
		return nodeFigure;
	}

	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
