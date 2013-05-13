package no.hib.dpf.visual;

import no.hib.dpf.diagram.DNode;

import org.eclipse.emf.common.util.EList;

public interface VCompartment extends VElement {
	
	EList<DNode> getChildren();
	
	void addChild(DNode child);
}
