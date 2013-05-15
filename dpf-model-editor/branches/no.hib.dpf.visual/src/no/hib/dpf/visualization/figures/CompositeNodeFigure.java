package no.hib.dpf.visualization.figures;

import java.io.IOException;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.visualization.VCompartment;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class CompositeNodeFigure extends NodeFigure {

	public CompositeNodeFigure(){
		//super();
		}
	
	public CompositeNodeFigure(EditableLabel name, EList<VCompartment> compartments) {
		nameLabel = name;
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(new Color(null, 255, 255, 180));
		setForegroundColor(new Color(null, 0, 0, 0));
		setOpaque(true);
		name.setForegroundColor(new Color(null, 0, 0, 0));
		add(name);
		for(VCompartment compartment : compartments) {
			CompartmentFigure child = new CompartmentFigure(compartment.getName()+"s");
			add(child);
		}
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public class CompartmentFigure extends Figure {

		  public CompartmentFigure(String name) {
		    ToolbarLayout layout = new ToolbarLayout();
		    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		    layout.setStretchMinorAxis(true);
		    layout.setSpacing(2);
		    setLayoutManager(layout);
		    setBorder(new CompartmentFigureBorder());
		    EditableLabel nameLabel = new EditableLabel(name);
		    add(nameLabel);
		  }
		    
		  public class CompartmentFigureBorder extends AbstractBorder {
		    public Insets getInsets(IFigure figure) {
		      return new Insets(1,0,0,0);
		    }
		    public void paint(IFigure figure, Graphics graphics, Insets insets) {
		      graphics.drawLine(getPaintRectangle(figure, insets).getTopLeft(), tempRect.getTopRight());
		    }
		  }
		}
}
