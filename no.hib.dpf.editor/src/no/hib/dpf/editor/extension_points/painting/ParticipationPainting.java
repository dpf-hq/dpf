package no.hib.dpf.editor.extension_points.painting;

import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;

public class ParticipationPainting implements IArrowPainting {


	@Override
	public RotatableDecoration createTargetDecoration() {
		return null;
	}

	@Override
	public PolylineConnection createConnectionFigure() {
		return new ArrowConnection();
	}

}
