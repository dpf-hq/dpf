package no.hib.mums.partmaker.features.parts.thrustercontrol;

import no.hib.mums.partmaker.features.parts.AddPartFeature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;

public class AddThrusterControlFeature extends AddPartFeature {

	public AddThrusterControlFeature(IFeatureProvider fp) {
		super(fp);
		this.setColors(new ColorConstant("006957"), 
			    new ColorConstant("34D0B6"), 
			    new ColorConstant("00A287"));
	}
}
