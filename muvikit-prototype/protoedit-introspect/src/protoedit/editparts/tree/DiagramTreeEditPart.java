package protoedit.editparts.tree;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import protomodel.Clazz;
import protomodel.Diagram;
import protomodel.ProtomodelFactory;
import protomodel.ProtomodelPackage;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

public class DiagramTreeEditPart extends AdapterTreeEditPart<Diagram> {

	public DiagramTreeEditPart(Diagram model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		return "Diagram: " + getCastedModel().getName();
	}
	
	@Override
	protected List getModelChildren() {
		EList<Clazz> children = getCastedModel().getClasses();
		return children;
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		int featureId = notification.getFeatureID(ProtomodelPackage.class);
		switch (featureId) {
		case ProtomodelPackage.REFERENCE:
			refresh();
			break;
		case ProtomodelPackage.DIAGRAM__CLASSES:
			refreshChildren();
			break;

		default:
			break;
		}
	}

}
