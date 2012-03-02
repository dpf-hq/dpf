package no.hib.dpf.editor.extension_points;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;

public interface IArrowPainting {

	RotatableDecoration createTargetDecoration();

	PolylineConnection createConnectionFigure();

}
