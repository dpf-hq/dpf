package protoedit.editparts.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import muvitorkit.gef.directedit.IDirectEditPart;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ICellEditorValidator;

public class GenericTreeEditPart extends AdapterTreeEditPart<EObject> implements IDirectEditPart {
	private EObject model;
	public GenericTreeEditPart(EObject eModel) {
		super(eModel);
		model = eModel;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		EStructuralFeature nameFeature = model.eClass().getEStructuralFeature("name");
		return (String) model.eClass().getName() + ": " + model.eGet(nameFeature);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getModelChildren() {
		List<EObject> children = new ArrayList<EObject>();
		List<EReference> containments = getCastedModel().eClass().getEAllContainments();

		
		for(EReference ref : containments) {
			System.out.println("> ref (" + ref.getName() + "): " + ref);

			EList<EObject> chld = (EList<EObject>) getCastedModel().eGet(ref);
			for(EObject c : chld) {
				System.out.println("-> " + c);
			}

			System.out.println("children-tmp: " + children);
		
			children.addAll(chld);
		}

		System.out.println("children: " + children);
		
		return children;
	}
	
	@Override
	protected void notifyChanged(Notification notification) {
		// TODO Auto-generated method stub
		super.notifyChanged(notification);
		refreshChildren();
		refresh();
	}

	@Override
	public int getDirectEditFeatureID() {
		EStructuralFeature feature = getCastedModel().eClass().getEStructuralFeature("name");
		return feature.getFeatureID();
	}

	@Override
	public ICellEditorValidator getDirectEditValidator() {
		// TODO Auto-generated method stub
		return null;
	}


}
