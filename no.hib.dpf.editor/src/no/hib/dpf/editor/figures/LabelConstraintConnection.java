package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class LabelConstraintConnection extends ConstraintConnection {
	protected Label label;
	public LabelConstraintConnection(){
		super();
		label = new Label();
		//put the label in the middle of the two anchors
		add(label, new ConnectionLocator(this, ConnectionLocator.MIDDLE){
			protected Point getLocation(PointList points) {
				return points.getFirstPoint().translate(points.getLastPoint()).getScaled(0.5);
			}});
	}
	public Label getLabel(){return label;}
}
