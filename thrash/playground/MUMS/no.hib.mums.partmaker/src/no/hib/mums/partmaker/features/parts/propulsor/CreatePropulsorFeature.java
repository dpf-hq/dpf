package no.hib.mums.partmaker.features.parts.propulsor;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.features.parts.CreatePartFeature;

public class CreatePropulsorFeature extends CreatePartFeature {

	public CreatePropulsorFeature(IFeatureProvider fp) {
		super(fp, PROPULSOR, "Create new propulsor");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(PROPULSOR);
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
