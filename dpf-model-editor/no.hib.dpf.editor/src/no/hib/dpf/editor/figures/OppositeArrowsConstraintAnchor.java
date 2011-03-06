package no.hib.dpf.editor.figures;

public class OppositeArrowsConstraintAnchor extends ConstraintAnchor {

	private static final int maxDistanceToConnectionPoint = 250;

	public OppositeArrowsConstraintAnchor(boolean useTargetEnd) {
		super(useTargetEnd);
	}

	protected double findDistanceToConnectionPoint(double distanceBetweenFirstPoints) {
		double distanceToConnectionPoint = distanceBetweenFirstPoints*5/6;
		if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
			distanceToConnectionPoint = maxDistanceToConnectionPoint;
		}
		return distanceToConnectionPoint;
	}

}
