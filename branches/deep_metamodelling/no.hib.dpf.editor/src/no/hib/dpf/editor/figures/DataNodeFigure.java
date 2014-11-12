package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * 
 * @author Ole Klokkhammer
 *
 */
public class DataNodeFigure extends NodeFigure {
	private Ellipse ellipse;
	private ConnectionAnchor connectionAnchor;

	public DataNodeFigure(EditableLabel name) {
		super(name);
		setLayoutManager(new XYLayout());
		setBorder(null);
		ellipse = new Ellipse();
		ellipse.setAntialias(SWT.ON);
		ellipse.setLineStyle(Graphics.LINE_DOT);
		add(ellipse);
		add(nameLabel);
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(ellipse, new Rectangle(0, 0, r.width, r.height));
		setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
		ellipse.invalidate();
		nameLabel.invalidate();
		super.paintFigure(graphics);
	}

	public ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new EllipseAnchor(this);
		}
		return connectionAnchor;
	}
}
