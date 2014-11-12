package no.hib.mums.partmaker.features.parts.thrustercontrol;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;

import no.hib.mums.partmaker.features.parts.PartFeatureContainer;

public class ThrusterControlFeatureContainer extends PartFeatureContainer {
	@Override
	public ICreateFeature getCreateFeature(IFeatureProvider fp) {
		return new CreateThrusterControlFeature(fp);
	}
	
	@Override
	public IAddFeature getAddFeature(IFeatureProvider fp) {
		return new AddThrusterControlFeature(fp);
	}
}
