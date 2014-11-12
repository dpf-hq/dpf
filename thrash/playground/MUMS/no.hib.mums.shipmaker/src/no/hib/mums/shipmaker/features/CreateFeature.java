package no.hib.mums.shipmaker.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import no.hib.dpf.core.Node;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import static no.hib.mums.shared.MumsConstants.*;

public class CreateFeature extends AbstractCreateFeature {

	public CreateFeature(IFeatureProvider fp) {
		super(fp, HULL, "Create new hull");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(HULL);
		
		System.out.println("Create hull " + n);
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
