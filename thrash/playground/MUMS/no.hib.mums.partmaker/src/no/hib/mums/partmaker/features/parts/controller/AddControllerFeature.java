package no.hib.mums.partmaker.features.parts.controller;

import no.hib.mums.partmaker.features.parts.AddPartFeature;

import org.eclipse.graphiti.features.IFeatureProvider;

public class AddControllerFeature extends AddPartFeature {

	public AddControllerFeature(IFeatureProvider fp) {
		super(fp);
		super.height = 50;
	}
}
