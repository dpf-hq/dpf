package no.hib.dpf.editor.viewmodel.factories;

import no.hib.dpf.editor.viewmodel.VNode;
import no.hib.dpf.metamodel.Node;

import org.eclipse.gef.requests.CreationFactory;

public class VNodeFactory implements CreationFactory {
	
	private Node typeNode;

	public VNodeFactory(Node typeNode) {
		this.typeNode = typeNode;
	}
	
	@Override
	public Object getNewObject() {
		VNode retval = new VNode(typeNode);
		return retval;
	}

	@Override
	public Object getObjectType() {
		return VNode.class;
	}

}
