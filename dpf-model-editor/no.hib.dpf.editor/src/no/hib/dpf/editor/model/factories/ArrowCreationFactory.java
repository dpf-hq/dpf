package no.hib.dpf.editor.model.factories;

import no.hib.dpf.metamodel.Arrow;

import org.eclipse.gef.requests.CreationFactory;

public class ArrowCreationFactory implements CreationFactory {

	Arrow typeEdge;
	
	public ArrowCreationFactory(Object newObject, Arrow typeArrow) {
		this.typeEdge = typeArrow;
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
