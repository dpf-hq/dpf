package protoedit.editparts.tree;

import muvitorkit.gef.editparts.AdapterTreeEditPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;

import protomodel.ProtomodelPackage;
import protomodel.Reference;

public class ReferenceTreeEditPart extends AdapterTreeEditPart<Reference> {

	public ReferenceTreeEditPart(Reference model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		System.out.println("castedModel: " + getCastedModel());
		String name = "ref: " + getCastedModel().getName() + " -> ";
		if(getCastedModel().getDest() != null) {
			name += getCastedModel().getDest().getName();
		} else {
			name += "(null)";
		}
		
		return name;
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ReferenceComponentEditPolicy());
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		final int featureId = notification.getFeatureID(ProtomodelPackage.class);
		switch (featureId) {
		case ProtomodelPackage.REFERENCE__SOURCE:
		case ProtomodelPackage.REFERENCE__DEST:
		case ProtomodelPackage.REFERENCE__NAME:
			refresh();
			break;

		}
	}
	/*
	@Override
	protected List getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.add(getCastedModel().getDest());
		return list;
	}
	 */
}
