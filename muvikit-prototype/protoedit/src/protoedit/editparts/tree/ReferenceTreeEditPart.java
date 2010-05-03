package protoedit.editparts.tree;

import muvitorkit.gef.editparts.AdapterTreeEditPart;

import org.eclipse.gef.EditPolicy;

import protomodel.Reference;

public class ReferenceTreeEditPart extends AdapterTreeEditPart<Reference> {

	public ReferenceTreeEditPart(Reference model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		System.out.println("castedModel: " + getCastedModel());
		String name = getCastedModel().getName() + " -> ";
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
	/*
	@Override
	protected List getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.add(getCastedModel().getDest());
		return list;
	}
	 */
}
