package protoedit.editparts.tree;

import java.util.ArrayList;
import java.util.List;

import muvitorkit.gef.directedit.IDirectEditPart;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ICellEditorValidator;

import protomodel.Clazz;
import protomodel.ProtomodelPackage;

public class ClazzTreeEditPart extends AdapterTreeEditPart<Clazz> implements IDirectEditPart {

	public ClazzTreeEditPart(Clazz model) {
		super(model);
	}
	
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}
	
	@Override
	protected List<EObject> getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.addAll(getCastedModel().getReferences());
		return list;
	}

	@Override
	public int getDirectEditFeatureID() {
		return ProtomodelPackage.CLAZZ__NAME;
	}

	@Override
	public ICellEditorValidator getDirectEditValidator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		final int featureId = notification.getFeatureID(ProtomodelPackage.class);
		switch(featureId) {
		case ProtomodelPackage.CLAZZ__REFERENCES:
			refreshChildren();
			break;
		case ProtomodelPackage.CLAZZ__NAME:
			refresh();
			break;
		default:
			break;
			
		}
	}
	

}
