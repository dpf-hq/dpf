package no.hib.dpf.editor.extension_points.painting;
import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.figures.OpenArrowDecoration;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.swt.SWT;


public class DashLineArrowPainting implements IArrowPainting {

	public DashLineArrowPainting() {
	}

	@Override
	public RotatableDecoration createTargetDecoration() {
		PolygonDecoration arrowHead = new OpenArrowDecoration();
		arrowHead.setFill(false);
		arrowHead.setScale(16, 6);
		return arrowHead;
	}

	@Override
	public PolylineConnection createConnectionFigure() {
		PolylineConnection connection = new ArrowConnection();
		connection.setLineStyle(SWT.LINE_CUSTOM);
		connection.setLineDash(new float[]{2});
		return connection;
	}

}
