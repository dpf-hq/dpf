package no.hib.dpf.editor.model.factories;

import no.hib.dpf.editor.model.DNode;
import no.hib.dpf.metamodel.Node;

import org.eclipse.gef.requests.CreationFactory;

public class VNodeFactory implements CreationFactory {
	
	private Node typeNode;

	public VNodeFactory(Node typeNode) {
		this.typeNode = typeNode;
	}
	
	@Override
	public Object getNewObject() {
		DNode retval = new DNode(typeNode);
		return retval;
	}

	@Override
	public Object getObjectType() {
		return DNode.class;
	}

}
