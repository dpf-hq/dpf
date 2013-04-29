package no.hib.dpf.visualization.presentation;

import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.policies.DGraphXYLayoutEditPolicy;
import no.hib.dpf.visual.VNode;

import org.eclipse.gef.EditPolicy;

public class DPFNodeEditPart extends DNodeEditPart {

	VNode visual = null;
	public DPFNodeEditPart(VNode vElement) {
		visual = vElement;
	}

	@Override
	protected void createEditPolicies() {
		if(visual.isComposite())
			installEditPolicy(EditPolicy.LAYOUT_ROLE, new DGraphXYLayoutEditPolicy());
	}
	
}
