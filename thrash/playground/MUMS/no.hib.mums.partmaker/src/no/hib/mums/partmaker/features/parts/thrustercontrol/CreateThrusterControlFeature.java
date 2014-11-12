package no.hib.mums.partmaker.features.parts.thrustercontrol;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.features.parts.CreatePartFeature;

public class CreateThrusterControlFeature extends CreatePartFeature {

	public CreateThrusterControlFeature(IFeatureProvider fp) {
		super(fp, THRUSTER_CONTROL, "Create new thruster control");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(THRUSTER_CONTROL);
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
