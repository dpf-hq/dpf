package protoedit.editparts.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import muvitorkit.gef.editparts.AdapterTreeEditPart;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class GenericTreeEditPart extends AdapterTreeEditPart<EObject> {
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
	public List getChildren() {
		List<EObject> children = new ArrayList<EObject>();
		EList<EReference> containments = getCastedModel().eClass().getEAllContainments();
		
		for(EReference ref : containments) {
			System.out.println("ref (" + ref.getName() + "): " + ref);
			EStructuralFeature feature = getCastedModel().eClass().getEStructuralFeature(ref.getName());
			System.out.println(feature);
			
			System.out.println("content: " + getCastedModel().eGet(feature));
			EList<EObject> chld = (EList<EObject>) getCastedModel().eGet(feature);
			children.addAll(chld);
			//children.addAll(ref.eContents());
		}
		System.out.println("children: " + children);
		System.out.println("---");
		return children;
	}


}
