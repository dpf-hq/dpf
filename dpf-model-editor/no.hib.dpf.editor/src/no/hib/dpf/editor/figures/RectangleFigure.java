package no.hib.dpf.editor.figures;

import java.util.List;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.graphics.Color;

public class RectangleFigure extends Figure implements RoutableFigure {

	public static Color tableColor = new Color(null, 255, 255, 206);
	public static Color backgroundColorr = new Color(null, 255, 255, 255);

//	private ColumnsFigure columnsFigure = new ColumnsFigure();
	private EditableLabel nameLabel;

	public RectangleFigure(EditableLabel name) {
		this(name, null);
		setOpaque(true); // non-transparent figure
		setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
		listenToNodeColorProperty();
	}

	
	private void listenToNodeColorProperty() {
		DPFPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if (event.getProperty().equals(PreferenceConstants.P_NODE_COLOR)) {
					setBackgroundColor(DPFEditorPreferences.getDefault().getNodeColor());
					repaint();
				}
			}
		});
	}
	
	@SuppressWarnings("rawtypes")
	public RectangleFigure(EditableLabel name, List colums) {

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