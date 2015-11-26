package no.hib.dpf.editor.extension_points.painting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;

public class RedDashedArrowPainting extends DashLineArrowPainting {


	@Override
	public PolylineConnection createConnectionFigure() {
		PolylineConnection result = super.createConnectionFigure();
		result.setForegroundColor(ColorConstants.red);
		return result;
	}

}
