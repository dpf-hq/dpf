package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

class ArrowLabelConstraint implements Locator {

	private String text;
	private Point offset;
	private PolylineConnection connFigure;
	private boolean placeLabelAtEnd = false;

	public ArrowLabelConstraint(String text, Point offset, PolylineConnection connFigure, boolean placeLabelAtEnd) {
		this.text = text;
		this.offset = offset;
		this.connFigure = connFigure;
		this.placeLabelAtEnd = placeLabelAtEnd;
	}

	public void relocate(IFigure figure) {
		Dimension minimum = FigureUtilities.getTextExtents(text, figure.getFont());
		figure.setSize(minimum);
		Point location = placeLabelAtEnd ? connFigure.getEnd() : connFigure.getPoints().getMidpoint();
		location = location.getTranslated(-minimum.width / 2, -minimum.height / 2);
		figure.setLocation(offset.getTranslated(location));
	}
}