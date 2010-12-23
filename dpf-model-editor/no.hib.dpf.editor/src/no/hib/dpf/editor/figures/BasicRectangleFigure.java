package no.hib.dpf.editor.figures;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;

public class BasicRectangleFigure extends Figure implements RoutableFigure {

	public static Color tableColor = new Color(null, 255, 255, 206);
	public static Color lightLightGreen = new Color(null, 128, 255, 128);

//	private ColumnsFigure columnsFigure = new ColumnsFigure();
	private EditableLabel nameLabel;

	public BasicRectangleFigure(EditableLabel name) {
		this(name, null);
		setOpaque(true); // non-transparent figure
		setBackgroundColor(lightLightGreen);		
	}

	@SuppressWarnings("rawtypes")
	public BasicRectangleFigure(EditableLabel name, List colums) {

		nameLabel = name;
		ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(true);
		layout.setStretchMinorAxis(true);
		setLayoutManager(layout);
		setBorder(new LineBorder(ColorConstants.black, 1));
		setBackgroundColor(tableColor);
		setForegroundColor(ColorConstants.black);
		setOpaque(true);

		name.setForegroundColor(ColorConstants.black);
		add(name);
//		add(columnsFigure);

	}

//	public void setSelected(boolean isSelected) {
//		LineBorder lineBorder = (LineBorder) getBorder();
//		if (isSelected)
//		{
//			lineBorder.setWidth(2);
//		}
//		else
//		{
//			lineBorder.setWidth(1);
//		}
//	}

	
	/**
	 * @return returns the label used to edit the name
	 */
	public EditableLabel getNameLabel()
	{
		return nameLabel;
	}

	@Override
	public int getRoutingPriority() {
		return 0;
	}

//	/**
//	 * @return the figure containing the column lables
//	 */
//	public ColumnsFigure getColumnsFigure()
//	{
//		return columnsFigure;
//	}
}