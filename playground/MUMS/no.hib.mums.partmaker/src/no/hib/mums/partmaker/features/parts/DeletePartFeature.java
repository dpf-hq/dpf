package no.hib.mums.partmaker.features.parts;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeletePartFeature extends DefaultDeleteFeature {

	public DeletePartFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	//We override this method to avoid the actual model object beeing deleted.
	@Override
	protected void deleteBusinessObject(Object bo) {
		//FIXME: Removing this will allow the editor to delete the EObject which is linked with the pictogramelement
	}
}
