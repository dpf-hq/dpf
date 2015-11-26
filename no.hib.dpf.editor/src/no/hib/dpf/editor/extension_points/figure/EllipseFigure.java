package no.hib.dpf.editor.extension_points.figure;

import org.eclipse.draw2d.Graphics;

import no.hib.dpf.editor.extension_points.border.BasicBorder;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

public class EllipseFigure extends NodeFigure{
	
	public EllipseFigure(EditableLabel name) {
		super(name);
		setBorder(new BasicBorder (){
			@Override
			public void draw(Graphics graphics) {				
				graphics.drawOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
			}
			public void drawBackground(Graphics graphics) {
				graphics.fillOval(tempRect.x, tempRect.y, tempRect.width, tempRect.height);
			}
			
		});
	}
}