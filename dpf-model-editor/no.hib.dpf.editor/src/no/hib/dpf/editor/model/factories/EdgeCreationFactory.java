package no.hib.dpf.editor.model.factories;

import no.hib.dpf.metamodel.Edge;

import org.eclipse.gef.requests.CreationFactory;

public class EdgeCreationFactory implements CreationFactory {

	Edge typeEdge;
	
	public EdgeCreationFactory(Object newObject, Edge typeEdge) {
		this.typeEdge = typeEdge;
	}
	
	@Override
	public Object getNewObject() {
		return null;
	}

	@Override
	public Object getObjectType() {
		return typeEdge;
	}

}
