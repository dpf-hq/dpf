package no.hib.dpf.editor.extension_points;

import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;

public interface INodePainting {

	NodeFigure createNodeFigure();

	ConnectionAnchor createConnectionAnchor(IFigure figure);

}
