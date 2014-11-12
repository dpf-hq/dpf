package no.hib.mums.partmaker.features.parts.controller;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import no.hib.mums.partmaker.features.parts.PartFeatureContainer;

public class ControllerFeatureContainer extends PartFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateControllerFeature(fp);
	}
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddControllerFeature(fp);
	}
}
