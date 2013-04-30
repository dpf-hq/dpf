package no.hib.dpf.visualization.presentation;

import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.visual.VNode;

public class DPFNodeEditPart extends DNodeEditPart {

	VNode visual = null;
	public DPFNodeEditPart(VNode vElement) {
		visual = vElement;
	}
	
}
