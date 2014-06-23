package no.hib.dpf.visualization.figures;

import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


public class CompositeVNodeFigure extends VNodeFigure {
	
	Figure pane;
	
	public CompositeVNodeFigure(EditableLabel name, RGB color, Boolean rounded, Boolean shadow) {
		super(name, color, rounded, shadow);
		 
		// override layout defined in supertype: 
		BorderLayout layout = new BorderLayout();
		layout.setConstraint(name, BorderLayout.TOP);
		setLayoutManager(layout);
		
		
		// add subcontainer for subcomponents (see CompartmentFigure)
		pane = new Figure();
		ConstrainedToolbarLayout paneLayout = new ConstrainedToolbarLayout();
        pane.setLayoutManager(paneLayout);
        add(pane, BorderLayout.CENTER);
	}
	
	public IFigure getContentPane() {
		return pane;
	}
}
