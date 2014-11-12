package no.hib.mums.partmaker.features.parts.controller;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.features.parts.CreatePartFeature;

public class CreateControllerFeature extends CreatePartFeature {

	public CreateControllerFeature(IFeatureProvider fp) {
		super(fp, CONTROLLER, "Create new controller");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(CONTROLLER);
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
