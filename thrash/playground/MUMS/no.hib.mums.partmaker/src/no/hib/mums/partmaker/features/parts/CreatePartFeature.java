package no.hib.mums.partmaker.features.parts;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public abstract class CreatePartFeature extends AbstractCreateFeature {
	
	public CreatePartFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public abstract Object[] create(ICreateContext context); 
//	{
//		Node n = DPFHelper.getNodeByName(getName());
//		
//		addGraphicalRepresentation(context, n);
//		
//		return new Object[] {n};
//	}

}