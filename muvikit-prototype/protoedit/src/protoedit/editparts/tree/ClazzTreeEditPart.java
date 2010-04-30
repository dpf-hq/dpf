package protoedit.editparts.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import protomodel.Clazz;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

public class ClazzTreeEditPart extends AdapterTreeEditPart<Clazz> {

	public ClazzTreeEditPart(Clazz model) {
		super(model);
	}
	
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}
	
	@Override
	protected List getModelChildren() {
		List<EObject> list = new ArrayList<EObject>();
		list.addAll(getCastedModel().getReferences());
		return list;
	}
	

}
