package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public class IrreflexiveValidator extends SemanticValidatorImpl {
	
	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		for (Arrow arrow : stuckedArrows) 
			if (arrow.getSource().equals(arrow.getTarget())) 
				return false;
		return true;
	}

}
