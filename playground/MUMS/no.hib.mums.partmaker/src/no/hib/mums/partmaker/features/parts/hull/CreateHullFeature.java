package no.hib.mums.partmaker.features.parts.hull;

import static no.hib.mums.shared.MumsConstants.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.services.Graphiti;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.PartHelper;
import no.hib.mums.partmaker.features.parts.CreatePartFeature;

public class CreateHullFeature extends CreatePartFeature {

	public CreateHullFeature(IFeatureProvider fp) {
		super(fp, HULL, "Create new hull");
	}

	@Override
	public Object[] create(ICreateContext context) {
		Node n = DiagramTypeProvider.getHelperInstance().createPartNode(HULL);
		
		System.out.println("Create hull " + n);
		
		addGraphicalRepresentation(context, n);
		
		return new Object[] {n};
	}

}
