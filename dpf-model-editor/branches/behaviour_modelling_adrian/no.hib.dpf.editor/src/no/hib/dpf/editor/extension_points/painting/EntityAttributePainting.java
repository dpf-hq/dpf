package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;

import no.hib.dpf.editor.extension_points.IArrowPainting;

public class EntityAttributePainting implements IArrowPainting {


	@Override
	public RotatableDecoration createTargetDecoration() {
		return null;
	}

	@Override
	public PolylineConnection createConnectionFigure() {
		return new PolylineConnection();
	}

}
