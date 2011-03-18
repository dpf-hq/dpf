package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.swt.SWT;

public class OpenArrowDecoration extends PolygonDecoration {

	public OpenArrowDecoration() {
		TRIANGLE_TIP.removeAllPoints();
		TRIANGLE_TIP.addPoint(-1, 1);
		TRIANGLE_TIP.addPoint(0, 0);
		TRIANGLE_TIP.addPoint(-1, -1);
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		g.pushState();
		g.setAntialias(SWT.ON);
		g.drawPolyline(getPoints());
		g.popState();
	}

}
