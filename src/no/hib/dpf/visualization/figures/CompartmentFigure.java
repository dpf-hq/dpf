package no.hib.dpf.visualization.figures;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class CompartmentFigure extends Figure {
	public String name;
	Figure pane;
	
	public CompartmentFigure(String name) {
		this.name = name;
		ToolbarLayout layout = new ToolbarLayout();
	    layout.setSpacing(2);
	    setLayoutManager(layout);
	    setBorder(new CompartmentFigureBorder());
	    EditableLabel nameLabel = new EditableLabel(name+"s");
	    
	    Display display = Display.getCurrent();
	    if (display == null)
	    	display = Display.getDefault();
	    
	    FontData fontData = display.getSystemFont().getFontData()[0];
	    Font font = new Font(null, new FontData(fontData.getName(), fontData.getHeight(), SWT.ITALIC));
	    nameLabel.setFont(font);
	    
	    add(nameLabel);
	    
	    pane = new Figure();
	    ToolbarLayout panelayout = new ToolbarLayout();
	    panelayout.setSpacing(2);
        pane.setLayoutManager(panelayout);
        add(pane);
	}
	    
	public class CompartmentFigureBorder extends AbstractBorder {
		public Insets getInsets(IFigure figure) {
			return new Insets(1,0,0,0);
	    }
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(), tempRect.getTopRight());
	    }
	}
	
	public IFigure getContentPane() {
		return pane;
	}
}