package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;

public class SingleNodeConnection extends DArrowImpl {

	public SingleNodeConnection(DNode source, DArrow typeArrow, Arrow arrow) {
		super();
		this.setDSource(source);
		setDTarget(source);
		setArrow(arrow);
		setDType(typeArrow);
	}
}
