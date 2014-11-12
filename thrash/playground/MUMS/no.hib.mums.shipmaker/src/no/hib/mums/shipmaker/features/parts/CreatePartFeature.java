package no.hib.mums.shipmaker.features.parts;

import no.hib.dpf.core.Node;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.ShipHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

//This class creates a create feature for each of the defined parts in partmaker (one feature for each)
public class CreatePartFeature extends AbstractCreateFeature {

	ShipHelper sh = DiagramTypeProvider.getHelperInstance();
	
	public CreatePartFeature(IFeatureProvider fp, String name,
			String description) {
		super(fp, name, description);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = sh.getPartMap().get(this.getName());
		
		System.out.println("ShipMaker#createFeature: "+ n.getName());
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
