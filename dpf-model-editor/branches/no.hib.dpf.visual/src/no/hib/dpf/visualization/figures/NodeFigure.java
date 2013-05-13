package no.hib.dpf.visualization.figures;

import java.io.IOException;
import java.util.List;

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class NodeFigure extends Figure {
	protected EditableLabel nameLabel;
	public org.eclipse.swt.graphics.Image IMAGE;
	
	public NodeFigure(EditableLabel name) {
		this(name, null);
		setOpaque(true); // non-transparent figure
		setBackgroundColor(new Color(null, 255, 255, 255));
		setForegroundColor(new Color(null, 0, 0, 0));
		try {
			IMAGE = new Image(null, DPFPlugin.getDefault().getBundle().getResource("/icons/error.png").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public NodeFigure(){
		//super();
		}


	/**
	 * Returns the leftmost figure of two, calculated from the centre.
	 * If both figure's centres are equal, the lowest figure is returned.
	 */
	public NodeFigure getLeftmostOrLowest(NodeFigure nodeFigure) {

		Rectangle myRect = getBounds();
		Rectangle otherRect = nodeFigure.getBounds();

		float myCenterX = myRect.x + 0.5f * myRect.width;
		float myCenterY = myRect.y + 0.5f * myRect.height;

		float otherCenterX = otherRect.x + 0.5f * otherRect.width;
		float other2CenterY = otherRect.y + 0.5f * otherRect.height;

		if ((myCenterX < otherCenterX) ||
				((myCenterX == otherCenterX) && (myCenterY < other2CenterY))) {
			return this;
		}

		return nodeFigure;
	}

	@SuppressWarnings("rawtypes")
	public NodeFigure(EditableLabel name, List columns) {
		nameLabel = name;
		GridLayout layout = new GridLayout(1, true);
		layout.setConstraint(nameLabel, new GridData(SWT.CENTER, SWT.CENTER, true, true));
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(new Color(null, 255, 255, 255));
		setForegroundColor(new Color(null, 0, 0, 0));
		setOpaque(true);
		name.setForegroundColor(new Color(null, 0, 0, 0));
		add(name);
	}

	/**
	 * @return returns the label used to edit the name
	 */
	public EditableLabel getNameLabel()
	{
		return nameLabel;
	}

	public int getRoutingPriority() {
		return 0;
	}
	public boolean valid = false;
	public void showFeedBack(int state) {
		switch (state) {
		case 0:
			setBackgroundColor(new Color(null, 255, 255, 255));
			break;
		case 1:
			setBackgroundColor(new Color(null, 0, 255, 0));
			break;
		case 2:
			setBackgroundColor(new Color(null, 0, 127, 0));
			break;
		default:
			break;
		}
	}

	@Override
	protected void paintChildren(Graphics graphics) {
		  if(valid){
			 graphics.drawImage(IMAGE, getBounds().x(),getBounds().y());
		}
		  super.paintChildren(graphics);
	}

	public void setErrorImageFlag(boolean bool) {
		if(valid != bool){
            valid = bool;
            revalidate();
            repaint();
		}
	}

	public boolean getErrorImageFlag() {
		return valid;
	}
}
