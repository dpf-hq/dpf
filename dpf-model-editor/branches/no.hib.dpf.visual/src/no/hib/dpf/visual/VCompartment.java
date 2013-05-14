package no.hib.dpf.visual;

import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;

import org.eclipse.emf.common.util.EList;

public interface VCompartment extends VElement {
	
	Node getParent();
	
	void setParent(Node parent);
	
	EList<DNode> getChildren();
	
	void addChild(DNode child);
}
