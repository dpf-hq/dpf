package no.hib.dpf.visualization.figures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.visualization.VCompartment;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class CompositeNodeFigure extends NodeFigure {
	
	List<CompartmentFigure> compartmentfigures;

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
		
		compartmentfigures = new ArrayList<CompartmentFigure>();
		for(VCompartment compartment : compartments) {
			CompartmentFigure child = new CompartmentFigure(compartment.getName());
			for(DNode dNode : compartment.getChildren()) {
				addChild(dNode.getNode());
			}
			compartmentfigures.add(child);
			add(child);
		}
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addChild(Node node) {
		String name = node.getName();
		for(CompartmentFigure compartment : compartmentfigures) {
			if(compartment.getName().equals(node.getTypeName())) {
				if (node.getTypeName() != null) 
					name += " : " + node.getTypeName();
				compartment.addChild(name);
			}
		}
	}
	
	public class CompartmentFigure extends Figure {
		public String name;
		
		public CompartmentFigure(String name) {
			this.name = name;
			ToolbarLayout layout = new ToolbarLayout();
		    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		    layout.setStretchMinorAxis(true);
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
		}
		
		public String getName() {
			return name;
		}
		
		public void addChild(String name) {
			Label label = new Label(name);
			label.setLabelAlignment(PositionConstants.LEFT);
			add(label);
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
