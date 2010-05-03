package protoedit.editparts.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;

import protomodel.Reference;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

public class ReferenceTreeEditPart extends AdapterTreeEditPart<Reference> {

	public ReferenceTreeEditPart(Reference model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		return getCastedModel().getName() + " -> " + getCastedModel().getDest().getName();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ReferenceComponentEditPolicy());
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
