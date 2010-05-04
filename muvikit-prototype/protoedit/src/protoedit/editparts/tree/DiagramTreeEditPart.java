package protoedit.editparts.tree;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import protomodel.Clazz;
import protomodel.Diagram;
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

}
