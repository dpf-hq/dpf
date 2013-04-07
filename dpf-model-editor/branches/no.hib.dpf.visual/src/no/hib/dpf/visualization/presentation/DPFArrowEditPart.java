package no.hib.dpf.visualization.presentation;

import no.hib.dpf.editor.parts.GraphicalConnectionEditPart;
import no.hib.dpf.visual.VArrow;

public class DPFArrowEditPart extends GraphicalConnectionEditPart  {

	VArrow visual = null;
	public DPFArrowEditPart(VArrow vArrow) {
		visual = vArrow;
	}

	@Override
	protected void createEditPolicies() {
		
	}
	
}
