package no.hib.dpf.editor.extension_points.painting;

import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.extension_points.figure.EllipseFigure;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;

public class EllipsePainting implements INodePainting {

	@Override
	public NodeFigure createNodeFigure() {
		return new EllipseFigure(new EditableLabel("entity"));
	}


	@Override
	public 	ConnectionAnchor createConnectionAnchor(IFigure figure){
		return new EllipseAnchor(figure);
	}

}
