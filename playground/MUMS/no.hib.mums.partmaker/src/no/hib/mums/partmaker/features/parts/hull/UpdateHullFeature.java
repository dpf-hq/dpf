package no.hib.mums.partmaker.features.parts.hull;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;

import static no.hib.mums.partmaker.PartHelper.*;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.features.parts.UpdatePartFeature;

public class UpdateHullFeature extends UpdatePartFeature {

	public UpdateHullFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		Object o = getBusinessObjectForPictogramElement(context.getPictogramElement());
		if(o instanceof Node && DiagramTypeProvider.getHelperInstance().isHull((Node)o)) {
			return true;
		}
		return false;
	}
	
}
