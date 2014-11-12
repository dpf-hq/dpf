package no.hib.dpf.visualization.figures;


import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramAttributeUtilities;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.figures.EditableLabel;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class CompartmentFigure extends Figure {
	Figure pane;
	
	public CompartmentFigure(String name) {
		ToolbarLayout layout = new ToolbarLayout();
	    layout.setSpacing(3);
	    setLayoutManager(layout);
	    Border border = new CompartmentFigureBorder(ColorConstants.gray);
	    setBorder(border);
	    
	    Display display = Display.getCurrent();
	    if (display == null){
	    	display = Display.getDefault();
	    }
	    
	    // TODO :  make this more generic
	    if(!name.equals(ClassDiagramConstants.NODE_ATTRIBUTE) && !name.equals(ClassDiagramConstants.NODE_METHOD)){
		    add(new EditableLabel(name + "s"));	
	    }
	    
	    pane = new Figure();
	    ToolbarLayout panelayout = new ToolbarLayout();
	    panelayout.setSpacing(3);
	    pane.setLayoutManager(panelayout);
        add(pane);
	}
	    
	public class CompartmentFigureBorder extends AbstractBorder {
		
		Color lineColor = ColorConstants.black;
	
		public CompartmentFigureBorder(Color lineColor){
			if(lineColor != null){
				this.lineColor = lineColor;
			}
			setBackgroundColor(lineColor);
		}
		
		@Override
		public Insets getInsets(IFigure figure) {
			return new Insets(4,5,4,0);
	    }
		
		@Override
		public void paint(IFigure figure, Graphics graphics, Insets insets) { 
			Point topleft = getPaintRectangle(figure, insets).getTopLeft();
			topleft.y += 1;
			
			Point topright = tempRect.getTopRight();
			topright.y += 1;
			
			graphics.setAlpha(90);
			graphics.drawLine(topleft, topright);
	    }
	}
	
	public IFigure getContentPane() {
		return pane;
	}
}