package no.hib.mums.partmaker.propertytab;
import no.hib.dpf.core.Node;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;


public class PartPropertyFilter extends AbstractPropertySectionFilter {

	@Override
	protected boolean accept(PictogramElement pictogramElement) {
		Object n = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pictogramElement);
		if(n instanceof Node) {
			return true;
		}
		return false;
	}

}
