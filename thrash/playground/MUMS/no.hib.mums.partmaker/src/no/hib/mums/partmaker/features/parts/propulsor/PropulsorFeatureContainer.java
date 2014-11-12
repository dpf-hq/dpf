package no.hib.mums.partmaker.features.parts.propulsor;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import no.hib.mums.partmaker.features.parts.PartFeatureContainer;

public class PropulsorFeatureContainer extends PartFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreatePropulsorFeature(fp);
	}
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddPropulsorFeature(fp);
	}
}
