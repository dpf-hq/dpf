package no.hib.dpf.visual;

import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

public interface VCompositeElement extends VElement {
	
	EList<Node> getChildren();
	
	Node getParent();
	
	Node getChildrenType();
	
	void setParent(Node node);
	
	void setChildrenType(Node node);
	
	void addChild(Node child);
}
