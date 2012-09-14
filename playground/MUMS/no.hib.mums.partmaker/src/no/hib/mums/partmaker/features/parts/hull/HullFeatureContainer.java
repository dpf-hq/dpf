package no.hib.mums.partmaker.features.parts.hull;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import no.hib.mums.partmaker.features.parts.PartFeatureContainer;
import no.hib.mums.shared.FeatureContainer;

public class HullFeatureContainer extends PartFeatureContainer {
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddHullFeature(fp);
	}
	
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateHullFeature(fp);
	}
	
	
}
