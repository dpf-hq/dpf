package no.hib.mums.partmaker.features.parts.actuator;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.features.parts.CreatePartFeature;

public class CreateActuatorFeature extends CreatePartFeature {

	public CreateActuatorFeature(IFeatureProvider fp) {
		super(fp, ACTUATOR, "Create new actuator");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(ACTUATOR);
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
