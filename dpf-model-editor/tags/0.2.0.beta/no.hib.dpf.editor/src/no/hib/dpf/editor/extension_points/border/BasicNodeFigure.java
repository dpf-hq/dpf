package no.hib.dpf.editor.extension_points.border;

import java.util.List;

import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.swt.SWT;

public class BasicNodeFigure extends NodeFigure {
	public BasicNodeFigure(EditableLabel name) {
		this(name, null);
	}
	@SuppressWarnings("rawtypes")
	public BasicNodeFigure(EditableLabel name, List colums) {
		GridLayout layout = new GridLayout(1, true);
		layout.setConstraint(nameLabel, new GridData(SWT.CENTER, SWT.CENTER, true, true));
		setLayoutManager(layout);
		setOpaque(true);
		add(name);
		nameLabel = name;
	}
	/**
	 * Paints this Figure and its children.
	 * 
	 * @param graphics
	 *            The Graphics object used for painting
	 * @see #paintFigure(Graphics)
	 * @see #paintClientArea(Graphics)
	 * @see #paintBorder(Graphics)
	 */
	@SuppressWarnings("deprecation")
	public void paint(Graphics graphics) {
		if (getLocalBackgroundColor() != null)
			graphics.setBackgroundColor(getLocalBackgroundColor());
		if (getLocalForegroundColor() != null)
			graphics.setForegroundColor(getLocalForegroundColor());
		if (font != null)
			graphics.setFont(font);

		graphics.pushState();
		try {
			paintFigure(graphics);
			graphics.restoreState();
			paintBorder(graphics);
			paintClientArea(graphics);
		} finally {
			graphics.popState();
		}
//		super.paint(graphics);
	}

}