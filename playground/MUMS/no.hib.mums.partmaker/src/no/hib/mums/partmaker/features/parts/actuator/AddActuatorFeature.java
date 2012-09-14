package no.hib.mums.partmaker.features.parts.actuator;

import no.hib.mums.partmaker.features.parts.AddPartFeature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;

public class AddActuatorFeature extends AddPartFeature {

	public AddActuatorFeature(IFeatureProvider fp) {
		super(fp);
		this.setColors(new ColorConstant("A64300"), 
					    new ColorConstant("FF8D40"), 
					    new ColorConstant("FF6700"));
		super.height = 50;
	}
}
