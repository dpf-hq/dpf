package no.hib.dpf.visualization.figures;

import java.io.IOException;

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


public class CompositeNodeFigure extends NodeFigure {

	public CompositeNodeFigure(){
		
	}
	
	public CompositeNodeFigure(EditableLabel name) {
		nameLabel = name;
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(new Color(null, 255, 255, 180));
		setForegroundColor(new Color(null, 0, 0, 0));
		setOpaque(true);
		name.setForegroundColor(new Color(null, 0, 0, 0));
		add(name);
		
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
