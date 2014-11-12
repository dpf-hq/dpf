package no.hib.mums.shipmaker.propertytab;

import no.hib.dpf.core.Node;
import no.hib.mums.shared.MumsConstants;
import no.hib.mums.shipmaker.DiagramTypeProvider;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class ShipPropertyFilter extends AbstractPropertySectionFilter {

	@Override
	protected boolean accept(PictogramElement pictogramElement) {
		Object n = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		if(n instanceof Node 
				&& DiagramTypeProvider.getHelperInstance().descendantOf((Node)n, MumsConstants.PART)) {
			return true;
		}
		return false;
	}
	
}
