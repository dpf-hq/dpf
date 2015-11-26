package no.hib.dpf.editor.figures;

import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.DNodeEditPart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

public class ArrowLabelLocator implements Locator {

	private DArrowEditPart connection;
	private DOffset offset;
	private String text;

	public ArrowLabelLocator(String text, DOffset dOffset, DArrowEditPart parent) {
		this.text = text == null ? "" : text;
		this.offset = dOffset;
		this.connection = parent;
	}

	public void relocate(IFigure figure) {
		Dimension minimum = FigureUtilities.getTextExtents(text, figure.getFont());
		if(figure instanceof EditableLabel){
			if(minimum.width > 80){
				minimum = ((EditableLabel)figure).getPreferredSize(80, -1);
			}
		}
		if(connection == null || connection.getSource() == null || connection.getTarget() == null) return;
		Point point = Draw2dUtil.getAbsolutePoint(((DNodeEditPart) connection.getSource()).getFigure(), 
				((DNodeEditPart) connection.getTarget()).getFigure(), 
				((Connection)connection.getFigure()).getPoints(),
				offset);
		if(point == null) return;
		figure.setSize(minimum);
		figure.setLocation(point);
	}

	public void setName(String arrowName) {
		if(text.equals(arrowName)) return;
		text = arrowName;
		connection.getFigure().revalidate();
	}
}