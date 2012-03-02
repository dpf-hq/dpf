package no.hib.dpf.editor.extension_points;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;

public interface INodePainting {

	Figure createNodeFigure();

	ConnectionAnchor createConnectionAnchor(IFigure figure);

}
