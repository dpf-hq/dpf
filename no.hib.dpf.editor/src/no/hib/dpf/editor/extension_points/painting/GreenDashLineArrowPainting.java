package no.hib.dpf.editor.extension_points.painting;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;


public class GreenDashLineArrowPainting extends DashLineArrowPainting {

	@Override
	public PolylineConnection createConnectionFigure() {
		PolylineConnection result = super.createConnectionFigure();
		result.setForegroundColor(ColorConstants.green);
		return result;
	}

}
