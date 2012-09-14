package no.hib.mums.partmaker.features.parts.hull;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.util.ColorConstant;

import no.hib.mums.partmaker.features.parts.AddPartFeature;

public class AddHullFeature extends AddPartFeature {

	public AddHullFeature(IFeatureProvider fp) {
		super(fp);
		this.setColors(new ColorConstant("6C8DD5"), 
			    new ColorConstant("1142AA"), 
			    new ColorConstant("06276F"));
		super.height = 160;
	}

	
}
