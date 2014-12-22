package no.hib.dpf.visualization.part;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;

//import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visualization.VCompartment;
 
public class VArrowEditPart extends DArrowEditPart  {

	VArrow visual = null;
	public VArrowEditPart(VArrow vArrow) {
		visual = vArrow;
	}
	
	@Override
	protected List<EObject> getModelChildren() {
		EList<EObject> child = new BasicEList<EObject>();
		child.addAll(super.getModelChildren());
		return child;
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDArrow().getConstraintsFrom());
		return sources;
	}
}
