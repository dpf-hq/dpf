package no.hib.mums.partmaker.features.parts.actuator;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import no.hib.mums.partmaker.features.parts.PartFeatureContainer;

public class ActuatorFeatureContainer extends PartFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateActuatorFeature(fp);
	}
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddActuatorFeature(fp);
	}
}
