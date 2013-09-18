package no.hib.dpf.visualization.figures;

import java.io.IOException;

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


public class CompositeNodeFigure extends NodeFigure {
	
	Figure pane;
	
	public CompositeNodeFigure(EditableLabel name) {
		nameLabel = name;
		BorderLayout layout = new BorderLayout();
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(new Color(null, 255, 255, 180));
		setForegroundColor(new Color(null, 0, 0, 0));
		setOpaque(true);
		nameLabel.setForegroundColor(new Color(null, 0, 0, 0));
		add(nameLabel, BorderLayout.TOP);
		
		pane = new Figure();
		ConstrainedToolbarLayout paneLayout = new ConstrainedToolbarLayout();
        pane.setLayoutManager(paneLayout);
        add(pane, BorderLayout.CENTER);
		
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public IFigure getContentPane() {
		return pane;
	}
}
